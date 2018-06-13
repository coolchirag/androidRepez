package com.att.android.speech;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C0128o implements OnClickListener {
    final /* synthetic */ C0122i f570a;

    C0128o(C0122i c0122i) {
        this.f570a = c0122i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f570a.m435c();
    }
}
