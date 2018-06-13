package com.brandall.nutter;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.google.ads.C0237d;
import com.google.ads.C0244f;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public final class gr {
    public static C0237d m993a(Context context) {
        if (hc.f1269b) {
            ls.m1346c("AdHelper getAdRequest");
        }
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (lx.m1452u(context).matches("F")) {
            if (hc.f1269b) {
                ls.m1346c("AdHelper setting Female");
            }
            c0237d.m1637a(C0244f.FEMALE);
        } else if (lx.m1452u(context).matches("M")) {
            if (hc.f1269b) {
                ls.m1346c("AdHelper setting Male");
            }
            c0237d.m1637a(C0244f.MALE);
        }
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
            c0237d.m1638a("0054687B0859D6CFF7AB43238D71ADBE");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
        }
        c0237d.m1636a(a);
        return c0237d;
    }

    public static boolean m994b(Context context) {
        boolean z;
        if (hc.f1269b) {
            ls.m1346c("in checkAdmob");
        }
        Locale locale = Locale.US;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/etc/hosts"));
            String readLine;
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    z = false;
                    break;
                }
            } while (!readLine.toLowerCase(locale).contains("googleads"));
            if (hc.f1269b) {
                ls.m1347d("ads blocked");
            }
            z = true;
        } catch (IOException e) {
            if (hc.f1269b) {
                ls.m1347d("hosts file not found");
            }
            z = false;
        }
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("ad_block", z);
        edit.commit();
        return z;
    }
}
