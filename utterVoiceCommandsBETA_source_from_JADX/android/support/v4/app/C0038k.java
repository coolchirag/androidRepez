package android.support.v4.app;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.p008c.C0057a;
import android.support.v4.p008c.C0058b;
import android.util.Log;
import android.util.SparseArray;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

final class C0038k extends C0037j {
    static final Interpolator f132A = new AccelerateInterpolator(1.5f);
    static boolean f133a = false;
    static final boolean f134b;
    static final Interpolator f135x = new DecelerateInterpolator(2.5f);
    static final Interpolator f136y = new DecelerateInterpolator(1.5f);
    static final Interpolator f137z = new AccelerateInterpolator(2.5f);
    ArrayList<Runnable> f138c;
    Runnable[] f139d;
    boolean f140e;
    ArrayList<C0032e> f141f;
    ArrayList<C0032e> f142g;
    ArrayList<Integer> f143h;
    ArrayList<C0028a> f144i;
    ArrayList<C0032e> f145j;
    ArrayList<C0028a> f146k;
    ArrayList<Integer> f147l;
    ArrayList<OnBackStackChangedListener> f148m;
    int f149n = 0;
    FragmentActivity f150o;
    boolean f151p;
    boolean f152q;
    boolean f153r;
    String f154s;
    boolean f155t;
    Bundle f156u = null;
    SparseArray<Parcelable> f157v = null;
    Runnable f158w = new C0039l(this);

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f134b = z;
    }

    C0038k() {
    }

    private static Animation m91a(float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f136y);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    private static Animation m92a(float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f135x);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f136y);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private Animation m93a(C0032e c0032e, int i, boolean z, int i2) {
        int i3 = c0032e.f90E;
        C0032e.m63h();
        if (c0032e.f90E != 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f150o, c0032e.f90E);
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        Object obj = -1;
        switch (i) {
            case 4097:
                if (!z) {
                    obj = 2;
                    break;
                }
                obj = 1;
                break;
            case 4099:
                if (!z) {
                    obj = 6;
                    break;
                }
                obj = 5;
                break;
            case 8194:
                if (!z) {
                    obj = 4;
                    break;
                }
                obj = 3;
                break;
        }
        if (obj < null) {
            return null;
        }
        FragmentActivity fragmentActivity;
        switch (obj) {
            case 1:
                fragmentActivity = this.f150o;
                return C0038k.m92a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                fragmentActivity = this.f150o;
                return C0038k.m92a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                fragmentActivity = this.f150o;
                return C0038k.m92a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                fragmentActivity = this.f150o;
                return C0038k.m92a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                fragmentActivity = this.f150o;
                return C0038k.m91a(0.0f, 1.0f);
            case 6:
                fragmentActivity = this.f150o;
                return C0038k.m91a(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f150o.getWindow() != null) {
                    i2 = this.f150o.getWindow().getAttributes().windowAnimations;
                }
                return i2 == 0 ? null : null;
        }
    }

    private void m94a(int i, C0028a c0028a) {
        synchronized (this) {
            if (this.f146k == null) {
                this.f146k = new ArrayList();
            }
            int size = this.f146k.size();
            if (i < size) {
                if (f133a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0028a);
                }
                this.f146k.set(i, c0028a);
            } else {
                while (size < i) {
                    this.f146k.add(null);
                    if (this.f147l == null) {
                        this.f147l = new ArrayList();
                    }
                    if (f133a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f147l.add(Integer.valueOf(size));
                    size++;
                }
                if (f133a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0028a);
                }
                this.f146k.add(c0028a);
            }
        }
    }

    private void m95b(C0032e c0032e) {
        if (c0032e.f93H != null) {
            if (this.f157v == null) {
                this.f157v = new SparseArray();
            } else {
                this.f157v.clear();
            }
            c0032e.f93H.saveHierarchyState(this.f157v);
            if (this.f157v.size() > 0) {
                c0032e.f103e = this.f157v;
                this.f157v = null;
            }
        }
    }

    public static int m96c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void m97d(int i) {
        m102a(i, 0, 0, false);
    }

    private void m98t() {
        if (this.f141f != null) {
            for (int i = 0; i < this.f141f.size(); i++) {
                C0032e c0032e = (C0032e) this.f141f.get(i);
                if (c0032e != null && c0032e.f94I) {
                    if (this.f140e) {
                        this.f155t = true;
                    } else {
                        c0032e.f94I = false;
                        m109a(c0032e, this.f149n, 0, 0);
                    }
                }
            }
        }
    }

    private void m99u() {
        if (this.f148m != null) {
            for (int i = 0; i < this.f148m.size(); i++) {
                this.f148m.get(i);
            }
        }
    }

    public final C0032e m100a(int i) {
        if (this.f141f != null) {
            int size;
            C0032e c0032e;
            for (size = this.f142g.size() - 1; size >= 0; size--) {
                c0032e = (C0032e) this.f142g.get(size);
                if (c0032e != null && c0032e.f119u == i) {
                    return c0032e;
                }
            }
            for (size = this.f141f.size() - 1; size >= 0; size--) {
                c0032e = (C0032e) this.f141f.get(size);
                if (c0032e != null && c0032e.f119u == i) {
                    return c0032e;
                }
            }
        }
        return null;
    }

    public final C0032e m101a(String str) {
        if (!(this.f141f == null || str == null)) {
            int size;
            C0032e c0032e;
            for (size = this.f142g.size() - 1; size >= 0; size--) {
                c0032e = (C0032e) this.f142g.get(size);
                if (c0032e != null && str.equals(c0032e.f121w)) {
                    return c0032e;
                }
            }
            for (size = this.f141f.size() - 1; size >= 0; size--) {
                c0032e = (C0032e) this.f141f.get(size);
                if (c0032e != null && str.equals(c0032e.f121w)) {
                    return c0032e;
                }
            }
        }
        return null;
    }

    final void m102a(int i, int i2, int i3, boolean z) {
        if (this.f150o == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || this.f149n != i) {
            this.f149n = i;
            if (this.f141f != null) {
                int i4 = 0;
                for (int i5 = 0; i5 < this.f141f.size(); i5++) {
                    C0032e c0032e = (C0032e) this.f141f.get(i5);
                    if (c0032e != null) {
                        m109a(c0032e, i, i2, i3);
                        if (c0032e.f96K != null) {
                            i4 |= c0032e.f96K.mo27a();
                        }
                    }
                }
                if (i4 == 0) {
                    m98t();
                }
                if (this.f151p && this.f150o != null && this.f149n == 5) {
                    this.f150o.m47a();
                    this.f151p = false;
                }
            }
        }
    }

    public final void m103a(Configuration configuration) {
        if (this.f141f != null) {
            for (int i = 0; i < this.f142g.size(); i++) {
                C0032e c0032e = (C0032e) this.f142g.get(i);
                if (c0032e != null) {
                    c0032e.onConfigurationChanged(configuration);
                }
            }
        }
    }

    final void m104a(Parcelable parcelable, ArrayList<C0032e> arrayList) {
        int i = 0;
        if (parcelable != null) {
            C0041n c0041n = (C0041n) parcelable;
            if (c0041n.f163a != null) {
                int i2;
                C0032e c0032e;
                if (arrayList != null) {
                    for (i2 = 0; i2 < arrayList.size(); i2++) {
                        c0032e = (C0032e) arrayList.get(i2);
                        if (f133a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + c0032e);
                        }
                        C0043p c0043p = c0041n.f163a[c0032e.f104f];
                        c0043p.f177k = c0032e;
                        c0032e.f103e = null;
                        c0032e.f116r = 0;
                        c0032e.f114p = false;
                        c0032e.f110l = false;
                        c0032e.f107i = null;
                        if (c0043p.f176j != null) {
                            c0043p.f176j.setClassLoader(this.f150o.getClassLoader());
                            c0032e.f103e = c0043p.f176j.getSparseParcelableArray("android:view_state");
                        }
                    }
                }
                this.f141f = new ArrayList(c0041n.f163a.length);
                if (this.f143h != null) {
                    this.f143h.clear();
                }
                for (int i3 = 0; i3 < c0041n.f163a.length; i3++) {
                    C0043p c0043p2 = c0041n.f163a[i3];
                    if (c0043p2 != null) {
                        C0032e a = c0043p2.m136a(this.f150o);
                        if (f133a) {
                            Log.v("FragmentManager", "restoreAllState: adding #" + i3 + ": " + a);
                        }
                        this.f141f.add(a);
                        c0043p2.f177k = null;
                    } else {
                        if (f133a) {
                            Log.v("FragmentManager", "restoreAllState: adding #" + i3 + ": (null)");
                        }
                        this.f141f.add(null);
                        if (this.f143h == null) {
                            this.f143h = new ArrayList();
                        }
                        if (f133a) {
                            Log.v("FragmentManager", "restoreAllState: adding avail #" + i3);
                        }
                        this.f143h.add(Integer.valueOf(i3));
                    }
                }
                if (arrayList != null) {
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        c0032e = (C0032e) arrayList.get(i4);
                        if (c0032e.f108j >= 0) {
                            if (c0032e.f108j < this.f141f.size()) {
                                c0032e.f107i = (C0032e) this.f141f.get(c0032e.f108j);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + c0032e + " target no longer exists: " + c0032e.f108j);
                                c0032e.f107i = null;
                            }
                        }
                    }
                }
                if (c0041n.f164b != null) {
                    this.f142g = new ArrayList(c0041n.f164b.length);
                    for (i2 = 0; i2 < c0041n.f164b.length; i2++) {
                        c0032e = (C0032e) this.f141f.get(c0041n.f164b[i2]);
                        if (c0032e == null) {
                            throw new IllegalStateException("No instantiated fragment for index #" + c0041n.f164b[i2]);
                        }
                        c0032e.f110l = true;
                        if (f133a) {
                            Log.v("FragmentManager", "restoreAllState: making added #" + i2 + ": " + c0032e);
                        }
                        this.f142g.add(c0032e);
                    }
                } else {
                    this.f142g = null;
                }
                if (c0041n.f165c != null) {
                    this.f144i = new ArrayList(c0041n.f165c.length);
                    while (i < c0041n.f165c.length) {
                        C0028a a2 = c0041n.f165c[i].m58a(this);
                        if (f133a) {
                            Log.v("FragmentManager", "restoreAllState: adding bse #" + i + " (index " + a2.f61o + "): " + a2);
                        }
                        this.f144i.add(a2);
                        if (a2.f61o >= 0) {
                            m94a(a2.f61o, a2);
                        }
                        i++;
                    }
                    return;
                }
                this.f144i = null;
            }
        }
    }

    public final void m105a(FragmentActivity fragmentActivity) {
        if (this.f150o != null) {
            throw new IllegalStateException();
        }
        this.f150o = fragmentActivity;
    }

    final void m106a(C0028a c0028a) {
        if (this.f144i == null) {
            this.f144i = new ArrayList();
        }
        this.f144i.add(c0028a);
        m99u();
    }

    final void m107a(C0032e c0032e) {
        m109a(c0032e, this.f149n, 0, 0);
    }

    public final void m108a(C0032e c0032e, int i, int i2) {
        int i3 = 0;
        if (f133a) {
            Log.v("FragmentManager", "remove: " + c0032e + " nesting=" + c0032e.f116r);
        }
        boolean z = !c0032e.m78b();
        if (!c0032e.f123y || z) {
            this.f142g.remove(c0032e);
            if (c0032e.f87B && c0032e.f88C) {
                this.f151p = true;
            }
            c0032e.f110l = false;
            c0032e.f111m = true;
            if (!z) {
                i3 = 1;
            }
            m109a(c0032e, i3, i, i2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m109a(android.support.v4.app.C0032e r9, int r10, int r11, int r12) {
        /*
        r8 = this;
        r7 = 4;
        r2 = 3;
        r1 = 1;
        r3 = 0;
        r6 = 0;
        r0 = r9.f110l;
        if (r0 != 0) goto L_0x000c;
    L_0x0009:
        if (r10 <= r1) goto L_0x000c;
    L_0x000b:
        r10 = r1;
    L_0x000c:
        r0 = r9.f111m;
        if (r0 == 0) goto L_0x0016;
    L_0x0010:
        r0 = r9.f99a;
        if (r10 <= r0) goto L_0x0016;
    L_0x0014:
        r10 = r9.f99a;
    L_0x0016:
        r0 = r9.f94I;
        if (r0 == 0) goto L_0x0021;
    L_0x001a:
        r0 = r9.f99a;
        if (r0 >= r7) goto L_0x0021;
    L_0x001e:
        if (r10 <= r2) goto L_0x0021;
    L_0x0020:
        r10 = r2;
    L_0x0021:
        r0 = r9.f99a;
        if (r0 >= r10) goto L_0x02cf;
    L_0x0025:
        r0 = r9.f113o;
        if (r0 == 0) goto L_0x002e;
    L_0x0029:
        r0 = r9.f114p;
        if (r0 != 0) goto L_0x002e;
    L_0x002d:
        return;
    L_0x002e:
        r0 = r9.f100b;
        if (r0 == 0) goto L_0x0039;
    L_0x0032:
        r9.f100b = r3;
        r0 = r9.f101c;
        r8.m109a(r9, r0, r6, r6);
    L_0x0039:
        r0 = r9.f99a;
        switch(r0) {
            case 0: goto L_0x0041;
            case 1: goto L_0x017b;
            case 2: goto L_0x024b;
            case 3: goto L_0x024b;
            case 4: goto L_0x0289;
            default: goto L_0x003e;
        };
    L_0x003e:
        r9.f99a = r10;
        goto L_0x002d;
    L_0x0041:
        r0 = f133a;
        if (r0 == 0) goto L_0x0059;
    L_0x0045:
        r0 = "FragmentManager";
        r4 = new java.lang.StringBuilder;
        r5 = "moveto CREATED: ";
        r4.<init>(r5);
        r4 = r4.append(r9);
        r4 = r4.toString();
        android.util.Log.v(r0, r4);
    L_0x0059:
        r0 = r9.f102d;
        if (r0 == 0) goto L_0x0097;
    L_0x005d:
        r0 = r9.f102d;
        r4 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r4);
        r9.f103e = r0;
        r0 = r9.f102d;
        r4 = "android:target_state";
        r5 = -1;
        r5 = r0.getInt(r4, r5);
        r0 = -1;
        if (r5 != r0) goto L_0x00c7;
    L_0x0073:
        r0 = r3;
    L_0x0074:
        r9.f107i = r0;
        r0 = r9.f107i;
        if (r0 == 0) goto L_0x0084;
    L_0x007a:
        r0 = r9.f102d;
        r4 = "android:target_req_state";
        r0 = r0.getInt(r4, r6);
        r9.f109k = r0;
    L_0x0084:
        r0 = r9.f102d;
        r4 = "android:user_visible_hint";
        r0 = r0.getBoolean(r4, r1);
        r9.f95J = r0;
        r0 = r9.f95J;
        if (r0 != 0) goto L_0x0097;
    L_0x0092:
        r9.f94I = r1;
        if (r10 <= r2) goto L_0x0097;
    L_0x0096:
        r10 = r2;
    L_0x0097:
        r0 = r8.f150o;
        r9.f118t = r0;
        r0 = r8.f150o;
        r0 = r0.f36b;
        r9.f117s = r0;
        r9.f89D = r6;
        r0 = r8.f150o;
        r9.m81g();
        r0 = r9.f89D;
        if (r0 != 0) goto L_0x0117;
    L_0x00ac:
        r0 = new android.support.v4.app.ad;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00c7:
        r0 = r8.f141f;
        r0 = r0.size();
        if (r5 < r0) goto L_0x00ee;
    L_0x00cf:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragement no longer exists for key ";
        r1.<init>(r2);
        r1 = r1.append(r4);
        r2 = ": index ";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00ee:
        r0 = r8.f141f;
        r0 = r0.get(r5);
        r0 = (android.support.v4.app.C0032e) r0;
        if (r0 != 0) goto L_0x0074;
    L_0x00f8:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragement no longer exists for key ";
        r1.<init>(r2);
        r1 = r1.append(r4);
        r2 = ": index ";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0117:
        r0 = r8.f150o;
        android.support.v4.app.FragmentActivity.m46b();
        r0 = r9.f86A;
        if (r0 != 0) goto L_0x0146;
    L_0x0120:
        r9.f89D = r6;
        r0 = r9.f102d;
        r9.m82i();
        r0 = r9.f89D;
        if (r0 != 0) goto L_0x0146;
    L_0x012b:
        r0 = new android.support.v4.app.ad;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " did not call through to super.onCreate()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0146:
        r9.f86A = r6;
        r0 = r9.f113o;
        if (r0 == 0) goto L_0x017b;
    L_0x014c:
        r0 = r9.f102d;
        r9.m79e();
        r0 = r9.f102d;
        r0 = android.support.v4.app.C0032e.m64j();
        r9.f92G = r0;
        r0 = r9.f92G;
        if (r0 == 0) goto L_0x01d2;
    L_0x015d:
        r0 = r9.f92G;
        r9.f93H = r0;
        r0 = r9.f92G;
        r0 = android.support.v4.app.C0050x.m162a(r0);
        r9.f92G = r0;
        r0 = r9.f122x;
        if (r0 == 0) goto L_0x0174;
    L_0x016d:
        r0 = r9.f92G;
        r4 = 8;
        r0.setVisibility(r4);
    L_0x0174:
        r0 = r9.f92G;
        r0 = r9.f102d;
        android.support.v4.app.C0032e.m65k();
    L_0x017b:
        if (r10 <= r1) goto L_0x024b;
    L_0x017d:
        r0 = f133a;
        if (r0 == 0) goto L_0x0195;
    L_0x0181:
        r0 = "FragmentManager";
        r4 = new java.lang.StringBuilder;
        r5 = "moveto ACTIVITY_CREATED: ";
        r4.<init>(r5);
        r4 = r4.append(r9);
        r4 = r4.toString();
        android.util.Log.v(r0, r4);
    L_0x0195:
        r0 = r9.f113o;
        if (r0 != 0) goto L_0x0219;
    L_0x0199:
        r0 = r9.f120v;
        if (r0 == 0) goto L_0x01d5;
    L_0x019d:
        r0 = r8.f150o;
        r4 = r9.f120v;
        r0 = r0.findViewById(r4);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01d6;
    L_0x01a9:
        r4 = r9.f115q;
        if (r4 != 0) goto L_0x01d6;
    L_0x01ad:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "No view found for id 0x";
        r1.<init>(r2);
        r2 = r9.f120v;
        r2 = java.lang.Integer.toHexString(r2);
        r1 = r1.append(r2);
        r2 = " for fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r9);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x01d2:
        r9.f93H = r3;
        goto L_0x017b;
    L_0x01d5:
        r0 = r3;
    L_0x01d6:
        r9.f91F = r0;
        r4 = r9.f102d;
        r9.m79e();
        r4 = r9.f102d;
        r4 = android.support.v4.app.C0032e.m64j();
        r9.f92G = r4;
        r4 = r9.f92G;
        if (r4 == 0) goto L_0x023f;
    L_0x01e9:
        r4 = r9.f92G;
        r9.f93H = r4;
        r4 = r9.f92G;
        r4 = android.support.v4.app.C0050x.m162a(r4);
        r9.f92G = r4;
        if (r0 == 0) goto L_0x0207;
    L_0x01f7:
        r4 = r8.m93a(r9, r11, r1, r12);
        if (r4 == 0) goto L_0x0202;
    L_0x01fd:
        r5 = r9.f92G;
        r5.startAnimation(r4);
    L_0x0202:
        r4 = r9.f92G;
        r0.addView(r4);
    L_0x0207:
        r0 = r9.f122x;
        if (r0 == 0) goto L_0x0212;
    L_0x020b:
        r0 = r9.f92G;
        r4 = 8;
        r0.setVisibility(r4);
    L_0x0212:
        r0 = r9.f92G;
        r0 = r9.f102d;
        android.support.v4.app.C0032e.m65k();
    L_0x0219:
        r9.f89D = r6;
        r0 = r9.f102d;
        r9.m83l();
        r0 = r9.f89D;
        if (r0 != 0) goto L_0x0242;
    L_0x0224:
        r0 = new android.support.v4.app.ad;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " did not call through to super.onActivityCreated()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x023f:
        r9.f93H = r3;
        goto L_0x0219;
    L_0x0242:
        r0 = r9.f92G;
        if (r0 == 0) goto L_0x0249;
    L_0x0246:
        r9.m75a();
    L_0x0249:
        r9.f102d = r3;
    L_0x024b:
        if (r10 <= r2) goto L_0x0289;
    L_0x024d:
        r0 = f133a;
        if (r0 == 0) goto L_0x0265;
    L_0x0251:
        r0 = "FragmentManager";
        r2 = new java.lang.StringBuilder;
        r4 = "moveto STARTED: ";
        r2.<init>(r4);
        r2 = r2.append(r9);
        r2 = r2.toString();
        android.util.Log.v(r0, r2);
    L_0x0265:
        r9.f89D = r6;
        r9.m89y();
        r0 = r9.f89D;
        if (r0 != 0) goto L_0x0289;
    L_0x026e:
        r0 = new android.support.v4.app.ad;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " did not call through to super.onStart()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0289:
        if (r10 <= r7) goto L_0x003e;
    L_0x028b:
        r0 = f133a;
        if (r0 == 0) goto L_0x02a3;
    L_0x028f:
        r0 = "FragmentManager";
        r2 = new java.lang.StringBuilder;
        r4 = "moveto RESUMED: ";
        r2.<init>(r4);
        r2 = r2.append(r9);
        r2 = r2.toString();
        android.util.Log.v(r0, r2);
    L_0x02a3:
        r9.f89D = r6;
        r9.f112n = r1;
        r9.m84m();
        r0 = r9.f89D;
        if (r0 != 0) goto L_0x02c9;
    L_0x02ae:
        r0 = new android.support.v4.app.ad;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " did not call through to super.onResume()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x02c9:
        r9.f102d = r3;
        r9.f103e = r3;
        goto L_0x003e;
    L_0x02cf:
        r0 = r9.f99a;
        if (r0 <= r10) goto L_0x003e;
    L_0x02d3:
        r0 = r9.f99a;
        switch(r0) {
            case 1: goto L_0x02da;
            case 2: goto L_0x0390;
            case 3: goto L_0x0373;
            case 4: goto L_0x0335;
            case 5: goto L_0x02f4;
            default: goto L_0x02d8;
        };
    L_0x02d8:
        goto L_0x003e;
    L_0x02da:
        if (r10 > 0) goto L_0x003e;
    L_0x02dc:
        r0 = r8.f153r;
        if (r0 == 0) goto L_0x02eb;
    L_0x02e0:
        r0 = r9.f100b;
        if (r0 == 0) goto L_0x02eb;
    L_0x02e4:
        r0 = r9.f100b;
        r9.f100b = r3;
        r0.clearAnimation();
    L_0x02eb:
        r0 = r9.f100b;
        if (r0 == 0) goto L_0x041a;
    L_0x02ef:
        r9.f101c = r10;
        r10 = r1;
        goto L_0x003e;
    L_0x02f4:
        r0 = 5;
        if (r10 >= r0) goto L_0x0335;
    L_0x02f7:
        r0 = f133a;
        if (r0 == 0) goto L_0x030f;
    L_0x02fb:
        r0 = "FragmentManager";
        r4 = new java.lang.StringBuilder;
        r5 = "movefrom RESUMED: ";
        r4.<init>(r5);
        r4 = r4.append(r9);
        r4 = r4.toString();
        android.util.Log.v(r0, r4);
    L_0x030f:
        r9.f89D = r6;
        r9.m85o();
        r0 = r9.f89D;
        if (r0 != 0) goto L_0x0333;
    L_0x0318:
        r0 = new android.support.v4.app.ad;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " did not call through to super.onPause()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0333:
        r9.f112n = r6;
    L_0x0335:
        if (r10 >= r7) goto L_0x0373;
    L_0x0337:
        r0 = f133a;
        if (r0 == 0) goto L_0x034f;
    L_0x033b:
        r0 = "FragmentManager";
        r4 = new java.lang.StringBuilder;
        r5 = "movefrom STARTED: ";
        r4.<init>(r5);
        r4 = r4.append(r9);
        r4 = r4.toString();
        android.util.Log.v(r0, r4);
    L_0x034f:
        r9.f89D = r6;
        r9.m90z();
        r0 = r9.f89D;
        if (r0 != 0) goto L_0x0373;
    L_0x0358:
        r0 = new android.support.v4.app.ad;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " did not call through to super.onStop()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0373:
        if (r10 >= r2) goto L_0x0390;
    L_0x0375:
        r0 = f133a;
        if (r0 == 0) goto L_0x038d;
    L_0x0379:
        r0 = "FragmentManager";
        r2 = new java.lang.StringBuilder;
        r4 = "movefrom STOPPED: ";
        r2.<init>(r4);
        r2 = r2.append(r9);
        r2 = r2.toString();
        android.util.Log.v(r0, r2);
    L_0x038d:
        r9.m73A();
    L_0x0390:
        r0 = 2;
        if (r10 >= r0) goto L_0x02da;
    L_0x0393:
        r0 = f133a;
        if (r0 == 0) goto L_0x03ab;
    L_0x0397:
        r0 = "FragmentManager";
        r2 = new java.lang.StringBuilder;
        r4 = "movefrom ACTIVITY_CREATED: ";
        r2.<init>(r4);
        r2 = r2.append(r9);
        r2 = r2.toString();
        android.util.Log.v(r0, r2);
    L_0x03ab:
        r0 = r9.f92G;
        if (r0 == 0) goto L_0x03be;
    L_0x03af:
        r0 = r8.f150o;
        r0 = r0.isFinishing();
        if (r0 != 0) goto L_0x03be;
    L_0x03b7:
        r0 = r9.f103e;
        if (r0 != 0) goto L_0x03be;
    L_0x03bb:
        r8.m95b(r9);
    L_0x03be:
        r9.f89D = r6;
        r9.m74B();
        r0 = r9.f89D;
        if (r0 != 0) goto L_0x03e2;
    L_0x03c7:
        r0 = new android.support.v4.app.ad;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " did not call through to super.onDestroyView()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03e2:
        r0 = r9.f92G;
        if (r0 == 0) goto L_0x0412;
    L_0x03e6:
        r0 = r9.f91F;
        if (r0 == 0) goto L_0x0412;
    L_0x03ea:
        r0 = r8.f149n;
        if (r0 <= 0) goto L_0x04cf;
    L_0x03ee:
        r0 = r8.f153r;
        if (r0 != 0) goto L_0x04cf;
    L_0x03f2:
        r0 = r8.m93a(r9, r11, r6, r12);
    L_0x03f6:
        if (r0 == 0) goto L_0x040b;
    L_0x03f8:
        r2 = r9.f92G;
        r9.f100b = r2;
        r9.f101c = r10;
        r2 = new android.support.v4.app.m;
        r2.<init>(r8, r9);
        r0.setAnimationListener(r2);
        r2 = r9.f92G;
        r2.startAnimation(r0);
    L_0x040b:
        r0 = r9.f91F;
        r2 = r9.f92G;
        r0.removeView(r2);
    L_0x0412:
        r9.f91F = r3;
        r9.f92G = r3;
        r9.f93H = r3;
        goto L_0x02da;
    L_0x041a:
        r0 = f133a;
        if (r0 == 0) goto L_0x0432;
    L_0x041e:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom CREATED: ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0432:
        r0 = r9.f86A;
        if (r0 != 0) goto L_0x045a;
    L_0x0436:
        r9.f89D = r6;
        r9.m86p();
        r0 = r9.f89D;
        if (r0 != 0) goto L_0x045a;
    L_0x043f:
        r0 = new android.support.v4.app.ad;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " did not call through to super.onDestroy()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x045a:
        r9.f89D = r6;
        r9.m88r();
        r0 = r9.f89D;
        if (r0 != 0) goto L_0x047e;
    L_0x0463:
        r0 = new android.support.v4.app.ad;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x047e:
        r0 = r9.f86A;
        if (r0 != 0) goto L_0x04c9;
    L_0x0482:
        r0 = r9.f104f;
        if (r0 < 0) goto L_0x003e;
    L_0x0486:
        r0 = f133a;
        if (r0 == 0) goto L_0x04a0;
    L_0x048a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "Freeing fragment index ";
        r1.<init>(r2);
        r2 = r9.f104f;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x04a0:
        r0 = r8.f141f;
        r1 = r9.f104f;
        r0.set(r1, r3);
        r0 = r8.f143h;
        if (r0 != 0) goto L_0x04b2;
    L_0x04ab:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r8.f143h = r0;
    L_0x04b2:
        r0 = r8.f143h;
        r1 = r9.f104f;
        r1 = java.lang.Integer.valueOf(r1);
        r0.add(r1);
        r0 = r8.f150o;
        r1 = r9.f104f;
        r0.m48a(r1);
        r9.m87q();
        goto L_0x003e;
    L_0x04c9:
        r9.f118t = r3;
        r9.f117s = r3;
        goto L_0x003e;
    L_0x04cf:
        r0 = r3;
        goto L_0x03f6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.k.a(android.support.v4.app.e, int, int, int):void");
    }

    public final void m110a(C0032e c0032e, boolean z) {
        if (this.f142g == null) {
            this.f142g = new ArrayList();
        }
        if (f133a) {
            Log.v("FragmentManager", "add: " + c0032e);
        }
        if (c0032e.f104f < 0) {
            if (this.f143h == null || this.f143h.size() <= 0) {
                if (this.f141f == null) {
                    this.f141f = new ArrayList();
                }
                c0032e.m76a(this.f141f.size());
                this.f141f.add(c0032e);
            } else {
                c0032e.m76a(((Integer) this.f143h.remove(this.f143h.size() - 1)).intValue());
                this.f141f.set(c0032e.f104f, c0032e);
            }
        }
        if (!c0032e.f123y) {
            this.f142g.add(c0032e);
            c0032e.f110l = true;
            c0032e.f111m = false;
            if (c0032e.f87B && c0032e.f88C) {
                this.f151p = true;
            }
            if (z) {
                m107a(c0032e);
            }
        }
    }

    public final void m111a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter) {
        int size;
        int i;
        C0032e c0032e;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f141f != null) {
            size = this.f141f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    c0032e = (C0032e) this.f141f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0032e);
                    if (c0032e != null) {
                        c0032e.m77a(str2, printWriter);
                    }
                }
            }
        }
        if (this.f142g != null) {
            size = this.f142g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    c0032e = (C0032e) this.f142g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0032e.toString());
                }
            }
        }
        if (this.f145j != null) {
            size = this.f145j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    c0032e = (C0032e) this.f145j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0032e.toString());
                }
            }
        }
        if (this.f144i != null) {
            size = this.f144i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0028a c0028a = (C0028a) this.f144i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0028a.toString());
                    c0028a.m54a(str2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.f146k != null) {
                int size2 = this.f146k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0028a = (C0028a) this.f146k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0028a);
                    }
                }
            }
            if (this.f147l != null && this.f147l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f147l.toArray()));
            }
        }
        if (this.f138c != null) {
            i = this.f138c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f138c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f149n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f152q);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f153r);
        if (this.f151p) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f151p);
        }
        if (this.f154s != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f154s);
        }
        if (this.f143h != null && this.f143h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f143h.toArray()));
        }
    }

    public final boolean m112a() {
        if (this.f152q) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f154s != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f154s);
        } else {
            m115b();
            Handler handler = this.f150o.f35a;
            if (this.f144i == null) {
                return false;
            }
            int size = this.f144i.size() - 1;
            if (size < 0) {
                return false;
            }
            ((C0028a) this.f144i.remove(size)).m51a();
            m99u();
            return true;
        }
    }

    public final void m113b(int i) {
        synchronized (this) {
            this.f146k.set(i, null);
            if (this.f147l == null) {
                this.f147l = new ArrayList();
            }
            if (f133a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f147l.add(Integer.valueOf(i));
        }
    }

    public final void m114b(C0032e c0032e, int i, int i2) {
        if (f133a) {
            Log.v("FragmentManager", "hide: " + c0032e);
        }
        if (!c0032e.f122x) {
            c0032e.f122x = true;
            if (c0032e.f92G != null) {
                Animation a = m93a(c0032e, i, true, i2);
                if (a != null) {
                    c0032e.f92G.startAnimation(a);
                }
                c0032e.f92G.setVisibility(8);
            }
            if (c0032e.f110l && c0032e.f87B && c0032e.f88C) {
                this.f151p = true;
            }
            C0032e.m61c();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m115b() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f140e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f150o;
        r3 = r3.f35a;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0024;
    L_0x001c:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        monitor-enter(r6);
        r3 = r6.f138c;	 Catch:{ all -> 0x0097 }
        if (r3 == 0) goto L_0x0032;
    L_0x002a:
        r3 = r6.f138c;	 Catch:{ all -> 0x0097 }
        r3 = r3.size();	 Catch:{ all -> 0x0097 }
        if (r3 != 0) goto L_0x005a;
    L_0x0032:
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r0 = r6.f155t;
        if (r0 == 0) goto L_0x00a5;
    L_0x0037:
        r3 = r2;
        r4 = r2;
    L_0x0039:
        r0 = r6.f141f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x009e;
    L_0x0041:
        r0 = r6.f141f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.C0032e) r0;
        if (r0 == 0) goto L_0x0056;
    L_0x004b:
        r5 = r0.f96K;
        if (r5 == 0) goto L_0x0056;
    L_0x004f:
        r0 = r0.f96K;
        r0 = r0.mo27a();
        r4 = r4 | r0;
    L_0x0056:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0039;
    L_0x005a:
        r1 = r6.f138c;	 Catch:{ all -> 0x0097 }
        r3 = r1.size();	 Catch:{ all -> 0x0097 }
        r1 = r6.f139d;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0069;
    L_0x0064:
        r1 = r6.f139d;	 Catch:{ all -> 0x0097 }
        r1 = r1.length;	 Catch:{ all -> 0x0097 }
        if (r1 >= r3) goto L_0x006d;
    L_0x0069:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0097 }
        r6.f139d = r1;	 Catch:{ all -> 0x0097 }
    L_0x006d:
        r1 = r6.f138c;	 Catch:{ all -> 0x0097 }
        r4 = r6.f139d;	 Catch:{ all -> 0x0097 }
        r1.toArray(r4);	 Catch:{ all -> 0x0097 }
        r1 = r6.f138c;	 Catch:{ all -> 0x0097 }
        r1.clear();	 Catch:{ all -> 0x0097 }
        r1 = r6.f150o;	 Catch:{ all -> 0x0097 }
        r1 = r1.f35a;	 Catch:{ all -> 0x0097 }
        r4 = r6.f158w;	 Catch:{ all -> 0x0097 }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x0097 }
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r6.f140e = r0;
        r1 = r2;
    L_0x0086:
        if (r1 >= r3) goto L_0x009a;
    L_0x0088:
        r4 = r6.f139d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f139d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0086;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x009a:
        r6.f140e = r2;
        r1 = r0;
        goto L_0x0025;
    L_0x009e:
        if (r4 != 0) goto L_0x00a5;
    L_0x00a0:
        r6.f155t = r2;
        r6.m98t();
    L_0x00a5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.k.b():boolean");
    }

    final ArrayList<C0032e> m116c() {
        ArrayList<C0032e> arrayList = null;
        if (this.f141f != null) {
            for (int i = 0; i < this.f141f.size(); i++) {
                C0032e c0032e = (C0032e) this.f141f.get(i);
                if (c0032e != null && c0032e.f124z) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0032e);
                    c0032e.f86A = true;
                    c0032e.f108j = c0032e.f107i != null ? c0032e.f107i.f104f : -1;
                }
            }
        }
        return arrayList;
    }

    public final void m117c(C0032e c0032e, int i, int i2) {
        if (f133a) {
            Log.v("FragmentManager", "show: " + c0032e);
        }
        if (c0032e.f122x) {
            c0032e.f122x = false;
            if (c0032e.f92G != null) {
                Animation a = m93a(c0032e, i, true, i2);
                if (a != null) {
                    c0032e.f92G.startAnimation(a);
                }
                c0032e.f92G.setVisibility(0);
            }
            if (c0032e.f110l && c0032e.f87B && c0032e.f88C) {
                this.f151p = true;
            }
            C0032e.m61c();
        }
    }

    final Parcelable m118d() {
        C0030c[] c0030cArr = null;
        m115b();
        if (f134b) {
            this.f152q = true;
        }
        if (this.f141f == null || this.f141f.size() <= 0) {
            return null;
        }
        int size = this.f141f.size();
        C0043p[] c0043pArr = new C0043p[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            C0032e c0032e = (C0032e) this.f141f.get(i);
            if (c0032e != null) {
                C0043p c0043p = new C0043p(c0032e);
                c0043pArr[i] = c0043p;
                if (c0032e.f99a <= 0 || c0043p.f176j != null) {
                    c0043p.f176j = c0032e.f102d;
                } else {
                    if (this.f156u == null) {
                        this.f156u = new Bundle();
                    }
                    Bundle bundle = this.f156u;
                    C0032e.m66n();
                    if (this.f156u.isEmpty()) {
                        bundle = null;
                    } else {
                        bundle = this.f156u;
                        this.f156u = null;
                    }
                    if (c0032e.f92G != null) {
                        m95b(c0032e);
                    }
                    if (c0032e.f103e != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", c0032e.f103e);
                    }
                    if (!c0032e.f95J) {
                        bundle.putBoolean("android:user_visible_hint", c0032e.f95J);
                    }
                    c0043p.f176j = bundle;
                    if (c0032e.f107i != null) {
                        if (c0032e.f107i.f104f < 0) {
                            String str = "Failure saving state: " + c0032e + " has target not in fragment manager: " + c0032e.f107i;
                            Log.e("FragmentManager", str);
                            m111a("  ", null, new PrintWriter(new C0058b("FragmentManager")));
                            throw new IllegalStateException(str);
                        }
                        if (c0043p.f176j == null) {
                            c0043p.f176j = new Bundle();
                        }
                        bundle = c0043p.f176j;
                        String str2 = "android:target_state";
                        C0032e c0032e2 = c0032e.f107i;
                        if (c0032e2.f104f < 0) {
                            throw new IllegalStateException("Fragment " + c0032e2 + " is not currently in the FragmentManager");
                        }
                        bundle.putInt(str2, c0032e2.f104f);
                        if (c0032e.f109k != 0) {
                            c0043p.f176j.putInt("android:target_req_state", c0032e.f109k);
                        }
                    }
                }
                if (f133a) {
                    Log.v("FragmentManager", "Saved state of " + c0032e + ": " + c0043p.f176j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            C0041n c0041n;
            if (this.f142g != null) {
                i = this.f142g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((C0032e) this.f142g.get(i2)).f104f;
                        if (f133a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f142g.get(i2));
                        }
                    }
                    if (this.f144i != null) {
                        i = this.f144i.size();
                        if (i > 0) {
                            c0030cArr = new C0030c[i];
                            for (i2 = 0; i2 < i; i2++) {
                                c0030cArr[i2] = new C0030c((C0028a) this.f144i.get(i2));
                                if (f133a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f144i.get(i2));
                                }
                            }
                        }
                    }
                    c0041n = new C0041n();
                    c0041n.f163a = c0043pArr;
                    c0041n.f164b = iArr;
                    c0041n.f165c = c0030cArr;
                    return c0041n;
                }
            }
            iArr = null;
            if (this.f144i != null) {
                i = this.f144i.size();
                if (i > 0) {
                    c0030cArr = new C0030c[i];
                    for (i2 = 0; i2 < i; i2++) {
                        c0030cArr[i2] = new C0030c((C0028a) this.f144i.get(i2));
                        if (f133a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f144i.get(i2));
                        }
                    }
                }
            }
            c0041n = new C0041n();
            c0041n.f163a = c0043pArr;
            c0041n.f164b = iArr;
            c0041n.f165c = c0030cArr;
            return c0041n;
        } else if (!f133a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public final void m119d(C0032e c0032e, int i, int i2) {
        if (f133a) {
            Log.v("FragmentManager", "detach: " + c0032e);
        }
        if (!c0032e.f123y) {
            c0032e.f123y = true;
            if (c0032e.f110l) {
                this.f142g.remove(c0032e);
                if (c0032e.f87B && c0032e.f88C) {
                    this.f151p = true;
                }
                c0032e.f110l = false;
                m109a(c0032e, 1, i, i2);
            }
        }
    }

    public final void m120e() {
        this.f152q = false;
    }

    public final void m121e(C0032e c0032e, int i, int i2) {
        if (f133a) {
            Log.v("FragmentManager", "attach: " + c0032e);
        }
        if (c0032e.f123y) {
            c0032e.f123y = false;
            if (!c0032e.f110l) {
                this.f142g.add(c0032e);
                c0032e.f110l = true;
                if (c0032e.f87B && c0032e.f88C) {
                    this.f151p = true;
                }
                m109a(c0032e, this.f149n, i, i2);
            }
        }
    }

    public final void m122f() {
        this.f152q = false;
        m97d(1);
    }

    public final void m123g() {
        this.f152q = false;
        m97d(2);
    }

    public final void m124h() {
        this.f152q = false;
        m97d(4);
    }

    public final void m125i() {
        this.f152q = false;
        m97d(5);
    }

    public final void m126j() {
        m97d(4);
    }

    public final void m127k() {
        this.f152q = true;
        m97d(3);
    }

    public final void m128l() {
        m97d(2);
    }

    public final void m129m() {
        this.f153r = true;
        m115b();
        m97d(0);
        this.f150o = null;
    }

    public final void m130n() {
        if (this.f141f != null) {
            for (int i = 0; i < this.f142g.size(); i++) {
                C0032e c0032e = (C0032e) this.f142g.get(i);
                if (c0032e != null) {
                    c0032e.onLowMemory();
                }
            }
        }
    }

    public final boolean m131o() {
        boolean z;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f141f != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f142g.size()) {
                C0032e c0032e = (C0032e) this.f142g.get(i2);
                if (c0032e != null && !c0032e.f122x && c0032e.f87B && c0032e.f88C) {
                    z = true;
                    C0032e.m67s();
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0032e);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f145j != null) {
            while (i < this.f145j.size()) {
                c0032e = (C0032e) this.f145j.get(i);
                if (arrayList == null || !arrayList.contains(c0032e)) {
                    C0032e.m69u();
                }
                i++;
            }
        }
        this.f145j = arrayList;
        return z;
    }

    public final boolean m132p() {
        if (this.f141f == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f142g.size(); i++) {
            C0032e c0032e = (C0032e) this.f142g.get(i);
            if (c0032e != null && !c0032e.f122x && c0032e.f87B && c0032e.f88C) {
                z = true;
                C0032e.m68t();
            }
        }
        return z;
    }

    public final boolean m133q() {
        if (this.f141f != null) {
            for (int i = 0; i < this.f142g.size(); i++) {
                C0032e c0032e = (C0032e) this.f142g.get(i);
                if (c0032e != null && !c0032e.f122x && c0032e.f87B && c0032e.f88C) {
                    C0032e.m70v();
                }
            }
        }
        return false;
    }

    public final boolean m134r() {
        if (this.f141f != null) {
            for (int i = 0; i < this.f142g.size(); i++) {
                C0032e c0032e = (C0032e) this.f142g.get(i);
                if (!(c0032e == null || c0032e.f122x)) {
                    C0032e.m72x();
                }
            }
        }
        return false;
    }

    public final void m135s() {
        if (this.f141f != null) {
            for (int i = 0; i < this.f142g.size(); i++) {
                C0032e c0032e = (C0032e) this.f142g.get(i);
                if (c0032e != null && !c0032e.f122x && c0032e.f87B && c0032e.f88C) {
                    C0032e.m71w();
                }
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0057a.m173a(this.f150o, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
