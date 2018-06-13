package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p006a.C0025a;
import android.support.v4.p008c.C0057a;
import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class C0048v extends C0046t {
    static boolean f183a = false;
    final C0045s<C0049w> f184b;
    final C0045s<C0049w> f185c;
    FragmentActivity f186d;
    boolean f187e;
    boolean f188f;

    final void m148a(FragmentActivity fragmentActivity) {
        this.f186d = fragmentActivity;
    }

    public final void m149a(String str, PrintWriter printWriter) {
        int i = 0;
        if (this.f184b.m139a() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f184b.m139a(); i2++) {
                C0049w c0049w = (C0049w) this.f184b.m145e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f184b.m144d(i2));
                printWriter.print(": ");
                printWriter.println(c0049w.toString());
                c0049w.m160a(str2, printWriter);
            }
        }
        if (this.f185c.m139a() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f185c.m139a()) {
                c0049w = (C0049w) this.f185c.m145e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f185c.m144d(i));
                printWriter.print(": ");
                printWriter.println(c0049w.toString());
                c0049w.m160a(str3, printWriter);
                i++;
            }
        }
    }

    public final boolean mo27a() {
        int a = this.f184b.m139a();
        boolean z = false;
        for (int i = 0; i < a; i++) {
            C0049w c0049w = (C0049w) this.f184b.m145e(i);
            int i2 = (!c0049w.f196h || c0049w.f194f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    final void m151b() {
        if (f183a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f187e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f187e = true;
        for (int a = this.f184b.m139a() - 1; a >= 0; a--) {
            C0049w c0049w = (C0049w) this.f184b.m145e(a);
            if (c0049w.f197i && c0049w.f198j) {
                c0049w.f196h = true;
            } else if (c0049w.f196h) {
                continue;
            } else {
                int i;
                c0049w.f196h = true;
                if (f183a) {
                    Log.v("LoaderManager", "  Starting: " + c0049w);
                }
                if (c0049w.f192d == null && c0049w.f191c != null) {
                    C0047u c0047u = c0049w.f191c;
                    i = c0049w.f189a;
                    Bundle bundle = c0049w.f190b;
                    c0049w.f192d = c0047u.m147a();
                }
                if (c0049w.f192d == null) {
                    continue;
                } else if (!c0049w.f192d.getClass().isMemberClass() || Modifier.isStatic(c0049w.f192d.getClass().getModifiers())) {
                    if (!c0049w.f201m) {
                        C0025a c0025a = c0049w.f192d;
                        i = c0049w.f189a;
                        if (c0025a.f30b != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        c0025a.f30b = c0049w;
                        c0025a.f29a = i;
                        c0049w.f201m = true;
                    }
                    C0025a c0025a2 = c0049w.f192d;
                    c0025a2.f31c = true;
                    c0025a2.f33e = false;
                    c0025a2.f32d = false;
                } else {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + c0049w.f192d);
                }
            }
        }
    }

    final void m152c() {
        if (f183a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f187e) {
            for (int a = this.f184b.m139a() - 1; a >= 0; a--) {
                ((C0049w) this.f184b.m145e(a)).m158a();
            }
            this.f187e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    final void m153d() {
        if (f183a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f187e) {
            this.f188f = true;
            this.f187e = false;
            for (int a = this.f184b.m139a() - 1; a >= 0; a--) {
                C0049w c0049w = (C0049w) this.f184b.m145e(a);
                if (f183a) {
                    Log.v("LoaderManager", "  Retaining: " + c0049w);
                }
                c0049w.f197i = true;
                c0049w.f198j = c0049w.f196h;
                c0049w.f196h = false;
                c0049w.f191c = null;
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    final void m154e() {
        if (this.f188f) {
            if (f183a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f188f = false;
            for (int a = this.f184b.m139a() - 1; a >= 0; a--) {
                C0049w c0049w = (C0049w) this.f184b.m145e(a);
                if (c0049w.f197i) {
                    if (f183a) {
                        Log.v("LoaderManager", "  Finished Retaining: " + c0049w);
                    }
                    c0049w.f197i = false;
                    if (!(c0049w.f196h == c0049w.f198j || c0049w.f196h)) {
                        c0049w.m158a();
                    }
                }
                if (c0049w.f196h && c0049w.f193e && !c0049w.f199k) {
                    c0049w.m159a(c0049w.f192d, c0049w.f195g);
                }
            }
        }
    }

    final void m155f() {
        for (int a = this.f184b.m139a() - 1; a >= 0; a--) {
            ((C0049w) this.f184b.m145e(a)).f199k = true;
        }
    }

    final void m156g() {
        for (int a = this.f184b.m139a() - 1; a >= 0; a--) {
            C0049w c0049w = (C0049w) this.f184b.m145e(a);
            if (c0049w.f196h && c0049w.f199k) {
                c0049w.f199k = false;
                if (c0049w.f193e) {
                    c0049w.m159a(c0049w.f192d, c0049w.f195g);
                }
            }
        }
    }

    final void m157h() {
        int a;
        if (!this.f188f) {
            if (f183a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (a = this.f184b.m139a() - 1; a >= 0; a--) {
                ((C0049w) this.f184b.m145e(a)).m161b();
            }
        }
        if (f183a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (a = this.f185c.m139a() - 1; a >= 0; a--) {
            ((C0049w) this.f185c.m145e(a)).m161b();
        }
        this.f185c.m141b();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0057a.m173a(this.f186d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
