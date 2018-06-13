package com.brandall.nutter;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.util.ArrayList;

public final class gu extends AsyncTask<Void, Void, Boolean> {
    Context f1251a;
    boolean f1252b = false;
    boolean f1253c = false;
    boolean f1254d = false;
    boolean f1255e = true;

    public gu(Context context) {
        this.f1251a = context;
    }

    private void m999a(String str) {
        lc.m1313a(this.f1251a, false, str);
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        Object obj;
        ls.m1346c("DIB BackupHelper");
        long currentTimeMillis = System.currentTimeMillis();
        Object obj2 = null;
        Object obj3 = null;
        ArrayList arrayList = new ArrayList();
        arrayList = new ArrayList();
        arrayList = new ArrayList();
        arrayList = new ArrayList();
        arrayList = new ArrayList();
        arrayList = new ArrayList();
        hk hkVar = new hk(this.f1251a);
        he heVar = new he(this.f1251a);
        arrayList = heVar.m1070b();
        ArrayList c = heVar.m1072c();
        ArrayList e = heVar.m1076e();
        ArrayList d = heVar.m1074d();
        Object obj4;
        if (arrayList.isEmpty()) {
            obj4 = null;
            int i = 1;
        } else {
            ls.m1344a("arrayUP: " + arrayList.size() + " : " + arrayList.toString());
            ls.m1344a("arrayUPR: " + c.size() + " : " + c.toString());
            if (arrayList.size() == c.size() && e.size() == d.size() && arrayList.size() == d.size()) {
                obj4 = null;
                obj = null;
            } else {
                obj4 = 1;
                obj = null;
            }
        }
        ArrayList a = hkVar.m1114a();
        ArrayList b = hkVar.m1120b();
        if (a.isEmpty()) {
            obj2 = 1;
        } else {
            ls.m1344a("arrayUW: " + a.size() + " : " + a.toString());
            ls.m1344a("arrayUR: " + b.size() + " : " + b.toString());
            if (a.size() != b.size()) {
                obj3 = 1;
            }
        }
        if (obj2 != null && obj != null) {
            this.f1252b = true;
            return Boolean.valueOf(false);
        } else if (obj3 == null && r6 == null) {
            if (obj2 != null) {
                if (!nt.m1506a(arrayList, c, e, d, null, null)) {
                    this.f1253c = true;
                }
            } else if (obj != null) {
                if (!nt.m1506a(null, null, null, null, a, b)) {
                    this.f1253c = true;
                }
            } else if (!nt.m1506a(arrayList, c, e, d, a, b)) {
                this.f1253c = true;
            }
            ls.m1346c("BackupHelper elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
            return Boolean.valueOf(true);
        } else {
            this.f1255e = true;
            return Boolean.valueOf(false);
        }
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        ls.m1345b("BackupHelper onPostEx");
        try {
            ActivityCustomise.m525a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bool.booleanValue()) {
            Toast.makeText(this.f1251a, "File: /utter/User_Commands/Backup.xml", 1).show();
            m999a("The back up completed successfully.");
        } else if (this.f1252b) {
            m999a("Sorry, but I didn't detect any phrases or custom replacements to export. Please note, custom commands are exported via the cloud.");
        } else if (this.f1253c) {
            m999a("Sorry, the back up failed due to an XML error");
        } else if (this.f1254d) {
            m999a("Sorry, the back up failed due to a database error");
        } else if (this.f1255e) {
            m999a("Sorry, the back up failed due to corrupt user data");
        } else {
            m999a("Sorry, but something went wrong");
        }
        super.onPostExecute(bool);
    }
}
