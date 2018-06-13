package p000a.p001a;

import java.io.Serializable;
import p000a.p001a.p003c.C0004b;
import p000a.p001a.p003c.C0016a;

public interface C0009d extends Serializable {
    String getConsumerKey();

    String getConsumerSecret();

    String getToken();

    String getTokenSecret();

    void setAdditionalParameters(C0016a c0016a);

    void setTokenWithSecret(String str, String str2);

    C0004b sign(C0004b c0004b);

    C0004b sign(Object obj);
}
