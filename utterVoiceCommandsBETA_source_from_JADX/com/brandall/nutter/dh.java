package com.brandall.nutter;

import android.content.pm.PackageInfo;
import java.util.Comparator;

public final class dh implements Comparator<PackageInfo> {
    final /* synthetic */ ActivityPickerActivity f1053a;

    public dh(ActivityPickerActivity activityPickerActivity) {
        this.f1053a = activityPickerActivity;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((PackageInfo) obj).applicationInfo.loadLabel(this.f1053a.f694a).toString().compareToIgnoreCase(((PackageInfo) obj2).applicationInfo.loadLabel(this.f1053a.f694a).toString());
    }
}
