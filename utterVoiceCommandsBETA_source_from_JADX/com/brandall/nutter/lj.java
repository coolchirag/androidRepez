package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class lj implements OnClickListener {
    final /* synthetic */ LauncherShortcutProvider f1675a;

    lj(LauncherShortcutProvider launcherShortcutProvider) {
        this.f1675a = launcherShortcutProvider;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1675a.finish();
    }
}
