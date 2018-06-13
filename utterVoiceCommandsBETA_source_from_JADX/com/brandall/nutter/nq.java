package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class nq implements OnCancelListener {
    final /* synthetic */ WidgetConfiguration f1799a;

    nq(WidgetConfiguration widgetConfiguration) {
        this.f1799a = widgetConfiguration;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f1799a.m964a();
    }
}
