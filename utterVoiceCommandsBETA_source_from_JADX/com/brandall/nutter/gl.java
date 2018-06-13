package com.brandall.nutter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class gl implements OnItemClickListener {
    final /* synthetic */ ActivityUserWords f1239a;

    gl(ActivityUserWords activityUserWords) {
        this.f1239a = activityUserWords;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ls.m1344a("selectedResult: " + adapterView.getItemAtPosition(i).toString());
        this.f1239a.f747g = i;
        ls.m1344a("myPosition: " + this.f1239a.f747g);
        ActivityUserWords.m717b(this.f1239a);
    }
}
