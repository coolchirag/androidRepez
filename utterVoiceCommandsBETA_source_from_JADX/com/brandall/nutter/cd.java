package com.brandall.nutter;

import android.content.Intent;
import br.com.dina.ui.widget.C0100d;

final class cd implements C0100d {
    final /* synthetic */ ActivityCustomise f1004a;

    private cd(ActivityCustomise activityCustomise) {
        this.f1004a = activityCustomise;
    }

    public final void mo73a(int i) {
        if (ServiceTTS.f854f) {
            this.f1004a.m531a("Disabled during tutorial");
            return;
        }
        switch (i) {
            case 0:
                ActivityCustomise.m526a(this.f1004a);
                return;
            case 1:
                ActivityCustomise.m533b(this.f1004a);
                return;
            case 2:
                ActivityCustomise.m535c(this.f1004a);
                return;
            case 3:
                ActivityCustomise.m537d(this.f1004a);
                return;
            case 4:
                ActivityCustomise.m539e(this.f1004a);
                return;
            case 5:
                ActivityCustomise.m540f(this.f1004a);
                return;
            case 6:
                this.f1004a.startActivity(new Intent(this.f1004a, ActivityUserNickNames.class));
                return;
            case 7:
                ActivityCustomise.m542h(this.f1004a);
                return;
            case 8:
                this.f1004a.startActivity(new Intent(this.f1004a, ActivityUserWords.class));
                return;
            case 9:
                ActivityCustomise.m544j(this.f1004a);
                return;
            case 10:
                this.f1004a.m531a("coming soon!");
                return;
            case 11:
                ActivityCustomise.m546l(this.f1004a);
                return;
            case 12:
                ActivityCustomise.m547m(this.f1004a);
                return;
            case 13:
                ActivityCustomise.m548n(this.f1004a);
                return;
            case 14:
                ActivityCustomise.m549o(this.f1004a);
                return;
            default:
                return;
        }
    }
}
