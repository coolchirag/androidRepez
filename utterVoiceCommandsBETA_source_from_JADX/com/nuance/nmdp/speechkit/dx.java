package com.nuance.nmdp.speechkit;

import android.media.MediaRecorder.AudioSource;

public final class dx {
    public static final int f2709a;

    static {
        eb ebVar = new eb();
        Integer num = (Integer) eb.m2486a(AudioSource.class, "VOICE_RECOGNITION");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        f2709a = num.intValue();
    }
}
