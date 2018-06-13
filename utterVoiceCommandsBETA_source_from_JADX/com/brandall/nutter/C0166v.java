package com.brandall.nutter;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

final class C0166v implements OnItemClickListener {
    final /* synthetic */ ActivityAdvancedSettings f1829a;
    private final /* synthetic */ ArrayList f1830b;
    private final /* synthetic */ Dialog f1831c;

    C0166v(ActivityAdvancedSettings activityAdvancedSettings, ArrayList arrayList, Dialog dialog) {
        this.f1829a = activityAdvancedSettings;
        this.f1830b = arrayList;
        this.f1831c = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String obj = adapterView.getItemAtPosition(i).toString();
        if (hc.f1269b) {
            ls.m1344a("selectedResult: " + i + " : " + obj);
            ls.m1344a("stringLocale: " + ((String) this.f1830b.get(i)));
        }
        this.f1829a.f652c = (String) this.f1830b.get(i);
        this.f1829a.f653d = obj;
        this.f1831c.dismiss();
        if (ly.m1468e(this.f1829a)) {
            lc.m1313a(this.f1829a, false, "The locale, " + obj + ", was selected. Please choose the voice engine language.");
            Intent intent = new Intent();
            intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
            intent.getStringArrayListExtra("availableVoices");
            this.f1829a.startActivityForResult(Intent.createChooser(intent, "Select Voice Engine"), 0);
            return;
        }
        lc.m1313a(this.f1829a, false, "Sorry, but to configure this feature, you need to enable the application with the button above first.");
    }
}
