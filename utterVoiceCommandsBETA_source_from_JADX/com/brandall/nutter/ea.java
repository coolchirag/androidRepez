package com.brandall.nutter;

import android.util.Log;

final class ea implements mu {
    final /* synthetic */ ActivityRecognitionVoices f1084a;

    private ea(ActivityRecognitionVoices activityRecognitionVoices) {
        this.f1084a = activityRecognitionVoices;
    }

    public final void mo91a(String str, Exception exception) {
        if (str != null) {
            ActivityRecognitionVoices.f702k = str;
        } else {
            Log.v("SimpleSpeech", "OAuth error: " + exception);
        }
    }
}
