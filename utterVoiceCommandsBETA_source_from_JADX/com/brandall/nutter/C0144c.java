package com.brandall.nutter;

import android.widget.Toast;
import br.com.dina.ui.widget.C0100d;

final class C0144c implements C0100d {
    final /* synthetic */ ActivityAccount f998a;

    private C0144c(ActivityAccount activityAccount) {
        this.f998a = activityAccount;
    }

    public final void mo73a(int i) {
        if (ServiceTTS.f854f) {
            Toast.makeText(this.f998a, "Disabled during tutorial", 0).show();
            return;
        }
        switch (i) {
            case 0:
                ActivityAccount.m481a(this.f998a);
                return;
            case 1:
                ActivityAccount.m483b(this.f998a);
                return;
            case 2:
                ActivityAccount.m484c(this.f998a);
                return;
            case 3:
                ActivityAccount.m485d(this.f998a);
                return;
            case 4:
                ActivityAccount.m486e(this.f998a);
                return;
            case 5:
                if (lx.m1436k(this.f998a).matches("a")) {
                    ActivityAccount.m487f(this.f998a);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
