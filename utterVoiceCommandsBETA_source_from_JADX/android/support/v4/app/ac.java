package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

final class ac implements aa {
    ac() {
    }

    public final Notification mo26a(C0052z c0052z) {
        boolean z = true;
        Context context = c0052z.f205a;
        Notification notification = c0052z.f214j;
        CharSequence charSequence = c0052z.f206b;
        CharSequence charSequence2 = c0052z.f207c;
        CharSequence charSequence3 = c0052z.f212h;
        RemoteViews remoteViews = c0052z.f210f;
        int i = c0052z.f213i;
        PendingIntent pendingIntent = c0052z.f208d;
        PendingIntent pendingIntent2 = c0052z.f209e;
        Bitmap bitmap = c0052z.f211g;
        Builder deleteIntent = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) == 0) {
            z = false;
        }
        return deleteIntent.setFullScreenIntent(pendingIntent2, z).setLargeIcon(bitmap).getNotification();
    }
}
