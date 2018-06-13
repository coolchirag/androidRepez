package org.apache.harmony.awt.internal.nls;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
    private static ResourceBundle bundle;

    class C05761 implements PrivilegedAction<Object> {
        private final /* synthetic */ ClassLoader val$loader;
        private final /* synthetic */ Locale val$locale;
        private final /* synthetic */ String val$resource;

        C05761(String str, Locale locale, ClassLoader classLoader) {
            this.val$resource = str;
            this.val$locale = locale;
            this.val$loader = classLoader;
        }

        public Object run() {
            return ResourceBundle.getBundle(this.val$resource, this.val$locale, this.val$loader != null ? this.val$loader : ClassLoader.getSystemClassLoader());
        }
    }

    static {
        bundle = null;
        try {
            bundle = setLocale(Locale.getDefault(), "org.apache.harmony.awt.internal.nls.messages");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String format(String str, Object[] objArr) {
        int i;
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder(str.length() + (objArr.length * 20));
        String[] strArr = new String[objArr.length];
        for (i = 0; i < objArr.length; i++) {
            if (objArr[i] == null) {
                strArr[i] = "<null>";
            } else {
                strArr[i] = objArr[i].toString();
            }
        }
        i = str.indexOf(123, 0);
        while (i >= 0) {
            if (i != 0 && str.charAt(i - 1) == '\\') {
                if (i != 1) {
                    stringBuilder.append(str.substring(i2, i - 1));
                }
                stringBuilder.append('{');
                i++;
            } else if (i > str.length() - 3) {
                stringBuilder.append(str.substring(i2, str.length()));
                i = str.length();
            } else {
                byte digit = (byte) Character.digit(str.charAt(i + 1), 10);
                if (digit < (byte) 0 || str.charAt(i + 2) != '}') {
                    stringBuilder.append(str.substring(i2, i + 1));
                    i++;
                } else {
                    stringBuilder.append(str.substring(i2, i));
                    if (digit >= strArr.length) {
                        stringBuilder.append("<missing argument>");
                    } else {
                        stringBuilder.append(strArr[digit]);
                    }
                    i += 3;
                }
            }
            int i3 = i;
            i = str.indexOf(123, i);
            i2 = i3;
        }
        if (i2 < str.length()) {
            stringBuilder.append(str.substring(i2, str.length()));
        }
        return stringBuilder.toString();
    }

    public static String getString(String str) {
        if (bundle == null) {
            return str;
        }
        try {
            return bundle.getString(str);
        } catch (MissingResourceException e) {
            return "Missing message: " + str;
        }
    }

    public static String getString(String str, char c) {
        return getString(str, new Object[]{String.valueOf(c)});
    }

    public static String getString(String str, int i) {
        return getString(str, new Object[]{Integer.toString(i)});
    }

    public static String getString(String str, Object obj) {
        return getString(str, new Object[]{obj});
    }

    public static String getString(String str, Object obj, Object obj2) {
        return getString(str, new Object[]{obj, obj2});
    }

    public static String getString(String str, Object[] objArr) {
        if (bundle != null) {
            try {
                str = bundle.getString(str);
            } catch (MissingResourceException e) {
            }
        }
        return format(str, objArr);
    }

    public static ResourceBundle setLocale(Locale locale, String str) {
        try {
            return (ResourceBundle) AccessController.doPrivileged(new C05761(str, locale, null));
        } catch (MissingResourceException e) {
            return null;
        }
    }
}
