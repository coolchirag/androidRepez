package com.brandall.nutter;

import android.app.backup.BackupManager;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.faceture.google.play.QueryParamConst;

public final class lx {
    public static String m1362A(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("widget_lang", QueryParamConst.HL_VALUE);
    }

    public static String m1363B(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("widget_recog", "en_US");
    }

    public static String m1364C(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("default_explorer_packagename", "");
    }

    public static boolean m1365D(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("default_explorer_condition", false);
    }

    public static String m1366E(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("default_notes_packagename", "");
    }

    public static boolean m1367F(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("default_notes_condition", false);
    }

    public static boolean m1368G(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("camera_dir_condition", false);
    }

    public static int m1369H(Context context) {
        return context.getSharedPreferences("utterPref", 0).getInt("pause_timeout", 0);
    }

    public static boolean m1370I(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("pause_timeout_condition", false);
    }

    public static boolean m1371J(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("default_voice_engine_condition", false);
    }

    public static String m1372K(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("sms_signature_content", "");
    }

    public static String m1373L(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("email_signature_content", "Sent by voice from <a href='https://play.google.com/store/apps/details?id=com.brandall.nutter&hl=en'>utter!</a>");
    }

    public static boolean m1374M(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("user_words", false);
    }

    public static boolean m1375N(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("nickname", false);
    }

    public static boolean m1376O(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("remote_disclaimer", false);
    }

    public static String m1377P(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("tw_token_key", "");
    }

    public static String m1378Q(Context context) {
        return hm.m1124b(context.getSharedPreferences("utterPref", 0).getString("email_address", ""));
    }

    public static boolean m1379R(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("email_auth", false);
    }

    public static String m1380S(Context context) {
        return hm.m1124b(context.getSharedPreferences("utterPref", 0).getString("music_email_address", ""));
    }

    public static String m1381T(Context context) {
        return hm.m1124b(context.getSharedPreferences("utterPref", 0).getString("music_password", ""));
    }

    public static Long m1382U(Context context) {
        return Long.valueOf(context.getSharedPreferences("utterPref", 0).getLong("fb_access_expires", 0));
    }

    public static String m1383V(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("fb_access_token", "");
    }

    public static boolean m1384W(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("child_protection", false);
    }

    public static String m1385X(Context context) {
        return hm.m1124b(context.getSharedPreferences("utterPref", 0).getString("user_password_content", ""));
    }

    public static void m1386Y(Context context) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("user_password", true);
        edit.commit();
        ar(context);
    }

    public static boolean m1387Z(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("user_password", false);
    }

    public static void m1388a(Context context, double d) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("car_lon", String.valueOf(d));
        edit.commit();
    }

    public static void m1389a(Context context, int i) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putInt("unknown_action", i);
        edit.commit();
        ar(context);
    }

    public static void m1390a(Context context, int i, int i2, int i3) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putInt("wave_level_1", i);
        edit.putInt("wave_level_2", i2);
        edit.putInt("wave_level_3", i3);
        edit.commit();
    }

    public static void m1391a(Context context, long j) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putLong("command_count", j);
        edit.commit();
    }

    public static void m1392a(Context context, String str) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("fs_access_token", str);
        edit.commit();
        ar(context);
    }

    public static void m1393a(Context context, String str, String str2, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("default_voice_engine_language", str);
        edit.putString("default_voice_engine_iso", str2);
        edit.putBoolean("default_voice_engine_condition", z);
        edit.commit();
    }

    public static void m1394a(Context context, String str, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("default_explorer_packagename", str);
        edit.putBoolean("default_explorer_condition", z);
        edit.commit();
        ar(context);
    }

    public static void m1395a(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("boot_start", z);
        edit.commit();
    }

    public static boolean m1396a(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("boot_start", true);
    }

    public static boolean aa(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("visual_setting", false);
    }

    public static boolean ab(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("disclaimer", false);
    }

    public static boolean ac(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("device_rooted", false);
    }

    public static boolean ad(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("enabled", false);
    }

    public static double ae(Context context) {
        return Double.valueOf(context.getSharedPreferences("utterPref", 0).getString("ai_level", "1")).doubleValue();
    }

    public static boolean af(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("have_user_commands", false);
    }

    public static String ag(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("user_name", "");
    }

    public static boolean ah(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("user_volume", false);
    }

    public static double ai(Context context) {
        return (double) context.getSharedPreferences("utterPref", 0).getInt("user_volume_level", 0);
    }

    public static boolean aj(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("native_locale", false);
    }

    public static boolean ak(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("custom_intro", false);
    }

    public static boolean al(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("shake_setting", false);
    }

    public static boolean am(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("wave_setting", false);
    }

    public static boolean an(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("not_hack", false);
    }

    public static boolean ao(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("now_voice", true);
    }

    public static long ap(Context context) {
        return context.getSharedPreferences("utterPref", 0).getLong("usage_server_threashold", 10);
    }

    public static long aq(Context context) {
        return context.getSharedPreferences("utterPref", 0).getLong("server_update_interval", 900000);
    }

    static void ar(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - context.getSharedPreferences("utterPref", 0).getLong("last_cloud_update", 0);
        if (j > 9000000) {
            if (hc.f1269b) {
                ls.m1346c("updateCloud interval: " + j + " - updating");
            }
            new BackupManager(context).dataChanged();
            m1414d(context, currentTimeMillis);
        } else if (hc.f1269b) {
            ls.m1346c("updateCloud interval: " + j + " - update suspended");
        }
    }

    public static int m1397b(Context context) {
        return context.getSharedPreferences("utterPref", 0).getInt("unknown_action", 0);
    }

    public static void m1398b(Context context, double d) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("car_lat", String.valueOf(d));
        edit.commit();
    }

    public static void m1399b(Context context, int i) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putInt("shake_level", i);
        edit.commit();
        if (ly.m1467d(context)) {
            jy.m1241b(context, true);
        }
    }

    public static void m1400b(Context context, long j) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putLong("usage_server_threashold", j);
        edit.commit();
    }

    public static void m1401b(Context context, String str) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("device_account_status", str);
        edit.commit();
    }

    public static void m1402b(Context context, String str, String str2, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("email_address", hm.m1123a(str));
        edit.putString("email_password", hm.m1123a(str2));
        edit.putBoolean("email_auth", z);
        edit.commit();
        ar(context);
    }

    public static void m1403b(Context context, String str, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("default_notes_packagename", str);
        edit.putBoolean("default_notes_condition", z);
        edit.commit();
        ar(context);
    }

    public static void m1404b(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("sms_body_fix", z);
        edit.commit();
    }

    public static String m1405c(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("fs_access_token", "");
    }

    public static void m1406c(Context context, double d) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        if (d < 0.0d) {
            d = 10.0d;
        } else if (d > 100.0d) {
            d = 100.0d;
        }
        edit.putBoolean("user_volume", true);
        edit.putInt("user_volume_level", (int) Math.round(d));
        edit.commit();
        ar(context);
    }

    public static void m1407c(Context context, int i) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putInt("easter_egg_stage", i);
        edit.commit();
    }

    public static void m1408c(Context context, long j) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putLong("server_update_interval", j);
        edit.commit();
    }

    public static void m1409c(Context context, String str) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("server_email", str);
        edit.commit();
        ar(context);
    }

    public static void m1410c(Context context, String str, String str2, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("music_email_address", hm.m1123a(str));
        edit.putString("music_password", hm.m1123a(str2));
        edit.putBoolean("music_auth", z);
        edit.commit();
        ar(context);
    }

    public static void m1411c(Context context, String str, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("user_name_condition", z);
        edit.putString("user_name", str);
        edit.commit();
        ar(context);
    }

    public static void m1412c(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("proof_read", z);
        edit.commit();
    }

    public static void m1413d(Context context, int i) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putInt("not_recognised_count", i);
        edit.commit();
    }

    private static void m1414d(Context context, long j) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putLong("last_cloud_update", j);
        edit.commit();
    }

    public static void m1415d(Context context, String str) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("temperature_units", str);
        edit.commit();
        ar(context);
    }

    public static void m1416d(Context context, String str, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        if (z) {
            edit.putBoolean("custom_intro", true);
            edit.putString("user_intro", str);
        } else {
            edit.putBoolean("custom_intro", false);
            edit.putString("user_intro", "");
        }
        edit.commit();
        ar(context);
    }

    public static void m1417d(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("adhere_vibrate", z);
        edit.commit();
    }

    public static boolean m1418d(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("sms_body_fix", false);
    }

    public static int m1419e(Context context) {
        return context.getSharedPreferences("utterPref", 0).getInt("wave_level_1", 120);
    }

    public static void m1420e(Context context, String str) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("user_guid", str);
        edit.commit();
        new BackupManager(context).dataChanged();
        m1414d(context, System.currentTimeMillis());
    }

    public static void m1421e(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("adhere_silent", z);
        edit.commit();
    }

    public static int m1422f(Context context) {
        return context.getSharedPreferences("utterPref", 0).getInt("shake_level", 11);
    }

    public static void m1423f(Context context, String str) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("user_sex", str);
        edit.commit();
        ar(context);
    }

    public static void m1424f(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("user_words", z);
        edit.commit();
        ar(context);
    }

    public static int m1425g(Context context) {
        return context.getSharedPreferences("utterPref", 0).getInt("easter_egg_stage", 1);
    }

    public static void m1426g(Context context, String str) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("sms_signature_content", str);
        edit.commit();
        ar(context);
    }

    public static void m1427g(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("nickname", z);
        edit.commit();
        ar(context);
    }

    public static void m1428h(Context context, String str) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("email_signature_content", str);
        edit.commit();
        ar(context);
    }

    public static void m1429h(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("remote_disclaimer", z);
        edit.commit();
    }

    public static boolean m1430h(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("proof_read", true);
    }

    public static void m1431i(Context context, String str) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putString("user_password_content", hm.m1123a(str));
        edit.commit();
        ar(context);
    }

    public static void m1432i(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("visual_setting", z);
        edit.commit();
    }

    public static boolean m1433i(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("adhere_vibrate", false);
    }

    public static void m1434j(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("device_rooted", z);
        edit.commit();
    }

    public static boolean m1435j(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("adhere_silent", false);
    }

    public static String m1436k(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("device_account_status", "null");
    }

    public static void m1437k(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("enabled", z);
        edit.commit();
    }

    public static String m1438l(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("server_email", "null");
    }

    public static void m1439l(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("have_user_commands", z);
        edit.commit();
        ar(context);
    }

    public static long m1440m(Context context) {
        return context.getSharedPreferences("utterPref", 0).getLong("command_count", 0);
    }

    public static void m1441m(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("shake_setting", z);
        edit.commit();
    }

    public static double m1442n(Context context) {
        return Double.valueOf(context.getSharedPreferences("utterPref", 0).getString("car_lon", QueryParamConst.U_VALUE)).doubleValue();
    }

    public static void m1443n(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("wave_setting", z);
        edit.commit();
    }

    public static double m1444o(Context context) {
        return Double.valueOf(context.getSharedPreferences("utterPref", 0).getString("car_lat", QueryParamConst.U_VALUE)).doubleValue();
    }

    public static void m1445o(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("not_hack", z);
        edit.commit();
        ar(context);
    }

    public static void m1446p(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("now_voice", z);
        edit.commit();
        ar(context);
    }

    public static boolean m1447p(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("car_location", false);
    }

    public static void m1448q(Context context) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("car_location", true);
        edit.commit();
    }

    public static String m1449r(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("temperature_units", "");
    }

    public static String m1450s(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("user_guid", "null");
    }

    public static String m1451t(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("user_uuid", "");
    }

    public static String m1452u(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("user_sex", "U");
    }

    public static boolean m1453v(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("not_recognised_cond", false);
    }

    public static void m1454w(Context context) {
        Editor edit = context.getSharedPreferences("utterPref", 0).edit();
        edit.putBoolean("not_recognised_cond", true);
        edit.commit();
    }

    public static int m1455x(Context context) {
        return context.getSharedPreferences("utterPref", 0).getInt("not_recognised_count", 0);
    }

    public static boolean m1456y(Context context) {
        return context.getSharedPreferences("utterPref", 0).getBoolean("developer_note_2", false);
    }

    public static String m1457z(Context context) {
        return context.getSharedPreferences("utterPref", 0).getString("widget_iso", "USA");
    }
}
