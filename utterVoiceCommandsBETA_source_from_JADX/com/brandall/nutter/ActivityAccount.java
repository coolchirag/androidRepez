package com.brandall.nutter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;

public class ActivityAccount extends Activity {
    UITableView f648a;
    private AdView f649b;

    static /* synthetic */ void m481a(ActivityAccount activityAccount) {
        if (mb.m1470a(activityAccount)) {
            jy.m1274y(activityAccount, "http://www.utter.me.uk/redirect.asp?id=" + lx.m1450s(activityAccount) + "&page=profile");
            return;
        }
        lc.m1313a(activityAccount, false, "Please create an account or register this device.");
        if (VERSION.SDK_INT >= 11) {
            new kz(activityAccount).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new kz(activityAccount).execute(new Void[0]);
        }
    }

    static /* synthetic */ void m483b(ActivityAccount activityAccount) {
        if (mb.m1470a(activityAccount)) {
            jy.m1274y(activityAccount, "http://www.utter.me.uk/redirect.asp?id=" + lx.m1450s(activityAccount) + "&page=mystats");
            return;
        }
        lc.m1313a(activityAccount, false, "Please create an account or register this device.");
        if (VERSION.SDK_INT >= 11) {
            new kz(activityAccount).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new kz(activityAccount).execute(new Void[0]);
        }
    }

    static /* synthetic */ void m484c(ActivityAccount activityAccount) {
        if (mb.m1470a(activityAccount)) {
            kz.f1635d = true;
            if (VERSION.SDK_INT >= 11) {
                new kz(activityAccount).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else {
                new kz(activityAccount).execute(new Void[0]);
                return;
            }
        }
        lc.m1313a(activityAccount, false, "Please create an account or register this device.");
        if (VERSION.SDK_INT >= 11) {
            new kz(activityAccount).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new kz(activityAccount).execute(new Void[0]);
        }
    }

    static /* synthetic */ void m485d(ActivityAccount activityAccount) {
        if (mb.m1470a(activityAccount)) {
            jy.m1274y(activityAccount, "http://www.utter.me.uk/redirect.asp?id=" + lx.m1450s(activityAccount) + "&page=LOCATION");
            return;
        }
        lc.m1313a(activityAccount, false, "Please create an account or register this device.");
        if (VERSION.SDK_INT >= 11) {
            new kz(activityAccount).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new kz(activityAccount).execute(new Void[0]);
        }
    }

    static /* synthetic */ void m486e(ActivityAccount activityAccount) {
        if (mb.m1470a(activityAccount)) {
            kz.f1634c = true;
            if (VERSION.SDK_INT >= 11) {
                new kz(activityAccount).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else {
                new kz(activityAccount).execute(new Void[0]);
                return;
            }
        }
        lc.m1313a(activityAccount, false, "Please create an account or register this device.");
        if (VERSION.SDK_INT >= 11) {
            new kz(activityAccount).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new kz(activityAccount).execute(new Void[0]);
        }
    }

    static /* synthetic */ void m487f(ActivityAccount activityAccount) {
        Intent intent = new Intent(activityAccount, ActivityTesting.class);
        intent.setFlags(603979776);
        activityAccount.startActivity(intent);
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
        setContentView(R.layout.account_layout);
        if (hc.f1269b) {
            ls.m1346c("ActivityAccount OnCreate");
        }
        this.f649b = (AdView) findViewById(R.id.adView);
        this.f648a = (UITableView) findViewById(R.id.tableView);
        this.f648a.setClickListener(new C0144c());
        C0090a c0090a = new C0090a("My Account");
        c0090a.f294b = R.drawable.account;
        c0090a.f297e = "tap to create";
        this.f648a.m292a(c0090a);
        c0090a = new C0090a("View Stats");
        c0090a.f294b = R.drawable.stats;
        c0090a.f297e = "tap to view";
        this.f648a.m292a(c0090a);
        c0090a = new C0090a("Send Location");
        c0090a.f294b = R.drawable.locationpin;
        c0090a.f297e = "tap to update";
        this.f648a.m292a(c0090a);
        c0090a = new C0090a("View Location");
        c0090a.f294b = R.drawable.maps24;
        c0090a.f297e = "tap to view";
        this.f648a.m292a(c0090a);
        c0090a = new C0090a("Remote Function");
        c0090a.f294b = R.drawable.remote;
        c0090a.f297e = "tap to test";
        this.f648a.m292a(c0090a);
        if (lx.m1436k(this).matches("a")) {
            c0090a = new C0090a("Testing");
            c0090a.f294b = R.drawable.remote;
            c0090a.f297e = "tap to test";
            this.f648a.m292a(c0090a);
        }
        this.f648a.m291a();
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
        }
        c0237d.m1636a(a);
        this.f649b.m1593a(c0237d);
    }

    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("ActivityAccount onDestroy");
        }
        if (this.f649b != null) {
            this.f649b.removeAllViews();
            this.f649b.m1592a();
        }
        getWindow().clearFlags(128);
    }

    public void onPause() {
        super.onPause();
        if (hc.f1269b) {
            ls.m1346c("ActivityAccount onPause");
        }
    }

    public void onResume() {
        super.onResume();
        if (hc.f1269b) {
            ls.m1346c("ActivityAccount onResume");
        }
    }
}
