package com.att.android.speech;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class C0129p implements OnCancelListener {
    final /* synthetic */ C0122i f571a;

    C0129p(C0122i c0122i) {
        this.f571a = c0122i;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f571a.m435c();
    }
}
