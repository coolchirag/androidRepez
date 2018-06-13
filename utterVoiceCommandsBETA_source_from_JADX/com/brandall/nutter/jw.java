package com.brandall.nutter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.p011a.p012a.C0102b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public final class jw {
    static C0102b f1580a = new C0102b("337811739620196");

    public static boolean m1220a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("utterPref", 0);
        String string = sharedPreferences.getString("fb_access_token", null);
        long j = sharedPreferences.getLong("fb_access_expires", 0);
        if (string != null) {
            f1580a.m308b(string);
        }
        if (j != 0) {
            f1580a.m304a(j);
        }
        if (f1580a.m306a()) {
            ls.m1346c("Facebook Session Valid");
            Bundle bundle = new Bundle();
            bundle.putString("message", str);
            bundle.putString("description", "topic share");
            try {
                f1580a.m301a("me");
                String a = f1580a.m302a("me/feed", bundle, "POST");
                ls.m1346c("got response: " + a);
                if (a == null || a.equals("") || a.equals("false")) {
                    ls.m1347d("Reponse was blank");
                    return false;
                } else if (a.contains("error")) {
                    ls.m1347d("Reponse was an error");
                    return false;
                } else {
                    ls.m1346c("Message successfully posted");
                    return true;
                }
            } catch (MalformedURLException e) {
                ls.m1348e("ExecuteFacebook MalformedURLException");
                e.printStackTrace();
                return false;
            } catch (FileNotFoundException e2) {
                ls.m1348e("ExecuteFacebook FileNotFoundException");
                e2.printStackTrace();
                return false;
            } catch (IOException e3) {
                ls.m1348e("ExecuteFacebook IOException");
                e3.printStackTrace();
                return false;
            }
        }
        ls.m1347d("Facebook Session Invalid");
        return false;
    }
}
