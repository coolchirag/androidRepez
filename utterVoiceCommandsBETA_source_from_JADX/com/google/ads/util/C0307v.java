package com.google.ads.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class C0307v implements OnClickListener {
    final /* synthetic */ JsPromptResult f2303a;
    final /* synthetic */ EditText f2304b;

    C0307v(JsPromptResult jsPromptResult, EditText editText) {
        this.f2303a = jsPromptResult;
        this.f2304b = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2303a.confirm(this.f2304b.getText().toString());
    }
}
