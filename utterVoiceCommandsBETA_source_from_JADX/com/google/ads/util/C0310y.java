package com.google.ads.util;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.google.ads.ar;

public final class C0310y extends C0301p {
    public C0310y(ar arVar) {
        super(arVar);
    }

    public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        customViewCallback.onCustomViewHidden();
    }
}
