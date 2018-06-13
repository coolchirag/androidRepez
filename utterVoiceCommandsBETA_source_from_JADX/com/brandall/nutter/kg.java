package com.brandall.nutter;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class kg implements OnCompletionListener {
    final /* synthetic */ kf f1612a;

    kg(kf kfVar) {
        this.f1612a = kfVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                mediaPlayer.release();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }
}
