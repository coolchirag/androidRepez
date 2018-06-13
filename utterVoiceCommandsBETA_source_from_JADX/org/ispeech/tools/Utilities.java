package org.ispeech.tools;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.faceture.google.play.QueryParamConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.ispeech.FreeformType;
import org.ispeech.SDKInfo;
import org.ispeech.SpeechRecognizer;
import org.ispeech.SpeechRecognizerEvent;
import org.ispeech.SpeechResult;
import org.ispeech.core.HttpRequestParams;
import org.ispeech.core.InternalResources;
import org.ispeech.tools.CommandResult.CommandType;

public class Utilities {
    private static /* synthetic */ int[] $SWITCH_TABLE$org$ispeech$tools$CommandResult$CommandType;
    public static final boolean APIKEY_GOOD = false;
    private static String TAG = ("iSpeech SDK" + Utilities.class.getSimpleName());

    class C06071 extends SpeechRecognizerEvent {
        private static /* synthetic */ int[] $SWITCH_TABLE$org$ispeech$tools$CommandResult$CommandType;
        private final /* synthetic */ Map val$commandList;
        private final /* synthetic */ int val$connectionTimeout;
        private final /* synthetic */ Context val$context;
        private final /* synthetic */ CommandResult val$r;

        static /* synthetic */ int[] $SWITCH_TABLE$org$ispeech$tools$CommandResult$CommandType() {
            int[] iArr = $SWITCH_TABLE$org$ispeech$tools$CommandResult$CommandType;
            if (iArr == null) {
                iArr = new int[CommandType.values().length];
                try {
                    iArr[CommandType.COMMAND_LAUNCH_URL.ordinal()] = 4;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[CommandType.COMMAND_PHONE_CALL.ordinal()] = 3;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[CommandType.COMMAND_SEND_SMS.ordinal()] = 2;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[CommandType.UNKNOWN.ordinal()] = 1;
                } catch (NoSuchFieldError e4) {
                }
                $SWITCH_TABLE$org$ispeech$tools$CommandResult$CommandType = iArr;
            }
            return iArr;
        }

        C06071(CommandResult commandResult, Map map, Context context, int i) {
            this.val$r = commandResult;
            this.val$commandList = map;
            this.val$context = context;
            this.val$connectionTimeout = i;
        }

        public void onError(Exception exception) {
        }

        public void onRecognitionComplete(SpeechResult speechResult) {
            if (speechResult != null && speechResult.getText() != null && speechResult.getText().trim().length() > 0 && speechResult.getConfidence() > 0.0f && ((this.val$r.getParameterCount() % 2 != 0 || this.val$commandList.containsKey(speechResult.getText().toLowerCase())) && !this.val$r.getParameter(this.val$r.getParameterCount() - 1).toLowerCase().equals(speechResult.getText().toLowerCase()) && this.val$commandList != null && this.val$commandList.containsKey(speechResult.getText().toLowerCase()))) {
                switch (C06071.$SWITCH_TABLE$org$ispeech$tools$CommandResult$CommandType()[this.val$r.Command.ordinal()]) {
                    case 2:
                        Utilities.sendSMS(this.val$context, ((String) this.val$commandList.get(speechResult.getText().toLowerCase())).toString(), new String(this.val$r.Data));
                        break;
                    case 3:
                        Utilities.initiateCall(this.val$context, ((String) this.val$commandList.get(speechResult.getText().toLowerCase())).toString());
                        break;
                    case 4:
                        Utilities.launchBrowser(this.val$context, ((String) this.val$commandList.get(speechResult.getText().toLowerCase())).toString());
                        break;
                }
            }
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(QueryParamConst.U_NAME, this.val$r.uniqueId));
            arrayList.add(new BasicNameValuePair("s", QueryParamConst.U_VALUE));
            try {
                Utilities.createConnection(InternalResources.NOTIFICATION_URL, arrayList, this.val$connectionTimeout);
            } catch (Exception e) {
                Log.e("Utilities.createConnection", e.getMessage());
            }
        }

        public void onRecordingCancelled() {
        }

        public void onRecordingComplete() {
        }
    }

    class C06082 extends TimerTask {
        private final /* synthetic */ Context val$context;
        private final /* synthetic */ String val$phoneNum;

        C06082(String str, Context context) {
            this.val$phoneNum = str;
            this.val$context = context;
        }

        public void run() {
            Intent intent = new Intent("android.intent.action.CALL");
            intent.setData(Uri.parse("tel:" + this.val$phoneNum));
            intent.setFlags(268435456);
            this.val$context.startActivity(intent);
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$ispeech$tools$CommandResult$CommandType() {
        int[] iArr = $SWITCH_TABLE$org$ispeech$tools$CommandResult$CommandType;
        if (iArr == null) {
            iArr = new int[CommandType.values().length];
            try {
                iArr[CommandType.COMMAND_LAUNCH_URL.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CommandType.COMMAND_PHONE_CALL.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CommandType.COMMAND_SEND_SMS.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CommandType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$org$ispeech$tools$CommandResult$CommandType = iArr;
        }
        return iArr;
    }

    private static byte[] ArraysCopy(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        for (int i3 = i; i3 < i2 + i; i3++) {
            bArr2[i3 - i] = bArr[i3];
        }
        return bArr2;
    }

    public static CommandResult cleanData(String str) {
        byte[] decodeBase64 = decodeBase64(sevenToEight(decodeBase64(str)).getBytes());
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(decodeBase64));
        if (dataInputStream.readShort() != decodeBase64.length - 2) {
            return null;
        }
        byte readByte = dataInputStream.readByte();
        short readShort = dataInputStream.readShort();
        byte[] bArr = new byte[readShort];
        dataInputStream.read(bArr, 0, readShort);
        CommandResult commandResult = new CommandResult(CommandType.parseInt(readByte), bArr);
        byte readByte2 = dataInputStream.readByte();
        for (readByte = (byte) 0; readByte < readByte2; readByte++) {
            short readShort2 = dataInputStream.readShort();
            byte[] bArr2 = new byte[readShort2];
            dataInputStream.read(bArr2, 0, readShort2);
            commandResult.addParameter(bArr2);
        }
        readByte = dataInputStream.readByte();
        bArr = new byte[readByte];
        dataInputStream.read(bArr, 0, readByte);
        commandResult.setUniqueId(new String(bArr, "utf8"));
        return commandResult;
    }

    public static HttpResponse createConnection(String str, List<NameValuePair> list, int i) {
        HttpConnectionParams.setConnectionTimeout(new BasicHttpParams(), i);
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost(str);
        HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list);
        urlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(urlEncodedFormEntity);
        return defaultHttpClient.execute(httpPost);
    }

    public static byte[] decodeBase64(String str) {
        return Base64Coder.decode(str);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return decodeBase64(new String(bArr));
    }

    public static float dp2px(float f, Context context) {
        return (context.getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    public static char[] encodeBase64(byte[] bArr) {
        return Base64Coder.encode(bArr);
    }

    public static String getApiKey(Context context) {
        String str = null;
        try {
            try {
                str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(InternalResources.ISPEECH_SCREEN_APIKEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable e2) {
            Log.e(TAG, "can not find API key in manifest file.", e2);
        }
        return str;
    }

    public static String getMCC(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            return (networkOperator == null || networkOperator.length() == 0) ? null : networkOperator.substring(0, 3);
        } catch (Exception e) {
            return "";
        }
    }

    public static String getMNC(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            return (networkOperator == null || networkOperator.length() == 0) ? null : networkOperator.substring(3);
        } catch (Exception e) {
            return "";
        }
    }

    public static SerializableHashTable getMetaInfo(Context context) {
        SerializableHashTable serializableHashTable = new SerializableHashTable();
        serializableHashTable.put("networkType", getNetworkType(context));
        serializableHashTable.put("MCC", getMCC(context));
        serializableHashTable.put("MNC", getMNC(context));
        serializableHashTable.put("networkName", getNetworkName(context));
        serializableHashTable.put("sdkVersion", SDKInfo.SDK_VERSION);
        serializableHashTable.put(HttpRequestParams.DEVICE, "Android");
        return serializableHashTable;
    }

    public static String getNetworkName(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception e) {
            return "";
        }
    }

    public static String getNetworkType(Context context) {
        try {
            switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO_0";
                case 6:
                    return "EVDO_A";
                case 7:
                    return "1xRTT";
                default:
                    return "UNKNOWN";
            }
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage(), e);
            return "";
        }
    }

    public static SerializableHashTable getResult(InputStream inputStream, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (byteArrayOutputStream.size() < i) {
            byte[] bArr = new byte[2048];
            byteArrayOutputStream.write(bArr, 0, inputStream.read(bArr));
        }
        return SerializableHashTable.deserialize(byteArrayOutputStream.toByteArray());
    }

    private static void initiateCall(Context context, String str) {
        new Timer().schedule(new C06082(str, context), 1000);
    }

    public static final byte[] intToByteArray(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static boolean isDebug(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean(InternalResources.ISPEECH_SCREEN_DEBUG);
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo state : allNetworkInfo) {
            if (state.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    private static void launchBrowser(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static File loadFileFromPackage(Context context, String str, String str2) {
        InputStream resourceAsStream = Utilities.class.getClassLoader().getResourceAsStream(str);
        File file = new File(context.getFilesDir(), str2);
        if (!(file.exists() || file.isFile() || resourceAsStream == null)) {
            FileOutputStream openFileOutput = context.openFileOutput(str2, 0);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = resourceAsStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                openFileOutput.write(bArr, 0, read);
            }
            resourceAsStream.close();
            openFileOutput.close();
        }
        return file;
    }

    public static void processCommand(Context context, CommandResult commandResult, String str, int i) {
        if (commandResult != null && !commandResult.Command.equals(CommandType.UNKNOWN)) {
            Map hashtable = new Hashtable();
            if (commandResult.getParameterCount() == 1) {
                switch ($SWITCH_TABLE$org$ispeech$tools$CommandResult$CommandType()[commandResult.Command.ordinal()]) {
                    case 2:
                        sendSMS(context, commandResult.getParameter(0), new String(commandResult.Data));
                        return;
                    case 3:
                        initiateCall(context, commandResult.getParameter(0));
                        return;
                    case 4:
                        launchBrowser(context, commandResult.getParameter(0));
                        return;
                    default:
                        return;
                }
            }
            SpeechRecognizer instance = SpeechRecognizer.getInstance(context);
            instance.setFreeForm(FreeformType.FREEFORM_DISABLED);
            for (int i2 = 0; i2 < commandResult.getParameterCount() - (commandResult.getParameterCount() % 2); i2 += 2) {
                instance.addCommand(new String[]{commandResult.getParameter(i2)});
                hashtable.put(commandResult.getParameter(i2).toLowerCase(), commandResult.getParameter(i2 + 1));
            }
            if (commandResult.getParameterCount() % 2 == 1) {
                instance.addCommand(new String[]{commandResult.getParameter(commandResult.getParameterCount() - 1)});
            }
            try {
                instance.startRecord(new C06071(commandResult, hashtable, context, i));
            } catch (Throwable e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    private static void sendSMS(Context context, String str, String str2) {
        SmsManager.getDefault().sendTextMessage(str, null, str2, null, null);
    }

    public static String sevenToEight(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < bArr.length; i += 7) {
            int i2;
            byte[] bArr2 = new byte[8];
            int min = Math.min(7, bArr.length - i);
            byte[] ArraysCopy = ArraysCopy(bArr, i, min);
            for (i2 = 0; i2 < 8; i2++) {
                if (i2 < ArraysCopy.length) {
                    bArr2[7 - i2] = ArraysCopy[i2];
                }
            }
            long readLong = new DataInputStream(new ByteArrayInputStream(bArr2)).readLong();
            for (i2 = 0; i2 <= min; i2++) {
                byteArrayOutputStream.write((byte) ((int) ((readLong >> (i2 * 7)) & 127)));
            }
        }
        return new String(byteArrayOutputStream.toByteArray(), "utf8").trim();
    }
}
