package com.p017c.p018a;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.p017c.p018a.p019a.C0172b;

public final class C0173a {
    public static CharSequence m1510a(Context context, Intent intent, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        } else if (str == null) {
            try {
                Log.w("LocaleApiLibrary", "currentCrumb cannot be null");
                return "";
            } catch (Throwable e) {
                Log.e("LocaleApiLibrary", "Encountered error generating breadcrumb", e);
                return "";
            }
        } else if (intent == null) {
            Log.w("LocaleApiLibrary", "intent cannot be null");
            return str;
        } else {
            if (intent.getStringExtra("com.twofortyfouram.locale.intent.extra.BREADCRUMB") == null) {
                return str;
            }
            return context.getString(C0172b.f1840b, new Object[]{r0, context.getString(C0172b.f1839a), str});
        }
    }
}
