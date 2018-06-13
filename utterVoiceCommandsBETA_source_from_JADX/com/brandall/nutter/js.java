package com.brandall.nutter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.dropbox.client2.C0196a;
import com.dropbox.client2.C0202e;
import com.dropbox.client2.android.C0199a;
import com.dropbox.client2.p021a.C0187a;
import com.dropbox.client2.p021a.C0188b;
import com.dropbox.client2.p021a.C0189c;
import com.dropbox.client2.p021a.C0190d;
import com.dropbox.client2.p021a.C0191e;
import com.dropbox.client2.p021a.C0193g;
import com.dropbox.client2.p021a.C0195i;
import com.dropbox.client2.p022c.C0197m;
import com.dropbox.client2.p022c.C0214k;
import com.dropbox.client2.p022c.C0215l;
import com.dropbox.client2.p022c.C0216n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class js extends AsyncTask<Void, Long, Boolean> {
    private static final C0216n f1565g = C0216n.APP_FOLDER;
    Context f1566a;
    private C0196a<C0199a> f1567b;
    private File f1568c;
    private long f1569d;
    private C0202e f1570e;
    private String f1571f;

    public js(Context context, File file) {
        C0197m c0199a;
        String str = null;
        this.f1566a = context;
        C0215l c0215l = new C0215l("gglnjer4bz97cf9", "r2i7yv5ojyjjbyr");
        ls.m1346c("getStoredKeys");
        SharedPreferences sharedPreferences = this.f1566a.getSharedPreferences("utterPref", 0);
        String string = sharedPreferences.getString("db_token_key", null);
        String string2 = sharedPreferences.getString("db_token_secret", null);
        ls.m1344a("key: " + string + " : secret: " + string2);
        if (!(string == null || string2 == null)) {
            str = new String[]{string, string2};
        }
        if (str != null) {
            c0199a = new C0199a(c0215l, f1565g, new C0214k(str[0], str[1]));
        } else {
            c0199a = new C0199a(c0215l, f1565g);
        }
        this.f1567b = new C0196a(c0199a);
        this.f1569d = file.length();
        this.f1568c = file;
    }

    private Boolean m1215a() {
        try {
            InputStream fileInputStream = new FileInputStream(this.f1568c);
            this.f1570e = this.f1567b.m1523a(this.f1568c.getName(), fileInputStream, this.f1568c.length(), new jt(this));
            if (this.f1570e != null) {
                this.f1570e.mo103a();
                return Boolean.valueOf(true);
            }
        } catch (C0195i e) {
            this.f1571f = "Please authorise utter to access your drop box account.";
        } catch (C0188b e2) {
            this.f1571f = "Sorry, but the file is too big to upload";
        } catch (C0191e e3) {
            this.f1571f = "Upload canceled";
        } catch (C0193g e4) {
            if (!(e4.f1846b == 401 || e4.f1846b == 403 || e4.f1846b == 404)) {
                int i = e4.f1846b;
            }
            this.f1571f = e4.f1845a.f1852b;
            if (this.f1571f == null) {
                this.f1571f = e4.f1845a.f1851a;
            }
        } catch (C0189c e5) {
            this.f1571f = "There was a network error. Please try again.";
        } catch (C0190d e6) {
            this.f1571f = "A drop box error occurred. Please try again.";
        } catch (C0187a e7) {
            this.f1571f = "An unknown error occurred. Please try again.";
        } catch (FileNotFoundException e8) {
        }
        return Boolean.valueOf(false);
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m1215a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            lc.m1313a(this.f1566a, false, "The file was uploaded to Drop box successfully.");
        } else {
            lc.m1313a(this.f1566a, false, this.f1571f);
        }
        lt.m1349a(3);
    }

    protected final void onPreExecute() {
        lt.m1352a(this.f1566a, "Dropbox upload", "utter! uploading", "to Dropbox", 17301640, true, 0, 3);
    }

    protected final /* synthetic */ void onProgressUpdate(Object... objArr) {
        lt.m1352a(this.f1566a, "Dropbox upload", "utter! is uploading", "to Dropbox...", 17301633, true, (int) (((100.0d * ((double) ((Long[]) objArr)[0].longValue())) / ((double) this.f1569d)) + 0.5d), 3);
    }
}
