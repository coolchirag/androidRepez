package com.brandall.nutter;

import android.app.backup.RestoreObserver;

final class be extends RestoreObserver {
    final /* synthetic */ ActivityCustomise f962a;

    be(ActivityCustomise activityCustomise) {
        this.f962a = activityCustomise;
    }

    public final void onUpdate(int i, String str) {
        if (hc.f1269b) {
            ls.m1346c("onUpdate: noBeingRestored: " + i + " : currentPackage: " + str);
        }
    }

    public final void restoreFinished(int i) {
        if (hc.f1269b) {
            ls.m1346c("restoreFinished: code: " + i);
        }
    }

    public final void restoreStarting(int i) {
        if (hc.f1269b) {
            ls.m1346c("restoreStarting: numPackages: " + i);
        }
    }
}
