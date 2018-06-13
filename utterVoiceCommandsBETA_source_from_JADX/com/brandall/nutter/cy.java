package com.brandall.nutter;

import android.content.Context;
import android.os.AsyncTask;

public final class cy extends AsyncTask<Void, Void, Boolean> {
    Context f1034a;
    final /* synthetic */ ActivityLinkApps f1035b;

    public cy(ActivityLinkApps activityLinkApps, Context context) {
        this.f1035b = activityLinkApps;
        this.f1034a = context;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        ls.m1346c("DIB ExecuteGoogleMusicTest");
        long currentTimeMillis = System.currentTimeMillis();
        boolean testLogin = ExecuteGoogleMusic.testLogin(this.f1034a);
        ls.m1346c("EGMT elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
        return Boolean.valueOf(testLogin);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        ls.m1345b("EGMT onPostEx");
        if (bool.booleanValue()) {
            lc.m1313a(this.f1035b, false, "Google Music authorisation successful");
        } else {
            lc.m1313a(this.f1035b, false, "Google Music authorisation failed. Please confirm your login details.");
        }
        super.onPostExecute(bool);
    }
}
