package org.ispeech.core;

import android.util.Log;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.ispeech.tools.HttpUtils;
import org.ispeech.tools.SerializableHashTable;
import org.ispeech.tools.Utilities;

public class ASREngine {
    private static final String TAG = ASREngine.class.getSimpleName();
    private static volatile ASREngine instance;
    private String apikey;
    private SerializableHashTable meta = new SerializableHashTable();
    private String url;
    private String voiceType;

    public enum AudioType {
        AMR("audio/amr"),
        MPEG("audio/mpeg");
        
        private final String contentType;

        private AudioType(String str) {
            this.contentType = str;
        }

        public final String getContentType() {
            return this.contentType;
        }
    }

    private ASREngine(String str, String str2) {
        this.apikey = str2;
        this.url = str;
    }

    public static ASREngine getInstance(String str, String str2) {
        if (instance == null) {
            instance = new ASREngine(str, str2);
        }
        return instance;
    }

    public void addMeta(String str, String str2) {
        this.meta.put(str, str2);
    }

    public String recognize(byte[] bArr, AudioType audioType) {
        List copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.APIKEY, this.apikey));
        copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.CONTENTTYPE, audioType.getContentType()));
        copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.DEVICE, HttpRequestParams.DEVICE_ANDROID));
        copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.ACTION, HttpRequestParams.ACTION_RECOGNIZE));
        if (this.voiceType != null) {
            copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.VOICE, this.voiceType));
        }
        if (this.meta != null) {
            copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.META, new String(Utilities.encodeBase64(this.meta.serialize()))));
        }
        String addParamsToUrl = HttpUtils.addParamsToUrl(this.url, copyOnWriteArrayList);
        Log.d(TAG, addParamsToUrl);
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost(addParamsToUrl);
        httpPost.setEntity(new ByteArrayEntity(bArr));
        return (String) HttpUtils.parseNameValuePairEntity(defaultHttpClient.execute(httpPost).getEntity()).get("result");
    }

    public void setVoice(String str) {
        this.voiceType = str;
    }
}
