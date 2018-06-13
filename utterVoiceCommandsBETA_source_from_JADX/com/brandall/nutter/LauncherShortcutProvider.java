package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class LauncherShortcutProvider extends Activity {
    public String f827a = "";
    public String f828b = "";
    int f829c = 0;

    static /* synthetic */ void m909a(LauncherShortcutProvider launcherShortcutProvider, ArrayList arrayList, ArrayList arrayList2) {
        ls.m1346c("langDialog");
        Builder builder = new Builder(launcherShortcutProvider);
        builder.setIcon(R.drawable.gvs);
        builder.setTitle("Select Recognition Language");
        View listView = new ListView(launcherShortcutProvider);
        listView.setAdapter(new ArrayAdapter(launcherShortcutProvider, 17367043, 16908308, arrayList));
        builder.setNegativeButton("Cancel", new lg(launcherShortcutProvider));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new lh(launcherShortcutProvider, arrayList2, create));
        create.show();
    }

    private void m910a(ArrayList<Locale> arrayList) {
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
        builder.setOnCancelListener(new li(this));
        builder.setNegativeButton("Cancel", new lj(this));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new lk(this, arrayList, create));
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
                m910a(arrayList);
                return;
            } catch (Exception e) {
            }
        }
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ls.m1345b("Landscape");
        } else if (configuration.orientation == 1) {
            ls.m1345b("Portrait");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BroadcastReceiver lfVar = new lf(this);
        sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, lfVar, null, -1, null, null);
    }
}
