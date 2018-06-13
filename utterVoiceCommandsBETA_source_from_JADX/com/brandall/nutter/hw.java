package com.brandall.nutter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class hw {
    public static boolean m1147a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
