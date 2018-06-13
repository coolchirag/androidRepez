package com.google.ads;

import android.view.View;
import com.google.ads.util.C0290d;

final class af implements Runnable {
    final /* synthetic */ aj f1951a;
    final /* synthetic */ View f1952b;
    final /* synthetic */ ag f1953c;
    final /* synthetic */ ac f1954d;

    af(ac acVar, aj ajVar, View view, ag agVar) {
        this.f1954d = acVar;
        this.f1951a = ajVar;
        this.f1952b = view;
        this.f1953c = agVar;
    }

    public final void run() {
        if (this.f1954d.m1609a(this.f1951a)) {
            C0290d.m1862a("Trying to switch GWAdNetworkAmbassadors, but GWController().destroy() has been called. Destroying the new ambassador and terminating mediation.");
        } else {
            this.f1954d.f1939a.m1725a(this.f1952b, this.f1951a, this.f1953c);
        }
    }
}
