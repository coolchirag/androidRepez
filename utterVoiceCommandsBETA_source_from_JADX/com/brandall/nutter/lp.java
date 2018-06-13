package com.brandall.nutter;

import android.content.Context;
import android.os.Debug;
import java.io.File;
import java.util.Timer;

public final class lp {
    public static void m1341a(Context context) {
        if (hc.f1269b) {
            ls.m1346c("VM Heap Size: " + Runtime.getRuntime().totalMemory());
            ls.m1346c("Allocated VM Memory: " + String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
            ls.m1346c("Remaining VM Heap Size: " + String.valueOf(Runtime.getRuntime().maxMemory()));
            ls.m1346c("Native Allocated Memory: " + String.valueOf(Debug.getNativeHeapAllocatedSize()));
        }
        m1343b(context);
        ly.m1459a(context);
        ly.m1465b(context, 0, false);
        new Timer().schedule(new lq(context), 2000);
    }

    private static boolean m1342a(File file) {
        if (file != null && file.isDirectory()) {
            if (hc.f1269b) {
                ls.m1344a("dir: " + file.getAbsolutePath());
            }
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                if (hc.f1269b) {
                    ls.m1344a("children[i]: " + list[i]);
                }
                if (!m1342a(new File(file, list[i]))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static void m1343b(Context context) {
        File file = new File(context.getCacheDir().getParent());
        if (file.exists()) {
            if (hc.f1269b) {
                ls.m1344a("appDir: " + file.getAbsolutePath());
            }
            for (String str : file.list()) {
                if (str.equals("cache")) {
                    if (hc.f1269b) {
                        ls.m1344a("s: " + str);
                    }
                    m1342a(new File(file, str));
                }
            }
        }
    }
}
