package com.brandall.nutter;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

final class np implements OnItemClickListener {
    final /* synthetic */ WidgetConfiguration f1796a;
    private final /* synthetic */ ArrayList f1797b;
    private final /* synthetic */ Dialog f1798c;

    np(WidgetConfiguration widgetConfiguration, ArrayList arrayList, Dialog dialog) {
        this.f1796a = widgetConfiguration;
        this.f1797b = arrayList;
        this.f1798c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String obj = adapterView.getItemAtPosition(i).toString();
        ls.m1344a("selectedResult: " + i + " : " + obj);
        ls.m1344a("stringLocale: " + ((String) this.f1797b.get(i)));
        this.f1796a.f906a = (String) this.f1797b.get(i);
        this.f1796a.f907b = obj;
        this.f1798c.dismiss();
        Intent intent = new Intent();
        intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
        intent.getStringArrayListExtra("availableVoices");
        this.f1796a.startActivityForResult(Intent.createChooser(intent, "Select Voice Engine"), 0);
    }
}
