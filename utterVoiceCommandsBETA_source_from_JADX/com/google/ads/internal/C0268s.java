package com.google.ads.internal;

import java.net.HttpURLConnection;
import java.net.URL;

final class C0268s implements C0267t {
    C0268s() {
    }

    public final HttpURLConnection mo114a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }
}
