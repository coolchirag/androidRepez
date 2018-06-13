package com.google.ads.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

final class C0303r implements OnClickListener {
    final /* synthetic */ JsResult f2299a;

    C0303r(JsResult jsResult) {
        this.f2299a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2299a.cancel();
    }
}
