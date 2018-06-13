package com.brandall.nutter;

import android.content.Intent;
import android.os.Bundle;

public final class gw {
    public static boolean m1001a(Intent intent) {
        return intent == null ? false : m1002a(intent.getExtras());
    }

    public static boolean m1002a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        try {
            bundle.containsKey(null);
            return false;
        } catch (Exception e) {
            bundle.clear();
            return true;
        }
    }
}
