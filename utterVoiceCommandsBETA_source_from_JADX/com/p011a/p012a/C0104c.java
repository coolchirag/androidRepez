package com.p011a.p012a;

import android.os.Bundle;
import android.webkit.CookieSyncManager;

final class C0104c implements C0103e {
    final /* synthetic */ C0102b f348a;

    C0104c(C0102b c0102b) {
        this.f348a = c0102b;
    }

    public final void mo52a() {
        C0112l.m332a("Facebook-authorize", "Login canceled");
        this.f348a.f344l.mo52a();
    }

    public final void mo53a(Bundle bundle) {
        CookieSyncManager.getInstance().sync();
        this.f348a.m308b(bundle.getString("access_token"));
        this.f348a.m310c(bundle.getString("expires_in"));
        if (this.f348a.m306a()) {
            C0112l.m332a("Facebook-authorize", "Login Success! access_token=" + this.f348a.m307b() + " expires=" + this.f348a.m309c());
            this.f348a.f344l.mo53a(bundle);
            return;
        }
        this.f348a.f344l.mo55a(new C0106f("Failed to receive access token."));
    }

    public final void mo54a(C0101a c0101a) {
        C0112l.m332a("Facebook-authorize", "Login failed: " + c0101a);
        this.f348a.f344l.mo54a(c0101a);
    }

    public final void mo55a(C0106f c0106f) {
        C0112l.m332a("Facebook-authorize", "Login failed: " + c0106f);
        this.f348a.f344l.mo55a(c0106f);
    }
}
