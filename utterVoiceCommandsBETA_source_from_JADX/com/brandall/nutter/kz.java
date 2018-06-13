package com.brandall.nutter;

import android.content.Context;
import android.os.AsyncTask;

public final class kz extends AsyncTask<Void, Void, String> {
    public static boolean f1633b = false;
    public static boolean f1634c = false;
    public static boolean f1635d = false;
    public static boolean f1636e = false;
    public static boolean f1637f = false;
    public static boolean f1638g = false;
    public static boolean f1639h = false;
    public static boolean f1640i = false;
    public static boolean f1641j = false;
    public static boolean f1642k = false;
    public static int f1643l = 999;
    public static int f1644m = 0;
    public static String f1645n = "";
    public static String f1646o = "";
    public static String f1647p = "";
    public static String f1648q = "";
    Context f1649a;

    public kz(Context context) {
        this.f1649a = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m1309a() {
        /*
        r19 = this;
        r2 = com.brandall.nutter.hc.f1269b;
        if (r2 == 0) goto L_0x0009;
    L_0x0004:
        r2 = "DIB GSI";
        com.brandall.nutter.ls.m1346c(r2);
    L_0x0009:
        r2 = com.brandall.nutter.hc.f1270c;
        if (r2 == 0) goto L_0x08eb;
    L_0x000d:
        r8 = java.lang.System.currentTimeMillis();
        r2 = f1633b;
        if (r2 == 0) goto L_0x03a4;
    L_0x0015:
        r2 = f1644m;
        r3 = 2;
        if (r2 <= r3) goto L_0x001d;
    L_0x001a:
        r2 = 2;
        f1644m = r2;
    L_0x001d:
        r0 = r19;
        r2 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r3 = "connectivity";
        r2 = r2.getSystemService(r3);	 Catch:{ Exception -> 0x026d }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Exception -> 0x026d }
        r2 = r2.getActiveNetworkInfo();	 Catch:{ Exception -> 0x026d }
        if (r2 == 0) goto L_0x0242;
    L_0x002f:
        r3 = r2.getType();	 Catch:{ Exception -> 0x026d }
        r4 = 1;
        if (r3 != r4) goto L_0x0236;
    L_0x0036:
        r7 = 255; // 0xff float:3.57E-43 double:1.26E-321;
    L_0x0038:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ Exception -> 0x026d }
        if (r2 == 0) goto L_0x0076;
    L_0x003c:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r3 = "GSI-DBUS: commandInt: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x026d }
        r3 = f1643l;	 Catch:{ Exception -> 0x026d }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x026d }
        r2 = r2.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1345b(r2);	 Catch:{ Exception -> 0x026d }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r3 = "GSI-DBUS: connectionType: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x026d }
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x026d }
        r2 = r2.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1345b(r2);	 Catch:{ Exception -> 0x026d }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r3 = "GSI-DBUS: outcome: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x026d }
        r3 = f1644m;	 Catch:{ Exception -> 0x026d }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x026d }
        r2 = r2.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1345b(r2);	 Catch:{ Exception -> 0x026d }
    L_0x0076:
        r2 = new com.brandall.nutter.hi;	 Catch:{ Exception -> 0x026d }
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r2.<init>(r3);	 Catch:{ Exception -> 0x026d }
        r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x026d }
        r3.<init>();	 Catch:{ Exception -> 0x026d }
        r3 = f1643l;	 Catch:{ Exception -> 0x026d }
        r4 = r2.m1102a(r3, r7);	 Catch:{ Exception -> 0x026d }
        r3 = r4.isEmpty();	 Catch:{ Exception -> 0x026d }
        if (r3 != 0) goto L_0x02cf;
    L_0x0090:
        r3 = com.brandall.nutter.hc.f1269b;	 Catch:{ Exception -> 0x026d }
        if (r3 == 0) goto L_0x0099;
    L_0x0094:
        r3 = "GSI-DBUS: dbData: row exists";
        com.brandall.nutter.ls.m1346c(r3);	 Catch:{ Exception -> 0x026d }
    L_0x0099:
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r0 = r19;
        r5 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r5 = com.brandall.nutter.lx.m1440m(r5);	 Catch:{ Exception -> 0x026d }
        r10 = 1;
        r5 = r5 + r10;
        com.brandall.nutter.lx.m1391a(r3, r5);	 Catch:{ Exception -> 0x026d }
        r3 = 0;
        r3 = r4.get(r3);	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x026d }
        r5 = r3.intValue();	 Catch:{ Exception -> 0x026d }
        r3 = f1644m;	 Catch:{ Exception -> 0x026d }
        switch(r3) {
            case 0: goto L_0x0245;
            case 1: goto L_0x027f;
            case 2: goto L_0x02a7;
            default: goto L_0x00bb;
        };	 Catch:{ Exception -> 0x026d }
    L_0x00bb:
        r3 = com.brandall.nutter.hc.f1269b;	 Catch:{ Exception -> 0x026d }
        if (r3 == 0) goto L_0x00d9;
    L_0x00bf:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r4 = "DBUS dcount: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x026d }
        r0 = r19;
        r4 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r4 = com.brandall.nutter.lx.m1440m(r4);	 Catch:{ Exception -> 0x026d }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x026d }
        r3 = r3.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1344a(r3);	 Catch:{ Exception -> 0x026d }
    L_0x00d9:
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r0 = r19;
        r4 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r4 = com.brandall.nutter.lx.m1440m(r4);	 Catch:{ Exception -> 0x026d }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x026d }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x026d }
        r7 = "utterPref";
        r10 = 0;
        r7 = r3.getSharedPreferences(r7, r10);	 Catch:{ Exception -> 0x026d }
        r10 = "last_server_update";
        r11 = 0;
        r10 = r7.getLong(r10, r11);	 Catch:{ Exception -> 0x026d }
        r12 = r5 - r10;
        r0 = r19;
        r7 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r14 = com.brandall.nutter.lx.aq(r7);	 Catch:{ Exception -> 0x026d }
        r0 = r19;
        r7 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r16 = com.brandall.nutter.lx.ap(r7);	 Catch:{ Exception -> 0x026d }
        r7 = com.brandall.nutter.hc.f1269b;	 Catch:{ Exception -> 0x026d }
        if (r7 == 0) goto L_0x0172;
    L_0x0112:
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r18 = "currentTime: ";
        r0 = r18;
        r7.<init>(r0);	 Catch:{ Exception -> 0x026d }
        r7 = r7.append(r5);	 Catch:{ Exception -> 0x026d }
        r7 = r7.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1346c(r7);	 Catch:{ Exception -> 0x026d }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r18 = "lastServerUpdate: ";
        r0 = r18;
        r7.<init>(r0);	 Catch:{ Exception -> 0x026d }
        r7 = r7.append(r10);	 Catch:{ Exception -> 0x026d }
        r7 = r7.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1346c(r7);	 Catch:{ Exception -> 0x026d }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r10 = "timeDifference: ";
        r7.<init>(r10);	 Catch:{ Exception -> 0x026d }
        r7 = r7.append(r12);	 Catch:{ Exception -> 0x026d }
        r7 = r7.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1346c(r7);	 Catch:{ Exception -> 0x026d }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r10 = "Interval: ";
        r7.<init>(r10);	 Catch:{ Exception -> 0x026d }
        r7 = r7.append(r14);	 Catch:{ Exception -> 0x026d }
        r7 = r7.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1346c(r7);	 Catch:{ Exception -> 0x026d }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r10 = "Threashold: ";
        r7.<init>(r10);	 Catch:{ Exception -> 0x026d }
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ Exception -> 0x026d }
        r7 = r7.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1346c(r7);	 Catch:{ Exception -> 0x026d }
    L_0x0172:
        r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r7 > 0) goto L_0x017e;
    L_0x0176:
        r10 = r4.longValue();	 Catch:{ Exception -> 0x026d }
        r4 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1));
        if (r4 <= 0) goto L_0x030f;
    L_0x017e:
        r4 = com.brandall.nutter.hc.f1269b;	 Catch:{ Exception -> 0x026d }
        if (r4 == 0) goto L_0x0187;
    L_0x0182:
        r4 = "Threasholds past";
        com.brandall.nutter.ls.m1346c(r4);	 Catch:{ Exception -> 0x026d }
    L_0x0187:
        r4 = "utterPref";
        r7 = 0;
        r3 = r3.getSharedPreferences(r4, r7);	 Catch:{ Exception -> 0x026d }
        r3 = r3.edit();	 Catch:{ Exception -> 0x026d }
        r4 = "last_server_update";
        r3.putLong(r4, r5);	 Catch:{ Exception -> 0x026d }
        r3.commit();	 Catch:{ Exception -> 0x026d }
        r3 = 1;
    L_0x019b:
        if (r3 == 0) goto L_0x0218;
    L_0x019d:
        r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x026d }
        r3.<init>();	 Catch:{ Exception -> 0x026d }
        r4 = r2.m1106b();	 Catch:{ Exception -> 0x026d }
        r3 = com.brandall.nutter.hc.f1269b;	 Catch:{ Exception -> 0x026d }
        if (r3 == 0) goto L_0x01ce;
    L_0x01aa:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r5 = "dbAllData: ";
        r3.<init>(r5);	 Catch:{ Exception -> 0x026d }
        r5 = r4.size();	 Catch:{ Exception -> 0x026d }
        r3 = r3.append(r5);	 Catch:{ Exception -> 0x026d }
        r5 = " : ";
        r3 = r3.append(r5);	 Catch:{ Exception -> 0x026d }
        r5 = r4.toString();	 Catch:{ Exception -> 0x026d }
        r3 = r3.append(r5);	 Catch:{ Exception -> 0x026d }
        r3 = r3.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1344a(r3);	 Catch:{ Exception -> 0x026d }
    L_0x01ce:
        r3 = "";
        r5 = r4.iterator();	 Catch:{ Exception -> 0x026d }
        r4 = r3;
    L_0x01d5:
        r3 = r5.hasNext();	 Catch:{ Exception -> 0x026d }
        if (r3 != 0) goto L_0x031b;
    L_0x01db:
        r3 = com.brandall.nutter.hc.f1269b;	 Catch:{ Exception -> 0x026d }
        if (r3 == 0) goto L_0x01f1;
    L_0x01df:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r5 = "glue: ";
        r3.<init>(r5);	 Catch:{ Exception -> 0x026d }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x026d }
        r3 = r3.toString();	 Catch:{ Exception -> 0x026d }
        com.brandall.nutter.ls.m1344a(r3);	 Catch:{ Exception -> 0x026d }
    L_0x01f1:
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
        r0 = r19;
        r5 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
        r4 = com.brandall.nutter.ki.m1297a(r5, r4);	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
        r3 = com.brandall.nutter.ki.m1301c(r3, r4);	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
        if (r3 == 0) goto L_0x0335;
    L_0x0203:
        r3 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
        if (r3 == 0) goto L_0x020c;
    L_0x0207:
        r3 = "serverResponse: true";
        com.brandall.nutter.ls.m1344a(r3);	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
    L_0x020c:
        r2.m1103a();	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
        r0 = r19;
        r2 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
        r3 = 0;
        com.brandall.nutter.lx.m1391a(r2, r3);	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
    L_0x0218:
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r8;
        r4 = com.brandall.nutter.hc.f1269b;
        if (r4 == 0) goto L_0x0233;
    L_0x0221:
        r4 = new java.lang.StringBuilder;
        r5 = "GSI elapsed: ";
        r4.<init>(r5);
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.brandall.nutter.ls.m1346c(r2);
    L_0x0233:
        r2 = f1645n;
        return r2;
    L_0x0236:
        r3 = r2.getType();	 Catch:{ Exception -> 0x026d }
        if (r3 != 0) goto L_0x0242;
    L_0x023c:
        r7 = r2.getSubtype();	 Catch:{ Exception -> 0x026d }
        goto L_0x0038;
    L_0x0242:
        r7 = 0;
        goto L_0x0038;
    L_0x0245:
        r3 = 1;
        r3 = r4.get(r3);	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x026d }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x026d }
        r6 = r3 + 1;
        r3 = 2;
        r3 = r4.get(r3);	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x026d }
        r7 = r3.intValue();	 Catch:{ Exception -> 0x026d }
        r3 = 3;
        r3 = r4.get(r3);	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x026d }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x026d }
        r2.m1104a(r5, r6, r7, r3);	 Catch:{ Exception -> 0x026d }
        goto L_0x00bb;
    L_0x026d:
        r2 = move-exception;
        r2.printStackTrace();
        r2 = com.brandall.nutter.hc.f1269b;
        if (r2 == 0) goto L_0x027a;
    L_0x0275:
        r2 = "SH-DBUS insert error";
        com.brandall.nutter.ls.m1348e(r2);
    L_0x027a:
        r2 = "error";
        f1645n = r2;
        goto L_0x0218;
    L_0x027f:
        r3 = 1;
        r3 = r4.get(r3);	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x026d }
        r6 = r3.intValue();	 Catch:{ Exception -> 0x026d }
        r3 = 2;
        r3 = r4.get(r3);	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x026d }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x026d }
        r7 = r3 + 1;
        r3 = 3;
        r3 = r4.get(r3);	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x026d }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x026d }
        r2.m1104a(r5, r6, r7, r3);	 Catch:{ Exception -> 0x026d }
        goto L_0x00bb;
    L_0x02a7:
        r3 = 1;
        r3 = r4.get(r3);	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x026d }
        r6 = r3.intValue();	 Catch:{ Exception -> 0x026d }
        r3 = 2;
        r3 = r4.get(r3);	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x026d }
        r7 = r3.intValue();	 Catch:{ Exception -> 0x026d }
        r3 = 3;
        r3 = r4.get(r3);	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x026d }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x026d }
        r3 = r3 + 1;
        r2.m1104a(r5, r6, r7, r3);	 Catch:{ Exception -> 0x026d }
        goto L_0x00bb;
    L_0x02cf:
        r3 = com.brandall.nutter.hc.f1269b;	 Catch:{ Exception -> 0x026d }
        if (r3 == 0) goto L_0x02d8;
    L_0x02d3:
        r3 = "GSI-DBUS: dbData: row not found";
        com.brandall.nutter.ls.m1345b(r3);	 Catch:{ Exception -> 0x026d }
    L_0x02d8:
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r0 = r19;
        r4 = r0.f1649a;	 Catch:{ Exception -> 0x026d }
        r4 = com.brandall.nutter.lx.m1440m(r4);	 Catch:{ Exception -> 0x026d }
        r10 = 1;
        r4 = r4 + r10;
        com.brandall.nutter.lx.m1391a(r3, r4);	 Catch:{ Exception -> 0x026d }
        r3 = f1644m;	 Catch:{ Exception -> 0x026d }
        switch(r3) {
            case 0: goto L_0x02f1;
            case 1: goto L_0x02fb;
            case 2: goto L_0x0305;
            default: goto L_0x02ef;
        };	 Catch:{ Exception -> 0x026d }
    L_0x02ef:
        goto L_0x00bb;
    L_0x02f1:
        r3 = f1643l;	 Catch:{ Exception -> 0x026d }
        r4 = 1;
        r5 = 0;
        r6 = 0;
        r2.m1105a(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x026d }
        goto L_0x00bb;
    L_0x02fb:
        r3 = f1643l;	 Catch:{ Exception -> 0x026d }
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r2.m1105a(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x026d }
        goto L_0x00bb;
    L_0x0305:
        r3 = f1643l;	 Catch:{ Exception -> 0x026d }
        r4 = 0;
        r5 = 0;
        r6 = 1;
        r2.m1105a(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x026d }
        goto L_0x00bb;
    L_0x030f:
        r3 = com.brandall.nutter.hc.f1269b;	 Catch:{ Exception -> 0x026d }
        if (r3 == 0) goto L_0x0318;
    L_0x0313:
        r3 = "Within threasholds";
        com.brandall.nutter.ls.m1346c(r3);	 Catch:{ Exception -> 0x026d }
    L_0x0318:
        r3 = 0;
        goto L_0x019b;
    L_0x031b:
        r3 = r5.next();	 Catch:{ Exception -> 0x026d }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x026d }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026d }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x026d }
        r6.<init>(r4);	 Catch:{ Exception -> 0x026d }
        r3 = r6.append(r3);	 Catch:{ Exception -> 0x026d }
        r3 = r3.toString();	 Catch:{ Exception -> 0x026d }
        r4 = r3;
        goto L_0x01d5;
    L_0x0335:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
        if (r2 == 0) goto L_0x0218;
    L_0x0339:
        r2 = "serverResponse: false";
        com.brandall.nutter.ls.m1347d(r2);	 Catch:{ InvalidKeyException -> 0x0340, NoSuchAlgorithmException -> 0x034a, NoSuchPaddingException -> 0x0354, IllegalBlockSizeException -> 0x035e, BadPaddingException -> 0x0368, InvalidAlgorithmParameterException -> 0x0372, UnsupportedEncodingException -> 0x037c, ClientProtocolException -> 0x0386, ParseException -> 0x0390, IOException -> 0x039a }
        goto L_0x0218;
    L_0x0340:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;	 Catch:{ Exception -> 0x026d }
        r2.printStackTrace();	 Catch:{ Exception -> 0x026d }
        goto L_0x0218;
    L_0x034a:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;	 Catch:{ Exception -> 0x026d }
        r2.printStackTrace();	 Catch:{ Exception -> 0x026d }
        goto L_0x0218;
    L_0x0354:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;	 Catch:{ Exception -> 0x026d }
        r2.printStackTrace();	 Catch:{ Exception -> 0x026d }
        goto L_0x0218;
    L_0x035e:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;	 Catch:{ Exception -> 0x026d }
        r2.printStackTrace();	 Catch:{ Exception -> 0x026d }
        goto L_0x0218;
    L_0x0368:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;	 Catch:{ Exception -> 0x026d }
        r2.printStackTrace();	 Catch:{ Exception -> 0x026d }
        goto L_0x0218;
    L_0x0372:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;	 Catch:{ Exception -> 0x026d }
        r2.printStackTrace();	 Catch:{ Exception -> 0x026d }
        goto L_0x0218;
    L_0x037c:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;	 Catch:{ Exception -> 0x026d }
        r2.printStackTrace();	 Catch:{ Exception -> 0x026d }
        goto L_0x0218;
    L_0x0386:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;	 Catch:{ Exception -> 0x026d }
        r2.printStackTrace();	 Catch:{ Exception -> 0x026d }
        goto L_0x0218;
    L_0x0390:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;	 Catch:{ Exception -> 0x026d }
        r2.printStackTrace();	 Catch:{ Exception -> 0x026d }
        goto L_0x0218;
    L_0x039a:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;	 Catch:{ Exception -> 0x026d }
        r2.printStackTrace();	 Catch:{ Exception -> 0x026d }
        goto L_0x0218;
    L_0x03a4:
        r2 = f1634c;
        if (r2 == 0) goto L_0x04fd;
    L_0x03a8:
        r2 = "";
        f1645n = r2;
        r0 = r19;
        r2 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r4 = new org.apache.http.impl.client.DefaultHttpClient;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r4.<init>();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r5 = new org.apache.http.client.methods.HttpPost;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r6 = "error";
        r5.<init>(r6);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r6 = "";
        r7 = com.brandall.nutter.ki.m1295a();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r10 = com.brandall.nutter.ki.m1295a();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r11 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        if (r11 == 0) goto L_0x03ea;
    L_0x03ce:
        r11 = new java.lang.StringBuilder;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r12 = "int 1: ";
        r11.<init>(r12);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r11 = r11.append(r7);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r12 = " - int2: ";
        r11 = r11.append(r12);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r11 = r11.append(r10);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r11 = r11.toString();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        com.brandall.nutter.ls.m1346c(r11);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
    L_0x03ea:
        r11 = new java.lang.StringBuilder;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r7 = (char) r7;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r7 = java.lang.Character.toString(r7);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r11.<init>(r7);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r7 = (char) r10;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r7 = java.lang.Character.toString(r7);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r7 = r11.append(r7);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r10 = "TEST=";
        r7 = r7.append(r10);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r3 = com.brandall.nutter.lx.m1450s(r3);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r3 = r7.append(r3);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r7 = "|";
        r3 = r3.append(r7);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r3 = r3.append(r6);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r3 = r3.toString();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r6 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        if (r6 == 0) goto L_0x0433;
    L_0x0421:
        r6 = new java.lang.StringBuilder;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r7 = "myPostData constuct: ";
        r6.<init>(r7);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r6 = r6.append(r3);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r6 = r6.toString();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        com.brandall.nutter.ls.m1346c(r6);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
    L_0x0433:
        r6 = com.brandall.nutter.GlobalV.az();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r3 = com.brandall.nutter.kc.m1283a(r3, r6);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r6 = r4.getParams();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r7 = "utter";
        org.apache.http.params.HttpProtocolParams.setUserAgent(r6, r7);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r6 = new java.util.ArrayList;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r6.<init>();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r7 = new org.apache.http.message.BasicNameValuePair;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r10 = "p";
        r7.<init>(r10, r3);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r6.add(r7);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r3 = new org.apache.http.client.entity.UrlEncodedFormEntity;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r3.<init>(r6);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r5.setEntity(r3);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r3 = r4.execute(r5);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r3 = r3.getEntity();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r3 = org.apache.http.util.EntityUtils.toString(r3);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r4 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        if (r4 == 0) goto L_0x047d;
    L_0x046b:
        r4 = new java.lang.StringBuilder;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r5 = "myPostData httpContent: ";
        r4.<init>(r5);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r4 = r4.append(r3);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        r4 = r4.toString();	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        com.brandall.nutter.ls.m1346c(r4);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
    L_0x047d:
        r2 = com.brandall.nutter.ki.m1301c(r2, r3);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        if (r2 == 0) goto L_0x0498;
    L_0x0483:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        if (r2 == 0) goto L_0x0218;
    L_0x0487:
        r2 = "serverResponse: true";
        com.brandall.nutter.ls.m1344a(r2);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        goto L_0x0218;
    L_0x048e:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0498:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        if (r2 == 0) goto L_0x0218;
    L_0x049c:
        r2 = "serverResponse: false";
        com.brandall.nutter.ls.m1347d(r2);	 Catch:{ InvalidKeyException -> 0x048e, NoSuchAlgorithmException -> 0x04a3, NoSuchPaddingException -> 0x04ad, IllegalBlockSizeException -> 0x04b7, BadPaddingException -> 0x04c1, InvalidAlgorithmParameterException -> 0x04cb, UnsupportedEncodingException -> 0x04d5, ClientProtocolException -> 0x04df, ParseException -> 0x04e9, IOException -> 0x04f3 }
        goto L_0x0218;
    L_0x04a3:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x04ad:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x04b7:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x04c1:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x04cb:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x04d5:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x04df:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x04e9:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x04f3:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x04fd:
        r2 = f1635d;
        if (r2 == 0) goto L_0x05b8;
    L_0x0501:
        r2 = "";
        f1645n = r2;
        r2 = android.os.Looper.myLooper();	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        if (r2 != 0) goto L_0x0517;
    L_0x050b:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        if (r2 == 0) goto L_0x0514;
    L_0x050f:
        r2 = "Preparing looper";
        com.brandall.nutter.ls.m1346c(r2);	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
    L_0x0514:
        android.os.Looper.prepare();	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
    L_0x0517:
        r0 = r19;
        r2 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        r3 = com.brandall.nutter.ki.m1298b(r3);	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        r2 = com.brandall.nutter.ki.m1301c(r2, r3);	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        if (r2 == 0) goto L_0x0554;
    L_0x0529:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        if (r2 == 0) goto L_0x0532;
    L_0x052d:
        r2 = "serverResponse: true";
        com.brandall.nutter.ls.m1344a(r2);	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
    L_0x0532:
        r2 = android.os.Looper.myLooper();	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        if (r2 == 0) goto L_0x0218;
    L_0x0538:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        if (r2 == 0) goto L_0x0541;
    L_0x053c:
        r2 = "Quitting myLooper";
        com.brandall.nutter.ls.m1346c(r2);	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
    L_0x0541:
        r2 = android.os.Looper.myLooper();	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        r2.quit();	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        goto L_0x0218;
    L_0x054a:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0554:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        if (r2 == 0) goto L_0x0532;
    L_0x0558:
        r2 = "serverResponse: false";
        com.brandall.nutter.ls.m1347d(r2);	 Catch:{ InvalidKeyException -> 0x054a, NoSuchAlgorithmException -> 0x055e, NoSuchPaddingException -> 0x0568, IllegalBlockSizeException -> 0x0572, BadPaddingException -> 0x057c, InvalidAlgorithmParameterException -> 0x0586, UnsupportedEncodingException -> 0x0590, ClientProtocolException -> 0x059a, ParseException -> 0x05a4, IOException -> 0x05ae }
        goto L_0x0532;
    L_0x055e:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0568:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0572:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x057c:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0586:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0590:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x059a:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x05a4:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x05ae:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x05b8:
        r2 = f1638g;
        if (r2 == 0) goto L_0x064c;
    L_0x05bc:
        r2 = "";
        f1645n = r2;
        r0 = r19;
        r2 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x05dd, NoSuchAlgorithmException -> 0x05f2, NoSuchPaddingException -> 0x05fc, IllegalBlockSizeException -> 0x0606, BadPaddingException -> 0x0610, InvalidAlgorithmParameterException -> 0x061a, UnsupportedEncodingException -> 0x0624, ClientProtocolException -> 0x062e, ParseException -> 0x0638, IOException -> 0x0642 }
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x05dd, NoSuchAlgorithmException -> 0x05f2, NoSuchPaddingException -> 0x05fc, IllegalBlockSizeException -> 0x0606, BadPaddingException -> 0x0610, InvalidAlgorithmParameterException -> 0x061a, UnsupportedEncodingException -> 0x0624, ClientProtocolException -> 0x062e, ParseException -> 0x0638, IOException -> 0x0642 }
        r3 = com.brandall.nutter.ki.m1300c(r3);	 Catch:{ InvalidKeyException -> 0x05dd, NoSuchAlgorithmException -> 0x05f2, NoSuchPaddingException -> 0x05fc, IllegalBlockSizeException -> 0x0606, BadPaddingException -> 0x0610, InvalidAlgorithmParameterException -> 0x061a, UnsupportedEncodingException -> 0x0624, ClientProtocolException -> 0x062e, ParseException -> 0x0638, IOException -> 0x0642 }
        r2 = com.brandall.nutter.ki.m1301c(r2, r3);	 Catch:{ InvalidKeyException -> 0x05dd, NoSuchAlgorithmException -> 0x05f2, NoSuchPaddingException -> 0x05fc, IllegalBlockSizeException -> 0x0606, BadPaddingException -> 0x0610, InvalidAlgorithmParameterException -> 0x061a, UnsupportedEncodingException -> 0x0624, ClientProtocolException -> 0x062e, ParseException -> 0x0638, IOException -> 0x0642 }
        if (r2 == 0) goto L_0x05e7;
    L_0x05d2:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x05dd, NoSuchAlgorithmException -> 0x05f2, NoSuchPaddingException -> 0x05fc, IllegalBlockSizeException -> 0x0606, BadPaddingException -> 0x0610, InvalidAlgorithmParameterException -> 0x061a, UnsupportedEncodingException -> 0x0624, ClientProtocolException -> 0x062e, ParseException -> 0x0638, IOException -> 0x0642 }
        if (r2 == 0) goto L_0x0218;
    L_0x05d6:
        r2 = "serverResponse: true";
        com.brandall.nutter.ls.m1344a(r2);	 Catch:{ InvalidKeyException -> 0x05dd, NoSuchAlgorithmException -> 0x05f2, NoSuchPaddingException -> 0x05fc, IllegalBlockSizeException -> 0x0606, BadPaddingException -> 0x0610, InvalidAlgorithmParameterException -> 0x061a, UnsupportedEncodingException -> 0x0624, ClientProtocolException -> 0x062e, ParseException -> 0x0638, IOException -> 0x0642 }
        goto L_0x0218;
    L_0x05dd:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x05e7:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x05dd, NoSuchAlgorithmException -> 0x05f2, NoSuchPaddingException -> 0x05fc, IllegalBlockSizeException -> 0x0606, BadPaddingException -> 0x0610, InvalidAlgorithmParameterException -> 0x061a, UnsupportedEncodingException -> 0x0624, ClientProtocolException -> 0x062e, ParseException -> 0x0638, IOException -> 0x0642 }
        if (r2 == 0) goto L_0x0218;
    L_0x05eb:
        r2 = "serverResponse: false";
        com.brandall.nutter.ls.m1347d(r2);	 Catch:{ InvalidKeyException -> 0x05dd, NoSuchAlgorithmException -> 0x05f2, NoSuchPaddingException -> 0x05fc, IllegalBlockSizeException -> 0x0606, BadPaddingException -> 0x0610, InvalidAlgorithmParameterException -> 0x061a, UnsupportedEncodingException -> 0x0624, ClientProtocolException -> 0x062e, ParseException -> 0x0638, IOException -> 0x0642 }
        goto L_0x0218;
    L_0x05f2:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x05fc:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0606:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0610:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x061a:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0624:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x062e:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0638:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0642:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x064c:
        r2 = f1636e;
        if (r2 == 0) goto L_0x06e2;
    L_0x0650:
        r2 = "";
        f1645n = r2;
        r0 = r19;
        r2 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x0673, NoSuchAlgorithmException -> 0x0688, NoSuchPaddingException -> 0x0692, IllegalBlockSizeException -> 0x069c, BadPaddingException -> 0x06a6, InvalidAlgorithmParameterException -> 0x06b0, UnsupportedEncodingException -> 0x06ba, ClientProtocolException -> 0x06c4, ParseException -> 0x06ce, IOException -> 0x06d8 }
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x0673, NoSuchAlgorithmException -> 0x0688, NoSuchPaddingException -> 0x0692, IllegalBlockSizeException -> 0x069c, BadPaddingException -> 0x06a6, InvalidAlgorithmParameterException -> 0x06b0, UnsupportedEncodingException -> 0x06ba, ClientProtocolException -> 0x06c4, ParseException -> 0x06ce, IOException -> 0x06d8 }
        r4 = f1646o;	 Catch:{ InvalidKeyException -> 0x0673, NoSuchAlgorithmException -> 0x0688, NoSuchPaddingException -> 0x0692, IllegalBlockSizeException -> 0x069c, BadPaddingException -> 0x06a6, InvalidAlgorithmParameterException -> 0x06b0, UnsupportedEncodingException -> 0x06ba, ClientProtocolException -> 0x06c4, ParseException -> 0x06ce, IOException -> 0x06d8 }
        r3 = com.brandall.nutter.ki.m1299b(r3, r4);	 Catch:{ InvalidKeyException -> 0x0673, NoSuchAlgorithmException -> 0x0688, NoSuchPaddingException -> 0x0692, IllegalBlockSizeException -> 0x069c, BadPaddingException -> 0x06a6, InvalidAlgorithmParameterException -> 0x06b0, UnsupportedEncodingException -> 0x06ba, ClientProtocolException -> 0x06c4, ParseException -> 0x06ce, IOException -> 0x06d8 }
        r2 = com.brandall.nutter.ki.m1301c(r2, r3);	 Catch:{ InvalidKeyException -> 0x0673, NoSuchAlgorithmException -> 0x0688, NoSuchPaddingException -> 0x0692, IllegalBlockSizeException -> 0x069c, BadPaddingException -> 0x06a6, InvalidAlgorithmParameterException -> 0x06b0, UnsupportedEncodingException -> 0x06ba, ClientProtocolException -> 0x06c4, ParseException -> 0x06ce, IOException -> 0x06d8 }
        if (r2 == 0) goto L_0x067d;
    L_0x0668:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x0673, NoSuchAlgorithmException -> 0x0688, NoSuchPaddingException -> 0x0692, IllegalBlockSizeException -> 0x069c, BadPaddingException -> 0x06a6, InvalidAlgorithmParameterException -> 0x06b0, UnsupportedEncodingException -> 0x06ba, ClientProtocolException -> 0x06c4, ParseException -> 0x06ce, IOException -> 0x06d8 }
        if (r2 == 0) goto L_0x0218;
    L_0x066c:
        r2 = "serverResponse: true";
        com.brandall.nutter.ls.m1344a(r2);	 Catch:{ InvalidKeyException -> 0x0673, NoSuchAlgorithmException -> 0x0688, NoSuchPaddingException -> 0x0692, IllegalBlockSizeException -> 0x069c, BadPaddingException -> 0x06a6, InvalidAlgorithmParameterException -> 0x06b0, UnsupportedEncodingException -> 0x06ba, ClientProtocolException -> 0x06c4, ParseException -> 0x06ce, IOException -> 0x06d8 }
        goto L_0x0218;
    L_0x0673:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x067d:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x0673, NoSuchAlgorithmException -> 0x0688, NoSuchPaddingException -> 0x0692, IllegalBlockSizeException -> 0x069c, BadPaddingException -> 0x06a6, InvalidAlgorithmParameterException -> 0x06b0, UnsupportedEncodingException -> 0x06ba, ClientProtocolException -> 0x06c4, ParseException -> 0x06ce, IOException -> 0x06d8 }
        if (r2 == 0) goto L_0x0218;
    L_0x0681:
        r2 = "serverResponse: false";
        com.brandall.nutter.ls.m1347d(r2);	 Catch:{ InvalidKeyException -> 0x0673, NoSuchAlgorithmException -> 0x0688, NoSuchPaddingException -> 0x0692, IllegalBlockSizeException -> 0x069c, BadPaddingException -> 0x06a6, InvalidAlgorithmParameterException -> 0x06b0, UnsupportedEncodingException -> 0x06ba, ClientProtocolException -> 0x06c4, ParseException -> 0x06ce, IOException -> 0x06d8 }
        goto L_0x0218;
    L_0x0688:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0692:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x069c:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x06a6:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x06b0:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x06ba:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x06c4:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x06ce:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x06d8:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x06e2:
        r2 = f1637f;
        if (r2 == 0) goto L_0x085f;
    L_0x06e6:
        r2 = "";
        f1645n = r2;
        r0 = r19;
        r2 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = f1647p;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r5 = f1648q;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r6 = new org.apache.http.impl.client.DefaultHttpClient;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r6.<init>();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r7 = new org.apache.http.client.methods.HttpPost;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r10 = "error";
        r7.<init>(r10);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r10 = com.brandall.nutter.ki.m1295a();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r11 = com.brandall.nutter.ki.m1295a();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r12 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        if (r12 == 0) goto L_0x072a;
    L_0x070e:
        r12 = new java.lang.StringBuilder;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r13 = "int 1: ";
        r12.<init>(r13);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r12 = r12.append(r10);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r13 = " - int2: ";
        r12 = r12.append(r13);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r12 = r12.append(r11);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r12 = r12.toString();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        com.brandall.nutter.ls.m1346c(r12);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
    L_0x072a:
        r12 = new java.lang.StringBuilder;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r10 = (char) r10;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r10 = java.lang.Character.toString(r10);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r10 = java.lang.String.valueOf(r10);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r12.<init>(r10);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r10 = (char) r11;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r10 = java.lang.Character.toString(r10);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r10 = r12.append(r10);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r11 = "COMMENT=";
        r10 = r10.append(r11);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = com.brandall.nutter.lx.m1450s(r3);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = r10.append(r3);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r10 = "|KNOWLEDGE|";
        r3 = r3.append(r10);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = r3.append(r4);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = "|";
        r3 = r3.append(r4);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = r3.append(r5);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = "|";
        r3 = r3.append(r4);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = java.util.Locale.getDefault();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = r4.toString();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = r3.append(r4);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = "|";
        r3 = r3.append(r4);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = r3.toString();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        if (r4 == 0) goto L_0x0795;
    L_0x0783:
        r4 = new java.lang.StringBuilder;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r5 = "sendKnowledge constuct: ";
        r4.<init>(r5);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = r4.append(r3);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = r4.toString();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        com.brandall.nutter.ls.m1346c(r4);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
    L_0x0795:
        r4 = com.brandall.nutter.GlobalV.az();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = com.brandall.nutter.kc.m1283a(r3, r4);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = r6.getParams();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r5 = "utter";
        org.apache.http.params.HttpProtocolParams.setUserAgent(r4, r5);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = new java.util.ArrayList;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4.<init>();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r5 = new org.apache.http.message.BasicNameValuePair;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r10 = "p";
        r5.<init>(r10, r3);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4.add(r5);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = new org.apache.http.client.entity.UrlEncodedFormEntity;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3.<init>(r4);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r7.setEntity(r3);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = r6.execute(r7);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = r3.getEntity();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r3 = org.apache.http.util.EntityUtils.toString(r3);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        if (r4 == 0) goto L_0x07df;
    L_0x07cd:
        r4 = new java.lang.StringBuilder;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r5 = "sendKnowledge httpContent: ";
        r4.<init>(r5);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = r4.append(r3);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        r4 = r4.toString();	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        com.brandall.nutter.ls.m1346c(r4);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
    L_0x07df:
        r2 = com.brandall.nutter.ki.m1301c(r2, r3);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        if (r2 == 0) goto L_0x07fa;
    L_0x07e5:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        if (r2 == 0) goto L_0x0218;
    L_0x07e9:
        r2 = "serverResponse: true";
        com.brandall.nutter.ls.m1344a(r2);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        goto L_0x0218;
    L_0x07f0:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x07fa:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        if (r2 == 0) goto L_0x0218;
    L_0x07fe:
        r2 = "serverResponse: false";
        com.brandall.nutter.ls.m1347d(r2);	 Catch:{ InvalidKeyException -> 0x07f0, NoSuchAlgorithmException -> 0x0805, NoSuchPaddingException -> 0x080f, IllegalBlockSizeException -> 0x0819, BadPaddingException -> 0x0823, InvalidAlgorithmParameterException -> 0x082d, UnsupportedEncodingException -> 0x0837, ClientProtocolException -> 0x0841, ParseException -> 0x084b, IOException -> 0x0855 }
        goto L_0x0218;
    L_0x0805:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x080f:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0819:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0823:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x082d:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0837:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0841:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x084b:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0855:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x085f:
        r0 = r19;
        r2 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x087c, NoSuchAlgorithmException -> 0x0891, NoSuchPaddingException -> 0x089b, IllegalBlockSizeException -> 0x08a5, BadPaddingException -> 0x08af, InvalidAlgorithmParameterException -> 0x08b9, UnsupportedEncodingException -> 0x08c3, ClientProtocolException -> 0x08cd, ParseException -> 0x08d7, IOException -> 0x08e1 }
        r0 = r19;
        r3 = r0.f1649a;	 Catch:{ InvalidKeyException -> 0x087c, NoSuchAlgorithmException -> 0x0891, NoSuchPaddingException -> 0x089b, IllegalBlockSizeException -> 0x08a5, BadPaddingException -> 0x08af, InvalidAlgorithmParameterException -> 0x08b9, UnsupportedEncodingException -> 0x08c3, ClientProtocolException -> 0x08cd, ParseException -> 0x08d7, IOException -> 0x08e1 }
        r3 = com.brandall.nutter.ki.m1296a(r3);	 Catch:{ InvalidKeyException -> 0x087c, NoSuchAlgorithmException -> 0x0891, NoSuchPaddingException -> 0x089b, IllegalBlockSizeException -> 0x08a5, BadPaddingException -> 0x08af, InvalidAlgorithmParameterException -> 0x08b9, UnsupportedEncodingException -> 0x08c3, ClientProtocolException -> 0x08cd, ParseException -> 0x08d7, IOException -> 0x08e1 }
        r2 = com.brandall.nutter.ki.m1301c(r2, r3);	 Catch:{ InvalidKeyException -> 0x087c, NoSuchAlgorithmException -> 0x0891, NoSuchPaddingException -> 0x089b, IllegalBlockSizeException -> 0x08a5, BadPaddingException -> 0x08af, InvalidAlgorithmParameterException -> 0x08b9, UnsupportedEncodingException -> 0x08c3, ClientProtocolException -> 0x08cd, ParseException -> 0x08d7, IOException -> 0x08e1 }
        if (r2 == 0) goto L_0x0886;
    L_0x0871:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x087c, NoSuchAlgorithmException -> 0x0891, NoSuchPaddingException -> 0x089b, IllegalBlockSizeException -> 0x08a5, BadPaddingException -> 0x08af, InvalidAlgorithmParameterException -> 0x08b9, UnsupportedEncodingException -> 0x08c3, ClientProtocolException -> 0x08cd, ParseException -> 0x08d7, IOException -> 0x08e1 }
        if (r2 == 0) goto L_0x0218;
    L_0x0875:
        r2 = "serverResponse: true";
        com.brandall.nutter.ls.m1344a(r2);	 Catch:{ InvalidKeyException -> 0x087c, NoSuchAlgorithmException -> 0x0891, NoSuchPaddingException -> 0x089b, IllegalBlockSizeException -> 0x08a5, BadPaddingException -> 0x08af, InvalidAlgorithmParameterException -> 0x08b9, UnsupportedEncodingException -> 0x08c3, ClientProtocolException -> 0x08cd, ParseException -> 0x08d7, IOException -> 0x08e1 }
        goto L_0x0218;
    L_0x087c:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x0886:
        r2 = com.brandall.nutter.hc.f1269b;	 Catch:{ InvalidKeyException -> 0x087c, NoSuchAlgorithmException -> 0x0891, NoSuchPaddingException -> 0x089b, IllegalBlockSizeException -> 0x08a5, BadPaddingException -> 0x08af, InvalidAlgorithmParameterException -> 0x08b9, UnsupportedEncodingException -> 0x08c3, ClientProtocolException -> 0x08cd, ParseException -> 0x08d7, IOException -> 0x08e1 }
        if (r2 == 0) goto L_0x0218;
    L_0x088a:
        r2 = "serverResponse: false";
        com.brandall.nutter.ls.m1347d(r2);	 Catch:{ InvalidKeyException -> 0x087c, NoSuchAlgorithmException -> 0x0891, NoSuchPaddingException -> 0x089b, IllegalBlockSizeException -> 0x08a5, BadPaddingException -> 0x08af, InvalidAlgorithmParameterException -> 0x08b9, UnsupportedEncodingException -> 0x08c3, ClientProtocolException -> 0x08cd, ParseException -> 0x08d7, IOException -> 0x08e1 }
        goto L_0x0218;
    L_0x0891:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x089b:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x08a5:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x08af:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x08b9:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x08c3:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x08cd:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x08d7:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x08e1:
        r2 = move-exception;
        r3 = "error";
        f1645n = r3;
        r2.printStackTrace();
        goto L_0x0218;
    L_0x08eb:
        r2 = com.brandall.nutter.hc.f1269b;
        if (r2 == 0) goto L_0x0233;
    L_0x08ef:
        r2 = "GSI Server Disabled";
        com.brandall.nutter.ls.m1347d(r2);
        goto L_0x0233;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brandall.nutter.kz.a():java.lang.String");
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m1309a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (hc.f1269b) {
            ls.m1345b("GSI onPostEx: " + str);
        }
        if (f1641j) {
            lt.m1351a(this.f1649a, "speak", str);
        } else if (f1640i) {
            lt.m1351a(this.f1649a, "web", str);
        } else if (f1639h) {
            lt.m1351a(this.f1649a, "toast", str);
        } else if (f1642k) {
            lt.m1351a(this.f1649a, "run", str);
        } else if (!str.matches("") && hc.f1269b) {
            ls.m1347d("GSI onPostEx no action taken");
        }
        f1643l = 999;
        f1644m = 0;
        f1633b = false;
        f1634c = false;
        f1639h = false;
        f1640i = false;
        f1641j = false;
        f1642k = false;
        f1635d = false;
        f1645n = "";
        f1638g = false;
        f1636e = false;
        f1646o = "";
        f1647p = "";
        f1648q = "";
        f1637f = false;
        super.onPostExecute(str);
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        if (hc.f1269b) {
            ls.m1345b("GSI onPreEx");
        }
    }
}
