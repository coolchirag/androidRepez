package p000a.p001a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p003c.C0004b;
import p000a.p001a.p003c.C0006c;
import p000a.p001a.p003c.C0016a;
import p000a.p001a.p004b.C0012a;
import p000a.p001a.p004b.C0013c;
import p000a.p001a.p004b.C0015e;

public abstract class C0002b implements C0001e {
    private String f11a;
    private String f12b;
    private String f13c;
    private C0016a f14d = new C0016a();
    private Map<String, String> f15e = new HashMap();
    private boolean f16f;
    private transient C0024f f17g;

    public C0002b(String str, String str2, String str3) {
        this.f11a = str;
        this.f12b = str2;
        this.f13c = str3;
    }

    private void m3a(C0009d c0009d, String str, String... strArr) {
        Exception e;
        C0015e e2;
        Throwable th;
        C0013c e3;
        Map map = this.f15e;
        if (c0009d.getConsumerKey() == null || c0009d.getConsumerSecret() == null) {
            throw new C0013c("Consumer key or secret not set");
        }
        C0004b c0004b = null;
        C0004b a;
        try {
            a = mo1a(str);
            try {
                String a2;
                C0016a c0016a;
                C0024f c0024f;
                for (String a22 : map.keySet()) {
                    a.setHeader(a22, (String) map.get(a22));
                }
                if (strArr != null) {
                    c0016a = new C0016a();
                    c0016a.m24a(strArr);
                    c0009d.setAdditionalParameters(c0016a);
                }
                if (this.f17g != null) {
                    c0024f = this.f17g;
                }
                c0009d.sign(a);
                if (this.f17g != null) {
                    c0024f = this.f17g;
                }
                C0006c a3 = mo2a(a);
                int b = a3.mo13b();
                boolean z = false;
                if (this.f17g != null) {
                    z = this.f17g.m44a();
                }
                if (z) {
                    try {
                        mo3b(a);
                    } catch (Exception e4) {
                        throw new C0012a(e4);
                    }
                } else if (b < 300 || a3 == null) {
                    c0016a = C0017c.m27a(a3.mo12a());
                    a22 = c0016a.m19a((Object) "oauth_token");
                    String a4 = c0016a.m19a((Object) "oauth_token_secret");
                    c0016a.m26c("oauth_token");
                    c0016a.m26c("oauth_token_secret");
                    this.f14d = c0016a;
                    if (a22 == null || a4 == null) {
                        throw new C0013c("Request token or token secret not set in server reply. The service provider you use is probably buggy.");
                    }
                    c0009d.setTokenWithSecret(a22, a4);
                    try {
                        mo3b(a);
                    } catch (Exception e42) {
                        throw new C0012a(e42);
                    }
                } else {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a3.mo12a()));
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        stringBuilder.append(readLine);
                    }
                    switch (b) {
                        case 401:
                            throw new C0015e(stringBuilder.toString());
                        default:
                            throw new C0012a("Service provider responded in error: " + b + " (" + a3.mo14c() + ")", stringBuilder.toString());
                    }
                }
            } catch (C0015e e5) {
                e2 = e5;
                c0004b = a;
                try {
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    a = c0004b;
                }
            } catch (C0013c e6) {
                e3 = e6;
                try {
                    throw e3;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e7) {
                e42 = e7;
                throw new C0012a(e42);
            }
        } catch (C0015e e8) {
            e2 = e8;
            throw e2;
        } catch (C0013c e9) {
            e3 = e9;
            a = null;
            throw e3;
        } catch (Exception e10) {
            e42 = e10;
            a = null;
            throw new C0012a(e42);
        } catch (Throwable th4) {
            th = th4;
            a = null;
            try {
                mo3b(a);
                throw th;
            } catch (Exception e422) {
                throw new C0012a(e422);
            }
        }
    }

    protected abstract C0004b mo1a(String str);

    protected abstract C0006c mo2a(C0004b c0004b);

    public final String m6a(C0009d c0009d, String str) {
        c0009d.setTokenWithSecret(null, null);
        m3a(c0009d, this.f11a, "oauth_callback", str);
        String a = this.f14d.m19a((Object) "oauth_callback_confirmed");
        this.f14d.m26c("oauth_callback_confirmed");
        this.f16f = Boolean.TRUE.toString().equals(a);
        if (this.f16f) {
            return C0017c.m30a(this.f13c, "oauth_token", c0009d.getToken());
        }
        return C0017c.m30a(this.f13c, "oauth_token", c0009d.getToken(), "oauth_callback", str);
    }

    protected void mo3b(C0004b c0004b) {
    }

    public final void m8b(C0009d c0009d, String str) {
        if (c0009d.getToken() == null || c0009d.getTokenSecret() == null) {
            throw new C0013c("Authorized request token or token secret not set. Did you retrieve an authorized request token before?");
        } else if (!this.f16f || str == null) {
            m3a(c0009d, this.f12b, new String[0]);
        } else {
            m3a(c0009d, this.f12b, "oauth_verifier", str);
        }
    }
}
