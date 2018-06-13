package com.brandall.nutter;

import android.widget.Toast;
import br.com.dina.ui.widget.C0100d;

final class dz implements C0100d {
    final /* synthetic */ ActivityRecognitionVoices f1080a;

    private dz(ActivityRecognitionVoices activityRecognitionVoices) {
        this.f1080a = activityRecognitionVoices;
    }

    public final void mo73a(int i) {
        if (ServiceTTS.f854f) {
            Toast.makeText(this.f1080a, "Disabled during tutorial", 0).show();
            return;
        }
        switch (i) {
            case 0:
                ActivityRecognitionVoices.m635a(this.f1080a);
                return;
            case 1:
                ActivityRecognitionVoices.m639b(this.f1080a);
                return;
            case 2:
                ActivityRecognitionVoices.m641c(this.f1080a);
                return;
            case 3:
                ActivityRecognitionVoices.m642d(this.f1080a);
                return;
            case 4:
                ActivityRecognitionVoices.m643e(this.f1080a);
                return;
            case 5:
                ActivityRecognitionVoices.m644f(this.f1080a);
                return;
            case 6:
                ActivityRecognitionVoices.m645g(this.f1080a);
                return;
            case 7:
                ActivityRecognitionVoices.m646h(this.f1080a);
                return;
            case 8:
                ActivityRecognitionVoices.m647i(this.f1080a);
                return;
            case 9:
                ActivityRecognitionVoices.m648j(this.f1080a);
                return;
            case 10:
                ActivityRecognitionVoices.m649k(this.f1080a);
                return;
            case 11:
                ActivityRecognitionVoices.m650l(this.f1080a);
                return;
            case 12:
                ActivityRecognitionVoices.m651m(this.f1080a);
                return;
            default:
                return;
        }
    }
}
