package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p006a.C0025a;
import android.support.v4.p006a.C0026b;
import android.support.v4.p008c.C0057a;
import android.util.Log;
import java.io.PrintWriter;

final class C0049w implements C0026b<Object> {
    final int f189a;
    final Bundle f190b;
    C0047u<Object> f191c;
    C0025a<Object> f192d;
    boolean f193e;
    boolean f194f;
    Object f195g;
    boolean f196h;
    boolean f197i;
    boolean f198j;
    boolean f199k;
    boolean f200l;
    boolean f201m;
    C0049w f202n;
    final /* synthetic */ C0048v f203o;

    final void m158a() {
        if (C0048v.f183a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f196h = false;
        if (!this.f197i && this.f192d != null && this.f201m) {
            this.f201m = false;
            this.f192d.m45a(this);
            this.f192d.f31c = false;
        }
    }

    final void m159a(C0025a<Object> c0025a, Object obj) {
        String str;
        if (this.f191c != null) {
            if (this.f203o.f186d != null) {
                String str2 = this.f203o.f186d.f36b.f154s;
                this.f203o.f186d.f36b.f154s = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (C0048v.f183a) {
                    StringBuilder append = new StringBuilder("  onLoadFinished in ").append(c0025a).append(": ");
                    StringBuilder stringBuilder = new StringBuilder(64);
                    C0057a.m173a(obj, stringBuilder);
                    stringBuilder.append("}");
                    Log.v("LoaderManager", append.append(stringBuilder.toString()).toString());
                }
                C0047u c0047u = this.f191c;
                this.f194f = true;
            } finally {
                if (this.f203o.f186d != null) {
                    this.f203o.f186d.f36b.f154s = str;
                }
            }
        }
    }

    public final void m160a(String str, PrintWriter printWriter) {
        while (true) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f189a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f190b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f191c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f192d);
            if (this.f192d != null) {
                C0025a c0025a = this.f192d;
                String str2 = str + "  ";
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(c0025a.f29a);
                printWriter.print(" mListener=");
                printWriter.println(c0025a.f30b);
                printWriter.print(str2);
                printWriter.print("mStarted=");
                printWriter.print(c0025a.f31c);
                printWriter.print(" mContentChanged=");
                printWriter.print(c0025a.f34f);
                printWriter.print(" mAbandoned=");
                printWriter.print(c0025a.f32d);
                printWriter.print(" mReset=");
                printWriter.println(c0025a.f33e);
            }
            if (this.f193e || this.f194f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f193e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f194f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f195g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f196h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f199k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f200l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f197i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f198j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f201m);
            if (this.f202n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f202n);
                printWriter.println(":");
                this = this.f202n;
                str = str + "  ";
            } else {
                return;
            }
        }
    }

    final void m161b() {
        String str;
        Object obj = 1;
        C0047u c0047u = null;
        Object obj2 = null;
        while (true) {
            if (C0048v.f183a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f200l = obj;
            boolean z = this.f194f;
            this.f194f = obj2;
            if (this.f191c != null && this.f192d != null && this.f193e && z) {
                if (C0048v.f183a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.f203o.f186d != null) {
                    String str2 = this.f203o.f186d.f36b.f154s;
                    this.f203o.f186d.f36b.f154s = "onLoaderReset";
                    str = str2;
                } else {
                    Object obj3 = c0047u;
                }
                try {
                    C0047u c0047u2 = this.f191c;
                    C0025a c0025a = this.f192d;
                } finally {
                    c0047u = this.f203o.f186d;
                    if (c0047u != null) {
                        c0047u = this.f203o.f186d.f36b;
                        c0047u.f154s = str;
                    }
                }
            }
            this.f191c = c0047u;
            this.f195g = c0047u;
            this.f193e = obj2;
            if (this.f192d != null) {
                if (this.f201m) {
                    this.f201m = obj2;
                    this.f192d.m45a(this);
                }
                c0025a = this.f192d;
                c0025a.f33e = obj;
                c0025a.f31c = obj2;
                c0025a.f32d = obj2;
                c0025a.f34f = obj2;
            }
            if (this.f202n != null) {
                this = this.f202n;
            } else {
                return;
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.f189a);
        stringBuilder.append(" : ");
        C0057a.m173a(this.f192d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
