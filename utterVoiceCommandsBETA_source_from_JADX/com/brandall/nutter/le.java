package com.brandall.nutter;

public final class le extends ld implements mp {
    final double f1667a = 0.1d;
    private double f1668b = 0.1d;

    public final double mo94a(String str, String str2) {
        String toLowerCase;
        int i = 0;
        double a = super.mo94a(str, str2);
        String toLowerCase2;
        if (str.length() > str2.length()) {
            toLowerCase2 = str.toLowerCase();
            toLowerCase = str2.toLowerCase();
        } else {
            toLowerCase2 = str2.toLowerCase();
            toLowerCase = str.toLowerCase();
        }
        int i2 = 0;
        while (i < toLowerCase.length() && toLowerCase.charAt(i) == r0.charAt(i)) {
            i2++;
            i++;
        }
        if (i2 > 4) {
            i2 = 4;
        }
        return ((this.f1668b * ((double) i2)) * (1.0d - a)) + a;
    }
}
