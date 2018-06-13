package com.p011a.p012a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.faceture.google.play.FormFieldConst;
import com.faceture.google.play.QueryParamConst;
import org.ispeech.core.InternalResources;
import org.json.JSONException;

public final class C0102b {
    public static final Uri f333a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    protected static String f334b = "https://m.facebook.com/dialog/";
    protected static String f335c = "https://graph.facebook.com/";
    protected static String f336d = "https://api.facebook.com/restserver.php";
    private String f337e = null;
    private long f338f = 0;
    private long f339g = 0;
    private String f340h;
    private Activity f341i;
    private String[] f342j;
    private int f343k;
    private C0103e f344l;
    private final long f345m = 86400000;
    private boolean f346n = true;
    private C0105d f347o = null;

    public C0102b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
        }
        this.f340h = str;
    }

    private void m295a(Activity activity, String[] strArr) {
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        CookieSyncManager.createInstance(activity);
        String str = "oauth";
        C0103e c0104c = new C0104c(this);
        String str2 = f334b + str;
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if (str.equals("oauth")) {
            bundle.putString(InternalResources.ISPEECH_SCREEN_TYPE, "user_agent");
            bundle.putString("client_id", this.f340h);
        } else {
            bundle.putString("app_id", this.f340h);
        }
        if (m306a()) {
            bundle.putString("access_token", this.f337e);
        }
        String stringBuilder = new StringBuilder(String.valueOf(str2)).append("?").append(C0112l.m327a(bundle)).toString();
        if (activity.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            C0112l.m331a((Context) activity, "Error", "Application requires permission to access the Internet");
        } else {
            new C0107g(activity, stringBuilder, c0104c).show();
        }
    }

    static /* synthetic */ void m297a(C0102b c0102b, String str, Context context) {
        String str2 = null;
        Cursor query = context.getContentResolver().query(f333a, new String[]{"aid"}, null, null, null);
        if (query != null && query.moveToFirst()) {
            str2 = query.getString(query.getColumnIndex("aid"));
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
        String stringBuilder = new StringBuilder(String.valueOf(str)).append("ping").toString();
        if (sharedPreferences.getLong(stringBuilder, 0) == 0 && str2 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("fields", "supports_attribution");
            Object obj = C0112l.m333b(c0102b.m302a(str, bundle, "GET")).get("supports_attribution");
            if (!(obj instanceof Boolean)) {
                throw new JSONException(String.format("%s contains %s instead of a Boolean", new Object[]{"supports_attribution", obj}));
            } else if (((Boolean) obj).booleanValue()) {
                bundle = new Bundle();
                bundle.putString("event", "MOBILE_APP_INSTALL");
                bundle.putString("attribution", str2);
                c0102b.m302a(String.format("%s/activities", new Object[]{str}), bundle, "POST");
                Editor edit = sharedPreferences.edit();
                edit.putLong(stringBuilder, System.currentTimeMillis());
                edit.commit();
            }
        }
    }

    private boolean m298a(Activity activity, String str, String[] strArr) {
        boolean z = true;
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", str);
        if (strArr.length > 0) {
            intent.putExtra("scope", TextUtils.join(",", strArr));
        }
        ResolveInfo resolveActivity = activity.getPackageManager().resolveActivity(intent, 0);
        if (!(resolveActivity == null ? false : C0102b.m299a((Context) activity, resolveActivity.activityInfo.packageName))) {
            return false;
        }
        this.f341i = activity;
        this.f342j = strArr;
        this.f343k = 32665;
        try {
            activity.startActivityForResult(intent, 32665);
        } catch (ActivityNotFoundException e) {
            z = false;
        }
        return z;
    }

    private static boolean m299a(Context context, String str) {
        try {
            for (Signature toCharsString : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (toCharsString.toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2")) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public final String m301a(String str) {
        return m302a(str, new Bundle(), "GET");
    }

    public final String m302a(String str, Bundle bundle, String str2) {
        bundle.putString("format", FormFieldConst.JSON_NAME);
        if (m306a()) {
            bundle.putString("access_token", this.f337e);
        }
        return C0112l.m330a(str != null ? f335c + str : f336d, str2, bundle);
    }

    public final void m303a(int i, int i2, Intent intent) {
        if (i != this.f343k) {
            return;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra == null) {
                m308b(intent.getStringExtra("access_token"));
                m310c(intent.getStringExtra("expires_in"));
                if (m306a()) {
                    C0112l.m332a("Facebook-authorize", "Login Success! access_token=" + this.f337e + " expires=" + this.f339g);
                    this.f344l.mo53a(intent.getExtras());
                    return;
                }
                this.f344l.mo55a(new C0106f("Failed to receive access token."));
            } else if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                C0112l.m332a("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                m295a(this.f341i, this.f342j);
            } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                C0112l.m332a("Facebook-authorize", "Login canceled by user.");
                this.f344l.mo52a();
            } else {
                String stringExtra2 = intent.getStringExtra("error_description");
                if (stringExtra2 != null) {
                    stringExtra = new StringBuilder(String.valueOf(stringExtra)).append(":").append(stringExtra2).toString();
                }
                C0112l.m332a("Facebook-authorize", "Login failed: " + stringExtra);
                this.f344l.mo55a(new C0106f(stringExtra));
            }
        } else if (i2 != 0) {
        } else {
            if (intent != null) {
                C0112l.m332a("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                this.f344l.mo54a(new C0101a(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                return;
            }
            C0112l.m332a("Facebook-authorize", "Login canceled by user.");
            this.f344l.mo52a();
        }
    }

    public final void m304a(long j) {
        this.f339g = j;
    }

    public final void m305a(Activity activity, String[] strArr, C0103e c0103e) {
        this.f344l = c0103e;
        Context applicationContext = activity.getApplicationContext();
        C0105d c0105d = null;
        synchronized (this) {
            if (this.f347o == null) {
                String str = this.f340h;
                if (str != null) {
                    c0105d = new C0105d(this, str, applicationContext);
                    this.f347o = c0105d;
                }
            }
        }
        if (c0105d != null) {
            c0105d.execute(new Void[0]);
        }
        if (!m298a(activity, this.f340h, strArr)) {
            m295a(activity, strArr);
        }
    }

    public final boolean m306a() {
        return this.f337e != null && (this.f339g == 0 || System.currentTimeMillis() < this.f339g);
    }

    public final String m307b() {
        return this.f337e;
    }

    public final void m308b(String str) {
        this.f337e = str;
        this.f338f = System.currentTimeMillis();
    }

    public final long m309c() {
        return this.f339g;
    }

    public final void m310c(String str) {
        if (str != null) {
            this.f339g = str.equals(QueryParamConst.U_VALUE) ? 0 : System.currentTimeMillis() + (Long.parseLong(str) * 1000);
        }
    }
}
