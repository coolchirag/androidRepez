package android.support.v4.p007b;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class C0056d<T> implements ClassLoaderCreator<T> {
    private final C0055c<T> f216a;

    public C0056d(C0055c<T> c0055c) {
        this.f216a = c0055c;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.f216a.mo35a(parcel, null);
    }

    public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f216a.mo35a(parcel, classLoader);
    }

    public final T[] newArray(int i) {
        return this.f216a.mo36a(i);
    }
}
