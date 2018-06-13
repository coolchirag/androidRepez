package com.dropbox.client2;

import com.dropbox.client2.p021a.C0189c;
import com.dropbox.client2.p021a.C0191e;
import com.dropbox.client2.p022c.C0197m;
import java.util.Map;
import org.apache.http.client.methods.HttpUriRequest;

public final class C0203b implements C0202e {
    private final HttpUriRequest f1866a;
    private final C0197m f1867b;

    public C0203b(HttpUriRequest httpUriRequest, C0197m c0197m) {
        this.f1866a = httpUriRequest;
        this.f1867b = c0197m;
    }

    public final C0218c mo103a() {
        try {
            return new C0218c((Map) C0222i.m1548a(C0222i.m1551a(this.f1867b, this.f1866a)));
        } catch (C0189c e) {
            if (this.f1866a.isAborted()) {
                throw new C0191e();
            }
            throw e;
        }
    }
}
