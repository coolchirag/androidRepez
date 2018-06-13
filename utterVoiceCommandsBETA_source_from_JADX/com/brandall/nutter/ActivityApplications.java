package com.brandall.nutter;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;

public class ActivityApplications extends Activity {
    private PackageManager f654a;
    private ProgressBar f655b;
    private ListView f656c;
    private AdView f657d;

    public static void m509a() {
        System.gc();
        Runtime.getRuntime().gc();
    }

    public void onBackPressed() {
        ls.m1346c("AA onBackPressed");
        ls.m1346c("AA tidyUp");
        new he(this).m1067a(GlobalV.m798K());
        GlobalV.m815a();
        m509a();
        lc.m1313a(this, false, "The command creation has been cancelled");
        finish();
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
        setContentView(R.layout.applications_layout);
        m509a();
        this.f655b = (ProgressBar) findViewById(R.id.progressBar1);
        this.f655b.setVisibility(0);
        Toast.makeText(this, "BUG ALERT! Please scroll slowly - I'm working on a fix", 1).show();
        this.f657d = (AdView) findViewById(R.id.adView);
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
        }
        c0237d.m1636a(a);
        this.f657d.m1593a(c0237d);
        this.f654a = getPackageManager();
        new aj().execute(new Void[0]);
        this.f656c = (ListView) findViewById(R.id.list);
        this.f656c.setOnItemClickListener(new ah(this));
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("AA onDestroy");
        if (this.f657d != null) {
            this.f657d.removeAllViews();
            this.f657d.m1592a();
        }
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("AA onPause");
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("AA onResume");
    }
}
