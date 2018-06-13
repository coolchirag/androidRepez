package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

final class bd implements OnItemClickListener {
    final /* synthetic */ ActivityContactPicker f958a;
    private final /* synthetic */ String f959b;
    private final /* synthetic */ String f960c;
    private final /* synthetic */ Dialog f961d;

    bd(ActivityContactPicker activityContactPicker, String str, String str2, Dialog dialog) {
        this.f958a = activityContactPicker;
        this.f959b = str;
        this.f960c = str2;
        this.f961d = dialog;
    }

    @SuppressLint({"NewApi"})
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String obj = adapterView.getItemAtPosition(i).toString();
        ls.m1344a("selectedResult: " + i + " : " + obj);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f959b);
        arrayList.add(this.f960c);
        arrayList.add(obj);
        if (VERSION.SDK_INT >= 11) {
            new gx(this.f958a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{arrayList});
        } else {
            new gx(this.f958a).execute(new ArrayList[]{arrayList});
        }
        this.f961d.dismiss();
        this.f958a.finish();
    }
}
