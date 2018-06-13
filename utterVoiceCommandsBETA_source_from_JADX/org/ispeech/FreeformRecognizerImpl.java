package org.ispeech;

import DrawImage.DrawCanvas;
import android.content.Context;
import android.content.Intent;
import android.media.AmrInputStream;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.ispeech.SpeechRecognizerEvent.EventType;
import org.ispeech.core.HttpRequestParams;
import org.ispeech.core.InternalResources;
import org.ispeech.core.RecognizerDialog;
import org.ispeech.core.SilenceDetection;
import org.ispeech.core.SilenceResult;
import org.ispeech.core.SoundBox;
import org.ispeech.error.ApiException;
import org.ispeech.error.InvalidApiKeyException;
import org.ispeech.error.NoNetworkException;
import org.ispeech.tools.HttpUtils;
import org.ispeech.tools.SerializableHashTable;
import org.ispeech.tools.Utilities;

class FreeformRecognizerImpl implements Recognizer {
    private static final int FREQUENCY = 8000;
    private static boolean IS_STREAMING_ENABLED = false;
    private static final int MS_PER_FRAME = 20;
    private static final int SAMPLE_PER_FRAME = 160;
    private static final String TAG = "iSpeech SDK";
    private static FreeformRecognizerImpl _instance = null;
    private static final int _model = 1;
    private int MIN_RECORD_BUFF_SIZE = (AudioRecord.getMinBufferSize(FREQUENCY, 2, 2) * 4);
    private String _apiKey;
    private Context _context;
    private Handler alertDialogHandler;
    private Map<String, List<String>> aliasList = new HashMap();
    private AudioManager audioManager;
    private AudioRecord audioRecorder;
    private LinkedBlockingQueue<BufferItem> bufferQueue = new LinkedBlockingQueue();
    private FreeformType freeFormValue = FreeformType.FREEFORM_SMS;
    private SerializableHashTable meta;
    private String mimeType = "audio/amr";
    private Map<String, String> optionalCommands = new Hashtable();
    private Vector<String> phraseList = new Vector();
    private HttpPost post;
    private SpeechRecognizerEvent recognizerEventListener = null;
    private boolean silenceDetectOn;
    long silenceStart = -1;
    private int socketTimeout = 60000;
    private boolean soundTone = true;
    private long timeout = 60000;
    private TimerTask timeoutTask;
    int voiceCount = 0;
    private VoiceDataCollector voiceDataCollector;
    VoiceDataTransporter voiceDataTransporter;
    private VoiceRecorderAsyncTask voiceRecorderAsyncTask;

    class C05793 extends TimerTask {
        C05793() {
        }

        public void run() {
            Log.d(FreeformRecognizerImpl.TAG, "Maximum record time reached.");
            if (FreeformRecognizerImpl.this.audioRecorder != null && FreeformRecognizerImpl.this.audioRecorder.getState() == 1 && FreeformRecognizerImpl.this.audioRecorder.getState() == 3) {
                FreeformRecognizerImpl.this.stopRecord();
            }
        }
    }

    class BufferItem {
        byte[] data;
        int length;

        BufferItem(byte[] bArr, int i) {
            this.data = bArr;
            this.length = i;
        }
    }

    class VoiceDataCollector extends Thread {
        OutputStream out;

        private VoiceDataCollector() {
        }

        public void run() {
            if (FreeformRecognizerImpl.IS_STREAMING_ENABLED) {
                FreeformRecognizerImpl.this.voiceDataTransporter = new VoiceDataTransporter();
                FreeformRecognizerImpl.this.voiceDataTransporter.start();
                this.out = FreeformRecognizerImpl.this.voiceDataTransporter.waitForConnection();
            } else {
                this.out = new ByteArrayOutputStream();
            }
            if (this.out != null) {
                while (!isInterrupted() && (!FreeformRecognizerImpl.this.bufferQueue.isEmpty() || FreeformRecognizerImpl.this.voiceRecorderAsyncTask.isRecording())) {
                    BufferItem bufferItem;
                    try {
                        bufferItem = (BufferItem) FreeformRecognizerImpl.this.bufferQueue.poll(3, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        bufferItem = null;
                    }
                    if (bufferItem != null) {
                        if (bufferItem.length == -1) {
                            break;
                        }
                        AmrInputStream amrInputStream = new AmrInputStream(new ByteArrayInputStream(bufferItem.data, 0, bufferItem.length));
                        byte[] bArr = new byte[320];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        int i = 1;
                        while (i > 0) {
                            try {
                                i = amrInputStream.read(bArr, 0, bArr.length);
                                if (i > 0) {
                                    byteArrayOutputStream.write(bArr, 0, i);
                                }
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        amrInputStream.close();
                        if (FreeformRecognizerImpl.IS_STREAMING_ENABLED) {
                            byte[] array = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
                            this.out.write(2);
                            this.out.write(1);
                            this.out.write(1);
                            this.out.write(array);
                        }
                        this.out.write(byteArrayOutputStream.toByteArray());
                        this.out.flush();
                    }
                }
                if (FreeformRecognizerImpl.IS_STREAMING_ENABLED) {
                    OutputStream outputStream = this.out;
                    byte[] bArr2 = new byte[7];
                    bArr2[0] = (byte) 2;
                    bArr2[1] = (byte) 1;
                    bArr2[2] = (byte) 1;
                    outputStream.write(bArr2);
                    this.out.flush();
                }
                if (isInterrupted() || FreeformRecognizerImpl.this.voiceRecorderAsyncTask.isRecordingCanceled()) {
                    Log.d(FreeformRecognizerImpl.TAG, "Freeform Recognizer work thread -> interrupt request received and/or recording canceled");
                } else if (!FreeformRecognizerImpl.IS_STREAMING_ENABLED) {
                    FreeformRecognizerImpl.this.voiceDataTransporter = new VoiceDataTransporter(this.out);
                    FreeformRecognizerImpl.this.voiceDataTransporter.start();
                }
            }
        }
    }

    class VoiceDataTransporter extends Thread {
        boolean isPrepared = false;
        OutputStream out = null;
        Socket sck;

        public VoiceDataTransporter(OutputStream outputStream) {
            this.out = outputStream;
        }

        public void run() {
            Log.d(FreeformRecognizerImpl.TAG, new StringBuilder(String.valueOf(VoiceDataTransporter.class.getSimpleName())).append("started run.").toString());
            try {
                String str;
                int i;
                HttpResponse httpResponse;
                FreeformRecognizerImpl.this.audioManager.setStreamSolo(InternalResources.STREAM_TYPE, false);
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair(HttpRequestParams.APIKEY, FreeformRecognizerImpl.this._apiKey));
                arrayList.add(new BasicNameValuePair(HttpRequestParams.CONTENTTYPE, FreeformRecognizerImpl.this.mimeType));
                arrayList.add(new BasicNameValuePair(HttpRequestParams.ACTION, HttpRequestParams.ACTION_RECOGNIZE));
                arrayList.add(new BasicNameValuePair(HttpRequestParams.FREEFORM, String.valueOf(FreeformRecognizerImpl.this.freeFormValue.getValue())));
                if (FreeformRecognizerImpl.this.freeFormValue.getValue() == 0) {
                    int i2 = 0;
                    String str2 = "";
                    while (i2 < FreeformRecognizerImpl.this.phraseList.size()) {
                        str = (String) FreeformRecognizerImpl.this.phraseList.get(i2);
                        str2 = i2 == 0 ? new StringBuilder(String.valueOf(str2)).append("command").append(Integer.toString(i2)).toString() : new StringBuilder(String.valueOf(str2)).append("|command").append(Integer.toString(i2)).toString();
                        if (str.contains("%")) {
                            Matcher matcher = Pattern.compile("%(.*?)%").matcher(str);
                            while (matcher.find()) {
                                str2 = str2.equals("") ? new StringBuilder(String.valueOf(str2)).append(str.substring(matcher.start() + 1, matcher.end() - 1).toUpperCase()).toString() : new StringBuilder(String.valueOf(str2)).append("|").append(str.substring(matcher.start() + 1, matcher.end() - 1).toUpperCase()).toString();
                            }
                        }
                        i2++;
                        str2 = str2;
                    }
                    arrayList.add(new BasicNameValuePair(HttpRequestParams.ALIAS, str2));
                    for (int i3 = 0; i3 < FreeformRecognizerImpl.this.phraseList.size(); i3++) {
                        arrayList.add(new BasicNameValuePair("command" + Integer.toString(i3), (String) FreeformRecognizerImpl.this.phraseList.get(i3)));
                    }
                    for (i = 0; i < FreeformRecognizerImpl.this.phraseList.size(); i++) {
                        str = (String) FreeformRecognizerImpl.this.phraseList.get(i);
                        if (str.contains("%")) {
                            Matcher matcher2 = Pattern.compile("%(.*?)%").matcher(str);
                            while (matcher2.find()) {
                                String substring = str.substring(matcher2.start() + 1, matcher2.end() - 1);
                                i2 = 0;
                                String str3 = "";
                                while (i2 < ((List) FreeformRecognizerImpl.this.aliasList.get(substring)).size()) {
                                    str2 = str3.equals("") ? new StringBuilder(String.valueOf(str3)).append((String) ((List) FreeformRecognizerImpl.this.aliasList.get(substring)).get(i2)).toString() : new StringBuilder(String.valueOf(str3)).append("|").append((String) ((List) FreeformRecognizerImpl.this.aliasList.get(substring)).get(i2)).toString();
                                    i2++;
                                    str3 = str2;
                                }
                                arrayList.add(new BasicNameValuePair(substring, str3));
                            }
                            continue;
                        }
                    }
                }
                arrayList.add(new BasicNameValuePair(HttpRequestParams.DEVICE, HttpRequestParams.DEVICE_ANDROID));
                if (FreeformRecognizerImpl.this.meta != null && FreeformRecognizerImpl.this.meta.size() > 0) {
                    arrayList.add(new BasicNameValuePair(HttpRequestParams.META, new String(Utilities.encodeBase64(FreeformRecognizerImpl.this.meta.serialize()))));
                }
                if (FreeformRecognizerImpl.this.optionalCommands != null && FreeformRecognizerImpl.this.optionalCommands.size() > 0) {
                    for (String str4 : FreeformRecognizerImpl.this.optionalCommands.keySet()) {
                        arrayList.add(new BasicNameValuePair(str4, (String) FreeformRecognizerImpl.this.optionalCommands.get(str4)));
                    }
                }
                str4 = HttpUtils.addParamsToUrl(InternalResources.getAPIUrl(FreeformRecognizerImpl.this._context), arrayList);
                Log.d("DEBUG", "URLPATH: " + str4);
                if (FreeformRecognizerImpl.IS_STREAMING_ENABLED) {
                    this.sck = new Socket();
                    this.sck.connect(new InetSocketAddress(InternalResources.getASRDomain(FreeformRecognizerImpl.this._context), 80));
                    if (this.sck.isConnected()) {
                        String[] split = str4.split("\\?", 2);
                        this.out = this.sck.getOutputStream();
                        this.out.write("iSpeech".getBytes("utf8"));
                        this.out.write(2);
                        this.out.write(1);
                        this.out.write(1);
                        byte[] bytes = split[1].getBytes("utf8");
                        this.out.write(ByteBuffer.allocate(4).putInt(bytes.length).array());
                        this.out.write(bytes);
                        httpResponse = null;
                    } else {
                        throw new ApiException("Could not connect to host");
                    }
                }
                FreeformRecognizerImpl.this.post = new HttpPost(str4);
                FreeformRecognizerImpl.this.post.setEntity(new ByteArrayEntity(((ByteArrayOutputStream) this.out).toByteArray()));
                HttpClient defaultHttpClient = new DefaultHttpClient();
                defaultHttpClient.getParams().setParameter(HttpRequestParams.SOCKET_TIMEOUT, new Integer(FreeformRecognizerImpl.this.socketTimeout));
                httpResponse = defaultHttpClient.execute(FreeformRecognizerImpl.this.post);
                if (isInterrupted()) {
                    Log.d(FreeformRecognizerImpl.TAG, new StringBuilder(String.valueOf(VoiceDataTransporter.class.getSimpleName())).append("->Processing (recognition canceled.").toString());
                    return;
                }
                int i4;
                Map map;
                Object speechResult;
                if (FreeformRecognizerImpl.IS_STREAMING_ENABLED) {
                    InputStream inputStream = this.sck.getInputStream();
                    inputStream.read();
                    inputStream.read();
                    inputStream.read();
                    byte[] bArr = new byte[4096];
                    inputStream.read(bArr, 0, 4);
                    ByteBuffer put = ByteBuffer.allocate(4).put(bArr, 0, 4);
                    put.position(0);
                    i4 = put.getInt();
                    if (i4 == 0) {
                        this.isPrepared = true;
                        inputStream.read();
                        inputStream.read();
                        inputStream.read();
                        inputStream.read(bArr, 0, 4);
                        put = ByteBuffer.allocate(4).put(bArr, 0, 4);
                        put.position(0);
                        i4 = put.getInt();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (i4 > 0) {
                            i = inputStream.read(bArr, 0, bArr.length);
                            if (i <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                            i4 -= i;
                        }
                        Map parseNameValuePairString = HttpUtils.parseNameValuePairString(new String(byteArrayOutputStream.toByteArray()));
                        byteArrayOutputStream.close();
                        map = parseNameValuePairString;
                    } else {
                        ByteBuffer allocate = ByteBuffer.allocate(i4);
                        while (i4 > 0) {
                            int read = inputStream.read(bArr, 0, bArr.length);
                            allocate.put(bArr, 0, read);
                            i4 -= read;
                        }
                        SerializableHashTable deserialize = SerializableHashTable.deserialize(allocate.array());
                        FreeformRecognizerImpl.this.stopRecord();
                        throw new ApiException(deserialize.getString("message"));
                    }
                }
                map = HttpUtils.parseNameValuePairString(EntityUtils.toString(httpResponse.getEntity()));
                if (map.containsKey("result") && ((String) map.get("result")).equals("success")) {
                    speechResult = new SpeechResult((String) map.get(HttpRequestParams.TEXT), Float.parseFloat((String) map.get("confidence")));
                } else if (map.containsKey("result") && ((String) map.get("result")).equals("error")) {
                    if (map.containsKey("code")) {
                        i4 = Integer.parseInt((String) map.get("code"));
                        switch (i4) {
                            case 1:
                                RecognizerDialog.getInstance().dismiss();
                                break;
                            case 3:
                            case 101:
                                break;
                            case 999:
                                throw new InvalidApiKeyException();
                            default:
                                Log.d(FreeformRecognizerImpl.TAG, new StringBuilder(String.valueOf(VoiceDataTransporter.class.getSimpleName())).append(" Error code: ").append(i4).append(" ").append(map.toString()).toString());
                                throw new IOException();
                        }
                    }
                    throw new ApiException((String) map.get("message"));
                } else {
                    speechResult = null;
                }
                if (isInterrupted()) {
                    Log.d(FreeformRecognizerImpl.TAG, new StringBuilder(String.valueOf(VoiceDataTransporter.class.getSimpleName())).append("->Processing (recognition canceled.").toString());
                    Log.d(FreeformRecognizerImpl.TAG, "Recognizer work thread - CLEANUP in final clause...");
                    FreeformRecognizerImpl.this.audioManager.setStreamSolo(InternalResources.STREAM_TYPE, false);
                    FreeformRecognizerImpl.this.timeoutTask.cancel();
                    FreeformRecognizerImpl.this.voiceCount = 0;
                    return;
                }
                Log.d(FreeformRecognizerImpl.TAG, new StringBuilder(String.valueOf(VoiceDataTransporter.class.getSimpleName())).append("->Processing wasn't interrupted, proceeding with the processing result.").toString());
                FreeformRecognizerImpl.this.createEventThread(EventType.RECOGNITION_COMPLETE, speechResult);
                FreeformRecognizerImpl.this.alertDialogHandler.sendEmptyMessage(0);
                Log.d(FreeformRecognizerImpl.TAG, "Recognizer work thread - CLEANUP in final clause...");
                FreeformRecognizerImpl.this.audioManager.setStreamSolo(InternalResources.STREAM_TYPE, false);
                FreeformRecognizerImpl.this.timeoutTask.cancel();
                FreeformRecognizerImpl.this.voiceCount = 0;
            } catch (ClientProtocolException e) {
                e.printStackTrace();
                FreeformRecognizerImpl.this.createEventThread(EventType.ERROR, e);
            } catch (IOException e2) {
                e2.printStackTrace();
                FreeformRecognizerImpl.this.createEventThread(EventType.ERROR, e2);
            } catch (InvalidApiKeyException e3) {
                e3.printStackTrace();
                FreeformRecognizerImpl.this.createEventThread(EventType.ERROR, e3);
            } catch (ApiException e4) {
                e4.printStackTrace();
                FreeformRecognizerImpl.this.createEventThread(EventType.ERROR, e4);
            } finally {
                Log.d(FreeformRecognizerImpl.TAG, "Recognizer work thread - CLEANUP in final clause...");
                FreeformRecognizerImpl.this.audioManager.setStreamSolo(InternalResources.STREAM_TYPE, false);
                FreeformRecognizerImpl.this.timeoutTask.cancel();
                FreeformRecognizerImpl.this.voiceCount = 0;
            }
        }

        public OutputStream waitForConnection() {
            while (isAlive()) {
                if (this.sck != null && this.sck.isConnected() && this.isPrepared) {
                    return this.out;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    class VoiceRecorderAsyncTask extends AsyncTask<Void, Void, Boolean> {
        private AudioRecord audioRecorder;
        private boolean isCanceled;
        private boolean isStopped;

        class C05801 extends Thread {
            C05801() {
            }

            public void run() {
                FreeformRecognizerImpl.this.playOpenSound();
                RecognizerDialog.getInstance().fixCanvas();
                RecognizerDialog.getInstance().startDraw();
                VoiceRecorderAsyncTask.this.audioRecorder = new AudioRecord(1, FreeformRecognizerImpl.FREQUENCY, 2, 2, FreeformRecognizerImpl.this.MIN_RECORD_BUFF_SIZE);
                VoiceRecorderAsyncTask.this.audioRecorder.startRecording();
                int access$19 = FreeformRecognizerImpl.this.MIN_RECORD_BUFF_SIZE;
                int i = access$19 + (access$19 % 2 == 0 ? 0 : 1);
                int i2 = 0;
                DrawCanvas canvas = RecognizerDialog.getInstance().getCanvas();
                while (!VoiceRecorderAsyncTask.this.isStopped) {
                    Object obj = new byte[FreeformRecognizerImpl.this.MIN_RECORD_BUFF_SIZE];
                    int read = VoiceRecorderAsyncTask.this.audioRecorder.read(obj, 0, obj.length);
                    VoiceRecorderAsyncTask.this.addDataToBufferQueue(obj, read);
                    for (access$19 = 0; access$19 + i <= read; access$19 += i) {
                        int i3 = 0;
                        int i4 = i2;
                        while (i3 < obj.length) {
                            Object obj2;
                            SilenceResult checkSilence;
                            if (obj.length - i3 < obj.length / 4) {
                                obj2 = new byte[(obj.length - i3)];
                                System.arraycopy(obj, i3, obj2, 0, obj.length - i3);
                                checkSilence = SilenceDetection.checkSilence(obj2, access$19, i / 4, 0 > 0 ? 0 / ((long) i4) : 0, 0);
                                i2 = i4 + 1;
                                canvas.setY(checkSilence.normalizedEnergy);
                            } else {
                                obj2 = new byte[(obj.length / 4)];
                                System.arraycopy(obj, i3, obj2, 0, obj.length / 4);
                                int length = i3 + (obj.length / 4);
                                checkSilence = SilenceDetection.checkSilence(obj2, access$19, i / 4, 0 > 0 ? 0 / ((long) i4) : 0, 0);
                                i2 = i4 + 1;
                                canvas.setY(checkSilence.normalizedEnergy);
                                if (FreeformRecognizerImpl.this.silenceDetectOn) {
                                    if (!checkSilence.status) {
                                        FreeformRecognizerImpl.this.silenceStart = -1;
                                        FreeformRecognizerImpl access$8 = FreeformRecognizerImpl.this;
                                        access$8.voiceCount++;
                                    } else if (FreeformRecognizerImpl.this.silenceStart == -1) {
                                        FreeformRecognizerImpl.this.silenceStart = System.currentTimeMillis();
                                    }
                                    if (FreeformRecognizerImpl.this.voiceCount <= 0) {
                                        FreeformRecognizerImpl.this.silenceStart = -1;
                                    }
                                    if (FreeformRecognizerImpl.this.silenceStart > -1 && System.currentTimeMillis() - FreeformRecognizerImpl.this.silenceStart > 1600) {
                                        Log.d(FreeformRecognizerImpl.TAG, "Silence detected, stopping recording");
                                        FreeformRecognizerImpl.this.stopTimeoutTask();
                                        break;
                                    }
                                }
                                i3 = length;
                                i4 = i2;
                            }
                        }
                        i2 = i4;
                    }
                    if (FreeformRecognizerImpl.this.silenceStart > -1) {
                        if (System.currentTimeMillis() - FreeformRecognizerImpl.this.silenceStart > 1600) {
                            break;
                        }
                    }
                }
                i2 = 1;
                VoiceRecorderAsyncTask.this.audioRecorder.stop();
                while (i2 > 0) {
                    byte[] bArr = new byte[FreeformRecognizerImpl.this.MIN_RECORD_BUFF_SIZE];
                    i2 = VoiceRecorderAsyncTask.this.audioRecorder.read(bArr, 0, bArr.length);
                    if (i2 > 0) {
                        VoiceRecorderAsyncTask.this.addDataToBufferQueue(bArr, i2);
                    }
                }
                VoiceRecorderAsyncTask.this.isStopped = true;
                VoiceRecorderAsyncTask.this.audioRecorder.release();
                VoiceRecorderAsyncTask.this.addDataToBufferQueue(null, -1);
                Log.d(FreeformRecognizerImpl.TAG, new StringBuilder(String.valueOf(VoiceRecorderAsyncTask.class.getSimpleName())).append("  onPostExecute").toString());
                if (!VoiceRecorderAsyncTask.this.isRecordingCanceled()) {
                    if (FreeformRecognizerImpl.this.soundTone) {
                        SoundBox.getInstance(FreeformRecognizerImpl.this._context).playClose();
                    }
                    FreeformRecognizerImpl.this.alertDialogHandler.sendEmptyMessage(2);
                    FreeformRecognizerImpl.this.createEventThread(EventType.RECORDING_COMPLETE, null);
                }
            }
        }

        private VoiceRecorderAsyncTask() {
            this.isStopped = false;
            this.isCanceled = false;
        }

        private void addDataToBufferQueue(byte[] bArr, int i) {
            try {
                FreeformRecognizerImpl.this.bufferQueue.put(new BufferItem(bArr, i));
            } catch (InterruptedException e) {
                Log.e(FreeformRecognizerImpl.TAG, "Could not add data to the buffer queue");
            }
        }

        public void cancelRecording() {
            stopRecording();
            this.isCanceled = true;
        }

        protected Boolean doInBackground(Void... voidArr) {
            Thread c05801 = new C05801();
            c05801.setPriority(10);
            c05801.start();
            return Boolean.valueOf(true);
        }

        public boolean isRecording() {
            return !this.isStopped;
        }

        public boolean isRecordingCanceled() {
            return this.isCanceled;
        }

        protected void onPostExecute(Boolean bool) {
        }

        public void stopRecording() {
            this.isStopped = true;
        }
    }

    private FreeformRecognizerImpl(Context context) {
        String apiKey = Utilities.getApiKey(context);
        if (apiKey == null || apiKey.length() != 32) {
            throw new InvalidApiKeyException();
        }
        this._apiKey = apiKey;
        this._context = context.getApplicationContext();
        this.meta = Utilities.getMetaInfo(context);
        SoundBox.getInstance(context);
        this.audioManager = (AudioManager) this._context.getSystemService("audio");
    }

    private Thread createEventThread(final EventType eventType, final Object obj) {
        Handler handler = new Handler(this._context.getMainLooper());
        Object c05771 = new Thread(eventType.name()) {
            public void run() {
                if (FreeformRecognizerImpl.this.recognizerEventListener != null) {
                    FreeformRecognizerImpl.this.recognizerEventListener.stateChanged(eventType, obj);
                }
            }
        };
        handler.post(c05771);
        return c05771;
    }

    public static FreeformRecognizerImpl getInstance(Context context) {
        if (_instance == null) {
            _instance = new FreeformRecognizerImpl(context);
        }
        return _instance;
    }

    public static FreeformRecognizerImpl getInstance(Context context, String str) {
        if (_instance == null) {
            _instance = new FreeformRecognizerImpl(context);
        }
        return _instance;
    }

    private void playOpenSound() {
        if (this.soundTone) {
            SoundBox.getInstance(this._context).playOpen();
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void removeOptionalCommand(String str) {
        if (this.optionalCommands.containsKey(str)) {
            this.optionalCommands.remove(str);
        }
    }

    private void setupProcessingDialogHandler() {
        this.alertDialogHandler = new Handler(this._context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    RecognizerDialog.getInstance().clearLayout();
                    RecognizerDialog.getInstance().dismiss();
                } else if (message.what == 1) {
                    FreeformRecognizerImpl.this.showDialog();
                } else if (message.what == 2) {
                    RecognizerDialog.getInstance().setRecognizing();
                } else if (message.what == 3 && RecognizerDialog.getInstance() != null) {
                    RecognizerDialog.getInstance().setMicrophoneLevel(message.arg1);
                }
            }
        };
    }

    private void setupRecordingTimeoutTask() {
        this.timeoutTask = new C05793();
        new Timer().schedule(this.timeoutTask, this.timeout);
    }

    private void showDialog() {
        Intent intent = new Intent(this._context, iSpeechFramework.class);
        intent.putExtra(InternalResources.ISPEECH_SCREEN_TYPE, 0);
        intent.putExtra(InternalResources.ISPEECH_SCREEN_APIKEY, this._apiKey);
        intent.setFlags(268435456);
        this._context.startActivity(intent);
    }

    public void addAlias(String str, String[] strArr) {
        if (!this.aliasList.containsKey(str.toUpperCase())) {
            this.aliasList.put(str.toUpperCase(), new ArrayList());
        }
        for (Object add : strArr) {
            ((List) this.aliasList.get(str)).add(add);
        }
    }

    public void addCommand(String str) {
        if (!this.phraseList.contains(str)) {
            this.phraseList.add(str);
        }
    }

    public void addCommand(String[] strArr) {
        if (strArr != null) {
            for (String addCommand : strArr) {
                addCommand(addCommand);
            }
        }
    }

    public void addMeta(MetaType metaType, String str) {
        this.meta.put(metaType.getValue(), str);
    }

    public void addOptionalCommand(String str, String str2) {
        this.optionalCommands.put(str, str2);
    }

    public void cancelProcessing() {
        Log.d(TAG, "Canceling processing");
        if (this.voiceDataTransporter != null) {
            this.voiceDataTransporter.interrupt();
            Log.e(TAG, "Can not interrupt " + VoiceDataTransporter.class.getSimpleName() + ". It has not been initialized yet");
        }
        createEventThread(EventType.RECOGNITION_CANCELED, null);
    }

    public void cancelRecord() {
        stopRecord();
        this.voiceRecorderAsyncTask.cancelRecording();
        this.voiceDataCollector.interrupt();
        createEventThread(EventType.RECORDING_CANCELED, null);
    }

    public void clearAlias() {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    public void clearCommand() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public void clearOptionalCommand() {
        this.optionalCommands.clear();
    }

    public void disableSoundTone() {
        this.soundTone = false;
    }

    public void enableSoundTone() {
        this.soundTone = true;
    }

    public FreeformType getFreeForm() {
        return this.freeFormValue;
    }

    public boolean isRunning() {
        return RecognizerDialog.getInstance().isDialogRunning();
    }

    public void setChime(boolean z) {
        if (z) {
            enableSoundTone();
        } else {
            disableSoundTone();
        }
    }

    public void setFreeForm(FreeformType freeformType) {
        this.freeFormValue = freeformType;
    }

    public void setLocale(String str) {
        if (str != null) {
            addOptionalCommand("locale", str);
        } else {
            removeOptionalCommand("locale");
        }
    }

    public void setModel(String str) {
        if (str != null) {
            addOptionalCommand("model", str);
        } else {
            removeOptionalCommand("model");
        }
    }

    public void setSilenceDetection(boolean z) {
        this.silenceDetectOn = z;
    }

    public void setSocketTimeout(int i) {
        this.socketTimeout = i;
    }

    public void setStreaming(boolean z) {
        IS_STREAMING_ENABLED = z;
    }

    public void setTimeout(int i) {
        this.timeout = (long) i;
    }

    public synchronized void startRecord(SpeechRecognizerEvent speechRecognizerEvent) {
        if (UtilitiesInternal.hasFrameworkActivityDefinedInManifest(this._context)) {
            if (Utilities.isNetworkAvailable(this._context)) {
                this.recognizerEventListener = speechRecognizerEvent;
                if (this.voiceRecorderAsyncTask == null || !this.voiceRecorderAsyncTask.isRecording()) {
                    this.silenceStart = -1;
                    try {
                        this.bufferQueue.clear();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    setupProcessingDialogHandler();
                    this.alertDialogHandler.sendEmptyMessage(1);
                    setupRecordingTimeoutTask();
                    this.audioManager.setStreamSolo(InternalResources.STREAM_TYPE, true);
                    this.voiceRecorderAsyncTask = new VoiceRecorderAsyncTask();
                    this.voiceRecorderAsyncTask.execute(new Void[0]);
                    this.voiceDataCollector = new VoiceDataCollector();
                    this.voiceDataCollector.start();
                } else {
                    createEventThread(EventType.ERROR, new IllegalStateException("Device is busy?"));
                    this.voiceRecorderAsyncTask.cancelRecording();
                    this.voiceDataCollector.interrupt();
                }
            } else {
                Log.d(InternalResources.ISPEECH_SCREEN_DEBUG, "throwing exception");
                throw new NoNetworkException("Network is not available.");
            }
        }
    }

    public void stopRecord() {
        if (this.timeoutTask != null) {
            this.timeoutTask.cancel();
        }
        this.voiceRecorderAsyncTask.stopRecording();
    }

    void stopTimeoutTask() {
        if (this.timeoutTask != null) {
            this.timeoutTask.cancel();
        }
    }
}
