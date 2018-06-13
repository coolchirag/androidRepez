package com.brandall.nutter;

import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

final class ng implements OnCheckedChangeListener {
    final /* synthetic */ TaskerPluginActivity f1766a;

    ng(TaskerPluginActivity taskerPluginActivity) {
        this.f1766a = taskerPluginActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            Intent intent = new Intent();
            intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
            intent.getStringArrayListExtra("availableVoices");
            try {
                this.f1766a.startActivityForResult(Intent.createChooser(intent, "Select Voice Engine"), 1);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this.f1766a.getApplicationContext(), "Something went wrong", 0).show();
                return;
            }
        }
        this.f1766a.f886a.setText("Non-English Voice");
    }
}
