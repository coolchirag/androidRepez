package com.brandall.nutter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import br.com.dina.ui.widget.C0100d;
import java.util.ArrayList;
import java.util.Iterator;

final class cn implements C0100d {
    final /* synthetic */ ActivityHome f1016a;

    private cn(ActivityHome activityHome) {
        this.f1016a = activityHome;
    }

    public final void mo73a(int i) {
        if (ServiceTTS.f854f) {
            this.f1016a.m558a("Disabled during tutorial", false, false);
            return;
        }
        switch (i) {
            case 0:
                ActivityHome.m556a(this.f1016a);
                return;
            case 1:
                jy.m1228a(this.f1016a, ActivityCommand.class, false);
                return;
            case 2:
                this.f1016a.m566d();
                return;
            case 3:
                jy.m1228a(this.f1016a, ActivityCustomise.class, false);
                return;
            case 4:
                jy.m1228a(this.f1016a, ActivitySettings.class, false);
                return;
            case 5:
                jy.m1228a(this.f1016a, ActivityLinkApps.class, false);
                return;
            case 6:
                jy.m1228a(this.f1016a, ActivityBugs.class, false);
                return;
            case 7:
                jy.m1228a(this.f1016a, ActivityRecognitionVoices.class, false);
                return;
            case 8:
                jy.m1235a(this.f1016a, false, "", "", "", "");
                return;
            case 9:
                Context context = this.f1016a;
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("message/rfc822");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"utter.android@gmail.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "utter! feedback");
                intent.setFlags(268435456);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("\n--------------------");
                arrayList2.add(context.getString(R.string.app_version));
                arrayList2.add("Model: " + Build.MODEL);
                arrayList2.add("Manufacturer: " + Build.MANUFACTURER);
                arrayList2.add("SDK Build: " + String.valueOf(VERSION.SDK_INT));
                arrayList2.add("Release: " + VERSION.RELEASE);
                if (context.getSharedPreferences("utterPref", 0).getBoolean("device_rooted", false)) {
                    arrayList2.add("Root access: true");
                } else {
                    arrayList2.add("Root access: false");
                }
                arrayList2.add("--------------------");
                arrayList2.add(7, ServiceTTS.m926e());
                String o = GlobalV.m873o();
                if (o != null) {
                    try {
                        arrayList2.add(7, "Voice Search: " + o);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Iterator it = arrayList2.iterator();
                String str = "";
                while (it.hasNext()) {
                    o = (String) it.next();
                    if (hc.f1269b) {
                        ls.m1344a("devInf: " + o);
                    }
                    str = new StringBuilder(String.valueOf(str)).append("\n ").append(o).toString();
                }
                intent.putExtra("android.intent.extra.TEXT", str);
                try {
                    context.startActivity(intent);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case 10:
                jy.m1274y(this.f1016a, "https://plus.google.com/100131487913427971091");
                return;
            case 11:
                jy.m1274y(this.f1016a, "http://twitter.com/brandall76");
                return;
            case 12:
                jy.m1249e(this.f1016a, "A_irIFVI1x0");
                return;
            case 13:
                jy.m1274y(this.f1016a, "http://forum.xda-developers.com/showthread.php?t=1508195");
                return;
            case 14:
                jy.m1246d(this.f1016a);
                return;
            case 15:
                jy.m1228a(this.f1016a, ActivityAbout.class, false);
                return;
            default:
                return;
        }
    }
}
