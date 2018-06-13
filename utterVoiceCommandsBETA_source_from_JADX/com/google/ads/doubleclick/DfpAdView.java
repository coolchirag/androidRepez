package com.google.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import com.google.ads.AdView;
import com.google.ads.C0245g;
import com.google.ads.C0246h;

public class DfpAdView extends AdView {
    public DfpAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DfpAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAppEventListener(C0246h c0246h) {
        super.setAppEventListener(c0246h);
    }

    public void setSupportedAdSizes(C0245g... c0245gArr) {
        super.setSupportedAdSizes(c0245gArr);
    }
}
