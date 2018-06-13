package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class ko implements OnClickListener {
    final /* synthetic */ FileBrowserActivity f1616a;

    ko(FileBrowserActivity fileBrowserActivity) {
        this.f1616a = fileBrowserActivity;
    }

    public final void onClick(View view) {
        FileBrowserActivity.m723a(this.f1616a);
        this.f1616a.m732d();
        this.f1616a.f752b.notifyDataSetChanged();
        this.f1616a.m729c();
    }
}
