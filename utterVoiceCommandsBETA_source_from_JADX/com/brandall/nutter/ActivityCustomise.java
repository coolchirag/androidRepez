package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.backup.BackupManager;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff.Mode;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.google.ads.AdView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ActivityCustomise extends Activity {
    public static ProgressBar f668a;
    static final Object[] f669b = new Object[0];
    UITableView f670c;
    lb f671d;
    private String f672e = "";
    private CheckBox f673f;
    private CheckBox f674g;
    private String f675h = "";
    private AdView f676i;

    public static void m525a() {
        try {
            f668a.setVisibility(4);
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1347d("AC Activity dead");
            }
        }
    }

    static /* synthetic */ void m526a(ActivityCustomise activityCustomise) {
        if (hc.f1269b) {
            ls.m1346c("in customIntro");
        }
        Dialog dialog = new Dialog(activityCustomise);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activityCustomise.getSystemService("layout_inflater")).inflate(R.layout.intro_dialog_layout, (ViewGroup) activityCustomise.findViewById(R.id.idl));
        EditText editText = (EditText) inflate.findViewById(R.id.intro);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        dialog.setContentView(inflate);
        if (lx.ak(activityCustomise)) {
            CharSequence string = activityCustomise.getSharedPreferences("utterPref", 0).getString("user_intro", "");
            if (!(string.isEmpty() || string.matches("silence"))) {
                editText.setHint(string);
            }
        }
        dialog.setFeatureDrawableResource(3, R.drawable.intro);
        dialog.setTitle("User Introduction");
        dialog.show();
        dialog.setOnCancelListener(new cb(activityCustomise));
        button.setOnClickListener(new cc(activityCustomise, editText, dialog));
        button2.setOnClickListener(new bf(activityCustomise, dialog));
        imageButton.setOnClickListener(new bg(activityCustomise));
    }

    static /* synthetic */ void m528a(ActivityCustomise activityCustomise, String str, String str2) {
        lc.m1313a(activityCustomise, false, "I've created that custom replacement. All occurrences  of, " + str + ", will be replaced by, " + str2);
        new hk(activityCustomise).m1116a(str, str2);
        lx.m1424f((Context) activityCustomise, true);
    }

    static /* synthetic */ void m529a(ActivityCustomise activityCustomise, String str, String str2, boolean z) {
        String str3 = null;
        int a = jk.m1207a((Context) activityCustomise, str);
        he heVar = new he(activityCustomise);
        if (str2.toLowerCase(Locale.US).contains("se~")) {
            str3 = str2.toLowerCase(Locale.US).replaceAll("se~", ", Sound effect of a ");
            int i = 1;
        } else {
            boolean z2 = false;
        }
        switch (a) {
            case 0:
                if (z) {
                    if (i != 0) {
                        lc.m1313a(activityCustomise, false, "When you say the phrase. " + str + ". I'll respond with. " + str3 + ", and start listening.");
                    } else {
                        lc.m1313a(activityCustomise, false, "When you say the phrase. " + str + ". I'll respond with. " + str2 + ", and start listening.");
                    }
                } else if (i != 0) {
                    lc.m1313a(activityCustomise, false, "When you say the phrase. " + str + ". I'll respond with. " + str3);
                } else {
                    lc.m1313a(activityCustomise, false, "When you say the phrase. " + str + ". I'll respond with. " + str2);
                }
                if (!activityCustomise.f675h.matches("")) {
                    if (hc.f1269b) {
                        ls.m1346c("voiceEngineLocale: " + activityCustomise.f675h);
                    }
                    if (activityCustomise.f672e.matches("")) {
                        activityCustomise.f671d = heVar.m1065a(str.toLowerCase(Locale.US).trim(), 777, str2.toLowerCase(Locale.US).trim(), "NULL", String.valueOf(z), "NULL", "NULL", activityCustomise.f675h);
                        return;
                    }
                    if (hc.f1269b) {
                        ls.m1346c("recogLocale: " + activityCustomise.f672e);
                    }
                    activityCustomise.f671d = heVar.m1065a(str.toLowerCase(Locale.US).trim(), 777, str2.toLowerCase(Locale.US).trim(), "NULL", String.valueOf(z), "NULL", activityCustomise.f672e, activityCustomise.f675h);
                    return;
                } else if (activityCustomise.f672e.matches("")) {
                    activityCustomise.f671d = heVar.m1065a(str.toLowerCase(Locale.US).trim(), 777, str2.toLowerCase(Locale.US).trim(), "NULL", String.valueOf(z), "NULL", "NULL", "NULL");
                    return;
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("recogLocale: " + activityCustomise.f672e);
                    }
                    activityCustomise.f671d = heVar.m1065a(str.toLowerCase(Locale.US).trim(), 777, str2.toLowerCase(Locale.US).trim(), "NULL", String.valueOf(z), "NULL", activityCustomise.f672e, "NULL");
                    return;
                }
            case 999:
                lc.m1313a(activityCustomise, false, "Sorry, a database error occurred.");
                return;
            default:
                if (z) {
                    if (i != 0) {
                        lc.m1313a(activityCustomise, false, "I've updated the current phrase. When you say. " + str + ". I'll respond with. " + str3 + ", and start listening.");
                    } else {
                        lc.m1313a(activityCustomise, false, "I've updated the current phrase. When you say. " + str + ". I'll respond with. " + str2 + ", and start listening.");
                    }
                } else if (i != 0) {
                    lc.m1313a(activityCustomise, false, "I've updated the current phrase. When you say. " + str + ". I'll respond with. " + str3);
                } else {
                    lc.m1313a(activityCustomise, false, "I've updated the current phrase. When you say. " + str + ". I'll respond with. " + str2);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("keyword", str);
                contentValues.put("success_words", str2);
                contentValues.put("command_int", Integer.valueOf(777));
                contentValues.put("string_1", String.valueOf(z));
                if (activityCustomise.f675h.matches("")) {
                    contentValues.put("string_4", "NULL");
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("userLocaleSelection: " + activityCustomise.f675h);
                    }
                    contentValues.put("string_4", activityCustomise.f675h);
                }
                heVar.getWritableDatabase().update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(a)});
                return;
        }
    }

    static /* synthetic */ void m530a(ActivityCustomise activityCustomise, ArrayList arrayList, ArrayList arrayList2) {
        ls.m1346c("langDialog");
        lc.m1313a(activityCustomise, false, "Please select your native recognition language.");
        Builder builder = new Builder(activityCustomise);
        builder.setIcon(R.drawable.gvs);
        builder.setTitle("Select Language");
        builder.setInverseBackgroundForced(true);
        View listView = new ListView(activityCustomise);
        listView.setAdapter(new ArrayAdapter(activityCustomise, 17367043, 16908308, arrayList));
        builder.setNegativeButton("Cancel", new bq(activityCustomise));
        builder.setOnCancelListener(new br(activityCustomise));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new bs(activityCustomise, arrayList2, create));
        create.show();
    }

    private void m531a(String str) {
        ((Vibrator) getSystemService("vibrator")).vibrate(100);
        Toast.makeText(this, str, 0).show();
    }

    private void m532a(ArrayList<Locale> arrayList) {
        if (hc.f1269b) {
            ls.m1346c("localeDialog");
        }
        lc.m1313a(this, false, "Please select the language in which I should respond.");
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.phrases);
        builder.setTitle("Select the Locale");
        builder.setInverseBackgroundForced(true);
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Locale) it.next()).toString());
        }
        View listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter(this, 17367043, 16908308, arrayList2));
        builder.setOnCancelListener(new bt(this));
        builder.setNegativeButton("Cancel", new bu(this));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new bv(this, create));
        create.show();
    }

    static /* synthetic */ void m533b(ActivityCustomise activityCustomise) {
        View inflate = ((LayoutInflater) activityCustomise.getSystemService("layout_inflater")).inflate(R.layout.phrase_dialog_layout, (ViewGroup) activityCustomise.findViewById(R.id.pdl));
        Builder builder = new Builder(activityCustomise);
        builder.setIcon(R.drawable.phrases);
        builder.setTitle("Custom Phrases");
        builder.setMessage("Create your own responses!");
        builder.setInverseBackgroundForced(true);
        EditText editText = (EditText) inflate.findViewById(R.id.phrase);
        EditText editText2 = (EditText) inflate.findViewById(R.id.response);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkBox1);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        activityCustomise.f674g = (CheckBox) inflate.findViewById(R.id.checkBoxnerl);
        activityCustomise.f673f = (CheckBox) inflate.findViewById(R.id.checkBox2);
        builder.setView(inflate);
        Dialog show = builder.show();
        show.setOnCancelListener(new bh(activityCustomise));
        checkBox.setOnCheckedChangeListener(new bi(activityCustomise));
        activityCustomise.f674g.setOnCheckedChangeListener(new bj(activityCustomise));
        activityCustomise.f673f.setOnCheckedChangeListener(new bk(activityCustomise));
        button.setOnClickListener(new bl(activityCustomise, editText, editText2, checkBox, show));
        button2.setOnClickListener(new bm(activityCustomise, show));
        imageButton.setOnClickListener(new bn(activityCustomise));
    }

    static /* synthetic */ void m535c(ActivityCustomise activityCustomise) {
        if (hc.f1269b) {
            ls.m1346c("in customCommands");
        }
        lc.m1313a(activityCustomise, false, "Please select the action the command will perform");
        Builder builder = new Builder(activityCustomise);
        builder.setIcon(R.drawable.command);
        builder.setTitle("Select Command Action");
        builder.setItems(new String[]{"Display Contact", "Call Contact", "Open Application", "Launch Activity", "Run Tasker Task"}, new bz(activityCustomise));
        builder.setNegativeButton("Cancel", new ca(activityCustomise));
        builder.show();
    }

    static /* synthetic */ void m537d(ActivityCustomise activityCustomise) {
        if (hc.f1269b) {
            ls.m1346c("in editCommands");
        }
        activityCustomise.startActivity(new Intent(activityCustomise, ActivityUserPhrases.class));
    }

    static /* synthetic */ void m539e(ActivityCustomise activityCustomise) {
        if (hc.f1270c) {
            activityCustomise.startActivity(new Intent(activityCustomise, ActivityAccount.class));
        } else {
            activityCustomise.m531a("coming soon!");
        }
    }

    static /* synthetic */ void m540f(ActivityCustomise activityCustomise) {
        lc.m1313a(activityCustomise, false, "Please select the contact");
        Intent intent = new Intent(activityCustomise, ActivityContactPicker.class);
        intent.setFlags(1073741824);
        intent.setFlags(268435456);
        intent.putExtra("sender", "nicknames");
        activityCustomise.startActivity(intent);
    }

    static /* synthetic */ void m542h(ActivityCustomise activityCustomise) {
        View inflate = ((LayoutInflater) activityCustomise.getSystemService("layout_inflater")).inflate(R.layout.words_dialog_layout, (ViewGroup) activityCustomise.findViewById(R.id.wdl));
        Builder builder = new Builder(activityCustomise);
        builder.setIcon(R.drawable.replace);
        builder.setTitle("Custom Words");
        builder.setMessage("Enter word or phrase & replacement");
        builder.setInverseBackgroundForced(true);
        EditText editText = (EditText) inflate.findViewById(R.id.mywords);
        EditText editText2 = (EditText) inflate.findViewById(R.id.myreplace);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        builder.setView(inflate);
        Dialog show = builder.show();
        show.setOnCancelListener(new bp(activityCustomise));
        button.setOnClickListener(new bw(activityCustomise, editText, editText2, show));
        button2.setOnClickListener(new bx(activityCustomise, show));
        imageButton.setOnClickListener(new by(activityCustomise));
    }

    static /* synthetic */ void m544j(ActivityCustomise activityCustomise) {
        if (hc.f1270c) {
            activityCustomise.startActivity(new Intent(activityCustomise, ActivityCommunity.class));
        } else {
            activityCustomise.m531a("coming soon!");
        }
    }

    static /* synthetic */ void m546l(ActivityCustomise activityCustomise) {
        lc.m1313a(activityCustomise, false, "Thank you. Your request has been queued with Google, and will be processed, I quote, At some point in the future.");
        BackupManager backupManager = new BackupManager(activityCustomise);
        synchronized (f669b) {
            if (hc.f1269b) {
                ls.m1346c("saveCloud dataLock");
            }
            backupManager.dataChanged();
        }
        if (hc.f1269b) {
            ls.m1346c("saveCloud out of dataLock");
        }
    }

    static /* synthetic */ void m547m(ActivityCustomise activityCustomise) {
        if (hc.f1269b) {
            ls.m1346c("restoreCloud");
        }
        lc.m1313a(activityCustomise, false, "Thank you. Your request has been queued with Google and will be processed shortly.");
        new BackupManager(activityCustomise).requestRestore(new be(activityCustomise));
    }

    static /* synthetic */ void m548n(ActivityCustomise activityCustomise) {
        f668a.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            new nu(activityCustomise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new nu(activityCustomise).execute(new Void[0]);
        }
    }

    static /* synthetic */ void m549o(ActivityCustomise activityCustomise) {
        f668a.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            new gu(activityCustomise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new gu(activityCustomise).execute(new Void[0]);
        }
    }

    static /* synthetic */ boolean m550p(ActivityCustomise activityCustomise) {
        mw b = mv.m1489b(activityCustomise);
        if (b.equals(mw.NotInstalled)) {
            if (hc.f1269b) {
                ls.m1347d("taskerStatus: NotInstalled");
            }
            lc.m1313a(activityCustomise, false, "You need to have Tasker installed to use this feature.");
            return false;
        } else if (b.equals(mw.NotEnabled)) {
            if (hc.f1269b) {
                ls.m1347d("taskerStatus: NotEnabled or wrong version");
            }
            String a = mv.m1485a((Context) activityCustomise);
            String str = "";
            if (a.matches("net.dinglisch.android.tasker")) {
                if (hc.f1269b) {
                    ls.m1346c("tskpack Direct: " + a);
                }
                str = "net.dinglisch.android.tasker";
            } else if (a.matches("net.dinglisch.android.taskerm")) {
                if (hc.f1269b) {
                    ls.m1346c("tskpack Market: " + a);
                }
                str = "net.dinglisch.android.taskerm";
            }
            if (jy.m1251f(activityCustomise, str)) {
                lc.m1313a(activityCustomise, false, "Please check that Tasker is enabled.");
            } else {
                lc.m1313a(activityCustomise, false, "Sorry, but there appears to be a problem with your Tasker installation.");
            }
            return false;
        } else if (b.equals(mw.AccessBlocked)) {
            if (hc.f1269b) {
                ls.m1347d("taskerStatus: AccessBlocked");
            }
            Intent intent = new Intent(mv.m1488b());
            intent.setFlags(268435456);
            activityCustomise.startActivity(intent);
            lc.m1313a(activityCustomise, false, "So I can execute tasks for you, please tick the box that allows external access.");
            return false;
        } else if (b.equals(mw.OK)) {
            if (hc.f1269b) {
                ls.m1346c("taskerStatus: OK");
            }
            return true;
        } else {
            if (hc.f1269b) {
                ls.m1347d("taskerStatus: " + b);
            }
            lc.m1313a(activityCustomise, false, "There was an error communicating with Tasker.");
            return false;
        }
    }

    static /* synthetic */ void m552r(ActivityCustomise activityCustomise) {
        BroadcastReceiver boVar = new bo(activityCustomise);
        activityCustomise.sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, boVar, null, -1, null, null);
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
                m532a(arrayList);
            } catch (Exception e) {
                e.printStackTrace();
                this.f673f.setChecked(false);
                lc.m1313a(this, false, "The data for that voice engine is corrupt.");
                this.f675h = "";
            }
        } else if (i == 3) {
            lc.m1313a(this, false, "Already got result");
        } else {
            try {
                this.f673f.setChecked(false);
                lc.m1313a(this, false, "I will use your default voice engine and language");
            } catch (Exception e2) {
                e2.printStackTrace();
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
            ls.m1346c("ActivityCustomise OnCreate");
        }
        setContentView(R.layout.customise_layout);
        this.f676i = (AdView) findViewById(R.id.adView);
        this.f670c = (UITableView) findViewById(R.id.tableView);
        this.f670c.setClickListener(new cd());
        C0090a c0090a = new C0090a("Custom Intro");
        c0090a.f294b = R.drawable.intro;
        c0090a.f297e = "tap to configure";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Custom Phrases");
        c0090a.f294b = R.drawable.phrases;
        c0090a.f297e = "tap to create";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Create Commands");
        c0090a.f294b = R.drawable.command;
        c0090a.f297e = "tap to customise";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Edit Commands");
        c0090a.f294b = R.drawable.commandedit;
        c0090a.f297e = "tap to edit";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Account");
        c0090a.f294b = R.drawable.account;
        c0090a.f297e = "tap to access";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Nicknames");
        c0090a.f294b = R.drawable.nicknames;
        c0090a.f297e = "tap to select";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Edit Nicknames");
        c0090a.f294b = R.drawable.people;
        c0090a.f297e = "tap to edit";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Replace Words");
        c0090a.f294b = R.drawable.replace;
        c0090a.f297e = "tap to configure";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Edit Words");
        c0090a.f294b = R.drawable.documentedit;
        c0090a.f297e = "tap to edit";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Community");
        c0090a.f294b = R.drawable.communitycolour;
        c0090a.f297e = "tap to contribute";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Location Profiles");
        c0090a.f294b = R.drawable.locationpin;
        c0090a.f297e = "tap within range";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Backup to Cloud");
        c0090a.f294b = R.drawable.cloudblue;
        c0090a.f297e = "tap to backup";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Restore from Cloud");
        c0090a.f294b = R.drawable.cloudpink;
        c0090a.f297e = "tap to restore";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Import Commands");
        c0090a.f294b = R.drawable.myimport;
        c0090a.f297e = "tap to import";
        this.f670c.m292a(c0090a);
        c0090a = new C0090a("Export Commands");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to export";
        this.f670c.m292a(c0090a);
        this.f670c.m291a();
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar4);
        f668a = progressBar;
        progressBar.getIndeterminateDrawable().setColorFilter(-65536, Mode.MULTIPLY);
        this.f676i.m1593a(gr.m993a(this));
    }

    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("ActivityCustomise onDestroy");
        }
        getWindow().clearFlags(128);
        if (this.f676i != null) {
            this.f676i.removeAllViews();
            this.f676i.m1592a();
        }
    }

    public void onPause() {
        super.onPause();
        if (hc.f1269b) {
            ls.m1346c("ActivityCustomise onPause");
        }
    }

    public void onResume() {
        super.onResume();
        if (hc.f1269b) {
            ls.m1346c("ActivityCustomise onResume");
        }
        if (ServiceTTS.f854f) {
            getWindow().addFlags(128);
        }
    }
}
