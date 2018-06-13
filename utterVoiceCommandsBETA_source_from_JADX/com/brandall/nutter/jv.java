package com.brandall.nutter;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

final class jv extends Authenticator {
    private final /* synthetic */ String f1578a;
    private final /* synthetic */ String f1579b;

    jv(String str, String str2) {
        this.f1578a = str;
        this.f1579b = str2;
    }

    protected final PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.f1578a, this.f1579b);
    }
}
