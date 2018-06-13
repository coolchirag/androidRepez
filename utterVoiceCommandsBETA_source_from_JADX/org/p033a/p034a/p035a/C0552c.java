package org.p033a.p034a.p035a;

import java.io.Reader;

final class C0552c {
    private static final int[] f3061a = new int[]{0, 0, 1, 1};
    private static final char[] f3062b;
    private static final int[] f3063c;
    private static final int[] f3064d;
    private static final int[] f3065e = new int[]{2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final String[] f3066f = new String[]{"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
    private static final int[] f3067g;
    private Reader f3068h = null;
    private int f3069i;
    private int f3070j = 0;
    private char[] f3071k = new char[16384];
    private int f3072l;
    private int f3073m;
    private int f3074n;
    private int f3075o;
    private int f3076p;
    private int f3077q;
    private int f3078r;
    private boolean f3079s = true;
    private boolean f3080t;
    private StringBuffer f3081u = new StringBuffer();

    static {
        int i = 0;
        String str = "\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016ﾂ\u0000";
        char[] cArr = new char[65536];
        int i2 = 0;
        int i3 = 0;
        while (i3 < 90) {
            int i4 = i3 + 1;
            i3 = str.charAt(i3);
            int i5 = i4 + 1;
            char charAt = str.charAt(i4);
            while (true) {
                i4 = i2 + 1;
                cArr[i2] = charAt;
                i3--;
                if (i3 <= 0) {
                    break;
                }
                i2 = i4;
            }
            i2 = i4;
            i3 = i5;
        }
        f3062b = cArr;
        int[] iArr = new int[45];
        String str2 = "\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018";
        int length = str2.length();
        i2 = 0;
        i3 = 0;
        while (i3 < length) {
            i4 = i3 + 1;
            i3 = str2.charAt(i3);
            i5 = i4 + 1;
            char charAt2 = str2.charAt(i4);
            while (true) {
                i4 = i2 + 1;
                iArr[i2] = charAt2;
                i3--;
                if (i3 <= 0) {
                    break;
                }
                i2 = i4;
            }
            i2 = i4;
            i3 = i5;
        }
        f3063c = iArr;
        int[] iArr2 = new int[45];
        str = "\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u00006\u0000¢\u0000½\u0000Ø\u00006\u00006\u00006\u00006\u00006\u00006\u0000ó\u0000Ď\u00006\u0000ĩ\u0000ń\u0000ş\u0000ź\u0000ƕ\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000ư\u0000ǋ\u0000Ǧ\u0000Ǧ\u0000ȁ\u0000Ȝ\u0000ȷ\u0000ɒ\u00006\u00006\u0000ɭ\u0000ʈ\u00006";
        int length2 = str.length();
        i3 = 0;
        i2 = 0;
        while (i2 < length2) {
            length = i2 + 1;
            int charAt3 = str.charAt(i2) << 16;
            i2 = i3 + 1;
            i4 = length + 1;
            iArr2[i3] = str.charAt(length) | charAt3;
            i3 = i2;
            i2 = i4;
        }
        f3064d = iArr2;
        iArr2 = new int[45];
        str = "\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t";
        length2 = str.length();
        i2 = 0;
        while (i < length2) {
            i4 = i + 1;
            i3 = str.charAt(i);
            i = i4 + 1;
            charAt = str.charAt(i4);
            while (true) {
                i4 = i2 + 1;
                iArr2[i2] = charAt;
                i3--;
                if (i3 <= 0) {
                    break;
                }
                i2 = i4;
            }
            i2 = i4;
        }
        f3067g = iArr2;
    }

    C0552c() {
    }

    private String m2808c() {
        return new String(this.f3071k, this.f3074n, this.f3072l - this.f3074n);
    }

    final int m2809a() {
        return this.f3077q;
    }

    public final void m2810a(Reader reader) {
        this.f3068h = reader;
        this.f3079s = true;
        this.f3080t = false;
        this.f3074n = 0;
        this.f3075o = 0;
        this.f3072l = 0;
        this.f3073m = 0;
        this.f3078r = 0;
        this.f3077q = 0;
        this.f3076p = 0;
        this.f3070j = 0;
    }

    public final C0553d m2811b() {
        int i = this.f3075o;
        char[] cArr = this.f3071k;
        char[] cArr2 = f3062b;
        int[] iArr = f3065e;
        int[] iArr2 = f3064d;
        int[] iArr3 = f3067g;
        while (true) {
            int i2 = this.f3072l;
            this.f3077q += i2 - this.f3074n;
            int i3 = -1;
            this.f3074n = i2;
            this.f3073m = i2;
            this.f3069i = f3061a[this.f3070j];
            int i4 = i2;
            while (true) {
                char c;
                int i5;
                String str;
                if (i4 >= i) {
                    if (this.f3080t) {
                        c = '￿';
                    } else {
                        Object obj;
                        char[] cArr3;
                        this.f3073m = i4;
                        this.f3072l = i2;
                        if (this.f3074n > 0) {
                            System.arraycopy(this.f3071k, this.f3074n, this.f3071k, 0, this.f3075o - this.f3074n);
                            this.f3075o -= this.f3074n;
                            this.f3073m -= this.f3074n;
                            this.f3072l -= this.f3074n;
                            this.f3074n = 0;
                        }
                        if (this.f3073m >= this.f3071k.length) {
                            obj = new char[(this.f3073m * 2)];
                            System.arraycopy(this.f3071k, 0, obj, 0, this.f3071k.length);
                            this.f3071k = obj;
                        }
                        int read = this.f3068h.read(this.f3071k, this.f3075o, this.f3071k.length - this.f3075o);
                        if (read > 0) {
                            this.f3075o = read + this.f3075o;
                            obj = null;
                        } else {
                            if (read == 0) {
                                read = this.f3068h.read();
                                if (read != -1) {
                                    cArr3 = this.f3071k;
                                    i2 = this.f3075o;
                                    this.f3075o = i2 + 1;
                                    cArr3[i2] = (char) read;
                                    obj = null;
                                }
                            }
                            obj = 1;
                        }
                        i5 = this.f3073m;
                        i4 = this.f3072l;
                        cArr3 = this.f3071k;
                        i2 = this.f3075o;
                        if (obj != null) {
                            char[] cArr4 = cArr3;
                            i = i2;
                            i2 = i4;
                            c = '￿';
                            cArr = cArr4;
                        } else {
                            cArr = cArr3;
                            i = i2;
                            i2 = i4;
                            i4 = i5;
                        }
                    }
                    this.f3072l = i2;
                    if (i3 >= 0) {
                        i3 = f3063c[i3];
                    }
                    switch (i3) {
                        case 1:
                            throw new C0551b(this.f3077q, 0, new Character(this.f3071k[this.f3074n + 0]));
                        case 2:
                            return new C0553d(0, Long.valueOf(m2808c()));
                        case 3:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                            break;
                        case 4:
                            this.f3081u.delete(0, this.f3081u.length());
                            this.f3070j = 2;
                            break;
                        case 5:
                            return new C0553d(1, null);
                        case 6:
                            return new C0553d(2, null);
                        case 7:
                            return new C0553d(3, null);
                        case 8:
                            return new C0553d(4, null);
                        case 9:
                            return new C0553d(5, null);
                        case 10:
                            return new C0553d(6, null);
                        case 11:
                            this.f3081u.append(m2808c());
                            break;
                        case 12:
                            this.f3081u.append('\\');
                            break;
                        case 13:
                            this.f3070j = 0;
                            return new C0553d(0, this.f3081u.toString());
                        case 14:
                            this.f3081u.append('\"');
                            break;
                        case 15:
                            this.f3081u.append('/');
                            break;
                        case 16:
                            this.f3081u.append('\b');
                            break;
                        case 17:
                            this.f3081u.append('\f');
                            break;
                        case 18:
                            this.f3081u.append('\n');
                            break;
                        case 19:
                            this.f3081u.append('\r');
                            break;
                        case 20:
                            this.f3081u.append('\t');
                            break;
                        case 21:
                            return new C0553d(0, Double.valueOf(m2808c()));
                        case 22:
                            return new C0553d(0, null);
                        case 23:
                            return new C0553d(0, Boolean.valueOf(m2808c()));
                        case 24:
                            try {
                                this.f3081u.append((char) Integer.parseInt(m2808c().substring(2), 16));
                                break;
                            } catch (Exception e) {
                                throw new C0551b(this.f3077q, 2, e);
                            }
                        default:
                            if (c == '￿' || this.f3074n != this.f3073m) {
                                try {
                                    str = f3066f[1];
                                } catch (ArrayIndexOutOfBoundsException e2) {
                                    str = f3066f[0];
                                }
                                throw new Error(str);
                            }
                            this.f3080t = true;
                            return null;
                    }
                }
                i5 = i4 + 1;
                c = cArr[i4];
                int i6 = iArr[iArr2[this.f3069i] + cArr2[c]];
                if (i6 != -1) {
                    this.f3069i = i6;
                    i6 = iArr3[this.f3069i];
                    if ((i6 & 1) == 1) {
                        i2 = this.f3069i;
                        if ((i6 & 8) != 8) {
                            i4 = i2;
                            i2 = i5;
                        } else {
                            i3 = i2;
                            i2 = i5;
                        }
                    } else {
                        i4 = i3;
                    }
                    i3 = i4;
                    i4 = i5;
                }
                this.f3072l = i2;
                if (i3 >= 0) {
                    i3 = f3063c[i3];
                }
                switch (i3) {
                    case 1:
                        throw new C0551b(this.f3077q, 0, new Character(this.f3071k[this.f3074n + 0]));
                    case 2:
                        return new C0553d(0, Long.valueOf(m2808c()));
                    case 3:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                        break;
                    case 4:
                        this.f3081u.delete(0, this.f3081u.length());
                        this.f3070j = 2;
                        break;
                    case 5:
                        return new C0553d(1, null);
                    case 6:
                        return new C0553d(2, null);
                    case 7:
                        return new C0553d(3, null);
                    case 8:
                        return new C0553d(4, null);
                    case 9:
                        return new C0553d(5, null);
                    case 10:
                        return new C0553d(6, null);
                    case 11:
                        this.f3081u.append(m2808c());
                        break;
                    case 12:
                        this.f3081u.append('\\');
                        break;
                    case 13:
                        this.f3070j = 0;
                        return new C0553d(0, this.f3081u.toString());
                    case 14:
                        this.f3081u.append('\"');
                        break;
                    case 15:
                        this.f3081u.append('/');
                        break;
                    case 16:
                        this.f3081u.append('\b');
                        break;
                    case 17:
                        this.f3081u.append('\f');
                        break;
                    case 18:
                        this.f3081u.append('\n');
                        break;
                    case 19:
                        this.f3081u.append('\r');
                        break;
                    case 20:
                        this.f3081u.append('\t');
                        break;
                    case 21:
                        return new C0553d(0, Double.valueOf(m2808c()));
                    case 22:
                        return new C0553d(0, null);
                    case 23:
                        return new C0553d(0, Boolean.valueOf(m2808c()));
                    case 24:
                        this.f3081u.append((char) Integer.parseInt(m2808c().substring(2), 16));
                        break;
                    default:
                        if (c == '￿') {
                            break;
                        }
                        str = f3066f[1];
                        throw new Error(str);
                }
            }
        }
    }
}
