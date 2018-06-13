package com.brandall.nutter;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

final class lh implements OnItemClickListener {
    final /* synthetic */ LauncherShortcutProvider f1671a;
    private final /* synthetic */ ArrayList f1672b;
    private final /* synthetic */ Dialog f1673c;

    lh(LauncherShortcutProvider launcherShortcutProvider, ArrayList arrayList, Dialog dialog) {
        this.f1671a = launcherShortcutProvider;
        this.f1672b = arrayList;
        this.f1673c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String obj = adapterView.getItemAtPosition(i).toString();
        ls.m1344a("selectedResult: " + i + " : " + obj);
        ls.m1344a("stringLocale: " + ((String) this.f1672b.get(i)));
        this.f1671a.f827a = (String) this.f1672b.get(i);
        this.f1671a.f828b = obj;
        this.f1673c.dismiss();
        Intent intent = new Intent();
        intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
        intent.getStringArrayListExtra("availableVoices");
        this.f1671a.startActivityForResult(Intent.createChooser(intent, "Select Voice Engine"), 0);
    }
}
