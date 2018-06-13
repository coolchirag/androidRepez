package com.p011a.p012a;

import android.content.Context;
import android.os.AsyncTask;

final class C0105d extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ C0102b f349a;
    private final String f350b;
    private final Context f351c;

    public C0105d(C0102b c0102b, String str, Context context) {
        this.f349a = c0102b;
        this.f350b = str;
        this.f351c = context.getApplicationContext();
    }

    private Void m319a() {
        try {
            C0102b.m297a(this.f349a, this.f350b, this.f351c);
        } catch (Exception e) {
            C0112l.m332a("Facebook-publish", e.getMessage());
        }
        return null;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m319a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        synchronized (this.f349a) {
            this.f349a.f347o = null;
        }
    }
}
