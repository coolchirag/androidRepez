package com.brandall.nutter;

import android.content.Context;

final class mi implements Runnable {
    final /* synthetic */ mh f1711a;

    mi(mh mhVar) {
        this.f1711a = mhVar;
    }

    public final void run() {
        if (hc.f1269b) {
            ls.m1345b("in postDelayed");
        }
        if (this.f1711a.f1710a.f870A) {
            if (hc.f1269b) {
                ls.m1346c("timeUp: " + this.f1711a.f1710a.f870A);
            }
            Context context = ServiceTTS.f849a;
            lt.m1352a(context, "Fetching...", "utter!", "fetching from Google Servers...", 17301640, false, 0, 1);
        } else if (hc.f1269b) {
            ls.m1346c("timeUp: " + this.f1711a.f1710a.f870A);
        }
    }
}
