package com.brandall.nutter;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public final class lc {
    public static boolean f1666a = false;

    public static String m1312a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("utterPref", 0);
        String string;
        if (sharedPreferences.getBoolean("custom_intro", false)) {
            string = sharedPreferences.getString("user_intro", "null");
            if (string.matches("null")) {
                string = lv.m1359c(context);
                GlobalV.m843g(string);
                return string;
            } else if (string.matches("silence")) {
                GlobalV.m843g("");
                return "";
            } else {
                GlobalV.m843g(string);
                return string;
            }
        }
        string = lv.m1359c(context);
        GlobalV.m843g(string);
        return string;
    }

    public static void m1313a(Context context, boolean z, String str) {
        boolean z2;
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (runningServiceInfo.service.getClassName().matches(ServiceTTS.class.getName())) {
                if (hc.f1269b) {
                    ls.m1346c("service running: " + runningServiceInfo.service.getClassName());
                }
                if (ServiceTTS.m924c()) {
                    if (hc.f1269b) {
                        ls.m1346c("isInstanceCreated: true");
                    }
                    z2 = true;
                } else {
                    if (hc.f1269b) {
                        ls.m1347d("isInstanceCreated: false");
                    }
                    z2 = false;
                }
                if (z2) {
                    if (hc.f1269b) {
                        ls.m1346c("instantiated: false");
                    }
                    if (f1666a) {
                        f1666a = false;
                        m1314b(context, false, "Sorry, something went wrong with the tutorial");
                        nl.m1496a(context);
                        try {
                            ServiceTTS.f854f = false;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    } else if (z) {
                        if (hc.f1269b) {
                            ls.m1346c("passSpeech to instantiate: quick");
                        }
                        m1314b(context, false, str);
                    } else {
                        if (hc.f1269b) {
                            ls.m1346c("passSpeech to instantiate: long");
                        }
                        m1314b(context, true, str);
                    }
                }
                if (hc.f1269b) {
                    ls.m1346c("instantiated: true");
                }
                if (f1666a) {
                    f1666a = false;
                    ServiceTTS.m913a(context, 2500);
                    return;
                } else if (z) {
                    if (hc.f1269b) {
                        ls.m1346c("passSpeech: quick");
                    }
                    ServiceTTS.m921b(str);
                    return;
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("passSpeech: long");
                    }
                    ServiceTTS.m918a(str);
                    return;
                }
            } else if (hc.f1269b) {
                ls.m1345b("service running: " + runningServiceInfo.service.getClassName());
            }
        }
        z2 = false;
        if (z2) {
            if (hc.f1269b) {
                ls.m1346c("instantiated: true");
            }
            if (f1666a) {
                f1666a = false;
                ServiceTTS.m913a(context, 2500);
                return;
            } else if (z) {
                if (hc.f1269b) {
                    ls.m1346c("passSpeech: quick");
                }
                ServiceTTS.m921b(str);
                return;
            } else {
                if (hc.f1269b) {
                    ls.m1346c("passSpeech: long");
                }
                ServiceTTS.m918a(str);
                return;
            }
        }
        if (hc.f1269b) {
            ls.m1346c("instantiated: false");
        }
        if (f1666a) {
            f1666a = false;
            m1314b(context, false, "Sorry, something went wrong with the tutorial");
            nl.m1496a(context);
            ServiceTTS.f854f = false;
        } else if (z) {
            if (hc.f1269b) {
                ls.m1346c("passSpeech to instantiate: quick");
            }
            m1314b(context, false, str);
        } else {
            if (hc.f1269b) {
                ls.m1346c("passSpeech to instantiate: long");
            }
            m1314b(context, true, str);
        }
    }

    private static void m1314b(Context context, boolean z, String str) {
        Intent intent = new Intent(context, ServiceTTS.class);
        intent.putExtra("INT_DATA", "INIT");
        intent.putExtra("SPEECH_DATA", str);
        intent.putExtra("START_RECOG", z);
        context.startService(intent);
    }
}
