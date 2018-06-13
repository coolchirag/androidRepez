package com.sun.mail.smtp;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.ParseException;

public class SMTPTransport extends Transport {
    static final /* synthetic */ boolean $assertionsDisabled = (!SMTPTransport.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final byte[] CRLF = new byte[]{(byte) 13, (byte) 10};
    private static final String UNKNOWN = "UNKNOWN";
    private static char[] hexchar = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String[] ignoreList = new String[]{"Bcc", "Content-Length"};
    private Address[] addresses;
    private SMTPOutputStream dataStream;
    private int defaultPort;
    private MessagingException exception;
    private Hashtable extMap;
    private Address[] invalidAddr;
    private boolean isSSL;
    private int lastReturnCode;
    private String lastServerResponse;
    private LineInputStream lineInputStream;
    private String localHostName;
    private DigestMD5 md5support;
    private MimeMessage message;
    private String name;
    private PrintStream out;
    private boolean quitWait;
    private boolean reportSuccess;
    private String saslRealm;
    private boolean sendPartiallyFailed;
    private BufferedInputStream serverInput;
    private OutputStream serverOutput;
    private Socket serverSocket;
    private boolean useRset;
    private boolean useStartTLS;
    private Address[] validSentAddr;
    private Address[] validUnsentAddr;

    public SMTPTransport(Session session, URLName uRLName) {
        this(session, uRLName, "smtp", 25, $assertionsDisabled);
    }

    protected SMTPTransport(Session session, URLName uRLName, String str, int i, boolean z) {
        boolean z2 = true;
        super(session, uRLName);
        this.name = "smtp";
        this.defaultPort = 25;
        this.isSSL = $assertionsDisabled;
        this.sendPartiallyFailed = $assertionsDisabled;
        this.quitWait = $assertionsDisabled;
        this.saslRealm = UNKNOWN;
        if (uRLName != null) {
            str = uRLName.getProtocol();
        }
        this.name = str;
        this.defaultPort = i;
        this.isSSL = z;
        this.out = session.getDebugOut();
        String property = session.getProperty("mail." + str + ".quitwait");
        boolean z3 = (property == null || property.equalsIgnoreCase("true")) ? true : $assertionsDisabled;
        this.quitWait = z3;
        property = session.getProperty("mail." + str + ".reportsuccess");
        z3 = (property == null || !property.equalsIgnoreCase("true")) ? $assertionsDisabled : true;
        this.reportSuccess = z3;
        property = session.getProperty("mail." + str + ".starttls.enable");
        z3 = (property == null || !property.equalsIgnoreCase("true")) ? $assertionsDisabled : true;
        this.useStartTLS = z3;
        property = session.getProperty("mail." + str + ".userset");
        if (property == null || !property.equalsIgnoreCase("true")) {
            z2 = $assertionsDisabled;
        }
        this.useRset = z2;
    }

    private void closeConnection() {
        try {
            if (this.serverSocket != null) {
                this.serverSocket.close();
            }
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (super.isConnected()) {
                super.close();
            }
        } catch (Exception e) {
            throw new MessagingException("Server Close Failed", e);
        } catch (Throwable th) {
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (super.isConnected()) {
                super.close();
            }
        }
    }

    private boolean convertTo8Bit(MimePart mimePart) {
        boolean z = $assertionsDisabled;
        try {
            if (mimePart.isMimeType("text/*")) {
                String encoding = mimePart.getEncoding();
                if (encoding != null && ((encoding.equalsIgnoreCase("quoted-printable") || encoding.equalsIgnoreCase("base64")) && is8Bit(mimePart.getInputStream()))) {
                    mimePart.setContent(mimePart.getContent(), mimePart.getContentType());
                    mimePart.setHeader("Content-Transfer-Encoding", "8bit");
                    return true;
                }
            } else if (mimePart.isMimeType("multipart/*")) {
                MimeMultipart mimeMultipart = (MimeMultipart) mimePart.getContent();
                int count = mimeMultipart.getCount();
                int i = 0;
                while (i < count) {
                    boolean z2 = convertTo8Bit((MimePart) mimeMultipart.getBodyPart(i)) ? true : z;
                    i++;
                    z = z2;
                }
                return z;
            }
            return $assertionsDisabled;
        } catch (IOException e) {
            return $assertionsDisabled;
        } catch (MessagingException e2) {
            return $assertionsDisabled;
        }
    }

    private void expandGroups() {
        Vector vector = null;
        int i = 0;
        while (i < this.addresses.length) {
            Vector vector2;
            InternetAddress internetAddress = (InternetAddress) this.addresses[i];
            if (internetAddress.isGroup()) {
                int i2;
                if (vector == null) {
                    vector = new Vector();
                    for (i2 = 0; i2 < i; i2++) {
                        vector.addElement(this.addresses[i2]);
                    }
                }
                try {
                    InternetAddress[] group = internetAddress.getGroup(true);
                    if (group != null) {
                        for (Object addElement : group) {
                            vector.addElement(addElement);
                        }
                        vector2 = vector;
                    } else {
                        vector.addElement(internetAddress);
                        vector2 = vector;
                    }
                } catch (ParseException e) {
                    vector.addElement(internetAddress);
                    vector2 = vector;
                }
            } else {
                if (vector != null) {
                    vector.addElement(internetAddress);
                }
                vector2 = vector;
            }
            i++;
            vector = vector2;
        }
        if (vector != null) {
            Address[] addressArr = new InternetAddress[vector.size()];
            vector.copyInto(addressArr);
            this.addresses = addressArr;
        }
    }

    private synchronized DigestMD5 getMD5() {
        if (this.md5support == null) {
            this.md5support = new DigestMD5(this.debug ? this.out : null);
        }
        return this.md5support;
    }

    private void initStreams() {
        Properties properties = this.session.getProperties();
        OutputStream debugOut = this.session.getDebugOut();
        boolean debug = this.session.getDebug();
        String property = properties.getProperty("mail.debug.quote");
        boolean z = (property == null || !property.equalsIgnoreCase("true")) ? $assertionsDisabled : true;
        InputStream traceInputStream = new TraceInputStream(this.serverSocket.getInputStream(), debugOut);
        traceInputStream.setTrace(debug);
        traceInputStream.setQuote(z);
        OutputStream traceOutputStream = new TraceOutputStream(this.serverSocket.getOutputStream(), debugOut);
        traceOutputStream.setTrace(debug);
        traceOutputStream.setQuote(z);
        this.serverOutput = new BufferedOutputStream(traceOutputStream);
        this.serverInput = new BufferedInputStream(traceInputStream);
        this.lineInputStream = new LineInputStream(this.serverInput);
    }

    private boolean is8Bit(InputStream inputStream) {
        boolean z = $assertionsDisabled;
        int i = 0;
        while (true) {
            try {
                int read = inputStream.read();
                if (read < 0) {
                    break;
                }
                read &= 255;
                if (read == 13 || read == 10) {
                    i = 0;
                } else if (read == 0) {
                    return $assertionsDisabled;
                } else {
                    i++;
                    if (i > 998) {
                        return $assertionsDisabled;
                    }
                }
                if (read > 127) {
                    z = true;
                }
            } catch (IOException e) {
                return $assertionsDisabled;
            }
        }
        if (this.debug && z) {
            this.out.println("DEBUG SMTP: found an 8bit part");
        }
        return z;
    }

    private boolean isNotLastLine(String str) {
        return (str == null || str.length() < 4 || str.charAt(3) != '-') ? $assertionsDisabled : true;
    }

    private void issueSendCommand(String str, int i) {
        sendCommand(str);
        int readServerResponse = readServerResponse();
        if (readServerResponse != i) {
            int length = this.validSentAddr == null ? 0 : this.validSentAddr.length;
            int length2 = this.validUnsentAddr == null ? 0 : this.validUnsentAddr.length;
            Object obj = new Address[(length + length2)];
            if (length > 0) {
                System.arraycopy(this.validSentAddr, 0, obj, 0, length);
            }
            if (length2 > 0) {
                System.arraycopy(this.validUnsentAddr, 0, obj, length, length2);
            }
            this.validSentAddr = null;
            this.validUnsentAddr = obj;
            if (this.debug) {
                this.out.println("DEBUG SMTP: got response code " + readServerResponse + ", with response: " + this.lastServerResponse);
            }
            String str2 = this.lastServerResponse;
            int i2 = this.lastReturnCode;
            if (this.serverSocket != null) {
                issueCommand("RSET", 250);
            }
            this.lastServerResponse = str2;
            this.lastReturnCode = i2;
            throw new SMTPSendFailedException(str, readServerResponse, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
        }
    }

    private String normalizeAddress(String str) {
        return (str.startsWith("<") || str.endsWith(">")) ? str : "<" + str + ">";
    }

    private void openServer() {
        int i = -1;
        String str = UNKNOWN;
        try {
            i = this.serverSocket.getPort();
            str = this.serverSocket.getInetAddress().getHostName();
            if (this.debug) {
                this.out.println("DEBUG SMTP: starting protocol to host \"" + str + "\", port " + i);
            }
            initStreams();
            int readServerResponse = readServerResponse();
            if (readServerResponse != 220) {
                this.serverSocket.close();
                this.serverSocket = null;
                this.serverOutput = null;
                this.serverInput = null;
                this.lineInputStream = null;
                if (this.debug) {
                    this.out.println("DEBUG SMTP: got bad greeting from host \"" + str + "\", port: " + i + ", response: " + readServerResponse + "\n");
                }
                throw new MessagingException("Got bad greeting from SMTP host: " + str + ", port: " + i + ", response: " + readServerResponse);
            } else if (this.debug) {
                this.out.println("DEBUG SMTP: protocol started to host \"" + str + "\", port: " + i + "\n");
            }
        } catch (Exception e) {
            throw new MessagingException("Could not start protocol to SMTP host: " + str + ", port: " + i, e);
        }
    }

    private void openServer(String str, int i) {
        if (this.debug) {
            this.out.println("DEBUG SMTP: trying to connect to host \"" + str + "\", port " + i + ", isSSL " + this.isSSL);
        }
        try {
            this.serverSocket = SocketFetcher.getSocket(str, i, this.session.getProperties(), "mail." + this.name, this.isSSL);
            i = this.serverSocket.getPort();
            initStreams();
            int readServerResponse = readServerResponse();
            if (readServerResponse != 220) {
                this.serverSocket.close();
                this.serverSocket = null;
                this.serverOutput = null;
                this.serverInput = null;
                this.lineInputStream = null;
                if (this.debug) {
                    this.out.println("DEBUG SMTP: could not connect to host \"" + str + "\", port: " + i + ", response: " + readServerResponse + "\n");
                }
                throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + i + ", response: " + readServerResponse);
            } else if (this.debug) {
                this.out.println("DEBUG SMTP: connected to host \"" + str + "\", port: " + i + "\n");
            }
        } catch (Exception e) {
            throw new MessagingException("Unknown SMTP host: " + str, e);
        } catch (Exception e2) {
            throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + i, e2);
        }
    }

    private void sendCommand(byte[] bArr) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            try {
                this.serverOutput.write(bArr);
                this.serverOutput.write(CRLF);
                this.serverOutput.flush();
                return;
            } catch (Exception e) {
                throw new MessagingException("Can't send command to SMTP host", e);
            }
        }
        throw new AssertionError();
    }

    protected static String xtext(String str) {
        StringBuffer stringBuffer = null;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '') {
                throw new IllegalArgumentException("Non-ASCII character in SMTP submitter: " + str);
            }
            if (charAt < '!' || charAt > '~' || charAt == '+' || charAt == '=') {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.length() + 4);
                    stringBuffer.append(str.substring(0, i));
                }
                stringBuffer.append('+');
                stringBuffer.append(hexchar[(charAt & 240) >> 4]);
                stringBuffer.append(hexchar[charAt & 15]);
            } else if (stringBuffer != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer != null ? stringBuffer.toString() : str;
    }

    protected void checkConnected() {
        if (!super.isConnected()) {
            throw new IllegalStateException("Not connected");
        }
    }

    public synchronized void close() {
        if (super.isConnected()) {
            try {
                if (this.serverSocket != null) {
                    sendCommand("QUIT");
                    if (this.quitWait) {
                        int readServerResponse = readServerResponse();
                        if (!(readServerResponse == 221 || readServerResponse == -1)) {
                            this.out.println("DEBUG SMTP: QUIT failed with " + readServerResponse);
                        }
                    }
                }
            } finally {
                closeConnection();
            }
        }
    }

    public synchronized void connect(Socket socket) {
        this.serverSocket = socket;
        super.connect();
    }

    protected OutputStream data() {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            issueSendCommand("DATA", 354);
            this.dataStream = new SMTPOutputStream(this.serverOutput);
            return this.dataStream;
        }
        throw new AssertionError();
    }

    protected boolean ehlo(String str) {
        sendCommand(str != null ? "EHLO " + str : "EHLO");
        int readServerResponse = readServerResponse();
        if (readServerResponse == 250) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(this.lastServerResponse));
            this.extMap = new Hashtable();
            Object obj = 1;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (obj != null) {
                        obj = null;
                    } else if (readLine.length() >= 5) {
                        String substring = readLine.substring(4);
                        int indexOf = substring.indexOf(32);
                        readLine = "";
                        if (indexOf > 0) {
                            readLine = substring.substring(indexOf + 1);
                            substring = substring.substring(0, indexOf);
                        }
                        if (this.debug) {
                            this.out.println("DEBUG SMTP: Found extension \"" + substring + "\", arg \"" + readLine + "\"");
                        }
                        this.extMap.put(substring.toUpperCase(Locale.ENGLISH), readLine);
                    }
                } catch (IOException e) {
                }
            }
        }
        return readServerResponse == 250 ? true : $assertionsDisabled;
    }

    protected void finalize() {
        super.finalize();
        try {
            closeConnection();
        } catch (MessagingException e) {
        }
    }

    protected void finishData() {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            this.dataStream.ensureAtBOL();
            issueSendCommand(".", 250);
            return;
        }
        throw new AssertionError();
    }

    public String getExtensionParameter(String str) {
        return this.extMap == null ? null : (String) this.extMap.get(str.toUpperCase(Locale.ENGLISH));
    }

    public synchronized int getLastReturnCode() {
        return this.lastReturnCode;
    }

    public synchronized String getLastServerResponse() {
        return this.lastServerResponse;
    }

    public synchronized String getLocalHost() {
        try {
            if (this.localHostName == null || this.localHostName.length() <= 0) {
                this.localHostName = this.session.getProperty("mail." + this.name + ".localhost");
            }
            if (this.localHostName == null || this.localHostName.length() <= 0) {
                this.localHostName = this.session.getProperty("mail." + this.name + ".localaddress");
            }
            if (this.localHostName == null || this.localHostName.length() <= 0) {
                InetAddress localHost = InetAddress.getLocalHost();
                this.localHostName = localHost.getHostName();
                if (this.localHostName == null) {
                    this.localHostName = "[" + localHost.getHostAddress() + "]";
                }
            }
        } catch (UnknownHostException e) {
        }
        return this.localHostName;
    }

    public synchronized boolean getReportSuccess() {
        return this.reportSuccess;
    }

    public synchronized String getSASLRealm() {
        if (this.saslRealm == UNKNOWN) {
            this.saslRealm = this.session.getProperty("mail." + this.name + ".sasl.realm");
            if (this.saslRealm == null) {
                this.saslRealm = this.session.getProperty("mail." + this.name + ".saslrealm");
            }
        }
        return this.saslRealm;
    }

    public synchronized boolean getStartTLS() {
        return this.useStartTLS;
    }

    public synchronized boolean getUseRset() {
        return this.useRset;
    }

    protected void helo(String str) {
        if (str != null) {
            issueCommand("HELO " + str, 250);
        } else {
            issueCommand("HELO", 250);
        }
    }

    public synchronized boolean isConnected() {
        boolean z = $assertionsDisabled;
        synchronized (this) {
            if (super.isConnected()) {
                try {
                    if (this.useRset) {
                        sendCommand("RSET");
                    } else {
                        sendCommand("NOOP");
                    }
                    int readServerResponse = readServerResponse();
                    if (readServerResponse < 0 || readServerResponse == 421) {
                        try {
                            closeConnection();
                        } catch (MessagingException e) {
                        }
                    } else {
                        z = true;
                    }
                } catch (Exception e2) {
                    try {
                        closeConnection();
                    } catch (MessagingException e3) {
                    }
                }
            }
        }
        return z;
    }

    public synchronized void issueCommand(String str, int i) {
        sendCommand(str);
        if (readServerResponse() != i) {
            throw new MessagingException(this.lastServerResponse);
        }
    }

    protected void mailFrom() {
        String envelopeFrom = this.message instanceof SMTPMessage ? ((SMTPMessage) this.message).getEnvelopeFrom() : null;
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            envelopeFrom = this.session.getProperty("mail." + this.name + ".from");
        }
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            InternetAddress internetAddress;
            if (this.message != null) {
                Address[] from = this.message.getFrom();
                if (from != null && from.length > 0) {
                    internetAddress = from[0];
                    if (internetAddress == null) {
                        envelopeFrom = internetAddress.getAddress();
                    } else {
                        throw new MessagingException("can't determine local email address");
                    }
                }
            }
            internetAddress = InternetAddress.getLocalAddress(this.session);
            if (internetAddress == null) {
                throw new MessagingException("can't determine local email address");
            }
            envelopeFrom = internetAddress.getAddress();
        }
        String str = "MAIL FROM:" + normalizeAddress(envelopeFrom);
        if (supportsExtension("DSN")) {
            envelopeFrom = this.message instanceof SMTPMessage ? ((SMTPMessage) this.message).getDSNRet() : null;
            if (envelopeFrom == null) {
                envelopeFrom = this.session.getProperty("mail." + this.name + ".dsn.ret");
            }
            if (envelopeFrom != null) {
                str = new StringBuilder(String.valueOf(str)).append(" RET=").append(envelopeFrom).toString();
            }
        }
        if (supportsExtension("AUTH")) {
            envelopeFrom = this.message instanceof SMTPMessage ? ((SMTPMessage) this.message).getSubmitter() : null;
            String property = envelopeFrom == null ? this.session.getProperty("mail." + this.name + ".submitter") : envelopeFrom;
            if (property != null) {
                try {
                    str = new StringBuilder(String.valueOf(str)).append(" AUTH=").append(xtext(property)).toString();
                } catch (IllegalArgumentException e) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: ignoring invalid submitter: " + property + ", Exception: " + e);
                    }
                }
            }
        }
        envelopeFrom = this.message instanceof SMTPMessage ? ((SMTPMessage) this.message).getMailExtension() : null;
        if (envelopeFrom == null) {
            envelopeFrom = this.session.getProperty("mail." + this.name + ".mailextension");
        }
        if (envelopeFrom != null && envelopeFrom.length() > 0) {
            str = new StringBuilder(String.valueOf(str)).append(" ").append(envelopeFrom).toString();
        }
        issueSendCommand(str, 250);
    }

    protected boolean protocolConnect(java.lang.String r9, int r10, java.lang.String r11, java.lang.String r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0281 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.session;
        r1 = new java.lang.StringBuilder;
        r2 = "mail.";
        r1.<init>(r2);
        r2 = r8.name;
        r1 = r1.append(r2);
        r2 = ".ehlo";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0 = r0.getProperty(r1);
        if (r0 == 0) goto L_0x007b;
    L_0x001f:
        r1 = "false";
        r0 = r0.equalsIgnoreCase(r1);
        if (r0 == 0) goto L_0x007b;
    L_0x0027:
        r0 = 0;
    L_0x0028:
        r1 = r8.session;
        r2 = new java.lang.StringBuilder;
        r3 = "mail.";
        r2.<init>(r3);
        r3 = r8.name;
        r2 = r2.append(r3);
        r3 = ".auth";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1 = r1.getProperty(r2);
        if (r1 == 0) goto L_0x007d;
    L_0x0047:
        r2 = "true";
        r1 = r1.equalsIgnoreCase(r2);
        if (r1 == 0) goto L_0x007d;
    L_0x004f:
        r1 = 1;
        r2 = r1;
    L_0x0051:
        r1 = r8.debug;
        if (r1 == 0) goto L_0x0073;
    L_0x0055:
        r1 = r8.out;
        r3 = new java.lang.StringBuilder;
        r4 = "DEBUG SMTP: useEhlo ";
        r3.<init>(r4);
        r3 = r3.append(r0);
        r4 = ", useAuth ";
        r3 = r3.append(r4);
        r3 = r3.append(r2);
        r3 = r3.toString();
        r1.println(r3);
    L_0x0073:
        if (r2 == 0) goto L_0x0080;
    L_0x0075:
        if (r11 == 0) goto L_0x0079;
    L_0x0077:
        if (r12 != 0) goto L_0x0080;
    L_0x0079:
        r0 = 0;
    L_0x007a:
        return r0;
    L_0x007b:
        r0 = 1;
        goto L_0x0028;
    L_0x007d:
        r1 = 0;
        r2 = r1;
        goto L_0x0051;
    L_0x0080:
        r1 = -1;
        if (r10 != r1) goto L_0x00a6;
    L_0x0083:
        r1 = r8.session;
        r3 = new java.lang.StringBuilder;
        r4 = "mail.";
        r3.<init>(r4);
        r4 = r8.name;
        r3 = r3.append(r4);
        r4 = ".port";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1 = r1.getProperty(r3);
        if (r1 == 0) goto L_0x0185;
    L_0x00a2:
        r10 = java.lang.Integer.parseInt(r1);
    L_0x00a6:
        if (r9 == 0) goto L_0x00ae;
    L_0x00a8:
        r1 = r9.length();
        if (r1 != 0) goto L_0x0290;
    L_0x00ae:
        r1 = "localhost";
    L_0x00b0:
        r3 = 0;
        r4 = r8.serverSocket;
        if (r4 == 0) goto L_0x0189;
    L_0x00b5:
        r8.openServer();
    L_0x00b8:
        if (r0 == 0) goto L_0x028d;
    L_0x00ba:
        r0 = r8.getLocalHost();
        r0 = r8.ehlo(r0);
    L_0x00c2:
        if (r0 != 0) goto L_0x00cb;
    L_0x00c4:
        r0 = r8.getLocalHost();
        r8.helo(r0);
    L_0x00cb:
        r0 = r8.useStartTLS;
        if (r0 == 0) goto L_0x00e1;
    L_0x00cf:
        r0 = "STARTTLS";
        r0 = r8.supportsExtension(r0);
        if (r0 == 0) goto L_0x00e1;
    L_0x00d7:
        r8.startTLS();
        r0 = r8.getLocalHost();
        r8.ehlo(r0);
    L_0x00e1:
        if (r2 != 0) goto L_0x00e7;
    L_0x00e3:
        if (r11 == 0) goto L_0x0281;
    L_0x00e5:
        if (r12 == 0) goto L_0x0281;
    L_0x00e7:
        r0 = "AUTH";
        r0 = r8.supportsExtension(r0);
        if (r0 != 0) goto L_0x00f7;
    L_0x00ef:
        r0 = "AUTH=LOGIN";
        r0 = r8.supportsExtension(r0);
        if (r0 == 0) goto L_0x0281;
    L_0x00f7:
        r0 = r8.debug;
        if (r0 == 0) goto L_0x0119;
    L_0x00fb:
        r0 = r8.out;
        r2 = "DEBUG SMTP: Attempt to authenticate";
        r0.println(r2);
        r0 = "LOGIN";
        r0 = r8.supportsAuthentication(r0);
        if (r0 != 0) goto L_0x0119;
    L_0x010a:
        r0 = "AUTH=LOGIN";
        r0 = r8.supportsExtension(r0);
        if (r0 == 0) goto L_0x0119;
    L_0x0112:
        r0 = r8.out;
        r2 = "DEBUG SMTP: use AUTH=LOGIN hack";
        r0.println(r2);
    L_0x0119:
        r0 = "LOGIN";
        r0 = r8.supportsAuthentication(r0);
        if (r0 != 0) goto L_0x0129;
    L_0x0121:
        r0 = "AUTH=LOGIN";
        r0 = r8.supportsExtension(r0);
        if (r0 == 0) goto L_0x01a8;
    L_0x0129:
        r0 = "AUTH LOGIN";
        r0 = r8.simpleCommand(r0);
        r1 = 530; // 0x212 float:7.43E-43 double:2.62E-321;
        if (r0 != r1) goto L_0x013c;
    L_0x0133:
        r8.startTLS();
        r0 = "AUTH LOGIN";
        r0 = r8.simpleCommand(r0);
    L_0x013c:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r1.<init>();	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r2 = new com.sun.mail.util.BASE64EncoderStream;	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r2.<init>(r1, r3);	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r3 = 334; // 0x14e float:4.68E-43 double:1.65E-321;	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        if (r0 != r3) goto L_0x0162;	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
    L_0x014d:
        r3 = com.sun.mail.util.ASCIIUtility.getBytes(r11);	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r2.write(r3);	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r2.flush();	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r3 = r1.toByteArray();	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r0 = r8.simpleCommand(r3);	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r1.reset();	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
    L_0x0162:
        r3 = 334; // 0x14e float:4.68E-43 double:1.65E-321;	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        if (r0 != r3) goto L_0x017b;	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
    L_0x0166:
        r3 = com.sun.mail.util.ASCIIUtility.getBytes(r12);	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r2.write(r3);	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r2.flush();	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r2 = r1.toByteArray();	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r0 = r8.simpleCommand(r2);	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
        r1.reset();	 Catch:{ IOException -> 0x018e, all -> 0x0199 }
    L_0x017b:
        r1 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r0 == r1) goto L_0x0281;
    L_0x017f:
        r8.closeConnection();
        r0 = 0;
        goto L_0x007a;
    L_0x0185:
        r10 = r8.defaultPort;
        goto L_0x00a6;
    L_0x0189:
        r8.openServer(r1, r10);
        goto L_0x00b8;
    L_0x018e:
        r1 = move-exception;
        r1 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r0 == r1) goto L_0x0281;
    L_0x0193:
        r8.closeConnection();
        r0 = 0;
        goto L_0x007a;
    L_0x0199:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        r2 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r1 == r2) goto L_0x01a7;
    L_0x01a1:
        r8.closeConnection();
        r0 = 0;
        goto L_0x007a;
    L_0x01a7:
        throw r0;
    L_0x01a8:
        r0 = "PLAIN";
        r0 = r8.supportsAuthentication(r0);
        if (r0 == 0) goto L_0x0209;
    L_0x01b0:
        r0 = "AUTH PLAIN";
        r1 = r8.simpleCommand(r0);
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r0.<init>();	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r2 = new com.sun.mail.util.BASE64EncoderStream;	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r2.<init>(r0, r3);	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r3 = 334; // 0x14e float:4.68E-43 double:1.65E-321;	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        if (r1 != r3) goto L_0x028a;	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
    L_0x01c7:
        r3 = 0;	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r2.write(r3);	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r3 = com.sun.mail.util.ASCIIUtility.getBytes(r11);	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r2.write(r3);	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r3 = 0;	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r2.write(r3);	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r3 = com.sun.mail.util.ASCIIUtility.getBytes(r12);	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r2.write(r3);	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r2.flush();	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
        r0 = r8.simpleCommand(r0);	 Catch:{ IOException -> 0x01f2, all -> 0x01fd }
    L_0x01e8:
        r1 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r0 == r1) goto L_0x0281;
    L_0x01ec:
        r8.closeConnection();
        r0 = 0;
        goto L_0x007a;
    L_0x01f2:
        r0 = move-exception;
        r0 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r1 == r0) goto L_0x0281;
    L_0x01f7:
        r8.closeConnection();
        r0 = 0;
        goto L_0x007a;
    L_0x01fd:
        r0 = move-exception;
        r2 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r1 == r2) goto L_0x0208;
    L_0x0202:
        r8.closeConnection();
        r0 = 0;
        goto L_0x007a;
    L_0x0208:
        throw r0;
    L_0x0209:
        r0 = "DIGEST-MD5";
        r0 = r8.supportsAuthentication(r0);
        if (r0 == 0) goto L_0x0281;
    L_0x0211:
        r0 = r8.getMD5();
        if (r0 == 0) goto L_0x0281;
    L_0x0217:
        r2 = "AUTH DIGEST-MD5";
        r6 = r8.simpleCommand(r2);
        r2 = 334; // 0x14e float:4.68E-43 double:1.65E-321;
        if (r6 != r2) goto L_0x0288;
    L_0x0221:
        r4 = r8.getSASLRealm();	 Catch:{ Exception -> 0x0250, all -> 0x0274 }
        r5 = r8.lastServerResponse;	 Catch:{ Exception -> 0x0250, all -> 0x0274 }
        r2 = r11;	 Catch:{ Exception -> 0x0250, all -> 0x0274 }
        r3 = r12;	 Catch:{ Exception -> 0x0250, all -> 0x0274 }
        r1 = r0.authClient(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0250, all -> 0x0274 }
        r1 = r8.simpleCommand(r1);	 Catch:{ Exception -> 0x0250, all -> 0x0274 }
        r2 = 334; // 0x14e float:4.68E-43 double:1.65E-321;
        if (r1 != r2) goto L_0x023e;
    L_0x0235:
        r2 = r8.lastServerResponse;	 Catch:{ Exception -> 0x0286 }
        r0 = r0.authServer(r2);	 Catch:{ Exception -> 0x0286 }
        if (r0 != 0) goto L_0x0248;
    L_0x023d:
        r1 = -1;
    L_0x023e:
        r0 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r1 == r0) goto L_0x0281;
    L_0x0242:
        r8.closeConnection();
        r0 = 0;
        goto L_0x007a;
    L_0x0248:
        r0 = 0;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x0286 }
        r1 = r8.simpleCommand(r0);	 Catch:{ Exception -> 0x0286 }
        goto L_0x023e;
    L_0x0250:
        r0 = move-exception;
        r1 = r6;
    L_0x0252:
        r2 = r8.debug;	 Catch:{ all -> 0x0284 }
        if (r2 == 0) goto L_0x026a;	 Catch:{ all -> 0x0284 }
    L_0x0256:
        r2 = r8.out;	 Catch:{ all -> 0x0284 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0284 }
        r4 = "DEBUG SMTP: DIGEST-MD5: ";	 Catch:{ all -> 0x0284 }
        r3.<init>(r4);	 Catch:{ all -> 0x0284 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x0284 }
        r0 = r0.toString();	 Catch:{ all -> 0x0284 }
        r2.println(r0);	 Catch:{ all -> 0x0284 }
    L_0x026a:
        r0 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r1 == r0) goto L_0x0281;
    L_0x026e:
        r8.closeConnection();
        r0 = 0;
        goto L_0x007a;
    L_0x0274:
        r0 = move-exception;
        r1 = r6;
    L_0x0276:
        r2 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        if (r1 == r2) goto L_0x0280;
    L_0x027a:
        r8.closeConnection();
        r0 = 0;
        goto L_0x007a;
    L_0x0280:
        throw r0;
    L_0x0281:
        r0 = 1;
        goto L_0x007a;
    L_0x0284:
        r0 = move-exception;
        goto L_0x0276;
    L_0x0286:
        r0 = move-exception;
        goto L_0x0252;
    L_0x0288:
        r1 = r6;
        goto L_0x023e;
    L_0x028a:
        r0 = r1;
        goto L_0x01e8;
    L_0x028d:
        r0 = r3;
        goto L_0x00c2;
    L_0x0290:
        r1 = r9;
        goto L_0x00b0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.protocolConnect(java.lang.String, int, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void rcptTo() {
        /*
        r14 = this;
        r9 = new java.util.Vector;
        r9.<init>();
        r10 = new java.util.Vector;
        r10.<init>();
        r11 = new java.util.Vector;
        r11.<init>();
        r6 = 0;
        r4 = 0;
        r0 = 0;
        r14.invalidAddr = r0;
        r14.validUnsentAddr = r0;
        r14.validSentAddr = r0;
        r0 = 0;
        r1 = r14.message;
        r1 = r1 instanceof com.sun.mail.smtp.SMTPMessage;
        if (r1 == 0) goto L_0x0027;
    L_0x001f:
        r0 = r14.message;
        r0 = (com.sun.mail.smtp.SMTPMessage) r0;
        r0 = r0.getSendPartial();
    L_0x0027:
        if (r0 != 0) goto L_0x033d;
    L_0x0029:
        r0 = r14.session;
        r1 = new java.lang.StringBuilder;
        r2 = "mail.";
        r1.<init>(r2);
        r2 = r14.name;
        r1 = r1.append(r2);
        r2 = ".sendpartial";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0 = r0.getProperty(r1);
        if (r0 == 0) goto L_0x015b;
    L_0x0048:
        r1 = "true";
        r0 = r0.equalsIgnoreCase(r1);
        if (r0 == 0) goto L_0x015b;
    L_0x0050:
        r0 = 1;
    L_0x0051:
        r1 = r0;
    L_0x0052:
        r0 = r14.debug;
        if (r0 == 0) goto L_0x005f;
    L_0x0056:
        if (r1 == 0) goto L_0x005f;
    L_0x0058:
        r0 = r14.out;
        r2 = "DEBUG SMTP: sendPartial set";
        r0.println(r2);
    L_0x005f:
        r2 = 0;
        r0 = 0;
        r3 = "DSN";
        r3 = r14.supportsExtension(r3);
        if (r3 == 0) goto L_0x0339;
    L_0x0069:
        r3 = r14.message;
        r3 = r3 instanceof com.sun.mail.smtp.SMTPMessage;
        if (r3 == 0) goto L_0x0077;
    L_0x006f:
        r0 = r14.message;
        r0 = (com.sun.mail.smtp.SMTPMessage) r0;
        r0 = r0.getDSNNotify();
    L_0x0077:
        if (r0 != 0) goto L_0x0096;
    L_0x0079:
        r0 = r14.session;
        r3 = new java.lang.StringBuilder;
        r5 = "mail.";
        r3.<init>(r5);
        r5 = r14.name;
        r3 = r3.append(r5);
        r5 = ".dsn.notify";
        r3 = r3.append(r5);
        r3 = r3.toString();
        r0 = r0.getProperty(r3);
    L_0x0096:
        if (r0 == 0) goto L_0x0335;
    L_0x0098:
        r2 = 1;
        r3 = r2;
        r2 = r0;
    L_0x009b:
        r0 = 0;
        r7 = r0;
    L_0x009d:
        r0 = r14.addresses;
        r0 = r0.length;
        if (r7 < r0) goto L_0x015e;
    L_0x00a2:
        if (r1 == 0) goto L_0x00ab;
    L_0x00a4:
        r0 = r9.size();
        if (r0 != 0) goto L_0x00ab;
    L_0x00aa:
        r4 = 1;
    L_0x00ab:
        if (r4 == 0) goto L_0x027c;
    L_0x00ad:
        r0 = r11.size();
        r0 = new javax.mail.Address[r0];
        r14.invalidAddr = r0;
        r0 = r14.invalidAddr;
        r11.copyInto(r0);
        r0 = r9.size();
        r1 = r10.size();
        r0 = r0 + r1;
        r0 = new javax.mail.Address[r0];
        r14.validUnsentAddr = r0;
        r1 = 0;
        r0 = 0;
        r2 = r1;
        r1 = r0;
    L_0x00cb:
        r0 = r9.size();
        if (r1 < r0) goto L_0x0258;
    L_0x00d1:
        r0 = 0;
        r1 = r0;
    L_0x00d3:
        r0 = r10.size();
        if (r1 < r0) goto L_0x026a;
    L_0x00d9:
        r0 = r14.debug;
        if (r0 == 0) goto L_0x011f;
    L_0x00dd:
        r0 = r14.validSentAddr;
        if (r0 == 0) goto L_0x00f3;
    L_0x00e1:
        r0 = r14.validSentAddr;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x00f3;
    L_0x00e6:
        r0 = r14.out;
        r1 = "DEBUG SMTP: Verified Addresses";
        r0.println(r1);
        r0 = 0;
    L_0x00ee:
        r1 = r14.validSentAddr;
        r1 = r1.length;
        if (r0 < r1) goto L_0x02c2;
    L_0x00f3:
        r0 = r14.validUnsentAddr;
        if (r0 == 0) goto L_0x0109;
    L_0x00f7:
        r0 = r14.validUnsentAddr;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x0109;
    L_0x00fc:
        r0 = r14.out;
        r1 = "DEBUG SMTP: Valid Unsent Addresses";
        r0.println(r1);
        r0 = 0;
    L_0x0104:
        r1 = r14.validUnsentAddr;
        r1 = r1.length;
        if (r0 < r1) goto L_0x02de;
    L_0x0109:
        r0 = r14.invalidAddr;
        if (r0 == 0) goto L_0x011f;
    L_0x010d:
        r0 = r14.invalidAddr;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x011f;
    L_0x0112:
        r0 = r14.out;
        r1 = "DEBUG SMTP: Invalid Addresses";
        r0.println(r1);
        r0 = 0;
    L_0x011a:
        r1 = r14.invalidAddr;
        r1 = r1.length;
        if (r0 < r1) goto L_0x02fa;
    L_0x011f:
        if (r4 == 0) goto L_0x0331;
    L_0x0121:
        r0 = r14.debug;
        if (r0 == 0) goto L_0x012c;
    L_0x0125:
        r0 = r14.out;
        r1 = "DEBUG SMTP: Sending failed because of invalid destination addresses";
        r0.println(r1);
    L_0x012c:
        r1 = 2;
        r2 = r14.validSentAddr;
        r3 = r14.validUnsentAddr;
        r4 = r14.invalidAddr;
        r5 = r14.message;
        r0 = r14;
        r0.notifyTransportListeners(r1, r2, r3, r4, r5);
        r1 = r14.lastServerResponse;
        r2 = r14.lastReturnCode;
        r0 = r14.serverSocket;	 Catch:{ MessagingException -> 0x0316 }
        if (r0 == 0) goto L_0x0148;
    L_0x0141:
        r0 = "RSET";
        r3 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r14.issueCommand(r0, r3);	 Catch:{ MessagingException -> 0x0316 }
    L_0x0148:
        r14.lastServerResponse = r1;
        r14.lastReturnCode = r2;
    L_0x014c:
        r0 = new javax.mail.SendFailedException;
        r1 = "Invalid Addresses";
        r3 = r14.validSentAddr;
        r4 = r14.validUnsentAddr;
        r5 = r14.invalidAddr;
        r2 = r6;
        r0.<init>(r1, r2, r3, r4, r5);
        throw r0;
    L_0x015b:
        r0 = 0;
        goto L_0x0051;
    L_0x015e:
        r0 = r14.addresses;
        r0 = r0[r7];
        r0 = (javax.mail.internet.InternetAddress) r0;
        r5 = new java.lang.StringBuilder;
        r8 = "RCPT TO:";
        r5.<init>(r8);
        r8 = r0.getAddress();
        r8 = r14.normalizeAddress(r8);
        r5 = r5.append(r8);
        r5 = r5.toString();
        if (r3 == 0) goto L_0x0332;
    L_0x017d:
        r8 = new java.lang.StringBuilder;
        r5 = java.lang.String.valueOf(r5);
        r8.<init>(r5);
        r5 = " NOTIFY=";
        r5 = r8.append(r5);
        r5 = r5.append(r2);
        r5 = r5.toString();
        r8 = r5;
    L_0x0195:
        r14.sendCommand(r8);
        r12 = r14.readServerResponse();
        switch(r12) {
            case 250: goto L_0x01bf;
            case 251: goto L_0x01bf;
            case 450: goto L_0x01f0;
            case 451: goto L_0x01f0;
            case 452: goto L_0x01f0;
            case 501: goto L_0x01d8;
            case 503: goto L_0x01d8;
            case 550: goto L_0x01d8;
            case 551: goto L_0x01d8;
            case 552: goto L_0x01f0;
            case 553: goto L_0x01d8;
            default: goto L_0x019f;
        };
    L_0x019f:
        r5 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r12 < r5) goto L_0x0208;
    L_0x01a3:
        r5 = 499; // 0x1f3 float:6.99E-43 double:2.465E-321;
        if (r12 > r5) goto L_0x0208;
    L_0x01a7:
        r10.addElement(r0);
    L_0x01aa:
        if (r1 != 0) goto L_0x01ad;
    L_0x01ac:
        r4 = 1;
    L_0x01ad:
        r5 = new com.sun.mail.smtp.SMTPAddressFailedException;
        r13 = r14.lastServerResponse;
        r5.<init>(r0, r8, r12, r13);
        if (r6 != 0) goto L_0x0251;
    L_0x01b6:
        r0 = r4;
        r4 = r5;
    L_0x01b8:
        r5 = r7 + 1;
        r7 = r5;
        r6 = r4;
        r4 = r0;
        goto L_0x009d;
    L_0x01bf:
        r9.addElement(r0);
        r5 = r14.reportSuccess;
        if (r5 == 0) goto L_0x0254;
    L_0x01c6:
        r5 = new com.sun.mail.smtp.SMTPAddressSucceededException;
        r13 = r14.lastServerResponse;
        r5.<init>(r0, r8, r12, r13);
        if (r6 != 0) goto L_0x01d2;
    L_0x01cf:
        r0 = r4;
        r4 = r5;
        goto L_0x01b8;
    L_0x01d2:
        r6.setNextException(r5);
        r0 = r4;
        r4 = r6;
        goto L_0x01b8;
    L_0x01d8:
        if (r1 != 0) goto L_0x01db;
    L_0x01da:
        r4 = 1;
    L_0x01db:
        r11.addElement(r0);
        r5 = new com.sun.mail.smtp.SMTPAddressFailedException;
        r13 = r14.lastServerResponse;
        r5.<init>(r0, r8, r12, r13);
        if (r6 != 0) goto L_0x01ea;
    L_0x01e7:
        r0 = r4;
        r4 = r5;
        goto L_0x01b8;
    L_0x01ea:
        r6.setNextException(r5);
        r0 = r4;
        r4 = r6;
        goto L_0x01b8;
    L_0x01f0:
        if (r1 != 0) goto L_0x01f3;
    L_0x01f2:
        r4 = 1;
    L_0x01f3:
        r10.addElement(r0);
        r5 = new com.sun.mail.smtp.SMTPAddressFailedException;
        r13 = r14.lastServerResponse;
        r5.<init>(r0, r8, r12, r13);
        if (r6 != 0) goto L_0x0202;
    L_0x01ff:
        r0 = r4;
        r4 = r5;
        goto L_0x01b8;
    L_0x0202:
        r6.setNextException(r5);
        r0 = r4;
        r4 = r6;
        goto L_0x01b8;
    L_0x0208:
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r12 < r5) goto L_0x0214;
    L_0x020c:
        r5 = 599; // 0x257 float:8.4E-43 double:2.96E-321;
        if (r12 > r5) goto L_0x0214;
    L_0x0210:
        r11.addElement(r0);
        goto L_0x01aa;
    L_0x0214:
        r1 = r14.debug;
        if (r1 == 0) goto L_0x0238;
    L_0x0218:
        r1 = r14.out;
        r2 = new java.lang.StringBuilder;
        r3 = "DEBUG SMTP: got response code ";
        r2.<init>(r3);
        r2 = r2.append(r12);
        r3 = ", with response: ";
        r2 = r2.append(r3);
        r3 = r14.lastServerResponse;
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.println(r2);
    L_0x0238:
        r1 = r14.lastServerResponse;
        r2 = r14.lastReturnCode;
        r3 = r14.serverSocket;
        if (r3 == 0) goto L_0x0247;
    L_0x0240:
        r3 = "RSET";
        r4 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r14.issueCommand(r3, r4);
    L_0x0247:
        r14.lastServerResponse = r1;
        r14.lastReturnCode = r2;
        r2 = new com.sun.mail.smtp.SMTPAddressFailedException;
        r2.<init>(r0, r8, r12, r1);
        throw r2;
    L_0x0251:
        r6.setNextException(r5);
    L_0x0254:
        r0 = r4;
        r4 = r6;
        goto L_0x01b8;
    L_0x0258:
        r5 = r14.validUnsentAddr;
        r3 = r2 + 1;
        r0 = r9.elementAt(r1);
        r0 = (javax.mail.Address) r0;
        r5[r2] = r0;
        r0 = r1 + 1;
        r1 = r0;
        r2 = r3;
        goto L_0x00cb;
    L_0x026a:
        r5 = r14.validUnsentAddr;
        r3 = r2 + 1;
        r0 = r10.elementAt(r1);
        r0 = (javax.mail.Address) r0;
        r5[r2] = r0;
        r0 = r1 + 1;
        r1 = r0;
        r2 = r3;
        goto L_0x00d3;
    L_0x027c:
        r0 = r14.reportSuccess;
        if (r0 != 0) goto L_0x028e;
    L_0x0280:
        if (r1 == 0) goto L_0x02bc;
    L_0x0282:
        r0 = r11.size();
        if (r0 > 0) goto L_0x028e;
    L_0x0288:
        r0 = r10.size();
        if (r0 <= 0) goto L_0x02bc;
    L_0x028e:
        r0 = 1;
        r14.sendPartiallyFailed = r0;
        r14.exception = r6;
        r0 = r11.size();
        r0 = new javax.mail.Address[r0];
        r14.invalidAddr = r0;
        r0 = r14.invalidAddr;
        r11.copyInto(r0);
        r0 = r10.size();
        r0 = new javax.mail.Address[r0];
        r14.validUnsentAddr = r0;
        r0 = r14.validUnsentAddr;
        r10.copyInto(r0);
        r0 = r9.size();
        r0 = new javax.mail.Address[r0];
        r14.validSentAddr = r0;
        r0 = r14.validSentAddr;
        r9.copyInto(r0);
        goto L_0x00d9;
    L_0x02bc:
        r0 = r14.addresses;
        r14.validSentAddr = r0;
        goto L_0x00d9;
    L_0x02c2:
        r1 = r14.out;
        r2 = new java.lang.StringBuilder;
        r3 = "DEBUG SMTP:   ";
        r2.<init>(r3);
        r3 = r14.validSentAddr;
        r3 = r3[r0];
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.println(r2);
        r0 = r0 + 1;
        goto L_0x00ee;
    L_0x02de:
        r1 = r14.out;
        r2 = new java.lang.StringBuilder;
        r3 = "DEBUG SMTP:   ";
        r2.<init>(r3);
        r3 = r14.validUnsentAddr;
        r3 = r3[r0];
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.println(r2);
        r0 = r0 + 1;
        goto L_0x0104;
    L_0x02fa:
        r1 = r14.out;
        r2 = new java.lang.StringBuilder;
        r3 = "DEBUG SMTP:   ";
        r2.<init>(r3);
        r3 = r14.invalidAddr;
        r3 = r3[r0];
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.println(r2);
        r0 = r0 + 1;
        goto L_0x011a;
    L_0x0316:
        r0 = move-exception;
        r14.close();	 Catch:{ MessagingException -> 0x0320 }
    L_0x031a:
        r14.lastServerResponse = r1;
        r14.lastReturnCode = r2;
        goto L_0x014c;
    L_0x0320:
        r0 = move-exception;
        r3 = r14.debug;	 Catch:{ all -> 0x032b }
        if (r3 == 0) goto L_0x031a;
    L_0x0325:
        r3 = r14.out;	 Catch:{ all -> 0x032b }
        r0.printStackTrace(r3);	 Catch:{ all -> 0x032b }
        goto L_0x031a;
    L_0x032b:
        r0 = move-exception;
        r14.lastServerResponse = r1;
        r14.lastReturnCode = r2;
        throw r0;
    L_0x0331:
        return;
    L_0x0332:
        r8 = r5;
        goto L_0x0195;
    L_0x0335:
        r3 = r2;
        r2 = r0;
        goto L_0x009b;
    L_0x0339:
        r3 = r2;
        r2 = r0;
        goto L_0x009b;
    L_0x033d:
        r1 = r0;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.rcptTo():void");
    }

    protected int readServerResponse() {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            String readLine;
            int i;
            StringBuffer stringBuffer = new StringBuffer(100);
            do {
                try {
                    readLine = this.lineInputStream.readLine();
                    if (readLine == null) {
                        String stringBuffer2 = stringBuffer.toString();
                        if (stringBuffer2.length() == 0) {
                            stringBuffer2 = "[EOF]";
                        }
                        this.lastServerResponse = stringBuffer2;
                        this.lastReturnCode = -1;
                        if (!this.debug) {
                            return -1;
                        }
                        this.out.println("DEBUG SMTP: EOF: " + stringBuffer2);
                        return -1;
                    }
                    stringBuffer.append(readLine);
                    stringBuffer.append("\n");
                } catch (Exception e) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: exception reading response: " + e);
                    }
                    this.lastServerResponse = "";
                    this.lastReturnCode = 0;
                    throw new MessagingException("Exception reading response", e);
                }
            } while (isNotLastLine(readLine));
            readLine = stringBuffer.toString();
            if (readLine == null || readLine.length() < 3) {
                i = -1;
            } else {
                try {
                    i = Integer.parseInt(readLine.substring(0, 3));
                } catch (NumberFormatException e2) {
                    try {
                        close();
                    } catch (MessagingException e3) {
                        if (this.debug) {
                            e3.printStackTrace(this.out);
                        }
                    }
                    i = -1;
                } catch (StringIndexOutOfBoundsException e4) {
                    try {
                        close();
                    } catch (MessagingException e32) {
                        if (this.debug) {
                            e32.printStackTrace(this.out);
                        }
                    }
                    i = -1;
                }
            }
            if (i == -1 && this.debug) {
                this.out.println("DEBUG SMTP: bad server response: " + readLine);
            }
            this.lastServerResponse = readLine;
            this.lastReturnCode = i;
            return i;
        }
        throw new AssertionError();
    }

    protected void sendCommand(String str) {
        sendCommand(ASCIIUtility.getBytes(str));
    }

    public synchronized void sendMessage(Message message, Address[] addressArr) {
        checkConnected();
        if (message instanceof MimeMessage) {
            int i = 0;
            while (i < addressArr.length) {
                if (addressArr[i] instanceof InternetAddress) {
                    i++;
                } else {
                    throw new MessagingException(addressArr[i] + " is not an InternetAddress");
                }
            }
            this.message = (MimeMessage) message;
            this.addresses = addressArr;
            this.validUnsentAddr = addressArr;
            expandGroups();
            boolean allow8bitMIME = message instanceof SMTPMessage ? ((SMTPMessage) message).getAllow8bitMIME() : $assertionsDisabled;
            if (!allow8bitMIME) {
                String property = this.session.getProperty("mail." + this.name + ".allow8bitmime");
                allow8bitMIME = (property == null || !property.equalsIgnoreCase("true")) ? $assertionsDisabled : true;
            }
            if (this.debug) {
                this.out.println("DEBUG SMTP: use8bit " + allow8bitMIME);
            }
            if (allow8bitMIME && supportsExtension("8BITMIME") && convertTo8Bit(this.message)) {
                try {
                    this.message.saveChanges();
                } catch (MessagingException e) {
                }
            }
            try {
                mailFrom();
                rcptTo();
                this.message.writeTo(data(), ignoreList);
                finishData();
                if (this.sendPartiallyFailed) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: Sending partially failed because of invalid destination addresses");
                    }
                    notifyTransportListeners(3, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                    throw new SMTPSendFailedException(".", this.lastReturnCode, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
                }
                notifyTransportListeners(1, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                this.invalidAddr = null;
                this.validUnsentAddr = null;
                this.validSentAddr = null;
                this.addresses = null;
                this.message = null;
                this.exception = null;
                this.sendPartiallyFailed = $assertionsDisabled;
            } catch (MessagingException e2) {
                MessagingException messagingException = e2;
                if (this.debug) {
                    messagingException.printStackTrace(this.out);
                }
                notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                throw messagingException;
            } catch (Exception e3) {
                Exception exception = e3;
                if (this.debug) {
                    exception.printStackTrace(this.out);
                }
                try {
                    closeConnection();
                } catch (MessagingException e4) {
                }
                notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                throw new MessagingException("IOException while sending message", exception);
            } catch (Throwable th) {
                this.invalidAddr = null;
                this.validUnsentAddr = null;
                this.validSentAddr = null;
                this.addresses = null;
                this.message = null;
                this.exception = null;
                this.sendPartiallyFailed = $assertionsDisabled;
            }
        } else {
            if (this.debug) {
                this.out.println("DEBUG SMTP: Can only send RFC822 msgs");
            }
            throw new MessagingException("SMTP can only send RFC822 messages");
        }
    }

    public synchronized void setLocalHost(String str) {
        this.localHostName = str;
    }

    public synchronized void setReportSuccess(boolean z) {
        this.reportSuccess = z;
    }

    public synchronized void setSASLRealm(String str) {
        this.saslRealm = str;
    }

    public synchronized void setStartTLS(boolean z) {
        this.useStartTLS = z;
    }

    public synchronized void setUseRset(boolean z) {
        this.useRset = z;
    }

    public synchronized int simpleCommand(String str) {
        sendCommand(str);
        return readServerResponse();
    }

    protected int simpleCommand(byte[] bArr) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            sendCommand(bArr);
            return readServerResponse();
        }
        throw new AssertionError();
    }

    protected void startTLS() {
        issueCommand("STARTTLS", 220);
        try {
            this.serverSocket = SocketFetcher.startTLS(this.serverSocket, this.session.getProperties(), "mail." + this.name);
            initStreams();
        } catch (Exception e) {
            closeConnection();
            throw new MessagingException("Could not convert socket to TLS", e);
        }
    }

    protected boolean supportsAuthentication(String str) {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.extMap == null) {
            return $assertionsDisabled;
        } else {
            String str2 = (String) this.extMap.get("AUTH");
            if (str2 == null) {
                return $assertionsDisabled;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str2);
            while (stringTokenizer.hasMoreTokens()) {
                if (stringTokenizer.nextToken().equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return $assertionsDisabled;
        }
    }

    public boolean supportsExtension(String str) {
        return (this.extMap == null || this.extMap.get(str.toUpperCase(Locale.ENGLISH)) == null) ? $assertionsDisabled : true;
    }
}
