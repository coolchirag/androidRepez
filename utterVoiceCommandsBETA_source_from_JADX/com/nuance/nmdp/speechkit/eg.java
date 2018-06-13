package com.nuance.nmdp.speechkit;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class eg implements X509TrustManager {
    private static X509TrustManager f2747b;
    private eh f2748a;

    public eg(eh ehVar) {
        this.f2748a = ehVar;
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(null);
        f2747b = (X509TrustManager) instance.getTrustManagers()[0];
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        int i;
        int i2 = 0;
        try {
            f2747b.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e) {
            if (!this.f2748a.f2749a) {
                throw e;
            }
        }
        if (this.f2748a.f2750b != null) {
            int i3 = 0;
            for (X509Certificate subjectDN : x509CertificateArr) {
                String name = subjectDN.getSubjectDN().getName();
                int indexOf = name.indexOf("CN=") + 3;
                if (this.f2748a.f2750b.equals(name.substring(indexOf, name.indexOf(44, indexOf)))) {
                    i3 = 1;
                }
            }
            if (i3 == 0) {
                throw new CertificateException("certificate summary is not identical");
            }
        }
        if (this.f2748a.f2751c != null) {
            i = 0;
            while (i2 < x509CertificateArr.length) {
                if (this.f2748a.f2751c.equals(bq.m2177a(x509CertificateArr[i2].getEncoded()))) {
                    i = 1;
                }
                i2++;
            }
            if (i == 0) {
                throw new CertificateException("certificate data is not identical");
            }
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return f2747b.getAcceptedIssuers();
    }
}
