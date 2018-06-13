package com.brandall.nutter;

import android.telephony.PhoneStateListener;

final class me extends PhoneStateListener {
    final /* synthetic */ ServiceTTS f1708a;

    me(ServiceTTS serviceTTS) {
        this.f1708a = serviceTTS;
    }

    public final void onCallStateChanged(int i, String str) {
        super.onCallStateChanged(i, str);
        switch (i) {
            case 0:
                if (hc.f1269b) {
                    ls.m1346c("CALL_STATE_IDLE");
                    return;
                }
                return;
            case 1:
                if (hc.f1269b) {
                    ls.m1346c("CALL_STATE_RINGING");
                }
                ServiceTTS.m911a();
                if (ServiceTTS.f854f) {
                    nl.m1496a(ServiceTTS.f849a);
                }
                if (ServiceTTS.f861m) {
                    ServiceTTS.m920b();
                    return;
                }
                return;
            case 2:
                if (hc.f1269b) {
                    ls.m1346c("CALL_STATE_OFFHOOK");
                }
                ServiceTTS.m911a();
                if (ServiceTTS.f854f) {
                    nl.m1496a(ServiceTTS.f849a);
                }
                if (ServiceTTS.f861m) {
                    ServiceTTS.m920b();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
