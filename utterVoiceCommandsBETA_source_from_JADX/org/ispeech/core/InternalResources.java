package org.ispeech.core;

import android.content.Context;
import org.ispeech.tools.Utilities;

public class InternalResources {
    public static boolean ALWAYS_SPEAK = false;
    public static final String DEVELOPMENT_API_URL = "http://dev.ispeech.org/api/rest";
    public static final String DEVELOPMENT_ASR_DOMAIN = "dev.ispeech.org";
    public static final String ISPEECH_SCREEN_ADCURL = "cu";
    public static final String ISPEECH_SCREEN_ADIURL = "iu";
    public static final String ISPEECH_SCREEN_AD_HEIGHT = "h";
    public static final String ISPEECH_SCREEN_AD_WIDTH = "w";
    public static final String ISPEECH_SCREEN_APIKEY = "ispeech_api_key";
    public static final String ISPEECH_SCREEN_DEBUG = "debug";
    public static final String ISPEECH_SCREEN_TYPE = "type";
    public static final String LIVE_API_URL = "http://api.ispeech.org/api/rest";
    public static final String LIVE_ASR_DOMAIN = "asr.ispeech.org";
    public static final String NOTIFICATION_URL = "https://api.ispeech.org/a/n";
    public static boolean Production = false;
    public static int STREAM_TYPE = 1;
    public static int mutex = 1;
    public static final String stringDismiss = "Dismiss";
    public static final String stringPleaseWait = "Please wait... ";

    private InternalResources() {
    }

    public static void alwaysSpeak(boolean z) {
        ALWAYS_SPEAK = z;
    }

    public static String getAPIUrl(Context context) {
        return !Utilities.isDebug(context) ? LIVE_API_URL : DEVELOPMENT_API_URL;
    }

    public static String getASRDomain(Context context) {
        return !Utilities.isDebug(context) ? LIVE_ASR_DOMAIN : DEVELOPMENT_ASR_DOMAIN;
    }

    public static void setStreamType(int i) {
        STREAM_TYPE = i;
    }
}
