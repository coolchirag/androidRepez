package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.ExpandableListActivity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;
import java.util.ArrayList;
import java.util.List;

public class ActivityPickerActivity extends ExpandableListActivity {
    private static boolean f693c = false;
    private PackageManager f694a;
    private ProgressBar f695b;
    private AdView f696d;

    public static void m615a() {
        System.gc();
        Runtime.getRuntime().gc();
    }

    private void m617b() {
        ls.m1346c("APA tidyVariables");
        new he(this).m1067a(GlobalV.m798K());
        m615a();
        GlobalV.m815a();
    }

    static /* synthetic */ void m618c(ActivityPickerActivity activityPickerActivity) {
        ls.m1346c("APA dobError");
        if (f693c) {
            activityPickerActivity.m617b();
            lc.m1313a(activityPickerActivity, false, "Your device was too low on memory to use this feature. The command creation has been cancelled.");
        }
        activityPickerActivity.finish();
    }

    static /* synthetic */ void m619d(ActivityPickerActivity activityPickerActivity) {
        ls.m1346c("childLongClick");
        lc.m1313a(activityPickerActivity, false, "Please enter any optional data extras");
        List arrayList = new ArrayList();
        arrayList.add("NONE");
        arrayList.add("LAUNCHER");
        arrayList.add("HOME");
        arrayList.add("DEFAULT");
        List arrayList2 = new ArrayList();
        arrayList2.add("NONE");
        arrayList2.add("ACTION_VIEW");
        arrayList2.add("ACTION_EDIT");
        arrayList2.add("ACTION_MAIN");
        arrayList2.add("ACTION_PICK");
        arrayList2.add("ACTION_CALL");
        arrayList2.add("ACTION_DEFAULT");
        View inflate = ((LayoutInflater) activityPickerActivity.getSystemService("layout_inflater")).inflate(R.layout.activity_extras_dialog_layout, (ViewGroup) activityPickerActivity.findViewById(R.id.aedl));
        Builder builder = new Builder(activityPickerActivity);
        builder.setIcon(R.drawable.command);
        builder.setTitle("Enter data extras");
        builder.setInverseBackgroundForced(true);
        EditText editText = (EditText) inflate.findViewById(R.id.action);
        EditText editText2 = (EditText) inflate.findViewById(R.id.extra1);
        EditText editText3 = (EditText) inflate.findViewById(R.id.extra2);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.catagory);
        Spinner spinner2 = (Spinner) inflate.findViewById(R.id.iaction);
        spinner2.setAdapter(new ArrayAdapter(activityPickerActivity, 17367048, arrayList2));
        spinner2.setOnItemSelectedListener(new da(activityPickerActivity));
        spinner.setAdapter(new ArrayAdapter(activityPickerActivity, 17367048, arrayList));
        spinner.setOnItemSelectedListener(new db(activityPickerActivity));
        builder.setView(inflate);
        builder.setPositiveButton("Save", new dc(activityPickerActivity, editText, editText2, editText3));
        builder.setNegativeButton("Cancel", new dd(activityPickerActivity));
        builder.setOnCancelListener(new de(activityPickerActivity));
        builder.show();
    }

    public void onBackPressed() {
        ls.m1346c("APA onBackPressed");
        if (f693c) {
            m617b();
            lc.m1313a(this, false, "The command creation has been cancelled");
        }
        finish();
    }

    @SuppressLint({"NewApi"})
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        ls.m1346c("onChildClick: groupPosition: " + i + " : childPosition: " + i2);
        ActivityInfo activityInfo = (ActivityInfo) getExpandableListAdapter().getChild(i, i2);
        ls.m1344a("packageName: " + activityInfo.applicationInfo.packageName);
        ls.m1344a("name: " + activityInfo.name);
        if (f693c) {
            ls.m1346c("creator: true");
            ArrayList arrayList = new ArrayList();
            arrayList.add(activityInfo.applicationInfo.packageName);
            arrayList.add(activityInfo.name);
            if (VERSION.SDK_INT >= 11) {
                new gx(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{arrayList});
            } else {
                new gx(this).execute(new ArrayList[]{arrayList});
            }
        }
        finish();
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ls.m1345b("Landscape");
        } else if (configuration.orientation == 1) {
            ls.m1345b("Portrait");
        }
    }

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ls.m1346c("ActivityPickerActivity onCreate");
        setContentView(R.layout.activity_list);
        m615a();
        this.f695b = (ProgressBar) findViewById(R.id.progressBar2);
        this.f695b.setVisibility(0);
        Toast.makeText(this, "BUG ALERT! Please scroll slowly - I'm working on a fix", 1).show();
        this.f696d = (AdView) findViewById(R.id.adView);
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
        }
        c0237d.m1636a(a);
        this.f696d.m1593a(c0237d);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getString("sender").matches("creator")) {
            ls.m1346c("APA acknowledged creator");
            f693c = true;
        }
        getExpandableListView().setTextFilterEnabled(true);
        this.f694a = getPackageManager();
        if (VERSION.SDK_INT >= 11) {
            new df().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new df().execute(new Void[0]);
        }
        getExpandableListView().setOnItemLongClickListener(new cz(this));
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("ActivityLinkApps onDestroy");
        if (this.f696d != null) {
            this.f696d.removeAllViews();
            this.f696d.m1592a();
        }
    }
}
