package com.att.android.speech;

import java.io.Serializable;

public final class C0119d implements Serializable {
    @Deprecated
    public static C0120e f499a = C0120e.USER_CANCELED;
    @Deprecated
    public static C0120e f500b = C0120e.PARAMETER_ERROR;
    @Deprecated
    public static C0120e f501c = C0120e.CAPTURE_FAILED;
    @Deprecated
    public static C0120e f502d = C0120e.BELOW_MINIMUM_LENGTH;
    @Deprecated
    public static C0120e f503e = C0120e.INAUDIBLE;
    @Deprecated
    public static C0120e f504f = C0120e.CONNECTION_ERROR;
    @Deprecated
    public static C0120e f505g = C0120e.RESPONSE_ERROR;
    @Deprecated
    public static C0120e f506h = C0120e.SERVER_ERROR;
    @Deprecated
    public static C0120e f507i = C0120e.OTHER_ERROR;
    private final String f508j;
    private final C0120e f509k;
    private final Exception f510l;
    private final C0121g f511m;

    public C0119d(C0120e c0120e, String str) {
        this(c0120e, str, null, null);
    }

    public C0119d(C0120e c0120e, String str, Exception exception) {
        this(c0120e, str, exception, null);
    }

    public C0119d(C0120e c0120e, String str, Exception exception, C0121g c0121g) {
        this.f508j = str;
        this.f509k = c0120e;
        this.f510l = exception;
        this.f511m = c0121g;
    }

    public final C0120e m399a() {
        return this.f509k;
    }

    public final String m400b() {
        return this.f508j;
    }

    public final C0121g m401c() {
        return this.f511m;
    }
}
