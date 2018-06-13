package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class li implements OnCancelListener {
    final /* synthetic */ LauncherShortcutProvider f1674a;

    li(LauncherShortcutProvider launcherShortcutProvider) {
        this.f1674a = launcherShortcutProvider;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f1674a.finish();
    }
}
