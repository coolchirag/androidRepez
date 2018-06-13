package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.google.ads.AdView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ActivityAdvancedSettings extends Activity {
    private UITableView f650a;
    private AdView f651b;
    private String f652c = "";
    private String f653d = "";

    static /* synthetic */ void m488a(ActivityAdvancedSettings activityAdvancedSettings) {
        if (hc.f1269b) {
            ls.m1346c("in shakeConfig");
        }
        Dialog dialog = new Dialog(activityAdvancedSettings);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activityAdvancedSettings.getSystemService("layout_inflater")).inflate(R.layout.shake_config_dialog_layout, (ViewGroup) activityAdvancedSettings.findViewById(R.id.scdl));
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.radioGroup1);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.radio0);
        radioButton.setTextColor(-1);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.radio1);
        radioButton2.setTextColor(-1);
        RadioButton radioButton3 = (RadioButton) inflate.findViewById(R.id.radio2);
        radioButton3.setTextColor(-1);
        RadioButton radioButton4 = (RadioButton) inflate.findViewById(R.id.radio3);
        radioButton4.setTextColor(-1);
        RadioButton radioButton5 = (RadioButton) inflate.findViewById(R.id.radio4);
        radioButton5.setTextColor(-1);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        dialog.setContentView(inflate);
        switch (lx.m1422f(activityAdvancedSettings)) {
            case 6:
                radioButton5.setChecked(true);
                break;
            case 8:
                radioButton4.setChecked(true);
                break;
            case 11:
                radioButton3.setChecked(true);
                break;
            case 14:
                radioButton2.setChecked(true);
                break;
            case 16:
                radioButton.setChecked(true);
                break;
        }
        dialog.setFeatureDrawableResource(3, R.drawable.shake);
        dialog.setTitle("Shake-to-Wake Config");
        dialog.show();
        dialog.setOnCancelListener(new C0145d(activityAdvancedSettings));
        button.setOnClickListener(new C0159o(activityAdvancedSettings, radioGroup, dialog));
        button2.setOnClickListener(new C0170z(activityAdvancedSettings, dialog));
        imageButton.setOnClickListener(new aa(activityAdvancedSettings));
    }

    static /* synthetic */ void m490a(ActivityAdvancedSettings activityAdvancedSettings, ArrayList arrayList, ArrayList arrayList2) {
        if (hc.f1269b) {
            ls.m1346c("langDialog");
        }
        lc.m1313a(activityAdvancedSettings, false, "Please select the language in which to compose your tweets, texts, emails and notes.");
        Builder builder = new Builder(activityAdvancedSettings);
        builder.setIcon(R.drawable.gvs);
        builder.setTitle("Select Language");
        builder.setInverseBackgroundForced(true);
        View listView = new ListView(activityAdvancedSettings);
        listView.setAdapter(new ArrayAdapter(activityAdvancedSettings, 17367043, 16908308, arrayList));
        builder.setNegativeButton("Cancel", new C0157m(activityAdvancedSettings));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new C0158n(activityAdvancedSettings, arrayList2, create));
        create.show();
    }

    private void m491a(String str, boolean z) {
        if (z) {
            ((Vibrator) getSystemService("vibrator")).vibrate(100);
        }
        Toast.makeText(this, str, 0).show();
    }

    private void m492a(ArrayList<Locale> arrayList) {
        if (hc.f1269b) {
            ls.m1346c("localeDialog");
        }
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.phrases);
        builder.setTitle("Select Voice Engine Locale");
        builder.setInverseBackgroundForced(true);
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Locale) it.next()).toString());
        }
        View listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter(this, 17367043, 16908308, arrayList2));
        builder.setOnCancelListener(new C0167w(this));
        builder.setNegativeButton("Cancel", new C0168x(this));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new C0169y(this, arrayList, create));
        create.show();
    }

    static /* synthetic */ void m493b(ActivityAdvancedSettings activityAdvancedSettings) {
        if (hc.f1269b) {
            ls.m1346c("in waveConfig");
        }
        Dialog dialog = new Dialog(activityAdvancedSettings);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activityAdvancedSettings.getSystemService("layout_inflater")).inflate(R.layout.wave_config_dialog_layout, (ViewGroup) activityAdvancedSettings.findViewById(R.id.wcdl));
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.radioGroup1);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.radio0);
        radioButton.setTextColor(-1);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.radio1);
        radioButton2.setTextColor(-1);
        RadioButton radioButton3 = (RadioButton) inflate.findViewById(R.id.radio2);
        radioButton3.setTextColor(-1);
        RadioButton radioButton4 = (RadioButton) inflate.findViewById(R.id.radio3);
        radioButton4.setTextColor(-1);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        int e = lx.m1419e(activityAdvancedSettings);
        if (e == 190) {
            radioButton2.setChecked(true);
        } else if (e == 250) {
            radioButton3.setChecked(true);
        } else if (e == 350) {
            radioButton4.setChecked(true);
        } else {
            radioButton.setChecked(true);
        }
        dialog.setContentView(inflate);
        dialog.setFeatureDrawableResource(3, R.drawable.waving_hands);
        dialog.setTitle("Wave-to-Wake Config");
        dialog.show();
        dialog.setOnCancelListener(new C0150h(activityAdvancedSettings));
        button.setOnClickListener(new C0151i(activityAdvancedSettings, radioGroup, dialog));
        button2.setOnClickListener(new C0153j(activityAdvancedSettings, dialog));
        imageButton.setOnClickListener(new C0155k(activityAdvancedSettings));
    }

    static /* synthetic */ void m495b(ActivityAdvancedSettings activityAdvancedSettings, ArrayList arrayList, ArrayList arrayList2) {
        if (hc.f1269b) {
            ls.m1346c("langDialog");
        }
        lc.m1313a(activityAdvancedSettings, false, "Please select the recognition language you require.");
        Builder builder = new Builder(activityAdvancedSettings);
        builder.setIcon(R.drawable.gvs);
        builder.setTitle("Select Recognition Language");
        builder.setInverseBackgroundForced(true);
        View listView = new ListView(activityAdvancedSettings);
        listView.setAdapter(new ArrayAdapter(activityAdvancedSettings, 17367043, 16908308, arrayList));
        builder.setNegativeButton("Cancel", new C0165u(activityAdvancedSettings));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new C0166v(activityAdvancedSettings, arrayList2, create));
        create.show();
    }

    static /* synthetic */ void m496c(ActivityAdvancedSettings activityAdvancedSettings) {
        if (hc.f1269b) {
            ls.m1346c("in tryAgain");
        }
        boolean m = jy.m1262m(activityAdvancedSettings, "com.wolfram.android.alpha");
        Dialog dialog = new Dialog(activityAdvancedSettings);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activityAdvancedSettings.getSystemService("layout_inflater")).inflate(R.layout.try_again_dialog_layout, (ViewGroup) activityAdvancedSettings.findViewById(R.id.tadl));
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.radioGroup1);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.radio0);
        radioButton.setTextColor(-1);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.radio1);
        radioButton2.setTextColor(-1);
        RadioButton radioButton3 = (RadioButton) inflate.findViewById(R.id.radio2);
        radioButton3.setTextColor(-1);
        RadioButton radioButton4 = (RadioButton) inflate.findViewById(R.id.radio3);
        radioButton4.setTextColor(-1);
        RadioButton radioButton5 = (RadioButton) inflate.findViewById(R.id.radio4);
        radioButton5.setTextColor(-1);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        switch (lx.m1397b(activityAdvancedSettings)) {
            case 0:
                radioButton5.setChecked(true);
                break;
            case 1:
                radioButton3.setChecked(true);
                break;
            case 2:
                radioButton.setChecked(true);
                break;
            case 3:
                if (!m) {
                    radioButton5.setChecked(true);
                    break;
                } else {
                    radioButton2.setChecked(true);
                    break;
                }
            case 4:
                radioButton4.setChecked(true);
                break;
        }
        if (!m) {
            radioButton2.setVisibility(8);
        }
        dialog.setContentView(inflate);
        dialog.setFeatureDrawableResource(3, R.drawable.refresh1);
        dialog.setTitle("Handling Unknown Commands");
        dialog.show();
        dialog.setOnCancelListener(new C0160p(activityAdvancedSettings));
        button.setOnClickListener(new C0161q(activityAdvancedSettings, radioGroup, dialog));
        button2.setOnClickListener(new C0162r(activityAdvancedSettings, dialog));
        imageButton.setOnClickListener(new C0163s(activityAdvancedSettings, m));
    }

    static /* synthetic */ void m497c(ActivityAdvancedSettings activityAdvancedSettings, String str) {
        if (hc.f1269b) {
            ls.m1346c("in setNativeLocale");
        }
        Editor edit = activityAdvancedSettings.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("native_locale", true);
        edit.putString("native_locale_value", str);
        edit.commit();
        lx.ar(activityAdvancedSettings);
    }

    static /* synthetic */ void m498d(ActivityAdvancedSettings activityAdvancedSettings) {
        BroadcastReceiver c0164t = new C0164t(activityAdvancedSettings);
        activityAdvancedSettings.sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, c0164t, null, 0, null, null);
    }

    static /* synthetic */ void m500e(ActivityAdvancedSettings activityAdvancedSettings) {
        if (hc.f1269b) {
            ls.m1346c("in emailSignature");
        }
        Dialog dialog = new Dialog(activityAdvancedSettings);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activityAdvancedSettings.getSystemService("layout_inflater")).inflate(R.layout.signature_dialog_layout, (ViewGroup) activityAdvancedSettings.findViewById(R.id.sdl));
        dialog.setTitle("Email Signature");
        EditText editText = (EditText) inflate.findViewById(R.id.intro);
        editText.setHint("No signature");
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        dialog.setContentView(inflate);
        dialog.setFeatureDrawableResource(3, R.drawable.email);
        dialog.setTitle("Email Signature");
        String L = lx.m1373L(activityAdvancedSettings);
        if (L.matches("") || L.matches(" ")) {
            editText.setText(Html.fromHtml("Sent by voice from <a href='https://play.google.com/store/apps/details?id=com.brandall.nutter&hl=en'>utter!</a>"));
        } else {
            editText.setText(Html.fromHtml(L.replaceAll("\\sutter\\!", " <a href='https://play.google.com/store/apps/details?id=com.brandall.nutter&hl=en'>utter!</a>")));
        }
        dialog.show();
        dialog.setOnCancelListener(new ab(activityAdvancedSettings));
        button.setOnClickListener(new ac(activityAdvancedSettings, editText, dialog));
        button2.setOnClickListener(new ad(activityAdvancedSettings, dialog));
        imageButton.setOnClickListener(new ae(activityAdvancedSettings));
    }

    static /* synthetic */ void m502f(ActivityAdvancedSettings activityAdvancedSettings) {
        if (hc.f1269b) {
            ls.m1346c("in smsSignature");
        }
        Dialog dialog = new Dialog(activityAdvancedSettings);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activityAdvancedSettings.getSystemService("layout_inflater")).inflate(R.layout.signature_dialog_layout, (ViewGroup) activityAdvancedSettings.findViewById(R.id.sdl));
        EditText editText = (EditText) inflate.findViewById(R.id.intro);
        editText.setHint("No signature");
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        dialog.setContentView(inflate);
        dialog.setFeatureDrawableResource(3, R.drawable.sms);
        dialog.setTitle("SMS Signature");
        String K = lx.m1372K(activityAdvancedSettings);
        if (K.matches("") || K.matches(" ")) {
            editText.setText(Html.fromHtml("Sent by voice from <a href='https://play.google.com/store/apps/details?id=com.brandall.nutter&hl=en'>utter!</a>"));
        } else {
            editText.setText(Html.fromHtml(K.replaceAll("\\sutter\\!", " <a href='https://play.google.com/store/apps/details?id=com.brandall.nutter&hl=en'>utter!</a>")));
        }
        dialog.show();
        dialog.setOnCancelListener(new af(activityAdvancedSettings));
        button.setOnClickListener(new C0147e(activityAdvancedSettings, editText, dialog));
        button2.setOnClickListener(new C0148f(activityAdvancedSettings, dialog));
        imageButton.setOnClickListener(new C0149g(activityAdvancedSettings));
    }

    static /* synthetic */ void m503g(ActivityAdvancedSettings activityAdvancedSettings) {
        BroadcastReceiver c0156l = new C0156l(activityAdvancedSettings);
        activityAdvancedSettings.sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, c0156l, null, 0, null, null);
    }

    static /* synthetic */ void m504h(ActivityAdvancedSettings activityAdvancedSettings) {
        boolean aa = lx.aa(activityAdvancedSettings);
        if (aa) {
            if (hc.f1269b) {
                ls.m1346c("visualSet: " + aa);
            }
            lx.m1432i((Context) activityAdvancedSettings, false);
            lc.m1313a(activityAdvancedSettings, false, "Visual results disabled");
            ly.m1460a(activityAdvancedSettings, 12000, false);
            return;
        }
        if (hc.f1269b) {
            ls.m1346c("visualSet: " + aa);
        }
        lx.m1432i((Context) activityAdvancedSettings, true);
        ly.m1460a(activityAdvancedSettings, 12000, true);
        ((Vibrator) activityAdvancedSettings.getSystemService("vibrator")).vibrate(100);
        if (activityAdvancedSettings.getSharedPreferences("utterPref", 0).getBoolean("visual_first", true)) {
            Editor edit = activityAdvancedSettings.getSharedPreferences("utterPref", 0).edit();
            edit.putBoolean("visual_first", false);
            edit.commit();
            GlobalV.m899w(true);
            lc.m1313a(activityAdvancedSettings, false, "Visual results enabled. This will display a floating results window after every command. It gives you a chance to see if Google Voice Search is returning your voice results accurately. If it doesn't, all is not lost, as you can customise and tweak commands to words and phrases that do work well for you. Other recognition providers will be available soon.");
            return;
        }
        lc.m1313a(activityAdvancedSettings, false, "Visual results enabled");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && intent != null) {
            try {
                Iterator it = intent.getStringArrayListExtra("availableVoices").iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    Locale locale = new Locale((String) it.next());
                    if (hc.f1269b) {
                        ls.m1346c("language locale: " + locale.toString());
                    }
                    arrayList.add(locale);
                }
                if (i == 0) {
                    m492a(arrayList);
                }
            } catch (Exception e) {
                e.printStackTrace();
                m491a("The data for that voice engine is corrupt.", false);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (hc.f1269b) {
                ls.m1345b("Landscape");
            }
        } else if (configuration.orientation == 1 && hc.f1269b) {
            ls.m1345b("Portrait");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (hc.f1269b) {
            ls.m1346c("AdvancedSettings OnCreate");
        }
        setContentView(R.layout.advanced_settings_layout);
        this.f651b = (AdView) findViewById(R.id.adView);
        this.f650a = (UITableView) findViewById(R.id.tableView);
        this.f650a.setClickListener(new ag());
        C0090a c0090a = new C0090a("Shake Configuration");
        c0090a.f294b = R.drawable.shake;
        c0090a.f297e = "tap to configure";
        this.f650a.m292a(c0090a);
        c0090a = new C0090a("Wave Configuration");
        c0090a.f294b = R.drawable.waving_hands;
        c0090a.f297e = "tap to configure";
        this.f650a.m292a(c0090a);
        c0090a = new C0090a("Try Again");
        c0090a.f294b = R.drawable.refresh1;
        c0090a.f297e = "tap to configure";
        this.f650a.m292a(c0090a);
        c0090a = new C0090a("Custom Launcher Shortcut");
        c0090a.f294b = R.drawable.shortcutnat;
        c0090a.f297e = "tap to create";
        this.f650a.m292a(c0090a);
        c0090a = new C0090a("Email Signature");
        c0090a.f294b = R.drawable.email;
        c0090a.f297e = "tap to set";
        if (lx.m1373L(this).matches(" ") || lx.m1373L(this).matches("")) {
            c0090a.f295c = R.drawable.cross;
        } else {
            c0090a.f295c = R.drawable.tick;
        }
        this.f650a.m292a(c0090a);
        c0090a = new C0090a("SMS Signature");
        c0090a.f294b = R.drawable.sms;
        c0090a.f297e = "tap to set";
        if (lx.m1372K(this).matches("") || lx.m1372K(this).matches(" ")) {
            c0090a.f295c = R.drawable.cross;
        } else {
            c0090a.f295c = R.drawable.tick;
        }
        this.f650a.m292a(c0090a);
        c0090a = new C0090a("Native Recognition Language");
        c0090a.f294b = R.drawable.speechbubbles24;
        c0090a.f297e = "tap to select";
        if (lx.aj(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f650a.m292a(c0090a);
        c0090a = new C0090a("Visual Results");
        c0090a.f294b = R.drawable.viewresults;
        c0090a.f297e = "tap to toggle";
        if (lx.aa(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f650a.m292a(c0090a);
        c0090a = new C0090a("Interaction Level");
        c0090a.f294b = R.drawable.allseeingeye;
        c0090a.f297e = "tap to set";
        this.f650a.m292a(c0090a);
        c0090a = new C0090a("Power User");
        c0090a.f294b = R.drawable.settings2;
        c0090a.f297e = "tap to configure";
        this.f650a.m292a(c0090a);
        this.f650a.m291a();
        this.f651b.m1593a(gr.m993a(this));
    }

    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("AdvancedSettings onDestroy");
        }
        if (this.f651b != null) {
            this.f651b.removeAllViews();
            this.f651b.m1592a();
        }
    }

    public void onPause() {
        super.onPause();
        if (hc.f1269b) {
            ls.m1346c("AdvancedSettings onPause");
        }
    }

    public void onResume() {
        super.onResume();
        if (hc.f1269b) {
            ls.m1346c("AdvancedSettings onResume");
        }
    }
}
