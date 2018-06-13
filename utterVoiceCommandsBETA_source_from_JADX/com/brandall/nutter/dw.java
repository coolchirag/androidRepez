package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class dw implements OnDismissListener {
    final /* synthetic */ ActivityRecognitionVoices f1077a;

    dw(ActivityRecognitionVoices activityRecognitionVoices) {
        this.f1077a = activityRecognitionVoices;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.f1077a.f712l != null) {
            this.f1077a.f712l.cancel();
            this.f1077a.f712l = null;
        }
        if (!this.f1077a.f711j) {
            this.f1077a.removeDialog(0);
            this.f1077a.m638b();
        }
    }
}
