package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;

final class cg implements OnClickListener {
    final /* synthetic */ ActivityHome f1007a;

    cg(ActivityHome activityHome) {
        this.f1007a = activityHome;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Editor edit = this.f1007a.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("disclaimer", true);
        edit.commit();
        this.f1007a.f679b.setChecked(true);
        this.f1007a.m563c();
    }
}
