package com.brandall.nutter;

import android.content.Context;
import android.content.Intent;
import java.util.TimerTask;

final class lq extends TimerTask {
    private final /* synthetic */ Context f1694a;

    lq(Context context) {
        this.f1694a = context;
    }

    public final void run() {
        if (hc.f1269b) {
            ls.m1346c("MemoryHelper run");
        }
        Context context = this.f1694a;
        Intent intent = new Intent(context, ActivityHome.class);
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.putExtra("shutdown", true);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            if (hc.f1269b) {
                ls.m1348e("ExecuteIntent shutdown: failed");
            }
        }
    }
}
