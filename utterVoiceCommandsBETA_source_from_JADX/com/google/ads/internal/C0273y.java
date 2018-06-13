package com.google.ads.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.GestureStore;
import android.gesture.Prediction;
import com.google.ads.util.C0290d;
import java.util.ArrayList;
import java.util.Iterator;
import org.ispeech.core.InternalResources;

public final class C0273y implements OnGesturePerformedListener {
    private final GestureStore f2215a;
    private Activity f2216b;
    private C0264p f2217c;

    public C0273y(Activity activity, C0264p c0264p, GestureStore gestureStore) {
        this.f2216b = activity;
        this.f2217c = c0264p;
        this.f2215a = gestureStore;
    }

    public final void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        ArrayList recognize = this.f2215a.recognize(gesture);
        Iterator it = recognize.iterator();
        while (it.hasNext()) {
            Prediction prediction = (Prediction) it.next();
            C0290d.m1862a("Gesture: '" + prediction.name + "' = " + prediction.score);
        }
        if (recognize.size() == 0) {
            C0290d.m1862a("Gesture: No remotely reasonable predictions");
        } else if (((Prediction) recognize.get(0)).score > 2.0d && InternalResources.ISPEECH_SCREEN_DEBUG.equals(((Prediction) recognize.get(0)).name) && this.f2217c != null) {
            Object c = this.f2217c.m1738c() == null ? "[No diagnostics available]" : this.f2217c.m1738c();
            new Builder(this.f2216b).setMessage(c).setTitle("Ad Information").setPositiveButton("Share", new aa(this, c)).setNegativeButton("Close", new C0274z(this)).create().show();
        }
    }
}
