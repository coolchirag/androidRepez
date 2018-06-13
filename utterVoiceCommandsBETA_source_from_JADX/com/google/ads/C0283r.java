package com.google.ads;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.util.C0290d;
import java.lang.ref.WeakReference;

final class C0283r implements Runnable {
    private final WeakReference<Activity> f2235a;
    private final WebView f2236b;
    private final String f2237c;

    public C0283r(Activity activity, WebView webView, String str) {
        this.f2235a = new WeakReference(activity);
        this.f2237c = str;
        this.f2236b = webView;
    }

    public final void run() {
        try {
            Uri withAppendedPath = Uri.withAppendedPath(C0280o.f2228a, this.f2237c);
            Activity activity = (Activity) this.f2235a.get();
            if (activity == null) {
                C0290d.m1862a("Activity was null while getting the +1 button state.");
                return;
            }
            boolean z;
            Cursor query = activity.getContentResolver().query(withAppendedPath, C0280o.f2230c, null, null, null);
            if (query == null || !query.moveToFirst()) {
                C0290d.m1862a("Google+ app not installed, showing ad as not +1'd");
                z = false;
            } else {
                z = query.getInt(query.getColumnIndex("has_plus1")) == 1;
            }
            this.f2236b.post(new C0284s(this.f2236b, z));
        } catch (Throwable th) {
            C0290d.m1866b("An unknown error occurred while updating the +1 state.", th);
        }
    }
}
