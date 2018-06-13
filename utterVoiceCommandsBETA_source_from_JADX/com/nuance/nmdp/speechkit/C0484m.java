package com.nuance.nmdp.speechkit;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;

public final class C0484m implements ba {
    private MediaPlayer f2826a = null;
    private az f2827b = null;
    private Object f2828c = null;
    private boolean f2829d = false;
    private boolean f2830e = false;
    private AssetFileDescriptor f2831f = null;

    final class C04822 implements OnErrorListener {
        private /* synthetic */ C0484m f2824a;

        C04822(C0484m c0484m) {
            this.f2824a = c0484m;
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            C0478j.m2567c(this.f2824a, "Error during audio prompt: " + i);
            ax.m2055a(new Runnable(this.f2824a, true) {
                private /* synthetic */ C0484m f2823b;

                public final void run() {
                    if (this.f2823b.f2826a != null && !this.f2823b.f2830e) {
                        if (r2) {
                            this.f2823b.f2826a.release();
                            this.f2823b.f2826a = null;
                            this.f2823b.f2826a = this.f2823b.m2585e();
                            if (this.f2823b.f2826a == null) {
                                if (this.f2823b.f2827b != null) {
                                    this.f2823b.f2827b.mo196a(this.f2823b.f2828c);
                                    this.f2823b.f2827b = null;
                                    this.f2823b.f2828c = null;
                                }
                                this.f2823b.mo294c();
                                return;
                            }
                        }
                        if (this.f2823b.f2829d) {
                            this.f2823b.m2584d();
                            return;
                        }
                        if (this.f2823b.f2827b != null) {
                            if (r2) {
                                this.f2823b.f2827b.mo196a(this.f2823b.f2828c);
                            } else {
                                this.f2823b.f2827b.mo198c(this.f2823b.f2828c);
                            }
                        }
                        this.f2823b.f2827b = null;
                        this.f2823b.f2828c = null;
                    }
                }
            });
            return true;
        }
    }

    final class C04833 implements OnCompletionListener {
        private /* synthetic */ C0484m f2825a;

        C04833(C0484m c0484m) {
            this.f2825a = c0484m;
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            C0478j.m2564a(this.f2825a, "Audio prompt completed");
            ax.m2055a(/* anonymous class already generated */);
        }
    }

    private void m2584d() {
        this.f2829d = false;
        this.f2826a.start();
        this.f2827b.mo197b(this.f2828c);
    }

    private MediaPlayer m2585e() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            long startOffset = this.f2831f.getStartOffset();
            long length = this.f2831f.getLength();
            if (length == -1) {
                C0478j.m2564a(this, "Attempting to initialize MediaPlayer with asset file of unknown length");
                mediaPlayer.setDataSource(this.f2831f.getFileDescriptor());
            } else {
                mediaPlayer.setDataSource(this.f2831f.getFileDescriptor(), startOffset, length);
            }
            mediaPlayer.prepare();
            mediaPlayer.getDuration();
            mediaPlayer.setOnErrorListener(new C04822(this));
            mediaPlayer.setOnCompletionListener(new C04833(this));
            return mediaPlayer;
        } catch (Throwable e) {
            C0478j.m2565a(this, "Unable to create MediaPlayer for audio prompt", e);
            try {
                mediaPlayer.release();
            } catch (Exception e2) {
            }
            return null;
        }
    }

    public final void mo291a() {
        if (this.f2826a != null) {
            this.f2829d = false;
            if (this.f2826a.isPlaying()) {
                try {
                    this.f2826a.stop();
                } catch (Throwable th) {
                    C0478j.m2565a(this, "Error stopping player", th);
                }
                this.f2826a.release();
                this.f2826a = null;
                this.f2826a = m2585e();
                if (this.f2826a == null) {
                    mo294c();
                }
            }
        }
    }

    public final void m2592a(AssetFileDescriptor assetFileDescriptor) {
        this.f2831f = assetFileDescriptor;
        this.f2826a = m2585e();
        if (this.f2826a == null) {
            mo294c();
        }
    }

    public final void mo292a(Object obj, az azVar, Object obj2) {
        if (this.f2826a == null || this.f2830e) {
            C0478j.m2567c(this, "Can't start disposed audio prompt");
            azVar.mo196a(obj2);
            return;
        }
        C0478j.m2564a(this, "Starting audio prompt");
        this.f2827b = azVar;
        this.f2828c = obj2;
        if (this.f2826a.isPlaying()) {
            C0478j.m2566b(this, "Audio prompt is already playing. Stopping to restart.");
            this.f2826a.stop();
            this.f2829d = true;
            return;
        }
        m2584d();
    }

    public final boolean mo293b() {
        return this.f2830e;
    }

    public final void mo294c() {
        this.f2830e = true;
        if (this.f2826a != null) {
            this.f2826a.release();
            this.f2826a = null;
        }
        if (this.f2831f != null) {
            try {
                this.f2831f.close();
            } catch (Throwable e) {
                C0478j.m2565a(this, "Error closing audio prompt file", e);
            }
            this.f2831f = null;
        }
        if (this.f2827b != null) {
            this.f2827b.mo196a(this.f2828c);
            this.f2827b = null;
        }
        this.f2828c = null;
    }
}
