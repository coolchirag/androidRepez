package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public final class ab extends LayoutParams {
    public boolean f279a;
    public int f280b;

    public ab() {
        super(-1, -1);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f232a);
        this.f280b = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
    }
}
