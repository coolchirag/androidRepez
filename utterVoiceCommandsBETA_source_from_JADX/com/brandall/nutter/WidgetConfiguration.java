package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class WidgetConfiguration extends Activity {
    public String f906a = "";
    public String f907b = "";
    int f908c = 0;

    private void m964a() {
        setResult(0, new Intent());
        finish();
    }

    static /* synthetic */ void m966a(WidgetConfiguration widgetConfiguration, String str, String str2, String str3) {
        ls.m1344a("WC recogLocale: " + str);
        ls.m1344a("WC voiceLang: " + str2);
        ls.m1344a("WC voiceISO: " + str3);
        Editor edit = widgetConfiguration.getSharedPreferences("utterPref", 0).edit();
        edit.putString("widget_iso", str3);
        edit.putString("widget_lang", str2);
        edit.putString("widget_recog", str);
        edit.commit();
        AppWidgetManager instance = AppWidgetManager.getInstance(widgetConfiguration);
        Intent intent = new Intent(widgetConfiguration, LauncherShortcutActivity.class);
        intent.putExtra("voice_engine_iso", lx.m1457z(widgetConfiguration));
        intent.putExtra("voice_engine_language", lx.m1362A(widgetConfiguration));
        intent.putExtra("recognition_locale", lx.m1363B(widgetConfiguration));
        PendingIntent activity = PendingIntent.getActivity(widgetConfiguration, WidgetProvider.f909a, intent, 134217728);
        RemoteViews remoteViews = new RemoteViews(widgetConfiguration.getPackageName(), R.layout.widget_layout);
        remoteViews.setOnClickPendingIntent(R.id.widgetIcon, activity);
        instance.updateAppWidget(widgetConfiguration.f908c, remoteViews);
        Intent intent2 = new Intent();
        intent2.putExtra("appWidgetId", widgetConfiguration.f908c);
        widgetConfiguration.setResult(-1, intent2);
        widgetConfiguration.finish();
    }

    static /* synthetic */ void m967a(WidgetConfiguration widgetConfiguration, ArrayList arrayList, ArrayList arrayList2) {
        ls.m1346c("langDialog");
        Builder builder = new Builder(widgetConfiguration);
        builder.setIcon(R.drawable.gvs);
        builder.setTitle("Select Recognition Language");
        View listView = new ListView(widgetConfiguration);
        listView.setAdapter(new ArrayAdapter(widgetConfiguration, 17367043, 16908308, arrayList));
        builder.setNegativeButton("Cancel", new no(widgetConfiguration));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new np(widgetConfiguration, arrayList2, create));
        create.show();
    }

    private void m968a(ArrayList<Locale> arrayList) {
        ls.m1346c("localeDialog");
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.phrases);
        builder.setTitle("Select Voice Engine Locale");
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Locale) it.next()).toString());
        }
        View listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter(this, 17367043, 16908308, arrayList2));
        builder.setOnCancelListener(new nq(this));
        builder.setNegativeButton("Cancel", new nr(this));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new ns(this, arrayList, create));
        create.show();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            try {
                Iterator it = intent.getStringArrayListExtra("availableVoices").iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    Locale locale = new Locale((String) it.next());
                    ls.m1346c("language locale: " + locale.toString());
                    arrayList.add(locale);
                }
                m968a(arrayList);
                return;
            } catch (Exception e) {
            }
        }
        m964a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f908c = extras.getInt("appWidgetId", 0);
            if (this.f908c == 0) {
                m964a();
            }
            BroadcastReceiver nnVar = new nn(this);
            sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, nnVar, null, -1, null, null);
            return;
        }
        m964a();
    }
}
