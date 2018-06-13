package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.provider.CallLog.Calls;
import android.provider.ContactsContract.Contacts;
import android.provider.Settings.System;
import android.text.Html;
import android.widget.Toast;
import com.faceture.google.play.PropertyConsts;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public final class jy {
    public static boolean m1221A(Context context, String str) {
        ls.m1346c("ExecuteIntent skypeUser");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("skype:" + str));
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent skpeIntent ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1222B(Context context, String str) {
        ls.m1346c("ExecuteIntent earthFlyTo");
        Intent intent = new Intent();
        intent.setClassName("com.google.earth", "com.google.earth.EarthActivity");
        intent.setFlags(268435456);
        intent.setAction("android.intent.action.SEARCH");
        intent.putExtra(PropertyConsts.QUERY, str);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent earthFlyTo ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static boolean m1223C(Context context, String str) {
        boolean z;
        boolean z2 = true;
        ls.m1346c("ExecuteIntent intentResult");
        if (str.matches("ttsSettings")) {
            ls.m1346c("ttsSettings");
            try {
                Intent intent = new Intent();
                intent.setAction("com.android.settings.TTS_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
        } else {
            z = false;
        }
        if (str.matches("voiceSearchSettings")) {
            ls.m1346c("voiceSearchSettings");
            try {
                intent = new Intent("android.intent.action.MAIN");
                intent.setComponent(new ComponentName("com.google.android.voicesearch", "com.google.android.voicesearch.VoiceSearchPreferences"));
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    intent = new Intent("android.intent.action.MAIN");
                    intent.setComponent(new ComponentName("com.google.android.googlequicksearchbox", "com.google.android.voicesearch.VoiceSearchPreferences"));
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    z = true;
                } catch (Exception e22) {
                    e22.printStackTrace();
                    z = false;
                }
            }
        }
        if (str.matches("datSettings")) {
            ls.m1346c("datSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.DATE_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e222) {
                e222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("dataSettings")) {
            ls.m1346c("dataSettings");
            try {
                intent = new Intent("android.settings.DATA_ROAMING_SETTINGS");
                intent.setClassName("com.android.phone", "com.android.phone.Settings");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e2222) {
                e2222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("wifiSettings")) {
            ls.m1346c("wifiSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.WIFI_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e22222) {
                e22222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("bluetoothSettings")) {
            ls.m1346c("bluetoothSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.BLUETOOTH_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e222222) {
                e222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("accessibilitySettings")) {
            ls.m1346c("accessibilitySettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.ACCESSIBILITY_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e2222222) {
                e2222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("apnSettings")) {
            ls.m1346c("apnSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.APN_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e22222222) {
                e22222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("applicationSettings")) {
            ls.m1346c("applicationSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.APPLICATION_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e222222222) {
                e222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("deviceSettings")) {
            ls.m1346c("deviceSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.DEVICE_INFO_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e2222222222) {
                e2222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("storageSettings")) {
            ls.m1346c("storageSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.INTERNAL_STORAGE_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e22222222222) {
                e22222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("localeSettings")) {
            ls.m1346c("localeSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.LOCALE_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e222222222222) {
                e222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("inputSettings")) {
            ls.m1346c("inputSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.INPUT_METHOD_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e2222222222222) {
                e2222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("displaySettings")) {
            ls.m1346c("displaySettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.DISPLAY_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e22222222222222) {
                e22222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("dictionarySettings")) {
            ls.m1346c("dictionarySettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.USER_DICTIONARY_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e222222222222222) {
                e222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("syncSettings")) {
            ls.m1346c("syncSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.SYNC_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e2222222222222222) {
                e2222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("soundSettings")) {
            ls.m1346c("soundSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.SOUND_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e22222222222222222) {
                e22222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("settingsSettings")) {
            ls.m1346c("settingsSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e222222222222222222) {
                e222222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("securitySettings")) {
            ls.m1346c("securitySettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.SECURITY_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e2222222222222222222) {
                e2222222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("searchSettings")) {
            ls.m1346c("searchSettings");
            try {
                intent = new Intent();
                intent.setAction("android.search.action.SEARCH_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e22222222222222222222) {
                e22222222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("quickLaunchSettings")) {
            ls.m1346c("quickLaunchSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.QUICK_LAUNCH_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e222222222222222222222) {
                e222222222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("privacySettings")) {
            ls.m1346c("privacySettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.PRIVACY_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e2222222222222222222222) {
                e2222222222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("locationSettings")) {
            ls.m1346c("locationSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e22222222222222222222222) {
                e22222222222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("nfcSettings")) {
            ls.m1346c("nfcSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.NFCSHARING_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e222222222222222222222222) {
                e222222222222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("networkOperatorSettings")) {
            ls.m1346c("networkOperatorSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.NETWORK_OPERATOR_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
                z = true;
            } catch (Exception e2222222222222222222222222) {
                e2222222222222222222222222.printStackTrace();
                z = false;
            }
        }
        if (str.matches("memoryCardSettings")) {
            ls.m1346c("memoryCardSettings");
            try {
                intent = new Intent();
                intent.setAction("android.settings.MEMORY_CARD_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e22222222222222222222222222) {
                e22222222222222222222222222.printStackTrace();
                z2 = false;
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            Toast.makeText(context, "Can't access Settings?", 0).show();
        }
        return z2;
    }

    public static boolean m1224a(Context context) {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + hr.m1141a(context)));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1225a(Context context, double d, double d2) {
        ls.m1346c("ExecuteIntent navigateTo");
        Intent intent = new Intent("android.intent.action.VIEW");
        if (m1262m(context, "com.waze")) {
            intent.setData(Uri.parse("waze://?ll=" + String.valueOf(d) + "," + String.valueOf(d2)));
        } else {
            intent.setData(Uri.parse("google.navigation:ll=" + String.valueOf(d) + "," + String.valueOf(d2) + "&mode=w"));
        }
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent navigateTo ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static boolean m1226a(Context context, int i, int i2, int i3, int i4, int i5, String str, boolean z) {
        Intent intent;
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2, i3, i4, i5);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(i, i2, i3, i4 + 1, i5);
        if (VERSION.SDK_INT >= 14) {
            intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra("beginTime", instance.getTimeInMillis());
            intent.putExtra("endTime", instance2.getTimeInMillis());
            intent.putExtra("title", str);
            intent.putExtra("description", "#utter!");
            intent.setFlags(268435456);
            if (z) {
                intent.putExtra("allDay", true);
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                ls.m1347d("ExecuteIntent Exception e");
                intent = new Intent("android.intent.action.EDIT");
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", instance.getTimeInMillis());
                intent.putExtra("endTime", instance2.getTimeInMillis());
                intent.putExtra("title", str);
                intent.putExtra("description", "#utter!");
                intent.setFlags(268435456);
                if (z) {
                    intent.putExtra("allDay", true);
                }
                try {
                    context.startActivity(intent);
                    return true;
                } catch (Exception e2) {
                    ls.m1347d("ExecuteIntent Exception e1");
                    e2.printStackTrace();
                    return false;
                }
            }
        }
        intent = new Intent("android.intent.action.EDIT");
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", instance.getTimeInMillis());
        intent.putExtra("endTime", instance2.getTimeInMillis());
        intent.putExtra("title", str);
        intent.putExtra("description", "#utter!");
        intent.setFlags(268435456);
        if (z) {
            intent.putExtra("allDay", true);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e22) {
            ls.m1346c("ExecuteIntent calendarEntry");
            e22.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static boolean m1227a(Context context, int i, int i2, String str) {
        ls.m1346c("ExecuteIntent setAlarm");
        Intent intent = new Intent("android.intent.action.SET_ALARM");
        intent.putExtra("android.intent.extra.alarm.HOUR", i);
        intent.putExtra("android.intent.extra.alarm.MINUTES", i2);
        intent.putExtra("android.intent.extra.alarm.MESSAGE", new StringBuilder(String.valueOf(str)).append(" #utter!").toString());
        if (VERSION.SDK_INT >= 17) {
            intent.putExtra("android.intent.extra.alarm.SKIP_UI", true);
        }
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent setAlarm");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1228a(Context context, Class<?> cls, boolean z) {
        Intent intent = new Intent(context, cls);
        if (z) {
            intent.setFlags(872415232);
        } else {
            intent.setFlags(603979776);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1229a(Context context, String str) {
        ls.m1346c("ExecuteIntent searchPlayStore");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setPackage("com.android.vending");
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent searchPlayStore ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1230a(Context context, String str, String str2) {
        ls.m1346c("ExecuteIntent launchActivity");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent launchActivity");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1231a(Context context, String str, String str2, String str3) {
        boolean z = true;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.setFlags(268435456);
        String L = lx.m1373L(context);
        if (L.matches("") || L.matches("")) {
            intent.putExtra("android.intent.extra.TEXT", str3);
        } else {
            L = new StringBuilder(String.valueOf(str3)).append("<br><br>").append(L.replaceAll("\\sutter\\!", " <a href='https://play.google.com/store/apps/details?id=com.brandall.nutter&hl=en'>utter!</a>")).toString();
            ls.m1346c("eSig: " + L);
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml(L));
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent sendEmail ActivityNotFoundException: ");
            e.printStackTrace();
            z = false;
        }
        GlobalV.m895v("");
        GlobalV.m892u("");
        GlobalV.m888t("");
        return z;
    }

    public static boolean m1232a(Context context, String str, String str2, boolean z) {
        Intent intent;
        ls.m1346c("ExecuteIntent sendSMS");
        ls.m1346c("sendSMS proofRead: true");
        if (z) {
            intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        } else {
            intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("address", str);
            intent.setType("vnd.android-dir/mms-sms");
        }
        String K = lx.m1372K(context);
        if (K.matches("") || K.matches(" ")) {
            intent.putExtra("sms_body", str2);
        } else {
            intent.putExtra("sms_body", new StringBuilder(String.valueOf(str2)).append("\n").append(K).toString());
        }
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent sendSMS ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1233a(Context context, String str, boolean z) {
        ls.m1346c("ExecuteIntent playMedia");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        if (z) {
            intent.setDataAndType(Uri.parse(str), "audio/mp3");
        } else {
            intent.setDataAndType(Uri.parse("file://" + str), "audio/mp3");
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("playMedia Exception");
            e.printStackTrace();
            intent = new Intent("android.intent.action.MUSIC_PLAYER");
            intent.setFlags(268435456);
            if (z) {
                intent.setDataAndType(Uri.parse(str), "audio/mp3");
            } else {
                intent.setDataAndType(Uri.parse("file://" + str), "audio/mp3");
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e2) {
                ls.m1348e("playMedia Exception2");
                e2.printStackTrace();
                return false;
            }
        }
    }

    public static boolean m1234a(Context context, boolean z) {
        if (hc.f1269b) {
            ls.m1346c("ExecuteIntent toggleAirplaneMode");
        }
        if (z) {
            try {
                System.putInt(context.getContentResolver(), "airplane_mode_on", 1);
            } catch (Exception e) {
                e.printStackTrace();
                if (!hc.f1269b) {
                    return false;
                }
                ls.m1348e("ExecuteIntent toggleAirplaneMode: failed");
                return false;
            }
        }
        System.putInt(context.getContentResolver(), "airplane_mode_on", 0);
        Intent intent = new Intent("android.intent.action.AIRPLANE_MODE");
        intent.putExtra("state", z);
        context.sendBroadcast(intent);
        if (hc.f1269b) {
            ls.m1346c("ExecuteIntent toggleAirplaneMode: success");
        }
        return true;
    }

    public static boolean m1235a(Context context, boolean z, String str, String str2, String str3, String str4) {
        Parcelable intent = new Intent(context, LauncherShortcutActivity.class);
        Intent intent2 = new Intent();
        if (z) {
            intent.putExtra("voice_engine_iso", str4);
            intent.putExtra("voice_engine_language", str3);
            intent.putExtra("recognition_locale", str);
            intent2.putExtra("android.intent.extra.shortcut.NAME", str2);
        } else {
            intent2.putExtra("android.intent.extra.shortcut.NAME", "utter!");
        }
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, R.drawable.ic_launcher_nutter));
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.addFlags(8388608);
        try {
            context.sendBroadcast(intent2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1236b(Context context) {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + Calls.getLastOutgoingCall(context)));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1237b(Context context, double d, double d2) {
        ls.m1346c("ExecuteIntent streetView");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("google.streetview:cbll=" + String.valueOf(d) + "," + String.valueOf(d2) + "&cbp=1,99.56,,1,1.0&mz=21"));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent streetView ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1238b(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("wolframalpha:///?i=" + str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1239b(Context context, String str, String str2) {
        ls.m1346c("ExecuteIntent twitterURL");
        String str3 = "android.intent.action.VIEW";
        Intent intent = new Intent(str3, Uri.parse("https://twitter.com/intent/tweet?text=" + str.replaceAll("hash tags ", "\\%23").replaceAll("hash tag ", "\\%23").replaceAll("hashtags ", "\\%23").replaceAll("hashtag ", "\\%23") + " " + str2));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent twitterURL ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1240b(Context context, String str, String str2, boolean z) {
        ls.m1346c("ExecuteIntent newCatchNote");
        Intent intent = new Intent();
        intent.setAction("com.catchnotes.intent.action.ADD");
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.putExtra("android.intent.extra.TITLE", str);
        intent.putExtra("com.catchnotes.intent.extra.SOURCE", "via utter!");
        intent.setFlags(268435456);
        if (!z) {
            intent.putExtra("com.catchnotes.intent.extra.AUTOSAVE", true);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent newCatchNote ActivityNotFoundException: ");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1241b(Context context, boolean z) {
        ls.m1346c("ExecuteIntent shakeToggle");
        Intent intent = new Intent(context, ServiceShakeEvent.class);
        if (z) {
            ls.m1346c("ExecuteIntent shakeToggle ON");
            try {
                context.startService(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                ls.m1348e("ExecuteIntent shakeToggle ActivityNotFoundException");
                e.printStackTrace();
                return false;
            }
        }
        ls.m1346c("ExecuteIntent shakeToggle OFF");
        try {
            context.stopService(intent);
            return true;
        } catch (ActivityNotFoundException e2) {
            ls.m1348e("ExecuteIntent shakeToggle ActivityNotFoundException");
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean m1242c(Context context) {
        Intent intent = new Intent(context, ActivityHome.class);
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1243c(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("package:" + str));
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1244c(Context context, String str, String str2, boolean z) {
        ls.m1346c("ExecuteIntent newEvernote");
        Serializable arrayList = new ArrayList();
        arrayList.add("Created via utter!");
        Intent intent = new Intent();
        intent.setAction("com.evernote.action.CREATE_NEW_NOTE");
        intent.putExtra("android.intent.extra.TITLE", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.putExtra("SOURCE_APP", "utter!");
        intent.putExtra("TAG_NAME_LIST", arrayList);
        intent.setFlags(268435456);
        if (!z) {
            intent.putExtra("QUICK_SEND", true);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent newEvernote ActivityNotFoundException: ");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1245c(Context context, boolean z) {
        ls.m1346c("ExecuteIntent waveToggle");
        Intent intent = new Intent(context, ServiceWaveEvent.class);
        if (z) {
            ls.m1346c("ExecuteIntent waveToggle ON");
            try {
                context.startService(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                ls.m1348e("ExecuteIntent waveToggle ActivityNotFoundException");
                e.printStackTrace();
                return false;
            }
        }
        ls.m1346c("ExecuteIntent waveToggle OFF");
        try {
            context.stopService(intent);
            return true;
        } catch (ActivityNotFoundException e2) {
            ls.m1348e("ExecuteIntent shakeToggle ActivityNotFoundException");
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean m1246d(Context context) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "utter!");
        intent.putExtra("android.intent.extra.TEXT", "#utter! beta release http://goo.gl/DrLHh & video http://goo.gl/xHqRR");
        try {
            context.startActivity(Intent.createChooser(intent, "Share via"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1247d(Context context, String str) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1248e(Context context) {
        ls.m1346c("ExecuteIntent screenShotScreencast");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.ms.screencast", "com.ms.screencast.TakeScreenshotActivity"));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent screenShotScreencast");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1249e(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + str)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + str));
            intent.setFlags(268435456);
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e2) {
                ls.m1348e("ExecuteIntent webSearch ActivityNotFoundException");
                e2.printStackTrace();
                return false;
            }
        }
    }

    public static boolean m1250f(Context context) {
        ls.m1346c("ExecuteIntent screenShotScreencastFree");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.ms.screencastfree", "com.ms.screencastfree.TakeScreenshotActivity"));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent screenShotScreencastFree");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1251f(Context context, String str) {
        ls.m1346c("ExecuteIntent launchAppFromPackageName");
        try {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent launchAppFromPackageName");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1252g(Context context) {
        ls.m1346c("ExecuteIntent fourSquareCheckInPage");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setComponent(new ComponentName("com.joelapenna.foursquared", "com.joelapenna.foursquared.CheckinActivityAlt"));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent fourSquareCheckIn ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1253g(Context context, String str) {
        ls.m1346c("ExecuteIntent runTaskerTask");
        try {
            context.sendBroadcast(new mv(str));
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent runTaskerTask");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1254h(Context context) {
        ls.m1346c("ExecuteIntent linkAppPage");
        Intent intent = new Intent(context, ActivityLinkApps.class);
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1346c("ExecuteIntent linkAppPage");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1255h(Context context, String str) {
        ls.m1346c("ExecuteIntent fourSquareCheckIn");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://m.foursquare.com/venue/" + str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent fourSquareCheckIn ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1256i(Context context) {
        ls.m1346c("ExecuteIntent newCatchNoteVoice");
        Intent intent = new Intent();
        intent.setAction("com.catchnotes.intent.action.ADD_VOICE");
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent newCatchNoteVoice ActivityNotFoundException: ");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1257i(Context context, String str) {
        ls.m1346c("ExecuteIntent ebaySearch");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("ebay:///find?q=" + str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent ebaySearch ActivityNotFoundException");
            e.printStackTrace();
            jn.f1556d = true;
            intent = new Intent("android.intent.action.VIEW", Uri.parse(jn.m1212a() + str));
            intent.setFlags(268435456);
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e2) {
                ls.m1348e("ExecuteIntent ebaySearch ActivityNotFoundException");
                e2.printStackTrace();
                return false;
            }
        }
    }

    public static boolean m1258j(Context context) {
        ls.m1346c("ExecuteIntent easterEgg");
        Intent intent = new Intent(context, EasterEgg.class);
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent easterEgg ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1259j(Context context, String str) {
        ls.m1346c("ExecuteIntent editPicture");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1346c("ExecuteIntent editPicture");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1260k(Context context, String str) {
        ls.m1346c("ExecuteIntent filmSearch");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("imdb:///find?q=" + str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent filmSearch ActivityNotFoundException");
            e.printStackTrace();
            intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.imdb.com/find?s=tt&q=" + str));
            intent.setFlags(268435456);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                ls.m1348e("ExecuteIntent filmWebSearch ActivityNotFoundException");
                e2.printStackTrace();
            }
            return false;
        }
    }

    public static boolean m1261l(Context context, String str) {
        ls.m1346c("ExecuteIntent navigateTo");
        Object obj = "google.navigation:q=";
        if (m1262m(context, "com.waze")) {
            obj = "waze://?q=";
            str = str.trim().replaceAll("\\s", "\\+");
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(new StringBuilder(String.valueOf(obj)).append(str).toString()));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent navigateTo ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1262m(Context context, String str) {
        ls.m1346c("ExecuteIntent packageInstalled");
        try {
            ls.m1344a("packageInstalled: " + context.getPackageManager().getApplicationInfo(str, 0).packageName.toString());
            return true;
        } catch (NameNotFoundException e) {
            ls.m1346c("ExecuteIntent NameNotFoundException");
            return false;
        }
    }

    public static boolean m1263n(Context context, String str) {
        ls.m1346c("ExecuteIntent playStoreSearch");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=" + str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent playStoreSearch ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1264o(Context context, String str) {
        ls.m1346c("ExecuteIntent playStoreLink");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent playStoreLink ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1265p(Context context, String str) {
        ls.m1346c("ExecuteIntent solidExplorer");
        Intent intent = new Intent();
        intent.setClassName("pl.solidexplorer", "pl.solidexplorer.SolidExplorer");
        intent.setAction("pl.solidexplorer.action.BROWSE_TO");
        intent.addFlags(268435456);
        intent.setData(Uri.parse("file://" + str));
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent solidExplorer ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1266q(Context context, String str) {
        ls.m1346c("ExecuteIntent esFileExplorer");
        Intent intent = new Intent();
        intent.setClassName("com.estrongs.android.pop", "com.estrongs.android.pop.view.FileExplorerActivity");
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(Uri.parse("file://" + str));
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent esFileExplorer ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1267r(Context context, String str) {
        ls.m1346c("ExecuteIntent fileExpert");
        Intent intent = new Intent();
        intent.setClassName("xcxin.filexpert", "xcxin.filexpert.FileLister");
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(Uri.parse("file://" + str));
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent rootExplorer ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1268s(Context context, String str) {
        ls.m1346c("ExecuteIntent rootExplorer");
        Intent intent = new Intent();
        intent.setClassName("com.speedsoftware.rootexplorer", "com.speedsoftware.rootexplorer.RootExplorer");
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(Uri.parse("file://" + str));
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent rootExplorer ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1269t(Context context, String str) {
        ls.m1346c("ExecuteIntent rootExplorerFree");
        Intent intent = new Intent();
        intent.setClassName("com.speedsoftware.explorer", "com.speedsoftware.explorer.Explorer");
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(Uri.parse("file://" + str));
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent rootExplorerFree ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1270u(Context context, String str) {
        ls.m1346c("ExecuteIntent totalCommander");
        Intent intent = new Intent();
        intent.setClassName("com.ghisler.android.TotalCommander", "com.ghisler.android.TotalCommander.TotalCommander");
        intent.setAction("android.intent.action.MAIN");
        intent.addFlags(268435456);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setData(Uri.parse("file://" + str));
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ls.m1348e("ExecuteIntent totalCommander ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1271v(Context context, String str) {
        ls.m1346c("ExecuteIntent newEvernoteVoice");
        Serializable arrayList = new ArrayList();
        arrayList.add("Created via utter!");
        Intent intent = new Intent();
        intent.setAction("com.evernote.action.NEW_VOICE_NOTE");
        intent.putExtra("android.intent.extra.TITLE", str);
        intent.putExtra("android.intent.extra.TEXT", "Created via utter!");
        intent.putExtra("TAG_NAME_LIST", arrayList);
        intent.putExtra("SOURCE_APP", "utter!");
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent newEvernoteVoice ActivityNotFoundException: ");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1272w(Context context, String str) {
        ls.m1346c("ExecuteIntent callContact");
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent callContact ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1273x(Context context, String str) {
        ls.m1346c("ExecuteIntent displayContact");
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri withAppendedPath = Uri.withAppendedPath(Contacts.CONTENT_URI, String.valueOf(str));
        intent.setFlags(268435456);
        intent.setData(withAppendedPath);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent displayContact ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1274y(Context context, String str) {
        ls.m1346c("ExecuteIntent webSearch");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent webSearch ActivityNotFoundException");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m1275z(Context context, String str) {
        ls.m1346c("ExecuteIntent videoSearch");
        Intent intent = new Intent("android.intent.action.MEDIA_SEARCH");
        intent.setPackage("com.google.android.youtube");
        intent.putExtra(PropertyConsts.QUERY, str);
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ls.m1348e("ExecuteIntent videoSearch ActivityNotFoundException");
            e.printStackTrace();
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/results?search_query=" + str.replaceAll("\\s", "\\+")));
            intent2.setFlags(268435456);
            try {
                context.startActivity(intent2);
                return true;
            } catch (ActivityNotFoundException e2) {
                ls.m1348e("ExecuteIntent videoSearchWeb ActivityNotFoundException");
                e2.printStackTrace();
                return false;
            }
        }
    }
}
