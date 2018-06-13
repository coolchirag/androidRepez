package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;

public class BroadcastReceiverHelper extends BroadcastReceiver {
    @SuppressLint({"NewApi"})
    public void onReceive(Context context, Intent intent) {
        if (hc.f1269b) {
            ls.m1346c("BRH - onReceive");
        }
        if (intent.getAction() != null) {
            if (intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
                if (hc.f1269b) {
                    ls.m1346c("ACTION_MEDIA_MOUNTED");
                }
                boolean al = lx.al(context);
                if (al) {
                    if (hc.f1269b) {
                        ls.m1346c("shakeSet: " + al);
                    }
                    if (hc.f1269b) {
                        ls.m1346c("mServiceShakeEvent");
                    }
                    context.startService(new Intent(context, ServiceShakeEvent.class));
                } else if (hc.f1269b) {
                    ls.m1346c("shakeSet: " + al);
                }
                al = lx.am(context);
                if (al) {
                    if (hc.f1269b) {
                        ls.m1346c("waveSet: " + al);
                    }
                    if (hc.f1269b) {
                        ls.m1346c("mServiceWaveEvent");
                    }
                    context.startService(new Intent(context, ServiceWaveEvent.class));
                } else if (hc.f1269b) {
                    ls.m1346c("waveSet: " + al);
                }
                if (VERSION.SDK_INT >= 11) {
                    new ky(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    new la(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    new ky(context).execute(new Void[0]);
                    new la(context).execute(new Void[0]);
                }
                context.sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, new GVSLanguage(), null, 69, null, null);
            } else if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
                if (hc.f1269b) {
                    ls.m1346c("ACTION_BOOT_COMPLETED");
                }
                if (lx.m1396a(context)) {
                    if (hc.f1269b) {
                        ls.m1346c("mServiceTTS");
                    }
                    context.startService(new Intent(context, ServiceTTS.class));
                }
                context.sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, new GVSLanguage(), null, 69, null, null);
                if (!hc.f1270c) {
                    return;
                }
                if (VERSION.SDK_INT >= 11) {
                    new kz(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    new kz(context).execute(new Void[0]);
                }
            } else if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED") || intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
                if (hc.f1269b) {
                    ls.m1346c("ACTION_PACKAGE_ADDED/REMOVED");
                }
                if (!GlobalV.m908z()) {
                    if (hc.f1269b) {
                        ls.m1346c("BRH !getGAppListRunning - fired");
                    }
                    if (VERSION.SDK_INT >= 11) {
                        new kv(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    } else {
                        new kv(context).execute(new Void[0]);
                    }
                } else if (hc.f1269b) {
                    ls.m1346c("BRH getGAppListRunning - skipping");
                }
            } else if (hc.f1269b) {
                ls.m1347d("mIntent action wasn't recognised");
            }
        } else if (hc.f1269b) {
            ls.m1347d("mIntent was null");
        }
    }
}
