package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import wei.mark.standout.StandOutWindow;

public class LauncherShortcutActivity extends Activity {
    private boolean f818a = false;
    private boolean f819b = false;
    private boolean f820c = false;
    private boolean f821d = false;
    private boolean f822e = false;
    private String f823f = "";
    private boolean f824g = false;
    private boolean f825h = false;
    private ArrayList<String> f826i;

    public void onBackPressed() {
        super.onBackPressed();
        if (hc.f1269b) {
            ls.m1346c("onBackPressed");
        }
        try {
            StandOutWindow.m740a(getApplicationContext(), VoiceResultsWindow.class);
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("StandOutWindow.closeAll: " + e.toString());
            }
        }
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (hc.f1269b) {
                ls.m1345b("Landscape");
            }
        } else if (configuration.orientation == 1 && hc.f1269b) {
            ls.m1345b("Portrait");
        }
    }

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (hc.f1269b) {
            ls.m1346c("LSA onCreate");
        }
        GlobalV.m889t(false);
        if (!ly.m1461a((Context) this, BroadcastReceiverHelper.class)) {
            if (hc.f1269b) {
                ls.m1346c("LSA enabling BRH component");
            }
            ly.m1465b(this, 12000, true);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f820c = extras.getBoolean("tasker", false);
            this.f821d = extras.getBoolean("tutorial", false);
            this.f822e = extras.getBoolean("offline", false);
            if (this.f821d) {
                if (hc.f1269b) {
                    ls.m1346c("LauncherShortcutActivity tutorial true");
                }
            } else if (this.f820c) {
                this.f823f = extras.getString("voice_content");
                if (!(this.f823f == null || this.f823f.isEmpty())) {
                    if (hc.f1269b) {
                        ls.m1344a("LSA vc: " + this.f823f);
                    }
                    this.f818a = true;
                }
                this.f819b = extras.getBoolean("Start_Listening", false);
                this.f824g = extras.getBoolean("custom_recog", false);
                this.f825h = extras.getBoolean("custom_voice", false);
                if (this.f819b && this.f824g) {
                    r1 = extras.getString("recognition_locale");
                    if (r1 != null) {
                        if (hc.f1269b) {
                            ls.m1344a("LSA rl: " + r1);
                        }
                        GlobalV.m852i(true);
                        GlobalV.m831d(r1);
                    }
                }
                if (this.f825h) {
                    r0 = extras.getString("voice_engine_locale");
                    if (r0 != null) {
                        if (hc.f1269b) {
                            ls.m1344a("LSA vel: " + r0);
                        }
                        GlobalV.m847h(true);
                        GlobalV.m838f(r0);
                        GlobalV.m834e("");
                    }
                }
            } else if (this.f822e) {
                this.f823f = extras.getString("voice_content");
            } else {
                r1 = extras.getString("recognition_locale");
                if (r1 != null) {
                    if (hc.f1269b) {
                        ls.m1344a("LSA rl: " + r1);
                    }
                    GlobalV.m852i(true);
                    GlobalV.m831d(r1);
                }
                r1 = extras.getString("voice_engine_language");
                r0 = extras.getString("voice_engine_iso");
                if (!(r1 == null || r0 == null)) {
                    if (hc.f1269b) {
                        ls.m1344a("LSA vel: " + r1 + " : veISO: " + r0);
                    }
                    GlobalV.m847h(true);
                    GlobalV.m838f(r1);
                    GlobalV.m834e(r0);
                }
            }
        }
        if (ServiceTTS.f861m) {
            ServiceTTS.m920b();
        } else if (GlobalV.ap() || this.f821d) {
            if (hc.f1269b) {
                ls.m1346c("GlobalVariables.getReadCond/tutorial : true");
            }
            ServiceTTS.m911a();
            if (this.f821d) {
                if (ServiceTTS.f857i || ServiceTTS.f860l) {
                    ServiceTTS.f855g = true;
                } else {
                    nl.m1496a((Context) this);
                }
            }
        } else if (GlobalV.m813Z()) {
            if (hc.f1269b) {
                ls.m1346c("GlobalVariables.getLanguageCond: true");
            }
            ServiceTTS.m911a();
        } else {
            if (this.f818a) {
                ls.m1346c("LSA voiceContent: true");
                if (this.f819b) {
                    if (hc.f1269b) {
                        ls.m1346c("LSA startRecog: true");
                    }
                    lc.m1313a(this, true, this.f823f);
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("LSA startRecog: false");
                    }
                    lc.m1313a(this, false, this.f823f);
                }
            } else {
                if (hc.f1269b) {
                    ls.m1346c("LSA voiceContent: false");
                }
                if (this.f820c) {
                    if (hc.f1269b) {
                        ls.m1346c("LSA tasker: true");
                    }
                    lc.m1313a(this, false, "Sorry, something went wrong passing the data from Tasker.");
                } else if (this.f822e) {
                    if (hc.f1269b) {
                        ls.m1346c("LSA offline: true");
                    }
                    if (this.f823f == null || this.f823f.isEmpty()) {
                        lc.m1313a(this, false, "Offline command failed");
                    } else {
                        if (hc.f1269b) {
                            ls.m1344a("LSA vc: " + this.f823f);
                        }
                        this.f826i = new ArrayList();
                        this.f826i.add(this.f823f);
                        if (VERSION.SDK_INT >= 11) {
                            new hs(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{this.f826i});
                        } else {
                            new hs(this).execute(new ArrayList[]{this.f826i});
                        }
                    }
                    this.f822e = false;
                    this.f826i = null;
                    this.f823f = "";
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("LSA tasker: false");
                    }
                    lc.m1313a(this, true, lc.m1312a(this));
                }
            }
            try {
                StandOutWindow.m740a(getApplicationContext(), VoiceResultsWindow.class);
            } catch (Exception e) {
                if (hc.f1269b) {
                    ls.m1348e("StandOutWindow.closeAll: " + e.toString());
                }
            }
        }
        this.f820c = false;
        this.f821d = false;
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("LSA onDestroy");
        }
    }

    public void onPause() {
        super.onPause();
        if (hc.f1269b) {
            ls.m1346c("LSA onPause");
        }
    }

    public void onResume() {
        super.onResume();
        if (hc.f1269b) {
            ls.m1346c("LSA onResume");
        }
    }
}
