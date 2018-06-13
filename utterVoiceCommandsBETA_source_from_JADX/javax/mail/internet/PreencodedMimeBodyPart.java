package javax.mail.internet;

import com.sun.mail.util.LineOutputStream;
import java.io.OutputStream;
import java.util.Enumeration;

public class PreencodedMimeBodyPart extends MimeBodyPart {
    private String encoding;

    public PreencodedMimeBodyPart(String str) {
        this.encoding = str;
    }

    public String getEncoding() {
        return this.encoding;
    }

    protected void updateHeaders() {
        super.updateHeaders();
        MimeBodyPart.setEncoding(this, this.encoding);
    }

    public void writeTo(OutputStream outputStream) {
        LineOutputStream lineOutputStream = outputStream instanceof LineOutputStream ? (LineOutputStream) outputStream : new LineOutputStream(outputStream);
        Enumeration allHeaderLines = getAllHeaderLines();
        while (allHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln((String) allHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        getDataHandler().writeTo(outputStream);
        outputStream.flush();
    }
}
