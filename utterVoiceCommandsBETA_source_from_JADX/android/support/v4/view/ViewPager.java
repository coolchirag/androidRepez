package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.p009d.C0059a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup {
    private static final int[] f232a = new int[]{16842931};
    private static final Comparator<aa> f233b = new C0087x();
    private static final Interpolator f234c = new C0088y();
    private float f235A;
    private float f236B;
    private int f237C = -1;
    private VelocityTracker f238D;
    private int f239E;
    private int f240F;
    private int f241G;
    private boolean f242H;
    private C0059a f243I;
    private C0059a f244J;
    private boolean f245K = true;
    private boolean f246L;
    private int f247M;
    private ad f248N;
    private ad f249O;
    private ac f250P;
    private int f251Q = 0;
    private final ArrayList<aa> f252d = new ArrayList();
    private C0072i f253e;
    private int f254f;
    private int f255g = -1;
    private Parcelable f256h = null;
    private ClassLoader f257i = null;
    private Scroller f258j;
    private ae f259k;
    private int f260l;
    private Drawable f261m;
    private int f262n;
    private int f263o;
    private int f264p;
    private int f265q;
    private boolean f266r;
    private boolean f267s;
    private boolean f268t;
    private boolean f269u;
    private int f270v = 1;
    private boolean f271w;
    private boolean f272x;
    private int f273y;
    private float f274z;

    public ViewPager(Context context) {
        super(context);
        m216e();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m216e();
    }

    private void m205a(int i) {
        if (this.f251Q != i) {
            this.f251Q = i;
            if (this.f248N != null) {
                this.f248N.mo44a(i);
            }
        }
    }

    private void m206a(int i, int i2, int i3, int i4) {
        int i5 = i + i3;
        if (i2 > 0) {
            int scrollX = getScrollX();
            int i6 = i2 + i4;
            i6 = (int) (((((float) (scrollX % i6)) / ((float) i6)) + ((float) (scrollX / i6))) * ((float) i5));
            scrollTo(i6, getScrollY());
            if (!this.f258j.isFinished()) {
                this.f258j.startScroll(i6, 0, i5 * this.f254f, 0, this.f258j.getDuration() - this.f258j.timePassed());
                return;
            }
            return;
        }
        scrollX = this.f254f * i5;
        if (scrollX != getScrollX()) {
            m219h();
            scrollTo(scrollX, getScrollY());
        }
    }

    private void m207a(int i, boolean z, boolean z2) {
        m208a(i, z, z2, 0);
    }

    private void m208a(int i, boolean z, boolean z2, int i2) {
        if (this.f253e == null || this.f253e.m261a() <= 0) {
            m210a(false);
        } else if (z2 || this.f254f != i || this.f252d.size() == 0) {
            int i3;
            if (i < 0) {
                i = 0;
            } else if (i >= this.f253e.m261a()) {
                i = this.f253e.m261a() - 1;
            }
            int i4 = this.f270v;
            if (i > this.f254f + i4 || i < this.f254f - i4) {
                for (i3 = 0; i3 < this.f252d.size(); i3++) {
                    ((aa) this.f252d.get(i3)).f278c = true;
                }
            }
            Object obj = this.f254f != i ? 1 : null;
            this.f254f = i;
            m217f();
            i4 = (getWidth() + this.f260l) * i;
            if (z) {
                if (getChildCount() == 0) {
                    m210a(false);
                } else {
                    i3 = getScrollX();
                    int scrollY = getScrollY();
                    int i5 = i4 - i3;
                    int i6 = 0 - scrollY;
                    if (i5 == 0 && i6 == 0) {
                        m219h();
                        m205a(0);
                    } else {
                        m210a(true);
                        this.f269u = true;
                        m205a(2);
                        i4 = getWidth();
                        int i7 = i4 / 2;
                        float sin = (((float) i7) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(i5))) / ((float) i4)) - 0.5f)) * 0.4712389167638204d))))) + ((float) i7);
                        int abs = Math.abs(i2);
                        this.f258j.startScroll(i3, scrollY, i5, i6, Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4 : (int) (((((float) Math.abs(i5)) / ((float) (i4 + this.f260l))) + 1.0f) * 100.0f), 600));
                        invalidate();
                    }
                }
                if (!(obj == null || this.f248N == null)) {
                    this.f248N.mo43a();
                }
                if (obj != null && this.f249O != null) {
                    this.f249O.mo43a();
                    return;
                }
                return;
            }
            if (!(obj == null || this.f248N == null)) {
                this.f248N.mo43a();
            }
            if (!(obj == null || this.f249O == null)) {
                this.f249O.mo43a();
            }
            m219h();
            scrollTo(i4, 0);
        } else {
            m210a(false);
        }
    }

    private void m209a(MotionEvent motionEvent) {
        int a = C0068e.m243a(motionEvent);
        if (C0068e.m245b(motionEvent, a) == this.f237C) {
            a = a == 0 ? 1 : 0;
            this.f235A = C0068e.m246c(motionEvent, a);
            this.f237C = C0068e.m245b(motionEvent, a);
            if (this.f238D != null) {
                this.f238D.clear();
            }
        }
    }

    private void m210a(boolean z) {
        if (this.f267s != z) {
            this.f267s = z;
        }
    }

    private boolean m211a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m211a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && C0078o.m274a(view, -i);
    }

    private void m212b(int i) {
        new aa().f277b = i;
        C0072i c0072i = this.f253e;
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    private void m213c(int i) {
        int width = getWidth() + this.f260l;
        int i2 = i / width;
        float f = ((float) (i % width)) / ((float) width);
        this.f246L = false;
        if (this.f247M > 0) {
            int scrollX = getScrollX();
            width = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                ab abVar = (ab) childAt.getLayoutParams();
                if (abVar.f279a) {
                    int max;
                    switch (abVar.f280b & 7) {
                        case 1:
                            max = Math.max((width2 - childAt.getMeasuredWidth()) / 2, width);
                            i4 = paddingRight;
                            paddingRight = width;
                            width = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + width;
                            i4 = width;
                            width = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = width;
                            width = i4;
                            break;
                        default:
                            max = width;
                            i4 = paddingRight;
                            paddingRight = width;
                            width = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = width;
                    width = i4;
                }
                i3++;
                i4 = width;
                width = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.f248N != null) {
            this.f248N.mo45a(i2, f);
        }
        if (this.f249O != null) {
            this.f249O.mo45a(i2, f);
        }
        this.f246L = true;
        if (!this.f246L) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m214d(int r7) {
        /*
        r6 = this;
        r5 = 66;
        r4 = 17;
        r2 = 0;
        r1 = 1;
        r0 = r6.findFocus();
        if (r0 != r6) goto L_0x000d;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        r3 = android.view.FocusFinder.getInstance();
        r3 = r3.findNextFocus(r6, r0, r7);
        if (r3 == 0) goto L_0x004e;
    L_0x0017:
        if (r3 == r0) goto L_0x004e;
    L_0x0019:
        if (r7 != r4) goto L_0x003b;
    L_0x001b:
        if (r0 == 0) goto L_0x0036;
    L_0x001d:
        r1 = r3.getLeft();
        r0 = r0.getLeft();
        if (r1 < r0) goto L_0x0036;
    L_0x0027:
        r0 = r6.m221j();
    L_0x002b:
        r2 = r0;
    L_0x002c:
        if (r2 == 0) goto L_0x0035;
    L_0x002e:
        r0 = android.view.SoundEffectConstants.getContantForFocusDirection(r7);
        r6.playSoundEffect(r0);
    L_0x0035:
        return r2;
    L_0x0036:
        r0 = r3.requestFocus();
        goto L_0x002b;
    L_0x003b:
        if (r7 != r5) goto L_0x002c;
    L_0x003d:
        if (r0 == 0) goto L_0x0049;
    L_0x003f:
        r4 = r3.getLeft();
        r0 = r0.getLeft();
        if (r4 <= r0) goto L_0x005c;
    L_0x0049:
        r0 = r3.requestFocus();
        goto L_0x002b;
    L_0x004e:
        if (r7 == r4) goto L_0x0052;
    L_0x0050:
        if (r7 != r1) goto L_0x0057;
    L_0x0052:
        r0 = r6.m221j();
        goto L_0x002b;
    L_0x0057:
        if (r7 == r5) goto L_0x005c;
    L_0x0059:
        r0 = 2;
        if (r7 != r0) goto L_0x002c;
    L_0x005c:
        r0 = r6.f253e;
        if (r0 == 0) goto L_0x0075;
    L_0x0060:
        r0 = r6.f254f;
        r3 = r6.f253e;
        r3 = r3.m261a();
        r3 = r3 + -1;
        if (r0 >= r3) goto L_0x0075;
    L_0x006c:
        r0 = r6.f254f;
        r0 = r0 + 1;
        r6.setCurrentItem(r0, r1);
        r0 = r1;
        goto L_0x002b;
    L_0x0075:
        r0 = r2;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.d(int):boolean");
    }

    private void m216e() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f258j = new Scroller(context, f234c);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f273y = C0083t.m281a(viewConfiguration);
        this.f239E = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f240F = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f243I = new C0059a(context);
        this.f244J = new C0059a(context);
        this.f241G = (int) (context.getResources().getDisplayMetrics().density * 25.0f);
    }

    private void m217f() {
        int i = -1;
        aa aaVar = null;
        int i2 = 0;
        if (this.f253e != null && !this.f268t && getWindowToken() != null) {
            aa aaVar2;
            C0072i c0072i = this.f253e;
            int i3 = this.f270v;
            int max = Math.max(0, this.f254f - i3);
            int min = Math.min(this.f253e.m261a() - 1, i3 + this.f254f);
            int i4 = 0;
            int i5 = -1;
            while (i4 < this.f252d.size()) {
                aaVar2 = (aa) this.f252d.get(i4);
                if ((aaVar2.f277b < max || aaVar2.f277b > min) && !aaVar2.f278c) {
                    this.f252d.remove(i4);
                    i4--;
                    C0072i c0072i2 = this.f253e;
                    i5 = aaVar2.f277b;
                    Object obj = aaVar2.f276a;
                    C0072i.m260b();
                    i5 = i4;
                } else {
                    if (i5 < min && aaVar2.f277b > max) {
                        i5++;
                        if (i5 < max) {
                            i5 = max;
                        }
                        while (i5 <= min && i5 < aaVar2.f277b) {
                            m212b(i5);
                            i5++;
                            i4++;
                        }
                    }
                    i5 = i4;
                }
                i4 = aaVar2.f277b;
                i3 = i5 + 1;
                i5 = i4;
                i4 = i3;
            }
            if (this.f252d.size() > 0) {
                i = ((aa) this.f252d.get(this.f252d.size() - 1)).f277b;
            }
            if (i < min) {
                i3 = i + 1;
                if (i3 <= max) {
                    i3 = max;
                }
                while (i3 <= min) {
                    m212b(i3);
                    i3++;
                }
            }
            for (i4 = 0; i4 < this.f252d.size(); i4++) {
                if (((aa) this.f252d.get(i4)).f277b == this.f254f) {
                    aaVar2 = (aa) this.f252d.get(i4);
                    break;
                }
            }
            aaVar2 = null;
            C0072i c0072i3 = this.f253e;
            i4 = this.f254f;
            if (aaVar2 != null) {
                Object obj2 = aaVar2.f276a;
            }
            c0072i = this.f253e;
            if (hasFocus()) {
                View findFocus = findFocus();
                if (findFocus != null) {
                    while (true) {
                        ViewPager parent = findFocus.getParent();
                        if (parent != this) {
                            if (parent == null || !(parent instanceof View)) {
                                break;
                            }
                            findFocus = parent;
                        } else {
                            break;
                        }
                    }
                    aaVar = m218g();
                }
                if (aaVar == null || aaVar.f277b != this.f254f) {
                    while (i2 < getChildCount()) {
                        findFocus = getChildAt(i2);
                        aa g = m218g();
                        if (g == null || g.f277b != this.f254f || !findFocus.requestFocus(2)) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private aa m218g() {
        for (int i = 0; i < this.f252d.size(); i++) {
            aa aaVar = (aa) this.f252d.get(i);
            C0072i c0072i = this.f253e;
            Object obj = aaVar.f276a;
            if (c0072i.m264c()) {
                return aaVar;
            }
        }
        return null;
    }

    private void m219h() {
        int scrollX;
        boolean z = this.f269u;
        if (z) {
            m210a(false);
            this.f258j.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f258j.getCurrX();
            int currY = this.f258j.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            m205a(0);
        }
        this.f268t = false;
        this.f269u = false;
        boolean z2 = z;
        for (scrollX = 0; scrollX < this.f252d.size(); scrollX++) {
            aa aaVar = (aa) this.f252d.get(scrollX);
            if (aaVar.f278c) {
                z2 = true;
                aaVar.f278c = false;
            }
        }
        if (z2) {
            m217f();
        }
    }

    private void m220i() {
        this.f271w = false;
        this.f272x = false;
        if (this.f238D != null) {
            this.f238D.recycle();
            this.f238D = null;
        }
    }

    private boolean m221j() {
        if (this.f254f <= 0) {
            return false;
        }
        setCurrentItem(this.f254f - 1, true);
        return true;
    }

    final ad m222a(ad adVar) {
        ad adVar2 = this.f249O;
        this.f249O = adVar;
        return adVar2;
    }

    public final C0072i m223a() {
        return this.f253e;
    }

    final void m224a(ac acVar) {
        this.f250P = acVar;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    aa g = m218g();
                    if (g != null && g.f277b == this.f254f) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                aa g = m218g();
                if (g != null && g.f277b == this.f254f) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        ab abVar = (ab) generateLayoutParams;
        abVar.f279a |= view instanceof C0063z;
        if (!this.f266r) {
            super.addView(view, i, generateLayoutParams);
        } else if (abVar == null || !abVar.f279a) {
            addViewInLayout(view, i, generateLayoutParams);
            view.measure(this.f264p, this.f265q);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public final int m225b() {
        return this.f254f;
    }

    final void m226c() {
        int i = 0;
        int i2 = (this.f252d.size() >= 3 || this.f252d.size() >= this.f253e.m261a()) ? 0 : 1;
        while (i < this.f252d.size()) {
            aa aaVar = (aa) this.f252d.get(i);
            C0072i c0072i = this.f253e;
            Object obj = aaVar.f276a;
            i++;
        }
        Collections.sort(this.f252d, f233b);
        if (i2 != 0) {
            m217f();
            requestLayout();
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof ab) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (this.f258j.isFinished() || !this.f258j.computeScrollOffset()) {
            m219h();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f258j.getCurrX();
        int currY = this.f258j.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            m213c(currX);
        }
        invalidate();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
        r4 = this;
        r1 = 1;
        r0 = 0;
        r2 = super.dispatchKeyEvent(r5);
        if (r2 != 0) goto L_0x0018;
    L_0x0008:
        r2 = r5.getAction();
        if (r2 != 0) goto L_0x0015;
    L_0x000e:
        r2 = r5.getKeyCode();
        switch(r2) {
            case 21: goto L_0x001a;
            case 22: goto L_0x0021;
            case 61: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r2 = r0;
    L_0x0016:
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        return r0;
    L_0x001a:
        r2 = 17;
        r2 = r4.m214d(r2);
        goto L_0x0016;
    L_0x0021:
        r2 = 66;
        r2 = r4.m214d(r2);
        goto L_0x0016;
    L_0x0028:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 11;
        if (r2 < r3) goto L_0x0015;
    L_0x002e:
        r2 = android.support.v4.view.C0064a.m228b(r5);
        if (r2 == 0) goto L_0x003a;
    L_0x0034:
        r2 = 2;
        r2 = r4.m214d(r2);
        goto L_0x0016;
    L_0x003a:
        r2 = android.support.v4.view.C0064a.m227a(r5);
        if (r2 == 0) goto L_0x0015;
    L_0x0040:
        r2 = r4.m214d(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                aa g = m218g();
                if (g != null && g.f277b == this.f254f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        int i = 1;
        super.draw(canvas);
        int i2 = 0;
        int a = C0078o.m273a(this);
        if (a == 0 || (a == 1 && this.f253e != null && this.f253e.m261a() > 1)) {
            if (!this.f243I.m176a()) {
                a = canvas.save();
                i2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i2) + getPaddingTop()), 0.0f);
                this.f243I.m175a(i2, getWidth());
                i2 = this.f243I.m178a(canvas) | 0;
                canvas.restoreToCount(a);
            }
            if (!this.f244J.m176a()) {
                a = canvas.save();
                int width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                if (this.f253e != null) {
                    i = this.f253e.m261a();
                }
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (float) (((-i) * (this.f260l + width)) + this.f260l));
                this.f244J.m175a(height, width);
                i2 |= this.f244J.m178a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f243I.m179b();
            this.f244J.m179b();
        }
        if (i2 != 0) {
            invalidate();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f261m;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new ab();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ab(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f245K = true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f260l > 0 && this.f261m != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            int i = scrollX % (this.f260l + width);
            if (i != 0) {
                scrollX = (scrollX - i) + width;
                this.f261m.setBounds(scrollX, this.f262n, this.f260l + scrollX, this.f263o);
                this.f261m.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f271w = false;
            this.f272x = false;
            this.f237C = -1;
            if (this.f238D == null) {
                return false;
            }
            this.f238D.recycle();
            this.f238D = null;
            return false;
        }
        if (action != 0) {
            if (this.f271w) {
                return true;
            }
            if (this.f272x) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f274z = x;
                this.f235A = x;
                this.f236B = motionEvent.getY();
                this.f237C = C0068e.m245b(motionEvent, 0);
                if (this.f251Q != 2) {
                    m219h();
                    this.f271w = false;
                    this.f272x = false;
                    break;
                }
                this.f271w = true;
                this.f272x = false;
                m205a(1);
                break;
            case 2:
                action = this.f237C;
                if (action != -1) {
                    action = C0068e.m244a(motionEvent, action);
                    float c = C0068e.m246c(motionEvent, action);
                    float f = c - this.f235A;
                    float abs = Math.abs(f);
                    float d = C0068e.m247d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f236B);
                    if (!m211a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs <= ((float) this.f273y) || abs <= abs2) {
                            if (abs2 > ((float) this.f273y)) {
                                this.f272x = true;
                                break;
                            }
                        }
                        this.f271w = true;
                        m205a(1);
                        this.f235A = c;
                        m210a(true);
                        break;
                    }
                    this.f235A = c;
                    this.f274z = c;
                    this.f236B = d;
                    return false;
                }
                break;
            case 6:
                m209a(motionEvent);
                break;
        }
        if (!this.f271w) {
            if (this.f238D == null) {
                this.f238D = VelocityTracker.obtain();
            }
            this.f238D.addMovement(motionEvent);
        }
        return this.f271w;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f266r = true;
        m217f();
        this.f266r = false;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                ab abVar = (ab) childAt.getLayoutParams();
                if (abVar.f279a) {
                    int max;
                    int i9 = abVar.f280b & 112;
                    switch (abVar.f280b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    i7++;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                } else {
                    aa g = m218g();
                    if (g != null) {
                        measuredWidth = (g.f277b * (this.f260l + i5)) + paddingLeft;
                        childAt.layout(measuredWidth, paddingTop, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                    }
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        this.f262n = paddingTop;
        this.f263o = i6 - paddingBottom;
        this.f247M = i7;
        this.f245K = false;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            ab abVar;
            int i4;
            int i5;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                abVar = (ab) childAt.getLayoutParams();
                if (abVar != null && abVar.f279a) {
                    int i6 = abVar.f280b & 7;
                    int i7 = abVar.f280b & 112;
                    Log.d("ViewPager", "gravity: " + abVar.f280b + " hgrav: " + i6 + " vgrav: " + i7);
                    i4 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i4 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    childAt.measure(MeasureSpec.makeMeasureSpec(measuredWidth, i4), MeasureSpec.makeMeasureSpec(measuredHeight, i5));
                    if (obj != null) {
                        i5 = measuredHeight - childAt.getMeasuredHeight();
                        i4 = measuredWidth;
                    } else if (obj2 != null) {
                        i4 = measuredWidth - childAt.getMeasuredWidth();
                        i5 = measuredHeight;
                    }
                    i3++;
                    measuredWidth = i4;
                    measuredHeight = i5;
                }
            }
            i5 = measuredHeight;
            i4 = measuredWidth;
            i3++;
            measuredWidth = i4;
            measuredHeight = i5;
        }
        this.f264p = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.f265q = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f266r = true;
        m217f();
        this.f266r = false;
        measuredHeight = getChildCount();
        for (i4 = 0; i4 < measuredHeight; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                abVar = (ab) childAt2.getLayoutParams();
                if (abVar == null || !abVar.f279a) {
                    childAt2.measure(this.f264p, this.f265q);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                aa g = m218g();
                if (g != null && g.f277b == this.f254f && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof af) {
            af afVar = (af) parcelable;
            super.onRestoreInstanceState(afVar.getSuperState());
            if (this.f253e != null) {
                C0072i c0072i = this.f253e;
                Parcelable parcelable2 = afVar.f284b;
                ClassLoader classLoader = afVar.f285c;
                m207a(afVar.f283a, false, true);
                return;
            }
            this.f255g = afVar.f283a;
            this.f256h = afVar.f284b;
            this.f257i = afVar.f285c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable afVar = new af(super.onSaveInstanceState());
        afVar.f283a = this.f254f;
        if (this.f253e != null) {
            C0072i c0072i = this.f253e;
            afVar.f284b = null;
        }
        return afVar;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m206a(i, i3, this.f260l, this.f260l);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f242H) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.f253e == null || this.f253e.m261a() == 0) {
            return false;
        }
        if (this.f238D == null) {
            this.f238D = VelocityTracker.obtain();
        }
        this.f238D.addMovement(motionEvent);
        float x;
        int a;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                m219h();
                x = motionEvent.getX();
                this.f274z = x;
                this.f235A = x;
                this.f237C = C0068e.m245b(motionEvent, 0);
                break;
            case 1:
                if (this.f271w) {
                    VelocityTracker velocityTracker = this.f238D;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f240F);
                    a = (int) C0074k.m269a(velocityTracker, this.f237C);
                    this.f268t = true;
                    int width = this.f260l + getWidth();
                    int scrollX = getScrollX();
                    int i = scrollX / width;
                    f = ((float) (scrollX % width)) / ((float) width);
                    if (Math.abs((int) (C0068e.m246c(motionEvent, C0068e.m244a(motionEvent, this.f237C)) - this.f274z)) <= this.f241G || Math.abs(a) <= this.f239E) {
                        i = (int) ((((float) i) + f) + 0.5f);
                    } else if (a <= 0) {
                        i++;
                    }
                    m208a(i, true, true, a);
                    this.f237C = -1;
                    m220i();
                    z = this.f243I.m180c() | this.f244J.m180c();
                    break;
                }
                break;
            case 2:
                float abs;
                if (!this.f271w) {
                    a = C0068e.m244a(motionEvent, this.f237C);
                    f = C0068e.m246c(motionEvent, a);
                    abs = Math.abs(f - this.f235A);
                    x = Math.abs(C0068e.m247d(motionEvent, a) - this.f236B);
                    if (abs > ((float) this.f273y) && abs > x) {
                        this.f271w = true;
                        this.f235A = f;
                        m205a(1);
                        m210a(true);
                    }
                }
                if (this.f271w) {
                    boolean z2;
                    float f2;
                    x = C0068e.m246c(motionEvent, C0068e.m244a(motionEvent, this.f237C));
                    f = this.f235A - x;
                    this.f235A = x;
                    abs = ((float) getScrollX()) + f;
                    int width2 = getWidth();
                    int i2 = width2 + this.f260l;
                    int a2 = this.f253e.m261a() - 1;
                    x = (float) Math.max(0, (this.f254f - 1) * i2);
                    f = (float) (Math.min(this.f254f + 1, a2) * i2);
                    if (abs < x) {
                        if (x == 0.0f) {
                            z = this.f243I.m177a((-abs) / ((float) width2));
                        }
                        float f3 = x;
                        z2 = z;
                        f2 = f3;
                    } else if (abs > f) {
                        if (f == ((float) (a2 * i2))) {
                            z = this.f244J.m177a((abs - f) / ((float) width2));
                        }
                        z2 = z;
                        f2 = f;
                    } else {
                        z2 = false;
                        f2 = abs;
                    }
                    this.f235A += f2 - ((float) ((int) f2));
                    scrollTo((int) f2, getScrollY());
                    m213c((int) f2);
                    z = z2;
                    break;
                }
                break;
            case 3:
                if (this.f271w) {
                    m207a(this.f254f, true, true);
                    this.f237C = -1;
                    m220i();
                    z = this.f243I.m180c() | this.f244J.m180c();
                    break;
                }
                break;
            case 5:
                a = C0068e.m243a(motionEvent);
                this.f235A = C0068e.m246c(motionEvent, a);
                this.f237C = C0068e.m245b(motionEvent, a);
                break;
            case 6:
                m209a(motionEvent);
                this.f235A = C0068e.m246c(motionEvent, C0068e.m244a(motionEvent, this.f237C));
                break;
        }
        if (z) {
            invalidate();
        }
        return true;
    }

    public void setAdapter(C0072i c0072i) {
        C0072i c0072i2;
        if (this.f253e != null) {
            int i;
            this.f253e.m263b(this.f259k);
            c0072i2 = this.f253e;
            for (i = 0; i < this.f252d.size(); i++) {
                aa aaVar = (aa) this.f252d.get(i);
                C0072i c0072i3 = this.f253e;
                int i2 = aaVar.f277b;
                Object obj = aaVar.f276a;
                C0072i.m260b();
            }
            c0072i2 = this.f253e;
            this.f252d.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((ab) getChildAt(i).getLayoutParams()).f279a) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.f254f = 0;
            scrollTo(0, 0);
        }
        c0072i2 = this.f253e;
        this.f253e = c0072i;
        if (this.f253e != null) {
            if (this.f259k == null) {
                this.f259k = new ae();
            }
            this.f253e.m262a(this.f259k);
            this.f268t = false;
            if (this.f255g >= 0) {
                C0072i c0072i4 = this.f253e;
                Parcelable parcelable = this.f256h;
                ClassLoader classLoader = this.f257i;
                m207a(this.f255g, false, true);
                this.f255g = -1;
                this.f256h = null;
                this.f257i = null;
            } else {
                m217f();
            }
        }
        if (this.f250P != null && c0072i2 != c0072i) {
            this.f250P.mo46a(c0072i2, c0072i);
        }
    }

    public void setCurrentItem(int i) {
        this.f268t = false;
        m207a(i, !this.f245K, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.f268t = false;
        m207a(i, z, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f270v) {
            this.f270v = i;
            m217f();
        }
    }

    public void setOnPageChangeListener(ad adVar) {
        this.f248N = adVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.f260l;
        this.f260l = i;
        int width = getWidth();
        m206a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f261m = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f261m;
    }
}
