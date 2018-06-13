package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.support.v4.app.C0052z;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.faceture.google.play.QueryParamConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@SuppressLint({"NewApi"})
public class ServiceTTS extends Service implements OnInitListener, OnUtteranceCompletedListener {
    private static boolean f843B = false;
    private static int f844C = 0;
    private static int f845D = 0;
    private static int f846E = 0;
    private static boolean f847F = false;
    private static ServiceTTS f848G = null;
    static Context f849a;
    static MediaPlayer f850b;
    static OnUtteranceCompletedListener f851c;
    static OnInitListener f852d;
    static HashMap<String, String> f853e;
    public static boolean f854f = false;
    public static boolean f855g = false;
    public static String f856h = "";
    public static boolean f857i = false;
    public static ArrayList<String> f858j = new ArrayList();
    public static boolean f859k = false;
    public static boolean f860l = false;
    public static boolean f861m = false;
    static Handler f862n = new Handler();
    private static TextToSpeech f863r;
    private static SpeechRecognizer f864s;
    private static String f865v = "";
    private static boolean f866w = false;
    private static boolean f867x = false;
    private static boolean f868y = false;
    private static boolean f869z = false;
    private boolean f870A = false;
    private PhoneStateListener f871H = new me(this);
    final Runnable f872o = new mc(this);
    final Runnable f873p = new md(this);
    BroadcastReceiver f874q = new mf(this);
    private TelephonyManager f875t;
    private final String f876u = "android.provider.Telephony.SMS_RECEIVED";

    public static void m911a() {
        if (hc.f1269b) {
            ls.m1345b("stopSpeech");
        }
        GlobalV.m899w(false);
        if (f863r != null) {
            f868y = false;
            f869z = false;
            try {
                f863r.stop();
            } catch (Exception e) {
                if (hc.f1269b) {
                    ls.m1348e("stopSpeech");
                }
                e.printStackTrace();
            }
        }
    }

    public static void m913a(Context context, int i) {
        if (hc.f1269b) {
            ls.m1346c("STTS playSilence");
        }
        if (f854f) {
            ((Vibrator) context.getSystemService("vibrator")).vibrate(70);
        }
        if (f853e == null) {
            f853e = new HashMap();
        }
        f863r.setOnUtteranceCompletedListener(f851c);
        f853e.put("utteranceId", "QS");
        f863r.playSilence((long) i, 1, f853e);
    }

    public static void m914a(Context context, String str) {
        if (hc.f1269b) {
            ls.m1346c("STTS myToast");
        }
        Toast.makeText(context, str, 0).show();
    }

    static /* synthetic */ void m916a(ServiceTTS serviceTTS) {
        if (hc.f1269b) {
            ls.m1346c("AA tidyUp");
        }
        new he(serviceTTS).m1067a(GlobalV.m798K());
    }

    public static void m918a(String str) {
        if (hc.f1269b) {
            ls.m1346c("in longSpeak");
        }
        if (f857i) {
            m944w();
        } else if (f866w) {
            if (hc.f1269b) {
                ls.m1347d("recogs: " + f866w);
            }
            f843B = true;
            m920b();
        } else {
            if (GlobalV.m872n()) {
                if (hc.f1269b) {
                    ls.m1346c("gvsCheck: true");
                }
                GlobalV.m832d(false);
                f849a.sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, new GVSLanguage(), null, 69, null, null);
            }
            if (f853e == null) {
                f853e = new HashMap();
            }
            f869z = true;
            if (str == null) {
                str = "";
            }
            if (f863r == null) {
                if (hc.f1269b) {
                    ls.m1347d("longSpeak: tts == null : binding TTS");
                }
                f865v = str;
                f863r = new TextToSpeech(f849a, f852d);
                return;
            }
            if (hc.f1269b) {
                ls.m1346c("longSpeak: tts != null : binded");
            }
            if (ke.m1284a(f849a)) {
                if (hc.f1269b) {
                    ls.m1346c("shouldSpeak: true");
                }
                if (f863r.isSpeaking()) {
                    if (hc.f1269b) {
                        ls.m1347d("tts.isSpeaking");
                    }
                    m911a();
                }
                if (GlobalV.ap()) {
                    Context context = f849a;
                    lt.m1352a(context, "utter! is reading...", "utter!", "Click to stop speech", 17301539, false, 0, 1);
                }
                if (hc.f1269b) {
                    ls.m1344a("longSpeak - myWords: " + str);
                }
                ly.m1458a(f849a, f863r, false, false);
                f863r.setOnUtteranceCompletedListener(f851c);
                if (lx.ao(f849a) && VERSION.SDK_INT >= 16 && hw.m1147a(f849a) && ly.m1462a(str)) {
                    if (hc.f1269b) {
                        ls.m1346c("gnVoice & Jelly Bean & network ok");
                    }
                    f853e.put("networkTts", "true");
                } else if (hc.f1269b) {
                    ls.m1346c("gnVoice & Jelly Bean & network: FALSE");
                }
                double g = nm.m1503g(f849a);
                if (g != 0.0d) {
                    f853e.put("volume", String.valueOf(g));
                }
                f853e.put("utteranceId", "LS");
                f863r.speak(str, 1, f853e);
                if (hc.f1269b) {
                    ls.m1345b("Uterrance longSpeak started");
                    return;
                }
                return;
            }
            if (hc.f1269b) {
                ls.m1347d("shouldSpeak: false");
            }
            m914a(f849a, str);
            f863r.setOnUtteranceCompletedListener(f851c);
            f853e.put("utteranceId", "LS");
            f863r.speak("", 1, f853e);
            if (hc.f1269b) {
                ls.m1345b("Uterrance longSpeak silence");
            }
        }
    }

    public static void m920b() {
        f866w = false;
        if (hc.f1269b) {
            ls.m1344a("cancelListener Setting recogs: " + f866w);
        }
        try {
            if (hc.f1269b) {
                ls.m1346c("cancelListener try");
            }
            f864s.cancel();
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("Failed to cancel recogniser: " + e.getMessage());
            }
        }
        if (f861m) {
            f861m = false;
            m925d();
        }
        GlobalV.m815a();
        lt.m1349a(1);
    }

    public static void m921b(String str) {
        if (hc.f1269b) {
            ls.m1346c("in quickSpeak");
        }
        if (f857i) {
            m944w();
        } else if (f866w) {
            if (hc.f1269b) {
                ls.m1347d("recogs: " + f866w);
            }
            f843B = true;
            m920b();
        } else {
            if (f853e == null) {
                f853e = new HashMap();
            }
            String C = GlobalV.m789C();
            if (C == null) {
                C = "";
            } else if (C.isEmpty()) {
                C = "";
            }
            if (str == null) {
                str = "";
            }
            if (!(str.replaceAll("[^a-zA-Z]", "").matches(C.replaceAll("[^a-zA-Z]", "")) || str.startsWith("I said. "))) {
                GlobalV.m867m(str);
            }
            f868y = true;
            if (f863r == null) {
                if (hc.f1269b) {
                    ls.m1347d("quickSpeak: tts == null : binding TTS");
                }
                f865v = str;
                f863r = new TextToSpeech(f849a, f852d);
                return;
            }
            if (hc.f1269b) {
                ls.m1346c("quickSpeak: tts != null : binded");
            }
            if (ke.m1284a(f849a)) {
                if (hc.f1269b) {
                    ls.m1346c("shouldSpeak: true");
                }
                if (f863r.isSpeaking() && !GlobalV.ad()) {
                    if (hc.f1269b) {
                        ls.m1347d("tts.isSpeaking");
                    }
                    m911a();
                }
                if (GlobalV.ap()) {
                    Context context = f849a;
                    lt.m1352a(context, "utter! is reading...", "utter!", "Click to stop speech", 17301539, false, 0, 1);
                }
                if (GlobalV.m813Z()) {
                    ly.m1458a(f849a, f863r, false, true);
                    lt.m1352a(f849a, f856h, "utter!", "Click to stop speech", 17301539, false, 0, 1);
                } else {
                    ly.m1458a(f849a, f863r, false, false);
                }
                if (hc.f1269b) {
                    ls.m1344a("quickSpeak - myWords: " + str);
                }
                f863r.setOnUtteranceCompletedListener(f851c);
                if (lx.ao(f849a) && VERSION.SDK_INT >= 16 && hw.m1147a(f849a) && ly.m1462a(str)) {
                    if (hc.f1269b) {
                        ls.m1346c("gnVoice & Jelly Bean & network");
                    }
                    f853e.put("networkTts", "true");
                } else if (hc.f1269b) {
                    ls.m1346c("gnVoice & Jelly Bean & network unavailable");
                }
                double g = nm.m1503g(f849a);
                if (g != 0.0d) {
                    f853e.put("volume", String.valueOf(g));
                }
                f853e.put("utteranceId", "QS");
                f863r.speak(str, 1, f853e);
                if (hc.f1269b) {
                    ls.m1345b("Uterrance quickSpeak started");
                    return;
                }
                return;
            }
            if (hc.f1269b) {
                ls.m1347d("shouldSpeak: false");
            }
            m914a(f849a, str);
            f863r.setOnUtteranceCompletedListener(f851c);
            f853e.put("utteranceId", "QS");
            f863r.speak("", 1, f853e);
            if (hc.f1269b) {
                ls.m1345b("Uterrance quickSpeak silence");
            }
        }
    }

    public static boolean m924c() {
        return f848G != null;
    }

    public static boolean m925d() {
        Exception exception;
        Exception exception2;
        if (hc.f1269b) {
            ls.m1346c("beginForeground");
        }
        boolean an = lx.an(f849a);
        Intent intent;
        PendingIntent activity;
        C0052z c0052z;
        if (f861m) {
            if (!f847F) {
                intent = new Intent(f849a, LauncherShortcutActivity.class);
                intent.addFlags(268435456);
                intent.addFlags(262144);
                intent.addFlags(32768);
                activity = PendingIntent.getActivity(f849a, 76, intent, 134217728);
                c0052z = new C0052z(f849a);
                c0052z.f208d = activity;
                C0052z a = c0052z.m165a((int) R.drawable.utternoto).m167a((CharSequence) "utter! Wake-up active").m166a(System.currentTimeMillis());
                a.f206b = "utter! Wake-up active";
                a.f207c = "tap to stop...";
                try {
                    ((Service) f849a).startForeground(76, c0052z.m170b());
                    try {
                        if (!lx.ad(f849a)) {
                            lx.m1437k(f849a, true);
                            ly.m1465b(f849a, 13000, true);
                        }
                        f847F = true;
                        return true;
                    } catch (Exception e) {
                        exception = e;
                        an = true;
                        exception2 = exception;
                        if (hc.f1269b) {
                            ls.m1348e("beginForeground failure");
                        }
                        exception2.printStackTrace();
                        return an;
                    }
                } catch (Exception e2) {
                    exception2 = e2;
                    an = false;
                    if (hc.f1269b) {
                        ls.m1348e("beginForeground failure");
                    }
                    exception2.printStackTrace();
                    return an;
                }
            } else if (!hc.f1269b) {
                return false;
            } else {
                ls.m1346c("wupNotification already active");
                return false;
            }
        } else if (an) {
            if (hc.f1269b) {
                ls.m1347d("using notHack");
            }
            intent = new Intent(f849a, LauncherShortcutActivity.class);
            intent.addFlags(268435456);
            intent.addFlags(262144);
            intent.addFlags(32768);
            activity = PendingIntent.getActivity(f849a, 76, intent, 134217728);
            c0052z = new C0052z(f849a);
            Notification b = c0052z.m170b();
            b.contentIntent = activity;
            b.flags = 96;
            c0052z.f208d = activity;
            c0052z.m165a((int) R.drawable.utternot).m167a((CharSequence) "utter! has become self aware...").m166a(System.currentTimeMillis()).f206b = "utter!";
            c0052z.f207c = "AI level: " + String.valueOf(C0142a.m969a(f849a));
            try {
                ((Service) f849a).startForeground(76, b);
                try {
                    if (!lx.ad(f849a)) {
                        lx.m1437k(f849a, true);
                        ly.m1465b(f849a, 13000, true);
                    }
                    f847F = false;
                    return true;
                } catch (Exception e22) {
                    exception = e22;
                    an = true;
                    exception2 = exception;
                    if (hc.f1269b) {
                        ls.m1348e("beginForeground failure");
                    }
                    exception2.printStackTrace();
                    return an;
                }
            } catch (Exception e222) {
                exception2 = e222;
                an = false;
                if (hc.f1269b) {
                    ls.m1348e("beginForeground failure");
                }
                exception2.printStackTrace();
                return an;
            }
        } else {
            intent = new Intent(f849a, LauncherShortcutActivity.class);
            intent.addFlags(268435456);
            intent.addFlags(262144);
            intent.addFlags(32768);
            activity = PendingIntent.getActivity(f849a, 76, intent, 134217728);
            c0052z = new C0052z(f849a);
            c0052z.f208d = activity;
            c0052z.m165a((int) R.drawable.utternot).m167a((CharSequence) "utter! has become self aware...").m166a(System.currentTimeMillis()).f206b = "utter!";
            double a2 = C0142a.m969a(f849a);
            Context context = f849a;
            Editor edit = context.getSharedPreferences("utterPref", 0).edit();
            edit.putString("ai_level", String.valueOf(a2));
            edit.commit();
            lx.ar(context);
            if (a2 > 1.13d) {
                c0052z.f207c = "AI level: " + String.valueOf(a2) + f849a.getResources().getString(R.string.power_user);
            } else {
                c0052z.f207c = "AI level: " + String.valueOf(a2);
            }
            try {
                ((Service) f849a).startForeground(76, c0052z.m170b());
                try {
                    if (!lx.ad(f849a)) {
                        lx.m1437k(f849a, true);
                        ly.m1465b(f849a, 13000, true);
                    }
                    f847F = false;
                    return true;
                } catch (Exception e2222) {
                    exception = e2222;
                    an = true;
                    exception2 = exception;
                    if (hc.f1269b) {
                        ls.m1348e("beginForeground failure");
                    }
                    exception2.printStackTrace();
                    return an;
                }
            } catch (Exception e22222) {
                exception2 = e22222;
                an = false;
                if (hc.f1269b) {
                    ls.m1348e("beginForeground failure");
                }
                exception2.printStackTrace();
                return an;
            }
        }
    }

    public static String m926e() {
        if (f863r != null) {
            try {
                return f863r.getDefaultEngine();
            } catch (Exception e) {
                if (hc.f1269b) {
                    ls.m1347d("STTS getEngine: engine null");
                }
                return "";
            }
        }
        if (hc.f1269b) {
            ls.m1347d("STTS getEngine: tts null");
        }
        return "";
    }

    static /* synthetic */ void m931j() {
        if (hc.f1269b) {
            ls.m1346c("freeForm");
        }
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        String string;
        if (GlobalV.m788B() && lx.aj(f849a)) {
            if (hc.f1269b) {
                ls.m1346c("user Locale: true");
            }
            string = f849a.getSharedPreferences("utterPref", 0).getString("native_locale_value", "");
            if (!(string == null || string.matches(""))) {
                intent.putExtra("android.speech.extra.LANGUAGE", string);
            }
        } else if (!GlobalV.m905y() || GlobalV.m891u().matches("")) {
            string = GlobalV.m873o();
            if (string == null) {
                f849a.sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, new GVSLanguage(), null, 69, null, null);
            } else if (!string.startsWith(QueryParamConst.HL_VALUE)) {
                if (hc.f1269b) {
                    ls.m1347d("gvsLanguage NOT English: " + string);
                }
                lt.m1350a(f849a);
                intent.putExtra("android.speech.extra.LANGUAGE", "en-US");
                GlobalV.m832d(true);
            } else if (hc.f1269b) {
                ls.m1346c("gvsLanguage English: " + string);
            }
        } else {
            if (hc.f1269b) {
                ls.m1346c("user shortcut Locale: true");
            }
            intent.putExtra("android.speech.extra.LANGUAGE", GlobalV.m891u());
        }
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("calling_package", "com.brandall.nutter");
        if (f861m) {
            intent.putExtra("android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS", Long.valueOf(100000000));
            intent.putExtra("android.speech.extras.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS", Long.valueOf(100000000));
        } else if (lx.m1370I(f849a) && lx.m1369H(f849a) != 0) {
            intent.putExtra("android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS", Long.valueOf(((long) lx.m1369H(f849a)) * 1000));
        }
        intent.putExtra("android.speech.extra.PROMPT", "uttering!");
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        try {
            if (hc.f1269b) {
                ls.m1346c("freeForm try");
            }
            if (f861m && !f847F) {
                m925d();
            }
            f864s.startListening(intent);
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("recognizer.startListening Exception");
            }
            e.printStackTrace();
            if (f861m) {
                nm.m1502f(f849a);
                f861m = false;
                m925d();
            }
            m914a(f849a, "Something's wrong. Please check your Google Voice Search installation.");
            m921b("Something's wrong. Please check your Google Voice Search installation.");
        }
        GlobalV.m860k(false);
        GlobalV.m852i(false);
        ly.f1701b = Locale.ENGLISH;
        ly.f1700a = false;
        GlobalV.m847h(false);
    }

    private static void m943v() {
        if (hc.f1269b) {
            ls.m1346c("resetVariables");
        }
        if (f854f) {
            nl.m1496a(f849a);
        }
        GlobalV.m786B("");
        GlobalV.m907z(false);
        GlobalV.m904y(false);
        f865v = "";
        f868y = false;
        f869z = false;
        f867x = false;
        ly.f1701b = Locale.ENGLISH;
        ly.f1700a = false;
        GlobalV.m860k(false);
        GlobalV.m852i(false);
        GlobalV.m847h(false);
    }

    private static void m944w() {
        if (hc.f1269b) {
            ls.m1346c("soundEffectCondition: " + f857i);
            ls.m1344a("arraySEOrder: " + f858j.size() + " : " + f858j.toString());
        }
        f857i = false;
        f860l = true;
        f845D = f858j.size() - 1;
        if (hc.f1269b) {
            ls.m1344a("getting entry:" + f844C + " of " + f845D);
        }
        if (f858j.size() > f844C) {
            String str = (String) f858j.get(f844C);
            if (str.startsWith("/")) {
                f844C++;
                if (f850b != null) {
                    f850b = new MediaPlayer();
                }
                MediaPlayer create = MediaPlayer.create(f849a, Uri.parse("file://" + str));
                f850b = create;
                create.start();
                f850b.setOnCompletionListener(new mg());
                return;
            } else if (f845D == f844C) {
                if (f850b != null) {
                    f850b.release();
                }
                if (f859k) {
                    f860l = false;
                    m918a(str);
                } else {
                    f860l = false;
                    m921b(str);
                }
                m945x();
                return;
            } else {
                f844C++;
                m921b(str);
                return;
            }
        }
        if (hc.f1269b) {
            ls.m1347d("arraySEOrder.size() <= loopCount");
        }
        if (f850b != null) {
            f850b.release();
        }
        m945x();
    }

    private static void m945x() {
        if (hc.f1269b) {
            ls.m1346c("resetStatic");
        }
        f858j.clear();
        f845D = 0;
        f844C = 0;
        f859k = false;
        f857i = false;
        f860l = false;
        ly.f1701b = Locale.ENGLISH;
        ly.f1700a = false;
        lt.m1349a(1);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        if (hc.f1269b) {
            ls.m1346c("TTS onCreate");
        }
        f851c = this;
        f852d = this;
        f849a = this;
        f848G = this;
        this.f875t = (TelephonyManager) getSystemService("phone");
        this.f875t.listen(this.f871H, 32);
        registerReceiver(this.f874q, new IntentFilter("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE"), null, null);
        registerReceiver(this.f874q, new IntentFilter("android.intent.action.SCREEN_ON"), null, null);
        registerReceiver(this.f874q, new IntentFilter("android.intent.action.SCREEN_OFF"), null, null);
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        intentFilter.setPriority(999);
        registerReceiver(this.f874q, intentFilter);
        m925d();
    }

    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("TTS onDestroy");
        }
        f848G = null;
        try {
            f849a.unregisterReceiver(this.f874q);
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("unregisterReceiver Exception");
            }
            e.printStackTrace();
        }
        try {
            this.f875t.listen(this.f871H, 0);
        } catch (Exception e2) {
            if (hc.f1269b) {
                ls.m1348e("PhoneStateListener.LISTEN_NONE Exception");
            }
            e2.printStackTrace();
        }
        lt.m1349a(1);
        GlobalV.m815a();
        try {
            f867x = false;
            f866w = false;
            if (hc.f1269b) {
                ls.m1344a("destroyListener Setting recogError: " + f867x);
                ls.m1344a("destroyListener Setting recogs: " + f866w);
            }
            try {
                f864s.cancel();
            } catch (Exception e22) {
                if (hc.f1269b) {
                    ls.m1348e("Failed to cancel recogniser: " + e22.getMessage());
                }
            }
            try {
                f864s.destroy();
            } catch (Exception e222) {
                if (hc.f1269b) {
                    ls.m1348e("Failed to destroy recogniser: " + e222.getMessage());
                }
            }
            GlobalV.m815a();
            lt.m1349a(1);
        } catch (Exception e2222) {
            if (hc.f1269b) {
                ls.m1348e("destroyListener Exception");
            }
            e2222.printStackTrace();
        }
        if (f863r != null) {
            try {
                f863r.stop();
                f863r.shutdown();
            } catch (Exception e22222) {
                if (hc.f1269b) {
                    ls.m1348e("TTS Exception");
                }
                e22222.getStackTrace();
            }
        }
        try {
            f863r = null;
        } catch (Exception e222222) {
            if (hc.f1269b) {
                ls.m1348e("TTS to null Exception");
            }
            e222222.printStackTrace();
        }
    }

    public void onInit(int i) {
        switch (i) {
            case -1:
                if (hc.f1269b) {
                    ls.m1347d("TextToSpeech.ERROR");
                }
                if (f868y) {
                    if (hc.f1269b) {
                        ls.m1346c("quickSpeech: true");
                    }
                } else if (f869z && hc.f1269b) {
                    ls.m1346c("longSpeech: true");
                }
                m914a(f849a, "Text-To-Speech initialisation failed");
                GlobalV.m815a();
                m943v();
                return;
            case 0:
                try {
                    String defaultEngine = f863r.getDefaultEngine();
                    if (hc.f1269b) {
                        ls.m1346c("TextToSpeech.SUCCESS: initialised " + defaultEngine);
                    }
                    Editor edit = f849a.getSharedPreferences("utterPref", 0).edit();
                    edit.putString("init_engine", defaultEngine);
                    edit.commit();
                } catch (Exception e) {
                    if (hc.f1269b) {
                        ls.m1344a("TTS onInit - failed to get engine name");
                    }
                }
                if (f868y) {
                    if (hc.f1269b) {
                        ls.m1346c("quickSpeech: true");
                    }
                    if (f865v == null) {
                        m921b(null);
                        return;
                    } else if (f865v.matches("")) {
                        m921b(null);
                        return;
                    } else {
                        m921b(f865v);
                        return;
                    }
                } else if (f869z) {
                    if (hc.f1269b) {
                        ls.m1346c("longSpeech: true");
                    }
                    if (f865v == null) {
                        m918a(null);
                        return;
                    } else if (f865v.matches("")) {
                        m918a(null);
                        return;
                    } else {
                        m918a(f865v);
                        return;
                    }
                } else {
                    return;
                }
            default:
                if (hc.f1269b) {
                    ls.m1348e("TextToSpeech.ERROR / TextToSpeech.SUCCESS");
                }
                m914a(f849a, "Text-To-Speech initialisation failed");
                GlobalV.m815a();
                m943v();
                return;
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (hc.f1269b) {
            ls.m1346c("TTS onStartCommand");
        }
        f851c = this;
        f852d = this;
        f849a = this;
        if (intent != null) {
            if (hc.f1269b) {
                ls.m1346c("TTS ttsIdata != null");
            }
            if (lx.ab(this)) {
                try {
                    String stringExtra = intent.getStringExtra("INT_DATA");
                    if (stringExtra.matches("HOME")) {
                        if (hc.f1269b) {
                            ls.m1346c("HOME intData: HOME");
                        }
                        if (f863r == null) {
                            if (hc.f1269b) {
                                ls.m1347d("HOME onStartCommand: tts == null : binding TTS");
                            }
                            f863r = new TextToSpeech(f849a, f852d);
                        } else if (hc.f1269b) {
                            ls.m1346c("HOME onStartCommand: tts != null : binded");
                        }
                    } else if (stringExtra.matches("INIT")) {
                        if (hc.f1269b) {
                            ls.m1346c("INIT intData: INIT");
                        }
                        if (intent.getBooleanExtra("START_RECOG", false)) {
                            if (hc.f1269b) {
                                ls.m1346c("startRecognizer longSpeak: true");
                            }
                            m918a(intent.getStringExtra("SPEECH_DATA"));
                        } else {
                            if (hc.f1269b) {
                                ls.m1346c("startRecognizer longSpeak: false");
                            }
                            m921b(intent.getStringExtra("SPEECH_DATA"));
                        }
                    } else if (hc.f1269b) {
                        ls.m1347d("TTS unknown INIT: " + stringExtra);
                    }
                } catch (Exception e) {
                    if (hc.f1269b) {
                        ls.m1347d("TTS initData FAIL: " + e.getMessage());
                    }
                }
            } else if (!id.m1166b(f849a)) {
                m921b("You need to accept the application disclaimer before you can use utter!");
                jy.m1242c(f849a);
            }
        } else {
            if (hc.f1269b) {
                ls.m1347d("TTS ttsIdata == null");
            }
            if (lx.ab(this)) {
                if (f863r == null) {
                    if (hc.f1269b) {
                        ls.m1347d("onStartCommand: tts == null : binding TTS");
                    }
                    f863r = new TextToSpeech(f849a, f852d);
                } else if (hc.f1269b) {
                    ls.m1346c("onStartCommand: tts != null : binded");
                }
            } else if (!id.m1166b(f849a)) {
                m921b("You need to accept the application disclaimer before you can use utter!");
                jy.m1242c(f849a);
            }
            lt.m1349a(1);
            GlobalV.m815a();
        }
        return 1;
    }

    public void onUtteranceCompleted(String str) {
        if (hc.f1269b) {
            ls.m1345b("TTSS-UC");
        }
        f853e.clear();
        if (str.equals("LS")) {
            if (hc.f1269b) {
                ls.m1345b("Uterrance LS Complete");
            }
            f869z = false;
            f862n.post(this.f872o);
        } else if (str.equals("QS")) {
            if (hc.f1269b) {
                ls.m1345b("Uterrance QS Complete");
            }
            f868y = false;
            f862n.post(this.f873p);
        } else if (f868y) {
            f862n.post(this.f873p);
        } else {
            f862n.post(this.f872o);
        }
    }
}
