package com.nuance.nmdp.speechkit;

import android.content.Context;
import android.media.AudioManager;

final class ec extends dy {
    private AudioManager f2742c = ((AudioManager) this.a.getSystemService("audio"));

    public ec(Context context) {
        super(context);
    }

    public final void mo280d() {
        if (!dw.f2704c) {
            this.f2742c.startBluetoothSco();
        }
    }

    public final void mo281e() {
        if (!dw.f2704c) {
            this.f2742c.stopBluetoothSco();
        }
    }

    public final int mo282f() {
        return m2461b() ? 0 : 3;
    }

    public final int mo283g() {
        return m2461b() ? dx.f2709a : 1;
    }
}
