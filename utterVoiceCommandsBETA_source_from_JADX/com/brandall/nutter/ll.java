package com.brandall.nutter;

import android.app.Activity;
import android.app.Dialog;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

final class ll extends Dialog {
    private String f1679a = null;
    private String f1680b = null;
    private boolean f1681c = false;

    public ll(Activity activity) {
        super(activity);
        requestWindowFeature(1);
        setContentView(R.layout.listening);
        setOwnerActivity(activity);
        setCancelable(true);
        LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
    }

    private static void m1319a(Button button, boolean z) {
        if (button != null) {
            button.setEnabled(z);
        }
    }

    public final void m1320a(OnClickListener onClickListener) {
        if (this.f1679a != null) {
            m1321a(this.f1679a);
        }
        m1323b("");
        this.f1681c = false;
        Button button = (Button) findViewById(R.id.btn_listeningStop);
        m1319a(button, true);
        button.setOnClickListener(onClickListener);
    }

    public final void m1321a(String str) {
        this.f1679a = str;
        TextView textView = (TextView) findViewById(R.id.text_listeningStatus);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void m1322a(boolean z) {
        this.f1681c = z;
    }

    public final void m1323b(String str) {
        ((TextView) findViewById(R.id.text_recordLevel)).setText(str);
    }

    public final void m1324b(boolean z) {
        m1319a((Button) findViewById(R.id.btn_listeningStop), z);
    }
}
