package com.brandall.nutter;

import br.com.dina.ui.widget.C0100d;

final class ds implements C0100d {
    final /* synthetic */ ActivityPowerUser f1073a;

    private ds(ActivityPowerUser activityPowerUser) {
        this.f1073a = activityPowerUser;
    }

    public final void mo73a(int i) {
        if (ServiceTTS.f854f) {
            this.f1073a.m622a("Disabled during tutorial", false);
            return;
        }
        switch (i) {
            case 0:
                ActivityPowerUser.m620a(this.f1073a);
                return;
            case 1:
                ActivityPowerUser.m623b(this.f1073a);
                return;
            case 2:
                ActivityPowerUser.m625c(this.f1073a);
                return;
            case 3:
                ActivityPowerUser.m627d(this.f1073a);
                return;
            case 4:
                ActivityPowerUser.m628e(this.f1073a);
                return;
            case 5:
                ActivityPowerUser.m629f(this.f1073a);
                return;
            case 6:
                ActivityPowerUser.m630g(this.f1073a);
                return;
            case 7:
                ActivityPowerUser.m631h(this.f1073a);
                return;
            case 8:
                ActivityPowerUser.m632i(this.f1073a);
                return;
            default:
                return;
        }
    }
}
