package com.p011a.p012a;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public final class C0107g extends Dialog {
    static final float[] f354a = new float[]{20.0f, 60.0f};
    static final float[] f355b = new float[]{40.0f, 60.0f};
    static final LayoutParams f356c = new LayoutParams(-1, -1);
    private String f357d;
    private C0103e f358e;
    private ProgressDialog f359f;
    private ImageView f360g;
    private WebView f361h;
    private FrameLayout f362i;

    public C0107g(Context context, String str, C0103e c0103e) {
        super(context, 16973840);
        this.f357d = str;
        this.f358e = c0103e;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f359f = new ProgressDialog(getContext());
        this.f359f.requestWindowFeature(1);
        this.f359f.setMessage("Loading...");
        requestWindowFeature(1);
        this.f362i = new FrameLayout(getContext());
        this.f360g = new ImageView(getContext());
        this.f360g.setOnClickListener(new C0108h(this));
        this.f360g.setImageDrawable(getContext().getResources().getDrawable(C0111k.f365a));
        this.f360g.setVisibility(4);
        int intrinsicWidth = this.f360g.getDrawable().getIntrinsicWidth() / 2;
        View linearLayout = new LinearLayout(getContext());
        this.f361h = new WebView(getContext());
        this.f361h.setVerticalScrollBarEnabled(false);
        this.f361h.setHorizontalScrollBarEnabled(false);
        this.f361h.setWebViewClient(new C0109i());
        this.f361h.getSettings().setJavaScriptEnabled(true);
        this.f361h.loadUrl(this.f357d);
        this.f361h.setLayoutParams(f356c);
        this.f361h.setVisibility(4);
        this.f361h.getSettings().setSavePassword(false);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.f361h);
        this.f362i.addView(linearLayout);
        this.f362i.addView(this.f360g, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f362i, new ViewGroup.LayoutParams(-1, -1));
    }
}
