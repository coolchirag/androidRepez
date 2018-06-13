package javax.activation;

import com.sun.p031a.p032a.C0530b;
import com.sun.p031a.p032a.C0534f;
import com.sun.p031a.p032a.C0535g;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Vector;

public class MimetypesFileTypeMap extends FileTypeMap {
    private static final int PROG = 0;
    private static C0535g defDB = null;
    private static String defaultType = "application/octet-stream";
    private C0535g[] DB;

    public MimetypesFileTypeMap() {
        C0535g loadFile;
        Vector vector = new Vector(5);
        vector.addElement(null);
        C0530b.m2786a("MimetypesFileTypeMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                loadFile = loadFile(new StringBuilder(String.valueOf(property)).append(File.separator).append(".mime.types").toString());
                if (loadFile != null) {
                    vector.addElement(loadFile);
                }
            }
        } catch (SecurityException e) {
        }
        C0530b.m2786a("MimetypesFileTypeMap: load SYS");
        try {
            loadFile = loadFile(new StringBuilder(String.valueOf(System.getProperty("java.home"))).append(File.separator).append("lib").append(File.separator).append("mime.types").toString());
            if (loadFile != null) {
                vector.addElement(loadFile);
            }
        } catch (SecurityException e2) {
        }
        C0530b.m2786a("MimetypesFileTypeMap: load JAR");
        loadAllResources(vector, "mime.types");
        C0530b.m2786a("MimetypesFileTypeMap: load DEF");
        synchronized (MimetypesFileTypeMap.class) {
            if (defDB == null) {
                defDB = loadResource("/mimetypes.default");
            }
        }
        if (defDB != null) {
            vector.addElement(defDB);
        }
        this.DB = new C0535g[vector.size()];
        vector.copyInto(this.DB);
    }

    public MimetypesFileTypeMap(InputStream inputStream) {
        this();
        try {
            this.DB[0] = new C0535g(inputStream);
        } catch (IOException e) {
        }
    }

    public MimetypesFileTypeMap(String str) {
        this();
        this.DB[0] = new C0535g(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAllResources(java.util.Vector r10, java.lang.String r11) {
        /*
        r9 = this;
        r2 = 0;
        r0 = javax.activation.SecuritySupport.getContextClassLoader();	 Catch:{ Exception -> 0x0105 }
        if (r0 != 0) goto L_0x000f;
    L_0x0007:
        r0 = r9.getClass();	 Catch:{ Exception -> 0x0105 }
        r0 = r0.getClassLoader();	 Catch:{ Exception -> 0x0105 }
    L_0x000f:
        if (r0 == 0) goto L_0x0047;
    L_0x0011:
        r0 = javax.activation.SecuritySupport.getResources(r0, r11);	 Catch:{ Exception -> 0x0105 }
        r4 = r0;
    L_0x0016:
        if (r4 == 0) goto L_0x0027;
    L_0x0018:
        r0 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ Exception -> 0x0105 }
        if (r0 == 0) goto L_0x0023;
    L_0x001e:
        r0 = "MimetypesFileTypeMap: getResources";
        com.sun.p031a.p032a.C0530b.m2786a(r0);	 Catch:{ Exception -> 0x0105 }
    L_0x0023:
        r3 = r2;
    L_0x0024:
        r0 = r4.length;	 Catch:{ Exception -> 0x0105 }
        if (r3 < r0) goto L_0x004d;
    L_0x0027:
        if (r2 != 0) goto L_0x0046;
    L_0x0029:
        r0 = "MimetypesFileTypeMap: !anyLoaded";
        com.sun.p031a.p032a.C0530b.m2786a(r0);
        r0 = new java.lang.StringBuilder;
        r1 = "/";
        r0.<init>(r1);
        r0 = r0.append(r11);
        r0 = r0.toString();
        r0 = r9.loadResource(r0);
        if (r0 == 0) goto L_0x0046;
    L_0x0043:
        r10.addElement(r0);
    L_0x0046:
        return;
    L_0x0047:
        r0 = javax.activation.SecuritySupport.getSystemResources(r11);	 Catch:{ Exception -> 0x0105 }
        r4 = r0;
        goto L_0x0016;
    L_0x004d:
        r5 = r4[r3];	 Catch:{ Exception -> 0x0105 }
        r1 = 0;
        r0 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ Exception -> 0x0105 }
        if (r0 == 0) goto L_0x0068;
    L_0x0056:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0105 }
        r6 = "MimetypesFileTypeMap: URL ";
        r0.<init>(r6);	 Catch:{ Exception -> 0x0105 }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x0105 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0105 }
        com.sun.p031a.p032a.C0530b.m2786a(r0);	 Catch:{ Exception -> 0x0105 }
    L_0x0068:
        r1 = javax.activation.SecuritySupport.openStream(r5);	 Catch:{ IOException -> 0x00b4, SecurityException -> 0x00d9, all -> 0x00fe }
        if (r1 == 0) goto L_0x009a;
    L_0x006e:
        r0 = new com.sun.a.a.g;	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r10.addElement(r0);	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r2 = 1;
        r0 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        if (r0 == 0) goto L_0x013c;
    L_0x007d:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r6 = "MimetypesFileTypeMap: successfully loaded mime types from URL: ";
        r0.<init>(r6);	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r0 = r0.append(r5);	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        com.sun.p031a.p032a.C0530b.m2786a(r0);	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r0 = r2;
    L_0x0090:
        if (r1 == 0) goto L_0x0095;
    L_0x0092:
        r1.close();	 Catch:{ IOException -> 0x0122, Exception -> 0x0125 }
    L_0x0095:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r0;
        goto L_0x0024;
    L_0x009a:
        r0 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        if (r0 == 0) goto L_0x013c;
    L_0x00a0:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r6 = "MimetypesFileTypeMap: not loading mime types from URL: ";
        r0.<init>(r6);	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r0 = r0.append(r5);	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        com.sun.p031a.p032a.C0530b.m2786a(r0);	 Catch:{ IOException -> 0x0135, SecurityException -> 0x012f, all -> 0x00fe }
        r0 = r2;
        goto L_0x0090;
    L_0x00b4:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
    L_0x00b9:
        r6 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ all -> 0x0129 }
        if (r6 == 0) goto L_0x00d1;
    L_0x00bf:
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0129 }
        r7 = "MimetypesFileTypeMap: can't load ";
        r6.<init>(r7);	 Catch:{ all -> 0x0129 }
        r5 = r6.append(r5);	 Catch:{ all -> 0x0129 }
        r5 = r5.toString();	 Catch:{ all -> 0x0129 }
        com.sun.p031a.p032a.C0530b.m2787a(r5, r1);	 Catch:{ all -> 0x0129 }
    L_0x00d1:
        if (r2 == 0) goto L_0x0095;
    L_0x00d3:
        r2.close();	 Catch:{ IOException -> 0x00d7, Exception -> 0x0125 }
        goto L_0x0095;
    L_0x00d7:
        r1 = move-exception;
        goto L_0x0095;
    L_0x00d9:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
    L_0x00de:
        r6 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ all -> 0x0129 }
        if (r6 == 0) goto L_0x00f6;
    L_0x00e4:
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0129 }
        r7 = "MimetypesFileTypeMap: can't load ";
        r6.<init>(r7);	 Catch:{ all -> 0x0129 }
        r5 = r6.append(r5);	 Catch:{ all -> 0x0129 }
        r5 = r5.toString();	 Catch:{ all -> 0x0129 }
        com.sun.p031a.p032a.C0530b.m2787a(r5, r1);	 Catch:{ all -> 0x0129 }
    L_0x00f6:
        if (r2 == 0) goto L_0x0095;
    L_0x00f8:
        r2.close();	 Catch:{ IOException -> 0x00fc, Exception -> 0x0125 }
        goto L_0x0095;
    L_0x00fc:
        r1 = move-exception;
        goto L_0x0095;
    L_0x00fe:
        r0 = move-exception;
    L_0x00ff:
        if (r1 == 0) goto L_0x0104;
    L_0x0101:
        r1.close();	 Catch:{ IOException -> 0x0120 }
    L_0x0104:
        throw r0;	 Catch:{ Exception -> 0x0105 }
    L_0x0105:
        r0 = move-exception;
    L_0x0106:
        r1 = com.sun.p031a.p032a.C0530b.m2788a();
        if (r1 == 0) goto L_0x0027;
    L_0x010c:
        r1 = new java.lang.StringBuilder;
        r3 = "MimetypesFileTypeMap: can't load ";
        r1.<init>(r3);
        r1 = r1.append(r11);
        r1 = r1.toString();
        com.sun.p031a.p032a.C0530b.m2787a(r1, r0);
        goto L_0x0027;
    L_0x0120:
        r1 = move-exception;
        goto L_0x0104;
    L_0x0122:
        r1 = move-exception;
        goto L_0x0095;
    L_0x0125:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x0106;
    L_0x0129:
        r1 = move-exception;
        r8 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r8;
        goto L_0x00ff;
    L_0x012f:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x00de;
    L_0x0135:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x00b9;
    L_0x013c:
        r0 = r2;
        goto L_0x0090;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadAllResources(java.util.Vector, java.lang.String):void");
    }

    private C0535g loadFile(String str) {
        try {
            return new C0535g(str);
        } catch (IOException e) {
            return null;
        }
    }

    private C0535g loadResource(String str) {
        InputStream resourceAsStream;
        Throwable e;
        try {
            resourceAsStream = SecuritySupport.getResourceAsStream(getClass(), str);
            if (resourceAsStream != null) {
                try {
                    C0535g c0535g = new C0535g(resourceAsStream);
                    if (C0530b.m2788a()) {
                        C0530b.m2786a("MimetypesFileTypeMap: successfully loaded mime types file: " + str);
                    }
                    if (resourceAsStream == null) {
                        return c0535g;
                    }
                    try {
                        resourceAsStream.close();
                        return c0535g;
                    } catch (IOException e2) {
                        return c0535g;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        if (C0530b.m2788a()) {
                            C0530b.m2787a("MimetypesFileTypeMap: can't load " + str, e);
                        }
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw e;
                    }
                } catch (SecurityException e6) {
                    e = e6;
                    if (C0530b.m2788a()) {
                        C0530b.m2787a("MimetypesFileTypeMap: can't load " + str, e);
                    }
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    return null;
                }
            }
            if (C0530b.m2788a()) {
                C0530b.m2786a("MimetypesFileTypeMap: not loading mime types file: " + str);
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e8) {
                }
            }
            return null;
        } catch (IOException e9) {
            e = e9;
            resourceAsStream = null;
            if (C0530b.m2788a()) {
                C0530b.m2787a("MimetypesFileTypeMap: can't load " + str, e);
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return null;
        } catch (SecurityException e10) {
            e = e10;
            resourceAsStream = null;
            if (C0530b.m2788a()) {
                C0530b.m2787a("MimetypesFileTypeMap: can't load " + str, e);
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            resourceAsStream = null;
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            throw e;
        }
    }

    public synchronized void addMimeTypes(String str) {
        if (this.DB[0] == null) {
            this.DB[0] = new C0535g();
        }
        try {
            this.DB[0].m2805a(new BufferedReader(new StringReader(str)));
        } catch (IOException e) {
        }
    }

    public String getContentType(File file) {
        return getContentType(file.getName());
    }

    public synchronized String getContentType(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            str2 = defaultType;
        } else {
            String substring = str.substring(lastIndexOf + 1);
            if (substring.length() == 0) {
                str2 = defaultType;
            } else {
                for (int i = 0; i < this.DB.length; i++) {
                    if (this.DB[i] != null) {
                        C0534f c0534f = (C0534f) this.DB[i].f3047a.get(substring);
                        str2 = c0534f != null ? c0534f.f3045a : null;
                        if (str2 != null) {
                            break;
                        }
                    }
                }
                str2 = defaultType;
            }
        }
        return str2;
    }
}
