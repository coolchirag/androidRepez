package com.google.ads.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class aa implements OnClickListener {
    final /* synthetic */ String f2096a;
    final /* synthetic */ C0273y f2097b;

    aa(C0273y c0273y, String str) {
        this.f2097b = c0273y;
        this.f2096a = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2097b.f2216b.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.f2096a), "Share via"));
    }
}
