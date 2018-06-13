package com.brandall.nutter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView;

final class cz implements OnItemLongClickListener {
    final /* synthetic */ ActivityPickerActivity f1036a;

    cz(ActivityPickerActivity activityPickerActivity) {
        this.f1036a = activityPickerActivity;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ExpandableListView.getPackedPositionType(j) != 1) {
            return false;
        }
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(j);
        ls.m1344a("groupPosition: " + packedPositionGroup + " : childPosition :" + ExpandableListView.getPackedPositionChild(j));
        ActivityPickerActivity.m619d(this.f1036a);
        return true;
    }
}
