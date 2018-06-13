package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.AdView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ActivitySettings extends Activity {
    UITableView f716a;
    private final int f717b = 2;
    private AdView f718c;

    static /* synthetic */ void m659a(ActivitySettings activitySettings) {
        boolean d = ly.m1467d(activitySettings);
        if (d) {
            if (hc.f1269b) {
                ls.m1346c("shakeSet: " + d);
            }
            lx.m1441m(activitySettings, false);
            lc.m1313a(activitySettings, false, "Shake to wake disabled");
            if (hc.f1269b) {
                ls.m1346c("Shutting down SSE");
            }
            jy.m1241b((Context) activitySettings, false);
            return;
        }
        if (hc.f1269b) {
            ls.m1346c("shakeSet: " + d);
        }
        lx.m1441m(activitySettings, true);
        ((Vibrator) activitySettings.getSystemService("vibrator")).vibrate(100);
        if (activitySettings.getSharedPreferences("utterPref", 0).getBoolean("shake_first", true)) {
            Editor edit = activitySettings.getSharedPreferences("utterPref", 0).edit();
            edit.putBoolean("shake_first", false);
            edit.commit();
            GlobalV.m899w(true);
            lc.m1313a(activitySettings, false, "Shake to wake enabled. Please see the command list for how to set the sensitivity to suit your device. If I'm activated accidentally in your pocket, you may get some very strange looks. You can also adjust the sensitivity in the advanced settings section. ");
        } else {
            lc.m1313a(activitySettings, false, "Shake to wake enabled");
        }
        if (hc.f1269b) {
            ls.m1346c("Staring SSE");
        }
        jy.m1241b((Context) activitySettings, true);
    }

    private void m661a(String str, boolean z) {
        if (z) {
            Toast.makeText(this, str, 1).show();
        } else {
            Toast.makeText(this, str, 0).show();
        }
    }

    private void m662a(ArrayList<Locale> arrayList) {
        if (hc.f1269b) {
            ls.m1346c("voiceEngineLocaleDialog");
        }
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.phrases);
        builder.setTitle("Default English Voice Engine");
        builder.setInverseBackgroundForced(true);
        ArrayList arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Locale locale = (Locale) it.next();
            String toLowerCase = locale.toString().toLowerCase(Locale.US);
            if (toLowerCase.contains("\\ben\\b") || toLowerCase.contains("\\beng\\b") || toLowerCase.contains("en_") || toLowerCase.contains("eng_") || toLowerCase.contains("en-") || toLowerCase.contains("eng-")) {
                arrayList2.add(locale);
                arrayList3.add(toLowerCase);
            }
        }
        if (arrayList2.isEmpty()) {
            lc.m1313a(this, false, "Please select an Voice Engine that has an English Voice");
            return;
        }
        View listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter(this, 17367043, 16908308, arrayList3));
        builder.setOnCancelListener(new fj(this));
        builder.setNegativeButton("Cancel", new fk(this));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new fl(this, arrayList2, create));
        create.show();
    }

    static /* synthetic */ void m663b(ActivitySettings activitySettings) {
        boolean c = ly.m1466c(activitySettings);
        if (c) {
            if (hc.f1269b) {
                ls.m1346c("waveSet: " + c);
            }
            lx.m1443n(activitySettings, false);
            lc.m1313a(activitySettings, false, "Wave to wake disabled");
            if (hc.f1269b) {
                ls.m1346c("Shutting down SWE");
            }
            jy.m1245c((Context) activitySettings, false);
            return;
        }
        if (hc.f1269b) {
            ls.m1346c("waveSet: " + c);
        }
        lx.m1443n(activitySettings, true);
        ((Vibrator) activitySettings.getSystemService("vibrator")).vibrate(100);
        if (activitySettings.getSharedPreferences("utterPref", 0).getBoolean("wave_first", true)) {
            Editor edit = activitySettings.getSharedPreferences("utterPref", 0).edit();
            edit.putBoolean("wave_first", false);
            edit.commit();
            GlobalV.m899w(true);
            lc.m1313a(activitySettings, false, "Wave to wake enabled. It can be a little tricky to find the right activation rhythm. For a demo, take a glance at the YouTube video, nine minutes and twenty seconds in. You can alter the configuration to make it more easy to activate in the Advanced Settings Menu.");
        } else {
            lc.m1313a(activitySettings, false, "Wave to wake enabled");
        }
        if (hc.f1269b) {
            ls.m1346c("Starting SWE");
        }
        jy.m1245c((Context) activitySettings, true);
    }

    static /* synthetic */ void m665c(ActivitySettings activitySettings) {
        if (hc.f1269b) {
            ls.m1346c("in defEngVoice");
        }
        Intent intent = new Intent();
        intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
        intent.getStringArrayListExtra("availableVoices");
        try {
            activitySettings.startActivityForResult(Intent.createChooser(intent, "Select Voice Engine"), 2);
        } catch (Exception e) {
            e.printStackTrace();
            jy.m1263n(activitySettings, "voice engine");
            lx.m1393a((Context) activitySettings, QueryParamConst.HL_VALUE, "USA", false);
            activitySettings.m661a("Please install an English voice engine!", true);
        }
    }

    static /* synthetic */ void m666d(ActivitySettings activitySettings) {
        if (hc.f1269b) {
            ls.m1346c("in tempUnits");
        }
        Dialog dialog = new Dialog(activitySettings);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activitySettings.getSystemService("layout_inflater")).inflate(R.layout.temperature_units_dialog_layout, (ViewGroup) activitySettings.findViewById(R.id.tudl));
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.radioGroup1);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.radio0);
        radioButton.setTextColor(-1);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.radio1);
        radioButton2.setTextColor(-1);
        RadioButton radioButton3 = (RadioButton) inflate.findViewById(R.id.radio2);
        radioButton3.setTextColor(-1);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        if (lx.m1449r(activitySettings).matches("c")) {
            radioButton.setChecked(true);
        } else if (lx.m1449r(activitySettings).matches("f")) {
            radioButton2.setChecked(true);
        } else {
            radioButton3.setChecked(true);
        }
        dialog.setContentView(inflate);
        dialog.setFeatureDrawableResource(3, R.drawable.temperature);
        dialog.setTitle("Temperature Units");
        dialog.show();
        dialog.setOnCancelListener(new fm(activitySettings));
        button.setOnClickListener(new fn(activitySettings, radioGroup, dialog));
        button2.setOnClickListener(new fo(activitySettings, dialog));
        imageButton.setOnClickListener(new fp(activitySettings));
    }

    static /* synthetic */ void m667e(ActivitySettings activitySettings) {
        Dialog dialog = new Dialog(activitySettings);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activitySettings.getSystemService("layout_inflater")).inflate(R.layout.volume_settings_dialog_layout, (ViewGroup) activitySettings.findViewById(R.id.vsdl));
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkBox1);
        checkBox.setTextColor(-1);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.checkBox2);
        checkBox2.setTextColor(-1);
        ((CheckBox) inflate.findViewById(R.id.checkBox3)).setTextColor(-1);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        if (lx.m1435j(activitySettings)) {
            checkBox.setChecked(true);
        }
        if (lx.m1433i(activitySettings)) {
            checkBox2.setChecked(true);
        }
        dialog.setContentView(inflate);
        dialog.setFeatureDrawableResource(3, R.drawable.volume);
        dialog.setTitle("Volume Preferences");
        dialog.show();
        dialog.setOnCancelListener(new fq(activitySettings));
        button.setOnClickListener(new ec(activitySettings, checkBox, checkBox2, dialog));
        button2.setOnClickListener(new ed(activitySettings, dialog));
        imageButton.setOnClickListener(new ee(activitySettings));
    }

    static /* synthetic */ void m668f(ActivitySettings activitySettings) {
        Dialog dialog = new Dialog(activitySettings);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activitySettings.getSystemService("layout_inflater")).inflate(R.layout.slider_dialog_layout, (ViewGroup) activitySettings.findViewById(R.id.psdl));
        dialog.setFeatureDrawableResource(3, R.drawable.musicpause);
        dialog.setTitle("Pause For Breath Timeout");
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.seekBar1);
        TextView textView = (TextView) inflate.findViewById(R.id.textViewSB);
        textView.setTextColor(-1);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        dialog.setContentView(inflate);
        if (lx.m1370I(activitySettings)) {
            seekBar.setProgress(lx.m1369H(activitySettings));
        } else {
            seekBar.setProgress(0);
        }
        if (lx.m1369H(activitySettings) == 0) {
            textView.setText("Pause timeout set to default");
        } else {
            textView.setText("Pause timeout will be " + lx.m1369H(activitySettings) + " seconds");
        }
        dialog.show();
        dialog.setOnCancelListener(new fd(activitySettings));
        button.setOnClickListener(new fe(activitySettings, seekBar, dialog));
        button2.setOnClickListener(new ff(activitySettings, dialog));
        seekBar.setOnSeekBarChangeListener(new fg(activitySettings, textView));
        imageButton.setOnClickListener(new fh(activitySettings));
    }

    static /* synthetic */ void m669g(ActivitySettings activitySettings) {
        if (hc.f1269b) {
            ls.m1346c("in proofRead");
        }
        Dialog dialog = new Dialog(activitySettings);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activitySettings.getSystemService("layout_inflater")).inflate(R.layout.proof_read_dialog_layout, (ViewGroup) activitySettings.findViewById(R.id.prdl));
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.radioGroup1);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.radio0);
        radioButton.setTextColor(-1);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.radio1);
        radioButton2.setTextColor(-1);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        if (lx.m1430h(activitySettings)) {
            radioButton.setChecked(true);
        } else {
            radioButton2.setChecked(true);
        }
        dialog.setContentView(inflate);
        dialog.setFeatureDrawableResource(3, R.drawable.proofread);
        dialog.setTitle("Proof Reading");
        dialog.show();
        dialog.setOnCancelListener(new eb(activitySettings));
        button.setOnClickListener(new em(activitySettings, radioGroup, dialog));
        button2.setOnClickListener(new ex(activitySettings, dialog));
        imageButton.setOnClickListener(new fi(activitySettings));
    }

    static /* synthetic */ void m670h(ActivitySettings activitySettings) {
        if (hc.f1269b) {
            ls.m1346c("in defaultExplorer");
        }
        String C = lx.m1364C(activitySettings);
        View inflate = ((LayoutInflater) activitySettings.getSystemService("layout_inflater")).inflate(R.layout.explorer_picker_dialog_layout, (ViewGroup) activitySettings.findViewById(R.id.eapdl));
        Builder builder = new Builder(activitySettings);
        builder.setIcon(R.drawable.fileexplorerdefault);
        builder.setTitle("Default Explorer application");
        builder.setMessage("Please select your choice");
        builder.setInverseBackgroundForced(true);
        TextView textView = (TextView) inflate.findViewById(R.id.eaptv1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.eaptv2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.eaptv3);
        TextView textView4 = (TextView) inflate.findViewById(R.id.eaptv4);
        TextView textView5 = (TextView) inflate.findViewById(R.id.eaptv5);
        TextView textView6 = (TextView) inflate.findViewById(R.id.eaptv6);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.eapcb1);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.eapcb2);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.eapcb3);
        CheckBox checkBox4 = (CheckBox) inflate.findViewById(R.id.eapcb4);
        CheckBox checkBox5 = (CheckBox) inflate.findViewById(R.id.eapcb5);
        CheckBox checkBox6 = (CheckBox) inflate.findViewById(R.id.eapcb6);
        if (jy.m1262m(activitySettings, "com.ghisler.android.TotalCommander")) {
            checkBox.setClickable(true);
            if (C.matches("com.ghisler.android.TotalCommander")) {
                checkBox.setChecked(true);
            }
        } else {
            checkBox.setClickable(false);
            checkBox.setVisibility(8);
        }
        if (jy.m1262m(activitySettings, "com.speedsoftware.rootexplorer")) {
            checkBox2.setClickable(true);
            if (C.matches("com.speedsoftware.rootexplorer")) {
                checkBox2.setChecked(true);
            }
        } else {
            checkBox2.setClickable(false);
            checkBox2.setVisibility(8);
        }
        if (jy.m1262m(activitySettings, "com.estrongs.android.pop")) {
            checkBox3.setClickable(true);
            if (C.matches("com.estrongs.android.pop")) {
                checkBox3.setChecked(true);
            }
        } else {
            checkBox3.setClickable(false);
            checkBox3.setVisibility(8);
        }
        if (jy.m1262m(activitySettings, "xcxin.filexpert")) {
            checkBox4.setClickable(true);
            if (C.matches("xcxin.filexpert")) {
                checkBox4.setChecked(true);
            }
        } else {
            checkBox4.setClickable(false);
            checkBox4.setVisibility(8);
        }
        if (jy.m1262m(activitySettings, "com.speedsoftware.explorer")) {
            checkBox5.setClickable(true);
            if (C.matches("com.speedsoftware.explorer")) {
                checkBox5.setChecked(true);
            }
        } else {
            checkBox5.setClickable(false);
            checkBox5.setVisibility(8);
        }
        if (jy.m1262m(activitySettings, "pl.solidexplorer")) {
            checkBox6.setClickable(true);
            if (C.matches("pl.solidexplorer")) {
                checkBox6.setChecked(true);
            }
        } else {
            checkBox6.setClickable(false);
            checkBox6.setVisibility(8);
        }
        builder.setPositiveButton("Save", new eo(activitySettings, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6));
        Builder builder2 = builder;
        builder2.setNegativeButton("Cancel", new ep(activitySettings));
        builder.setView(inflate);
        Dialog create = builder.create();
        textView.setOnClickListener(new eq(activitySettings, create));
        textView2.setOnClickListener(new er(activitySettings, create));
        textView3.setOnClickListener(new es(activitySettings, create));
        textView4.setOnClickListener(new et(activitySettings, create));
        textView5.setOnClickListener(new eu(activitySettings, create));
        textView6.setOnClickListener(new ev(activitySettings, create));
        checkBox.setOnCheckedChangeListener(new ew(activitySettings, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6));
        checkBox2.setOnCheckedChangeListener(new ey(activitySettings, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6));
        checkBox3.setOnCheckedChangeListener(new ez(activitySettings, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6));
        checkBox4.setOnCheckedChangeListener(new fa(activitySettings, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6));
        checkBox5.setOnCheckedChangeListener(new fb(activitySettings, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6));
        checkBox6.setOnCheckedChangeListener(new fc(activitySettings, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6));
        builder.show();
    }

    static /* synthetic */ void m671i(ActivitySettings activitySettings) {
        if (hc.f1269b) {
            ls.m1346c("defaultNotes");
        }
        String E = lx.m1366E(activitySettings);
        View inflate = ((LayoutInflater) activitySettings.getSystemService("layout_inflater")).inflate(R.layout.notes_picker_dialog_layout, (ViewGroup) activitySettings.findViewById(R.id.napdl));
        Builder builder = new Builder(activitySettings);
        builder.setIcon(R.drawable.notes);
        builder.setTitle("Default notes application");
        builder.setMessage("Please select your choice");
        builder.setInverseBackgroundForced(true);
        TextView textView = (TextView) inflate.findViewById(R.id.naptv1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.naptv2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.naptv3);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.napcb1);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.napcb2);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.napcb3);
        if (jy.m1262m(activitySettings, "com.evernote")) {
            checkBox.setClickable(true);
            if (E.matches("com.evernote")) {
                checkBox.setChecked(true);
            }
        } else {
            checkBox.setClickable(false);
            checkBox.setVisibility(8);
        }
        if (jy.m1262m(activitySettings, "com.threebanana.notes")) {
            checkBox2.setClickable(true);
            if (E.matches("com.threebanana.notes")) {
                checkBox2.setChecked(true);
            }
        } else {
            checkBox2.setClickable(false);
            checkBox2.setVisibility(8);
        }
        if (jy.m1262m(activitySettings, "com.springpad")) {
            checkBox3.setClickable(false);
            checkBox3.setVisibility(8);
            if (E.matches("com.springpad")) {
                checkBox3.setChecked(true);
            }
        } else {
            checkBox3.setClickable(false);
            checkBox3.setVisibility(8);
        }
        builder.setPositiveButton("Save", new ef(activitySettings, checkBox, checkBox2, checkBox3));
        builder.setNegativeButton("Cancel", new eg(activitySettings));
        builder.setView(inflate);
        Dialog create = builder.create();
        textView.setOnClickListener(new eh(activitySettings, create));
        textView2.setOnClickListener(new ei(activitySettings, create));
        textView3.setOnClickListener(new ej(activitySettings, create));
        checkBox.setOnCheckedChangeListener(new ek(activitySettings, checkBox2, checkBox3));
        checkBox2.setOnCheckedChangeListener(new el(activitySettings, checkBox, checkBox3));
        checkBox3.setOnCheckedChangeListener(new en(activitySettings, checkBox, checkBox2));
        builder.show();
    }

    static /* synthetic */ void m672j(ActivitySettings activitySettings) {
        if (VERSION.SDK_INT >= 16) {
            boolean ao = lx.ao(activitySettings);
            if (ao) {
                if (hc.f1269b) {
                    ls.m1346c("gnVoice: " + ao);
                }
                lx.m1446p(activitySettings, false);
                lc.m1313a(activitySettings, false, "Disabled");
                ly.m1459a((Context) activitySettings);
                ly.m1464b(activitySettings);
                return;
            }
            if (hc.f1269b) {
                ls.m1346c("gnVoice: " + ao);
            }
            lx.m1446p(activitySettings, true);
            if (activitySettings.getSharedPreferences("utterPref", 0).getBoolean("gnv_first", true)) {
                Editor edit = activitySettings.getSharedPreferences("utterPref", 0).edit();
                edit.putBoolean("gnv_first", false);
                edit.commit();
                GlobalV.m899w(true);
                lc.m1313a(activitySettings, false, "Enabled. I'll speak using the Jelly Bean network synthesised voice. Please be aware, this will increase your data usage.");
            } else {
                lc.m1313a(activitySettings, false, "Enabled");
            }
            ly.m1459a((Context) activitySettings);
            ly.m1464b(activitySettings);
            return;
        }
        lc.m1313a(activitySettings, false, "Your device is not running Jelly Bean");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 2 || intent == null) {
            lc.m1313a(this, false, "Cancelled");
            lx.m1393a((Context) this, QueryParamConst.HL_VALUE, "USA", false);
            return;
        }
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
            m662a(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            lc.m1313a(this, false, "The data for that voice engine is corrupt.");
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
            ls.m1346c("ActivitySettings OnCreate");
        }
        setContentView(R.layout.settings_layout);
        this.f718c = (AdView) findViewById(R.id.adView);
        this.f716a = (UITableView) findViewById(R.id.tableView);
        this.f716a.setClickListener(new fr());
        C0090a c0090a = new C0090a("Shake-To-Wake");
        c0090a.f294b = R.drawable.shake;
        c0090a.f297e = "tap to toggle";
        if (ly.m1467d(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f716a.m292a(c0090a);
        c0090a = new C0090a("Wave-To-Wake");
        c0090a.f294b = R.drawable.waving_hands;
        c0090a.f297e = "tap to toggle";
        if (ly.m1466c(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f716a.m292a(c0090a);
        c0090a = new C0090a("English Voice Engine");
        c0090a.f294b = R.drawable.speechbritish;
        c0090a.f297e = "tap to select";
        if (lx.m1371J(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f716a.m292a(c0090a);
        c0090a = new C0090a("Temperature Units");
        c0090a.f294b = R.drawable.temperature;
        c0090a.f297e = "tap to set";
        if (lx.m1449r(this).matches("")) {
            c0090a.f295c = R.drawable.cross;
        } else {
            c0090a.f295c = R.drawable.tick;
        }
        this.f716a.m292a(c0090a);
        c0090a = new C0090a("Volume Settings");
        c0090a.f294b = R.drawable.volume;
        c0090a.f297e = "tap to configure";
        this.f716a.m292a(c0090a);
        c0090a = new C0090a("Pause Timeout");
        c0090a.f294b = R.drawable.musicpause;
        c0090a.f297e = "tap to set";
        if (lx.m1370I(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f716a.m292a(c0090a);
        c0090a = new C0090a("Proof Read Defaults");
        c0090a.f294b = R.drawable.proofread;
        c0090a.f297e = "tap to select";
        this.f716a.m292a(c0090a);
        c0090a = new C0090a("Default Explorer");
        c0090a.f294b = R.drawable.fileexplorerdefault;
        c0090a.f297e = "tap to select";
        if (lx.m1365D(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f716a.m292a(c0090a);
        c0090a = new C0090a("Default Notes");
        c0090a.f294b = R.drawable.notes;
        c0090a.f297e = "tap to select";
        if (lx.m1367F(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f716a.m292a(c0090a);
        c0090a = new C0090a("Google Synthesised Voice");
        c0090a.f294b = R.drawable.googlesearch;
        c0090a.f297e = "Jelly Bean only";
        if (VERSION.SDK_INT < 16 || !lx.ao(this)) {
            c0090a.f295c = R.drawable.cross;
        } else {
            c0090a.f295c = R.drawable.tick;
        }
        this.f716a.m292a(c0090a);
        c0090a = new C0090a("Advanced Settings");
        c0090a.f294b = R.drawable.settings3;
        c0090a.f297e = "tap to configure";
        this.f716a.m292a(c0090a);
        this.f716a.m291a();
        this.f718c.m1593a(gr.m993a(this));
    }

    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("ActivitySettings onDestroy");
        }
        getWindow().clearFlags(128);
        if (this.f718c != null) {
            this.f718c.removeAllViews();
            this.f718c.m1592a();
        }
    }

    public void onPause() {
        super.onPause();
        if (hc.f1269b) {
            ls.m1346c("ActivitySettings onPause");
        }
    }

    public void onResume() {
        super.onResume();
        if (hc.f1269b) {
            ls.m1346c("ActivitySettings onResume");
        }
        if (ServiceTTS.f854f) {
            getWindow().addFlags(128);
        }
    }
}
