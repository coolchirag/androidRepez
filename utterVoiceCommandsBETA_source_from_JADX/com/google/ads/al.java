package com.google.ads;

import android.app.Activity;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.p028a.C0229a;
import com.google.ads.p028a.C0230b;
import com.google.ads.p028a.C0231c;
import com.google.ads.p028a.C0232d;
import com.google.ads.p028a.C0233e;
import com.google.ads.util.C0290d;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class al implements Runnable {
    private final aj f1983a;
    private final String f1984b;
    private final C0237d f1985c;
    private final HashMap<String, String> f1986d;
    private final boolean f1987e;
    private final WeakReference<Activity> f1988f;

    public al(aj ajVar, Activity activity, String str, C0237d c0237d, HashMap<String, String> hashMap) {
        boolean z;
        this.f1983a = ajVar;
        this.f1984b = str;
        this.f1988f = new WeakReference(activity);
        this.f1985c = c0237d;
        this.f1986d = new HashMap(hashMap);
        String str2 = (String) this.f1986d.remove("gwhirl_share_location");
        if ("1".equals(str2)) {
            z = true;
        } else {
            if (!(str2 == null || QueryParamConst.U_VALUE.equals(str2))) {
                C0290d.m1865b("Received an illegal value, '" + str2 + "', for the special share location parameter from mediation server (expected '0' or '1'). Will not share the location.");
            }
            z = false;
        }
        this.f1987e = z;
    }

    private void m1623a(String str, Throwable th, ai aiVar) {
        C0290d.m1866b(str, th);
        this.f1983a.m1615a(aiVar);
    }

    public final void run() {
        try {
            C0290d.m1862a("Trying to instantiate: " + this.f1984b);
            C0230b c0230b = (C0230b) C0230b.class.cast(Class.forName(this.f1984b).newInstance());
            Activity activity = (Activity) this.f1988f.get();
            if (activity == null) {
                throw new am("Activity became null while trying to instantiate adapter.");
            }
            this.f1983a.m1614a(c0230b);
            Class c = c0230b.m1600c();
            if (c != null) {
                ((C0233e) c.newInstance()).m1603a(this.f1986d);
            }
            c = c0230b.m1599b();
            if (c != null) {
                this.f1985c.m1640a(c);
            }
            C0229a c0229a = new C0229a(this.f1985c, activity, this.f1987e);
            if (this.f1983a.f1968a.m1798a()) {
                if (c0230b instanceof C0232d) {
                    C0232d c0232d = (C0232d) c0230b;
                    ao aoVar = new ao(this.f1983a);
                    c0232d.m1602d();
                } else {
                    throw new am("Adapter " + this.f1984b + " doesn't support the MediationInterstitialAdapter interface.");
                }
            } else if (c0230b instanceof C0231c) {
                C0231c c0231c = (C0231c) c0230b;
                an anVar = new an(this.f1983a);
                this.f1983a.f1968a.m1799b();
                c0231c.m1601d();
            } else {
                throw new am("Adapter " + this.f1984b + " doesn't support the MediationBannerAdapter interface");
            }
            this.f1983a.m1621g();
        } catch (Throwable e) {
            m1623a("Cannot find adapter class '" + this.f1984b + "'. Did you link the ad network's mediation adapter? Skipping ad network.", e, ai.NOT_FOUND);
        } catch (Throwable e2) {
            m1623a("Error while creating adapter and loading ad from ad network. Skipping ad network.", e2, ai.EXCEPTION);
        }
    }
}
