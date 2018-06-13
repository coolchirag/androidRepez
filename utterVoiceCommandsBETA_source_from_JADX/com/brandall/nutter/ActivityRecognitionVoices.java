package com.brandall.nutter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.Vibrator;
import android.util.Log;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.att.android.speech.ATTSpeechActivity;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;
import com.nuance.nmdp.speechkit.Prompt;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.Recognizer.RecognizerType;
import com.nuance.nmdp.speechkit.SpeechKit;
import com.nuance.nmdp.speechkit.Vocalizer;
import com.nuance.nmdp.speechkit.Vocalizer.Listener;
import java.util.ArrayList;
import org.ispeech.FreeformType;
import org.ispeech.SpeechRecognizer;
import org.ispeech.SpeechSynthesis;
import org.ispeech.error.BusyException;
import org.ispeech.error.InvalidApiKeyException;
import org.ispeech.error.NoNetworkException;
import wei.mark.standout.StandOutWindow;

public class ActivityRecognitionVoices extends Activity {
    static Activity f701b;
    private static String f702k = null;
    UITableView f703a;
    SpeechSynthesis f704c;
    SpeechRecognizer f705d;
    Listener f706e;
    Vocalizer f707f;
    SpeechKit f708g;
    private AdView f709h;
    private Object f710i = null;
    private boolean f711j = true;
    private Recognizer f712l = null;
    private ll f713m = null;
    private Handler f714n = null;
    private Recognizer.Listener f715o = new dv(this);

    public static void m634a() {
        ls.m1346c("attWatson");
        Intent intent = new Intent(f701b, ATTSpeechActivity.class);
        intent.putExtra("att.speech.extra.REQUEST_URL", "https://api.att.com/rest/1/SpeechToText");
        intent.putExtra("att.speech.extra.SPEECH_CONTEXT", "Generic");
        intent.putExtra("att.speech.extra.BEARER_AUTH_TOKEN", f702k);
        f701b.startActivityForResult(intent, 42);
        Log.v("SimpleSpeech", "Starting speech interaction");
        ((Vibrator) f701b.getSystemService("vibrator")).vibrate(70);
    }

    static /* synthetic */ void m635a(ActivityRecognitionVoices activityRecognitionVoices) {
        if (activityRecognitionVoices.f704c == null) {
            try {
                activityRecognitionVoices.f704c = SpeechSynthesis.getInstance(activityRecognitionVoices);
                activityRecognitionVoices.f704c.setSpeechSynthesisEvent(new dx(activityRecognitionVoices));
            } catch (InvalidApiKeyException e) {
                ls.m1348e("Invalid API key\n" + e.getStackTrace());
            }
        }
        try {
            activityRecognitionVoices.f704c.speak("Please say some random words");
        } catch (BusyException e2) {
            ls.m1348e("SDK is busy");
            e2.printStackTrace();
        } catch (NoNetworkException e3) {
            ls.m1348e("Network is not available\n" + e3.getStackTrace());
        }
    }

    private void m638b() {
        this.f713m = new ll(this);
        this.f713m.setOnDismissListener(new dw(this));
    }

    static /* synthetic */ void m639b(ActivityRecognitionVoices activityRecognitionVoices) {
        activityRecognitionVoices.f707f = activityRecognitionVoices.f708g.createVocalizerWithVoice("Samantha", activityRecognitionVoices.f706e, new Handler());
        activityRecognitionVoices.f710i = new Object();
        activityRecognitionVoices.f707f.speakString("Please say some random words", activityRecognitionVoices.f710i);
    }

    private void m640c() {
        ls.m1346c("iSpeech setupFreeFormDictation.");
        try {
            this.f705d = SpeechRecognizer.getInstance(this);
            this.f705d.setFreeForm(FreeformType.FREEFORM_DICTATION);
        } catch (InvalidApiKeyException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void m641c(ActivityRecognitionVoices activityRecognitionVoices) {
        lc.m1313a(activityRecognitionVoices, true, "Please say some random words");
        GlobalV.m839f(true);
    }

    static /* synthetic */ void m642d(ActivityRecognitionVoices activityRecognitionVoices) {
        GlobalV.m835e(true);
        lc.m1313a(activityRecognitionVoices, false, "Please say some random words");
    }

    static /* synthetic */ void m643e(ActivityRecognitionVoices activityRecognitionVoices) {
        ls.m1345b("In tts output");
        if (!jy.m1223C(activityRecognitionVoices, "ttsSettings")) {
            lc.m1313a(activityRecognitionVoices, false, "I don't seem to be able to access those settings");
        }
    }

    static /* synthetic */ void m644f(ActivityRecognitionVoices activityRecognitionVoices) {
        ls.m1345b("In voice search");
        if (!jy.m1223C(activityRecognitionVoices, "voiceSearchSettings")) {
            lc.m1313a(activityRecognitionVoices, false, "I don't seem to be able to access those settings");
        }
    }

    static /* synthetic */ void m645g(ActivityRecognitionVoices activityRecognitionVoices) {
        ls.m1346c("ivonaMain");
        activityRecognitionVoices.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.ivona.tts")));
    }

    static /* synthetic */ void m646h(ActivityRecognitionVoices activityRecognitionVoices) {
        ls.m1346c("ivonaEN");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.ivona.tts.voicebeta.eng.gbr.amy"));
        intent.addFlags(268435456);
        activityRecognitionVoices.startActivity(intent);
    }

    static /* synthetic */ void m647i(ActivityRecognitionVoices activityRecognitionVoices) {
        ls.m1346c("ivonaUS");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.ivona.tts.voicebeta.eng.usa.kendra"));
        intent.addFlags(268435456);
        activityRecognitionVoices.startActivity(intent);
    }

    static /* synthetic */ void m648j(ActivityRecognitionVoices activityRecognitionVoices) {
        ls.m1346c("svoxMain");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.svox.classic"));
        intent.addFlags(268435456);
        activityRecognitionVoices.startActivity(intent);
    }

    static /* synthetic */ void m649k(ActivityRecognitionVoices activityRecognitionVoices) {
        ls.m1346c("svoxEN");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.svox.classic.langpack.eng_gbr_fem_trial"));
        intent.addFlags(268435456);
        activityRecognitionVoices.startActivity(intent);
    }

    static /* synthetic */ void m650l(ActivityRecognitionVoices activityRecognitionVoices) {
        ls.m1346c("svoxUS");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.svox.classic.langpack.eng_usa_fem_trial"));
        intent.addFlags(268435456);
        activityRecognitionVoices.startActivity(intent);
    }

    static /* synthetic */ void m651m(ActivityRecognitionVoices activityRecognitionVoices) {
        ls.m1346c("GVS");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.voicesearch"));
        intent.addFlags(268435456);
        activityRecognitionVoices.startActivity(intent);
    }

    static /* synthetic */ void m653o(ActivityRecognitionVoices activityRecognitionVoices) {
        activityRecognitionVoices.f712l = activityRecognitionVoices.f708g.createRecognizer(RecognizerType.Dictation, 2, "en_US", activityRecognitionVoices.f715o, activityRecognitionVoices.f714n);
        activityRecognitionVoices.f712l.start();
    }

    static /* synthetic */ void m658t(ActivityRecognitionVoices activityRecognitionVoices) {
        ls.m1346c("iSpeech startRecognition.");
        activityRecognitionVoices.m640c();
        try {
            ls.m1346c("iSpeech startRecognition: try");
            activityRecognitionVoices.f705d.startRecord(new dy(activityRecognitionVoices));
        } catch (BusyException e) {
            e.printStackTrace();
        } catch (NoNetworkException e2) {
            e2.printStackTrace();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 42) {
            return;
        }
        if (i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
            stringArrayListExtra.add("**PLUGIN AVAILABLE SOON!**");
            GlobalV.m823b(stringArrayListExtra);
            StandOutWindow.m741a(getApplicationContext(), VoiceResultsWindow.class, 0);
            String str = null;
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                str = (String) stringArrayListExtra.get(0);
            }
            if (str == null || str.length() <= 0) {
                Log.v("SimpleSpeech", "Recognized no hypotheses.");
            } else {
                Log.v("SimpleSpeech", "Recognized " + stringArrayListExtra.size() + str);
            }
        } else if (i2 == 0) {
            Log.v("SimpleSpeech", "User canceled.");
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ls.m1345b("Landscape");
        } else if (configuration.orientation == 1) {
            ls.m1345b("Portrait");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ls.m1346c("ActivityRecognitionVoices onCreate");
        setContentView(R.layout.voices_layout);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        ly.m1460a(this, 12000, true);
        this.f709h = (AdView) findViewById(R.id.adView);
        this.f703a = (UITableView) findViewById(R.id.tableView);
        ls.m1346c("VoicesActivity createList");
        this.f703a.setClickListener(new dz());
        C0090a c0090a = new C0090a("iSpeech");
        c0090a.f297e = "Click to sample";
        c0090a.f294b = R.drawable.ispeech;
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("Dragon Nuance");
        c0090a.f297e = "Click to sample";
        c0090a.f294b = R.drawable.dragonnuance;
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("Google Voice Search");
        c0090a.f297e = "Click to sample";
        c0090a.f294b = R.drawable.voicesearchround;
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("AT&T Watson");
        c0090a.f297e = "Click to sample";
        c0090a.f294b = R.drawable.att;
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("Text-To-Speech Settings");
        c0090a.f294b = R.drawable.texttospeech;
        c0090a.f297e = "android shortcut";
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("Voice Search Settings");
        c0090a.f294b = R.drawable.voicesearchround;
        c0090a.f297e = "android shortcut";
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("IVONA");
        c0090a.f297e = "Main Engine";
        c0090a.f294b = R.drawable.ivona;
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("IVONA");
        c0090a.f297e = "English United Kingdom";
        c0090a.f294b = R.drawable.ivona_en;
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("IVONA");
        c0090a.f297e = "English USA";
        c0090a.f294b = R.drawable.ivona_us;
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("SVOX");
        c0090a.f297e = "Main Engine";
        c0090a.f294b = R.drawable.svox;
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("SVOX");
        c0090a.f297e = "English United Kingdom";
        c0090a.f294b = R.drawable.svox_uk;
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("SVOX");
        c0090a.f297e = "English USA";
        c0090a.f294b = R.drawable.svox_us;
        this.f703a.m292a(c0090a);
        c0090a = new C0090a("Google Voice Search");
        c0090a.f297e = "Install latest version";
        c0090a.f294b = R.drawable.gvs;
        this.f703a.m292a(c0090a);
        this.f703a.m291a();
        f701b = this;
        this.f711j = false;
        m638b();
        m640c();
        mq a = mq.m1483a("https://api.att.com/oauth/token", "819eb03609732ce50ce4f8f2068d5d81", "792b323f704f4fae");
        a.f1733a = new ea();
        new mr(a, a.f1734b.getURL().toString(), new Handler()).start();
        this.f708g = SpeechKit.initialize(getApplication().getApplicationContext(), "NMDPTRIAL_brandall20120605082447", "sandbox.nmdp.nuancemobility.net", 443, false, gt.f1250a);
        this.f708g.connect();
        this.f708g.setDefaultRecognizerPrompts(this.f708g.defineAudioPrompt(R.raw.beep), Prompt.vibration(100), null, null);
        this.f706e = new du(this);
        C0227h a2 = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
        }
        c0237d.m1636a(a2);
        this.f709h.m1593a(c0237d);
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                return this.f713m;
            default:
                return null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("ActivityRecognitionVoices onDestroy");
        getWindow().clearFlags(128);
        if (!lx.aa(this)) {
            ly.m1460a(this, 12000, false);
        }
        if (this.f709h != null) {
            this.f709h.removeAllViews();
            this.f709h.m1592a();
        }
        try {
            this.f711j = true;
            if (this.f712l != null) {
                this.f712l.cancel();
                this.f712l = null;
            }
            if (this.f704c != null) {
                this.f704c.stop();
            }
            if (this.f705d != null) {
                this.f705d.cancelProcessing();
                this.f705d.cancelRecord();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (hc.f1269b) {
                ls.m1347d("Failed to destroy listeners");
            }
        }
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("ActivityRecognitionVoices onPause");
        try {
            if (this.f704c != null) {
                this.f704c.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (hc.f1269b) {
                ls.m1347d("Failed to stop synthesis");
            }
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 0:
                this.f713m.m1320a(new dt(this));
                return;
            default:
                return;
        }
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("ActivityRecognitionVoices onResume");
        if (ServiceTTS.f854f) {
            getWindow().addFlags(128);
        }
    }
}
