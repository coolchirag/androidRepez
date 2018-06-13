package com.brandall.nutter;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {
    public static int f909a = 99;

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        ls.m1346c("WidgetProvider onUpdate");
        for (int i : iArr) {
            ls.m1346c("WidgetProvider appWidgetId: " + i);
            Intent intent = new Intent(context, LauncherShortcutActivity.class);
            intent.putExtra("voice_engine_iso", lx.m1457z(context));
            intent.putExtra("voice_engine_language", lx.m1362A(context));
            intent.putExtra("recognition_locale", lx.m1363B(context));
            PendingIntent activity = PendingIntent.getActivity(context, f909a, intent, 134217728);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            remoteViews.setOnClickPendingIntent(R.id.widgetIcon, activity);
            appWidgetManager.updateAppWidget(i, remoteViews);
        }
    }
}
