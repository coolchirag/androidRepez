package com.sun.p031a.p032a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class C0531c {
    private static boolean f3034d;
    private Map f3035a = new HashMap();
    private Map f3036b = new HashMap();
    private Map f3037c = new HashMap();

    static {
        f3034d = false;
        try {
            f3034d = Boolean.getBoolean("javax.activation.addreverse");
        } catch (Throwable th) {
        }
    }

    public C0531c() {
        if (C0530b.m2788a()) {
            C0530b.m2786a("new MailcapFile: default");
        }
    }

    public C0531c(InputStream inputStream) {
        if (C0530b.m2788a()) {
            C0530b.m2786a("new MailcapFile: InputStream");
        }
        m2791a(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public C0531c(String str) {
        FileReader fileReader;
        Throwable th;
        if (C0530b.m2788a()) {
            C0530b.m2786a("new MailcapFile: file " + str);
        }
        try {
            fileReader = new FileReader(str);
            try {
                m2791a(new BufferedReader(fileReader));
                try {
                    fileReader.close();
                } catch (IOException e) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            if (fileReader != null) {
                fileReader.close();
            }
            throw th;
        }
    }

    private static Map m2789a(Map map, Map map2) {
        Map hashMap = new HashMap(map);
        for (String str : map2.keySet()) {
            List list = (List) hashMap.get(str);
            if (list == null) {
                hashMap.put(str, map2.get(str));
            } else {
                List list2 = (List) map2.get(str);
                List arrayList = new ArrayList(list);
                arrayList.addAll(list2);
                hashMap.put(str, arrayList);
            }
        }
        return hashMap;
    }

    private static void m2790a(int i, int i2, String str) {
        throw new C0532d("Encountered a " + C0533e.m2799a(i2) + " token (" + str + ") while expecting a " + C0533e.m2799a(i) + " token.");
    }

    private void m2791a(Reader reader) {
        BufferedReader bufferedReader = new BufferedReader(reader);
        Object obj = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                readLine = readLine.trim();
                try {
                    if (readLine.charAt(0) != '#') {
                        if (readLine.charAt(readLine.length() - 1) == '\\') {
                            obj = obj != null ? new StringBuilder(String.valueOf(obj)).append(readLine.substring(0, readLine.length() - 1)).toString() : readLine.substring(0, readLine.length() - 1);
                        } else if (obj != null) {
                            try {
                                m2793e(new StringBuilder(String.valueOf(obj)).append(readLine).toString());
                            } catch (C0532d e) {
                            }
                            obj = null;
                        } else {
                            try {
                                m2793e(readLine);
                            } catch (C0532d e2) {
                            }
                        }
                    }
                } catch (StringIndexOutOfBoundsException e3) {
                }
            } else {
                return;
            }
        }
    }

    private static void m2792b(int i, int i2, String str) {
        throw new C0532d("Encountered a " + C0533e.m2799a(i2) + " token (" + str + ") while expecting a " + C0533e.m2799a(i) + " or a " + C0533e.m2799a(59) + " token.");
    }

    private void m2793e(String str) {
        List list;
        C0533e c0533e = new C0533e(str);
        c0533e.f3039b = false;
        if (C0530b.m2788a()) {
            C0530b.m2786a("parse: " + str);
        }
        int a = c0533e.m2803a();
        if (a != 2) {
            C0531c.m2790a(2, a, c0533e.f3038a);
        }
        String toLowerCase = c0533e.f3038a.toLowerCase(Locale.ENGLISH);
        String str2 = "*";
        int a2 = c0533e.m2803a();
        if (!(a2 == 47 || a2 == 59)) {
            C0531c.m2792b(47, a2, c0533e.f3038a);
        }
        if (a2 == 47) {
            a = c0533e.m2803a();
            if (a != 2) {
                C0531c.m2790a(2, a, c0533e.f3038a);
            }
            str2 = c0533e.f3038a.toLowerCase(Locale.ENGLISH);
            a2 = c0533e.m2803a();
        }
        toLowerCase = new StringBuilder(String.valueOf(toLowerCase)).append("/").append(str2).toString();
        if (C0530b.m2788a()) {
            C0530b.m2786a("  Type: " + toLowerCase);
        }
        Map linkedHashMap = new LinkedHashMap();
        if (a2 != 59) {
            C0531c.m2790a(59, a2, c0533e.f3038a);
        }
        c0533e.f3039b = true;
        a2 = c0533e.m2803a();
        c0533e.f3039b = false;
        if (!(a2 == 2 || a2 == 59)) {
            C0531c.m2792b(2, a2, c0533e.f3038a);
        }
        if (a2 == 2) {
            list = (List) this.f3037c.get(toLowerCase);
            if (list == null) {
                list = new ArrayList();
                list.add(str);
                this.f3037c.put(toLowerCase, list);
            } else {
                list.add(str);
            }
        }
        a = a2 != 59 ? c0533e.m2803a() : a2;
        if (a == 59) {
            String str3;
            boolean z = false;
            do {
                a = c0533e.m2803a();
                if (a != 2) {
                    C0531c.m2790a(2, a, c0533e.f3038a);
                }
                String toLowerCase2 = c0533e.f3038a.toLowerCase(Locale.ENGLISH);
                a = c0533e.m2803a();
                if (a != 61 && a != 59 && a != 5) {
                    str3 = c0533e.f3038a;
                    if (C0530b.m2788a()) {
                        C0530b.m2786a("PARSE ERROR: Encountered a " + C0533e.m2799a(a) + " token (" + str3 + ") while expecting a " + C0533e.m2799a(61) + ", a " + C0533e.m2799a(59) + ", or a " + C0533e.m2799a(5) + " token.");
                    }
                    throw new C0532d("Encountered a " + C0533e.m2799a(a) + " token (" + str3 + ") while expecting a " + C0533e.m2799a(61) + ", a " + C0533e.m2799a(59) + ", or a " + C0533e.m2799a(5) + " token.");
                } else if (a == 61) {
                    boolean z2;
                    boolean z3;
                    c0533e.f3039b = true;
                    a = c0533e.m2803a();
                    c0533e.f3039b = false;
                    if (a != 2) {
                        C0531c.m2790a(2, a, c0533e.f3038a);
                    }
                    String str4 = c0533e.f3038a;
                    if (toLowerCase2.startsWith("x-java-")) {
                        toLowerCase2 = toLowerCase2.substring(7);
                        if (toLowerCase2.equals("fallback-entry") && str4.equalsIgnoreCase("true")) {
                            z2 = true;
                            z3 = z2;
                            a = c0533e.m2803a();
                            z = z3;
                            continue;
                        } else {
                            if (C0530b.m2788a()) {
                                C0530b.m2786a("    Command: " + toLowerCase2 + ", Class: " + str4);
                            }
                            list = (List) linkedHashMap.get(toLowerCase2);
                            if (list == null) {
                                list = new ArrayList();
                                linkedHashMap.put(toLowerCase2, list);
                            }
                            if (f3034d) {
                                list.add(0, str4);
                                z2 = z;
                                z3 = z2;
                                a = c0533e.m2803a();
                                z = z3;
                                continue;
                            } else {
                                list.add(str4);
                            }
                        }
                    }
                    z2 = z;
                    z3 = z2;
                    a = c0533e.m2803a();
                    z = z3;
                    continue;
                }
            } while (a == 59);
            Map map = z ? this.f3036b : this.f3035a;
            Map map2 = (Map) map.get(toLowerCase);
            if (map2 == null) {
                map.put(toLowerCase, linkedHashMap);
                return;
            }
            if (C0530b.m2788a()) {
                C0530b.m2786a("Merging commands for type " + toLowerCase);
            }
            for (String str32 : map2.keySet()) {
                List list2 = (List) map2.get(str32);
                List<String> list3 = (List) linkedHashMap.get(str32);
                if (list3 != null) {
                    for (String str322 : list3) {
                        if (!list2.contains(str322)) {
                            if (f3034d) {
                                list2.add(0, str322);
                            } else {
                                list2.add(str322);
                            }
                        }
                    }
                }
            }
            for (String str3222 : linkedHashMap.keySet()) {
                if (!map2.containsKey(str3222)) {
                    map2.put(str3222, (List) linkedHashMap.get(str3222));
                }
            }
        } else if (a != 5) {
            C0531c.m2792b(5, a, c0533e.f3038a);
        }
    }

    public final Map m2794a(String str) {
        Map map = (Map) this.f3035a.get(str);
        int indexOf = str.indexOf(47);
        if (str.substring(indexOf + 1).equals("*")) {
            return map;
        }
        Map map2 = (Map) this.f3035a.get(str.substring(0, indexOf + 1) + "*");
        return map2 != null ? map != null ? C0531c.m2789a(map, map2) : map2 : map;
    }

    public final String[] m2795a() {
        Set hashSet = new HashSet(this.f3035a.keySet());
        hashSet.addAll(this.f3036b.keySet());
        hashSet.addAll(this.f3037c.keySet());
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final Map m2796b(String str) {
        Map map = (Map) this.f3036b.get(str);
        int indexOf = str.indexOf(47);
        if (str.substring(indexOf + 1).equals("*")) {
            return map;
        }
        Map map2 = (Map) this.f3036b.get(str.substring(0, indexOf + 1) + "*");
        return map2 != null ? map != null ? C0531c.m2789a(map, map2) : map2 : map;
    }

    public final String[] m2797c(String str) {
        List list = (List) this.f3037c.get(str.toLowerCase(Locale.ENGLISH));
        return list != null ? (String[]) list.toArray(new String[list.size()]) : null;
    }

    public final void m2798d(String str) {
        if (C0530b.m2788a()) {
            C0530b.m2786a("appendToMailcap: " + str);
        }
        try {
            m2791a(new StringReader(str));
        } catch (IOException e) {
        }
    }
}
