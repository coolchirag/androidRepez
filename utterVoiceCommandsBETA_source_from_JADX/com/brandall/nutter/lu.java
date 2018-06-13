package com.brandall.nutter;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

public final class lu {
    public static boolean m1355a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        if (!bundle.containsKey("com.brandall.nutter.extra.STRING_MESSAGE") && !bundle.containsKey("com.brandall.nutter.extra.STRING_MESSAGE5")) {
            Log.e("TaskerPlugin", String.format("bundle must contain extra %s", new Object[]{"com.brandall.nutter.extra.STRING_MESSAGE"}));
            return false;
        } else if (1 > bundle.keySet().size()) {
            Log.e("TaskerPlugin", String.format("bundle must contain 2 keys, but currently contains %d keys: %s", new Object[]{Integer.valueOf(bundle.keySet().size()), bundle.keySet().toString()}));
            return false;
        } else if (!TextUtils.isEmpty(bundle.getString("com.brandall.nutter.extra.STRING_MESSAGE")) || !TextUtils.isEmpty(bundle.getString("com.brandall.nutter.extra.STRING_MESSAGE6"))) {
            return true;
        } else {
            Log.e("TaskerPlugin", String.format("bundle extra %s appears to be null or empty.  It must be a non-empty string", new Object[]{"com.brandall.nutter.extra.STRING_MESSAGE"}));
            return false;
        }
    }
}
