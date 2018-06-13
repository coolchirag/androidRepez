package com.nuance.nmdp.speechkit;

import android.content.Context;
import android.media.AudioManager;

final class ee extends dy {
    private AudioManager f2743c = ((AudioManager) this.a.getSystemService("audio"));

    public ee(Context context) {
        super(context);
    }

    public final void mo280d() {
        this.f2743c.startBluetoothSco();
    }

    public final void mo281e() {
        this.f2743c.stopBluetoothSco();
    }

    public final int mo282f() {
        return m2461b() ? 0 : 3;
    }

    public final int mo283g() {
        return m2461b() ? dx.f2709a : 1;
    }
}
