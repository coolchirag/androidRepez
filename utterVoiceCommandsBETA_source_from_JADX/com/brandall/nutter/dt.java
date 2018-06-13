package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class dt implements OnClickListener {
    final /* synthetic */ ActivityRecognitionVoices f1074a;

    dt(ActivityRecognitionVoices activityRecognitionVoices) {
        this.f1074a = activityRecognitionVoices;
    }

    public final void onClick(View view) {
        if (this.f1074a.f712l != null) {
            this.f1074a.f712l.stopRecording();
        }
    }
}
