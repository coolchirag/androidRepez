package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.PorterDuff.Mode;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.Vibrator;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.google.ads.AdView;

public class ActivityPowerUser extends Activity {
    private static ProgressBar f697d;
    private UITableView f698a;
    private AdView f699b;
    private final int f700c = 1;

    static /* synthetic */ void m620a(ActivityPowerUser activityPowerUser) {
        boolean an = lx.an(activityPowerUser);
        if (an) {
            if (hc.f1269b) {
                ls.m1346c("notHack: " + an);
            }
            lx.m1445o(activityPowerUser, false);
            activityPowerUser.stopService(new Intent(activityPowerUser, ServiceTTS.class));
            Intent intent = new Intent(activityPowerUser, ServiceTTS.class);
            intent.addFlags(262144);
            intent.putExtra("INT_DATA", "HOME");
            activityPowerUser.startService(intent);
            return;
        }
        if (hc.f1269b) {
            ls.m1346c("notHack: " + an);
        }
        lx.m1445o(activityPowerUser, true);
        activityPowerUser.stopService(new Intent(activityPowerUser, ServiceTTS.class));
        intent = new Intent(activityPowerUser, ServiceTTS.class);
        intent.addFlags(262144);
        intent.putExtra("INT_DATA", "HOME");
        activityPowerUser.startService(intent);
        if (activityPowerUser.getSharedPreferences("utterPref", 0).getBoolean("not_hack_first", true)) {
            Editor edit = activityPowerUser.getSharedPreferences("utterPref", 0).edit();
            edit.putBoolean("not_hack_first", false);
            edit.commit();
            GlobalV.m899w(true);
            lc.m1313a(activityPowerUser, false, "Please be aware, the use of a permanent notification is an instruction to Android not to kill me. If you do not have it enabled, Android may kill me mid command to free up memory. It's not a nice feeling. It tickles.");
            return;
        }
        activityPowerUser.m622a("WARNING! THIS MAY CAUSE UTTER! TO FUNCTION INCORRECTLY!", true);
    }

    private void m622a(String str, boolean z) {
        if (z) {
            ((Vibrator) getSystemService("vibrator")).vibrate(100);
        }
        Toast.makeText(this, str, 0).show();
    }

    static /* synthetic */ void m623b(ActivityPowerUser activityPowerUser) {
        if (lx.ac(activityPowerUser)) {
            lx.m1434j(activityPowerUser, false);
            return;
        }
        lx.m1434j(activityPowerUser, true);
        if (VERSION.SDK_INT >= 11) {
            new kf(activityPowerUser).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"requestAccess"});
            return;
        }
        new kf(activityPowerUser).execute(new String[]{"requestAccess"});
    }

    static /* synthetic */ void m625c(ActivityPowerUser activityPowerUser) {
        if (hc.f1269b) {
            ls.m1346c("userPassword");
        }
        if (!lx.m1387Z(activityPowerUser) || lx.m1385X(activityPowerUser) == null || lx.m1385X(activityPowerUser).isEmpty() || lx.m1385X(activityPowerUser).replaceAll("\\s", "").isEmpty()) {
            Dialog dialog = new Dialog(activityPowerUser);
            dialog.requestWindowFeature(3);
            View inflate = ((LayoutInflater) activityPowerUser.getSystemService("layout_inflater")).inflate(R.layout.user_password_dialog_layout, (ViewGroup) activityPowerUser.findViewById(R.id.eupdl));
            EditText editText = (EditText) inflate.findViewById(R.id.epassword);
            EditText editText2 = (EditText) inflate.findViewById(R.id.ecpassword);
            ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
            Button button = (Button) inflate.findViewById(R.id.positiveButton);
            Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
            dialog.setContentView(inflate);
            dialog.setFeatureDrawableResource(3, R.drawable.password);
            dialog.setTitle("utter! user password");
            dialog.show();
            dialog.setOnCancelListener(new dl(activityPowerUser));
            button.setOnClickListener(new dm(activityPowerUser, editText, editText2, dialog));
            button2.setOnClickListener(new dn(activityPowerUser, dialog));
            imageButton.setOnClickListener(new C0146do(activityPowerUser));
            return;
        }
        if (hc.f1269b) {
            ls.m1346c("updateUserPassword");
        }
        dialog = new Dialog(activityPowerUser);
        dialog.requestWindowFeature(3);
        View inflate2 = ((LayoutInflater) activityPowerUser.getSystemService("layout_inflater")).inflate(R.layout.update_user_password_dialog_layout, (ViewGroup) activityPowerUser.findViewById(R.id.euupdl));
        EditText editText3 = (EditText) inflate2.findViewById(R.id.cpassword);
        EditText editText4 = (EditText) inflate2.findViewById(R.id.unpassword);
        EditText editText5 = (EditText) inflate2.findViewById(R.id.unpasswordc);
        ImageButton imageButton2 = (ImageButton) inflate2.findViewById(R.id.helpButton);
        Button button3 = (Button) inflate2.findViewById(R.id.positiveButton);
        Button button4 = (Button) inflate2.findViewById(R.id.negativeButton);
        dialog.setContentView(inflate2);
        dialog.setFeatureDrawableResource(3, R.drawable.password);
        dialog.setTitle("utter! user password");
        dialog.show();
        dialog.setOnCancelListener(new dp(activityPowerUser));
        button3.setOnClickListener(new dq(activityPowerUser, editText3, editText4, editText5, dialog));
        button4.setOnClickListener(new dr(activityPowerUser, dialog));
        imageButton2.setOnClickListener(new dj(activityPowerUser));
    }

    static /* synthetic */ void m626c(ActivityPowerUser activityPowerUser, String str) {
        lx.m1386Y(activityPowerUser);
        lx.m1431i((Context) activityPowerUser, str);
    }

    static /* synthetic */ void m627d(ActivityPowerUser activityPowerUser) {
        if (hc.f1269b) {
            ls.m1346c("remoteControl");
        }
        Builder builder = new Builder(activityPowerUser);
        builder.setIcon(R.drawable.remote);
        builder.setTitle("Remote Control Disclaimer");
        View textView = new TextView(activityPowerUser);
        textView.setClickable(true);
        textView.setText(Html.fromHtml("<b><i>Important Information!</b></i><br><br>Please read this disclaimer carefully, before accepting the terms.<br><br>By accepting this disclaimer you confirm that you have read and understood the <a href='http://forum.xda-developers.com/showpost.php?p=26430008&postcount=956'>remote control disclaimer</a> which explains the usage of this feature and both the positive and possible negative consequencies of enabling it.<br><br>The user guide contains the above information and a tutorial to help you."));
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        textView.setPadding(30, 2, 20, 10);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        builder.setPositiveButton("Accept", new di(activityPowerUser));
        builder.setNegativeButton("Decline", new dk(activityPowerUser));
        builder.setView(textView);
        builder.show();
    }

    static /* synthetic */ void m628e(ActivityPowerUser activityPowerUser) {
        if (hc.f1269b) {
            ls.m1346c("smsBodyFix");
        }
        if (lx.m1418d(activityPowerUser)) {
            lc.m1313a(activityPowerUser, false, "Fix removed");
            lx.m1404b((Context) activityPowerUser, false);
            return;
        }
        ((Vibrator) activityPowerUser.getSystemService("vibrator")).vibrate(100);
        lc.m1313a(activityPowerUser, false, "Fix applied");
        lx.m1404b((Context) activityPowerUser, true);
    }

    static /* synthetic */ void m629f(ActivityPowerUser activityPowerUser) {
        if (VERSION.SDK_INT == 14 || VERSION.SDK_INT == 15) {
            ServiceTTS.f861m = true;
            lc.m1313a(activityPowerUser, true, "Permanent recognition initialised. Say, wake up, to activate me. Please be aware, this will kill you battery and use lots of data. ");
            return;
        }
        lc.m1313a(activityPowerUser, false, "Sorry, but for now this is only working for Ice Cream Sandwich.");
    }

    static /* synthetic */ void m630g(ActivityPowerUser activityPowerUser) {
        Intent intent = new Intent("ua.com.vassiliev.androidfilebrowser.SELECT_DIRECTORY_ACTION", null, activityPowerUser, FileBrowserActivity.class);
        intent.putExtra("ua.com.vassiliev.androidfilebrowser.directoryPath", Environment.getExternalStorageDirectory());
        activityPowerUser.startActivityForResult(intent, 1);
    }

    static /* synthetic */ void m631h(ActivityPowerUser activityPowerUser) {
        if (hc.f1269b) {
            ls.m1346c("bootSetting");
        }
        if (lx.m1396a(activityPowerUser)) {
            lx.m1395a((Context) activityPowerUser, false);
            lc.m1313a(activityPowerUser, false, "I won't start until you manually activate me");
            return;
        }
        lx.m1395a((Context) activityPowerUser, true);
        lc.m1313a(activityPowerUser, false, "I will run in the background when the device first boots");
    }

    static /* synthetic */ void m632i(ActivityPowerUser activityPowerUser) {
        if (hc.f1269b) {
            ls.m1346c("shutdown");
        }
        f697d.setVisibility(0);
        lp.m1341a((Context) activityPowerUser);
    }

    static /* synthetic */ void m633j(ActivityPowerUser activityPowerUser) {
        Editor edit = activityPowerUser.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("child_protection", true);
        edit.commit();
        lx.ar(activityPowerUser);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("ua.com.vassiliev.androidfilebrowser.directoryPathRet");
            if (hc.f1269b) {
                ls.m1346c("musicDir: " + stringExtra);
            }
            Editor edit = getSharedPreferences("utterPref", 0).edit();
            edit.putString("camera_dir", stringExtra);
            edit.putBoolean("camera_dir_condition", true);
            edit.commit();
            lx.ar(this);
            lc.m1313a(this, false, "Your selection has been stored.");
            return;
        }
        if (hc.f1269b) {
            ls.m1346c("newDir: no dir selected");
        }
        lc.m1313a(this, false, "Cancelled");
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
        ls.m1346c("PowerUser OnCreate");
        setContentView(R.layout.power_user_layout);
        this.f699b = (AdView) findViewById(R.id.adView);
        StrictMode.setThreadPolicy(new ThreadPolicy.Builder().permitAll().build());
        this.f698a = (UITableView) findViewById(R.id.tableView);
        this.f698a.setClickListener(new ds());
        C0090a c0090a = new C0090a("Remove Notification");
        c0090a.f294b = R.drawable.utternot24;
        c0090a.f297e = "tap to toggle";
        if (lx.an(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f698a.m292a(c0090a);
        c0090a = new C0090a("Superuser Permission");
        c0090a.f294b = R.drawable.rootx;
        c0090a.f297e = "tap to toggle";
        if (lx.ac(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f698a.m292a(c0090a);
        c0090a = new C0090a("User Password");
        c0090a.f294b = R.drawable.password;
        c0090a.f297e = "tap to set";
        if (lx.m1387Z(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f698a.m292a(c0090a);
        c0090a = new C0090a("Remote Control");
        c0090a.f294b = R.drawable.remote;
        c0090a.f297e = "tap to enable";
        if (lx.m1376O(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f698a.m292a(c0090a);
        c0090a = new C0090a("SMS Body Fix");
        c0090a.f294b = R.drawable.sms;
        c0090a.f297e = "tap to toggle";
        if (lx.m1418d(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f698a.m292a(c0090a);
        c0090a = new C0090a("Wake-Up-Phrase (test)");
        c0090a.f294b = R.drawable.wakeup;
        c0090a.f297e = "ICS only";
        this.f698a.m292a(c0090a);
        c0090a = new C0090a("Camera Directory");
        c0090a.f294b = R.drawable.cameradir;
        c0090a.f297e = "tap to set";
        if (lx.m1368G(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f698a.m292a(c0090a);
        c0090a = new C0090a("Start at Boot");
        c0090a.f294b = R.drawable.power_green;
        c0090a.f297e = "tap to toggle";
        if (lx.m1396a(this)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f698a.m292a(c0090a);
        c0090a = new C0090a("Shutdown");
        c0090a.f294b = R.drawable.shutdown;
        c0090a.f297e = "tap to kill";
        this.f698a.m292a(c0090a);
        this.f698a.m291a();
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBarPW);
        f697d = progressBar;
        progressBar.getIndeterminateDrawable().setColorFilter(-65536, Mode.MULTIPLY);
        this.f699b.m1593a(gr.m993a(this));
    }

    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("PowerUser onDestroy");
        }
        if (this.f699b != null) {
            this.f699b.removeAllViews();
            this.f699b.m1592a();
        }
    }

    public void onPause() {
        super.onPause();
        if (hc.f1269b) {
            ls.m1346c("PowerUser onPause");
        }
    }

    public void onResume() {
        super.onResume();
        if (hc.f1269b) {
            ls.m1346c("PowerUser onResume");
        }
    }
}
