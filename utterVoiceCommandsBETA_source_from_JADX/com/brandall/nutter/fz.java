package com.brandall.nutter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class fz implements OnItemClickListener {
    final /* synthetic */ ActivityUserPhrases f1218a;

    fz(ActivityUserPhrases activityUserPhrases) {
        this.f1218a = activityUserPhrases;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ls.m1344a("selectedResult: " + adapterView.getItemAtPosition(i).toString());
        this.f1218a.f740k = i;
        ls.m1344a("myPosition: " + this.f1218a.f740k);
        ActivityUserPhrases.m702b(this.f1218a);
    }
}
