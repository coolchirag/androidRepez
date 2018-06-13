package org.ispeech;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.ispeech.SpeechSynthesisEvent.EventType;
import org.ispeech.core.InternalResources;
import org.ispeech.core.TTSEngine;
import org.ispeech.core.TTSEngine.ResponseHandler;
import org.ispeech.error.ApiException;
import org.ispeech.error.BusyException;
import org.ispeech.error.InvalidApiKeyException;
import org.ispeech.tools.CommandResult;
import org.ispeech.tools.HttpUtils;
import org.ispeech.tools.Utilities;
import winterwell.jtwitter.TwitterStream;

public class SpeechSynthesis implements Synthesizer {
    private static final String TAG = "iSpeech SDK";
    private static SpeechSynthesis _synthesis = null;
    private Context _context;
    private String apiKey;
    private AudioManager audioManager;
    private ConvertResult convertResult = null;
    private Thread eventThread;
    private int mediaTime = -1;
    private OnCompletionListener onCompletion = new C05851();
    private OnErrorListener onError = new C05862();
    private boolean speechAttempted = false;
    private Vector<SpeechSynthesisEvent> speechEventListeners = new Vector();
    private StateChangedListener stateChangedListener = new C05883();
    private boolean stopTrigger = false;
    private int streamType = 3;
    private TTSEngine ttsEngine;
    private Thread ttsEngineWorkThread;
    private boolean wtfidontevenknow = false;

    class C05851 implements OnCompletionListener {
        C05851() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            SpeechSynthesis.this.audioManager.setStreamSolo(InternalResources.STREAM_TYPE, false);
            new HandlerThread("OnCompletion") {
                public void run() {
                    SpeechSynthesis.this.stateChangedListener.changeState(1);
                }
            }.start();
        }
    }

    class C05862 implements OnErrorListener {
        C05862() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            SpeechSynthesis.this.audioManager.setStreamSolo(InternalResources.STREAM_TYPE, false);
            SpeechSynthesis.this.createEventThread(EventType.PLAY_FAILURE, new Exception("MediaPlayer Error: (" + i + "," + i2 + ")"));
            return true;
        }
    }

    interface StateChangedListener {
        public static final int CANCELED = 5;
        public static final int CLOSED = 1;
        public static final int EXPIRED = 4;
        public static final int STARTED = 2;
        public static final int STOPPED = 3;

        void changeState(int i);
    }

    class C05883 implements StateChangedListener {
        C05883() {
        }

        public void changeState(int i) {
            if (i == 2) {
                SpeechSynthesis.this.createEventThread(EventType.PLAY_STARTED, null);
            }
            if (i == 4 || i == 3) {
                SpeechSynthesis.this.ttsEngine.startedSpeaking = false;
                SpeechSynthesis.this.showBanner();
            }
            if (i == 3) {
                SpeechSynthesis.this.ttsEngine.startedSpeaking = false;
                SpeechSynthesis.this.ttsEngine.release();
                SpeechSynthesis.this.playOnlyAd();
            }
            if (i == 1 || i == 3) {
                SpeechSynthesis.this.ttsEngine.startedSpeaking = false;
                final CommandResult commandResult = SpeechSynthesis.this.convertResult == null ? null : SpeechSynthesis.this.convertResult.result;
                if (i == 1) {
                    SpeechSynthesis.this.createEventThread(EventType.PLAY_SUCCESSFUL, null);
                } else {
                    SpeechSynthesis.this.createEventThread(EventType.PLAY_STOPPED, null);
                }
                new HandlerThread("Utilities.processCommand") {
                    public void run() {
                        try {
                            Utilities.processCommand(SpeechSynthesis.this._context, commandResult, SpeechSynthesis.this.apiKey, TwitterStream.MAX_USERS);
                        } catch (InvalidApiKeyException e) {
                        }
                    }
                }.start();
            }
        }
    }

    class C05905 implements ResponseHandler {
        C05905() {
        }

        public void onResponse(HttpResponse httpResponse) {
            int i = 0;
            BannerAd bannerAd = null;
            if (httpResponse.getStatusLine().getStatusCode() == 202) {
                try {
                    throw new ApiException((String) HttpUtils.parseNameValuePairEntity(httpResponse.getEntity()).get("message"));
                } catch (Exception e) {
                    SpeechSynthesis.this.createEventThread(EventType.PLAY_FAILURE, e);
                }
            } else if (httpResponse.getStatusLine().getStatusCode() == 200) {
                BannerAd bannerAd2;
                Map hashMap = new HashMap();
                for (Header header : httpResponse.getAllHeaders()) {
                    hashMap.put(header.getName().toLowerCase(), header.getValue());
                }
                Log.d(SpeechSynthesis.TAG, hashMap.toString());
                String str = hashMap.containsKey("x-data") ? (String) hashMap.get("x-data") : null;
                int intValue = Integer.valueOf((String) hashMap.get("x-time-length")).intValue();
                String str2 = hashMap.containsKey("x-ad") ? (String) hashMap.get("x-ad") : null;
                String str3 = hashMap.containsKey("x-mode") ? (String) hashMap.get("x-mode") : null;
                int parseInt = (str3 == null || str3.length() <= 0) ? 0 : Integer.parseInt(str3);
                if (str2 == null || str2.length() <= 0) {
                    bannerAd2 = null;
                } else {
                    if (hashMap.containsKey("x-banner")) {
                        bannerAd = BannerAd.parseData((String) hashMap.get("x-banner"));
                    }
                    i = Integer.parseInt((String) hashMap.get("x-content-time-length"));
                    bannerAd2 = bannerAd;
                }
                if (str != null) {
                    try {
                        SpeechSynthesis.this.convertResult = new ConvertResult(Utilities.cleanData(str), intValue, parseInt, str2, bannerAd2, i);
                        return;
                    } catch (Throwable e2) {
                        Log.e(SpeechSynthesis.TAG, e2.getMessage(), e2);
                        SpeechSynthesis.this.createEventThread(EventType.PLAY_FAILURE, e2);
                        return;
                    }
                }
                SpeechSynthesis.this.convertResult = new ConvertResult(null, intValue, parseInt, str2, bannerAd2, i);
            }
        }
    }

    class C05916 implements OnPreparedListener {
        C05916() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
            SpeechSynthesis.this.audioManager.setStreamSolo(InternalResources.STREAM_TYPE, true);
        }
    }

    class C05927 implements OnCompletionListener {
        C05927() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.release();
        }
    }

    class C05949 extends Thread {
        C05949() {
        }

        public void run() {
            SpeechSynthesis.this.ttsEngine.setOnCompletionListener(null);
            SpeechSynthesis.this.stateChangedListener.changeState(3);
            SpeechSynthesis.this.wtfidontevenknow = false;
        }
    }

    class BannerAd {
        public String clickURL;
        public int height;
        public String imageURL;
        public int width;

        private BannerAd(int i, int i2, String str, String str2) {
            this.width = i;
            this.height = i2;
            this.imageURL = str;
            this.clickURL = str2;
        }

        public static BannerAd parseData(String str) {
            int i = 0;
            try {
                String[] strArr = new String[4];
                int indexOf = str.indexOf("|");
                int i2 = 0;
                while (i < strArr.length) {
                    if (indexOf == -1) {
                        strArr[i] = str.substring(i2);
                    } else {
                        strArr[i] = str.substring(i2, indexOf);
                    }
                    i++;
                    i2 = indexOf + 1;
                    indexOf = str.indexOf("|", i2);
                }
                return new BannerAd(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), strArr[2], strArr[3]);
            } catch (Exception e) {
                return null;
            }
        }
    }

    class ConvertResult {
        public String adURL;
        public BannerAd banner;
        public int contentTimeLength;
        public int length;
        public int mode;
        public CommandResult result;

        public ConvertResult(CommandResult commandResult, int i, int i2, String str, BannerAd bannerAd, int i3) {
            this.result = commandResult;
            this.length = i;
            this.mode = i2;
            this.adURL = str;
            this.banner = bannerAd;
            this.contentTimeLength = i3;
        }
    }

    private SpeechSynthesis(Context context, String str) {
        if (str == null || str.length() != 32) {
            throw new InvalidApiKeyException();
        }
        this.apiKey = str;
        this._context = context;
        this.audioManager = (AudioManager) context.getSystemService("audio");
        this.ttsEngine = TTSEngine.getInstance(InternalResources.getAPIUrl(context), str);
        this.ttsEngine.setMeta(Utilities.getMetaInfo(context));
    }

    private Thread createEventThread(final EventType eventType, final Object obj) {
        this.eventThread = new Thread() {
            public void run() {
                if (SpeechSynthesis.this.speechEventListeners != null) {
                    Iterator it = SpeechSynthesis.this.speechEventListeners.iterator();
                    while (it.hasNext()) {
                        ((SpeechSynthesisEvent) it.next()).stateChanged(eventType, obj);
                    }
                }
            }
        };
        new Handler(this._context.getMainLooper()).post(this.eventThread);
        return this.eventThread;
    }

    public static SpeechSynthesis getInstance(Activity activity) {
        return getInstance(activity.getApplicationContext(), activity);
    }

    public static SpeechSynthesis getInstance(Context context, Activity activity) {
        if (_synthesis == null) {
            _synthesis = new SpeechSynthesis(context, Utilities.getApiKey(context));
            activity.setVolumeControlStream(InternalResources.STREAM_TYPE);
        } else {
            _synthesis._context = context;
        }
        return _synthesis;
    }

    private void playOnlyAd() {
        try {
            if (this.convertResult != null && this.convertResult.adURL != null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(this.convertResult.adURL);
                mediaPlayer.prepare();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new C05927());
            }
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    private void setupTTSEngine() {
        this.ttsEngine.setResponseHandler(new C05905());
        this.ttsEngine.setOnCompletionListener(this.onCompletion);
        this.ttsEngine.setOnErrorListener(this.onError);
        this.ttsEngine.setAudioStreamType(InternalResources.STREAM_TYPE);
        this.ttsEngine.setOnPreparedListener(new C05916());
    }

    private void showBanner() {
        if (this.convertResult.banner != null && this.convertResult.mode != 2) {
            Intent intent = new Intent(this._context, iSpeechFramework.class);
            intent.putExtra(InternalResources.ISPEECH_SCREEN_TYPE, 1);
            intent.putExtra(InternalResources.ISPEECH_SCREEN_ADIURL, this.convertResult.banner.imageURL);
            intent.putExtra(InternalResources.ISPEECH_SCREEN_ADCURL, this.convertResult.banner.clickURL);
            intent.putExtra(InternalResources.ISPEECH_SCREEN_AD_HEIGHT, this.convertResult.banner.height);
            intent.putExtra(InternalResources.ISPEECH_SCREEN_AD_WIDTH, this.convertResult.banner.width);
            intent.setFlags(268435456);
            this._context.startActivity(intent);
        }
    }

    private void showProcessingDialog() {
        Intent intent = new Intent(this._context, iSpeechFramework.class);
        intent.putExtra(InternalResources.ISPEECH_SCREEN_TYPE, 3);
        intent.putExtra(InternalResources.ISPEECH_SCREEN_APIKEY, this.apiKey);
        intent.setFlags(268435456);
        this._context.startActivity(intent);
    }

    public void addMeta(MetaType metaType, String str) {
        this.ttsEngine.addMeta(metaType.getValue(), str);
    }

    public void addOptionalCommand(String str, String str2) {
        this.ttsEngine.addOptionalCommand(str, str2);
    }

    public void cancel() {
        stop();
        Log.d(TAG, new StringBuilder(String.valueOf(SpeechSynthesis.class.getSimpleName())).append("->speech synthesis canceled").toString());
        createEventThread(EventType.PLAY_CANCELED, null);
        if (this.ttsEngine.isSpeaking()) {
            Log.d(TAG, "TTSEngine is speaking already");
            this.ttsEngine.cancelTTS();
            return;
        }
        Log.d(TAG, "TTSEngine is not speaking yet, trying to interrupt ttsEngineWorkThread");
        if (this.ttsEngineWorkThread != null) {
            this.ttsEngineWorkThread.interrupt();
        }
    }

    public void clearOptionalCommand() {
        this.ttsEngine.clearOptionalCommand();
    }

    public int getCurrentPosition() {
        return this.ttsEngine.getCurrentPosition();
    }

    public MarkerHolder getMarkerInfo(String str, String str2, String str3, String str4) {
        MarkerHolder markerHolder = new MarkerMovements(str, this.apiKey, str2, str3, str4).getMarkerHolder();
        markerHolder.getMarker().get(1);
        return markerHolder;
    }

    public TTSEngine getTTSEngine() {
        return this.ttsEngine;
    }

    public VisemeHolder getVisemeInfo(String str, String str2, String str3, String str4) {
        VisemeHolder visemeHolder = new MouthMovements(str, this.apiKey, str2, str3, str4).getVisemeHolder();
        visemeHolder.getViseme().get(1);
        return visemeHolder;
    }

    public void setConnectionTimeout(int i) {
        if (this.ttsEngine != null) {
            this.ttsEngine.setSocketTimeout(i);
        }
    }

    public void setSpeakWhenSilent(boolean z) {
        InternalResources.alwaysSpeak(z);
    }

    public void setSpeechSynthesisEvent(SpeechSynthesisEvent speechSynthesisEvent) {
        this.speechEventListeners.add(speechSynthesisEvent);
    }

    public void setStreamType(int i) {
        InternalResources.setStreamType(i);
    }

    public void setVoiceType(String str) {
        this.ttsEngine.setVoice(str);
    }

    public void speak(final String str) {
        try {
            if (!UtilitiesInternal.hasFrameworkActivityDefinedInManifest(this._context)) {
                createEventThread(EventType.PLAY_FAILURE, new IllegalArgumentException("No API Key detected."));
            } else if (this.ttsEngine.isSpeaking()) {
                createEventThread(EventType.PLAY_FAILURE, new BusyException("Device is busy?"));
            } else {
                if (str != null) {
                    if (str.length() != 0) {
                        showProcessingDialog();
                        setupTTSEngine();
                        this.speechAttempted = true;
                        this.ttsEngineWorkThread = new Thread() {
                            public void run() {
                                try {
                                    SpeechSynthesis.this.ttsEngine.speak(SpeechSynthesis.this._context, str);
                                    while (!SpeechSynthesis.this.ttsEngine.startedSpeaking) {
                                        Thread.sleep(100);
                                    }
                                    SpeechSynthesis.this.stateChangedListener.changeState(2);
                                } catch (Throwable e) {
                                    SpeechSynthesis.this.audioManager.setStreamSolo(InternalResources.STREAM_TYPE, false);
                                    Log.e(SpeechSynthesis.TAG, e.getMessage(), e);
                                    SpeechSynthesis.this.createEventThread(EventType.PLAY_FAILURE, e);
                                } catch (InterruptedException e2) {
                                    SpeechSynthesis.this.ttsEngine.cancelTTS();
                                    e2.printStackTrace();
                                } finally {
                                    SpeechSynthesis.this.speechAttempted = false;
                                }
                            }
                        };
                        this.ttsEngineWorkThread.start();
                        return;
                    }
                }
                createEventThread(EventType.PLAY_FAILURE, new IllegalArgumentException("Text is Empty."));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (this.ttsEngine.isSpeaking()) {
            int currentPosition = this.ttsEngine.getCurrentPosition();
            if (this.convertResult == null || this.convertResult.contentTimeLength <= 0 || currentPosition < this.convertResult.contentTimeLength) {
                this.mediaTime = currentPosition;
                this.ttsEngine.stop();
                this.wtfidontevenknow = true;
                new C05949().start();
            }
        } else if (this.ttsEngine.isRunning() && !this.wtfidontevenknow) {
            this.ttsEngine.setEarlyStop();
        }
        this.audioManager.setStreamSolo(InternalResources.STREAM_TYPE, false);
    }

    public void toDisableTheDialogContact_salesATiSpeechDOTorg() {
    }

    public void unregisterSpeechSynthesisEventListener(SpeechSynthesisEvent speechSynthesisEvent) {
        if (this.speechEventListeners.remove(speechSynthesisEvent)) {
            Log.d(TAG, "Removed speech synthesis event listener");
        }
    }
}
