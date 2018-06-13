package javax.mail;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.activation.DataHandler;

public interface Part {
    public static final String ATTACHMENT = "attachment";
    public static final String INLINE = "inline";

    void addHeader(String str, String str2);

    Enumeration getAllHeaders();

    Object getContent();

    String getContentType();

    DataHandler getDataHandler();

    String getDescription();

    String getDisposition();

    String getFileName();

    String[] getHeader(String str);

    InputStream getInputStream();

    int getLineCount();

    Enumeration getMatchingHeaders(String[] strArr);

    Enumeration getNonMatchingHeaders(String[] strArr);

    int getSize();

    boolean isMimeType(String str);

    void removeHeader(String str);

    void setContent(Object obj, String str);

    void setContent(Multipart multipart);

    void setDataHandler(DataHandler dataHandler);

    void setDescription(String str);

    void setDisposition(String str);

    void setFileName(String str);

    void setHeader(String str, String str2);

    void setText(String str);

    void writeTo(OutputStream outputStream);
}
