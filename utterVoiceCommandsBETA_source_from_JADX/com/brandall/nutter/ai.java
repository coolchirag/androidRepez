package com.brandall.nutter;

import android.content.pm.PackageInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

final class ai extends BaseAdapter {
    final /* synthetic */ ActivityApplications f922a;
    private final List<PackageInfo> f923b;

    public ai(ActivityApplications activityApplications, List<PackageInfo> list) {
        this.f922a = activityApplications;
        this.f923b = list;
    }

    private PackageInfo m971a(int i) {
        return (PackageInfo) this.f923b.get(i);
    }

    public final int getCount() {
        return this.f923b.size();
    }

    public final Object getItem(int i) {
        return m971a(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View textView = new TextView(this.f922a);
        textView.setGravity(19);
        textView.setPadding(2, 0, 0, 0);
        PackageInfo a = m971a(i);
        textView.setText(a.applicationInfo.loadLabel(this.f922a.f654a));
        try {
            textView.setCompoundDrawablesWithIntrinsicBounds(nk.m1493a(a.applicationInfo.loadIcon(this.f922a.f654a), this.f922a), null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            ActivityApplications activityApplications = this.f922a;
            ActivityApplications.m509a();
            if (hc.f1269b) {
                ls.m1346c("ActivityApplications catch");
            }
        }
        return textView;
    }
}
