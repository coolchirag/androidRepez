package com.google.ads.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

final class C0304s implements OnClickListener {
    final /* synthetic */ JsResult f2300a;

    C0304s(JsResult jsResult) {
        this.f2300a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2300a.confirm();
    }
}
