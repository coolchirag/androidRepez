package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class C0043p implements Parcelable {
    public static final Creator<C0043p> f166l = new C0044q();
    final String f167a;
    final int f168b;
    final boolean f169c;
    final int f170d;
    final int f171e;
    final String f172f;
    final boolean f173g;
    final boolean f174h;
    final Bundle f175i;
    Bundle f176j;
    C0032e f177k;

    public C0043p(Parcel parcel) {
        boolean z = true;
        this.f167a = parcel.readString();
        this.f168b = parcel.readInt();
        this.f169c = parcel.readInt() != 0;
        this.f170d = parcel.readInt();
        this.f171e = parcel.readInt();
        this.f172f = parcel.readString();
        this.f173g = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.f174h = z;
        this.f175i = parcel.readBundle();
        this.f176j = parcel.readBundle();
    }

    public C0043p(C0032e c0032e) {
        this.f167a = c0032e.getClass().getName();
        this.f168b = c0032e.f104f;
        this.f169c = c0032e.f113o;
        this.f170d = c0032e.f119u;
        this.f171e = c0032e.f120v;
        this.f172f = c0032e.f121w;
        this.f173g = c0032e.f124z;
        this.f174h = c0032e.f123y;
        this.f175i = c0032e.f106h;
    }

    public final C0032e m136a(FragmentActivity fragmentActivity) {
        if (this.f177k != null) {
            return this.f177k;
        }
        if (this.f175i != null) {
            this.f175i.setClassLoader(fragmentActivity.getClassLoader());
        }
        this.f177k = C0032e.m60a(fragmentActivity, this.f167a, this.f175i);
        if (this.f176j != null) {
            this.f176j.setClassLoader(fragmentActivity.getClassLoader());
            this.f177k.f102d = this.f176j;
        }
        this.f177k.m76a(this.f168b);
        this.f177k.f113o = this.f169c;
        this.f177k.f115q = true;
        this.f177k.f119u = this.f170d;
        this.f177k.f120v = this.f171e;
        this.f177k.f121w = this.f172f;
        this.f177k.f124z = this.f173g;
        this.f177k.f123y = this.f174h;
        this.f177k.f117s = fragmentActivity.f36b;
        return this.f177k;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f167a);
        parcel.writeInt(this.f168b);
        parcel.writeInt(this.f169c ? 1 : 0);
        parcel.writeInt(this.f170d);
        parcel.writeInt(this.f171e);
        parcel.writeString(this.f172f);
        parcel.writeInt(this.f173g ? 1 : 0);
        if (!this.f174h) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f175i);
        parcel.writeBundle(this.f176j);
    }
}
