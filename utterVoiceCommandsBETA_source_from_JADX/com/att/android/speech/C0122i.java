package com.att.android.speech;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.faceture.http.Scheme;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class C0122i {
    private static C0122i f530c = null;
    private String f531A;
    private boolean f532B = true;
    private int f533C = 1500;
    private int f534D = 850;
    private int f535E = 500;
    private int f536F = 25000;
    private int f537G = 10000;
    private int f538H = 30000;
    private int f539a = -1;
    private final Activity f540b;
    private ad f541d = null;
    private C0130s f542e;
    private C0118c f543f;
    private boolean f544g = false;
    private C0113h f545h = new C0123j(this);
    private C0116f f546i = new C0124k(this);
    private ai f547j = new C0125l(this);
    private C0113h f548k;
    private C0116f f549l;
    private C0130s f550m;
    private C0118c f551n;
    private URI f552o;
    private String f553p;
    private String f554q;
    private String f555r;
    private String f556s;
    private String f557t;
    private String f558u;
    private HashMap<String, String> f559v;
    private boolean f560w = true;
    private String f561x;
    private String f562y;
    private String f563z;

    private C0122i(Activity activity) {
        this.f540b = activity;
        if (this.f540b.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == -1) {
            throw new IllegalStateException("ATTSpeechKit requires that the app have the RECORD_AUDIO permission.  Please add the RECORD_AUDIO permission to the Android manifest");
        }
    }

    public static C0122i m408a(Activity activity) {
        if (f530c == null || f530c.f540b != activity) {
            f530c = new C0122i(activity);
        }
        return f530c;
    }

    private void m409a(C0120e c0120e, String str) {
        if (this.f549l != null) {
            this.f549l.mo61a(new C0119d(c0120e, str));
        }
        m438d();
    }

    private void m419k() {
        this.f541d = null;
        Binder.flushPendingCommands();
    }

    private void m420l() {
        try {
            ac.m345a("ATTSpeechService", "startRecording() called.");
            if (this.f541d != null) {
                ac.m345a("ATTSpeechService", "Attempted to start recording on an already used request manager");
                return;
            }
            if (this.f550m != null) {
                this.f550m.mo65a(C0133t.INITIALIZING);
            }
            if (this.f542e != null) {
                this.f542e.mo65a(C0133t.INITIALIZING);
            }
            this.f541d = new ad(this.f540b);
            this.f541d.m360a(this.f545h);
            this.f541d.m359a(this.f546i);
            this.f541d.m358a(this.f547j);
            this.f541d.m361a(this.f552o);
            this.f541d.m357a(this.f536F);
            this.f541d.m366c(this.f534D);
            this.f541d.m364b(this.f535E);
            this.f541d.m367d(this.f533C);
            this.f541d.f398c = this.f538H;
            this.f541d.f399d = this.f537G;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Map unmodifiableMap = this.f559v != null ? Collections.unmodifiableMap(this.f559v) : null;
            if (unmodifiableMap != null) {
                for (String str : unmodifiableMap.keySet()) {
                    arrayList.add(str);
                    arrayList2.add((String) unmodifiableMap.get(str));
                }
            }
            this.f541d.f400e = (String[]) arrayList.toArray(new String[0]);
            this.f541d.f401f = (String[]) arrayList2.toArray(new String[0]);
            this.f541d.f402g = this.f557t;
            this.f541d.f404i = this.f555r;
            this.f541d.f405j = this.f556s;
            this.f541d.f406k = this.f554q;
            this.f541d.f410o = this.f553p;
            this.f541d.f407l = this.f558u;
            this.f541d.m358a(this.f547j);
            this.f541d.m359a(this.f546i);
            this.f541d.m360a(this.f545h);
            this.f541d.m362a(this.f532B);
            ac.m345a("ATTSpeechService", "Will start recording now....");
            this.f541d.m363b();
            ac.m345a("ATTSpeechService", "Should've started recording....");
            C0133t c0133t = this.f557t != null ? C0133t.PROCESSING : C0133t.RECORDING;
            if (this.f550m != null) {
                this.f550m.mo65a(c0133t);
            }
            if (this.f542e != null) {
                this.f542e.mo65a(c0133t);
            }
        } catch (C0134u e) {
            m409a(C0120e.PARAMETER_ERROR, e.getMessage());
            e.printStackTrace();
        } catch (Exception e2) {
            m409a(C0120e.OTHER_ERROR, e2.getMessage());
            e2.printStackTrace();
        }
    }

    private String m421m() {
        if (this.f562y == null) {
            this.f562y = "Stop";
        }
        return this.f562y;
    }

    private String m422n() {
        if (this.f531A == null) {
            this.f531A = "Cancel";
        }
        return this.f531A;
    }

    @Deprecated
    public final void m423a() {
        this.f544g = false;
        this.f539a = -1;
        if (this.f560w) {
            Builder builder = new Builder(this.f540b);
            builder.setTitle("Initializing...");
            Drawable aaVar = new aa(this.f540b);
            aaVar.f375a = new C0132r(this);
            this.f543f = new C0126m(this, aaVar);
            View imageView = new ImageView(this.f540b);
            imageView.setBackgroundDrawable(new BitmapDrawable(aaVar.f377c));
            imageView.setImageDrawable(aaVar);
            imageView.setAdjustViewBounds(true);
            builder.setView(imageView);
            builder.setPositiveButton(m421m(), null);
            OnClickListener c0127n = new C0127n(this);
            builder.setNegativeButton(m422n(), new C0128o(this));
            builder.setCancelable(true);
            builder.setOnCancelListener(new C0129p(this));
            AlertDialog create = builder.create();
            create.setOwnerActivity(this.f540b);
            this.f542e = new C0131q(this, create, c0127n);
            create.show();
            return;
        }
        m420l();
    }

    public final void m424a(int i) {
        this.f533C = i;
    }

    public final void m425a(C0116f c0116f) {
        this.f549l = c0116f;
    }

    public final void m426a(C0113h c0113h) {
        this.f548k = c0113h;
    }

    public final void m427a(String str) {
        this.f553p = str;
    }

    public final void m428a(URI uri) {
        if (uri == null) {
            throw new NullPointerException("Request URL is null");
        } else if (Scheme.HTTP.equals(uri.getScheme()) || Scheme.HTTPS.equals(uri.getScheme())) {
            this.f552o = uri;
        } else {
            throw new URISyntaxException(uri.toString(), "Protocol must be HTTP or HTTPS");
        }
    }

    public final void m429a(Map<String, String> map) {
        this.f559v = new HashMap(map);
    }

    public final void m430a(boolean z) {
        this.f560w = z;
    }

    public final void m431b() {
        this.f541d.m356a();
        ac.m345a("ATTSpeechService", "Stop method called");
    }

    public final void m432b(int i) {
        this.f534D = i;
    }

    public final void m433b(String str) {
        this.f554q = str;
    }

    public final void m434b(boolean z) {
        this.f532B = z;
    }

    final void m435c() {
        this.f544g = true;
        m409a(C0120e.USER_CANCELED, "Dialog cancelled by user");
        m438d();
    }

    public final void m436c(int i) {
        this.f535E = i;
    }

    public final void m437c(String str) {
        this.f555r = str;
    }

    public final void m438d() {
        this.f544g = true;
        if (this.f541d != null) {
            ac.m345a("ATTSpeechService", "RequestManager will be canceled");
            this.f541d.m365c();
        } else {
            ac.m345a("ATTSpeechService", "RequestManager is null");
        }
        m419k();
    }

    public final void m439d(int i) {
        this.f536F = i;
    }

    public final void m440d(String str) {
        this.f556s = str;
    }

    protected final void m441e() {
        m420l();
    }

    public final void m442e(int i) {
        this.f537G = i;
    }

    public final void m443e(String str) {
        this.f557t = str;
    }

    public final void m444f(int i) {
        this.f538H = i;
    }

    public final void m445f(String str) {
        this.f558u = str;
    }

    public final boolean m446f() {
        return this.f560w;
    }

    public final String m447g() {
        if (this.f561x == null) {
            this.f561x = "Listening...";
        }
        return this.f561x;
    }

    public final void m448g(String str) {
        this.f561x = str;
    }

    public final String m449h() {
        if (this.f563z == null) {
            this.f563z = "Processing...";
        }
        return this.f563z;
    }

    public final void m450h(String str) {
        this.f562y = str;
    }

    public final void m451i(String str) {
        this.f563z = str;
    }

    public final boolean m452i() {
        return this.f532B;
    }

    final JSONObject m453j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestUrl", this.f552o);
            jSONObject.put("speechContext", this.f553p);
            jSONObject.put("bearerAuthToken", this.f554q);
            jSONObject.put("audioFilePath", this.f557t);
            jSONObject.put("contentType", this.f558u);
            jSONObject.put("showUI", this.f560w);
            jSONObject.put("recordingPrompt", m447g());
            jSONObject.put("recordingStopButton", m421m());
            jSONObject.put("processingPrompt", m449h());
            jSONObject.put("processingCancelButton", m422n());
            jSONObject.put("cancelWhenSilent", this.f532B);
            jSONObject.put("maxInitialSilence", this.f533C);
            jSONObject.put("endingSilence", this.f534D);
            jSONObject.put("minRecordingTime", this.f535E);
            jSONObject.put("maxRecordingTime", this.f536F);
            jSONObject.put("connectionTimeout", this.f537G);
            jSONObject.put("serverResponseTimeout", this.f538H);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final void m454j(String str) {
        this.f531A = str;
    }
}
