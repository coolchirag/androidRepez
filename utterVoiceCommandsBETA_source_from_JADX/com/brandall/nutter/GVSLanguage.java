package com.brandall.nutter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.Locale;

public class GVSLanguage extends BroadcastReceiver {
    private String f765a;

    public void onReceive(Context context, Intent intent) {
        Bundle resultExtras = getResultExtras(true);
        if (resultExtras != null && resultExtras.containsKey("android.speech.extra.LANGUAGE_PREFERENCE")) {
            this.f765a = resultExtras.getString("android.speech.extra.LANGUAGE_PREFERENCE");
            if (this.f765a != null) {
                Locale locale = new Locale(this.f765a);
                if (!locale.toString().matches("")) {
                    if (hc.f1269b) {
                        ls.m1344a("languagePreference: " + this.f765a + " :" + locale.getDisplayName() + " : loc: " + locale.toString());
                    }
                    GlobalV.m826c(locale.toString());
                }
            }
        }
    }
}
