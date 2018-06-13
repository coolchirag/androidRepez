package com.brandall.nutter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class kv extends AsyncTask<Void, Void, Void> {
    Context f1625a;

    public kv(Context context) {
        this.f1625a = context;
    }

    private Void m1306a() {
        List queryIntentActivities;
        if (hc.f1269b) {
            ls.m1346c("DIB ApplicationList");
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            System.gc();
            Runtime.getRuntime().gc();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            PackageManager packageManager = this.f1625a.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            try {
                queryIntentActivities = packageManager.queryIntentActivities(intent, 128);
            } catch (Exception e) {
                e.printStackTrace();
                System.gc();
                Runtime.getRuntime().gc();
                queryIntentActivities = null;
            }
            Locale locale = Locale.US;
            if (r0 != null) {
                for (ResolveInfo resolveInfo : r0) {
                    String toLowerCase = resolveInfo.activityInfo.applicationInfo.loadLabel(packageManager).toString().toLowerCase(locale);
                    String str = resolveInfo.activityInfo.applicationInfo.packageName;
                    if (!(toLowerCase == null || str == null || arrayList.contains(toLowerCase))) {
                        arrayList.add(toLowerCase);
                        arrayList2.add(str);
                    }
                }
                if (hc.f1269b) {
                    ls.m1346c("AppName: " + arrayList.size() + " " + arrayList.toString());
                    ls.m1346c("PackageName: " + arrayList2.size() + " " + arrayList2.toString());
                }
                if (!(arrayList.isEmpty() || arrayList2.isEmpty())) {
                    new hd(this.f1625a).m1061a(arrayList, arrayList2);
                }
            } else if (hc.f1269b) {
                ls.m1347d("List was null");
            }
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            if (hc.f1269b) {
                ls.m1346c("GAL elapsed: " + currentTimeMillis);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        GlobalV.m856j(false);
        return null;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m1306a();
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        if (hc.f1269b) {
            ls.m1345b("GenerateAppList onPreEx");
        }
        GlobalV.m856j(true);
    }
}
