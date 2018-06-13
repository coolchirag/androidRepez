package com.brandall.nutter;

import android.os.FileObserver;

public final class lr extends FileObserver {
    public String f1695a;

    public lr(String str) {
        super(str, 256);
        this.f1695a = str;
    }

    public final void onEvent(int i, String str) {
        if (str != null && (i & 256) != 0) {
            ls.m1346c("FileObserver: " + this.f1695a + "/" + str);
            GlobalV.ar();
            GlobalV.m900x(this.f1695a + "/" + str);
            stopWatching();
        }
    }
}
