package com.brandall.nutter;

import android.content.pm.PackageInfo;
import java.util.Comparator;

public final class ak implements Comparator<PackageInfo> {
    final /* synthetic */ ActivityApplications f926a;

    public ak(ActivityApplications activityApplications) {
        this.f926a = activityApplications;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((PackageInfo) obj).applicationInfo.loadLabel(this.f926a.f654a).toString().compareToIgnoreCase(((PackageInfo) obj2).applicationInfo.loadLabel(this.f926a.f654a).toString());
    }
}
