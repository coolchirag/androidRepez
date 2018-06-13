package com.google.ads;

public final class C0240b {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1646a(com.google.ads.internal.C0264p r6, com.google.ads.internal.C0265q r7) {
        /*
        r1 = com.google.ads.AdActivity.f1911b;
        monitor-enter(r1);
        r0 = com.google.ads.AdActivity.f1913d;	 Catch:{ all -> 0x0030 }
        if (r0 != 0) goto L_0x0023;
    L_0x000b:
        com.google.ads.AdActivity.f1913d = r6;	 Catch:{ all -> 0x0030 }
    L_0x000e:
        monitor-exit(r1);
        r0 = r6.m1742g();
        r0 = r0.f2014e;
        r0 = r0.m1853a();
        r0 = (android.app.Activity) r0;
        if (r0 != 0) goto L_0x0033;
    L_0x001d:
        r0 = "activity was null while launching an AdActivity.";
        com.google.ads.util.C0290d.m1871e(r0);
    L_0x0022:
        return;
    L_0x0023:
        r0 = com.google.ads.AdActivity.f1913d;	 Catch:{ all -> 0x0030 }
        if (r0 == r6) goto L_0x000e;
    L_0x0029:
        r0 = "Tried to launch a new AdActivity with a different AdManager.";
        com.google.ads.util.C0290d.m1865b(r0);	 Catch:{ all -> 0x0030 }
        monitor-exit(r1);	 Catch:{ all -> 0x0030 }
        goto L_0x0022;
    L_0x0030:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0033:
        r1 = new android.content.Intent;
        r2 = r0.getApplicationContext();
        r3 = com.google.ads.AdActivity.class;
        r1.<init>(r2, r3);
        r2 = "com.google.ads.AdOpener";
        r3 = new android.os.Bundle;
        r3.<init>();
        r4 = "action";
        r5 = r7.f2178a;
        r3.putString(r4, r5);
        r4 = "params";
        r5 = r7.f2179b;
        r3.putSerializable(r4, r5);
        r1.putExtra(r2, r3);
        r2 = "Launching AdActivity.";
        com.google.ads.util.C0290d.m1862a(r2);	 Catch:{ ActivityNotFoundException -> 0x005f }
        r0.startActivity(r1);	 Catch:{ ActivityNotFoundException -> 0x005f }
        goto L_0x0022;
    L_0x005f:
        r0 = move-exception;
        r1 = "Activity not found.";
        com.google.ads.util.C0290d.m1866b(r1, r0);
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.b.a(com.google.ads.internal.p, com.google.ads.internal.q):void");
    }

    public static boolean m1647a() {
        boolean z;
        synchronized (AdActivity.f1911b) {
            z = AdActivity.f1914e != null;
        }
        return z;
    }
}
