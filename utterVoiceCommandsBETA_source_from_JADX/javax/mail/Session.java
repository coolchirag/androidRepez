package javax.mail;

import com.sun.mail.util.LineInputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Provider.Type;

public final class Session {
    private static Session defaultSession = null;
    private final Properties addressMap = new Properties();
    private final Hashtable authTable = new Hashtable();
    private final Authenticator authenticator;
    private boolean debug = false;
    private PrintStream out;
    private final Properties props;
    private final Vector providers = new Vector();
    private final Hashtable providersByClassName = new Hashtable();
    private final Hashtable providersByProtocol = new Hashtable();

    class C05431 implements StreamLoader {
        C05431() {
        }

        public void load(InputStream inputStream) {
            Session.this.loadProvidersFromStream(inputStream);
        }
    }

    class C05442 implements StreamLoader {
        C05442() {
        }

        public void load(InputStream inputStream) {
            Session.this.addressMap.load(inputStream);
        }
    }

    class C05453 implements PrivilegedAction {
        C05453() {
        }

        public Object run() {
            Object obj = null;
            try {
                obj = Thread.currentThread().getContextClassLoader();
            } catch (SecurityException e) {
            }
            return obj;
        }
    }

    class C05464 implements PrivilegedExceptionAction {
        private final /* synthetic */ Class val$c;
        private final /* synthetic */ String val$name;

        C05464(Class cls, String str) {
            this.val$c = cls;
            this.val$name = str;
        }

        public Object run() {
            return this.val$c.getResourceAsStream(this.val$name);
        }
    }

    class C05475 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$cl;
        private final /* synthetic */ String val$name;

        C05475(ClassLoader classLoader, String str) {
            this.val$cl = classLoader;
            this.val$name = str;
        }

        public Object run() {
            try {
                Vector vector = new Vector();
                Enumeration resources = this.val$cl.getResources(this.val$name);
                while (resources != null && resources.hasMoreElements()) {
                    URL url = (URL) resources.nextElement();
                    if (url != null) {
                        vector.addElement(url);
                    }
                }
                if (vector.size() <= 0) {
                    return null;
                }
                Object obj = new URL[vector.size()];
                try {
                    vector.copyInto(obj);
                    return obj;
                } catch (IOException e) {
                    return obj;
                } catch (SecurityException e2) {
                    return obj;
                }
            } catch (IOException e3) {
                return null;
            } catch (SecurityException e4) {
                return null;
            }
        }
    }

    class C05486 implements PrivilegedAction {
        private final /* synthetic */ String val$name;

        C05486(String str) {
            this.val$name = str;
        }

        public Object run() {
            try {
                Vector vector = new Vector();
                Enumeration systemResources = ClassLoader.getSystemResources(this.val$name);
                while (systemResources != null && systemResources.hasMoreElements()) {
                    URL url = (URL) systemResources.nextElement();
                    if (url != null) {
                        vector.addElement(url);
                    }
                }
                if (vector.size() <= 0) {
                    return null;
                }
                Object obj = new URL[vector.size()];
                try {
                    vector.copyInto(obj);
                    return obj;
                } catch (IOException e) {
                    return obj;
                } catch (SecurityException e2) {
                    return obj;
                }
            } catch (IOException e3) {
                return null;
            } catch (SecurityException e4) {
                return null;
            }
        }
    }

    class C05497 implements PrivilegedExceptionAction {
        private final /* synthetic */ URL val$url;

        C05497(URL url) {
            this.val$url = url;
        }

        public Object run() {
            return this.val$url.openStream();
        }
    }

    private Session(Properties properties, Authenticator authenticator) {
        this.props = properties;
        this.authenticator = authenticator;
        if (Boolean.valueOf(properties.getProperty("mail.debug")).booleanValue()) {
            this.debug = true;
        }
        if (this.debug) {
            pr("DEBUG: JavaMail version 1.4.1");
        }
        Class cls = authenticator != null ? authenticator.getClass() : getClass();
        loadProviders(cls);
        loadAddressMap(cls);
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new C05453());
    }

    public static Session getDefaultInstance(Properties properties) {
        return getDefaultInstance(properties, null);
    }

    public static synchronized Session getDefaultInstance(Properties properties, Authenticator authenticator) {
        Session session;
        synchronized (Session.class) {
            if (defaultSession == null) {
                defaultSession = new Session(properties, authenticator);
            } else if (defaultSession.authenticator != authenticator && (defaultSession.authenticator == null || authenticator == null || defaultSession.authenticator.getClass().getClassLoader() != authenticator.getClass().getClassLoader())) {
                throw new SecurityException("Access to default session denied");
            }
            session = defaultSession;
        }
        return session;
    }

    public static Session getInstance(Properties properties) {
        return new Session(properties, null);
    }

    public static Session getInstance(Properties properties, Authenticator authenticator) {
        return new Session(properties, authenticator);
    }

    private static InputStream getResourceAsStream(Class cls, String str) {
        try {
            return (InputStream) AccessController.doPrivileged(new C05464(cls, str));
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    private static URL[] getResources(ClassLoader classLoader, String str) {
        return (URL[]) AccessController.doPrivileged(new C05475(classLoader, str));
    }

    private Object getService(Provider provider, URLName uRLName) {
        Class cls = null;
        if (provider == null) {
            throw new NoSuchProviderException("null");
        }
        Class loadClass;
        URLName uRLName2 = uRLName == null ? new URLName(provider.getProtocol(), cls, -1, cls, cls, cls) : uRLName;
        ClassLoader classLoader = this.authenticator != null ? this.authenticator.getClass().getClassLoader() : getClass().getClassLoader();
        try {
            ClassLoader contextClassLoader = getContextClassLoader();
            if (contextClassLoader != null) {
                try {
                    cls = contextClassLoader.loadClass(provider.getClassName());
                } catch (ClassNotFoundException e) {
                }
            }
            loadClass = cls == null ? classLoader.loadClass(provider.getClassName()) : cls;
        } catch (Exception e2) {
            try {
                loadClass = Class.forName(provider.getClassName());
            } catch (Exception e3) {
                if (this.debug) {
                    e3.printStackTrace(getDebugOut());
                }
                throw new NoSuchProviderException(provider.getProtocol());
            }
        }
        try {
            return loadClass.getConstructor(new Class[]{Session.class, URLName.class}).newInstance(new Object[]{this, uRLName2});
        } catch (Exception e32) {
            if (this.debug) {
                e32.printStackTrace(getDebugOut());
            }
            throw new NoSuchProviderException(provider.getProtocol());
        }
    }

    private Store getStore(Provider provider, URLName uRLName) {
        if (provider == null || provider.getType() != Type.STORE) {
            throw new NoSuchProviderException("invalid provider");
        }
        try {
            return (Store) getService(provider, uRLName);
        } catch (ClassCastException e) {
            throw new NoSuchProviderException("incorrect class");
        }
    }

    private static URL[] getSystemResources(String str) {
        return (URL[]) AccessController.doPrivileged(new C05486(str));
    }

    private Transport getTransport(Provider provider, URLName uRLName) {
        if (provider == null || provider.getType() != Type.TRANSPORT) {
            throw new NoSuchProviderException("invalid provider");
        }
        try {
            return (Transport) getService(provider, uRLName);
        } catch (ClassCastException e) {
            throw new NoSuchProviderException("incorrect class");
        }
    }

    private void loadAddressMap(Class cls) {
        StreamLoader c05442 = new C05442();
        loadResource("/META-INF/javamail.default.address.map", cls, c05442);
        loadAllResources("META-INF/javamail.address.map", cls, c05442);
        try {
            loadFile(new StringBuilder(String.valueOf(System.getProperty("java.home"))).append(File.separator).append("lib").append(File.separator).append("javamail.address.map").toString(), c05442);
        } catch (SecurityException e) {
            if (this.debug) {
                pr("DEBUG: can't get java.home: " + e);
            }
        }
        if (this.addressMap.isEmpty()) {
            if (this.debug) {
                pr("DEBUG: failed to load address map, using defaults");
            }
            this.addressMap.put("rfc822", "smtp");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAllResources(java.lang.String r9, java.lang.Class r10, javax.mail.StreamLoader r11) {
        /*
        r8 = this;
        r2 = 0;
        r0 = getContextClassLoader();	 Catch:{ Exception -> 0x00e5 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r10.getClassLoader();	 Catch:{ Exception -> 0x00e5 }
    L_0x000b:
        if (r0 == 0) goto L_0x0036;
    L_0x000d:
        r0 = getResources(r0, r9);	 Catch:{ Exception -> 0x00e5 }
        r4 = r0;
    L_0x0012:
        if (r4 == 0) goto L_0x0018;
    L_0x0014:
        r3 = r2;
    L_0x0015:
        r0 = r4.length;	 Catch:{ Exception -> 0x00e5 }
        if (r3 < r0) goto L_0x003c;
    L_0x0018:
        if (r2 != 0) goto L_0x0035;
    L_0x001a:
        r0 = r8.debug;
        if (r0 == 0) goto L_0x0023;
    L_0x001e:
        r0 = "DEBUG: !anyLoaded";
        r8.pr(r0);
    L_0x0023:
        r0 = new java.lang.StringBuilder;
        r1 = "/";
        r0.<init>(r1);
        r0 = r0.append(r9);
        r0 = r0.toString();
        r8.loadResource(r0, r10, r11);
    L_0x0035:
        return;
    L_0x0036:
        r0 = getSystemResources(r9);	 Catch:{ Exception -> 0x00e5 }
        r4 = r0;
        goto L_0x0012;
    L_0x003c:
        r0 = r4[r3];	 Catch:{ Exception -> 0x00e5 }
        r1 = 0;
        r5 = r8.debug;	 Catch:{ Exception -> 0x00e5 }
        if (r5 == 0) goto L_0x0055;
    L_0x0043:
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e5 }
        r6 = "DEBUG: URL ";
        r5.<init>(r6);	 Catch:{ Exception -> 0x00e5 }
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x00e5 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00e5 }
        r8.pr(r5);	 Catch:{ Exception -> 0x00e5 }
    L_0x0055:
        r1 = openStream(r0);	 Catch:{ IOException -> 0x0098, SecurityException -> 0x00bb, all -> 0x00de }
        if (r1 == 0) goto L_0x0080;
    L_0x005b:
        r11.load(r1);	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r2 = 1;
        r5 = r8.debug;	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        if (r5 == 0) goto L_0x0119;
    L_0x0063:
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r6 = "DEBUG: successfully loaded resource: ";
        r5.<init>(r6);	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r0 = r5.append(r0);	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r8.pr(r0);	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r0 = r2;
    L_0x0076:
        if (r1 == 0) goto L_0x007b;
    L_0x0078:
        r1.close();	 Catch:{ IOException -> 0x0100, Exception -> 0x0103 }
    L_0x007b:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r0;
        goto L_0x0015;
    L_0x0080:
        r5 = r8.debug;	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        if (r5 == 0) goto L_0x0119;
    L_0x0084:
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r6 = "DEBUG: not loading resource: ";
        r5.<init>(r6);	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r0 = r5.append(r0);	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r8.pr(r0);	 Catch:{ IOException -> 0x0113, SecurityException -> 0x010d, all -> 0x00de }
        r0 = r2;
        goto L_0x0076;
    L_0x0098:
        r0 = move-exception;
        r7 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r7;
    L_0x009d:
        r5 = r8.debug;	 Catch:{ all -> 0x0107 }
        if (r5 == 0) goto L_0x00b3;
    L_0x00a1:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0107 }
        r6 = "DEBUG: ";
        r5.<init>(r6);	 Catch:{ all -> 0x0107 }
        r1 = r5.append(r1);	 Catch:{ all -> 0x0107 }
        r1 = r1.toString();	 Catch:{ all -> 0x0107 }
        r8.pr(r1);	 Catch:{ all -> 0x0107 }
    L_0x00b3:
        if (r2 == 0) goto L_0x007b;
    L_0x00b5:
        r2.close();	 Catch:{ IOException -> 0x00b9, Exception -> 0x0103 }
        goto L_0x007b;
    L_0x00b9:
        r1 = move-exception;
        goto L_0x007b;
    L_0x00bb:
        r0 = move-exception;
        r7 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r7;
    L_0x00c0:
        r5 = r8.debug;	 Catch:{ all -> 0x0107 }
        if (r5 == 0) goto L_0x00d6;
    L_0x00c4:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0107 }
        r6 = "DEBUG: ";
        r5.<init>(r6);	 Catch:{ all -> 0x0107 }
        r1 = r5.append(r1);	 Catch:{ all -> 0x0107 }
        r1 = r1.toString();	 Catch:{ all -> 0x0107 }
        r8.pr(r1);	 Catch:{ all -> 0x0107 }
    L_0x00d6:
        if (r2 == 0) goto L_0x007b;
    L_0x00d8:
        r2.close();	 Catch:{ IOException -> 0x00dc, Exception -> 0x0103 }
        goto L_0x007b;
    L_0x00dc:
        r1 = move-exception;
        goto L_0x007b;
    L_0x00de:
        r0 = move-exception;
    L_0x00df:
        if (r1 == 0) goto L_0x00e4;
    L_0x00e1:
        r1.close();	 Catch:{ IOException -> 0x00fe }
    L_0x00e4:
        throw r0;	 Catch:{ Exception -> 0x00e5 }
    L_0x00e5:
        r0 = move-exception;
    L_0x00e6:
        r1 = r8.debug;
        if (r1 == 0) goto L_0x0018;
    L_0x00ea:
        r1 = new java.lang.StringBuilder;
        r3 = "DEBUG: ";
        r1.<init>(r3);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r8.pr(r0);
        goto L_0x0018;
    L_0x00fe:
        r1 = move-exception;
        goto L_0x00e4;
    L_0x0100:
        r1 = move-exception;
        goto L_0x007b;
    L_0x0103:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x00e6;
    L_0x0107:
        r1 = move-exception;
        r7 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r7;
        goto L_0x00df;
    L_0x010d:
        r0 = move-exception;
        r7 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x00c0;
    L_0x0113:
        r0 = move-exception;
        r7 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x009d;
    L_0x0119:
        r0 = r2;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.loadAllResources(java.lang.String, java.lang.Class, javax.mail.StreamLoader):void");
    }

    private void loadFile(String str, StreamLoader streamLoader) {
        Object e;
        Throwable th;
        InputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                streamLoader.load(bufferedInputStream);
                if (this.debug) {
                    pr("DEBUG: successfully loaded file: " + str);
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    if (this.debug) {
                        pr("DEBUG: not loading file: " + str);
                        pr("DEBUG: " + e);
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (SecurityException e6) {
                e = e6;
                if (this.debug) {
                    pr("DEBUG: not loading file: " + str);
                    pr("DEBUG: " + e);
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e7) {
                    }
                }
            }
        } catch (IOException e8) {
            e = e8;
            bufferedInputStream = null;
            if (this.debug) {
                pr("DEBUG: not loading file: " + str);
                pr("DEBUG: " + e);
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        } catch (SecurityException e9) {
            e = e9;
            bufferedInputStream = null;
            if (this.debug) {
                pr("DEBUG: not loading file: " + str);
                pr("DEBUG: " + e);
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    private void loadProviders(Class cls) {
        StreamLoader c05431 = new C05431();
        try {
            loadFile(new StringBuilder(String.valueOf(System.getProperty("java.home"))).append(File.separator).append("lib").append(File.separator).append("javamail.providers").toString(), c05431);
        } catch (SecurityException e) {
            if (this.debug) {
                pr("DEBUG: can't get java.home: " + e);
            }
        }
        loadAllResources("META-INF/javamail.providers", cls, c05431);
        loadResource("/META-INF/javamail.default.providers", cls, c05431);
        if (this.providers.size() == 0) {
            if (this.debug) {
                pr("DEBUG: failed to load any providers, using defaults");
            }
            addProvider(new Provider(Type.STORE, "imap", "com.sun.mail.imap.IMAPStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Type.STORE, "imaps", "com.sun.mail.imap.IMAPSSLStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Type.STORE, "pop3", "com.sun.mail.pop3.POP3Store", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Type.STORE, "pop3s", "com.sun.mail.pop3.POP3SSLStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Type.TRANSPORT, "smtp", "com.sun.mail.smtp.SMTPTransport", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Type.TRANSPORT, "smtps", "com.sun.mail.smtp.SMTPSSLTransport", "Sun Microsystems, Inc.", Version.version));
        }
        if (this.debug) {
            pr("DEBUG: Tables of loaded providers");
            pr("DEBUG: Providers Listed By Class Name: " + this.providersByClassName.toString());
            pr("DEBUG: Providers Listed By Protocol: " + this.providersByProtocol.toString());
        }
    }

    private void loadProvidersFromStream(InputStream inputStream) {
        if (inputStream != null) {
            LineInputStream lineInputStream = new LineInputStream(inputStream);
            while (true) {
                String readLine = lineInputStream.readLine();
                if (readLine != null) {
                    if (!readLine.startsWith("#")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine, ";");
                        String str = null;
                        String str2 = null;
                        String str3 = null;
                        String str4 = null;
                        Type type = null;
                        while (stringTokenizer.hasMoreTokens()) {
                            String trim = stringTokenizer.nextToken().trim();
                            int indexOf = trim.indexOf("=");
                            if (trim.startsWith("protocol=")) {
                                str4 = trim.substring(indexOf + 1);
                            } else if (trim.startsWith("type=")) {
                                trim = trim.substring(indexOf + 1);
                                if (trim.equalsIgnoreCase("store")) {
                                    type = Type.STORE;
                                } else if (trim.equalsIgnoreCase("transport")) {
                                    type = Type.TRANSPORT;
                                }
                            } else if (trim.startsWith("class=")) {
                                str3 = trim.substring(indexOf + 1);
                            } else if (trim.startsWith("vendor=")) {
                                str2 = trim.substring(indexOf + 1);
                            } else if (trim.startsWith("version=")) {
                                str = trim.substring(indexOf + 1);
                            }
                        }
                        if (type != null && str4 != null && str3 != null && str4.length() > 0 && str3.length() > 0) {
                            addProvider(new Provider(type, str4, str3, str2, str));
                        } else if (this.debug) {
                            pr("DEBUG: Bad provider entry: " + readLine);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void loadResource(String str, Class cls, StreamLoader streamLoader) {
        InputStream inputStream = null;
        try {
            inputStream = getResourceAsStream(cls, str);
            if (inputStream != null) {
                streamLoader.load(inputStream);
                if (this.debug) {
                    pr("DEBUG: successfully loaded resource: " + str);
                }
            } else if (this.debug) {
                pr("DEBUG: not loading resource: " + str);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (IOException e2) {
            if (this.debug) {
                pr("DEBUG: " + e2);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (SecurityException e4) {
            if (this.debug) {
                pr("DEBUG: " + e4);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
        }
    }

    private static InputStream openStream(URL url) {
        try {
            return (InputStream) AccessController.doPrivileged(new C05497(url));
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    private void pr(String str) {
        getDebugOut().println(str);
    }

    public final synchronized void addProvider(Provider provider) {
        this.providers.addElement(provider);
        this.providersByClassName.put(provider.getClassName(), provider);
        if (!this.providersByProtocol.containsKey(provider.getProtocol())) {
            this.providersByProtocol.put(provider.getProtocol(), provider);
        }
    }

    public final synchronized boolean getDebug() {
        return this.debug;
    }

    public final synchronized PrintStream getDebugOut() {
        return this.out == null ? System.out : this.out;
    }

    public final Folder getFolder(URLName uRLName) {
        Store store = getStore(uRLName);
        store.connect();
        return store.getFolder(uRLName);
    }

    public final PasswordAuthentication getPasswordAuthentication(URLName uRLName) {
        return (PasswordAuthentication) this.authTable.get(uRLName);
    }

    public final Properties getProperties() {
        return this.props;
    }

    public final String getProperty(String str) {
        return this.props.getProperty(str);
    }

    public final synchronized Provider getProvider(String str) {
        Provider provider;
        if (str != null) {
            if (str.length() > 0) {
                provider = null;
                String property = this.props.getProperty("mail." + str + ".class");
                if (property != null) {
                    if (this.debug) {
                        pr("DEBUG: mail." + str + ".class property exists and points to " + property);
                    }
                    provider = (Provider) this.providersByClassName.get(property);
                }
                if (provider == null) {
                    provider = (Provider) this.providersByProtocol.get(str);
                    if (provider == null) {
                        throw new NoSuchProviderException("No provider for " + str);
                    } else if (this.debug) {
                        pr("DEBUG: getProvider() returning " + provider.toString());
                    }
                }
            }
        }
        throw new NoSuchProviderException("Invalid protocol: null");
        return provider;
    }

    public final synchronized Provider[] getProviders() {
        Provider[] providerArr;
        providerArr = new Provider[this.providers.size()];
        this.providers.copyInto(providerArr);
        return providerArr;
    }

    public final Store getStore() {
        return getStore(getProperty("mail.store.protocol"));
    }

    public final Store getStore(String str) {
        return getStore(new URLName(str, null, -1, null, null, null));
    }

    public final Store getStore(Provider provider) {
        return getStore(provider, null);
    }

    public final Store getStore(URLName uRLName) {
        return getStore(getProvider(uRLName.getProtocol()), uRLName);
    }

    public final Transport getTransport() {
        return getTransport(getProperty("mail.transport.protocol"));
    }

    public final Transport getTransport(String str) {
        return getTransport(new URLName(str, null, -1, null, null, null));
    }

    public final Transport getTransport(Address address) {
        String str = (String) this.addressMap.get(address.getType());
        if (str != null) {
            return getTransport(str);
        }
        throw new NoSuchProviderException("No provider for Address type: " + address.getType());
    }

    public final Transport getTransport(Provider provider) {
        return getTransport(provider, null);
    }

    public final Transport getTransport(URLName uRLName) {
        return getTransport(getProvider(uRLName.getProtocol()), uRLName);
    }

    public final PasswordAuthentication requestPasswordAuthentication(InetAddress inetAddress, int i, String str, String str2, String str3) {
        return this.authenticator != null ? this.authenticator.requestPasswordAuthentication(inetAddress, i, str, str2, str3) : null;
    }

    public final synchronized void setDebug(boolean z) {
        this.debug = z;
        if (z) {
            pr("DEBUG: setDebug: JavaMail version 1.4.1");
        }
    }

    public final synchronized void setDebugOut(PrintStream printStream) {
        this.out = printStream;
    }

    public final void setPasswordAuthentication(URLName uRLName, PasswordAuthentication passwordAuthentication) {
        if (passwordAuthentication == null) {
            this.authTable.remove(uRLName);
        } else {
            this.authTable.put(uRLName, passwordAuthentication);
        }
    }

    public final synchronized void setProtocolForAddress(String str, String str2) {
        if (str2 == null) {
            this.addressMap.remove(str);
        } else {
            this.addressMap.put(str, str2);
        }
    }

    public final synchronized void setProvider(Provider provider) {
        if (provider == null) {
            throw new NoSuchProviderException("Can't set null provider");
        }
        this.providersByProtocol.put(provider.getProtocol(), provider);
        this.props.put("mail." + provider.getProtocol() + ".class", provider.getClassName());
    }
}
