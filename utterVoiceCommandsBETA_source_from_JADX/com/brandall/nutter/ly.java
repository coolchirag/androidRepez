package com.brandall.nutter;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import com.faceture.google.play.QueryParamConst;
import java.util.Locale;

public final class ly {
    public static boolean f1700a = false;
    public static Locale f1701b = Locale.ENGLISH;

    public static void m1458a(Context context, TextToSpeech textToSpeech, boolean z, boolean z2) {
        Object obj = null;
        if (hc.f1269b) {
            ls.m1346c("STTSH setEngineLanguage");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (textToSpeech != null) {
            try {
                Locale language = textToSpeech.getLanguage();
                if (language != null) {
                    if (hc.f1269b) {
                        ls.m1346c("Current voice locale: " + language.toString());
                        ls.m1346c("getISO3Country: " + language.getISO3Country());
                        ls.m1346c("getLanguage: " + language.getLanguage());
                    }
                    String defaultEngine = textToSpeech.getDefaultEngine();
                    String string = context.getSharedPreferences("utterPref", 0).getString("init_engine", "");
                    if (string.matches(defaultEngine)) {
                        if (hc.f1269b) {
                            ls.m1346c("Matched defaultEngine - initEngine: " + defaultEngine + " - " + string);
                        }
                    } else if (hc.f1269b) {
                        ls.m1347d("Not matched defaultEngine - initEngine: " + defaultEngine + " - " + string);
                    }
                    string = textToSpeech.getLanguage().toString().toLowerCase(Locale.US);
                    Object obj2 = (string.contains("\\ben\\b") || string.contains("\\beng\\b") || string.contains("en_") || string.contains("eng_") || string.contains("en-") || string.contains("eng-")) ? 1 : null;
                    if (obj2 != null) {
                        if (hc.f1269b) {
                            ls.m1346c("Current voice is English: " + string);
                        }
                    } else if (hc.f1269b) {
                        ls.m1346c("Current voice not English: " + string);
                    }
                    string = context.getSharedPreferences("utterPref", 0).getString("default_voice_engine_language", QueryParamConst.HL_VALUE).replaceFirst("eng", QueryParamConst.HL_VALUE);
                    String string2 = context.getSharedPreferences("utterPref", 0).getString("default_voice_engine_iso", "USA");
                    Locale locale = new Locale(string, string2);
                    Locale locale2 = Locale.getDefault();
                    String toLowerCase = locale2.toString().toLowerCase(Locale.US);
                    obj2 = (toLowerCase.contains("\\ben\\b") || toLowerCase.contains("\\beng\\b") || toLowerCase.contains("en_") || toLowerCase.contains("eng_") || toLowerCase.contains("en-") || toLowerCase.contains("eng-")) ? 1 : null;
                    if (obj2 != null) {
                        if (hc.f1269b) {
                            ls.m1346c("Device locale English: " + toLowerCase);
                        }
                        obj = 1;
                    } else if (hc.f1269b) {
                        ls.m1346c("Device locale not English: " + toLowerCase);
                    }
                    if (hc.f1269b) {
                        ls.m1346c("User default English Voice: " + string + " : " + string2 + " - " + locale.toString());
                    }
                    if (f1700a) {
                        if (hc.f1269b) {
                            ls.m1346c("STTSH customLanguageResponse: true: " + f1701b.toString());
                        }
                        if (m1463a(language, f1701b)) {
                            if (hc.f1269b) {
                                ls.m1346c("STTSH customLanguageResponse - current is matched - doing nothing");
                            }
                        } else if (hc.f1269b) {
                            ls.m1346c("STTSH customLanguageResponse - current not matched - applying custom");
                            textToSpeech.setLanguage(f1701b);
                        }
                    } else if (GlobalV.m902x()) {
                        if (hc.f1269b) {
                            ls.m1346c("STTSH getCustomLauncherVoiceCondition: true");
                        }
                        if (!m1463a(language, new Locale(GlobalV.m897w(), GlobalV.m894v()))) {
                            if (hc.f1269b) {
                                ls.m1346c("STTSH getCustomLauncherVoiceCondition - current not matched - applying custom");
                            }
                            String w = GlobalV.m897w();
                            defaultEngine = GlobalV.m894v();
                            if (defaultEngine.isEmpty() || defaultEngine.replaceAll("\\s", "").matches("")) {
                                if (hc.f1269b) {
                                    ls.m1346c("constructLocale - ISO is empty");
                                }
                                if (!(w.isEmpty() || w.replaceAll("\\s", "").matches(""))) {
                                    if (hc.f1269b) {
                                        ls.m1346c("constructLocale - lang not empty");
                                    }
                                    String[] split;
                                    if (w.contains("-")) {
                                        split = w.split("-");
                                        if (split.length > 1) {
                                            if (split[0].matches("eng")) {
                                                split[0] = QueryParamConst.HL_VALUE;
                                            }
                                            if (hc.f1269b) {
                                                ls.m1344a("EUC-: gls0: " + split[0] + "  : gls1 :" + split[1]);
                                            }
                                            language = new Locale(split[0], split[1]);
                                        } else {
                                            language = new Locale(w, defaultEngine);
                                        }
                                    } else if (w.contains("_")) {
                                        split = w.split("_");
                                        if (split.length > 1) {
                                            if (split[0].matches("eng")) {
                                                split[0] = QueryParamConst.HL_VALUE;
                                            }
                                            if (hc.f1269b) {
                                                ls.m1344a("EUC-: gls0: " + split[0] + "  : gls1 :" + split[1]);
                                            }
                                            language = new Locale(split[0], split[1]);
                                        } else {
                                            language = new Locale(w, defaultEngine);
                                        }
                                    } else if (w.contains("\\s")) {
                                        split = w.split("\\s");
                                        if (split.length > 1) {
                                            if (split[0].matches("eng")) {
                                                split[0] = QueryParamConst.HL_VALUE;
                                            }
                                            if (hc.f1269b) {
                                                ls.m1344a("EUC-: gls0: " + split[0] + "  : gls1 :" + split[1]);
                                            }
                                            language = new Locale(split[0], split[1]);
                                        } else {
                                            language = new Locale(w, defaultEngine);
                                        }
                                    } else {
                                        language = new Locale(w, defaultEngine);
                                    }
                                }
                            } else {
                                language = new Locale(w, defaultEngine);
                            }
                            textToSpeech.setLanguage(language);
                        } else if (hc.f1269b) {
                            ls.m1346c("STTSH getCustomLauncherVoiceCondition - current is matched - doing nothing");
                        }
                        GlobalV.m847h(false);
                        GlobalV.m838f("");
                        GlobalV.m834e("");
                    } else if (z) {
                        if (hc.f1269b) {
                            ls.m1346c("STTSH utteranceCompleted: true");
                        }
                        GlobalV.m884r(false);
                        GlobalV.m885s("");
                        if (!m1463a(language, locale)) {
                            if (hc.f1269b) {
                                ls.m1346c("STTSH utteranceCompleted helper - current not matched - applying user default");
                            }
                            textToSpeech.setLanguage(locale);
                        } else if (hc.f1269b) {
                            ls.m1346c("STTSH utteranceCompleted helper - current is matched - doing nothing");
                        }
                    } else if (z2) {
                        if (hc.f1269b) {
                            ls.m1346c("STTSH translation: true");
                        }
                        ServiceTTS.f856h = "";
                        String aa = GlobalV.aa();
                        if (aa.matches("german")) {
                            if (hc.f1269b) {
                                ls.m1346c("Setting German");
                            }
                            textToSpeech.setLanguage(Locale.GERMAN);
                            ServiceTTS.f856h = "utter! German translation...";
                        } else if (aa.matches("italian")) {
                            if (hc.f1269b) {
                                ls.m1346c("Setting Italian");
                            }
                            textToSpeech.setLanguage(Locale.ITALIAN);
                            ServiceTTS.f856h = "utter! Italian translation...";
                        } else if (aa.matches("french")) {
                            if (hc.f1269b) {
                                ls.m1346c("Setting French");
                            }
                            textToSpeech.setLanguage(Locale.FRENCH);
                            ServiceTTS.f856h = "utter! French translation...";
                        } else if (aa.matches("polish")) {
                            if (hc.f1269b) {
                                ls.m1346c("Setting Polish");
                            }
                            textToSpeech.setLanguage(new Locale("pl"));
                            ServiceTTS.f856h = "utter! Polish translation...";
                        } else if (aa.matches("spanish")) {
                            if (hc.f1269b) {
                                ls.m1346c("Setting Spanish");
                            }
                            textToSpeech.setLanguage(new Locale("es"));
                            ServiceTTS.f856h = "utter! Spanish translation...";
                        } else if (aa.matches("romanian")) {
                            if (hc.f1269b) {
                                ls.m1346c("Setting Romanian");
                            }
                            textToSpeech.setLanguage(new Locale("ro"));
                            ServiceTTS.f856h = "utter! Romanian translation...";
                        }
                    } else if (GlobalV.m890t()) {
                        if (hc.f1269b) {
                            ls.m1346c("getAdHocVoiceCondition: true");
                        }
                        if (obj == null) {
                            if (hc.f1269b) {
                                ls.m1346c("getAdHocVoiceCondition: englishLocale false - setting to device locale");
                            }
                            textToSpeech.setLanguage(locale2);
                        } else {
                            if (hc.f1269b) {
                                ls.m1346c("getAdHocVoiceCondition: englishLocale true - applying user english default");
                            }
                            textToSpeech.setLanguage(locale);
                        }
                    } else {
                        if (hc.f1269b) {
                            ls.m1346c("STTSH: no conditions applied. Checking Match.");
                        }
                        if (!m1463a(language, locale)) {
                            if (hc.f1269b) {
                                ls.m1346c("STTSH no conditions applied - current not matched - applying user default");
                            }
                            textToSpeech.setLanguage(locale);
                        } else if (hc.f1269b) {
                            ls.m1346c("STTSH no conditions applied - current is matched - doing nothing");
                        }
                    }
                } else if (hc.f1269b) {
                    ls.m1348e("STTSH: getLanguage null - leaving well alone.");
                }
            } catch (Exception e) {
                if (hc.f1269b) {
                    ls.m1348e("STTSH: Catch");
                }
                e.printStackTrace();
            }
        } else if (hc.f1269b) {
            ls.m1348e("STTSH: tts object null.");
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (hc.f1269b) {
            ls.m1346c("STTSH elapsed: " + currentTimeMillis2);
        }
    }

    public static boolean m1459a(Context context) {
        if (hc.f1269b) {
            ls.m1347d("ServiceHelper stopSTTS");
        }
        lx.m1437k(context, false);
        try {
            context.stopService(new Intent(context, ServiceTTS.class));
            return true;
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1347d("ServiceHelper: Failed to stop service");
            }
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1460a(Context context, int i, boolean z) {
        if (hc.f1269b) {
            ls.m1345b("voiceResultsNotFix");
        }
        if (context != null) {
            int i2;
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
                try {
                    context.stopService(new Intent(context, VoiceResultsWindow.class));
                } catch (Exception e) {
                    e.printStackTrace();
                    if (hc.f1269b) {
                        ls.m1347d("icsTutNotFix failed to stop service");
                    }
                }
            }
            try {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, VoiceResultsWindow.class), i2, 1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (VERSION.SDK_INT == 15) {
                if (hc.f1269b) {
                    ls.m1344a("voiceResultsNotFix - icsNotificationFix");
                }
                new Thread(new lz(i, context)).start();
            }
        } else if (hc.f1269b) {
            ls.m1347d("STTSH voiceResultsNotFix - context null");
        }
        return true;
    }

    public static boolean m1461a(Context context, Class<?> cls) {
        if (hc.f1269b) {
            ls.m1345b("STTSH checkComponentState");
        }
        switch (context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, cls))) {
            case 0:
                if (!hc.f1269b) {
                    return true;
                }
                ls.m1345b("STTSH COMPONENT_ENABLED_STATE_DEFAULT");
                return true;
            case 1:
                if (!hc.f1269b) {
                    return true;
                }
                ls.m1345b("STTSH COMPONENT_ENABLED_STATE_ENABLED");
                return true;
            case 2:
                if (hc.f1269b) {
                    ls.m1345b("STTSH COMPONENT_ENABLED_STATE_DISABLED");
                    break;
                }
                break;
            case 3:
                if (hc.f1269b) {
                    ls.m1345b("STTSH COMPONENT_ENABLED_STATE_DISABLED_USER");
                    break;
                }
                break;
        }
        return false;
    }

    public static boolean m1462a(String str) {
        if (str == null) {
            return false;
        }
        if (hc.f1269b) {
            ls.m1345b("STTSH checkSpeechLength: " + str.length());
        }
        return str.length() < 1024;
    }

    private static boolean m1463a(Locale locale, Locale locale2) {
        if (hc.f1269b) {
            ls.m1346c("currentVoiceLocale getISO3Country: " + locale.getISO3Country());
            ls.m1346c("currentVoiceLocale getLanguage: " + locale.getLanguage());
            ls.m1346c("userDefaultVoiceLocale getISO3Country: " + locale2.getISO3Country());
            ls.m1346c("userDefaultVoiceLocale getLanguage: " + locale2.getLanguage());
        }
        if (locale.getISO3Country().equalsIgnoreCase(locale2.getISO3Country()) && (locale.getLanguage().equalsIgnoreCase(locale2.getLanguage()) || locale.getISO3Language().equalsIgnoreCase(locale2.getLanguage()) || locale.getISO3Language().equalsIgnoreCase(locale2.getISO3Language()))) {
            return true;
        }
        if (locale.getLanguage().equalsIgnoreCase(QueryParamConst.HL_VALUE) || locale.getLanguage().equalsIgnoreCase("eng")) {
            if (!hc.f1269b) {
                return true;
            }
            ls.m1346c("Current voice engine is english, leaving alone");
            return true;
        } else if (!locale2.getLanguage().contains("-")) {
            return false;
        } else {
            String[] split = locale2.getLanguage().split("-");
            if (split.length <= 1) {
                return false;
            }
            if (split[0].matches("eng")) {
                split[0] = QueryParamConst.HL_VALUE;
            }
            if (hc.f1269b) {
                ls.m1344a("EUC-: gls0: " + split[0] + "  : gls1 :" + split[1]);
            }
            return split[0].equalsIgnoreCase(locale.getLanguage()) && split[1].equalsIgnoreCase(locale.getISO3Country());
        }
    }

    public static boolean m1464b(Context context) {
        if (hc.f1269b) {
            ls.m1346c("ServiceHelper startSTTS");
        }
        lx.m1437k(context, true);
        Intent intent = new Intent(context, ServiceTTS.class);
        intent.addFlags(262144);
        intent.putExtra("INT_DATA", "HOME");
        try {
            context.startService(intent);
            return true;
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1347d("ServiceHelper: Failed to start service");
            }
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1465b(Context context, int i, boolean z) {
        int i2;
        if (hc.f1269b) {
            ls.m1345b("icsNotFixHomeToggle");
        }
        ComponentName componentName = new ComponentName(context, BroadcastReceiverHelper.class);
        if (z) {
            i2 = 1;
        } else {
            try {
                context.stopService(new Intent(context, ServiceShakeEvent.class));
                lx.m1441m(context, false);
            } catch (Exception e) {
                e.printStackTrace();
                if (hc.f1269b) {
                    ls.m1347d("Failed to stop ServiceShakeEvent");
                }
            }
            try {
                context.stopService(new Intent(context, ServiceWaveEvent.class));
                lx.m1443n(context, false);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (hc.f1269b) {
                    ls.m1347d("Failed to stop ServiceWaveEvent");
                }
            }
            try {
                context.stopService(new Intent(context, VoiceResultsWindow.class));
                lx.m1432i(context, false);
                i2 = 2;
            } catch (Exception e22) {
                e22.printStackTrace();
                if (hc.f1269b) {
                    ls.m1347d("Failed to stop VoiceResultsWindow");
                }
                i2 = 2;
            }
        }
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, i2, 1);
            lx.m1437k(context, z);
        } catch (Exception e222) {
            e222.printStackTrace();
        }
        if (z && VERSION.SDK_INT == 15) {
            if (hc.f1269b) {
                ls.m1344a("icsNotificationFix");
            }
            new Thread(new ma(i)).start();
        }
        return true;
    }

    public static boolean m1466c(Context context) {
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (hc.f1269b) {
                ls.m1346c("service: " + runningServiceInfo.service.getClassName());
            }
            if (runningServiceInfo.service.getClassName().matches(ServiceWaveEvent.class.getName())) {
                lx.m1443n(context, true);
                return true;
            }
        }
        lx.m1443n(context, false);
        return false;
    }

    public static boolean m1467d(Context context) {
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (hc.f1269b) {
                ls.m1346c("service: " + runningServiceInfo.service.getClassName());
            }
            if (runningServiceInfo.service.getClassName().matches(ServiceShakeEvent.class.getName())) {
                lx.m1441m(context, true);
                return true;
            }
        }
        lx.m1441m(context, false);
        return false;
    }

    public static boolean m1468e(Context context) {
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (hc.f1269b) {
                ls.m1346c("service: " + runningServiceInfo.service.getClassName());
            }
            if (runningServiceInfo.service.getClassName().matches(ServiceTTS.class.getName())) {
                return true;
            }
        }
        return false;
    }
}
