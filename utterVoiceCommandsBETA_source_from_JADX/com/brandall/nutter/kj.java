package com.brandall.nutter;

import android.content.Context;
import android.os.AsyncTask;

public final class kj extends AsyncTask<String, Void, Void> {
    Context f1613a;

    public kj(Context context) {
        this.f1613a = context;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        String[] strArr = (String[]) objArr;
        ls.m1346c("DIB ExecuteTestEmail");
        long currentTimeMillis = System.currentTimeMillis();
        ju.m1219a(this.f1613a, strArr[0], "An email from utter!", "Authentication Test Email.");
        ls.m1346c("ETE elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
        return null;
    }
}
