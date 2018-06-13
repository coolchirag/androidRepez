package com.brandall.nutter;

import android.widget.Toast;
import br.com.dina.ui.widget.C0100d;

final class am implements C0100d {
    final /* synthetic */ ActivityBugs f928a;

    private am(ActivityBugs activityBugs) {
        this.f928a = activityBugs;
    }

    public final void mo73a(int i) {
        if (ServiceTTS.f854f) {
            Toast.makeText(this.f928a, "Disabled during tutorial", 0).show();
            return;
        }
        switch (i) {
            case 0:
                jy.m1274y(this.f928a, "http://forum.xda-developers.com/showpost.php?p=25228934&postcount=659");
                return;
            default:
                return;
        }
    }
}
