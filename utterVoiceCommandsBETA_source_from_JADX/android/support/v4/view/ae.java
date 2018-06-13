package android.support.v4.view;

import android.database.DataSetObserver;

final class ae extends DataSetObserver {
    final /* synthetic */ ViewPager f281a;

    private ae(ViewPager viewPager) {
        this.f281a = viewPager;
    }

    public final void onChanged() {
        this.f281a.m226c();
    }

    public final void onInvalidated() {
        this.f281a.m226c();
    }
}
