package com.brandall.nutter;

import com.faceture.google.play.QueryParamConst;
import java.util.Locale;

public final class jn {
    public static boolean f1553a = false;
    public static boolean f1554b = false;
    public static boolean f1555c = false;
    public static boolean f1556d = false;

    public static String m1212a() {
        if (hc.f1269b) {
            ls.m1346c("EstablishWebExtension getWebExtension");
        }
        String str = "";
        Locale locale = Locale.getDefault();
        String locale2 = locale.toString();
        if (hc.f1269b) {
            ls.m1346c("sloc: " + locale2);
            for (Locale locale3 : Locale.getAvailableLocales()) {
                if (locale3.toString().startsWith(QueryParamConst.HL_VALUE)) {
                    ls.m1346c("lc: " + locale3.toString());
                }
            }
        }
        if (!locale.equals(Locale.CANADA)) {
            if (locale.equals(Locale.US)) {
                if (!f1553a) {
                    if (f1555c) {
                        str = "";
                    } else if (f1554b) {
                        str = "search.yahoo.com";
                    } else if (f1556d) {
                        str = "http://shop.mobileweb.ebay.com/searchresults?kw=";
                    }
                }
            } else if (locale.equals(Locale.UK)) {
                if (f1553a) {
                    str = "co.uk";
                } else if (f1555c) {
                    str = "&cc=gb";
                } else if (f1554b) {
                    str = "uk.search.yahoo.com";
                } else if (f1556d) {
                    str = "http://shop.mobileweb.ebay.co.uk/searchresults?kw=";
                }
            } else if (locale2.matches("en_NZ")) {
                if (f1553a) {
                    str = "co.nz";
                } else if (f1555c) {
                    str = "&cc=nz";
                } else if (f1554b) {
                    str = "nz.search.yahoo.com";
                } else if (f1556d) {
                    str = "http://shop.mobileweb.ebay.com/searchresults?kw=";
                }
            } else if (locale2.matches("en_AU")) {
                if (f1553a) {
                    str = "com.au";
                } else if (f1555c) {
                    str = "&cc=au";
                } else if (f1554b) {
                    str = "au.search.yahoo.com";
                } else if (f1556d) {
                    str = "http://shop.mobileweb.ebay.com.au/searchresults?kw=";
                }
            } else if (!f1553a) {
                if (f1555c) {
                    str = "";
                } else if (f1554b) {
                    str = "search.yahoo.com";
                } else if (f1556d) {
                    str = "http://shop.mobileweb.ebay.com/searchresults?kw=";
                }
            }
            str = "com";
        } else if (f1553a) {
            str = "ca";
        } else if (f1555c) {
            str = "&cc=ca";
        } else if (f1554b) {
            str = "ca.search.yahoo.com";
        } else if (f1556d) {
            str = "http://shop.mobileweb.ebay.ca/searchresults?kw=";
        }
        f1555c = false;
        f1554b = false;
        f1553a = false;
        f1556d = false;
        return str;
    }
}
