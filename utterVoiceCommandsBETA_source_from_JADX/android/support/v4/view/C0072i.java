package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;

public abstract class C0072i {
    private DataSetObservable f287a;

    public static void m260b() {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public abstract int m261a();

    final void m262a(DataSetObserver dataSetObserver) {
        this.f287a.registerObserver(dataSetObserver);
    }

    final void m263b(DataSetObserver dataSetObserver) {
        this.f287a.unregisterObserver(dataSetObserver);
    }

    public abstract boolean m264c();
}
