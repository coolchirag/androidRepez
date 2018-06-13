package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import org.ispeech.core.HttpRequestParams;

public class InteractionHelper extends Activity {
    public void onBackPressed() {
        ls.m1346c("InteractionHelper onBackPressed");
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

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ls.m1346c("InteractionHelper onCreate");
        Bundle extras = getIntent().getExtras();
        if (extras == null || extras.getString("sender") == null) {
            if (hc.f1269b) {
                ls.m1347d("InteractionHelper extras sender null");
            }
            finish();
        } else if (extras.getString("sender").matches("gvs")) {
            if (jy.m1223C(this, "voiceSearchSettings")) {
                lc.m1313a(this, false, "Please set the recognition language to English");
            } else {
                lc.m1313a(this, false, "From the Android Settings, please set the recognition language of Google Voice Search to English.");
            }
            finish();
        } else if (!extras.getString("sender").matches("server") || extras.getString("content") == null || extras.getString(HttpRequestParams.ACTION) == null) {
            if (hc.f1269b) {
                ls.m1347d("InteractionHelper sender/content/action unknown");
            }
            finish();
        } else {
            if (hc.f1269b) {
                ls.m1346c("InteractionHelper server: " + extras.getString("content"));
            }
            if (extras.getString(HttpRequestParams.ACTION).matches("run")) {
                new ArrayList().add(extras.getString("content"));
                if (VERSION.SDK_INT >= 11) {
                    new hs(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{r1});
                } else {
                    new hs(this).execute(new ArrayList[]{r1});
                }
            } else if (extras.getString(HttpRequestParams.ACTION).matches("speak")) {
                lc.m1313a(this, false, extras.getString("content"));
            } else if (extras.getString(HttpRequestParams.ACTION).matches("toast")) {
                Toast.makeText(this, extras.getString("content"), 1).show();
            } else if (extras.getString(HttpRequestParams.ACTION).matches("web")) {
                jy.m1274y(this, extras.getString("content"));
            } else {
                if (hc.f1269b) {
                    ls.m1347d("InteractionHelper server action unknown");
                }
                finish();
            }
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("InteractionHelper onDestroy");
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("InteractionHelper onPause");
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("InteractionHelper onResume");
    }
}
