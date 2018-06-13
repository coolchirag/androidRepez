package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.AdView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ActivityHome extends Activity {
    private static ProgressBar f677c;
    UITableView f678a;
    private ToggleButton f679b;
    private boolean f680d = false;
    private AdView f681e;
    private Bundle f682f;

    public static void m555a() {
        try {
            f677c.setVisibility(4);
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1347d("AH Activity dead");
            }
        }
    }

    static /* synthetic */ void m556a(ActivityHome activityHome) {
        AudioManager audioManager = (AudioManager) activityHome.getSystemService("audio");
        boolean z = (audioManager.getRingerMode() == 0 || audioManager.getStreamVolume(3) == 0 || audioManager.getRingerMode() == 1) ? false : true;
        if (z) {
            activityHome.getWindow().addFlags(128);
            ServiceTTS.f854f = true;
            ly.m1460a(activityHome, 15000, true);
            lt.m1354a(activityHome, false);
            lc.m1313a(activityHome, false, "Welcome to the beta version of, Utter. To stop this tutorial, you can tap the notification in the status bar at any time. Let's take a look around");
            return;
        }
        activityHome.m558a("The device and media sound must be enabled to run the tutorial!", true, true);
    }

    private void m558a(String str, boolean z, boolean z2) {
        if (z2) {
            ((Vibrator) getSystemService("vibrator")).vibrate(100);
        }
        if (z) {
            Toast.makeText(this, str, 1).show();
        } else {
            Toast.makeText(this, str, 0).show();
        }
    }

    private void m559a(ArrayList<Locale> arrayList) {
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
            String trim = locale.toString().toLowerCase(Locale.US).trim();
            if (trim.contains("\\ben\\b") || trim.contains("\\beng\\b") || trim.contains("en_") || trim.contains("eng_") || trim.contains("en-") || trim.contains("eng-") || trim.matches(QueryParamConst.HL_VALUE) || trim.matches("eng")) {
                arrayList2.add(locale);
                arrayList3.add(trim);
            }
        }
        if (arrayList2.isEmpty()) {
            m558a("Please select an engine with an English Voice. If you don't have one, please install and return to the application.", true, false);
            if (!lx.m1456y(this)) {
                m560b();
                return;
            }
            return;
        }
        View listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter(this, 17367043, 16908308, arrayList3));
        builder.setOnCancelListener(new cj(this));
        builder.setNegativeButton("Cancel", new ck(this));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new cl(this, arrayList2, create));
        create.show();
    }

    private void m560b() {
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.info1);
        builder.setTitle("Welcome to utter! BETA!");
        View textView = new TextView(this);
        textView.setClickable(true);
        try {
            textView.setText(Html.fromHtml("<b><i>A message from the developer</b></i><br><br>Thank you for wanting to test the beta release of utter!<br><br>The application is currently compatible with 2,083 different Android devices, but unfortunately it’s not going to work correctly on all of them! With your help, I want to catch as many bugs as possible associated with the framework of the application, so then I can press on with adding additional functionality. <br><br>Thank you so much for all of your support, feedback, bug reports and suggestions so far. They've helped me so much. If the app crashes, please do press ‘<i>report</i>’ so I get the bug details – pop your email in the description box if you’d like a reply<br><br>I can’t respond to comments on the Play Store, so ‘<i>1* Some of the features don’t work for me</i>’ will not help! If you'd like to report a problem, please press the ‘<i>Send Feedback</i>’ button in the app and drop me a lightning quick email.<br><br>I've added more ads to the application as I need to raise development funds to keep this project alive. I hope you can put up with them whilst you are configuring utter! as you like! They don't appear outside of the main application of course.<br><br>Finally, I’m working on this project alone, but I’ll do my best to respond to your messages as quickly as possible! <br><br>Thanks again for wanting to be involved!<br><br>Ben<br>"));
        } catch (ArrayIndexOutOfBoundsException e) {
            textView.setText("You have an Android Platform bug which will prevent this application from working correctly for you. If you would like to help me test a fix for this problem, I would be very grateful utter.android@gmail.com");
        }
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        textView.setPadding(30, 2, 20, 10);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        builder.setPositiveButton("Let's do it!", new cf(this));
        builder.setView(textView);
        try {
            builder.show();
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.printStackTrace();
            textView.setText("You have an Android Platform bug which will prevent this application from working correctly for you. If you would like to help me test a fix for this problem, I would be very grateful utter.android@gmail.com");
            builder.show();
        }
    }

    private void m563c() {
        Intent intent = new Intent();
        intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
        intent.getStringArrayListExtra("availableVoices");
        try {
            startActivityForResult(Intent.createChooser(intent, "Select Voice Engine"), 1);
        } catch (Exception e) {
            e.printStackTrace();
            jy.m1263n(this, "voice engine");
            lx.m1393a((Context) this, QueryParamConst.HL_VALUE, "USA", false);
            m558a("Please install an English voice engine!", true, false);
        }
    }

    static /* synthetic */ void m564c(ActivityHome activityHome) {
        if (hc.f1269b) {
            ls.m1346c("HomeActivity offLoad");
        }
        if (activityHome.f680d && !ly.m1468e(activityHome)) {
            if (hc.f1269b) {
                ls.m1346c("HomeActivity starting service");
            }
            ly.m1464b(activityHome);
        }
        if (activityHome.getSharedPreferences("utterPref", 0).getBoolean("version_update2262", true)) {
            if (hc.f1269b) {
                ls.m1347d("HomeActivity runUpdate");
            }
            Editor edit = activityHome.getSharedPreferences("utterPref", 0).edit();
            edit.putBoolean("version_update2262", false);
            edit.commit();
            lx.ar(activityHome);
            lx.m1402b(activityHome, "", "", false);
            lx.m1410c(activityHome, "", "", false);
        }
        activityHome.sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, new GVSLanguage(), null, 69, null, null);
        if (hc.f1269b) {
            int i = (int) activityHome.getResources().getDisplayMetrics().density;
            Display defaultDisplay = activityHome.getWindowManager().getDefaultDisplay();
            if (VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                ls.m1344a("Width: " + point.x);
                ls.m1344a("Height: " + point.y);
                ls.m1344a("density: " + i);
                return;
            }
            ls.m1344a("Width: " + defaultDisplay.getWidth());
            ls.m1344a("Height: " + defaultDisplay.getHeight());
            ls.m1344a("density: " + i);
        }
    }

    private void m566d() {
        if (hc.f1269b) {
            ls.m1346c("in userGuide");
        }
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.userguide);
        builder.setTitle("Select Help Topic");
        builder.setItems(new String[]{"Basic Usage", "Creating Commands", "Translation", "Word Replacement", "Sound Effects", "Remote Control", "Tasker Plugin Guide", "Troubleshooting & Bugs", "Known Bugs", "Download Icons", "Coming Soon!"}, new cm(this));
        if (!ServiceTTS.f854f) {
            builder.setNegativeButton("Cancel", null);
        }
        builder.show();
    }

    public void mySwitchClick(View view) {
        this.f679b = (ToggleButton) view.findViewById(R.id.cvToggleButton);
        if (this.f679b.isChecked()) {
            if (hc.f1269b) {
                ls.m1346c("HomeActivity switching on");
            }
            if (!ly.m1464b(this) && hc.f1269b) {
                ls.m1348e("HomeActivity failed to start service");
            }
            ly.m1465b(this, 9000, true);
            return;
        }
        if (hc.f1269b) {
            ls.m1346c("HomeActivity switching off");
        }
        if (!ly.m1459a((Context) this) && hc.f1269b) {
            ls.m1348e("HomeActivity failed to stop service");
        }
        ly.m1465b(this, 0, false);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1 || intent == null) {
            lx.m1393a((Context) this, QueryParamConst.HL_VALUE, "USA", false);
            if (lx.m1456y(this)) {
                m558a("Cancelled", false, false);
                return;
            } else {
                m560b();
                return;
            }
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
            if (i == 1) {
                m559a(arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            m558a("The data for that voice engine is corrupt.", false, false);
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
            ls.m1346c("HomeActivity OnCreate");
        }
        this.f682f = getIntent().getExtras();
        if (this.f682f == null || !this.f682f.getBoolean("shutdown", false)) {
            setContentView(R.layout.main);
            hc.m1058a();
            this.f678a = (UITableView) findViewById(R.id.tableView);
            this.f678a.setClickListener(new cn());
            C0090a c0090a = new C0090a("Voice Tutorial");
            c0090a.f294b = R.drawable.voicetutorial;
            c0090a.f297e = "tap to begin";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("View Command List");
            c0090a.f294b = R.drawable.list;
            c0090a.f297e = "tap to view";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("User Guide");
            c0090a.f294b = R.drawable.userguide;
            c0090a.f297e = "tap for topics";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Customisation");
            c0090a.f294b = R.drawable.customise3;
            c0090a.f297e = "tap to configure";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Settings");
            c0090a.f294b = R.drawable.settings1;
            c0090a.f297e = "tap to configure";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Linked Applications");
            c0090a.f294b = R.drawable.linked;
            c0090a.f297e = "tap for links";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Troubleshooting & Bugs");
            c0090a.f294b = R.drawable.bugred;
            c0090a.f297e = "tap for help";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Recognition & Voices");
            c0090a.f294b = R.drawable.speechbubblequestion;
            c0090a.f297e = "tap to view";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Launcher Shortcut");
            c0090a.f294b = R.drawable.shortcut;
            c0090a.f297e = "tap to create";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Send Feedback");
            c0090a.f294b = R.drawable.feedback1;
            c0090a.f297e = "email the developer";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Circle me on Google+");
            c0090a.f294b = R.drawable.gplus;
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Follow me on Twitter");
            c0090a.f294b = R.drawable.twitter;
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Watch the *New* Beta Video!");
            c0090a.f294b = R.drawable.youtube;
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("XDA Development Thread");
            c0090a.f294b = R.drawable.ic_xda;
            c0090a.f297e = "latest test builds";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("Share utter!");
            c0090a.f294b = R.drawable.share1;
            c0090a.f297e = "share the new video!";
            this.f678a.m292a(c0090a);
            c0090a = new C0090a("About utter!");
            c0090a.f294b = R.drawable.info1;
            this.f678a.m292a(c0090a);
            this.f678a.m291a();
            this.f680d = lx.ad(this);
            new ce(this).start();
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar3);
            f677c = progressBar;
            progressBar.getIndeterminateDrawable().setColorFilter(-65536, Mode.MULTIPLY);
            f677c.setVisibility(0);
            this.f679b = (ToggleButton) findViewById(R.id.cvToggleButton);
            this.f681e = (AdView) findViewById(R.id.adView);
            if (this.f680d) {
                if (hc.f1269b) {
                    ls.m1346c("checkEnabled: true");
                }
                this.f679b.setChecked(true);
            } else if (ly.m1468e(this)) {
                if (hc.f1269b) {
                    ls.m1346c("checkEnabled: false: serviceTTSRunning: true");
                }
                this.f679b.setChecked(true);
                lx.m1437k(this, true);
            } else {
                if (hc.f1269b) {
                    ls.m1346c("checkEnabled: else");
                }
                this.f679b.setChecked(false);
            }
            if (!lx.ab(this)) {
                Builder builder = new Builder(this);
                builder.setIcon(R.drawable.password);
                builder.setTitle("Application Disclaimer");
                View textView = new TextView(this);
                textView.setClickable(true);
                try {
                    textView.setText(Html.fromHtml("<b><i>Welcome to utter!</b></i><br><br>Please read this disclaimer carefully, before accepting the terms.<br><br>This application is provided 'as is' and you use it entirely at your own risk. No warranties are made as to performance, merchantability, fitness for a particular purpose, or any other warranties whether expressed or implied. <br><br>No oral or written communication from or information provided by the author shall create a warranty. Under no circumstances shall the author be liable for direct, indirect, special, incidental, or consequential damages resulting from the use, misuse, or inability to use this software. <br><br>Use of this program implies acceptance of these conditions. If you do not accept, please click the cancel button and then uninstall the application from your device.<br><br>By accepting this disclaimer you also agree to the application's <a href='http://forum.xda-developers.com/showpost.php?p=26516535&postcount=991'>privacy policy</a> which explains how your personal and device information is used."));
                } catch (ArrayIndexOutOfBoundsException e) {
                    textView.setText("You have an Android Platform bug which will prevent this application from working correctly for you. If you would like to help me test a fix for this problem, I would be very grateful utter.android@gmail.com");
                }
                textView.setTextSize(18.0f);
                textView.setTextColor(-1);
                textView.setPadding(30, 2, 20, 10);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                builder.setPositiveButton("Accept", new cg(this));
                builder.setNegativeButton("Decline", new ch(this));
                builder.setOnCancelListener(new ci(this));
                builder.setView(textView);
                try {
                    builder.show();
                } catch (ArrayIndexOutOfBoundsException e2) {
                    e2.printStackTrace();
                    textView.setText("You have an Android Platform bug which will prevent this application from working correctly for you. If you would like to help me test a fix for this problem, I would be very grateful utter.android@gmail.com");
                    builder.show();
                }
            } else if (!lx.m1371J(this)) {
                m563c();
            } else if (lx.m1456y(this)) {
                m558a("refreshing device data", true, false);
            } else {
                m560b();
            }
            GlobalV.m786B("");
            kf.f1590b = true;
            if (VERSION.SDK_INT >= 11) {
                new kf(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"requestAccess"});
                new la(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                new ky(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                if (!GlobalV.m908z()) {
                    if (hc.f1269b) {
                        ls.m1346c("AH !getGAppListRunning - fired");
                    }
                    new kv(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else if (hc.f1269b) {
                    ls.m1346c("AH getGAppListRunning - skipping");
                }
                new hb(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                if (hc.f1270c) {
                    new kz(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }
            } else {
                new kf(this).execute(new String[]{"requestAccess"});
                new la(this).execute(new Void[0]);
                new ky(this).execute(new Void[0]);
                if (!GlobalV.m908z()) {
                    if (hc.f1269b) {
                        ls.m1346c("AH !getGAppListRunning - fired");
                    }
                    new kv(this).execute(new Void[0]);
                } else if (hc.f1269b) {
                    ls.m1346c("AH getGAppListRunning - skipping");
                }
                new hb(this).execute(new Void[0]);
                if (hc.f1270c) {
                    new kz(this).execute(new Void[0]);
                }
            }
            this.f681e.m1593a(gr.m993a(this));
            return;
        }
        finish();
    }

    @SuppressLint({"NewApi"})
    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("homeActivity onDestroy");
        }
        if (this.f681e != null) {
            this.f681e.removeAllViews();
            this.f681e.m1592a();
        }
        getWindow().clearFlags(128);
        if (hc.f1269b && GlobalV.m840f()) {
            if (hc.f1269b) {
                ls.m1346c("homeActivity onDestroy: replacing hosts file");
            }
            if (VERSION.SDK_INT >= 11) {
                new gs(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Boolean[]{Boolean.valueOf(false)});
            } else {
                new gs(this).execute(new Boolean[]{Boolean.valueOf(false)});
            }
        } else if (hc.f1269b) {
            ls.m1346c("homeActivity onDestroy: no host file action");
        }
        if (this.f682f != null && this.f682f.getBoolean("shutdown", false)) {
            System.exit(0);
        }
    }

    public void onPause() {
        super.onPause();
        if (hc.f1269b) {
            ls.m1346c("homeActivity onPause");
        }
    }

    public void onResume() {
        super.onResume();
        if (hc.f1269b) {
            ls.m1346c("homeActivity onResume");
        }
        if (ServiceTTS.f854f && GlobalV.m865m() == 16) {
            m566d();
        }
    }
}
