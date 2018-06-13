package com.google.ads.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;

final class C0306u implements OnClickListener {
    final /* synthetic */ JsPromptResult f2302a;

    C0306u(JsPromptResult jsPromptResult) {
        this.f2302a = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2302a.cancel();
    }
}
