package com.nuance.nmdp.speechkit;

import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class ef {
    private static SSLSocketFactory f2744a;
    private static SSLContext f2745b;
    private static eg[] f2746c = new eg[1];

    public static Socket m2503a(String str, int i, eh ehVar) {
        try {
            f2746c[0] = new eg(ehVar);
            SSLContext instance = SSLContext.getInstance("TLS");
            f2745b = instance;
            instance.init(null, (TrustManager[]) f2746c, null);
            f2744a = f2745b.getSocketFactory();
            return f2744a.createSocket(str, i);
        } catch (NoSuchAlgorithmException e) {
            throw new SecurityException("No such algorithm exception " + e);
        } catch (KeyManagementException e2) {
            throw new SecurityException("Failed to initialize the client-side SSLContext " + e2);
        } catch (GeneralSecurityException e3) {
            throw new SecurityException("General security exception " + e3);
        }
    }
}
