package com.brandall.nutter;

import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import wei.mark.standout.C0615g;
import wei.mark.standout.C0616h;
import wei.mark.standout.StandOutWindow;

public class FloatingAdviewWindow extends StandOutWindow {
    private final String f764a = "a14f6514eec7ca1";

    protected final String mo66a() {
        return " utter!";
    }

    protected final C0615g mo67a(int i) {
        return new C0615g(this, i, 275, 300);
    }

    protected final void mo68a(int i, FrameLayout frameLayout) {
        ls.m1346c("createAndAttachView");
        ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.adview_floating_layout, frameLayout, true);
    }

    protected final int mo69b() {
        return R.drawable.ic_window_icon;
    }

    protected final Animation mo70b(int i) {
        return m775f(i) ? AnimationUtils.loadAnimation(this, 17432576) : super.mo70b(i);
    }

    protected final int mo71c() {
        return (((C0616h.f3150a | C0616h.f3154e) | C0616h.f3157h) | C0616h.f3158i) | C0616h.f3160k;
    }

    protected final Animation mo72d() {
        return AnimationUtils.loadAnimation(this, 17432577);
    }
}
