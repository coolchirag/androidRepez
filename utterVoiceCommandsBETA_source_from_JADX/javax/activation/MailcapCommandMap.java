package javax.activation;

import com.sun.p031a.p032a.C0530b;
import com.sun.p031a.p032a.C0531c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MailcapCommandMap extends CommandMap {
    private static final int PROG = 0;
    private static C0531c defDB = null;
    private C0531c[] DB;

    public MailcapCommandMap() {
        C0531c loadFile;
        List arrayList = new ArrayList(5);
        arrayList.add(null);
        C0530b.m2786a("MailcapCommandMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                loadFile = loadFile(new StringBuilder(String.valueOf(property)).append(File.separator).append(".mailcap").toString());
                if (loadFile != null) {
                    arrayList.add(loadFile);
                }
            }
        } catch (SecurityException e) {
        }
        C0530b.m2786a("MailcapCommandMap: load SYS");
        try {
            loadFile = loadFile(new StringBuilder(String.valueOf(System.getProperty("java.home"))).append(File.separator).append("lib").append(File.separator).append("mailcap").toString());
            if (loadFile != null) {
                arrayList.add(loadFile);
            }
        } catch (SecurityException e2) {
        }
        C0530b.m2786a("MailcapCommandMap: load JAR");
        loadAllResources(arrayList, "mailcap");
        C0530b.m2786a("MailcapCommandMap: load DEF");
        synchronized (MailcapCommandMap.class) {
            if (defDB == null) {
                defDB = loadResource("mailcap.default");
            }
        }
        if (defDB != null) {
            arrayList.add(defDB);
        }
        this.DB = new C0531c[arrayList.size()];
        this.DB = (C0531c[]) arrayList.toArray(this.DB);
    }

    public MailcapCommandMap(InputStream inputStream) {
        this();
        C0530b.m2786a("MailcapCommandMap: load PROG");
        if (this.DB[0] == null) {
            try {
                this.DB[0] = new C0531c(inputStream);
            } catch (IOException e) {
            }
        }
    }

    public MailcapCommandMap(String str) {
        this();
        if (C0530b.m2788a()) {
            C0530b.m2786a("MailcapCommandMap: load PROG from " + str);
        }
        if (this.DB[0] == null) {
            this.DB[0] = new C0531c(str);
        }
    }

    private void appendCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            for (String commandInfo : (List) map.get(str)) {
                list.add(new CommandInfo(str, commandInfo));
            }
        }
    }

    private void appendPrefCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            if (!checkForVerb(list, str)) {
                list.add(new CommandInfo(str, (String) ((List) map.get(str)).get(0)));
            }
        }
    }

    private boolean checkForVerb(List list, String str) {
        for (CommandInfo commandName : list) {
            if (commandName.getCommandName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private DataContentHandler getDataContentHandler(String str) {
        if (C0530b.m2788a()) {
            C0530b.m2786a("    got content-handler");
        }
        if (C0530b.m2788a()) {
            C0530b.m2786a("      class " + str);
        }
        try {
            Class loadClass;
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            try {
                loadClass = contextClassLoader.loadClass(str);
            } catch (Exception e) {
                loadClass = Class.forName(str);
            }
            if (loadClass != null) {
                return (DataContentHandler) loadClass.newInstance();
            }
        } catch (Throwable e2) {
            if (C0530b.m2788a()) {
                C0530b.m2787a("Can't load DCH " + str, e2);
            }
        } catch (Throwable e22) {
            if (C0530b.m2788a()) {
                C0530b.m2787a("Can't load DCH " + str, e22);
            }
        } catch (Throwable e222) {
            if (C0530b.m2788a()) {
                C0530b.m2787a("Can't load DCH " + str, e222);
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAllResources(java.util.List r10, java.lang.String r11) {
        /*
        r9 = this;
        r2 = 0;
        r0 = javax.activation.SecuritySupport.getContextClassLoader();	 Catch:{ Exception -> 0x010b }
        if (r0 != 0) goto L_0x000f;
    L_0x0007:
        r0 = r9.getClass();	 Catch:{ Exception -> 0x010b }
        r0 = r0.getClassLoader();	 Catch:{ Exception -> 0x010b }
    L_0x000f:
        if (r0 == 0) goto L_0x004d;
    L_0x0011:
        r0 = javax.activation.SecuritySupport.getResources(r0, r11);	 Catch:{ Exception -> 0x010b }
        r4 = r0;
    L_0x0016:
        if (r4 == 0) goto L_0x0027;
    L_0x0018:
        r0 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ Exception -> 0x010b }
        if (r0 == 0) goto L_0x0023;
    L_0x001e:
        r0 = "MailcapCommandMap: getResources";
        com.sun.p031a.p032a.C0530b.m2786a(r0);	 Catch:{ Exception -> 0x010b }
    L_0x0023:
        r3 = r2;
    L_0x0024:
        r0 = r4.length;	 Catch:{ Exception -> 0x010b }
        if (r3 < r0) goto L_0x0053;
    L_0x0027:
        if (r2 != 0) goto L_0x004c;
    L_0x0029:
        r0 = com.sun.p031a.p032a.C0530b.m2788a();
        if (r0 == 0) goto L_0x0034;
    L_0x002f:
        r0 = "MailcapCommandMap: !anyLoaded";
        com.sun.p031a.p032a.C0530b.m2786a(r0);
    L_0x0034:
        r0 = new java.lang.StringBuilder;
        r1 = "/";
        r0.<init>(r1);
        r0 = r0.append(r11);
        r0 = r0.toString();
        r0 = r9.loadResource(r0);
        if (r0 == 0) goto L_0x004c;
    L_0x0049:
        r10.add(r0);
    L_0x004c:
        return;
    L_0x004d:
        r0 = javax.activation.SecuritySupport.getSystemResources(r11);	 Catch:{ Exception -> 0x010b }
        r4 = r0;
        goto L_0x0016;
    L_0x0053:
        r5 = r4[r3];	 Catch:{ Exception -> 0x010b }
        r1 = 0;
        r0 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ Exception -> 0x010b }
        if (r0 == 0) goto L_0x006e;
    L_0x005c:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010b }
        r6 = "MailcapCommandMap: URL ";
        r0.<init>(r6);	 Catch:{ Exception -> 0x010b }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x010b }
        r0 = r0.toString();	 Catch:{ Exception -> 0x010b }
        com.sun.p031a.p032a.C0530b.m2786a(r0);	 Catch:{ Exception -> 0x010b }
    L_0x006e:
        r1 = javax.activation.SecuritySupport.openStream(r5);	 Catch:{ IOException -> 0x00ba, SecurityException -> 0x00df, all -> 0x0104 }
        if (r1 == 0) goto L_0x00a0;
    L_0x0074:
        r0 = new com.sun.a.a.c;	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r10.add(r0);	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r2 = 1;
        r0 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        if (r0 == 0) goto L_0x0142;
    L_0x0083:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r6 = "MailcapCommandMap: successfully loaded mailcap file from URL: ";
        r0.<init>(r6);	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r0 = r0.append(r5);	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        com.sun.p031a.p032a.C0530b.m2786a(r0);	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r0 = r2;
    L_0x0096:
        if (r1 == 0) goto L_0x009b;
    L_0x0098:
        r1.close();	 Catch:{ IOException -> 0x0128, Exception -> 0x012b }
    L_0x009b:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r0;
        goto L_0x0024;
    L_0x00a0:
        r0 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        if (r0 == 0) goto L_0x0142;
    L_0x00a6:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r6 = "MailcapCommandMap: not loading mailcap file from URL: ";
        r0.<init>(r6);	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r0 = r0.append(r5);	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        com.sun.p031a.p032a.C0530b.m2786a(r0);	 Catch:{ IOException -> 0x013b, SecurityException -> 0x0135, all -> 0x0104 }
        r0 = r2;
        goto L_0x0096;
    L_0x00ba:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
    L_0x00bf:
        r6 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ all -> 0x012f }
        if (r6 == 0) goto L_0x00d7;
    L_0x00c5:
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012f }
        r7 = "MailcapCommandMap: can't load ";
        r6.<init>(r7);	 Catch:{ all -> 0x012f }
        r5 = r6.append(r5);	 Catch:{ all -> 0x012f }
        r5 = r5.toString();	 Catch:{ all -> 0x012f }
        com.sun.p031a.p032a.C0530b.m2787a(r5, r1);	 Catch:{ all -> 0x012f }
    L_0x00d7:
        if (r2 == 0) goto L_0x009b;
    L_0x00d9:
        r2.close();	 Catch:{ IOException -> 0x00dd, Exception -> 0x012b }
        goto L_0x009b;
    L_0x00dd:
        r1 = move-exception;
        goto L_0x009b;
    L_0x00df:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
    L_0x00e4:
        r6 = com.sun.p031a.p032a.C0530b.m2788a();	 Catch:{ all -> 0x012f }
        if (r6 == 0) goto L_0x00fc;
    L_0x00ea:
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012f }
        r7 = "MailcapCommandMap: can't load ";
        r6.<init>(r7);	 Catch:{ all -> 0x012f }
        r5 = r6.append(r5);	 Catch:{ all -> 0x012f }
        r5 = r5.toString();	 Catch:{ all -> 0x012f }
        com.sun.p031a.p032a.C0530b.m2787a(r5, r1);	 Catch:{ all -> 0x012f }
    L_0x00fc:
        if (r2 == 0) goto L_0x009b;
    L_0x00fe:
        r2.close();	 Catch:{ IOException -> 0x0102, Exception -> 0x012b }
        goto L_0x009b;
    L_0x0102:
        r1 = move-exception;
        goto L_0x009b;
    L_0x0104:
        r0 = move-exception;
    L_0x0105:
        if (r1 == 0) goto L_0x010a;
    L_0x0107:
        r1.close();	 Catch:{ IOException -> 0x0126 }
    L_0x010a:
        throw r0;	 Catch:{ Exception -> 0x010b }
    L_0x010b:
        r0 = move-exception;
    L_0x010c:
        r1 = com.sun.p031a.p032a.C0530b.m2788a();
        if (r1 == 0) goto L_0x0027;
    L_0x0112:
        r1 = new java.lang.StringBuilder;
        r3 = "MailcapCommandMap: can't load ";
        r1.<init>(r3);
        r1 = r1.append(r11);
        r1 = r1.toString();
        com.sun.p031a.p032a.C0530b.m2787a(r1, r0);
        goto L_0x0027;
    L_0x0126:
        r1 = move-exception;
        goto L_0x010a;
    L_0x0128:
        r1 = move-exception;
        goto L_0x009b;
    L_0x012b:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x010c;
    L_0x012f:
        r1 = move-exception;
        r8 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r8;
        goto L_0x0105;
    L_0x0135:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x00e4;
    L_0x013b:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x00bf;
    L_0x0142:
        r0 = r2;
        goto L_0x0096;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadAllResources(java.util.List, java.lang.String):void");
    }

    private C0531c loadFile(String str) {
        try {
            return new C0531c(str);
        } catch (IOException e) {
            return null;
        }
    }

    private C0531c loadResource(String str) {
        Throwable e;
        InputStream resourceAsStream;
        try {
            resourceAsStream = SecuritySupport.getResourceAsStream(getClass(), str);
            if (resourceAsStream != null) {
                try {
                    C0531c c0531c = new C0531c(resourceAsStream);
                    if (C0530b.m2788a()) {
                        C0530b.m2786a("MailcapCommandMap: successfully loaded mailcap file: " + str);
                    }
                    if (resourceAsStream == null) {
                        return c0531c;
                    }
                    try {
                        resourceAsStream.close();
                        return c0531c;
                    } catch (IOException e2) {
                        return c0531c;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        if (C0530b.m2788a()) {
                            C0530b.m2787a("MailcapCommandMap: can't load " + str, e);
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
                        C0530b.m2787a("MailcapCommandMap: can't load " + str, e);
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
                C0530b.m2786a("MailcapCommandMap: not loading mailcap file: " + str);
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
                C0530b.m2787a("MailcapCommandMap: can't load " + str, e);
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return null;
        } catch (SecurityException e10) {
            e = e10;
            resourceAsStream = null;
            if (C0530b.m2788a()) {
                C0530b.m2787a("MailcapCommandMap: can't load " + str, e);
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

    public synchronized void addMailcap(String str) {
        C0530b.m2786a("MailcapCommandMap: add to PROG");
        if (this.DB[0] == null) {
            this.DB[0] = new C0531c();
        }
        this.DB[0].m2798d(str);
    }

    public synchronized DataContentHandler createDataContentHandler(String str) {
        DataContentHandler dataContentHandler;
        int i = 0;
        synchronized (this) {
            Map a;
            List list;
            if (C0530b.m2788a()) {
                C0530b.m2786a("MailcapCommandMap: createDataContentHandler for " + str);
            }
            if (str != null) {
                str = str.toLowerCase(Locale.ENGLISH);
            }
            for (int i2 = 0; i2 < this.DB.length; i2++) {
                if (this.DB[i2] != null) {
                    if (C0530b.m2788a()) {
                        C0530b.m2786a("  search DB #" + i2);
                    }
                    a = this.DB[i2].m2794a(str);
                    if (a != null) {
                        list = (List) a.get("content-handler");
                        if (list != null) {
                            dataContentHandler = getDataContentHandler((String) list.get(0));
                            if (dataContentHandler != null) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
            while (i < this.DB.length) {
                if (this.DB[i] != null) {
                    if (C0530b.m2788a()) {
                        C0530b.m2786a("  search fallback DB #" + i);
                    }
                    a = this.DB[i].m2796b(str);
                    if (a != null) {
                        list = (List) a.get("content-handler");
                        if (list != null) {
                            dataContentHandler = getDataContentHandler((String) list.get(0));
                            if (dataContentHandler != null) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                i++;
            }
            dataContentHandler = null;
        }
        return dataContentHandler;
    }

    public synchronized CommandInfo[] getAllCommands(String str) {
        CommandInfo[] commandInfoArr;
        int i = 0;
        synchronized (this) {
            List arrayList = new ArrayList();
            if (str != null) {
                str = str.toLowerCase(Locale.ENGLISH);
            }
            for (int i2 = 0; i2 < this.DB.length; i2++) {
                if (this.DB[i2] != null) {
                    Map a = this.DB[i2].m2794a(str);
                    if (a != null) {
                        appendCmdsToList(a, arrayList);
                    }
                }
            }
            while (i < this.DB.length) {
                if (this.DB[i] != null) {
                    Map b = this.DB[i].m2796b(str);
                    if (b != null) {
                        appendCmdsToList(b, arrayList);
                    }
                }
                i++;
            }
            commandInfoArr = (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
        }
        return commandInfoArr;
    }

    public synchronized CommandInfo getCommand(String str, String str2) {
        CommandInfo commandInfo;
        int i = 0;
        synchronized (this) {
            String str3;
            if (str != null) {
                str = str.toLowerCase(Locale.ENGLISH);
            }
            for (int i2 = 0; i2 < this.DB.length; i2++) {
                Map a;
                List list;
                if (this.DB[i2] != null) {
                    a = this.DB[i2].m2794a(str);
                    if (a != null) {
                        list = (List) a.get(str2);
                        if (list != null) {
                            str3 = (String) list.get(0);
                            if (str3 != null) {
                                commandInfo = new CommandInfo(str2, str3);
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
            while (i < this.DB.length) {
                if (this.DB[i] != null) {
                    a = this.DB[i].m2796b(str);
                    if (a != null) {
                        list = (List) a.get(str2);
                        if (list != null) {
                            str3 = (String) list.get(0);
                            if (str3 != null) {
                                commandInfo = new CommandInfo(str2, str3);
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                i++;
            }
            commandInfo = null;
        }
        return commandInfo;
    }

    public synchronized String[] getMimeTypes() {
        List arrayList;
        arrayList = new ArrayList();
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null) {
                String[] a = this.DB[i].m2795a();
                if (a != null) {
                    for (int i2 = 0; i2 < a.length; i2++) {
                        if (!arrayList.contains(a[i2])) {
                            arrayList.add(a[i2]);
                        }
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized String[] getNativeCommands(String str) {
        List arrayList;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null) {
                String[] c = this.DB[i].m2797c(str);
                if (c != null) {
                    for (int i2 = 0; i2 < c.length; i2++) {
                        if (!arrayList.contains(c[i2])) {
                            arrayList.add(c[i2]);
                        }
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized CommandInfo[] getPreferredCommands(String str) {
        CommandInfo[] commandInfoArr;
        int i = 0;
        synchronized (this) {
            List arrayList = new ArrayList();
            if (str != null) {
                str = str.toLowerCase(Locale.ENGLISH);
            }
            for (int i2 = 0; i2 < this.DB.length; i2++) {
                if (this.DB[i2] != null) {
                    Map a = this.DB[i2].m2794a(str);
                    if (a != null) {
                        appendPrefCmdsToList(a, arrayList);
                    }
                }
            }
            while (i < this.DB.length) {
                if (this.DB[i] != null) {
                    Map b = this.DB[i].m2796b(str);
                    if (b != null) {
                        appendPrefCmdsToList(b, arrayList);
                    }
                }
                i++;
            }
            commandInfoArr = (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
        }
        return commandInfoArr;
    }
}
