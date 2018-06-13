package android.support.v4.app;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

final class C0028a extends C0027r implements Runnable {
    final C0038k f47a;
    C0029b f48b;
    C0029b f49c;
    int f50d;
    int f51e;
    int f52f;
    int f53g;
    int f54h;
    int f55i;
    int f56j;
    boolean f57k;
    boolean f58l = true;
    String f59m;
    boolean f60n;
    int f61o;
    int f62p;
    CharSequence f63q;
    int f64r;
    CharSequence f65s;

    public C0028a(C0038k c0038k) {
        this.f47a = c0038k;
    }

    public final void m51a() {
        if (C0038k.f133a) {
            Log.v("BackStackEntry", "popFromBackStack: " + this);
        }
        m52a(-1);
        for (C0029b c0029b = this.f49c; c0029b != null; c0029b = c0029b.f67b) {
            C0032e c0032e;
            switch (c0029b.f68c) {
                case 1:
                    c0032e = c0029b.f69d;
                    c0032e.f90E = c0029b.f73h;
                    this.f47a.m108a(c0032e, C0038k.m96c(this.f55i), this.f56j);
                    break;
                case 2:
                    c0032e = c0029b.f69d;
                    c0032e.f90E = c0029b.f73h;
                    this.f47a.m108a(c0032e, C0038k.m96c(this.f55i), this.f56j);
                    if (c0029b.f74i == null) {
                        break;
                    }
                    for (int i = 0; i < c0029b.f74i.size(); i++) {
                        c0032e = (C0032e) c0029b.f74i.get(i);
                        c0032e.f90E = c0029b.f72g;
                        this.f47a.m110a(c0032e, false);
                    }
                    break;
                case 3:
                    c0032e = c0029b.f69d;
                    c0032e.f90E = c0029b.f72g;
                    this.f47a.m110a(c0032e, false);
                    break;
                case 4:
                    c0032e = c0029b.f69d;
                    c0032e.f90E = c0029b.f72g;
                    this.f47a.m117c(c0032e, C0038k.m96c(this.f55i), this.f56j);
                    break;
                case 5:
                    c0032e = c0029b.f69d;
                    c0032e.f90E = c0029b.f73h;
                    this.f47a.m114b(c0032e, C0038k.m96c(this.f55i), this.f56j);
                    break;
                case 6:
                    c0032e = c0029b.f69d;
                    c0032e.f90E = c0029b.f72g;
                    this.f47a.m121e(c0032e, C0038k.m96c(this.f55i), this.f56j);
                    break;
                case 7:
                    c0032e = c0029b.f69d;
                    c0032e.f90E = c0029b.f72g;
                    this.f47a.m119d(c0032e, C0038k.m96c(this.f55i), this.f56j);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0029b.f68c);
            }
        }
        this.f47a.m102a(this.f47a.f149n, C0038k.m96c(this.f55i), this.f56j, true);
        if (this.f61o >= 0) {
            this.f47a.m113b(this.f61o);
            this.f61o = -1;
        }
    }

    final void m52a(int i) {
        if (this.f57k) {
            if (C0038k.f133a) {
                Log.v("BackStackEntry", "Bump nesting in " + this + " by " + i);
            }
            for (C0029b c0029b = this.f48b; c0029b != null; c0029b = c0029b.f66a) {
                C0032e c0032e = c0029b.f69d;
                c0032e.f116r += i;
                if (C0038k.f133a) {
                    Log.v("BackStackEntry", "Bump nesting of " + c0029b.f69d + " to " + c0029b.f69d.f116r);
                }
                if (c0029b.f74i != null) {
                    for (int size = c0029b.f74i.size() - 1; size >= 0; size--) {
                        c0032e = (C0032e) c0029b.f74i.get(size);
                        c0032e.f116r += i;
                        if (C0038k.f133a) {
                            Log.v("BackStackEntry", "Bump nesting of " + c0032e + " to " + c0032e.f116r);
                        }
                    }
                }
            }
        }
    }

    final void m53a(C0029b c0029b) {
        if (this.f48b == null) {
            this.f49c = c0029b;
            this.f48b = c0029b;
        } else {
            c0029b.f67b = this.f49c;
            this.f49c.f66a = c0029b;
            this.f49c = c0029b;
        }
        c0029b.f70e = this.f51e;
        c0029b.f71f = this.f52f;
        c0029b.f72g = this.f53g;
        c0029b.f73h = this.f54h;
        this.f50d++;
    }

    public final void m54a(String str, PrintWriter printWriter) {
        printWriter.print(str);
        printWriter.print("mName=");
        printWriter.print(this.f59m);
        printWriter.print(" mIndex=");
        printWriter.print(this.f61o);
        printWriter.print(" mCommitted=");
        printWriter.println(this.f60n);
        if (this.f55i != 0) {
            printWriter.print(str);
            printWriter.print("mTransition=#");
            printWriter.print(Integer.toHexString(this.f55i));
            printWriter.print(" mTransitionStyle=#");
            printWriter.println(Integer.toHexString(this.f56j));
        }
        if (!(this.f51e == 0 && this.f52f == 0)) {
            printWriter.print(str);
            printWriter.print("mEnterAnim=#");
            printWriter.print(Integer.toHexString(this.f51e));
            printWriter.print(" mExitAnim=#");
            printWriter.println(Integer.toHexString(this.f52f));
        }
        if (!(this.f53g == 0 && this.f54h == 0)) {
            printWriter.print(str);
            printWriter.print("mPopEnterAnim=#");
            printWriter.print(Integer.toHexString(this.f53g));
            printWriter.print(" mPopExitAnim=#");
            printWriter.println(Integer.toHexString(this.f54h));
        }
        if (!(this.f62p == 0 && this.f63q == null)) {
            printWriter.print(str);
            printWriter.print("mBreadCrumbTitleRes=#");
            printWriter.print(Integer.toHexString(this.f62p));
            printWriter.print(" mBreadCrumbTitleText=");
            printWriter.println(this.f63q);
        }
        if (!(this.f64r == 0 && this.f65s == null)) {
            printWriter.print(str);
            printWriter.print("mBreadCrumbShortTitleRes=#");
            printWriter.print(Integer.toHexString(this.f64r));
            printWriter.print(" mBreadCrumbShortTitleText=");
            printWriter.println(this.f65s);
        }
        if (this.f48b != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            C0029b c0029b = this.f48b;
            while (c0029b != null) {
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(0);
                printWriter.println(":");
                printWriter.print(str2);
                printWriter.print("cmd=");
                printWriter.print(c0029b.f68c);
                printWriter.print(" fragment=");
                printWriter.println(c0029b.f69d);
                if (!(c0029b.f70e == 0 && c0029b.f71f == 0)) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(c0029b.f70e));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(c0029b.f71f));
                }
                if (!(c0029b.f72g == 0 && c0029b.f73h == 0)) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(c0029b.f72g));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(c0029b.f73h));
                }
                if (c0029b.f74i != null && c0029b.f74i.size() > 0) {
                    for (int i = 0; i < c0029b.f74i.size(); i++) {
                        printWriter.print(str2);
                        if (c0029b.f74i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            printWriter.println("Removed:");
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(0);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0029b.f74i.get(i));
                    }
                }
                c0029b = c0029b.f66a;
            }
        }
    }

    public final void run() {
        if (C0038k.f133a) {
            Log.v("BackStackEntry", "Run: " + this);
        }
        if (!this.f57k || this.f61o >= 0) {
            m52a(1);
            for (C0029b c0029b = this.f48b; c0029b != null; c0029b = c0029b.f66a) {
                C0032e c0032e;
                switch (c0029b.f68c) {
                    case 1:
                        c0032e = c0029b.f69d;
                        c0032e.f90E = c0029b.f70e;
                        this.f47a.m110a(c0032e, false);
                        break;
                    case 2:
                        C0032e c0032e2 = c0029b.f69d;
                        if (this.f47a.f142g != null) {
                            for (int i = 0; i < this.f47a.f142g.size(); i++) {
                                c0032e = (C0032e) this.f47a.f142g.get(i);
                                if (C0038k.f133a) {
                                    Log.v("BackStackEntry", "OP_REPLACE: adding=" + c0032e2 + " old=" + c0032e);
                                }
                                if (c0032e.f120v == c0032e2.f120v) {
                                    if (c0029b.f74i == null) {
                                        c0029b.f74i = new ArrayList();
                                    }
                                    c0029b.f74i.add(c0032e);
                                    c0032e.f90E = c0029b.f71f;
                                    if (this.f57k) {
                                        c0032e.f116r++;
                                        if (C0038k.f133a) {
                                            Log.v("BackStackEntry", "Bump nesting of " + c0032e + " to " + c0032e.f116r);
                                        }
                                    }
                                    this.f47a.m108a(c0032e, this.f55i, this.f56j);
                                }
                            }
                        }
                        c0032e2.f90E = c0029b.f70e;
                        this.f47a.m110a(c0032e2, false);
                        break;
                    case 3:
                        c0032e = c0029b.f69d;
                        c0032e.f90E = c0029b.f71f;
                        this.f47a.m108a(c0032e, this.f55i, this.f56j);
                        break;
                    case 4:
                        c0032e = c0029b.f69d;
                        c0032e.f90E = c0029b.f71f;
                        this.f47a.m114b(c0032e, this.f55i, this.f56j);
                        break;
                    case 5:
                        c0032e = c0029b.f69d;
                        c0032e.f90E = c0029b.f70e;
                        this.f47a.m117c(c0032e, this.f55i, this.f56j);
                        break;
                    case 6:
                        c0032e = c0029b.f69d;
                        c0032e.f90E = c0029b.f71f;
                        this.f47a.m119d(c0032e, this.f55i, this.f56j);
                        break;
                    case 7:
                        c0032e = c0029b.f69d;
                        c0032e.f90E = c0029b.f70e;
                        this.f47a.m121e(c0032e, this.f55i, this.f56j);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0029b.f68c);
                }
            }
            this.f47a.m102a(this.f47a.f149n, this.f55i, this.f56j, true);
            if (this.f57k) {
                this.f47a.m106a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }
}
