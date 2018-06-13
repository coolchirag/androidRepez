package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.util.ArrayList;

final class bz implements OnClickListener {
    ArrayList<String> f996a = new ArrayList();
    final /* synthetic */ ActivityCustomise f997b;

    bz(ActivityCustomise activityCustomise) {
        this.f997b = activityCustomise;
    }

    @SuppressLint({"NewApi"})
    public final void onClick(DialogInterface dialogInterface, int i) {
        GlobalV.m886s(true);
        GlobalV.m858k(1);
        switch (i) {
            case 0:
                this.f996a.add("display contact");
                if (VERSION.SDK_INT >= 11) {
                    new gx(this.f997b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{this.f996a});
                    return;
                }
                new gx(this.f997b).execute(new ArrayList[]{this.f996a});
                return;
            case 1:
                this.f996a.add("call contact");
                if (VERSION.SDK_INT >= 11) {
                    new gx(this.f997b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{this.f996a});
                    return;
                }
                new gx(this.f997b).execute(new ArrayList[]{this.f996a});
                return;
            case 2:
                this.f996a.add("application");
                if (VERSION.SDK_INT >= 11) {
                    new gx(this.f997b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{this.f996a});
                    return;
                }
                new gx(this.f997b).execute(new ArrayList[]{this.f996a});
                return;
            case 3:
                this.f996a.add("activity");
                if (VERSION.SDK_INT >= 11) {
                    new gx(this.f997b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{this.f996a});
                    return;
                }
                new gx(this.f997b).execute(new ArrayList[]{this.f996a});
                return;
            case 4:
                if (ActivityCustomise.m550p(this.f997b)) {
                    this.f996a.add("tasker");
                    if (VERSION.SDK_INT >= 11) {
                        new gx(this.f997b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{this.f996a});
                        return;
                    }
                    new gx(this.f997b).execute(new ArrayList[]{this.f996a});
                    return;
                }
                GlobalV.m886s(false);
                GlobalV.m858k(0);
                return;
            default:
                return;
        }
    }
}
