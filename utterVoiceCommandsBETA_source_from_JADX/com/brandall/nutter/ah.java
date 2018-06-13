package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Locale;

final class ah implements OnItemClickListener {
    final /* synthetic */ ActivityApplications f921a;

    ah(ActivityApplications activityApplications) {
        this.f921a = activityApplications;
    }

    @SuppressLint({"NewApi"})
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PackageInfo packageInfo = (PackageInfo) adapterView.getAdapter().getItem(i);
        ls.m1344a("packageName: " + packageInfo.applicationInfo.packageName);
        ls.m1344a("packageLabel: " + packageInfo.applicationInfo.loadLabel(this.f921a.f654a).toString().toLowerCase(Locale.US));
        ArrayList arrayList = new ArrayList();
        arrayList.add(packageInfo.applicationInfo.loadLabel(this.f921a.f654a).toString().toLowerCase(Locale.US));
        arrayList.add(packageInfo.applicationInfo.packageName);
        if (VERSION.SDK_INT >= 11) {
            new gx(this.f921a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{arrayList});
        } else {
            new gx(this.f921a).execute(new ArrayList[]{arrayList});
        }
        this.f921a.finish();
    }
}
