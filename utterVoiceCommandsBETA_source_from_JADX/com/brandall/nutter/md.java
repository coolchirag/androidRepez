package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Vibrator;
import java.util.ArrayList;
import wei.mark.standout.StandOutWindow;

final class md implements Runnable {
    final /* synthetic */ ServiceTTS f1707a;

    md(ServiceTTS serviceTTS) {
        this.f1707a = serviceTTS;
    }

    @SuppressLint({"NewApi"})
    public final void run() {
        boolean z;
        if (hc.f1269b) {
            ls.m1345b("IDQS Handler");
        }
        ServiceTTS.f868y = false;
        nm.m1501e(ServiceTTS.f849a);
        lt.m1349a(1);
        if (!ServiceTTS.f860l) {
            GlobalV.m899w(false);
            if (ServiceTTS.f867x) {
                if (hc.f1269b) {
                    ls.m1347d("recogError: " + ServiceTTS.f867x);
                }
                if (ServiceTTS.f854f) {
                    z = true;
                } else if (ServiceTTS.f861m) {
                    ServiceTTS.f861m = false;
                    ServiceTTS.f867x = false;
                    ServiceTTS.m925d();
                    z = false;
                } else {
                    ServiceTTS.m943v();
                    z = false;
                }
            } else if (GlobalV.aD()) {
                if (hc.f1269b) {
                    ls.m1346c("GlobalVariables.getRootExCond: true");
                }
                if (VERSION.SDK_INT >= 11) {
                    new kf(this.f1707a.getApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{GlobalV.aB()});
                    z = false;
                } else {
                    new kf(this.f1707a.getApplicationContext()).execute(new String[]{GlobalV.aB()});
                    z = false;
                }
            } else {
                if (ServiceTTS.f854f) {
                    if (hc.f1269b) {
                        ls.m1346c("tutorial: true");
                    }
                    GlobalV.m833e(GlobalV.m865m() + 1);
                    Intent intent;
                    switch (GlobalV.m865m()) {
                        case 4:
                            StandOutWindow.m741a(ServiceTTS.f849a, VoiceResultsWindow.class, 2);
                            break;
                        case 5:
                            ((Vibrator) this.f1707a.getSystemService("vibrator")).vibrate(70);
                            break;
                        case 12:
                            intent = new Intent(ServiceTTS.f849a, ActivityCustomise.class);
                            intent.setFlags(872415232);
                            ServiceTTS.f849a.startActivity(intent);
                            break;
                        case 14:
                            intent = new Intent(ServiceTTS.f849a, ActivitySettings.class);
                            intent.setFlags(872415232);
                            ServiceTTS.f849a.startActivity(intent);
                            break;
                        case 15:
                            intent = new Intent(ServiceTTS.f849a, ActivityLinkApps.class);
                            intent.setFlags(872415232);
                            ServiceTTS.f849a.startActivity(intent);
                            break;
                        case 16:
                            intent = new Intent(ServiceTTS.f849a, ActivityHome.class);
                            intent.setFlags(872415232);
                            ServiceTTS.f849a.startActivity(intent);
                            break;
                        case 17:
                            intent = new Intent(ServiceTTS.f849a, ActivityRecognitionVoices.class);
                            intent.setFlags(872415232);
                            ServiceTTS.f849a.startActivity(intent);
                            break;
                    }
                    if (VERSION.SDK_INT >= 11) {
                        new nl(ServiceTTS.f849a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[0]);
                        z = false;
                    } else {
                        new nl(ServiceTTS.f849a).execute(new ArrayList[0]);
                    }
                }
                z = false;
            }
            ly.m1458a(ServiceTTS.f849a, ServiceTTS.f863r, true, false);
            if (!lx.an(ServiceTTS.f849a)) {
                ServiceTTS.f846E = ServiceTTS.f846E + 1;
                if (ServiceTTS.f846E > 4) {
                    if (lx.ae(ServiceTTS.f849a) != C0142a.m969a(ServiceTTS.f849a)) {
                        if (hc.f1269b) {
                            ls.m1346c("AILevels: SPHAI: " + lx.ae(ServiceTTS.f849a) + " - AI: " + C0142a.m969a(ServiceTTS.f849a));
                        }
                        ServiceTTS.m925d();
                    }
                    ServiceTTS.f846E = 0;
                }
            }
        } else if (ServiceTTS.f855g) {
            if (hc.f1269b) {
                ls.m1346c("stopTutorial: true");
            }
            ServiceTTS.f855g = false;
            nl.m1496a(ServiceTTS.f849a);
            ServiceTTS.m945x();
            z = false;
        } else {
            z = false;
            ServiceTTS.m944w();
        }
        if (GlobalV.m878p()) {
            GlobalV.m835e(false);
            ActivityRecognitionVoices.m634a();
        }
        if (z) {
            GlobalV.m821b(GlobalV.m853j() + 1);
            if (GlobalV.m853j() > 2) {
                GlobalV.m821b(0);
                ServiceTTS.m921b("You either have connection problems, or there is something wrong with your Google Voice Search installation. Please see the Troubleshooting section or the link in the user guide for ways you can fix this. The tutorial has been cancelled.");
                ServiceTTS.m943v();
                return;
            }
            ServiceTTS.m918a("Something went wrong with your connection or Google Voice Search. Could you repeat that please. ");
            ServiceTTS.f867x = false;
        }
    }
}
