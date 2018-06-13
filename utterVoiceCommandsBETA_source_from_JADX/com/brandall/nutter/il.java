package com.brandall.nutter;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

final class il implements LocationListener {
    il() {
    }

    public final void onLocationChanged(Location location) {
        ls.m1346c("LocationListener: onLocationChanged");
        ik.f1448b = location;
        ik.f1447a.removeUpdates(this);
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
        switch (i) {
            case 0:
                ik.f1447a.removeUpdates(ik.f1451e);
                return;
            case 1:
                ik.f1447a.removeUpdates(ik.f1451e);
                return;
            default:
                return;
        }
    }
}
