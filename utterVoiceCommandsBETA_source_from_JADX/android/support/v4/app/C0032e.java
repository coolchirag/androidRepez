package android.support.v4.app;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p008c.C0057a;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.PrintWriter;
import java.util.HashMap;

public final class C0032e implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final HashMap<String, Class<?>> f85N = new HashMap();
    boolean f86A;
    boolean f87B;
    boolean f88C = true;
    boolean f89D;
    int f90E;
    ViewGroup f91F;
    View f92G;
    View f93H;
    boolean f94I;
    boolean f95J = true;
    C0048v f96K;
    boolean f97L;
    boolean f98M;
    int f99a = 0;
    View f100b;
    int f101c;
    Bundle f102d;
    SparseArray<Parcelable> f103e;
    int f104f = -1;
    String f105g;
    Bundle f106h;
    C0032e f107i;
    int f108j = -1;
    int f109k;
    boolean f110l;
    boolean f111m;
    boolean f112n;
    boolean f113o;
    boolean f114p;
    boolean f115q;
    int f116r;
    C0038k f117s;
    FragmentActivity f118t;
    int f119u;
    int f120v;
    String f121w;
    boolean f122x;
    boolean f123y;
    boolean f124z;

    public static C0032e m59a(Context context, String str) {
        return C0032e.m60a(context, str, null);
    }

    public static C0032e m60a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f85N.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f85N.put(str, cls);
            }
            C0032e c0032e = (C0032e) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(c0032e.getClass().getClassLoader());
                c0032e.f106h = bundle;
            }
            return c0032e;
        } catch (Exception e) {
            throw new C0033f("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0033f("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0033f("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e22);
        }
    }

    public static void m61c() {
    }

    public static void m62d() {
    }

    public static Animation m63h() {
        return null;
    }

    public static View m64j() {
        return null;
    }

    public static void m65k() {
    }

    public static void m66n() {
    }

    public static void m67s() {
    }

    public static void m68t() {
    }

    public static void m69u() {
    }

    public static boolean m70v() {
        return false;
    }

    public static void m71w() {
    }

    public static boolean m72x() {
        return false;
    }

    final void m73A() {
        if (this.f97L) {
            this.f97L = false;
            if (!this.f98M) {
                this.f98M = true;
                FragmentActivity fragmentActivity = this.f118t;
                int i = this.f104f;
                boolean z = this.f97L;
                this.f96K = fragmentActivity.m50b(i);
            }
            if (this.f96K == null) {
                return;
            }
            if (this.f118t.f41g) {
                this.f96K.m153d();
            } else {
                this.f96K.m152c();
            }
        }
    }

    final void m74B() {
        this.f89D = true;
        if (this.f96K != null) {
            this.f96K.m155f();
        }
    }

    final void m75a() {
        if (this.f103e != null) {
            this.f93H.restoreHierarchyState(this.f103e);
            this.f103e = null;
        }
    }

    final void m76a(int i) {
        this.f104f = i;
        this.f105g = "android:fragment:" + this.f104f;
    }

    public final void m77a(String str, PrintWriter printWriter) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f119u));
        printWriter.print(" mContainerId#=");
        printWriter.print(Integer.toHexString(this.f120v));
        printWriter.print(" mTag=");
        printWriter.println(this.f121w);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f99a);
        printWriter.print(" mIndex=");
        printWriter.print(this.f104f);
        printWriter.print(" mWho=");
        printWriter.print(this.f105g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f116r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f110l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f111m);
        printWriter.print(" mResumed=");
        printWriter.print(this.f112n);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f113o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f114p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f122x);
        printWriter.print(" mDetached=");
        printWriter.print(this.f123y);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f88C);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f87B);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f124z);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f86A);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f95J);
        if (this.f117s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f117s);
        }
        if (this.f118t != null) {
            printWriter.print(str);
            printWriter.print("mActivity=");
            printWriter.println(this.f118t);
        }
        if (this.f106h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f106h);
        }
        if (this.f102d != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f102d);
        }
        if (this.f103e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f103e);
        }
        if (this.f107i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f107i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f109k);
        }
        if (this.f90E != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f90E);
        }
        if (this.f91F != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f91F);
        }
        if (this.f92G != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f92G);
        }
        if (this.f93H != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f92G);
        }
        if (this.f100b != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f100b);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f101c);
        }
        if (this.f96K != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f96K.m149a(str + "  ", printWriter);
        }
    }

    final boolean m78b() {
        return this.f116r > 0;
    }

    public final LayoutInflater m79e() {
        return this.f118t.getLayoutInflater();
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final void m80f() {
        this.f89D = true;
    }

    public final void m81g() {
        this.f89D = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void m82i() {
        this.f89D = true;
    }

    public final void m83l() {
        this.f89D = true;
    }

    public final void m84m() {
        this.f89D = true;
    }

    public final void m85o() {
        this.f89D = true;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        this.f89D = true;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        this.f118t.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public final void onLowMemory() {
        this.f89D = true;
    }

    public final void m86p() {
        this.f89D = true;
        if (!this.f98M) {
            this.f98M = true;
            FragmentActivity fragmentActivity = this.f118t;
            int i = this.f104f;
            boolean z = this.f97L;
            this.f96K = fragmentActivity.m50b(i);
        }
        if (this.f96K != null) {
            this.f96K.m157h();
        }
    }

    final void m87q() {
        this.f104f = -1;
        this.f105g = null;
        this.f110l = false;
        this.f111m = false;
        this.f112n = false;
        this.f113o = false;
        this.f114p = false;
        this.f115q = false;
        this.f116r = 0;
        this.f117s = null;
        this.f118t = null;
        this.f119u = 0;
        this.f120v = 0;
        this.f121w = null;
        this.f122x = false;
        this.f123y = false;
        this.f86A = false;
        this.f96K = null;
        this.f97L = false;
        this.f98M = false;
    }

    public final void m88r() {
        this.f89D = true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0057a.m173a(this, stringBuilder);
        if (this.f104f >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f104f);
        }
        if (this.f119u != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f119u));
        }
        if (this.f121w != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f121w);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    final void m89y() {
        this.f89D = true;
        if (!this.f97L) {
            this.f97L = true;
            if (!this.f98M) {
                this.f98M = true;
                FragmentActivity fragmentActivity = this.f118t;
                int i = this.f104f;
                boolean z = this.f97L;
                this.f96K = fragmentActivity.m50b(i);
            }
            if (this.f96K != null) {
                this.f96K.m151b();
            }
        }
        if (this.f96K != null) {
            this.f96K.m156g();
        }
    }

    final void m90z() {
        this.f89D = true;
    }
}
