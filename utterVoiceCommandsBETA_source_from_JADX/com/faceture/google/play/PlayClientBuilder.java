package com.faceture.google.play;

import com.faceture.google.GoogleUtil;
import com.faceture.google.gson.GsonWrapper;
import com.faceture.google.play.domain.PlayDomainFactory;
import com.faceture.http.HttpClientFactory;
import com.faceture.http.HttpUtil;
import com.faceture.rest.RestClient;
import com.faceture.rest.RestClientUtil;
import com.faceture.rest.RestResponseFactory;
import com.google.gson.Gson;

public class PlayClientBuilder {
    public PlayClient create() {
        HttpClientFactory httpClientFactory = new HttpClientFactory();
        HttpUtil httpUtil = new HttpUtil(httpClientFactory);
        return new PlayClient(new RestClient(httpClientFactory, httpUtil, new RestClientUtil(httpClientFactory, httpUtil, new RestResponseFactory())), new PlaySessionFactory(), new GoogleUtil(), new GsonWrapper(new Gson()), new PlayDomainFactory(), new LoginResponseFactory());
    }
}
