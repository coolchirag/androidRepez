package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class lg implements OnClickListener {
    final /* synthetic */ LauncherShortcutProvider f1670a;

    lg(LauncherShortcutProvider launcherShortcutProvider) {
        this.f1670a = launcherShortcutProvider;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1670a.finish();
    }
}
