package com.brandall.nutter;

import br.com.dina.ui.widget.C0100d;

final class ag implements C0100d {
    final /* synthetic */ ActivityAdvancedSettings f920a;

    private ag(ActivityAdvancedSettings activityAdvancedSettings) {
        this.f920a = activityAdvancedSettings;
    }

    public final void mo73a(int i) {
        if (ServiceTTS.f854f) {
            this.f920a.m491a("Disabled during tutorial", false);
            return;
        }
        switch (i) {
            case 0:
                ActivityAdvancedSettings.m488a(this.f920a);
                return;
            case 1:
                ActivityAdvancedSettings.m493b(this.f920a);
                return;
            case 2:
                ActivityAdvancedSettings.m496c(this.f920a);
                return;
            case 3:
                ActivityAdvancedSettings.m498d(this.f920a);
                return;
            case 4:
                ActivityAdvancedSettings.m500e(this.f920a);
                return;
            case 5:
                ActivityAdvancedSettings.m502f(this.f920a);
                return;
            case 6:
                ActivityAdvancedSettings.m503g(this.f920a);
                return;
            case 7:
                ActivityAdvancedSettings.m504h(this.f920a);
                return;
            case 8:
                this.f920a.m491a("coming soon!", true);
                return;
            case 9:
                jy.m1228a(this.f920a, ActivityPowerUser.class, false);
                return;
            default:
                return;
        }
    }
}
