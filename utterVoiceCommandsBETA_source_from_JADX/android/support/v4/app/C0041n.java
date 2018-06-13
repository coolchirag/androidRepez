package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class C0041n implements Parcelable {
    public static final Creator<C0041n> f162d = new C0042o();
    C0043p[] f163a;
    int[] f164b;
    C0030c[] f165c;

    public C0041n(Parcel parcel) {
        this.f163a = (C0043p[]) parcel.createTypedArray(C0043p.f166l);
        this.f164b = parcel.createIntArray();
        this.f165c = (C0030c[]) parcel.createTypedArray(C0030c.f75j);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f163a, i);
        parcel.writeIntArray(this.f164b);
        parcel.writeTypedArray(this.f165c, i);
    }
}
