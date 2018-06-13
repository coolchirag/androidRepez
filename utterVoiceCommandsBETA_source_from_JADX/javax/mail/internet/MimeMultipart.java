package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessageAware;
import javax.mail.Multipart;
import javax.mail.MultipartDataSource;
import winterwell.jtwitter.Twitter;

public class MimeMultipart extends Multipart {
    private static boolean bmparse;
    private static boolean ignoreMissingBoundaryParameter;
    private static boolean ignoreMissingEndBoundary;
    private boolean complete;
    protected DataSource ds;
    protected boolean parsed;
    private String preamble;

    static {
        boolean z = false;
        ignoreMissingEndBoundary = true;
        ignoreMissingBoundaryParameter = true;
        bmparse = true;
        try {
            String property = System.getProperty("mail.mime.multipart.ignoremissingendboundary");
            boolean z2 = property == null || !property.equalsIgnoreCase("false");
            ignoreMissingEndBoundary = z2;
            property = System.getProperty("mail.mime.multipart.ignoremissingboundaryparameter");
            z2 = property == null || !property.equalsIgnoreCase("false");
            ignoreMissingBoundaryParameter = z2;
            property = System.getProperty("mail.mime.multipart.bmparse");
            if (property == null || !property.equalsIgnoreCase("false")) {
                z = true;
            }
            bmparse = z;
        } catch (SecurityException e) {
        }
    }

    public MimeMultipart() {
        this(Twitter.SEARCH_MIXED);
    }

    public MimeMultipart(String str) {
        this.ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        String uniqueBoundaryValue = UniqueValue.getUniqueBoundaryValue();
        ContentType contentType = new ContentType("multipart", str, null);
        contentType.setParameter("boundary", uniqueBoundaryValue);
        this.contentType = contentType.toString();
    }

    public MimeMultipart(DataSource dataSource) {
        this.ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        if (dataSource instanceof MessageAware) {
            setParent(((MessageAware) dataSource).getMessageContext().getPart());
        }
        if (dataSource instanceof MultipartDataSource) {
            setMultipartDataSource((MultipartDataSource) dataSource);
            return;
        }
        this.parsed = false;
        this.ds = dataSource;
        this.contentType = dataSource.getContentType();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void parsebm() {
        /*
        r25 = this;
        monitor-enter(r25);
        r0 = r25;
        r2 = r0.parsed;	 Catch:{ all -> 0x007a }
        if (r2 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r25);
        return;
    L_0x0009:
        r2 = 0;
        r9 = 0;
        r4 = 0;
        r0 = r25;
        r3 = r0.ds;	 Catch:{ Exception -> 0x007d }
        r6 = r3.getInputStream();	 Catch:{ Exception -> 0x007d }
        r3 = r6 instanceof java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x007d }
        if (r3 != 0) goto L_0x0344;
    L_0x001a:
        r3 = r6 instanceof java.io.BufferedInputStream;	 Catch:{ Exception -> 0x007d }
        if (r3 != 0) goto L_0x0344;
    L_0x001e:
        r3 = r6 instanceof javax.mail.internet.SharedInputStream;	 Catch:{ Exception -> 0x007d }
        if (r3 != 0) goto L_0x0344;
    L_0x0022:
        r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x007d }
        r3.<init>(r6);	 Catch:{ Exception -> 0x007d }
    L_0x0027:
        r6 = r3 instanceof javax.mail.internet.SharedInputStream;	 Catch:{ all -> 0x007a }
        if (r6 == 0) goto L_0x0340;
    L_0x002b:
        r0 = r3;
        r0 = (javax.mail.internet.SharedInputStream) r0;	 Catch:{ all -> 0x007a }
        r2 = r0;
        r17 = r2;
    L_0x0031:
        r2 = new javax.mail.internet.ContentType;	 Catch:{ all -> 0x007a }
        r0 = r25;
        r6 = r0.contentType;	 Catch:{ all -> 0x007a }
        r2.<init>(r6);	 Catch:{ all -> 0x007a }
        r6 = 0;
        r7 = "boundary";
        r2 = r2.getParameter(r7);	 Catch:{ all -> 0x007a }
        if (r2 == 0) goto L_0x0086;
    L_0x0043:
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007a }
        r7 = "--";
        r6.<init>(r7);	 Catch:{ all -> 0x007a }
        r2 = r6.append(r2);	 Catch:{ all -> 0x007a }
        r6 = r2.toString();	 Catch:{ all -> 0x007a }
    L_0x0052:
        r18 = new com.sun.mail.util.LineInputStream;	 Catch:{ IOException -> 0x006c }
        r0 = r18;
        r0.<init>(r3);	 Catch:{ IOException -> 0x006c }
        r2 = 0;
        r7 = 0;
        r11 = r2;
    L_0x005c:
        r2 = r18.readLine();	 Catch:{ IOException -> 0x006c }
        if (r2 != 0) goto L_0x0092;
    L_0x0062:
        if (r2 != 0) goto L_0x00ed;
    L_0x0064:
        r2 = new javax.mail.MessagingException;	 Catch:{ IOException -> 0x006c }
        r4 = "Missing start boundary";
        r2.<init>(r4);	 Catch:{ IOException -> 0x006c }
        throw r2;	 Catch:{ IOException -> 0x006c }
    L_0x006c:
        r2 = move-exception;
        r4 = new javax.mail.MessagingException;	 Catch:{ all -> 0x0075 }
        r5 = "IO Error";
        r4.<init>(r5, r2);	 Catch:{ all -> 0x0075 }
        throw r4;	 Catch:{ all -> 0x0075 }
    L_0x0075:
        r2 = move-exception;
        r3.close();	 Catch:{ IOException -> 0x0329 }
    L_0x0079:
        throw r2;	 Catch:{ all -> 0x007a }
    L_0x007a:
        r2 = move-exception;
        monitor-exit(r25);
        throw r2;
    L_0x007d:
        r2 = move-exception;
        r3 = new javax.mail.MessagingException;	 Catch:{ all -> 0x007a }
        r4 = "No inputstream from datasource";
        r3.<init>(r4, r2);	 Catch:{ all -> 0x007a }
        throw r3;	 Catch:{ all -> 0x007a }
    L_0x0086:
        r2 = ignoreMissingBoundaryParameter;	 Catch:{ all -> 0x007a }
        if (r2 != 0) goto L_0x0052;
    L_0x008a:
        r2 = new javax.mail.MessagingException;	 Catch:{ all -> 0x007a }
        r3 = "Missing boundary parameter";
        r2.<init>(r3);	 Catch:{ all -> 0x007a }
        throw r2;	 Catch:{ all -> 0x007a }
    L_0x0092:
        r8 = r2.length();	 Catch:{ IOException -> 0x006c }
        r8 = r8 + -1;
    L_0x0098:
        if (r8 >= 0) goto L_0x00cf;
    L_0x009a:
        r12 = 0;
        r8 = r8 + 1;
        r2 = r2.substring(r12, r8);	 Catch:{ IOException -> 0x006c }
        if (r6 == 0) goto L_0x00de;
    L_0x00a3:
        r8 = r2.equals(r6);	 Catch:{ IOException -> 0x006c }
        if (r8 != 0) goto L_0x0062;
    L_0x00a9:
        r8 = r2.length();	 Catch:{ IOException -> 0x006c }
        if (r8 <= 0) goto L_0x005c;
    L_0x00af:
        if (r7 != 0) goto L_0x00b9;
    L_0x00b1:
        r7 = "line.separator";
        r8 = "\n";
        r7 = java.lang.System.getProperty(r7, r8);	 Catch:{ SecurityException -> 0x00e9 }
    L_0x00b9:
        if (r11 != 0) goto L_0x033d;
    L_0x00bb:
        r8 = new java.lang.StringBuffer;	 Catch:{ IOException -> 0x006c }
        r11 = r2.length();	 Catch:{ IOException -> 0x006c }
        r11 = r11 + 2;
        r8.<init>(r11);	 Catch:{ IOException -> 0x006c }
    L_0x00c6:
        r2 = r8.append(r2);	 Catch:{ IOException -> 0x006c }
        r2.append(r7);	 Catch:{ IOException -> 0x006c }
        r11 = r8;
        goto L_0x005c;
    L_0x00cf:
        r12 = r2.charAt(r8);	 Catch:{ IOException -> 0x006c }
        r13 = 32;
        if (r12 == r13) goto L_0x00db;
    L_0x00d7:
        r13 = 9;
        if (r12 != r13) goto L_0x009a;
    L_0x00db:
        r8 = r8 + -1;
        goto L_0x0098;
    L_0x00de:
        r8 = "--";
        r8 = r2.startsWith(r8);	 Catch:{ IOException -> 0x006c }
        if (r8 == 0) goto L_0x00a9;
    L_0x00e6:
        r6 = r2;
        goto L_0x0062;
    L_0x00e9:
        r7 = move-exception;
        r7 = "\n";
        goto L_0x00b9;
    L_0x00ed:
        if (r11 == 0) goto L_0x00f7;
    L_0x00ef:
        r2 = r11.toString();	 Catch:{ IOException -> 0x006c }
        r0 = r25;
        r0.preamble = r2;	 Catch:{ IOException -> 0x006c }
    L_0x00f7:
        r19 = com.sun.mail.util.ASCIIUtility.getBytes(r6);	 Catch:{ IOException -> 0x006c }
        r0 = r19;
        r0 = r0.length;	 Catch:{ IOException -> 0x006c }
        r16 = r0;
        r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r0 = new int[r2];	 Catch:{ IOException -> 0x006c }
        r20 = r0;
        r2 = 0;
    L_0x0107:
        r0 = r16;
        if (r2 < r0) goto L_0x012a;
    L_0x010b:
        r0 = r16;
        r0 = new int[r0];	 Catch:{ IOException -> 0x006c }
        r21 = r0;
        r6 = r16;
    L_0x0113:
        if (r6 > 0) goto L_0x0133;
    L_0x0115:
        r2 = r16 + -1;
        r6 = 1;
        r21[r2] = r6;	 Catch:{ IOException -> 0x006c }
        r2 = 0;
        r11 = r2;
        r6 = r4;
        r4 = r9;
    L_0x011e:
        if (r11 == 0) goto L_0x0151;
    L_0x0120:
        r3.close();	 Catch:{ IOException -> 0x032c }
    L_0x0123:
        r2 = 1;
        r0 = r25;
        r0.parsed = r2;	 Catch:{ all -> 0x007a }
        goto L_0x0007;
    L_0x012a:
        r6 = r19[r2];	 Catch:{ IOException -> 0x006c }
        r7 = r2 + 1;
        r20[r6] = r7;	 Catch:{ IOException -> 0x006c }
        r2 = r2 + 1;
        goto L_0x0107;
    L_0x0133:
        r2 = r16 + -1;
    L_0x0135:
        if (r2 >= r6) goto L_0x013d;
    L_0x0137:
        if (r2 > 0) goto L_0x014c;
    L_0x0139:
        r2 = r6 + -1;
        r6 = r2;
        goto L_0x0113;
    L_0x013d:
        r7 = r19[r2];	 Catch:{ IOException -> 0x006c }
        r8 = r2 - r6;
        r8 = r19[r8];	 Catch:{ IOException -> 0x006c }
        if (r7 != r8) goto L_0x0139;
    L_0x0145:
        r7 = r2 + -1;
        r21[r7] = r6;	 Catch:{ IOException -> 0x006c }
        r2 = r2 + -1;
        goto L_0x0135;
    L_0x014c:
        r2 = r2 + -1;
        r21[r2] = r6;	 Catch:{ IOException -> 0x006c }
        goto L_0x0137;
    L_0x0151:
        r2 = 0;
        if (r17 == 0) goto L_0x0178;
    L_0x0154:
        r4 = r17.getPosition();	 Catch:{ IOException -> 0x006c }
    L_0x0158:
        r8 = r18.readLine();	 Catch:{ IOException -> 0x006c }
        if (r8 == 0) goto L_0x0164;
    L_0x015e:
        r9 = r8.length();	 Catch:{ IOException -> 0x006c }
        if (r9 > 0) goto L_0x0158;
    L_0x0164:
        if (r8 != 0) goto L_0x0339;
    L_0x0166:
        r2 = ignoreMissingEndBoundary;	 Catch:{ IOException -> 0x006c }
        if (r2 != 0) goto L_0x0172;
    L_0x016a:
        r2 = new javax.mail.MessagingException;	 Catch:{ IOException -> 0x006c }
        r4 = "missing multipart end boundary";
        r2.<init>(r4);	 Catch:{ IOException -> 0x006c }
        throw r2;	 Catch:{ IOException -> 0x006c }
    L_0x0172:
        r2 = 0;
        r0 = r25;
        r0.complete = r2;	 Catch:{ IOException -> 0x006c }
        goto L_0x0120;
    L_0x0178:
        r0 = r25;
        r2 = r0.createInternetHeaders(r3);	 Catch:{ IOException -> 0x006c }
        r8 = r2;
        r9 = r4;
    L_0x0180:
        r2 = r3.markSupported();	 Catch:{ IOException -> 0x006c }
        if (r2 != 0) goto L_0x018e;
    L_0x0186:
        r2 = new javax.mail.MessagingException;	 Catch:{ IOException -> 0x006c }
        r4 = "Stream doesn't support mark";
        r2.<init>(r4);	 Catch:{ IOException -> 0x006c }
        throw r2;	 Catch:{ IOException -> 0x006c }
    L_0x018e:
        r2 = 0;
        if (r17 != 0) goto L_0x01c4;
    L_0x0191:
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x006c }
        r2.<init>();	 Catch:{ IOException -> 0x006c }
        r15 = r2;
        r12 = r6;
    L_0x0198:
        r0 = r16;
        r7 = new byte[r0];	 Catch:{ IOException -> 0x006c }
        r0 = r16;
        r6 = new byte[r0];	 Catch:{ IOException -> 0x006c }
        r4 = 0;
        r2 = 1;
        r14 = r4;
        r4 = r12;
        r12 = r2;
    L_0x01a5:
        r2 = r16 + 4;
        r2 = r2 + 1000;
        r3.mark(r2);	 Catch:{ IOException -> 0x006c }
        r2 = 0;
        r13 = 0;
        r0 = r16;
        r13 = readFully(r3, r7, r13, r0);	 Catch:{ IOException -> 0x006c }
        r0 = r16;
        if (r13 >= r0) goto L_0x01f3;
    L_0x01b8:
        r11 = ignoreMissingEndBoundary;	 Catch:{ IOException -> 0x006c }
        if (r11 != 0) goto L_0x01ca;
    L_0x01bc:
        r2 = new javax.mail.MessagingException;	 Catch:{ IOException -> 0x006c }
        r4 = "missing multipart end boundary";
        r2.<init>(r4);	 Catch:{ IOException -> 0x006c }
        throw r2;	 Catch:{ IOException -> 0x006c }
    L_0x01c4:
        r12 = r17.getPosition();	 Catch:{ IOException -> 0x006c }
        r15 = r2;
        goto L_0x0198;
    L_0x01ca:
        if (r17 == 0) goto L_0x01d0;
    L_0x01cc:
        r4 = r17.getPosition();	 Catch:{ IOException -> 0x006c }
    L_0x01d0:
        r11 = 0;
        r0 = r25;
        r0.complete = r11;	 Catch:{ IOException -> 0x006c }
        r11 = 1;
        r24 = r2;
        r2 = r11;
        r11 = r24;
    L_0x01db:
        if (r17 == 0) goto L_0x0307;
    L_0x01dd:
        r0 = r17;
        r6 = r0.newStream(r9, r4);	 Catch:{ IOException -> 0x006c }
        r0 = r25;
        r6 = r0.createMimeBodyPart(r6);	 Catch:{ IOException -> 0x006c }
    L_0x01e9:
        r0 = r25;
        super.addBodyPart(r6);	 Catch:{ IOException -> 0x006c }
        r11 = r2;
        r6 = r4;
        r4 = r9;
        goto L_0x011e;
    L_0x01f3:
        r2 = r16 + -1;
    L_0x01f5:
        if (r2 >= 0) goto L_0x0265;
    L_0x01f7:
        if (r2 >= 0) goto L_0x0336;
    L_0x01f9:
        r2 = 0;
        if (r12 != 0) goto L_0x022c;
    L_0x01fc:
        r22 = r14 + -1;
        r22 = r6[r22];	 Catch:{ IOException -> 0x006c }
        r23 = 13;
        r0 = r22;
        r1 = r23;
        if (r0 == r1) goto L_0x0210;
    L_0x0208:
        r23 = 10;
        r0 = r22;
        r1 = r23;
        if (r0 != r1) goto L_0x022c;
    L_0x0210:
        r2 = 1;
        r23 = 10;
        r0 = r22;
        r1 = r23;
        if (r0 != r1) goto L_0x022c;
    L_0x0219:
        r22 = 2;
        r0 = r22;
        if (r14 < r0) goto L_0x022c;
    L_0x021f:
        r22 = r14 + -2;
        r22 = r6[r22];	 Catch:{ IOException -> 0x006c }
        r23 = 13;
        r0 = r22;
        r1 = r23;
        if (r0 != r1) goto L_0x022c;
    L_0x022b:
        r2 = 2;
    L_0x022c:
        if (r12 != 0) goto L_0x0230;
    L_0x022e:
        if (r2 <= 0) goto L_0x02a6;
    L_0x0230:
        if (r17 == 0) goto L_0x0242;
    L_0x0232:
        r4 = r17.getPosition();	 Catch:{ IOException -> 0x006c }
        r0 = r16;
        r0 = (long) r0;	 Catch:{ IOException -> 0x006c }
        r22 = r0;
        r4 = r4 - r22;
        r0 = (long) r2;	 Catch:{ IOException -> 0x006c }
        r22 = r0;
        r4 = r4 - r22;
    L_0x0242:
        r12 = r3.read();	 Catch:{ IOException -> 0x006c }
        r22 = 45;
        r0 = r22;
        if (r12 != r0) goto L_0x0276;
    L_0x024c:
        r22 = r3.read();	 Catch:{ IOException -> 0x006c }
        r23 = 45;
        r0 = r22;
        r1 = r23;
        if (r0 != r1) goto L_0x0276;
    L_0x0258:
        r11 = 1;
        r0 = r25;
        r0.complete = r11;	 Catch:{ IOException -> 0x006c }
        r11 = 1;
        r24 = r2;
        r2 = r11;
        r11 = r24;
        goto L_0x01db;
    L_0x0265:
        r22 = r7[r2];	 Catch:{ IOException -> 0x006c }
        r23 = r19[r2];	 Catch:{ IOException -> 0x006c }
        r0 = r22;
        r1 = r23;
        if (r0 != r1) goto L_0x01f7;
    L_0x026f:
        r2 = r2 + -1;
        goto L_0x01f5;
    L_0x0272:
        r12 = r3.read();	 Catch:{ IOException -> 0x006c }
    L_0x0276:
        r22 = 32;
        r0 = r22;
        if (r12 == r0) goto L_0x0272;
    L_0x027c:
        r22 = 9;
        r0 = r22;
        if (r12 == r0) goto L_0x0272;
    L_0x0282:
        r22 = 10;
        r0 = r22;
        if (r12 == r0) goto L_0x032f;
    L_0x0288:
        r22 = 13;
        r0 = r22;
        if (r12 != r0) goto L_0x02a6;
    L_0x028e:
        r12 = 1;
        r3.mark(r12);	 Catch:{ IOException -> 0x006c }
        r12 = r3.read();	 Catch:{ IOException -> 0x006c }
        r22 = 10;
        r0 = r22;
        if (r12 == r0) goto L_0x032f;
    L_0x029c:
        r3.reset();	 Catch:{ IOException -> 0x006c }
        r24 = r2;
        r2 = r11;
        r11 = r24;
        goto L_0x01db;
    L_0x02a6:
        r2 = 0;
        r12 = r4;
    L_0x02a8:
        r4 = r2 + 1;
        r5 = r7[r2];	 Catch:{ IOException -> 0x006c }
        r5 = r5 & 127;
        r5 = r20[r5];	 Catch:{ IOException -> 0x006c }
        r4 = r4 - r5;
        r2 = r21[r2];	 Catch:{ IOException -> 0x006c }
        r2 = java.lang.Math.max(r4, r2);	 Catch:{ IOException -> 0x006c }
        r4 = 2;
        if (r2 >= r4) goto L_0x02f3;
    L_0x02ba:
        if (r17 != 0) goto L_0x02c5;
    L_0x02bc:
        r2 = 1;
        if (r14 <= r2) goto L_0x02c5;
    L_0x02bf:
        r2 = 0;
        r4 = r14 + -1;
        r15.write(r6, r2, r4);	 Catch:{ IOException -> 0x006c }
    L_0x02c5:
        r3.reset();	 Catch:{ IOException -> 0x006c }
        r4 = 1;
        r0 = r25;
        r0.skipFully(r3, r4);	 Catch:{ IOException -> 0x006c }
        if (r14 <= 0) goto L_0x02ea;
    L_0x02d1:
        r2 = 0;
        r4 = r14 + -1;
        r4 = r6[r4];	 Catch:{ IOException -> 0x006c }
        r6[r2] = r4;	 Catch:{ IOException -> 0x006c }
        r2 = 1;
        r4 = 0;
        r4 = r7[r4];	 Catch:{ IOException -> 0x006c }
        r6[r2] = r4;	 Catch:{ IOException -> 0x006c }
        r2 = 2;
        r4 = r6;
    L_0x02e0:
        r5 = 0;
        r14 = r2;
        r6 = r4;
        r24 = r5;
        r4 = r12;
        r12 = r24;
        goto L_0x01a5;
    L_0x02ea:
        r2 = 0;
        r4 = 0;
        r4 = r7[r4];	 Catch:{ IOException -> 0x006c }
        r6[r2] = r4;	 Catch:{ IOException -> 0x006c }
        r2 = 1;
        r4 = r6;
        goto L_0x02e0;
    L_0x02f3:
        if (r14 <= 0) goto L_0x02fb;
    L_0x02f5:
        if (r17 != 0) goto L_0x02fb;
    L_0x02f7:
        r4 = 0;
        r15.write(r6, r4, r14);	 Catch:{ IOException -> 0x006c }
    L_0x02fb:
        r3.reset();	 Catch:{ IOException -> 0x006c }
        r4 = (long) r2;	 Catch:{ IOException -> 0x006c }
        r0 = r25;
        r0.skipFully(r3, r4);	 Catch:{ IOException -> 0x006c }
        r4 = r7;
        r7 = r6;
        goto L_0x02e0;
    L_0x0307:
        r12 = r14 - r11;
        if (r12 <= 0) goto L_0x0311;
    L_0x030b:
        r12 = 0;
        r11 = r14 - r11;
        r15.write(r6, r12, r11);	 Catch:{ IOException -> 0x006c }
    L_0x0311:
        r0 = r25;
        r6 = r0.complete;	 Catch:{ IOException -> 0x006c }
        if (r6 != 0) goto L_0x031d;
    L_0x0317:
        if (r13 <= 0) goto L_0x031d;
    L_0x0319:
        r6 = 0;
        r15.write(r7, r6, r13);	 Catch:{ IOException -> 0x006c }
    L_0x031d:
        r6 = r15.toByteArray();	 Catch:{ IOException -> 0x006c }
        r0 = r25;
        r6 = r0.createMimeBodyPart(r8, r6);	 Catch:{ IOException -> 0x006c }
        goto L_0x01e9;
    L_0x0329:
        r3 = move-exception;
        goto L_0x0079;
    L_0x032c:
        r2 = move-exception;
        goto L_0x0123;
    L_0x032f:
        r24 = r2;
        r2 = r11;
        r11 = r24;
        goto L_0x01db;
    L_0x0336:
        r12 = r4;
        goto L_0x02a8;
    L_0x0339:
        r8 = r2;
        r9 = r4;
        goto L_0x0180;
    L_0x033d:
        r8 = r11;
        goto L_0x00c6;
    L_0x0340:
        r17 = r2;
        goto L_0x0031;
    L_0x0344:
        r3 = r6;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parsebm():void");
    }

    private static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i2 > 0) {
            int read = inputStream.read(bArr, i, i2);
            if (read <= 0) {
                break;
            }
            i += read;
            i3 += read;
            i2 -= read;
        }
        return i3 <= 0 ? -1 : i3;
    }

    private void skipFully(InputStream inputStream, long j) {
        while (j > 0) {
            long skip = inputStream.skip(j);
            if (skip <= 0) {
                throw new EOFException("can't skip");
            }
            j -= skip;
        }
    }

    public synchronized void addBodyPart(BodyPart bodyPart) {
        parse();
        super.addBodyPart(bodyPart);
    }

    public synchronized void addBodyPart(BodyPart bodyPart, int i) {
        parse();
        super.addBodyPart(bodyPart, i);
    }

    protected InternetHeaders createInternetHeaders(InputStream inputStream) {
        return new InternetHeaders(inputStream);
    }

    protected MimeBodyPart createMimeBodyPart(InputStream inputStream) {
        return new MimeBodyPart(inputStream);
    }

    protected MimeBodyPart createMimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) {
        return new MimeBodyPart(internetHeaders, bArr);
    }

    public synchronized BodyPart getBodyPart(int i) {
        parse();
        return super.getBodyPart(i);
    }

    public synchronized BodyPart getBodyPart(String str) {
        BodyPart bodyPart;
        parse();
        int count = getCount();
        for (int i = 0; i < count; i++) {
            MimeBodyPart mimeBodyPart = (MimeBodyPart) getBodyPart(i);
            String contentID = mimeBodyPart.getContentID();
            if (contentID != null && contentID.equals(str)) {
                break;
            }
        }
        bodyPart = null;
        return bodyPart;
    }

    public synchronized int getCount() {
        parse();
        return super.getCount();
    }

    public synchronized String getPreamble() {
        parse();
        return this.preamble;
    }

    public synchronized boolean isComplete() {
        parse();
        return this.complete;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected synchronized void parse() {
        /*
        r21 = this;
        monitor-enter(r21);
        r0 = r21;
        r1 = r0.parsed;	 Catch:{ all -> 0x0011 }
        if (r1 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r21);
        return;
    L_0x0009:
        r1 = bmparse;	 Catch:{ all -> 0x0011 }
        if (r1 == 0) goto L_0x0014;
    L_0x000d:
        r21.parsebm();	 Catch:{ all -> 0x0011 }
        goto L_0x0007;
    L_0x0011:
        r1 = move-exception;
        monitor-exit(r21);
        throw r1;
    L_0x0014:
        r1 = 0;
        r5 = 0;
        r3 = 0;
        r0 = r21;
        r2 = r0.ds;	 Catch:{ Exception -> 0x0082 }
        r7 = r2.getInputStream();	 Catch:{ Exception -> 0x0082 }
        r2 = r7 instanceof java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0082 }
        if (r2 != 0) goto L_0x0277;
    L_0x0025:
        r2 = r7 instanceof java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0082 }
        if (r2 != 0) goto L_0x0277;
    L_0x0029:
        r2 = r7 instanceof javax.mail.internet.SharedInputStream;	 Catch:{ Exception -> 0x0082 }
        if (r2 != 0) goto L_0x0277;
    L_0x002d:
        r2 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0082 }
        r2.<init>(r7);	 Catch:{ Exception -> 0x0082 }
    L_0x0032:
        r7 = r2 instanceof javax.mail.internet.SharedInputStream;	 Catch:{ all -> 0x0011 }
        if (r7 == 0) goto L_0x0274;
    L_0x0036:
        r0 = r2;
        r0 = (javax.mail.internet.SharedInputStream) r0;	 Catch:{ all -> 0x0011 }
        r1 = r0;
        r13 = r1;
    L_0x003b:
        r1 = new javax.mail.internet.ContentType;	 Catch:{ all -> 0x0011 }
        r0 = r21;
        r7 = r0.contentType;	 Catch:{ all -> 0x0011 }
        r1.<init>(r7);	 Catch:{ all -> 0x0011 }
        r7 = 0;
        r8 = "boundary";
        r1 = r1.getParameter(r8);	 Catch:{ all -> 0x0011 }
        if (r1 == 0) goto L_0x008b;
    L_0x004d:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0011 }
        r8 = "--";
        r7.<init>(r8);	 Catch:{ all -> 0x0011 }
        r1 = r7.append(r1);	 Catch:{ all -> 0x0011 }
        r7 = r1.toString();	 Catch:{ all -> 0x0011 }
    L_0x005c:
        r14 = new com.sun.mail.util.LineInputStream;	 Catch:{ IOException -> 0x0074 }
        r14.<init>(r2);	 Catch:{ IOException -> 0x0074 }
        r1 = 0;
        r8 = 0;
        r10 = r1;
    L_0x0064:
        r1 = r14.readLine();	 Catch:{ IOException -> 0x0074 }
        if (r1 != 0) goto L_0x0097;
    L_0x006a:
        if (r1 != 0) goto L_0x00f2;
    L_0x006c:
        r1 = new javax.mail.MessagingException;	 Catch:{ IOException -> 0x0074 }
        r3 = "Missing start boundary";
        r1.<init>(r3);	 Catch:{ IOException -> 0x0074 }
        throw r1;	 Catch:{ IOException -> 0x0074 }
    L_0x0074:
        r1 = move-exception;
        r3 = new javax.mail.MessagingException;	 Catch:{ all -> 0x007d }
        r4 = "IO Error";
        r3.<init>(r4, r1);	 Catch:{ all -> 0x007d }
        throw r3;	 Catch:{ all -> 0x007d }
    L_0x007d:
        r1 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x025a }
    L_0x0081:
        throw r1;	 Catch:{ all -> 0x0011 }
    L_0x0082:
        r1 = move-exception;
        r2 = new javax.mail.MessagingException;	 Catch:{ all -> 0x0011 }
        r3 = "No inputstream from datasource";
        r2.<init>(r3, r1);	 Catch:{ all -> 0x0011 }
        throw r2;	 Catch:{ all -> 0x0011 }
    L_0x008b:
        r1 = ignoreMissingBoundaryParameter;	 Catch:{ all -> 0x0011 }
        if (r1 != 0) goto L_0x005c;
    L_0x008f:
        r1 = new javax.mail.MessagingException;	 Catch:{ all -> 0x0011 }
        r2 = "Missing boundary parameter";
        r1.<init>(r2);	 Catch:{ all -> 0x0011 }
        throw r1;	 Catch:{ all -> 0x0011 }
    L_0x0097:
        r9 = r1.length();	 Catch:{ IOException -> 0x0074 }
        r9 = r9 + -1;
    L_0x009d:
        if (r9 >= 0) goto L_0x00d4;
    L_0x009f:
        r11 = 0;
        r9 = r9 + 1;
        r1 = r1.substring(r11, r9);	 Catch:{ IOException -> 0x0074 }
        if (r7 == 0) goto L_0x00e3;
    L_0x00a8:
        r9 = r1.equals(r7);	 Catch:{ IOException -> 0x0074 }
        if (r9 != 0) goto L_0x006a;
    L_0x00ae:
        r9 = r1.length();	 Catch:{ IOException -> 0x0074 }
        if (r9 <= 0) goto L_0x0064;
    L_0x00b4:
        if (r8 != 0) goto L_0x00be;
    L_0x00b6:
        r8 = "line.separator";
        r9 = "\n";
        r8 = java.lang.System.getProperty(r8, r9);	 Catch:{ SecurityException -> 0x00ee }
    L_0x00be:
        if (r10 != 0) goto L_0x0271;
    L_0x00c0:
        r9 = new java.lang.StringBuffer;	 Catch:{ IOException -> 0x0074 }
        r10 = r1.length();	 Catch:{ IOException -> 0x0074 }
        r10 = r10 + 2;
        r9.<init>(r10);	 Catch:{ IOException -> 0x0074 }
    L_0x00cb:
        r1 = r9.append(r1);	 Catch:{ IOException -> 0x0074 }
        r1.append(r8);	 Catch:{ IOException -> 0x0074 }
        r10 = r9;
        goto L_0x0064;
    L_0x00d4:
        r11 = r1.charAt(r9);	 Catch:{ IOException -> 0x0074 }
        r12 = 32;
        if (r11 == r12) goto L_0x00e0;
    L_0x00dc:
        r12 = 9;
        if (r11 != r12) goto L_0x009f;
    L_0x00e0:
        r9 = r9 + -1;
        goto L_0x009d;
    L_0x00e3:
        r9 = "--";
        r9 = r1.startsWith(r9);	 Catch:{ IOException -> 0x0074 }
        if (r9 == 0) goto L_0x00ae;
    L_0x00eb:
        r7 = r1;
        goto L_0x006a;
    L_0x00ee:
        r8 = move-exception;
        r8 = "\n";
        goto L_0x00be;
    L_0x00f2:
        if (r10 == 0) goto L_0x00fc;
    L_0x00f4:
        r1 = r10.toString();	 Catch:{ IOException -> 0x0074 }
        r0 = r21;
        r0.preamble = r1;	 Catch:{ IOException -> 0x0074 }
    L_0x00fc:
        r15 = com.sun.mail.util.ASCIIUtility.getBytes(r7);	 Catch:{ IOException -> 0x0074 }
        r0 = r15.length;	 Catch:{ IOException -> 0x0074 }
        r16 = r0;
        r1 = 0;
        r8 = r1;
    L_0x0105:
        if (r8 == 0) goto L_0x0111;
    L_0x0107:
        r2.close();	 Catch:{ IOException -> 0x025d }
    L_0x010a:
        r1 = 1;
        r0 = r21;
        r0.parsed = r1;	 Catch:{ all -> 0x0011 }
        goto L_0x0007;
    L_0x0111:
        r1 = 0;
        if (r13 == 0) goto L_0x0138;
    L_0x0114:
        r5 = r13.getPosition();	 Catch:{ IOException -> 0x0074 }
    L_0x0118:
        r7 = r14.readLine();	 Catch:{ IOException -> 0x0074 }
        if (r7 == 0) goto L_0x0124;
    L_0x011e:
        r9 = r7.length();	 Catch:{ IOException -> 0x0074 }
        if (r9 > 0) goto L_0x0118;
    L_0x0124:
        if (r7 != 0) goto L_0x0260;
    L_0x0126:
        r1 = ignoreMissingEndBoundary;	 Catch:{ IOException -> 0x0074 }
        if (r1 != 0) goto L_0x0132;
    L_0x012a:
        r1 = new javax.mail.MessagingException;	 Catch:{ IOException -> 0x0074 }
        r3 = "missing multipart end boundary";
        r1.<init>(r3);	 Catch:{ IOException -> 0x0074 }
        throw r1;	 Catch:{ IOException -> 0x0074 }
    L_0x0132:
        r1 = 0;
        r0 = r21;
        r0.complete = r1;	 Catch:{ IOException -> 0x0074 }
        goto L_0x0107;
    L_0x0138:
        r0 = r21;
        r1 = r0.createInternetHeaders(r2);	 Catch:{ IOException -> 0x0074 }
        r19 = r5;
        r6 = r19;
        r5 = r1;
    L_0x0143:
        r1 = r2.markSupported();	 Catch:{ IOException -> 0x0074 }
        if (r1 != 0) goto L_0x0151;
    L_0x0149:
        r1 = new javax.mail.MessagingException;	 Catch:{ IOException -> 0x0074 }
        r3 = "Stream doesn't support mark";
        r1.<init>(r3);	 Catch:{ IOException -> 0x0074 }
        throw r1;	 Catch:{ IOException -> 0x0074 }
    L_0x0151:
        r1 = 0;
        if (r13 != 0) goto L_0x01a9;
    L_0x0154:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0074 }
        r1.<init>();	 Catch:{ IOException -> 0x0074 }
    L_0x0159:
        r11 = 1;
        r10 = -1;
        r9 = -1;
        r19 = r9;
        r20 = r10;
        r9 = r3;
        r3 = r19;
        r4 = r20;
    L_0x0165:
        if (r11 == 0) goto L_0x01f9;
    L_0x0167:
        r11 = r16 + 4;
        r11 = r11 + 1000;
        r2.mark(r11);	 Catch:{ IOException -> 0x0074 }
        r11 = 0;
    L_0x016f:
        r0 = r16;
        if (r11 < r0) goto L_0x01ae;
    L_0x0173:
        r0 = r16;
        if (r11 != r0) goto L_0x01e6;
    L_0x0177:
        r11 = r2.read();	 Catch:{ IOException -> 0x0074 }
        r12 = 45;
        if (r11 != r12) goto L_0x01c5;
    L_0x017f:
        r12 = r2.read();	 Catch:{ IOException -> 0x0074 }
        r17 = 45;
        r0 = r17;
        if (r12 != r0) goto L_0x01c5;
    L_0x0189:
        r3 = 1;
        r0 = r21;
        r0.complete = r3;	 Catch:{ IOException -> 0x0074 }
        r8 = 1;
        r3 = r8;
    L_0x0190:
        if (r13 == 0) goto L_0x024e;
    L_0x0192:
        r1 = r13.newStream(r6, r9);	 Catch:{ IOException -> 0x0074 }
        r0 = r21;
        r1 = r0.createMimeBodyPart(r1);	 Catch:{ IOException -> 0x0074 }
    L_0x019c:
        r0 = r21;
        super.addBodyPart(r1);	 Catch:{ IOException -> 0x0074 }
        r8 = r3;
        r3 = r9;
        r19 = r6;
        r5 = r19;
        goto L_0x0105;
    L_0x01a9:
        r3 = r13.getPosition();	 Catch:{ IOException -> 0x0074 }
        goto L_0x0159;
    L_0x01ae:
        r12 = r2.read();	 Catch:{ IOException -> 0x0074 }
        r17 = r15[r11];	 Catch:{ IOException -> 0x0074 }
        r0 = r17;
        r0 = r0 & 255;
        r17 = r0;
        r0 = r17;
        if (r12 != r0) goto L_0x0173;
    L_0x01be:
        r11 = r11 + 1;
        goto L_0x016f;
    L_0x01c1:
        r11 = r2.read();	 Catch:{ IOException -> 0x0074 }
    L_0x01c5:
        r12 = 32;
        if (r11 == r12) goto L_0x01c1;
    L_0x01c9:
        r12 = 9;
        if (r11 == r12) goto L_0x01c1;
    L_0x01cd:
        r12 = 10;
        if (r11 == r12) goto L_0x026e;
    L_0x01d1:
        r12 = 13;
        if (r11 != r12) goto L_0x01e6;
    L_0x01d5:
        r3 = 1;
        r2.mark(r3);	 Catch:{ IOException -> 0x0074 }
        r3 = r2.read();	 Catch:{ IOException -> 0x0074 }
        r4 = 10;
        if (r3 == r4) goto L_0x026e;
    L_0x01e1:
        r2.reset();	 Catch:{ IOException -> 0x0074 }
        r3 = r8;
        goto L_0x0190;
    L_0x01e6:
        r2.reset();	 Catch:{ IOException -> 0x0074 }
        if (r1 == 0) goto L_0x01f9;
    L_0x01eb:
        r11 = -1;
        if (r4 == r11) goto L_0x01f9;
    L_0x01ee:
        r1.write(r4);	 Catch:{ IOException -> 0x0074 }
        r4 = -1;
        if (r3 == r4) goto L_0x01f7;
    L_0x01f4:
        r1.write(r3);	 Catch:{ IOException -> 0x0074 }
    L_0x01f7:
        r3 = -1;
        r4 = r3;
    L_0x01f9:
        r11 = r2.read();	 Catch:{ IOException -> 0x0074 }
        if (r11 >= 0) goto L_0x0214;
    L_0x01ff:
        r3 = ignoreMissingEndBoundary;	 Catch:{ IOException -> 0x0074 }
        if (r3 != 0) goto L_0x020b;
    L_0x0203:
        r1 = new javax.mail.MessagingException;	 Catch:{ IOException -> 0x0074 }
        r3 = "missing multipart end boundary";
        r1.<init>(r3);	 Catch:{ IOException -> 0x0074 }
        throw r1;	 Catch:{ IOException -> 0x0074 }
    L_0x020b:
        r3 = 0;
        r0 = r21;
        r0.complete = r3;	 Catch:{ IOException -> 0x0074 }
        r8 = 1;
        r3 = r8;
        goto L_0x0190;
    L_0x0214:
        r12 = 13;
        if (r11 == r12) goto L_0x021c;
    L_0x0218:
        r12 = 10;
        if (r11 != r12) goto L_0x0245;
    L_0x021c:
        r12 = 1;
        if (r13 == 0) goto L_0x0227;
    L_0x021f:
        r9 = r13.getPosition();	 Catch:{ IOException -> 0x0074 }
        r17 = 1;
        r9 = r9 - r17;
    L_0x0227:
        r4 = 13;
        if (r11 != r4) goto L_0x026a;
    L_0x022b:
        r4 = 1;
        r2.mark(r4);	 Catch:{ IOException -> 0x0074 }
        r4 = r2.read();	 Catch:{ IOException -> 0x0074 }
        r17 = 10;
        r0 = r17;
        if (r4 != r0) goto L_0x023e;
    L_0x0239:
        r3 = r4;
        r4 = r11;
        r11 = r12;
        goto L_0x0165;
    L_0x023e:
        r2.reset();	 Catch:{ IOException -> 0x0074 }
        r4 = r11;
        r11 = r12;
        goto L_0x0165;
    L_0x0245:
        r12 = 0;
        if (r1 == 0) goto L_0x0267;
    L_0x0248:
        r1.write(r11);	 Catch:{ IOException -> 0x0074 }
        r11 = r12;
        goto L_0x0165;
    L_0x024e:
        r1 = r1.toByteArray();	 Catch:{ IOException -> 0x0074 }
        r0 = r21;
        r1 = r0.createMimeBodyPart(r5, r1);	 Catch:{ IOException -> 0x0074 }
        goto L_0x019c;
    L_0x025a:
        r2 = move-exception;
        goto L_0x0081;
    L_0x025d:
        r1 = move-exception;
        goto L_0x010a;
    L_0x0260:
        r19 = r5;
        r6 = r19;
        r5 = r1;
        goto L_0x0143;
    L_0x0267:
        r11 = r12;
        goto L_0x0165;
    L_0x026a:
        r4 = r11;
        r11 = r12;
        goto L_0x0165;
    L_0x026e:
        r3 = r8;
        goto L_0x0190;
    L_0x0271:
        r9 = r10;
        goto L_0x00cb;
    L_0x0274:
        r13 = r1;
        goto L_0x003b;
    L_0x0277:
        r2 = r7;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parse():void");
    }

    public void removeBodyPart(int i) {
        parse();
        super.removeBodyPart(i);
    }

    public boolean removeBodyPart(BodyPart bodyPart) {
        parse();
        return super.removeBodyPart(bodyPart);
    }

    public synchronized void setPreamble(String str) {
        this.preamble = str;
    }

    public synchronized void setSubType(String str) {
        ContentType contentType = new ContentType(this.contentType);
        contentType.setSubType(str);
        this.contentType = contentType.toString();
    }

    protected void updateHeaders() {
        for (int i = 0; i < this.parts.size(); i++) {
            ((MimeBodyPart) this.parts.elementAt(i)).updateHeaders();
        }
    }

    public synchronized void writeTo(OutputStream outputStream) {
        parse();
        String str = "--" + new ContentType(this.contentType).getParameter("boundary");
        LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
        if (this.preamble != null) {
            byte[] bytes = ASCIIUtility.getBytes(this.preamble);
            lineOutputStream.write(bytes);
            if (!(bytes.length <= 0 || bytes[bytes.length - 1] == (byte) 13 || bytes[bytes.length - 1] == (byte) 10)) {
                lineOutputStream.writeln();
            }
        }
        for (int i = 0; i < this.parts.size(); i++) {
            lineOutputStream.writeln(str);
            ((MimeBodyPart) this.parts.elementAt(i)).writeTo(outputStream);
            lineOutputStream.writeln();
        }
        lineOutputStream.writeln(new StringBuilder(String.valueOf(str)).append("--").toString());
    }
}
