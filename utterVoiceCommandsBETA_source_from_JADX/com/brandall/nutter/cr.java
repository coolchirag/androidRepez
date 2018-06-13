package com.brandall.nutter;

import android.os.Bundle;
import com.p011a.p012a.C0101a;
import com.p011a.p012a.C0103e;
import com.p011a.p012a.C0106f;

final class cr implements C0103e {
    final /* synthetic */ ActivityLinkApps f1022a;

    cr(ActivityLinkApps activityLinkApps) {
        this.f1022a = activityLinkApps;
    }

    public final void mo52a() {
        ls.m1347d("Facebook onCancel");
    }

    public final void mo53a(Bundle bundle) {
        ActivityLinkApps.m580L(this.f1022a);
    }

    public final void mo54a(C0101a c0101a) {
        ls.m1347d("Facebook onError");
        c0101a.printStackTrace();
        if (c0101a.toString().contains("The connection to the server was unsuccessful") || c0101a.toString().contains("The URL could not be found")) {
            lc.m1313a(this.f1022a, false, "Facebook authentication failed. Please make sure you have an active data connection before attempting authorisation.");
        }
    }

    public final void mo55a(C0106f c0106f) {
        ls.m1347d("onFacebookError:" + c0106f.m320a());
    }
}
