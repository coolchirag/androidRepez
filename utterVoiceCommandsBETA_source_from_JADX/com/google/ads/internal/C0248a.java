package com.google.ads.internal;

import android.os.Handler;
import com.google.ads.util.C0290d;
import java.lang.ref.WeakReference;

final class C0248a implements Runnable {
    private WeakReference<AdVideoView> f2094a;
    private Handler f2095b = new Handler();

    public C0248a(AdVideoView adVideoView) {
        this.f2094a = new WeakReference(adVideoView);
    }

    public final void m1679a() {
        this.f2095b.postDelayed(this, 250);
    }

    public final void run() {
        AdVideoView adVideoView = (AdVideoView) this.f2094a.get();
        if (adVideoView == null) {
            C0290d.m1869d("The video must be gone, so cancelling the timeupdate task.");
            return;
        }
        adVideoView.m1672e();
        this.f2095b.postDelayed(this, 250);
    }
}
