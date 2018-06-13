package com.google.ads.internal;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.ads.util.C0290d;
import java.lang.ref.WeakReference;

public class AdVideoView extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private static final C0250c f2082b = ((C0250c) C0250c.f2099a.mo113a());
    public MediaController f2083a = null;
    private WeakReference<Activity> f2084c;
    private AdWebView f2085d;
    private long f2086e = 0;
    private VideoView f2087f;
    private String f2088g = null;

    public AdVideoView(Activity activity, AdWebView adWebView) {
        super(activity);
        this.f2084c = new WeakReference(activity);
        this.f2085d = adWebView;
        this.f2087f = new VideoView(activity);
        addView(this.f2087f, new LayoutParams(-1, -1, 17));
        new C0248a(this).m1679a();
        this.f2087f.setOnCompletionListener(this);
        this.f2087f.setOnPreparedListener(this);
        this.f2087f.setOnErrorListener(this);
    }

    public final void m1666a() {
        if (TextUtils.isEmpty(this.f2088g)) {
            C0250c c0250c = f2082b;
            C0250c.m1683a(this.f2085d, "onVideoEvent", "{'event': 'error', 'what': 'no_src'}");
            return;
        }
        this.f2087f.setVideoPath(this.f2088g);
    }

    public final void m1667a(int i) {
        this.f2087f.seekTo(i);
    }

    public final void m1668a(MotionEvent motionEvent) {
        this.f2087f.onTouchEvent(motionEvent);
    }

    public final void m1669b() {
        this.f2087f.pause();
    }

    public final void m1670c() {
        this.f2087f.start();
    }

    public final void m1671d() {
        this.f2087f.stopPlayback();
    }

    final void m1672e() {
        long currentPosition = (long) this.f2087f.getCurrentPosition();
        if (this.f2086e != currentPosition) {
            float f = ((float) currentPosition) / 1000.0f;
            C0250c c0250c = f2082b;
            C0250c.m1683a(this.f2085d, "onVideoEvent", "{'event': 'timeupdate', 'time': " + f + "}");
            this.f2086e = currentPosition;
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        C0250c c0250c = f2082b;
        C0250c.m1683a(this.f2085d, "onVideoEvent", "{'event': 'ended'}");
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        C0290d.m1871e("Video threw error! <what:" + i + ", extra:" + i2 + ">");
        C0250c c0250c = f2082b;
        C0250c.m1683a(this.f2085d, "onVideoEvent", "{'event': 'error', 'what': '" + i + "', 'extra': '" + i2 + "'}");
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        float duration = ((float) this.f2087f.getDuration()) / 1000.0f;
        C0250c c0250c = f2082b;
        C0250c.m1683a(this.f2085d, "onVideoEvent", "{'event': 'canplaythrough', 'duration': '" + duration + "'}");
    }

    public void setMediaControllerEnabled(boolean z) {
        Activity activity = (Activity) this.f2084c.get();
        if (activity == null) {
            C0290d.m1871e("adActivity was null while trying to enable controls on a video.");
        } else if (z) {
            if (this.f2083a == null) {
                this.f2083a = new MediaController(activity);
            }
            this.f2087f.setMediaController(this.f2083a);
        } else {
            if (this.f2083a != null) {
                this.f2083a.hide();
            }
            this.f2087f.setMediaController(null);
        }
    }

    public void setSrc(String str) {
        this.f2088g = str;
    }
}
