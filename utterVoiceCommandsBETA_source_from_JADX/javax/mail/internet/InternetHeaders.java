package javax.mail.internet;

import com.sun.mail.util.LineInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.mail.Header;
import javax.mail.MessagingException;

public class InternetHeaders {
    protected List headers = new ArrayList(40);

    public final class InternetHeader extends Header {
        String line;

        public InternetHeader(String str) {
            super("", "");
            int indexOf = str.indexOf(58);
            if (indexOf < 0) {
                this.name = str.trim();
            } else {
                this.name = str.substring(0, indexOf).trim();
            }
            this.line = str;
        }

        public InternetHeader(String str, String str2) {
            super(str, "");
            if (str2 != null) {
                this.line = new StringBuilder(String.valueOf(str)).append(": ").append(str2).toString();
            } else {
                this.line = null;
            }
        }

        public final String getValue() {
            int indexOf = this.line.indexOf(58);
            if (indexOf < 0) {
                return this.line;
            }
            indexOf++;
            while (indexOf < this.line.length()) {
                char charAt = this.line.charAt(indexOf);
                if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                    break;
                }
                indexOf++;
            }
            return this.line.substring(indexOf);
        }
    }

    class matchEnum implements Enumeration {
        private Iterator f3052e;
        private boolean match;
        private String[] names;
        private InternetHeader next_header = null;
        private boolean want_line;

        matchEnum(List list, String[] strArr, boolean z, boolean z2) {
            this.f3052e = list.iterator();
            this.names = strArr;
            this.match = z;
            this.want_line = z2;
        }

        private InternetHeader nextMatch() {
            while (this.f3052e.hasNext()) {
                InternetHeader internetHeader = (InternetHeader) this.f3052e.next();
                if (internetHeader.line != null) {
                    if (this.names == null) {
                        return this.match ? null : internetHeader;
                    } else {
                        int i = 0;
                        while (i < this.names.length) {
                            if (!this.names[i].equalsIgnoreCase(internetHeader.getName())) {
                                i++;
                            } else if (this.match) {
                                return internetHeader;
                            }
                        }
                        if (!this.match) {
                            return internetHeader;
                        }
                    }
                }
            }
            return null;
        }

        public boolean hasMoreElements() {
            if (this.next_header == null) {
                this.next_header = nextMatch();
            }
            return this.next_header != null;
        }

        public Object nextElement() {
            if (this.next_header == null) {
                this.next_header = nextMatch();
            }
            if (this.next_header == null) {
                throw new NoSuchElementException("No more headers");
            }
            InternetHeader internetHeader = this.next_header;
            this.next_header = null;
            return this.want_line ? internetHeader.line : new Header(internetHeader.getName(), internetHeader.getValue());
        }
    }

    public InternetHeaders() {
        this.headers.add(new InternetHeader("Return-Path", null));
        this.headers.add(new InternetHeader("Received", null));
        this.headers.add(new InternetHeader("Resent-Date", null));
        this.headers.add(new InternetHeader("Resent-From", null));
        this.headers.add(new InternetHeader("Resent-Sender", null));
        this.headers.add(new InternetHeader("Resent-To", null));
        this.headers.add(new InternetHeader("Resent-Cc", null));
        this.headers.add(new InternetHeader("Resent-Bcc", null));
        this.headers.add(new InternetHeader("Resent-Message-Id", null));
        this.headers.add(new InternetHeader("Date", null));
        this.headers.add(new InternetHeader("From", null));
        this.headers.add(new InternetHeader("Sender", null));
        this.headers.add(new InternetHeader("Reply-To", null));
        this.headers.add(new InternetHeader("To", null));
        this.headers.add(new InternetHeader("Cc", null));
        this.headers.add(new InternetHeader("Bcc", null));
        this.headers.add(new InternetHeader("Message-Id", null));
        this.headers.add(new InternetHeader("In-Reply-To", null));
        this.headers.add(new InternetHeader("References", null));
        this.headers.add(new InternetHeader("Subject", null));
        this.headers.add(new InternetHeader("Comments", null));
        this.headers.add(new InternetHeader("Keywords", null));
        this.headers.add(new InternetHeader("Errors-To", null));
        this.headers.add(new InternetHeader("MIME-Version", null));
        this.headers.add(new InternetHeader("Content-Type", null));
        this.headers.add(new InternetHeader("Content-Transfer-Encoding", null));
        this.headers.add(new InternetHeader("Content-MD5", null));
        this.headers.add(new InternetHeader(":", null));
        this.headers.add(new InternetHeader("Content-Length", null));
        this.headers.add(new InternetHeader("Status", null));
    }

    public InternetHeaders(InputStream inputStream) {
        load(inputStream);
    }

    public void addHeader(String str, String str2) {
        int i = 0;
        int size = this.headers.size();
        if (str.equalsIgnoreCase("Received") || str.equalsIgnoreCase("Return-Path")) {
            int i2 = 1;
        } else {
            Object obj = null;
        }
        if (obj == null) {
            i = size;
        }
        size = i;
        for (int size2 = this.headers.size() - 1; size2 >= 0; size2--) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(size2);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                if (obj != null) {
                    size = size2;
                } else {
                    this.headers.add(size2 + 1, new InternetHeader(str, str2));
                    return;
                }
            }
            if (internetHeader.getName().equals(":")) {
                size = size2;
            }
        }
        this.headers.add(size, new InternetHeader(str, str2));
    }

    public void addHeaderLine(String str) {
        try {
            char charAt = str.charAt(0);
            if (charAt == ' ' || charAt == '\t') {
                InternetHeader internetHeader = (InternetHeader) this.headers.get(this.headers.size() - 1);
                internetHeader.line += "\r\n" + str;
                return;
            }
            this.headers.add(new InternetHeader(str));
        } catch (StringIndexOutOfBoundsException e) {
        } catch (NoSuchElementException e2) {
        }
    }

    public Enumeration getAllHeaderLines() {
        return getNonMatchingHeaderLines(null);
    }

    public Enumeration getAllHeaders() {
        return new matchEnum(this.headers, null, false, false);
    }

    public String getHeader(String str, String str2) {
        int i = 1;
        String[] header = getHeader(str);
        if (header == null) {
            return null;
        }
        if (header.length == 1 || str2 == null) {
            return header[0];
        }
        StringBuffer stringBuffer = new StringBuffer(header[0]);
        while (i < header.length) {
            stringBuffer.append(str2);
            stringBuffer.append(header[i]);
            i++;
        }
        return stringBuffer.toString();
    }

    public String[] getHeader(String str) {
        List arrayList = new ArrayList();
        for (InternetHeader internetHeader : this.headers) {
            if (str.equalsIgnoreCase(internetHeader.getName()) && internetHeader.line != null) {
                arrayList.add(internetHeader.getValue());
            }
        }
        return arrayList.size() == 0 ? null : (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) {
        return new matchEnum(this.headers, strArr, true, true);
    }

    public Enumeration getMatchingHeaders(String[] strArr) {
        return new matchEnum(this.headers, strArr, true, false);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) {
        return new matchEnum(this.headers, strArr, false, true);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) {
        return new matchEnum(this.headers, strArr, false, false);
    }

    public void load(InputStream inputStream) {
        LineInputStream lineInputStream = new LineInputStream(inputStream);
        StringBuffer stringBuffer = new StringBuffer();
        String str = null;
        String readLine;
        do {
            try {
                readLine = lineInputStream.readLine();
                if (readLine == null || !(readLine.startsWith(" ") || readLine.startsWith("\t"))) {
                    if (str != null) {
                        addHeaderLine(str);
                    } else if (stringBuffer.length() > 0) {
                        addHeaderLine(stringBuffer.toString());
                        stringBuffer.setLength(0);
                    }
                    str = readLine;
                } else {
                    if (str != null) {
                        stringBuffer.append(str);
                        str = null;
                    }
                    stringBuffer.append("\r\n");
                    stringBuffer.append(readLine);
                }
                if (readLine == null) {
                    return;
                }
            } catch (Exception e) {
                throw new MessagingException("Error in input stream", e);
            }
        } while (readLine.length() > 0);
    }

    public void removeHeader(String str) {
        for (int i = 0; i < this.headers.size(); i++) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(i);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                internetHeader.line = null;
            }
        }
    }

    public void setHeader(String str, String str2) {
        int i = 0;
        int i2 = 0;
        while (i < this.headers.size()) {
            int i3;
            InternetHeader internetHeader = (InternetHeader) this.headers.get(i);
            if (!str.equalsIgnoreCase(internetHeader.getName())) {
                i3 = i;
                i = i2;
            } else if (i2 == 0) {
                if (internetHeader.line != null) {
                    i2 = internetHeader.line.indexOf(58);
                    if (i2 >= 0) {
                        internetHeader.line = new StringBuilder(String.valueOf(internetHeader.line.substring(0, i2 + 1))).append(" ").append(str2).toString();
                        i3 = i;
                        i = 1;
                    }
                }
                internetHeader.line = new StringBuilder(String.valueOf(str)).append(": ").append(str2).toString();
                i3 = i;
                i = 1;
            } else {
                this.headers.remove(i);
                i3 = i - 1;
                i = i2;
            }
            i2 = i;
            i = i3 + 1;
        }
        if (i2 == 0) {
            addHeader(str, str2);
        }
    }
}
