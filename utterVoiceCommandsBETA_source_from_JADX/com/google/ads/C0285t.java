package com.google.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class C0285t {
    public static boolean m1816a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
        return C0285t.m1817a(intent, context);
    }

    public static boolean m1817a(Intent intent, Context context) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
