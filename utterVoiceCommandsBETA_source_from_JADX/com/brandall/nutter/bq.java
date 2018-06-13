package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bq implements OnClickListener {
    final /* synthetic */ ActivityCustomise f980a;

    bq(ActivityCustomise activityCustomise) {
        this.f980a = activityCustomise;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f980a.f674g.setChecked(false);
        this.f980a.f674g.setText("Non-English Recognition Language");
        this.f980a.f672e = "";
    }
}
