package com.google.ads;

import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.util.C0290d;
import java.lang.ref.WeakReference;
import java.util.Date;

final class C0282q implements Runnable {
    private final WeakReference<Activity> f2233a;
    private final Editor f2234b;

    public C0282q(Activity activity) {
        this(activity, (byte) 0);
    }

    private C0282q(Activity activity, byte b) {
        this.f2233a = new WeakReference(activity);
        this.f2234b = null;
    }

    public final void run() {
        try {
            Activity activity = (Activity) this.f2233a.get();
            if (activity == null) {
                C0290d.m1862a("Activity was null while making a doritos cookie request.");
                return;
            }
            Object obj;
            Cursor query = activity.getContentResolver().query(C0280o.f2229b, C0280o.f2231d, null, null, null);
            if (query == null || !query.moveToFirst() || query.getColumnNames().length <= 0) {
                C0290d.m1862a("Google+ app not installed, not storing doritos cookie");
                obj = null;
            } else {
                obj = query.getString(query.getColumnIndex(query.getColumnName(0)));
            }
            Editor edit = this.f2234b == null ? PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext()).edit() : this.f2234b;
            if (TextUtils.isEmpty(obj)) {
                edit.putString("drt", "");
                edit.putLong("drt_ts", 0);
            } else {
                edit.putString("drt", obj);
                edit.putLong("drt_ts", new Date().getTime());
            }
            edit.commit();
        } catch (Throwable th) {
            C0290d.m1866b("An unknown error occurred while sending a doritos request.", th);
        }
    }
}
