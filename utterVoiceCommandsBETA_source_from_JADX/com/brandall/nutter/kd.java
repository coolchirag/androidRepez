package com.brandall.nutter;

import android.content.Context;
import android.os.AsyncTask;

public final class kd extends AsyncTask<String, Void, Boolean> {
    Context f1589a;

    public kd(Context context) {
        this.f1589a = context;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        boolean z = true;
        String[] strArr = (String[]) objArr;
        ls.m1346c("DIB ExecuteRemoteEmail");
        long currentTimeMillis = System.currentTimeMillis();
        if (!ju.m1219a(this.f1589a, strArr[0], "utter! Response", strArr[1])) {
            z = false;
        }
        ls.m1346c("ERE elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
        return Boolean.valueOf(z);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        ls.m1345b("ERE onPostEx");
        super.onPostExecute(bool);
    }
}
