package com.brandall.nutter;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class nb implements OnItemClickListener {
    final /* synthetic */ TaskerPluginActivity f1760a;
    private final /* synthetic */ Dialog f1761b;

    nb(TaskerPluginActivity taskerPluginActivity, Dialog dialog) {
        this.f1760a = taskerPluginActivity;
        this.f1761b = dialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object obj = adapterView.getItemAtPosition(i).toString();
        if (hc.f1269b) {
            ls.m1344a("selectedResult: " + i + " : " + obj);
        }
        this.f1760a.f886a.setChecked(true);
        this.f1760a.f886a.setText(obj);
        this.f1760a.f901p = obj;
        this.f1761b.dismiss();
    }
}
