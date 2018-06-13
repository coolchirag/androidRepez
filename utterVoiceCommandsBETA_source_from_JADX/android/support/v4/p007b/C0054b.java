package android.support.v4.p007b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class C0054b<T> implements Creator<T> {
    final C0055c<T> f215a;

    public C0054b(C0055c<T> c0055c) {
        this.f215a = c0055c;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.f215a.mo35a(parcel, null);
    }

    public final T[] newArray(int i) {
        return this.f215a.mo36a(i);
    }
}
