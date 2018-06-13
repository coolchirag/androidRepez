package com.brandall.nutter;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class Swap extends Activity {
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ls.m1345b("Landscape");
        } else if (configuration.orientation == 1) {
            ls.m1345b("Portrait");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.swap_layout);
    }

    public void onPause() {
        super.onPause();
        finish();
    }

    public void onResume() {
        super.onResume();
        finish();
    }
}
