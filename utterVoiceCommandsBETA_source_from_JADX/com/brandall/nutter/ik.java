package com.brandall.nutter;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import java.util.Calendar;
import java.util.List;

public final class ik {
    static LocationManager f1447a;
    static Location f1448b;
    static boolean f1449c = false;
    public static boolean f1450d = false;
    static LocationListener f1451e = new il();

    private static Location m1174a() {
        int i = 0;
        while (i < 31) {
            ls.m1346c("In myTimer While");
            if (f1449c) {
                ls.m1346c("In myTimer gps_enabled");
                Location lastKnownLocation = f1447a.getLastKnownLocation("gps");
                if (lastKnownLocation == null || lastKnownLocation.getTime() <= Calendar.getInstance().getTimeInMillis() - 120000) {
                    try {
                        Thread.sleep(1000);
                        i++;
                        ls.m1344a("Count: " + i);
                        if (lastKnownLocation != null && lastKnownLocation.getTime() > Calendar.getInstance().getTimeInMillis() - 120000) {
                            f1448b = null;
                        }
                    } catch (InterruptedException e) {
                        ls.m1348e("InterruptedException");
                        e.printStackTrace();
                        f1447a.removeUpdates(f1451e);
                        return f1448b;
                    }
                }
                f1448b = lastKnownLocation;
                f1447a.removeUpdates(f1451e);
                return f1448b;
            }
            ls.m1347d("GPS disabled");
            f1447a.removeUpdates(f1451e);
            return f1448b;
        }
        f1447a.removeUpdates(f1451e);
        return f1448b;
    }

    public static Location m1175a(Context context) {
        ls.m1346c("EstablishLocation getLocation");
        f1448b = null;
        if (f1447a == null) {
            f1447a = (LocationManager) context.getSystemService("location");
        }
        try {
            f1449c = f1447a.isProviderEnabled("gps");
        } catch (Exception e) {
            ls.m1348e("GPS not available");
            e.printStackTrace();
        }
        if (f1449c) {
            ls.m1346c("gps_enabled: setting listener");
            f1447a.requestLocationUpdates("gps", 0, 0.0f, f1451e);
            Location a = m1174a();
            f1448b = a;
            return a;
        }
        ls.m1347d("!gps_enabled: returning null");
        jy.m1223C(context, "locationSettings");
        return null;
    }

    public static double[] m1176b(Context context) {
        ls.m1346c("getGPS");
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        List providers = locationManager.getProviders(true);
        Location location = null;
        for (int size = providers.size() - 1; size >= 0; size--) {
            location = locationManager.getLastKnownLocation((String) providers.get(size));
            if (location != null) {
                break;
            }
        }
        Location location2 = location;
        double[] dArr = new double[2];
        if (location2 == null) {
            return null;
        }
        ls.m1346c("In gps if");
        dArr[0] = location2.getLatitude();
        dArr[1] = location2.getLongitude();
        ls.m1344a("GPS:- Latitude: " + dArr[0] + " Longitude: " + dArr[1]);
        return dArr;
    }

    public static Location m1177c(Context context) {
        ls.m1346c("getLastKnownLocation");
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        List providers = locationManager.getProviders(true);
        Location location = null;
        for (int size = providers.size() - 1; size >= 0; size--) {
            location = locationManager.getLastKnownLocation((String) providers.get(size));
            if (location != null) {
                break;
            }
        }
        return location;
    }
}
