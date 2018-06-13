package com.brandall.nutter;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

final class fg implements OnSeekBarChangeListener {
    final /* synthetic */ ActivitySettings f1188a;
    private final /* synthetic */ TextView f1189b;

    fg(ActivitySettings activitySettings, TextView textView) {
        this.f1188a = activitySettings;
        this.f1189b = textView;
    }

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (i == 0) {
            this.f1189b.setText("Pause timeout set to default");
        } else if (i == 1) {
            this.f1189b.setText("Pause timeout will be " + i + " second");
        } else {
            this.f1189b.setText("Pause timeout will be " + i + " seconds");
        }
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
