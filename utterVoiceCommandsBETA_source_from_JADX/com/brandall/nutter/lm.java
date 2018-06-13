package com.brandall.nutter;

import java.util.SortedMap;
import java.util.TreeMap;

public final class lm {
    private static final int[] f1682g;
    private SortedMap<String, Double> f1683a = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private SortedMap<String, Double> f1684b;
    private SortedMap<String, lo> f1685c;
    private boolean f1686d;
    private int f1687e;
    private boolean f1688f;

    static {
        int[] iArr = new int[127];
        iArr[43] = 1;
        iArr[45] = 1;
        iArr[42] = 2;
        iArr[47] = 2;
        iArr[37] = 2;
        iArr[94] = 3;
        iArr[61] = Integer.MAX_VALUE;
        f1682g = iArr;
    }

    public lm() {
        m1329a("E", 2.718281828459045d);
        m1329a("Euler", 0.577215664901533d);
        m1329a("LN2", 0.693147180559945d);
        m1329a("LN10", 2.302585092994046d);
        m1329a("LOG2E", 1.442695040888963d);
        m1329a("LOG10E", 0.434294481903252d);
        m1329a("PHI", 1.618033988749895d);
        m1329a("PI", 3.141592653589793d);
        this.f1684b = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.f1685c = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.f1687e = 0;
        this.f1688f = false;
    }

    private double m1326a(String str, int i, int i2) {
        return m1327a(str, i, i2, ' ', 0.0d, '=');
    }

    private double m1327a(String str, int i, int i2, char c, double d, char c2) {
        String substring;
        char c3 = '\u0000';
        int i3 = i;
        while (i3 <= i2 && Character.isWhitespace(str.charAt(i3))) {
            i3++;
        }
        if (i3 > i2) {
            throw m1336b(str, i3, "Blank expression or sub-expression");
        }
        double d2;
        char c4 = c2;
        double d3 = d;
        while (i3 <= i2) {
            int i4;
            char charAt;
            char c5;
            int i5 = i3;
            while (i5 <= i2 && Character.isWhitespace(str.charAt(i5))) {
                i5++;
            }
            if (i5 <= i2) {
                int a;
                double a2;
                char c6;
                int i6;
                char c7;
                String str2;
                int i7;
                String substring2;
                Double d4;
                double doubleValue;
                double d5;
                Object obj = null;
                i4 = i5;
                while (i4 <= i2) {
                    charAt = str.charAt(i4);
                    if (charAt == '(') {
                        a = m1328a(')', str, i4 + 1, i2);
                        if (a > i2) {
                            throw m1336b(str, i4, "Unclosed parenthesis");
                        }
                        obj = 1;
                    } else {
                        if (m1332a(charAt)) {
                            Object obj2 = (charAt == '-' || charAt == '+') ? 1 : null;
                            if (obj2 == null || i4 != i5) {
                                c3 = charAt;
                                charAt = str.charAt(i5);
                                if (charAt == '(') {
                                    i3 = i4 - 1;
                                    while (i3 > i5 && str.charAt(i3) != ')') {
                                        i3--;
                                    }
                                    a2 = m1326a(str, i5 + 1, i3 - 1);
                                    c6 = c3;
                                } else if (Character.isLetter(charAt)) {
                                    if (obj == null) {
                                        a = m1328a('(', str, i5, i2);
                                        substring = str.substring(i5, a);
                                        i6 = a - 1;
                                        c7 = '*';
                                    } else {
                                        substring = str.substring(i5, i4).trim();
                                        i6 = i4;
                                        c7 = c3;
                                    }
                                    str2 = "0x";
                                    if (substring == null) {
                                        try {
                                        } catch (NumberFormatException e) {
                                            throw m1336b(str, i5, "Invalid numeric value \"" + substring + "\"");
                                        }
                                    }
                                    if (substring == null ? substring.regionMatches(true, 0, str2, 0, str2.length()) : false) {
                                        a2 = Double.parseDouble(substring);
                                        i4 = i6;
                                        c6 = c7;
                                    } else {
                                        a2 = (double) Long.parseLong(substring.substring(2), 16);
                                        i4 = i6;
                                        c6 = c7;
                                    }
                                } else if (obj == null) {
                                    a2 = m1334b(str, i5, i4 - 1);
                                    c6 = c3;
                                } else {
                                    i7 = i4 - 1;
                                    while (i5 <= i7 && Character.isWhitespace(str.charAt(i7))) {
                                        i7--;
                                    }
                                    if (i5 <= i7) {
                                        throw m1336b(str, i5, "Blank expression or sub-expression");
                                    }
                                    substring2 = str.substring(i5, i7 + 1);
                                    d4 = (Double) this.f1683a.get(substring2);
                                    if (d4 == null) {
                                        doubleValue = d4.doubleValue();
                                    } else {
                                        d4 = (Double) this.f1684b.get(substring2);
                                        if (d4 != null) {
                                            this.f1688f = false;
                                            doubleValue = d4.doubleValue();
                                        } else if (this.f1686d) {
                                            throw m1336b(str, i5, "Unrecognized constant or variable \"" + str.substring(i5, i7 + 1) + "\"");
                                        } else {
                                            this.f1688f = false;
                                            doubleValue = 0.0d;
                                        }
                                    }
                                    a2 = doubleValue;
                                    c6 = c3;
                                }
                                if (m1335b(c6) <= m1335b(c4)) {
                                    a2 = m1327a(str, i4 + 1, i2, c4, a2, c6);
                                    a = this.f1687e;
                                    charAt = str.charAt(a > i2 ? a : i2);
                                    i4 = a;
                                    d5 = a2;
                                } else {
                                    d5 = a2;
                                    charAt = c6;
                                }
                                switch (c4) {
                                    case '%':
                                        d5 = d3 % d5;
                                        break;
                                    case '*':
                                        d5 *= d3;
                                        break;
                                    case '+':
                                        d5 += d3;
                                        break;
                                    case '-':
                                        d5 = d3 - d5;
                                        break;
                                    case '/':
                                        d5 = d3 / d5;
                                        break;
                                    case '=':
                                        break;
                                    case '^':
                                        try {
                                            d5 = Math.pow(d3, d5);
                                            break;
                                        } catch (Throwable e2) {
                                            throw m1331a(str, i5, "Mathematical expression \"" + str + "\" failed to evaluate", e2);
                                        }
                                    default:
                                        i3 = i5;
                                        while (i3 > 0) {
                                            if (m1332a(str.charAt(i3))) {
                                                i3--;
                                            } else {
                                                throw m1336b(str, i3, "Operator \"" + c4 + "\" not handled by math engine (Programmer error: The list of operators is inconsistent with the engine)");
                                            }
                                        }
                                        throw m1336b(str, i3, "Operator \"" + c4 + "\" not handled by math engine (Programmer error: The list of operators is inconsistent with the engine)");
                                }
                                if (m1335b(charAt) <= m1335b(c)) {
                                    d3 = d5;
                                    c5 = charAt;
                                } else {
                                    d2 = d5;
                                    i3 = i4;
                                    this.f1687e = i3;
                                    return d2;
                                }
                            }
                        }
                        a = i4;
                    }
                    i4 = a + 1;
                    c3 = charAt;
                }
                charAt = str.charAt(i5);
                if (charAt == '(') {
                    i3 = i4 - 1;
                    while (i3 > i5) {
                        i3--;
                    }
                    a2 = m1326a(str, i5 + 1, i3 - 1);
                    c6 = c3;
                } else if (Character.isLetter(charAt)) {
                    if (obj == null) {
                        substring = str.substring(i5, i4).trim();
                        i6 = i4;
                        c7 = c3;
                    } else {
                        a = m1328a('(', str, i5, i2);
                        substring = str.substring(i5, a);
                        i6 = a - 1;
                        c7 = '*';
                    }
                    str2 = "0x";
                    if (substring == null ? substring.regionMatches(true, 0, str2, 0, str2.length()) : false) {
                        a2 = Double.parseDouble(substring);
                        i4 = i6;
                        c6 = c7;
                    } else {
                        a2 = (double) Long.parseLong(substring.substring(2), 16);
                        i4 = i6;
                        c6 = c7;
                    }
                } else if (obj == null) {
                    i7 = i4 - 1;
                    while (i5 <= i7) {
                        i7--;
                    }
                    if (i5 <= i7) {
                        substring2 = str.substring(i5, i7 + 1);
                        d4 = (Double) this.f1683a.get(substring2);
                        if (d4 == null) {
                            d4 = (Double) this.f1684b.get(substring2);
                            if (d4 != null) {
                                this.f1688f = false;
                                doubleValue = d4.doubleValue();
                            } else if (this.f1686d) {
                                throw m1336b(str, i5, "Unrecognized constant or variable \"" + str.substring(i5, i7 + 1) + "\"");
                            } else {
                                this.f1688f = false;
                                doubleValue = 0.0d;
                            }
                        } else {
                            doubleValue = d4.doubleValue();
                        }
                        a2 = doubleValue;
                        c6 = c3;
                    } else {
                        throw m1336b(str, i5, "Blank expression or sub-expression");
                    }
                } else {
                    a2 = m1334b(str, i5, i4 - 1);
                    c6 = c3;
                }
                if (m1335b(c6) <= m1335b(c4)) {
                    d5 = a2;
                    charAt = c6;
                } else {
                    a2 = m1327a(str, i4 + 1, i2, c4, a2, c6);
                    a = this.f1687e;
                    if (a > i2) {
                    }
                    charAt = str.charAt(a > i2 ? a : i2);
                    i4 = a;
                    d5 = a2;
                }
                switch (c4) {
                    case '%':
                        d5 = d3 % d5;
                        break;
                    case '*':
                        d5 *= d3;
                        break;
                    case '+':
                        d5 += d3;
                        break;
                    case '-':
                        d5 = d3 - d5;
                        break;
                    case '/':
                        d5 = d3 / d5;
                        break;
                    case '=':
                        break;
                    case '^':
                        d5 = Math.pow(d3, d5);
                        break;
                    default:
                        i3 = i5;
                        while (i3 > 0) {
                            if (m1332a(str.charAt(i3))) {
                                i3--;
                            } else {
                                throw m1336b(str, i3, "Operator \"" + c4 + "\" not handled by math engine (Programmer error: The list of operators is inconsistent with the engine)");
                            }
                        }
                        throw m1336b(str, i3, "Operator \"" + c4 + "\" not handled by math engine (Programmer error: The list of operators is inconsistent with the engine)");
                }
                if (m1335b(charAt) <= m1335b(c)) {
                    d2 = d5;
                    i3 = i4;
                    this.f1687e = i3;
                    return d2;
                }
                d3 = d5;
                c5 = charAt;
            } else {
                i4 = i5;
                c5 = c3;
                charAt = c4;
            }
            if (i4 == i2 && m1332a(c5)) {
                throw m1336b(str, i4, "Expression ends with a blank sub-expression");
            }
            c4 = charAt;
            char c8 = c5;
            i3 = i4 + 1;
            c3 = c8;
        }
        d2 = d3;
        this.f1687e = i3;
        return d2;
    }

    private static int m1328a(char c, String str, int i, int i2) {
        int i3;
        char c2;
        Object obj;
        if (c == ')') {
            obj = 1;
            i3 = 1;
            c2 = '(';
        } else if (c == ']') {
            r2 = 1;
            i3 = 1;
            c2 = '[';
        } else if (c == '}') {
            r2 = 1;
            i3 = 1;
            c2 = '{';
        } else if (c == '>') {
            r2 = 1;
            i3 = 1;
            c2 = '<';
        } else if (c == '\"') {
            obj = null;
            i3 = 1;
            c2 = '\u0000';
        } else if (c == '\'') {
            obj = null;
            i3 = 1;
            c2 = '\u0000';
        } else {
            obj = null;
            i3 = 1;
            c2 = '\u0000';
        }
        while (i <= i2) {
            char charAt = str.charAt(i);
            if (charAt == c2 && r2 != null) {
                i3++;
            } else if (charAt == c) {
                i3--;
                if (i3 == 0) {
                    break;
                }
            } else {
                continue;
            }
            i++;
        }
        return i;
    }

    private lm m1329a(String str, double d) {
        Double valueOf = Double.valueOf(d);
        if (!Character.isLetter(str.charAt(0))) {
            throw new IllegalArgumentException("Constant names must start with a letter");
        } else if (str.indexOf(40) != -1) {
            throw new IllegalArgumentException("Constant names may not contain a parenthesis");
        } else if (str.indexOf(41) != -1) {
            throw new IllegalArgumentException("Constant names may not contain a parenthesis");
        } else if (this.f1683a.get(str) != null) {
            throw new IllegalArgumentException("Constants may not be redefined");
        } else {
            this.f1683a.put(str, valueOf);
            return this;
        }
    }

    private static ArithmeticException m1331a(String str, int i, String str2, Throwable th) {
        return new ArithmeticException(new StringBuilder(String.valueOf(str2)).append(" at offset ").append(i).append(" in expression \"").append(str).append("\" (Cause: ").append(th.getMessage() != null ? th.getMessage() : th.toString()).append(")").toString());
    }

    private static boolean m1332a(char c) {
        return c < '' && f1682g[c] != 0;
    }

    private double m1333b(String str) {
        return m1326a(str, 0, str.length() - 1);
    }

    private double m1334b(String str, int i, int i2) {
        Throwable e;
        ln lnVar = null;
        int i3 = i;
        while (i3 <= i2 && str.charAt(i3) != '(') {
            i3++;
        }
        while (i3 <= i2 && str.charAt(i2) != ')') {
            i2--;
        }
        ln lnVar2 = new ln(this, str, i3, i2);
        try {
            double a;
            String trim = str.substring(i, i3).trim();
            lo loVar = (lo) this.f1685c.get(trim);
            if (loVar != null) {
                a = loVar.m1340a();
                if (lnVar2.m1339b()) {
                    throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                }
            }
            switch (Character.toLowerCase(trim.charAt(0))) {
                case 'a':
                    if (trim.equalsIgnoreCase("abs")) {
                        a = Math.abs(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("acos")) {
                        a = Math.acos(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("asin")) {
                        a = Math.asin(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("atan")) {
                        a = Math.atan(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    }
                    break;
                case 'c':
                    if (trim.equalsIgnoreCase("cbrt")) {
                        a = Math.cbrt(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("ceil")) {
                        a = Math.ceil(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("cos")) {
                        a = Math.cos(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("cosh")) {
                        a = Math.cosh(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    }
                    break;
                case 'e':
                    if (trim.equalsIgnoreCase("exp")) {
                        a = Math.exp(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("expm1")) {
                        a = Math.expm1(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    }
                    break;
                case 'f':
                    if (trim.equalsIgnoreCase("floor")) {
                        a = Math.floor(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    }
                    break;
                case 'l':
                    if (trim.equalsIgnoreCase("log")) {
                        a = Math.log(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("log10")) {
                        a = Math.log10(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("log1p")) {
                        a = Math.log1p(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    }
                    break;
                case 'm':
                    if (trim.equalsIgnoreCase("max")) {
                        a = Math.max(lnVar2.m1338a(), lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("min")) {
                        a = Math.min(lnVar2.m1338a(), lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    }
                    break;
                case 'r':
                    if (trim.equalsIgnoreCase("round")) {
                        a = (double) Math.round(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("roundHE")) {
                        a = Math.rint(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    }
                    break;
                case 's':
                    if (trim.equalsIgnoreCase("signum")) {
                        a = Math.signum(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("sin")) {
                        a = Math.sin(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("sinh")) {
                        a = Math.sinh(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("sqrt")) {
                        a = Math.sqrt(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    }
                    break;
                case 't':
                    if (trim.equalsIgnoreCase("tan")) {
                        a = Math.tan(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("tanh")) {
                        a = Math.tanh(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("toDegrees")) {
                        a = Math.toDegrees(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    } else if (trim.equalsIgnoreCase("toRadians")) {
                        a = Math.toRadians(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    }
                    break;
                case 'u':
                    if (trim.equalsIgnoreCase("ulp")) {
                        a = Math.ulp(lnVar2.m1338a());
                        if (lnVar2.m1339b()) {
                            throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                        }
                    }
                    break;
            }
            this.f1688f = false;
            if (trim.equalsIgnoreCase("random")) {
                a = Math.random();
                if (lnVar2.m1339b()) {
                    throw m1336b(str, lnVar2.f1691c, "Function has too many arguments");
                }
            }
            throw m1336b(str, i, "Function \"" + str.substring(i, i3) + "\" not recognized");
            return a;
        } catch (Throwable e2) {
            throw m1331a(str, lnVar2.f1692d, "Function evaluation failed", e2);
        } catch (IllegalArgumentException e3) {
            throw m1336b(str, lnVar2.f1691c, e3.getMessage());
        } catch (Throwable e22) {
            if (lnVar2.m1339b()) {
                throw m1331a(str, i, "Unexpected exception parsing function arguments", e22);
            }
            throw m1336b(str, lnVar2.f1691c, "Function has too few arguments");
        } catch (NoSuchMethodError e4) {
            throw m1336b(str, i, "Function not supported in this JVM: \"" + str.substring(i, i3) + "\"");
        } catch (Throwable th) {
            e22 = th;
            if (lnVar == null) {
            }
            throw e22;
        }
    }

    private static int m1335b(char c) {
        return c < '' ? f1682g[c] : 0;
    }

    private static ArithmeticException m1336b(String str, int i, String str2) {
        return new ArithmeticException(new StringBuilder(String.valueOf(str2)).append(" at offset ").append(i).append(" in expression \"").append(str).append("\"").toString());
    }

    public final double m1337a(String str) {
        this.f1688f = true;
        return m1333b(str);
    }
}
