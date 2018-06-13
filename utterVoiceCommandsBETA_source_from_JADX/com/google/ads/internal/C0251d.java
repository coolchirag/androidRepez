package com.google.ads.internal;

import com.google.ads.C0276k;
import com.google.ads.C0277l;
import com.google.ads.C0286u;
import com.google.ads.as;
import com.google.ads.at;
import com.google.ads.au;
import com.google.ads.av;
import com.google.ads.aw;
import com.google.ads.ax;
import com.google.ads.ay;
import com.google.ads.az;
import com.google.ads.bd;
import com.google.ads.be;
import java.util.HashMap;

final class C0251d extends HashMap<String, as> {
    C0251d() {
        put("/open", new be());
        put("/canOpenURLs", new au());
        put("/close", new aw());
        put("/customClose", new ax());
        put("/appEvent", new at());
        put("/evalInOpener", new ay());
        put("/log", new bd());
        put("/click", new av());
        put("/httpTrack", new az());
        put("/touch", new C0276k());
        put("/video", new C0277l());
        put("/plusOne", new C0286u());
    }
}
