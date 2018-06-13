package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

public class PagerTitleStrip extends ViewGroup implements C0063z {
    private static final int[] f221k = new int[]{16842804, 16842904, 16842901};
    ViewPager f222a;
    private TextView f223b;
    private TextView f224c;
    private TextView f225d;
    private int f226e;
    private float f227f;
    private int f228g;
    private boolean f229h;
    private boolean f230i;
    private final C0073j f231j;

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f226e = -1;
        this.f227f = -1.0f;
        this.f231j = new C0073j();
        View textView = new TextView(context);
        this.f223b = textView;
        addView(textView);
        textView = new TextView(context);
        this.f224c = textView;
        addView(textView);
        textView = new TextView(context);
        this.f225d = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f221k);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.f223b.setTextAppearance(context, resourceId);
            this.f224c.setTextAppearance(context, resourceId);
            this.f225d.setTextAppearance(context, resourceId);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            resourceId = obtainStyledAttributes.getColor(1, 0);
            this.f223b.setTextColor(resourceId);
            this.f224c.setTextColor(resourceId);
            this.f225d.setTextColor(resourceId);
        }
        resourceId = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        if (resourceId != 0) {
            this.f223b.setTextSize(0, (float) resourceId);
            this.f224c.setTextSize(0, (float) resourceId);
            this.f225d.setTextSize(0, (float) resourceId);
        }
        obtainStyledAttributes.recycle();
        int defaultColor = (this.f223b.getTextColors().getDefaultColor() & 16777215) | -1728053248;
        this.f223b.setTextColor(defaultColor);
        this.f225d.setTextColor(defaultColor);
        this.f223b.setEllipsize(TruncateAt.END);
        this.f224c.setEllipsize(TruncateAt.END);
        this.f225d.setEllipsize(TruncateAt.END);
        this.f223b.setSingleLine();
        this.f224c.setSingleLine();
        this.f225d.setSingleLine();
        this.f228g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    final void m202a(int i) {
        this.f229h = true;
        this.f223b.setText(null);
        this.f224c.setText(null);
        this.f225d.setText(null);
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f), Integer.MIN_VALUE);
        height = MeasureSpec.makeMeasureSpec(height, 1073741824);
        this.f223b.measure(makeMeasureSpec, height);
        this.f224c.measure(makeMeasureSpec, height);
        this.f225d.measure(makeMeasureSpec, height);
        this.f226e = i;
        if (!this.f230i) {
            m203a(i, this.f227f);
        }
        this.f229h = false;
    }

    final void m203a(int i, float f) {
        if (i != this.f226e) {
            this.f222a.m223a();
            m202a(i);
        } else if (f == this.f227f) {
            return;
        }
        this.f230i = true;
        int measuredWidth = this.f223b.getMeasuredWidth();
        int measuredWidth2 = this.f224c.getMeasuredWidth();
        int measuredWidth3 = this.f225d.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i5 = ((width - i3) - ((int) (f2 * ((float) i4)))) - i2;
        measuredWidth2 += i5;
        this.f224c.layout(i5, paddingTop, measuredWidth2, this.f224c.getMeasuredHeight() + paddingTop);
        i5 = Math.min(paddingLeft, (i5 - this.f228g) - measuredWidth);
        this.f223b.layout(i5, paddingTop, measuredWidth + i5, this.f223b.getMeasuredHeight() + paddingTop);
        i5 = Math.max((width - paddingRight) - measuredWidth3, this.f228g + measuredWidth2);
        this.f225d.layout(i5, paddingTop, i5 + measuredWidth3, this.f225d.getMeasuredHeight() + paddingTop);
        this.f227f = f;
        this.f230i = false;
    }

    final void m204a(C0072i c0072i, C0072i c0072i2) {
        if (c0072i != null) {
            c0072i.m263b(this.f231j);
        }
        if (c0072i2 != null) {
            c0072i2.m262a(this.f231j);
        }
        if (this.f222a != null) {
            this.f226e = -1;
            this.f227f = -1.0f;
            m202a(this.f222a.m225b());
            requestLayout();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            C0072i a = viewPager.m223a();
            viewPager.m222a(this.f231j);
            viewPager.m224a(this.f231j);
            this.f222a = viewPager;
            m204a(null, a);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        m204a(this.f222a.m223a(), null);
        this.f222a.m222a(null);
        this.f222a.m224a(null);
        this.f222a = null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f222a != null) {
            m203a(this.f222a.m225b(), 0.0f);
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        mode = 0;
        Drawable background = getBackground();
        if (background != null) {
            mode = background.getIntrinsicHeight();
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = size2 - paddingTop;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((int) (((float) size) * 0.8f), Integer.MIN_VALUE);
        i3 = MeasureSpec.makeMeasureSpec(i3, mode2);
        this.f223b.measure(makeMeasureSpec, i3);
        this.f224c.measure(makeMeasureSpec, i3);
        this.f225d.measure(makeMeasureSpec, i3);
        if (mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, Math.max(mode, this.f224c.getMeasuredHeight() + paddingTop));
        }
    }

    public void requestLayout() {
        if (!this.f229h) {
            super.requestLayout();
        }
    }
}
