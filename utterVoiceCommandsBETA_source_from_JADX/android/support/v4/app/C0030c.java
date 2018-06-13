package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class C0030c implements Parcelable {
    public static final Creator<C0030c> f75j = new C0031d();
    final int[] f76a;
    final int f77b;
    final int f78c;
    final String f79d;
    final int f80e;
    final int f81f;
    final CharSequence f82g;
    final int f83h;
    final CharSequence f84i;

    public C0030c(Parcel parcel) {
        this.f76a = parcel.createIntArray();
        this.f77b = parcel.readInt();
        this.f78c = parcel.readInt();
        this.f79d = parcel.readString();
        this.f80e = parcel.readInt();
        this.f81f = parcel.readInt();
        this.f82g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f83h = parcel.readInt();
        this.f84i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public C0030c(C0028a c0028a) {
        int i = 0;
        for (C0029b c0029b = c0028a.f48b; c0029b != null; c0029b = c0029b.f66a) {
            if (c0029b.f74i != null) {
                i += c0029b.f74i.size();
            }
        }
        this.f76a = new int[(i + (c0028a.f50d * 7))];
        if (c0028a.f57k) {
            i = 0;
            for (C0029b c0029b2 = c0028a.f48b; c0029b2 != null; c0029b2 = c0029b2.f66a) {
                int i2 = i + 1;
                this.f76a[i] = c0029b2.f68c;
                int i3 = i2 + 1;
                this.f76a[i2] = c0029b2.f69d.f104f;
                i2 = i3 + 1;
                this.f76a[i3] = c0029b2.f70e;
                i3 = i2 + 1;
                this.f76a[i2] = c0029b2.f71f;
                i2 = i3 + 1;
                this.f76a[i3] = c0029b2.f72g;
                int i4 = i2 + 1;
                this.f76a[i2] = c0029b2.f73h;
                if (c0029b2.f74i != null) {
                    int size = c0029b2.f74i.size();
                    i3 = i4 + 1;
                    this.f76a[i4] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i4 = i3 + 1;
                        this.f76a[i3] = ((C0032e) c0029b2.f74i.get(i2)).f104f;
                        i2++;
                        i3 = i4;
                    }
                    i = i3;
                } else {
                    i = i4 + 1;
                    this.f76a[i4] = 0;
                }
            }
            this.f77b = c0028a.f55i;
            this.f78c = c0028a.f56j;
            this.f79d = c0028a.f59m;
            this.f80e = c0028a.f61o;
            this.f81f = c0028a.f62p;
            this.f82g = c0028a.f63q;
            this.f83h = c0028a.f64r;
            this.f84i = c0028a.f65s;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public final C0028a m58a(C0038k c0038k) {
        C0028a c0028a = new C0028a(c0038k);
        int i = 0;
        while (i < this.f76a.length) {
            C0029b c0029b = new C0029b();
            int i2 = i + 1;
            c0029b.f68c = this.f76a[i];
            if (C0038k.f133a) {
                Log.v("FragmentManager", "BSE " + c0028a + " set base fragment #" + this.f76a[i2]);
            }
            int i3 = i2 + 1;
            c0029b.f69d = (C0032e) c0038k.f141f.get(this.f76a[i2]);
            int i4 = i3 + 1;
            c0029b.f70e = this.f76a[i3];
            i2 = i4 + 1;
            c0029b.f71f = this.f76a[i4];
            i4 = i2 + 1;
            c0029b.f72g = this.f76a[i2];
            i2 = i4 + 1;
            c0029b.f73h = this.f76a[i4];
            i = i2 + 1;
            i3 = this.f76a[i2];
            if (i3 > 0) {
                c0029b.f74i = new ArrayList(i3);
                i4 = 0;
                while (i4 < i3) {
                    if (C0038k.f133a) {
                        Log.v("FragmentManager", "BSE " + c0028a + " set remove fragment #" + this.f76a[i]);
                    }
                    i2 = i + 1;
                    c0029b.f74i.add((C0032e) c0038k.f141f.get(this.f76a[i]));
                    i4++;
                    i = i2;
                }
            }
            c0028a.m53a(c0029b);
        }
        c0028a.f55i = this.f77b;
        c0028a.f56j = this.f78c;
        c0028a.f59m = this.f79d;
        c0028a.f61o = this.f80e;
        c0028a.f57k = true;
        c0028a.f62p = this.f81f;
        c0028a.f63q = this.f82g;
        c0028a.f64r = this.f83h;
        c0028a.f65s = this.f84i;
        c0028a.m52a(1);
        return c0028a;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f76a);
        parcel.writeInt(this.f77b);
        parcel.writeInt(this.f78c);
        parcel.writeString(this.f79d);
        parcel.writeInt(this.f80e);
        parcel.writeInt(this.f81f);
        TextUtils.writeToParcel(this.f82g, parcel, 0);
        parcel.writeInt(this.f83h);
        TextUtils.writeToParcel(this.f84i, parcel, 0);
    }
}
