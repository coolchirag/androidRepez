package com.brandall.nutter;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class EasterEgg extends Activity {
    private MediaPlayer f749a;

    static /* synthetic */ void m721a(EasterEgg easterEgg) {
        ls.m1346c("easterEggFirst.");
        GlobalV.m893u(true);
        GlobalV.m896v(true);
        String str = "first,";
        switch (lx.m1425g(easterEgg)) {
            case 2:
                str = "second,";
                break;
            case 3:
                str = "third,";
                break;
            case 4:
                str = "fourth,";
                break;
            case 5:
                str = "fifth,";
                break;
        }
        lc.m1313a(easterEgg, true, "Please say the, " + str + " Easter Egg password");
    }

    public void onBackPressed() {
        ls.m1346c("onBackPressed");
        super.onBackPressed();
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ls.m1346c("EE onCreate");
        getWindow().setBackgroundDrawableResource(R.drawable.easteregg);
        ls.m1346c("Playing EasterEggDiscover.");
        this.f749a = MediaPlayer.create(this, R.raw.eealert);
        this.f749a.start();
        this.f749a.setOnCompletionListener(new hl(this));
    }

    public void onDestroy() {
        ls.m1346c("easterEgg onDestroy");
        super.onDestroy();
        if (this.f749a != null) {
            this.f749a.stop();
            this.f749a.release();
        }
    }

    public void onPause() {
        ls.m1346c("easterEgg onPause");
        super.onPause();
        if (this.f749a != null) {
            this.f749a.stop();
        }
        finish();
    }

    public void onResume() {
        ls.m1346c("easterEgg onResume");
        super.onResume();
    }
}
