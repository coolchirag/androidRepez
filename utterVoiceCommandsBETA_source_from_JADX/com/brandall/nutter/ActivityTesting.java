package com.brandall.nutter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.Vibrator;
import android.widget.Toast;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

public class ActivityTesting extends Activity {
    UITableView f720a;
    private AdView f721b;

    static /* synthetic */ void m674a(ActivityTesting activityTesting) {
        if (!lx.m1450s(activityTesting).matches("null")) {
            kz.f1634c = true;
        }
        if (VERSION.SDK_INT >= 11) {
            new kz(activityTesting).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new kz(activityTesting).execute(new Void[0]);
        }
    }

    private void m675a(String str) {
        ((Vibrator) getSystemService("vibrator")).vibrate(100);
        Toast.makeText(this, str, 1).show();
    }

    static /* synthetic */ void m676b(ActivityTesting activityTesting) {
        if (!lx.m1450s(activityTesting).matches("null")) {
            kz.f1643l = 777;
            kz.f1644m = 0;
            kz.f1633b = true;
            lx.m1408c((Context) activityTesting, 0);
            lx.m1400b((Context) activityTesting, 0);
        }
        if (VERSION.SDK_INT >= 11) {
            new kz(activityTesting).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new kz(activityTesting).execute(new Void[0]);
        }
    }

    static /* synthetic */ void m678d(ActivityTesting activityTesting) {
        lx.m1420e((Context) activityTesting, "null");
        activityTesting.m675a("cleared");
    }

    static /* synthetic */ void m680f(ActivityTesting activityTesting) {
        try {
            ki.m1297a(activityTesting, "attack|sfsfdfs|attack|erwerewr|");
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
        } catch (InvalidAlgorithmParameterException e6) {
            e6.printStackTrace();
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        } catch (ClientProtocolException e8) {
            e8.printStackTrace();
        } catch (ParseException e9) {
            e9.printStackTrace();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    static /* synthetic */ void m681g(ActivityTesting activityTesting) {
        try {
            String d = ki.m1302d(activityTesting);
            if (d != null) {
                activityTesting.m675a(d);
            } else {
                activityTesting.m675a("Server error!");
            }
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
        } catch (InvalidAlgorithmParameterException e6) {
            e6.printStackTrace();
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        } catch (ClientProtocolException e8) {
            e8.printStackTrace();
        } catch (ParseException e9) {
            e9.printStackTrace();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    static /* synthetic */ void m682h(ActivityTesting activityTesting) {
        try {
            ki.m1298b(activityTesting);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
        } catch (InvalidAlgorithmParameterException e6) {
            e6.printStackTrace();
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        } catch (ClientProtocolException e8) {
            e8.printStackTrace();
        } catch (ParseException e9) {
            e9.printStackTrace();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    static /* synthetic */ void m683i(ActivityTesting activityTesting) {
        if (lx.m1450s(activityTesting).matches("null")) {
            activityTesting.m675a("Device not recognised");
        } else {
            jy.m1274y(activityTesting, "http://www.utter.me.uk/redirect.asp?id=" + lx.m1450s(activityTesting) + "&page=xda1");
        }
    }

    static /* synthetic */ void m684j(ActivityTesting activityTesting) {
        if (lx.m1438l(activityTesting).matches("null")) {
            activityTesting.m675a("PLEASE LOG IN");
            return;
        }
        try {
            activityTesting.m675a(ki.m1300c(activityTesting));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
        } catch (InvalidAlgorithmParameterException e6) {
            e6.printStackTrace();
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        } catch (ClientProtocolException e8) {
            e8.printStackTrace();
        } catch (ParseException e9) {
            e9.printStackTrace();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    static /* synthetic */ void m685k(ActivityTesting activityTesting) {
        if (lx.m1450s(activityTesting).matches("null")) {
            activityTesting.m675a("Device not recognised");
        } else {
            jy.m1274y(activityTesting, "http://www.utter.me.uk/redirect.asp?id=" + lx.m1450s(activityTesting) + "&page=mystats");
        }
    }

    static /* synthetic */ void m686l(ActivityTesting activityTesting) {
        try {
            ki.m1299b(activityTesting, "What's the difference between hamburgers falling from the sky and cabbage falling from the sky? One is a meatier shower.");
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
        } catch (InvalidAlgorithmParameterException e6) {
            e6.printStackTrace();
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        } catch (ClientProtocolException e8) {
            e8.printStackTrace();
        } catch (ParseException e9) {
            e9.printStackTrace();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    static /* synthetic */ void m687m(ActivityTesting activityTesting) {
        activityTesting.m675a("cleared");
        lx.m1409c((Context) activityTesting, "null");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (hc.f1269b) {
                ls.m1345b("Landscape");
            }
        } else if (configuration.orientation == 1 && hc.f1269b) {
            ls.m1345b("Portrait");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.testing_layout);
        if (hc.f1269b) {
            ls.m1346c("ActivityTesting OnCreate");
        }
        this.f721b = (AdView) findViewById(R.id.adView);
        this.f720a = (UITableView) findViewById(R.id.tableView);
        this.f720a.setClickListener(new fs());
        C0090a c0090a = new C0090a("Server Message");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to fetch";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("Force send stats");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to send";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("Show intervals");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to toast";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("Clear GUID");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to clear";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("Show GUID");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to toast";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("DOS Attack");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to attack";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("Request Joke");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to chuckle!";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("Send Location");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to update";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("Test Redirect");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to get directed!";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("Send Info");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to send";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("View Usage Stats");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to view";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("Send Joke");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to send";
        this.f720a.m292a(c0090a);
        c0090a = new C0090a("Clear Email");
        c0090a.f294b = R.drawable.myexport;
        c0090a.f297e = "tap to clear";
        this.f720a.m292a(c0090a);
        this.f720a.m291a();
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
        }
        c0237d.m1636a(a);
        this.f721b.m1593a(c0237d);
    }

    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("ActivityTesting onDestroy");
        }
        if (this.f721b != null) {
            this.f721b.removeAllViews();
            this.f721b.m1592a();
        }
        getWindow().clearFlags(128);
    }

    public void onPause() {
        super.onPause();
        if (hc.f1269b) {
            ls.m1346c("ActivityTesting onPause");
        }
    }

    public void onResume() {
        super.onResume();
        if (hc.f1269b) {
            ls.m1346c("ActivityTesting onResume");
        }
    }
}
