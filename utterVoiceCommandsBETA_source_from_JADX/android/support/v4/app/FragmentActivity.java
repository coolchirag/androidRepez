package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FragmentActivity extends Activity {
    final Handler f35a = new C0034g(this);
    final C0038k f36b = new C0038k();
    boolean f37c;
    boolean f38d;
    boolean f39e;
    boolean f40f;
    boolean f41g;
    boolean f42h;
    boolean f43i;
    boolean f44j;
    C0045s<C0048v> f45k;
    C0048v f46l;

    public static void m46b() {
    }

    public final void m47a() {
        if (VERSION.SDK_INT >= 11) {
            invalidateOptionsMenu();
        } else {
            this.f42h = true;
        }
    }

    final void m48a(int i) {
        if (this.f45k != null) {
            C0048v c0048v = (C0048v) this.f45k.m140a(i);
            if (c0048v != null && !c0048v.f188f) {
                c0048v.m157h();
                this.f45k.m142b(i);
            }
        }
    }

    final void m49a(boolean z) {
        if (!this.f40f) {
            this.f40f = true;
            this.f41g = z;
            this.f35a.removeMessages(1);
            if (this.f44j) {
                this.f44j = false;
                if (this.f46l != null) {
                    if (this.f41g) {
                        this.f46l.m153d();
                    } else {
                        this.f46l.m152c();
                    }
                }
            }
            this.f36b.m128l();
        }
    }

    final C0048v m50b(int i) {
        if (this.f45k == null) {
            this.f45k = new C0045s();
        }
        C0048v c0048v = (C0048v) this.f45k.m140a(i);
        if (c0048v != null) {
            c0048v.m148a(this);
        }
        return c0048v;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = VERSION.SDK_INT;
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f37c);
        printWriter.print("mResumed=");
        printWriter.print(this.f38d);
        printWriter.print(" mStopped=");
        printWriter.print(this.f39e);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f40f);
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f44j);
        if (this.f46l != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f46l)));
            printWriter.println(":");
            this.f46l.m149a(str + "  ", printWriter);
        }
        this.f36b.m111a(str, fileDescriptor, printWriter);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            if (this.f36b.f141f == null || i3 < 0 || i3 >= this.f36b.f141f.size()) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            if (((C0032e) this.f36b.f141f.get(i3)) == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            }
            C0032e.m62d();
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f36b.m112a()) {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f36b.m103a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f36b.m105a(this);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        C0036i c0036i = (C0036i) getLastNonConfigurationInstance();
        if (c0036i != null) {
            this.f45k = c0036i.f131e;
        }
        if (bundle != null) {
            this.f36b.m104a(bundle.getParcelable("android:support:fragments"), c0036i != null ? c0036i.f130d : null);
        }
        this.f36b.m122f();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        C0038k c0038k = this.f36b;
        getMenuInflater();
        return VERSION.SDK_INT >= 11 ? onCreatePanelMenu | c0038k.m131o() : true;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        C0032e c0032e = null;
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0035h.f126a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            c0032e = this.f36b.m100a(resourceId);
        }
        if (c0032e == null && string != null) {
            c0032e = this.f36b.m101a(string);
        }
        if (c0032e == null) {
            c0032e = this.f36b.m100a(0);
        }
        if (C0038k.f133a) {
            Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + c0032e);
        }
        if (c0032e == null) {
            C0032e a = C0032e.m59a((Context) this, attributeValue);
            a.f113o = true;
            a.f119u = resourceId != 0 ? resourceId : 0;
            a.f120v = 0;
            a.f121w = string;
            a.f114p = true;
            a.f117s = this.f36b;
            Bundle bundle = a.f102d;
            a.m80f();
            this.f36b.m110a(a, true);
            c0032e = a;
        } else if (c0032e.f114p) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(0) + " with another fragment for " + attributeValue);
        } else {
            c0032e.f114p = true;
            if (!c0032e.f86A) {
                Bundle bundle2 = c0032e.f102d;
                c0032e.m80f();
            }
            this.f36b.m107a(c0032e);
        }
        if (c0032e.f92G == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            c0032e.f92G.setId(resourceId);
        }
        if (c0032e.f92G.getTag() == null) {
            c0032e.f92G.setTag(string);
        }
        return c0032e.f92G;
    }

    protected void onDestroy() {
        super.onDestroy();
        m49a(false);
        this.f36b.m129m();
        if (this.f46l != null) {
            this.f46l.m157h();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f36b.m130n();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f36b.m133q();
            case 6:
                return this.f36b.m134r();
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f36b.m135s();
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f38d = false;
        if (this.f35a.hasMessages(2)) {
            this.f35a.removeMessages(2);
            this.f36b.m125i();
        }
        this.f36b.m126j();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f35a.removeMessages(2);
        this.f36b.m125i();
        this.f36b.m115b();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f42h) {
            this.f42h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return (super.onPreparePanel(i, view, menu) | this.f36b.m132p()) != 0 && menu.hasVisibleItems();
    }

    protected void onResume() {
        super.onResume();
        this.f35a.sendEmptyMessage(2);
        this.f38d = true;
        this.f36b.m115b();
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f39e) {
            m49a(true);
        }
        ArrayList c = this.f36b.m116c();
        boolean z = false;
        if (this.f45k != null) {
            int a = this.f45k.m139a() - 1;
            while (a >= 0) {
                boolean z2;
                C0048v c0048v = (C0048v) this.f45k.m145e(a);
                if (c0048v.f188f) {
                    z2 = true;
                } else {
                    c0048v.m157h();
                    this.f45k.m143c(a);
                    z2 = z;
                }
                a--;
                z = z2;
            }
        }
        if (c == null && !r2) {
            return null;
        }
        C0036i c0036i = new C0036i();
        c0036i.f127a = null;
        c0036i.f128b = null;
        c0036i.f129c = null;
        c0036i.f130d = c;
        c0036i.f131e = this.f45k;
        return c0036i;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable d = this.f36b.m118d();
        if (d != null) {
            bundle.putParcelable("android:support:fragments", d);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f39e = false;
        this.f40f = false;
        this.f35a.removeMessages(1);
        if (!this.f37c) {
            this.f37c = true;
            this.f36b.m123g();
        }
        this.f36b.m120e();
        this.f36b.m115b();
        if (!this.f44j) {
            this.f44j = true;
            if (this.f46l != null) {
                this.f46l.m151b();
            } else if (!this.f43i) {
                boolean z = this.f44j;
                this.f46l = m50b(-1);
            }
            this.f43i = true;
        }
        this.f36b.m124h();
        if (this.f45k != null) {
            for (int a = this.f45k.m139a() - 1; a >= 0; a--) {
                C0048v c0048v = (C0048v) this.f45k.m145e(a);
                c0048v.m154e();
                c0048v.m156g();
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.f39e = true;
        this.f35a.sendEmptyMessage(1);
        this.f36b.m127k();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
}
