package com.brandall.nutter;

import br.com.dina.ui.widget.C0100d;

final class fr implements C0100d {
    final /* synthetic */ ActivitySettings f1205a;

    private fr(ActivitySettings activitySettings) {
        this.f1205a = activitySettings;
    }

    public final void mo73a(int i) {
        if (ServiceTTS.f854f) {
            this.f1205a.m661a("Disabled during tutorial", false);
            return;
        }
        switch (i) {
            case 0:
                ActivitySettings.m659a(this.f1205a);
                return;
            case 1:
                ActivitySettings.m663b(this.f1205a);
                return;
            case 2:
                ActivitySettings.m665c(this.f1205a);
                return;
            case 3:
                ActivitySettings.m666d(this.f1205a);
                return;
            case 4:
                ActivitySettings.m667e(this.f1205a);
                return;
            case 5:
                ActivitySettings.m668f(this.f1205a);
                return;
            case 6:
                ActivitySettings.m669g(this.f1205a);
                return;
            case 7:
                ActivitySettings.m670h(this.f1205a);
                return;
            case 8:
                ActivitySettings.m671i(this.f1205a);
                return;
            case 9:
                ActivitySettings.m672j(this.f1205a);
                return;
            case 10:
                jy.m1228a(this.f1205a, ActivityAdvancedSettings.class, false);
                return;
            default:
                return;
        }
    }
}
