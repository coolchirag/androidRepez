package com.att.android.speech;

import winterwell.jtwitter.Twitter;

enum ab {
    LDPI(120, "assets/graphmeteron_ldpi.png", "assets/graphmeteroff_ldpi.png"),
    MDPI(160, "assets/graphmeteron_mdpi.png", "assets/graphmeteroff_mdpi.png"),
    HDPI(240, "assets/graphmeteron_hdpi.png", "assets/graphmeteroff_hdpi.png"),
    XHDPI(320, "assets/graphmeteron_xhdpi.png", "assets/graphmeteroff_xhdpi.png");
    
    final int f391e;
    final float f392f;
    final String f393g;
    final String f394h;

    private ab(int i, String str, String str2) {
        this.f391e = i;
        this.f393g = str;
        this.f394h = str2;
        this.f392f = ((float) i) / 160.0f;
    }

    public static ab m344a(int i) {
        return i < Twitter.MAX_CHARS ? LDPI : i < 200 ? MDPI : i < 280 ? HDPI : XHDPI;
    }
}
