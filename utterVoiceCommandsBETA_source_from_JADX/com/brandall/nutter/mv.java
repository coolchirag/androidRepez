package com.brandall.nutter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Process;
import java.util.List;
import java.util.Random;

public final class mv extends Intent {
    private static Random f1742a = new Random();
    private int f1743b = 0;

    public mv() {
        super("net.dinglisch.android.tasker.ACTION_TASK");
        m1492d();
        m1486a(m1490c());
    }

    public mv(String str) {
        super("net.dinglisch.android.tasker.ACTION_TASK");
        m1492d();
        m1486a(str);
    }

    public static Intent m1484a() {
        return new Intent("net.dinglisch.android.tasker.ACTION_TASK_SELECT").setFlags(1082392576);
    }

    public static String m1485a(Context context) {
        String str = null;
        try {
            context.getPackageManager().getPackageInfo("net.dinglisch.android.tasker", 0);
            str = "net.dinglisch.android.tasker";
        } catch (NameNotFoundException e) {
        }
        try {
            context.getPackageManager().getPackageInfo("net.dinglisch.android.taskerm", 0);
            return "net.dinglisch.android.taskerm";
        } catch (NameNotFoundException e2) {
            return str;
        }
    }

    private void m1486a(String str) {
        putExtra("version_number", "1.1");
        putExtra("task_name", str);
    }

    private static boolean m1487a(Context context, String str) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://net.dinglisch.android.tasker/prefs"), new String[]{str}, null, null, null);
        if (query != null) {
            query.moveToFirst();
            boolean z = Boolean.TRUE.toString().equals(query.getString(0));
            query.close();
            return z;
        } else if (!hc.f1269b) {
            return false;
        } else {
            ls.m1347d("no cursor for content://net.dinglisch.android.tasker/prefs");
            return false;
        }
    }

    public static Intent m1488b() {
        return new Intent("net.dinglisch.android.tasker.ACTION_OPEN_PREFS").putExtra("tno", 3);
    }

    public static mw m1489b(Context context) {
        int i = 1;
        if (!m1491c(context)) {
            return mw.NotInstalled;
        }
        if ((context.checkPermission("net.dinglisch.android.tasker.PERMISSION_RUN_TASKS", Process.myPid(), Process.myUid()) == 0 ? 1 : 0) == 0) {
            return mw.NoPermission;
        }
        if (!m1487a(context, "enabled")) {
            return mw.NotEnabled;
        }
        if (!m1487a(context, "ext_access")) {
            return mw.AccessBlocked;
        }
        List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new mv(""), 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            i = 0;
        }
        return i == 0 ? mw.NoReceiver : mw.OK;
    }

    private static String m1490c() {
        return Long.toString(f1742a.nextLong());
    }

    public static boolean m1491c(Context context) {
        return m1485a(context) != null;
    }

    private void m1492d() {
        setData(Uri.parse("id:" + m1490c()));
    }
}
