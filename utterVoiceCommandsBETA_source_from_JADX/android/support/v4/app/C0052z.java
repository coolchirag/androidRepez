package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

public final class C0052z {
    Context f205a;
    public CharSequence f206b;
    public CharSequence f207c;
    public PendingIntent f208d;
    PendingIntent f209e;
    RemoteViews f210f;
    Bitmap f211g;
    CharSequence f212h;
    int f213i;
    public Notification f214j = new Notification();

    public C0052z(Context context) {
        this.f205a = context;
        this.f214j.when = System.currentTimeMillis();
        this.f214j.audioStreamType = -1;
    }

    public final C0052z m164a() {
        int i = 1;
        this.f214j.ledARGB = -16711936;
        this.f214j.ledOnMS = 300;
        this.f214j.ledOffMS = 100;
        int i2 = (this.f214j.ledOnMS == 0 || this.f214j.ledOffMS == 0) ? 0 : 1;
        Notification notification = this.f214j;
        int i3 = this.f214j.flags & -2;
        if (i2 == 0) {
            i = 0;
        }
        notification.flags = i3 | i;
        return this;
    }

    public final C0052z m165a(int i) {
        this.f214j.icon = i;
        return this;
    }

    public final C0052z m166a(long j) {
        this.f214j.when = j;
        return this;
    }

    public final C0052z m167a(CharSequence charSequence) {
        this.f214j.tickerText = charSequence;
        return this;
    }

    public final C0052z m168a(boolean z) {
        m169a(16, z);
        return this;
    }

    public final void m169a(int i, boolean z) {
        if (z) {
            Notification notification = this.f214j;
            notification.flags |= i;
            return;
        }
        notification = this.f214j;
        notification.flags &= i ^ -1;
    }

    public final Notification m170b() {
        return C0051y.f204a.mo26a(this);
    }
}
