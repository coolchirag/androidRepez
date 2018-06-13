package com.google.ads.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsResult;

final class C0302q implements OnCancelListener {
    final /* synthetic */ JsResult f2298a;

    C0302q(JsResult jsResult) {
        this.f2298a = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f2298a.cancel();
    }
}
