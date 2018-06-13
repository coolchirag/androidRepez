package javax.mail.internet;

import java.util.Enumeration;
import javax.mail.Part;

public interface MimePart extends Part {
    void addHeaderLine(String str);

    Enumeration getAllHeaderLines();

    String getContentID();

    String[] getContentLanguage();

    String getContentMD5();

    String getEncoding();

    String getHeader(String str, String str2);

    Enumeration getMatchingHeaderLines(String[] strArr);

    Enumeration getNonMatchingHeaderLines(String[] strArr);

    void setContentLanguage(String[] strArr);

    void setContentMD5(String str);

    void setText(String str);

    void setText(String str, String str2);

    void setText(String str, String str2, String str3);
}
