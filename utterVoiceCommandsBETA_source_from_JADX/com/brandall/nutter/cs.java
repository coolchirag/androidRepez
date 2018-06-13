package com.brandall.nutter;

import android.app.Activity;
import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.android.AndroidTwitterLogin;

final class cs extends AndroidTwitterLogin {
    final /* synthetic */ ActivityLinkApps f1023a;

    cs(ActivityLinkApps activityLinkApps, Activity activity, String str, String str2, String str3) {
        this.f1023a = activityLinkApps;
        super(activity, str, str2, str3);
    }

    protected final void onFail(Exception exception) {
        ls.m1347d("jtwitter Exception");
        ls.m1347d(exception.toString());
        if (exception.toString().contains("Communication with the service provider failed")) {
            lc.m1313a(this.f1023a, false, "Twitter authentication failed. Please make sure you have an active data connection before attempting authorisation. Press back to return to, utter.");
        } else {
            lc.m1313a(this.f1023a, false, "Twitter authentication failed. Press back to return to, utter.");
        }
    }

    protected final void onSuccess(Twitter twitter, String[] strArr) {
        ls.m1346c("onSuccess");
        ActivityLinkApps.m583a(this.f1023a, strArr[0], strArr[1]);
        lc.m1313a(this.f1023a, false, "Twitter authentication successful");
    }
}
