package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class br implements OnCancelListener {
    final /* synthetic */ ActivityCustomise f981a;

    br(ActivityCustomise activityCustomise) {
        this.f981a = activityCustomise;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f981a.f674g.setChecked(false);
        this.f981a.f674g.setText("Non-English Recognition Language");
        this.f981a.f672e = "";
    }
}
