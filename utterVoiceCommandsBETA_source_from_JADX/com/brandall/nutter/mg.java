package com.brandall.nutter;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class mg implements OnCompletionListener {
    mg() {
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (ServiceTTS.f844C > ServiceTTS.f845D) {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (ServiceTTS.f859k) {
                ServiceTTS.m931j();
            }
            ServiceTTS.f860l = false;
            ServiceTTS.m945x();
            return;
        }
        ServiceTTS.m944w();
    }
}
