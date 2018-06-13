package com.att.android.speech;

import android.content.Context;
import android.os.Handler;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

final class ad {
    public static final String[] f396a = new String[]{"Content-Type", "Content-Length", "Transfer-Encoding"};
    Handler f397b = null;
    protected int f398c = -1;
    protected int f399d = -1;
    protected String[] f400e = null;
    protected String[] f401f = null;
    protected String f402g = null;
    protected URI f403h = null;
    protected String f404i = null;
    protected String f405j = null;
    protected String f406k = null;
    protected String f407l = "audio/amr";
    protected Context f408m = null;
    protected aj f409n = new aj();
    protected String f410o = null;
    private C0135v f411p = null;
    private InputStream f412q = null;
    private C0115x f413r = null;
    private Thread f414s = null;
    private ai f415t = null;
    private C0116f f416u = null;
    private C0113h f417v = null;
    private DefaultHttpClient f418w = null;
    private HttpPost f419x = null;
    private Runnable f420y = new ae(this);

    public ad(Context context) {
        this.f408m = context;
    }

    private C0121g m348a(Header[] headerArr, long j, InputStream inputStream, int i) {
        int i2 = 0;
        int length = headerArr != null ? headerArr.length : 0;
        String[] strArr = new String[length];
        String[] strArr2 = new String[length];
        while (i2 < length) {
            Header header = headerArr[i2];
            strArr[i2] = header.getName();
            strArr2[i2] = header.getValue();
            i2++;
        }
        try {
            byte[] bArr = new byte[256];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(j < 0 ? 256 : (int) j);
            while (true) {
                length = inputStream.read(bArr);
                if (length < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, length);
            }
            if (byteArrayOutputStream.size() > 0) {
                return new C0121g(byteArrayOutputStream.toByteArray(), i, strArr, strArr2);
            }
        } catch (Exception e) {
            m350a(new C0119d(C0120e.RESPONSE_ERROR, e.getMessage(), e));
        }
        return null;
    }

    private void m350a(C0119d c0119d) {
        ac.m345a("RequestManager", "There was a recording error: " + c0119d.m399a() + ": " + c0119d.m400b());
        if (this.f397b != null && this.f416u != null) {
            this.f397b.post(new ah(this, this.f416u, c0119d));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m352c(com.att.android.speech.ad r10) {
        /*
        r3 = 1;
        r1 = 0;
        r0 = 0;
        r10.f418w = r0;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0 = new com.att.android.speech.z;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r10.f409n;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4 = r10.f415t;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r5 = r10.f412q;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r6 = r10.f397b;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0.<init>(r2, r4, r5, r6);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r10.f411p = r0;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0 = r10.f407l;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r0 != 0) goto L_0x0127;
    L_0x0018:
        r0 = r10.f411p;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = "audio/amr";
        r0.setContentType(r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
    L_0x001f:
        r0 = r10.f411p;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = 1;
        r0.setChunked(r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0 = new org.apache.http.params.BasicHttpParams;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0.<init>();	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r10.f398c;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r2 < 0) goto L_0x0033;
    L_0x002e:
        r2 = r10.f398c;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        org.apache.http.params.HttpConnectionParams.setSoTimeout(r0, r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
    L_0x0033:
        r2 = r10.f399d;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r2 < 0) goto L_0x003c;
    L_0x0037:
        r2 = r10.f399d;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r0, r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
    L_0x003c:
        r2 = new org.apache.http.impl.conn.SingleClientConnManager;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4 = new org.apache.http.conn.scheme.SchemeRegistry;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4.<init>();	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r5 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r6 = new org.apache.http.conn.scheme.Scheme;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r7 = "http";
        r8 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory();	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r9 = 80;
        r6.<init>(r7, r8, r9);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4.register(r6);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r6 = new org.apache.http.conn.scheme.Scheme;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r7 = "https";
        r8 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;
        r6.<init>(r7, r5, r8);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4.register(r6);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2.<init>(r0, r4);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4 = new org.apache.http.impl.client.DefaultHttpClient;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4.<init>(r2, r0);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r10.f418w = r4;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0 = r10.f418w;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = new org.apache.http.impl.client.DefaultHttpRequestRetryHandler;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4 = 0;
        r5 = 0;
        r2.<init>(r4, r5);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0.setHttpRequestRetryHandler(r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0 = new org.apache.http.client.methods.HttpPost;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r10.f403h;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r10.f419x = r0;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0 = r10.f400e;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r0 == 0) goto L_0x0098;
    L_0x0086:
        r0 = r10.f401f;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r0 == 0) goto L_0x0098;
    L_0x008a:
        r0 = r10.f400e;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0 = r0.length;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r10.f401f;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r2.length;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r0 != r2) goto L_0x0098;
    L_0x0092:
        r0 = r1;
    L_0x0093:
        r2 = r10.f400e;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r2.length;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r0 < r2) goto L_0x014a;
    L_0x0098:
        r0 = r10.f410o;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r0 == 0) goto L_0x00a5;
    L_0x009c:
        r0 = r10.f419x;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r1 = "X-SpeechContext";
        r2 = r10.f410o;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0.addHeader(r1, r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
    L_0x00a5:
        r0 = r10.f406k;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r0 == 0) goto L_0x00c1;
    L_0x00a9:
        r0 = r10.f419x;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r1 = "Authorization";
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r3 = "Bearer ";
        r2.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r3 = r10.f406k;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0.addHeader(r1, r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
    L_0x00c1:
        r0 = r10.f419x;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r1 = r10.f411p;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0.setEntity(r1);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0 = r10.f404i;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r0 != 0) goto L_0x00d0;
    L_0x00cc:
        r0 = r10.f405j;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r0 == 0) goto L_0x00db;
    L_0x00d0:
        r0 = new com.att.android.speech.af;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0.<init>(r10);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r1 = r10.f418w;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = 0;
        r1.addRequestInterceptor(r0, r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
    L_0x00db:
        r0 = "ATTSpeechKit";
        r1 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = "URL ";
        r1.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r10.f403h;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r1 = r1.append(r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r1 = r1.toString();	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        com.att.android.speech.ac.m347c(r0, r1);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0 = r10.m353d();	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r0 == 0) goto L_0x011c;
    L_0x00fb:
        r1 = "RequestManager";
        r2 = "Done executing.";
        com.att.android.speech.ac.m345a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r6 = r0.getStatusLine();	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r5 = r6.getStatusCode();	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r7 = r0.getEntity();	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        if (r7 != 0) goto L_0x0177;
    L_0x0110:
        r0 = new com.att.android.speech.d;	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r1 = com.att.android.speech.C0120e.RESPONSE_ERROR;	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r2 = "No entity in the response";
        r0.<init>(r1, r2);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r10.m350a(r0);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
    L_0x011c:
        r0 = "RequestManager";
        r1 = "In the finally block.";
        com.att.android.speech.ac.m345a(r0, r1);
        r10.m355f();
    L_0x0126:
        return;
    L_0x0127:
        r0 = r10.f411p;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = r10.f407l;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r0.setContentType(r2);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        goto L_0x001f;
    L_0x0130:
        r0 = move-exception;
        r1 = new com.att.android.speech.d;	 Catch:{ all -> 0x0248 }
        r2 = com.att.android.speech.C0120e.PARAMETER_ERROR;	 Catch:{ all -> 0x0248 }
        r3 = r0.getMessage();	 Catch:{ all -> 0x0248 }
        r1.<init>(r2, r3, r0);	 Catch:{ all -> 0x0248 }
        r10.m350a(r1);	 Catch:{ all -> 0x0248 }
        r0 = "RequestManager";
        r1 = "In the finally block.";
        com.att.android.speech.ac.m345a(r0, r1);
        r10.m355f();
        goto L_0x0126;
    L_0x014a:
        r2 = r1;
    L_0x014b:
        r4 = f396a;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4 = r4.length;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r2 < r4) goto L_0x0164;
    L_0x0150:
        r2 = r3;
    L_0x0151:
        if (r2 == 0) goto L_0x0160;
    L_0x0153:
        r2 = r10.f419x;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4 = r10.f400e;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4 = r4[r0];	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r5 = r10.f401f;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r5 = r5[r0];	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2.addHeader(r4, r5);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
    L_0x0160:
        r0 = r0 + 1;
        goto L_0x0093;
    L_0x0164:
        r4 = f396a;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4 = r4[r2];	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r5 = r10.f400e;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r5 = r5[r0];	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r4 = r4.equalsIgnoreCase(r5);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        if (r4 == 0) goto L_0x0174;
    L_0x0172:
        r2 = r1;
        goto L_0x0151;
    L_0x0174:
        r2 = r2 + 1;
        goto L_0x014b;
    L_0x0177:
        r1 = "ATTSpeechKit";
        r2 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = "Response length:";
        r2.<init>(r3);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = r7.getContentLength();	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = " is chunked:";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = r7.isChunked();	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = " content type:";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = r7.getContentType();	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = r3.getValue();	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r2 = r2.toString();	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        com.att.android.speech.ac.m345a(r1, r2);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r1 = r0.getAllHeaders();	 Catch:{ all -> 0x01ea }
        r2 = r7.getContentLength();	 Catch:{ all -> 0x01ea }
        r4 = r7.getContent();	 Catch:{ all -> 0x01ea }
        r0 = r10;
        r0 = r0.m348a(r1, r2, r4, r5);	 Catch:{ all -> 0x01ea }
        r7.consumeContent();	 Catch:{ IOException -> 0x0256, SocketException -> 0x01e7 }
    L_0x01cb:
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 == r1) goto L_0x021b;
    L_0x01cf:
        r1 = "RequestManager";
        r2 = "The http status was not ok.";
        com.att.android.speech.ac.m345a(r1, r2);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r1 = new com.att.android.speech.d;	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r2 = com.att.android.speech.C0120e.SERVER_ERROR;	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = r6.getReasonPhrase();	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r4 = 0;
        r1.<init>(r2, r3, r4, r0);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r10.m350a(r1);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        goto L_0x011c;
    L_0x01e7:
        r0 = move-exception;
        goto L_0x011c;
    L_0x01ea:
        r0 = move-exception;
        r7.consumeContent();	 Catch:{ IOException -> 0x0254, SocketException -> 0x01e7 }
    L_0x01ee:
        throw r0;	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
    L_0x01ef:
        r0 = move-exception;
        r1 = new com.att.android.speech.d;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r2 = com.att.android.speech.C0120e.RESPONSE_ERROR;	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r3 = r0.getMessage();	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r1.<init>(r2, r3, r0);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        r10.m350a(r1);	 Catch:{ IllegalArgumentException -> 0x0130, IllegalStateException -> 0x0200, Exception -> 0x022d }
        goto L_0x011c;
    L_0x0200:
        r0 = move-exception;
        r1 = new com.att.android.speech.d;	 Catch:{ all -> 0x0248 }
        r2 = com.att.android.speech.C0120e.PARAMETER_ERROR;	 Catch:{ all -> 0x0248 }
        r3 = r0.getMessage();	 Catch:{ all -> 0x0248 }
        r1.<init>(r2, r3, r0);	 Catch:{ all -> 0x0248 }
        r10.m350a(r1);	 Catch:{ all -> 0x0248 }
        r0 = "RequestManager";
        r1 = "In the finally block.";
        com.att.android.speech.ac.m345a(r0, r1);
        r10.m355f();
        goto L_0x0126;
    L_0x021b:
        r1 = r10.f417v;	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        if (r1 == 0) goto L_0x011c;
    L_0x021f:
        r1 = r10.f397b;	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r2 = new com.att.android.speech.ak;	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r3 = r10.f417v;	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r2.<init>(r10, r3, r0);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        r1.post(r2);	 Catch:{ SocketException -> 0x01e7, IOException -> 0x01ef }
        goto L_0x011c;
    L_0x022d:
        r0 = move-exception;
        r1 = new com.att.android.speech.d;	 Catch:{ all -> 0x0248 }
        r2 = com.att.android.speech.C0120e.OTHER_ERROR;	 Catch:{ all -> 0x0248 }
        r3 = r0.getMessage();	 Catch:{ all -> 0x0248 }
        r1.<init>(r2, r3, r0);	 Catch:{ all -> 0x0248 }
        r10.m350a(r1);	 Catch:{ all -> 0x0248 }
        r0 = "RequestManager";
        r1 = "In the finally block.";
        com.att.android.speech.ac.m345a(r0, r1);
        r10.m355f();
        goto L_0x0126;
    L_0x0248:
        r0 = move-exception;
        r1 = "RequestManager";
        r2 = "In the finally block.";
        com.att.android.speech.ac.m345a(r1, r2);
        r10.m355f();
        throw r0;
    L_0x0254:
        r1 = move-exception;
        goto L_0x01ee;
    L_0x0256:
        r1 = move-exception;
        goto L_0x01cb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.att.android.speech.ad.c(com.att.android.speech.ad):void");
    }

    private HttpResponse m353d() {
        HttpResponse httpResponse = null;
        try {
            httpResponse = this.f418w.execute(this.f419x);
        } catch (Exception e) {
            m350a(new C0119d(C0120e.CONNECTION_ERROR, e.getMessage(), e));
        } catch (Exception e2) {
            m350a(new C0119d(C0120e.CONNECTION_ERROR, e2.getMessage(), e2));
        } catch (Exception e22) {
            m350a(new C0119d(C0120e.CONNECTION_ERROR, e22.getMessage(), e22));
        } catch (Exception e222) {
            m350a(new C0119d(C0120e.CONNECTION_ERROR, e222.getMessage(), e222));
        } catch (Exception e2222) {
            m350a(new C0119d(C0120e.RESPONSE_ERROR, e2222.getMessage(), e2222));
        }
        return httpResponse;
    }

    private void m354e() {
        this.f414s = new Thread(null, new ag(this), "speech request");
        this.f414s.start();
    }

    private void m355f() {
        if (this.f413r != null) {
            try {
                this.f413r.mo60d();
            } catch (Exception e) {
            }
            this.f413r = null;
        }
        if (this.f411p != null) {
            try {
                this.f411p.m463a();
            } catch (Exception e2) {
            }
            this.f411p = null;
        }
        if (this.f412q != null) {
            try {
                this.f412q.close();
            } catch (Exception e3) {
            }
            this.f412q = null;
        }
    }

    public final void m356a() {
        if (this.f413r != null) {
            try {
                this.f413r.mo60d();
            } catch (IOException e) {
            }
        }
    }

    public final void m357a(int i) {
        this.f409n.f427a = i;
    }

    public final void m358a(ai aiVar) {
        this.f415t = aiVar;
        if (aiVar != null && this.f397b == null) {
            this.f397b = new Handler();
        }
    }

    public final void m359a(C0116f c0116f) {
        this.f416u = c0116f;
        if (c0116f != null && this.f397b == null) {
            this.f397b = new Handler();
        }
    }

    public final void m360a(C0113h c0113h) {
        this.f417v = c0113h;
        if (c0113h != null && this.f397b == null) {
            this.f397b = new Handler();
        }
    }

    public final void m361a(URI uri) {
        this.f403h = uri;
    }

    public final void m362a(boolean z) {
        this.f409n.f431e = z;
    }

    public final void m363b() {
        this.f409n.f432f = System.currentTimeMillis();
        this.f409n.f433g = Long.MAX_VALUE;
        if (this.f402g == null) {
            InputStream pipedInputStream = new PipedInputStream();
            this.f412q = pipedInputStream;
            this.f413r = new al(this.f409n, this.f415t, this.f416u, this.f397b, pipedInputStream, this.f408m);
            this.f413r.mo57a();
        } else {
            File file = new File(this.f402g);
            long length = file.length();
            if (length == 0) {
                throw new C0134u("Audio file empty or does not exist.");
            } else if (length > 51200) {
                throw new C0134u("Max audio file size exceeded");
            } else {
                this.f412q = new FileInputStream(file);
                this.f413r = null;
            }
        }
        if (this.f402g != null) {
            m354e();
        } else {
            new Thread(null, this.f420y, "speech recording runnable").start();
        }
    }

    public final void m364b(int i) {
        this.f409n.f429c = i;
    }

    public final void m365c() {
        if (this.f413r != null) {
            this.f413r.mo59c();
        }
        if (this.f411p != null) {
            this.f411p.m463a();
        }
        ac.m345a("RequestManager", "Request Cancelled");
        try {
            if (this.f414s != null) {
                if (this.f414s.isAlive()) {
                    ac.m345a("RequestManager", "Request thread interrupting ...");
                    if (this.f419x != null) {
                        this.f419x.abort();
                    }
                    ac.m345a("RequestManager", "httpclient connection should be shut down.");
                    this.f414s.interrupt();
                }
                this.f414s = null;
            }
        } catch (IOException e) {
        }
        m355f();
    }

    public final void m366c(int i) {
        this.f409n.f428b = i;
    }

    public final void m367d(int i) {
        this.f409n.f430d = i;
    }
}
