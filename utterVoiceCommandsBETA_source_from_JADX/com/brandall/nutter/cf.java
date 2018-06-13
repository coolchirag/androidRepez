package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;

final class cf implements OnClickListener {
    final /* synthetic */ ActivityHome f1006a;

    cf(ActivityHome activityHome) {
        this.f1006a = activityHome;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Editor edit = this.f1006a.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("developer_note_2", true);
        edit.commit();
    }
}
