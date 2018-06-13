package com.brandall.nutter;

import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import java.util.Collections;
import java.util.List;

final class aj extends AsyncTask<Void, Void, Void> {
    List<PackageInfo> f924a;
    final /* synthetic */ ActivityApplications f925b;

    private aj(ActivityApplications activityApplications) {
        this.f925b = activityApplications;
    }

    public final /* synthetic */ Object doInBackground(Object... objArr) {
        ActivityApplications activityApplications = this.f925b;
        ActivityApplications.m509a();
        this.f924a = this.f925b.f654a.getInstalledPackages(0);
        Collections.sort(this.f924a, new ak(this.f925b));
        return null;
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        this.f925b.f655b.setVisibility(4);
        this.f925b.f656c.setAdapter(new ai(this.f925b, this.f924a));
    }
}
