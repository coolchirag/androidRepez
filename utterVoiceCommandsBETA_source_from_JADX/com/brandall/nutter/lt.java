package com.brandall.nutter;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.C0052z;
import android.widget.RemoteViews;
import org.ispeech.core.HttpRequestParams;

public final class lt {
    private static int f1696a;
    private static int f1697b = 199;
    private static NotificationManager f1698c;

    public static boolean m1349a(int i) {
        if (hc.f1269b) {
            ls.m1346c("removeNotification");
        }
        if (f1698c != null) {
            if (hc.f1269b) {
                ls.m1346c("notificationManager != null");
            }
            try {
                f1696a = i;
                f1698c.cancel(f1696a);
                return true;
            } catch (Exception e) {
                if (hc.f1269b) {
                    ls.m1348e("Failed to cancel notification");
                }
                e.printStackTrace();
                return false;
            }
        } else if (!hc.f1269b) {
            return false;
        } else {
            ls.m1346c("notificationManager == null");
            return false;
        }
    }

    public static boolean m1350a(Context context) {
        if (hc.f1269b) {
            ls.m1346c("englishGVSNotification");
        }
        try {
            Intent intent = new Intent(context, InteractionHelper.class);
            intent.putExtra("sender", "gvs");
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
            f1698c = (NotificationManager) context.getSystemService("notification");
            C0052z c0052z = new C0052z(context);
            c0052z.f208d = activity;
            C0052z a = c0052z.m165a((int) R.drawable.utternoto).m167a((CharSequence) "Interactive Update").m166a(System.currentTimeMillis());
            a.f206b = "utter!";
            a.f207c = "Tap for message";
            a.m164a();
            c0052z.m168a(true);
            f1698c.notify(99, c0052z.m170b());
            return true;
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("Notification failure");
            }
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1351a(Context context, String str, String str2) {
        if (hc.f1269b) {
            ls.m1346c("serverNotification: action: " + str + " : content: " + str2);
        }
        try {
            Intent intent = new Intent(context, InteractionHelper.class);
            intent.putExtra("sender", "server");
            intent.putExtra(HttpRequestParams.ACTION, str);
            intent.putExtra("content", str2);
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
            f1698c = (NotificationManager) context.getSystemService("notification");
            C0052z c0052z = new C0052z(context);
            c0052z.f208d = activity;
            C0052z a = c0052z.m165a((int) R.drawable.utternoto).m167a((CharSequence) "Server Update").m166a(System.currentTimeMillis());
            a.f206b = "utter!";
            a.m164a();
            if (str.matches("speak")) {
                c0052z.f207c = "Tap to listen";
            } else if (str.matches("web")) {
                c0052z.f207c = "Tap for weblink";
            } else if (str.matches("toast")) {
                c0052z.f207c = "Tap to toast";
            } else if (str.matches("run")) {
                c0052z.f207c = "Tap to perform";
            } else {
                c0052z.f207c = "Please clear";
            }
            c0052z.m168a(true);
            f1698c.notify(247, c0052z.m170b());
            return true;
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("Notification failure");
            }
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1352a(Context context, String str, String str2, String str3, int i, boolean z, int i2, int i3) {
        if (hc.f1269b) {
            ls.m1346c("createNotification: " + str + " : " + str2 + " : " + str3);
        }
        try {
            PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent(context, LauncherShortcutActivity.class), 268435456);
            f1698c = (NotificationManager) context.getSystemService("notification");
            C0052z c0052z = new C0052z(context);
            c0052z.f208d = activity;
            C0052z a = c0052z.m165a(i).m167a((CharSequence) str).m166a(System.currentTimeMillis());
            a.f206b = str2;
            a.f207c = str3;
            if (z) {
                c0052z.m169a(2, true);
                c0052z.m168a(false);
                RemoteViews remoteViews = new RemoteViews("com.brandall.nutter", R.layout.progress_notification);
                remoteViews.setTextViewText(R.id.status_title, str2);
                remoteViews.setTextViewText(R.id.status_text, str3);
                remoteViews.setImageViewResource(R.id.status_icon, R.drawable.dropbox);
                remoteViews.setProgressBar(R.id.status_progress, 100, i2, false);
                c0052z.f214j.contentView = remoteViews;
            } else {
                c0052z.m168a(true);
            }
            f1696a = i3;
            f1698c.notify(f1696a, c0052z.m170b());
            return true;
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("Notification failure");
            }
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1353a(Context context, String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4, String str5, String str6) {
        if (hc.f1269b) {
            ls.m1346c("createNotification: " + str + " : " + str2 + " : " + str3);
        }
        try {
            Intent intent = new Intent(context, LauncherShortcutActivity.class);
            intent.putExtra("voice_engine_locale", str5);
            intent.putExtra("recognition_locale", str6);
            intent.putExtra("voice_content", str4);
            intent.putExtra("Start_Listening", z);
            intent.putExtra("custom_recog", z2);
            intent.putExtra("custom_voice", z3);
            intent.putExtra("tasker", true);
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
            f1698c = (NotificationManager) context.getSystemService("notification");
            C0052z c0052z = new C0052z(context);
            c0052z.f208d = activity;
            C0052z a = c0052z.m165a((int) R.drawable.utternoto).m167a((CharSequence) str).m166a(System.currentTimeMillis());
            a.f206b = str2;
            a.f207c = str3;
            a.m164a();
            c0052z.m168a(true);
            Notification b = c0052z.m170b();
            f1697b = 199;
            f1698c.notify(f1697b, b);
            return true;
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("Notification failure");
            }
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1354a(Context context, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("tutorialNotification");
        }
        try {
            Intent intent = new Intent(context, LauncherShortcutActivity.class);
            intent.putExtra("tutorial", true);
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 1073741824);
            f1698c = (NotificationManager) context.getSystemService("notification");
            C0052z c0052z = new C0052z(context);
            c0052z.f208d = activity;
            C0052z a = c0052z.m165a(17301539).m166a(System.currentTimeMillis());
            a.f206b = "utter!";
            a.f207c = "Tap to stop tutorial";
            a.m164a();
            if (z) {
                c0052z.m167a((CharSequence) "Tutorial running...");
            } else {
                c0052z.m167a((CharSequence) "Initialising tutorial...");
            }
            c0052z.m168a(true);
            f1698c.notify(399, c0052z.m170b());
            return true;
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("Notification failure");
            }
            e.printStackTrace();
            return false;
        }
    }
}
