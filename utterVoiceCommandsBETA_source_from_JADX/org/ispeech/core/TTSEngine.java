package org.ispeech.core;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.ispeech.tools.HttpUtils;
import org.ispeech.tools.SerializableHashTable;
import org.ispeech.tools.Utilities;

public class TTSEngine {
    protected static final String TAG = "iSpeech SDK";
    private static volatile TTSEngine _instance;
    private static MediaPlayer mediaPlayer;
    private String apikey;
    private String audioFile = "ispeechtts.mp3";
    private boolean changeVolume = false;
    private boolean earlyStop = false;
    private ResponseHandler handler;
    private boolean isRunning;
    private SerializableHashTable meta = new SerializableHashTable();
    private Map<String, String> optional = new HashMap();
    private int originalVolume;
    private int socketTimeout = 60000;
    public boolean startedSpeaking = false;
    private int streamType = InternalResources.STREAM_TYPE;
    private String url;
    private String voiceType;

    public interface ResponseHandler {
        void onResponse(HttpResponse httpResponse);
    }

    private TTSEngine(String str, String str2) {
        this.apikey = str2;
        this.url = str;
    }

    public static TTSEngine getInstance(String str, String str2) {
        if (_instance == null) {
            _instance = new TTSEngine(str, str2);
        }
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
        return _instance;
    }

    public void addMeta(String str, String str2) {
        this.meta.put(str, str2);
    }

    public void addOptionalCommand(String str, String str2) {
        this.optional.put(str, str2);
    }

    public void cancelTTS() {
        mediaPlayer.stop();
    }

    public void clearOptionalCommand() {
        this.optional.clear();
    }

    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    public int getPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public boolean isSpeaking() {
        boolean z = false;
        synchronized (_instance) {
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying() || this.startedSpeaking) {
                    z = true;
                }
            }
        }
        return z;
    }

    public void release() {
        synchronized (_instance) {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.release();
                mediaPlayer = new MediaPlayer();
            }
            this.isRunning = false;
        }
    }

    public void setAudioStreamType(int i) {
        this.streamType = i;
    }

    public void setEarlyStop() {
        this.earlyStop = true;
    }

    public void setMeta(SerializableHashTable serializableHashTable) {
        this.meta = serializableHashTable;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        mediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        mediaPlayer.setOnErrorListener(onErrorListener);
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        mediaPlayer.setOnPreparedListener(onPreparedListener);
    }

    public void setResponseHandler(ResponseHandler responseHandler) {
        this.handler = responseHandler;
    }

    public void setSocketTimeout(int i) {
        this.socketTimeout = i;
    }

    public void setVoice(String str) {
        this.voiceType = str;
    }

    public void speak(Context context, String str) {
        this.isRunning = true;
        final AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int streamVolume = audioManager.getStreamVolume(InternalResources.STREAM_TYPE);
        if (InternalResources.ALWAYS_SPEAK && streamVolume <= 0) {
            this.changeVolume = true;
            audioManager.setRingerMode(2);
            this.originalVolume = audioManager.getStreamVolume(InternalResources.STREAM_TYPE);
            audioManager.setStreamVolume(InternalResources.STREAM_TYPE, audioManager.getStreamMaxVolume(InternalResources.STREAM_TYPE) / 2, 1);
        }
        try {
            List copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.APIKEY, this.apikey));
            copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.TEXT, str));
            copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.DEVICE, HttpRequestParams.DEVICE_ANDROID));
            copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.ACTION, HttpRequestParams.ACTION_CONVERT));
            if (this.voiceType != null) {
                copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.VOICE, this.voiceType));
            }
            if (this.meta != null) {
                copyOnWriteArrayList.add(new BasicNameValuePair(HttpRequestParams.META, new String(Utilities.encodeBase64(this.meta.serialize()))));
            }
            if (this.optional != null && this.optional.size() > 0) {
                for (String str2 : this.optional.keySet()) {
                    copyOnWriteArrayList.add(new BasicNameValuePair(str2, (String) this.optional.get(str2)));
                }
            }
            String str22 = HttpUtils.addParamsToUrl(this.url, copyOnWriteArrayList);
            Log.d(TAG, "TTS request url: " + str22);
            HttpClient defaultHttpClient = new DefaultHttpClient();
            defaultHttpClient.getParams().setParameter(HttpRequestParams.SOCKET_TIMEOUT, new Integer(this.socketTimeout));
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str22));
            if (this.handler != null) {
                this.handler.onResponse(execute);
            }
            if (execute.getEntity().getContentType().getValue().contains("audio")) {
                OutputStream openFileOutput = context.openFileOutput(this.audioFile, 0);
                execute.getEntity().writeTo(openFileOutput);
                openFileOutput.close();
                File file = new File(new StringBuilder(String.valueOf(context.getFilesDir().getAbsolutePath())).append("/").append(this.audioFile).toString());
                try {
                    synchronized (_instance) {
                        if (!mediaPlayer.isPlaying()) {
                            mediaPlayer.reset();
                            FileInputStream fileInputStream = new FileInputStream(file);
                            mediaPlayer.setDataSource(fileInputStream.getFD());
                            mediaPlayer.setAudioStreamType(this.streamType);
                            mediaPlayer.prepare();
                            fileInputStream.close();
                        }
                    }
                    Thread.sleep(100);
                    Log.d(TAG, "Speaking: " + str);
                    this.startedSpeaking = true;
                    mediaPlayer.start();
                    if (this.changeVolume) {
                        new Thread(new Runnable() {
                            public void run() {
                                while (TTSEngine.this.startedSpeaking) {
                                    try {
                                        Thread.sleep(1000);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                TTSEngine.this.earlyStop = false;
                                audioManager.setStreamVolume(InternalResources.STREAM_TYPE, TTSEngine.this.originalVolume, 1);
                                TTSEngine.this.changeVolume = false;
                            }
                        }).start();
                    }
                } catch (Throwable e) {
                    Log.e(TAG, e.getMessage(), e);
                } catch (Throwable e2) {
                    Log.e(TAG, e2.getMessage(), e2);
                } catch (Throwable e22) {
                    Log.e(TAG, e22.getMessage(), e22);
                }
            }
            this.isRunning = false;
        } catch (IOException e3) {
            throw e3;
        } catch (Throwable th) {
            this.isRunning = false;
        }
    }

    public void stop() {
        synchronized (_instance) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
        }
    }
}
