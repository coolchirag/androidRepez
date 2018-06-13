package com.brandall.nutter;

public class ld implements mp {
    private static String m1316a(String str, String str2, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder(str2);
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            int max = Math.max(0, i2 - i);
            int i3 = 0;
            while (i3 == 0 && max < Math.min(i2 + i, str2.length())) {
                if (stringBuilder2.charAt(max) == charAt) {
                    i3 = 1;
                    stringBuilder.append(charAt);
                    stringBuilder2.setCharAt(max, '*');
                }
                max++;
            }
            i2++;
        }
        return stringBuilder.toString();
    }

    public double mo94a(String str, String str2) {
        String toLowerCase;
        String toLowerCase2;
        int i = 0;
        if (str.length() > str2.length()) {
            toLowerCase = str.toLowerCase();
            toLowerCase2 = str2.toLowerCase();
        } else {
            toLowerCase = str2.toLowerCase();
            toLowerCase2 = str.toLowerCase();
        }
        int length = (toLowerCase2.length() / 2) + 1;
        String a = m1316a(toLowerCase2, toLowerCase, length);
        String a2 = m1316a(toLowerCase, toLowerCase2, length);
        if (a.length() == 0 || a2.length() == 0) {
            return 0.0d;
        }
        if (a.length() != a2.length()) {
            return 0.0d;
        }
        int i2 = 0;
        while (i < a.length()) {
            if (a.charAt(i) != a2.charAt(i)) {
                i2++;
            }
            i++;
        }
        i = i2 / 2;
        return (((((double) a2.length()) / ((double) toLowerCase.length())) + (((double) a.length()) / ((double) toLowerCase2.length()))) + (((double) (a.length() - i)) / ((double) a.length()))) / 3.0d;
    }
}
