package com.faceture.google.play;

import com.faceture.google.GoogleUtil;
import com.faceture.google.gson.GsonWrapper;
import com.faceture.google.play.domain.PlayDomainFactory;
import com.faceture.google.play.domain.SearchResponse;
import com.faceture.google.play.domain.SearchResults;
import com.faceture.google.play.domain.StreamingUrl;
import com.faceture.rest.RestClient;
import com.faceture.rest.RestResponse;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class PlayClient {
    private GoogleUtil googleUtil;
    private GsonWrapper gsonWrapper;
    private LoginResponseFactory loginResponseFactory;
    private PlayDomainFactory playDomainFactory;
    private PlaySessionFactory playSessionFactory;
    private RestClient restClient;

    public PlayClient(RestClient restClient, PlaySessionFactory playSessionFactory, GoogleUtil googleUtil, GsonWrapper gsonWrapper, PlayDomainFactory playDomainFactory, LoginResponseFactory loginResponseFactory) {
        if (restClient == null) {
            throw new IllegalArgumentException("restClient is null");
        } else if (playSessionFactory == null) {
            throw new IllegalArgumentException("playSessionFactory is null");
        } else if (googleUtil == null) {
            throw new IllegalArgumentException("googleUtil is null");
        } else if (gsonWrapper == null) {
            throw new IllegalArgumentException("gsonWrapper is null");
        } else if (playDomainFactory == null) {
            throw new IllegalArgumentException("playDomainFactory is null");
        } else if (loginResponseFactory == null) {
            throw new IllegalArgumentException("loginResponseFactory is null");
        } else {
            this.restClient = restClient;
            this.playSessionFactory = playSessionFactory;
            this.googleUtil = googleUtil;
            this.gsonWrapper = gsonWrapper;
            this.playDomainFactory = playDomainFactory;
            this.loginResponseFactory = loginResponseFactory;
        }
    }

    public URI getPlayURI(String str, PlaySession playSession) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("query is null or empty");
        } else if (playSession == null) {
            throw new IllegalArgumentException("playSession is null");
        } else {
            Map hashMap = new HashMap();
            hashMap.put(QueryParamConst.U_NAME, QueryParamConst.U_VALUE);
            hashMap.put(QueryParamConst.PT_NAME, QueryParamConst.PT_VALUE);
            hashMap.put(QueryParamConst.SONG_ID_NAME, str);
            String createAuthHeaderValue = this.googleUtil.createAuthHeaderValue(playSession.getAuthToken());
            Map hashMap2 = new HashMap();
            hashMap2.put(HeaderName.AUTHORIZATION, createAuthHeaderValue);
            Map hashMap3 = new HashMap();
            hashMap3.put(CookieName.SJSAID, playSession.getSjsaidCookie());
            hashMap3.put("xt", playSession.getXtCookie());
            RestResponse doGet = this.restClient.doGet(true, HostName.PLAY, Path.MUSIC_PLAY, hashMap, hashMap2, hashMap3);
            if (doGet.getStatusCode() != 200) {
                throw new IllegalStateException("Bad status: " + doGet.getStatusCode() + " response body: " + doGet.getBody());
            }
            return new URI(((StreamingUrl) this.gsonWrapper.fromJson(doGet.getBody(), StreamingUrl.class)).getUrl());
        }
    }

    public LoginResponse login(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("emailAddress is null or empty");
        } else if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("password is null or empty");
        } else {
            Map hashMap = new HashMap();
            hashMap.put(FormFieldConst.SERVICE_NAME, FormFieldConst.SERVICE_VALUE);
            hashMap.put(FormFieldConst.EMAIL_NAME, str);
            hashMap.put(FormFieldConst.PASSWORD_NAME, str2);
            RestResponse doPost = this.restClient.doPost(true, HostName.GOOGLE, Path.GOOGLE_LOGIN, null, null, null, hashMap);
            int statusCode = doPost.getStatusCode();
            if (statusCode != 200) {
                return 403 == statusCode ? this.loginResponseFactory.create(LoginResult.BAD_CREDENTIALS, null) : this.loginResponseFactory.create(LoginResult.FAILURE, null);
            } else {
                String authTokenFromLoginResponse = this.googleUtil.getAuthTokenFromLoginResponse(doPost.getBody());
                Map hashMap2 = new HashMap();
                hashMap2.put(QueryParamConst.HL_NAME, QueryParamConst.HL_VALUE);
                hashMap2.put(QueryParamConst.U_NAME, QueryParamConst.U_VALUE);
                String createAuthHeaderValue = this.googleUtil.createAuthHeaderValue(authTokenFromLoginResponse);
                Map hashMap3 = new HashMap();
                hashMap3.put(HeaderName.AUTHORIZATION, createAuthHeaderValue);
                doPost = this.restClient.doPost(true, HostName.PLAY, Path.MUSIC_LOGIN, hashMap2, hashMap3, null, null);
                switch (doPost.getStatusCode()) {
                    case 200:
                        Map cookies = doPost.getCookies();
                        return this.loginResponseFactory.create(LoginResult.SUCCESS, this.playSessionFactory.create((String) cookies.get("xt"), (String) cookies.get(CookieName.SJSAID), authTokenFromLoginResponse));
                    case 403:
                        return this.loginResponseFactory.create(LoginResult.BAD_CREDENTIALS, null);
                    default:
                        return this.loginResponseFactory.create(LoginResult.FAILURE, null);
                }
            }
        }
    }

    public SearchResults search(String str, PlaySession playSession) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("query is null or empty");
        } else if (playSession == null) {
            throw new IllegalArgumentException("session is null");
        } else {
            Map hashMap = new HashMap();
            hashMap.put(QueryParamConst.U_NAME, QueryParamConst.U_VALUE);
            hashMap.put("xt", playSession.getXtCookie());
            Map hashMap2 = new HashMap();
            hashMap2.put(HeaderName.AUTHORIZATION, this.googleUtil.createAuthHeaderValue(playSession.getAuthToken()));
            String toJson = this.gsonWrapper.toJson(this.playDomainFactory.createSearchRequest(str));
            Map hashMap3 = new HashMap();
            hashMap3.put(FormFieldConst.JSON_NAME, toJson);
            RestResponse doPost = this.restClient.doPost(true, HostName.PLAY, Path.MUSIC_SEARCH, hashMap, hashMap2, null, hashMap3);
            if (doPost.getStatusCode() != 200) {
                throw new IllegalStateException("Bad status: " + doPost.getStatusCode() + " response body: " + doPost.getBody());
            }
            return ((SearchResponse) this.gsonWrapper.fromJson(doPost.getBody(), SearchResponse.class)).getResults();
        }
    }
}
