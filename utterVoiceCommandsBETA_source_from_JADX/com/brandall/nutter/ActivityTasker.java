package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;

public class ActivityTasker extends Activity {
    private static boolean f719a = false;

    private void m673a() {
        ls.m1346c("CC tidyVariables");
        new he(this).m1067a(GlobalV.m798K());
        GlobalV.m815a();
    }

    @SuppressLint({"NewApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        ls.m1346c("onActivityResult");
        if (i != 2468 || i2 != -1) {
            ls.m1348e("Tasker data was null");
            if (f719a) {
                m673a();
                lc.m1313a(this, false, "The command creation has been cancelled");
            }
        } else if (intent != null) {
            String dataString = intent.getDataString();
            ls.m1346c("Task: " + dataString);
            if (f719a) {
                ls.m1346c("creator: true");
                new ArrayList().add(dataString);
                if (VERSION.SDK_INT >= 11) {
                    new gx(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{r1});
                } else {
                    new gx(this).execute(new ArrayList[]{r1});
                }
            } else {
                sendBroadcast(new mv(dataString));
                lc.m1313a(this, false, "Executed");
            }
        } else {
            ls.m1348e("Tasker selection was null");
            if (f719a) {
                m673a();
                lc.m1313a(this, false, "The command creation has been cancelled");
            }
        }
        finish();
    }

    public void onBackPressed() {
        ls.m1346c("TaskerActivity onBackPressed");
        if (f719a) {
            m673a();
            lc.m1313a(this, false, "The command creation has been cancelled");
        }
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ls.m1345b("Landscape");
        } else if (configuration.orientation == 1) {
            ls.m1345b("Portrait");
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ls.m1346c("TaskerActivity onCreate");
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getString("sender").matches("creator")) {
            f719a = true;
            lc.m1313a(this, false, "Please select the task");
        }
        startActivityForResult(mv.m1484a(), 2468);
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("TaskerActivity onDestroy");
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("TaskerActivity onPause");
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("TaskerActivity onResume");
    }
}
