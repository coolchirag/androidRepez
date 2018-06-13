package com.brandall.nutter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class ft implements OnItemClickListener {
    final /* synthetic */ ActivityUserNickNames f1207a;

    ft(ActivityUserNickNames activityUserNickNames) {
        this.f1207a = activityUserNickNames;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ls.m1344a("selectedResult: " + adapterView.getItemAtPosition(i).toString());
        this.f1207a.f728g = i;
        ls.m1344a("myPosition: " + this.f1207a.f728g);
        ActivityUserNickNames.m693b(this.f1207a);
    }
}
