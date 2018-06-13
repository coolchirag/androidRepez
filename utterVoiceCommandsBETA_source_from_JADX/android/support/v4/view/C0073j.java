package android.support.v4.view;

import android.database.DataSetObserver;

final class C0073j extends DataSetObserver implements ac, ad {
    final /* synthetic */ PagerTitleStrip f288a;
    private int f289b;

    private C0073j(PagerTitleStrip pagerTitleStrip) {
        this.f288a = pagerTitleStrip;
    }

    public final void mo43a() {
        if (this.f289b == 0) {
            PagerTitleStrip pagerTitleStrip = this.f288a;
            int b = this.f288a.f222a.m225b();
            this.f288a.f222a.m223a();
            pagerTitleStrip.m202a(b);
        }
    }

    public final void mo44a(int i) {
        this.f289b = i;
    }

    public final void mo45a(int i, float f) {
        if (f > 0.5f) {
            i++;
        }
        this.f288a.m203a(i, f);
    }

    public final void mo46a(C0072i c0072i, C0072i c0072i2) {
        this.f288a.m204a(c0072i, c0072i2);
    }

    public final void onChanged() {
        PagerTitleStrip pagerTitleStrip = this.f288a;
        int b = this.f288a.f222a.m225b();
        this.f288a.f222a.m223a();
        pagerTitleStrip.m202a(b);
    }
}
