package com.brandall.nutter;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class cp implements OnTouchListener {
    final /* synthetic */ ActivityLinkApps f1019a;

    cp(ActivityLinkApps activityLinkApps) {
        this.f1019a = activityLinkApps;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 1) && !view.hasFocus()) {
            view.requestFocus();
        }
        return false;
    }
}
