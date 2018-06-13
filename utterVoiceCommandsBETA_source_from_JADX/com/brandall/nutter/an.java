package com.brandall.nutter;

import br.com.dina.ui.widget.C0100d;
import wei.mark.standout.StandOutWindow;

final class an implements C0100d {
    final /* synthetic */ ActivityCommand f929a;

    private an(ActivityCommand activityCommand) {
        this.f929a = activityCommand;
    }

    public final void mo73a(int i) {
        switch (i) {
            case 0:
                ly.m1460a(this.f929a, 12000, true);
                StandOutWindow.m741a(this.f929a, VoiceResultsWindow.class, 2);
                lc.m1313a(this.f929a, false, "You can say, float commands, to view this at any time.");
                return;
            default:
                return;
        }
    }
}
