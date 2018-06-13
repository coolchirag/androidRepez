package com.google.ads.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsPromptResult;

final class C0305t implements OnCancelListener {
    final /* synthetic */ JsPromptResult f2301a;

    C0305t(JsPromptResult jsPromptResult) {
        this.f2301a = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f2301a.cancel();
    }
}
