package org.ispeech;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import org.ispeech.core.InternalResources;

class UtilitiesInternal {
    private static final String TAG = "iSpeech SDK";

    UtilitiesInternal() {
    }

    public static boolean hasFrameworkActivityDefinedInManifest(Context context) {
        Intent intent = new Intent(context, iSpeechFramework.class);
        intent.putExtra(InternalResources.ISPEECH_SCREEN_TYPE, -1);
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "iSpeech SDK can not proceed.\nPlease make sure iSpeechFramework activity is defined in your app's manifest. Please see integration documentation for more details.", 1).show();
            Log.e(TAG, "iSpeechFramework activity not found. Please make sure iSpeechFramework activity is defined in your app's manifest. Please see integration documentation for more details.");
            return false;
        }
    }
}
