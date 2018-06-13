package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p007b.C0054b;
import android.support.v4.p007b.C0055c;
import android.support.v4.p007b.C0056d;
import android.view.View.BaseSavedState;

public final class af extends BaseSavedState {
    public static final Creator<af> f282d;
    int f283a;
    Parcelable f284b;
    ClassLoader f285c;

    static {
        C0055c agVar = new ag();
        if (VERSION.SDK_INT >= 13) {
            C0056d c0056d = new C0056d(agVar);
        }
        f282d = new C0054b(agVar);
    }

    af(Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        if (classLoader == null) {
            classLoader = getClass().getClassLoader();
        }
        this.f283a = parcel.readInt();
        this.f284b = parcel.readParcelable(classLoader);
        this.f285c = classLoader;
    }

    public af(Parcelable parcelable) {
        super(parcelable);
    }

    public final String toString() {
        return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f283a + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f283a);
        parcel.writeParcelable(this.f284b, i);
    }
}
