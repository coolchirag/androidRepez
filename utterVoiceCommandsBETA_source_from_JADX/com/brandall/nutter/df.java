package com.brandall.nutter;

import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import java.util.Collections;
import java.util.List;

final class df extends AsyncTask<Void, Void, Void> {
    List<PackageInfo> f1046a;
    final /* synthetic */ ActivityPickerActivity f1047b;

    private df(ActivityPickerActivity activityPickerActivity) {
        this.f1047b = activityPickerActivity;
    }

    public final /* synthetic */ Object doInBackground(Object... objArr) {
        ActivityPickerActivity activityPickerActivity = this.f1047b;
        ActivityPickerActivity.m615a();
        this.f1046a = this.f1047b.f694a.getInstalledPackages(0);
        if (this.f1046a != null) {
            Collections.sort(this.f1046a, new dh(this.f1047b));
        }
        return null;
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        this.f1047b.f695b.setVisibility(4);
        try {
            this.f1047b.setListAdapter(new dg(this.f1047b, this.f1046a));
        } catch (Exception e) {
            e.printStackTrace();
            ActivityPickerActivity.m618c(this.f1047b);
        }
    }
}
