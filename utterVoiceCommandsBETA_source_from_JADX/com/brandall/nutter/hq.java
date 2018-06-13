package com.brandall.nutter;

import android.content.Context;
import com.faceture.google.play.QueryParamConst;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class hq {
    private static final Pattern f1301A = Pattern.compile(".*\\b(\\d{2}\\s\\d{2})\\b.*");
    private static final Pattern f1302B = Pattern.compile(".*\\b\\dam\\b.*");
    private static final Pattern f1303C = Pattern.compile(".*\\b\\d\\dam\\b.*");
    private static final Pattern f1304D = Pattern.compile(".*\\b\\dpm\\b.*");
    private static final Pattern f1305E = Pattern.compile(".*\\b\\d\\dpm\\b.*");
    private static final Pattern f1306F = Pattern.compile(".*\\b\\d[a.m.]\\b.*");
    private static final Pattern f1307G = Pattern.compile(".*\\b\\d\\d[a.m.]\\b.*");
    private static final Pattern f1308H = Pattern.compile(".*\\b\\d[p.m.]\\b.*");
    private static final Pattern f1309I = Pattern.compile(".*\\b\\d\\d[p.m.]\\b.*");
    private static final Pattern f1310J = Pattern.compile(".*\\b\\d\\s[a.m.]\\b.*");
    private static final Pattern f1311K = Pattern.compile(".*\\b\\d\\d\\s[a.m.]\\b.*");
    private static final Pattern f1312L = Pattern.compile(".*\\b\\d\\s[p.m.]\\b.*");
    private static final Pattern f1313M = Pattern.compile(".*\\b\\d\\d\\s[p.m.]\\b.*");
    private static final Pattern f1314N = Pattern.compile(".*\\b\\d\\sam\\b.*");
    private static final Pattern f1315O = Pattern.compile(".*\\b\\d\\sa\\sm\\b.*");
    private static final Pattern f1316P = Pattern.compile(".*\\b\\d\\d\\sam\\b.*");
    private static final Pattern f1317Q = Pattern.compile(".*\\b\\d\\d\\sa\\sm\\b.*");
    private static final Pattern f1318R = Pattern.compile(".*\\b\\d\\spm\\b.*");
    private static final Pattern f1319S = Pattern.compile(".*\\b\\d\\sp\\sm\\b.*");
    private static final Pattern f1320T = Pattern.compile(".*\\b\\d\\d\\spm\\b.*");
    private static final Pattern f1321U = Pattern.compile(".*\\b\\d\\d\\sp\\sm\\b.*");
    private static final Pattern f1322V = Pattern.compile(".*\\bfirst\\b.*");
    private static final Pattern f1323W = Pattern.compile(".*\\bsecond\\b.*");
    private static final Pattern f1324X = Pattern.compile(".*\\bthird\\b.*");
    private static final Pattern f1325Y = Pattern.compile(".*\\bfourth\\b.*");
    private static final Pattern f1326Z = Pattern.compile(".*\\bfifth\\b.*");
    private static ArrayList<String> f1327a = new ArrayList();
    private static final Pattern aA = Pattern.compile(".*\\b11th\\b.*");
    private static final Pattern aB = Pattern.compile(".*\\b12th\\b.*");
    private static final Pattern aC = Pattern.compile(".*\\b13th\\b.*");
    private static final Pattern aD = Pattern.compile(".*\\b14th\\b.*");
    private static final Pattern aE = Pattern.compile(".*\\b15th\\b.*");
    private static final Pattern aF = Pattern.compile(".*\\b16th\\b.*");
    private static final Pattern aG = Pattern.compile(".*\\b17th\\b.*");
    private static final Pattern aH = Pattern.compile(".*\\b18th\\b.*");
    private static final Pattern aI = Pattern.compile(".*\\b19th\\b.*");
    private static final Pattern aJ = Pattern.compile(".*\\b20th\\b.*");
    private static final Pattern aK = Pattern.compile(".*\\b21st\\b.*");
    private static final Pattern aL = Pattern.compile(".*\\b22nd\\b.*");
    private static final Pattern aM = Pattern.compile(".*\\b23rd\\b.*");
    private static final Pattern aN = Pattern.compile(".*\\b24th\\b.*");
    private static final Pattern aO = Pattern.compile(".*\\b25th\\b.*");
    private static final Pattern aP = Pattern.compile(".*\\b26th\\b.*");
    private static final Pattern aQ = Pattern.compile(".*\\b27th\\b.*");
    private static final Pattern aR = Pattern.compile(".*\\b28th\\b.*");
    private static final Pattern aS = Pattern.compile(".*\\b29th\\b.*");
    private static final Pattern aT = Pattern.compile(".*\\b30th\\b.*");
    private static final Pattern aU = Pattern.compile(".*\\b31st\\b.*");
    private static final Pattern aV = Pattern.compile(".*\\bjanuary\\b.*");
    private static final Pattern aW = Pattern.compile(".*\\bfebruary\\b.*");
    private static final Pattern aX = Pattern.compile(".*\\bmarch\\b.*");
    private static final Pattern aY = Pattern.compile(".*\\bapril\\b.*");
    private static final Pattern aZ = Pattern.compile(".*\\bmay\\b.*");
    private static final Pattern aa = Pattern.compile(".*\\bsixth\\b.*");
    private static final Pattern ab = Pattern.compile(".*\\bseventh\\b.*");
    private static final Pattern ac = Pattern.compile(".*\\beighth\\b.*");
    private static final Pattern ad = Pattern.compile(".*\\bnineth\\b.*");
    private static final Pattern ae = Pattern.compile(".*\\btenth\\b.*");
    private static final Pattern af = Pattern.compile(".*\\beleventh\\b.*");
    private static final Pattern ag = Pattern.compile(".*\\btwelth\\b.*");
    private static final Pattern ah = Pattern.compile(".*\\bthirteenth\\b.*");
    private static final Pattern ai = Pattern.compile(".*\\bfourteenth\\b.*");
    private static final Pattern aj = Pattern.compile(".*\\bfifteenth\\b.*");
    private static final Pattern ak = Pattern.compile(".*\\bsixteenth\\b.*");
    private static final Pattern al = Pattern.compile(".*\\bseventeenth\\b.*");
    private static final Pattern am = Pattern.compile(".*\\beighteenth\\b.*");
    private static final Pattern an = Pattern.compile(".*\\bnineteenth\\b.*");
    private static final Pattern ao = Pattern.compile(".*\\btwentieth\\b.*");
    private static final Pattern ap = Pattern.compile(".*\\bthirtieth\\b.*");
    private static final Pattern aq = Pattern.compile(".*\\b1st\\b.*");
    private static final Pattern ar = Pattern.compile(".*\\b2nd\\b.*");
    private static final Pattern as = Pattern.compile(".*\\b3rd\\b.*");
    private static final Pattern at = Pattern.compile(".*\\b4th\\b.*");
    private static final Pattern au = Pattern.compile(".*\\b5th\\b.*");
    private static final Pattern av = Pattern.compile(".*\\b6th\\b.*");
    private static final Pattern aw = Pattern.compile(".*\\b7th\\b.*");
    private static final Pattern ax = Pattern.compile(".*\\b8th\\b.*");
    private static final Pattern ay = Pattern.compile(".*\\b9th\\b.*");
    private static final Pattern az = Pattern.compile(".*\\b10th\\b.*");
    private static ArrayList<String> f1328b = new ArrayList();
    private static final Pattern bA = Pattern.compile(".*\\b2017\\b.*");
    private static final Pattern bB = Pattern.compile(".*\\b2018\\b.*");
    private static final Pattern bC = Pattern.compile(".*\\b2019\\b.*");
    private static final Pattern bD = Pattern.compile(".*\\b2020\\b.*");
    private static final Pattern bE = Pattern.compile(".*\\bmonday\\b.*");
    private static final Pattern bF = Pattern.compile(".*\\btuesday\\b.*");
    private static final Pattern bG = Pattern.compile(".*\\bwednesday\\b.*");
    private static final Pattern bH = Pattern.compile(".*\\bthursday\\b.*");
    private static final Pattern bI = Pattern.compile(".*\\bfriday\\b.*");
    private static final Pattern bJ = Pattern.compile(".*\\bsaturday\\b.*");
    private static final Pattern bK = Pattern.compile(".*\\bsunday\\b.*");
    private static Pattern bL = Pattern.compile(".*\\bcalled\\b.*");
    private static Pattern bM = Pattern.compile(".*\\bnamed\\b.*");
    private static Pattern bN = Pattern.compile(".*\\bnames\\b.*");
    private static Pattern bO = Pattern.compile(".*\\bname\\b.*");
    private static Pattern bP = Pattern.compile(".*\\bcalls\\b.*");
    private static Pattern bQ = Pattern.compile(".*\\bcall\\b.*");
    private static Pattern bR = Pattern.compile(".*\\bcold\\b.*");
    private static final Pattern bS = Pattern.compile(".*\\btomorrow\\b.*");
    private static final Pattern bT = Pattern.compile(".*\\ctoday\\b.*");
    private static final Pattern ba = Pattern.compile(".*\\bjune\\b.*");
    private static final Pattern bb = Pattern.compile(".*\\bjuly\\b.*");
    private static final Pattern bc = Pattern.compile(".*\\baugust\\b.*");
    private static final Pattern bd = Pattern.compile(".*\\bseptember\\b.*");
    private static final Pattern be = Pattern.compile(".*\\boctober\\b.*");
    private static final Pattern bf = Pattern.compile(".*\\bnovember\\b.*");
    private static final Pattern bg = Pattern.compile(".*\\bdecember\\b.*");
    private static final Pattern bh = Pattern.compile(".*\\bam\\b.*");
    private static final Pattern bi = Pattern.compile(".*\\bpm\\b.*");
    private static final Pattern bj = Pattern.compile(".*\\ba[.m.]\\b.*");
    private static final Pattern bk = Pattern.compile(".*\\bp[.m.]\\b.*");
    private static final Pattern bl = Pattern.compile(".*\\b\\da[.m.]\\b.*");
    private static final Pattern bm = Pattern.compile(".*\\b\\dp[.m.]\\b.*");
    private static final Pattern bn = Pattern.compile(".*\\b\\d\\da[.m.]\\b.*");
    private static final Pattern bo = Pattern.compile(".*\\b\\d\\dp[.m.]\\b.*");
    private static final Pattern bp = Pattern.compile(".*\\ba\\sm\\b.*");
    private static final Pattern bq = Pattern.compile(".*\\bp\\sm\\b.*");
    private static final Pattern br = Pattern.compile(".*\\b\\dam\\b.*");
    private static final Pattern bs = Pattern.compile(".*\\b\\dpm\\b.*");
    private static final Pattern bt = Pattern.compile(".*\\b\\d\\dpm\\b.*");
    private static final Pattern bu = Pattern.compile(".*\\b\\d\\dam\\b.*");
    private static final Pattern bv = Pattern.compile(".*\\b2012\\b.*");
    private static final Pattern bw = Pattern.compile(".*\\b2013\\b.*");
    private static final Pattern bx = Pattern.compile(".*\\b2014\\b.*");
    private static final Pattern by = Pattern.compile(".*\\b2015\\b.*");
    private static final Pattern bz = Pattern.compile(".*\\b2016\\b.*");
    private static int f1329c = 0;
    private static int f1330d = 0;
    private static int f1331e = 0;
    private static int f1332f = 0;
    private static int f1333g = 0;
    private static int f1334h = 0;
    private static boolean f1335i = false;
    private static boolean f1336j = false;
    private static boolean f1337k = false;
    private static boolean f1338l = false;
    private static boolean f1339m = false;
    private static boolean f1340n = false;
    private static boolean f1341o = false;
    private static boolean f1342p = false;
    private static boolean f1343q = false;
    private static boolean f1344r = false;
    private static boolean f1345s = false;
    private static boolean f1346t = false;
    private static boolean f1347u = false;
    private static String f1348v = "";
    private static String f1349w = "";
    private static final Pattern f1350x = Pattern.compile(".*\\b(\\d{3})\\b.*");
    private static final Pattern f1351y = Pattern.compile(".*\\b(\\d{4})\\b.*");
    private static final Pattern f1352z = Pattern.compile(".*\\b(\\d\\s\\d{2})\\b.*");

    public static ArrayList<String> m1131a(Context context, ArrayList<String> arrayList) {
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            String trim = ((String) listIterator.next()).toString().toLowerCase().trim();
            ls.m1344a("calLoop: " + trim);
            f1334h = 0;
            f1331e = 0;
            f1333g = 0;
            f1332f = 0;
            f1329c = 0;
            f1330d = 0;
            f1349w = "";
            f1348v = "";
            f1327a.clear();
            f1335i = false;
            f1336j = false;
            f1337k = false;
            f1338l = false;
            f1339m = false;
            f1340n = false;
            f1345s = false;
            f1341o = false;
            f1342p = false;
            f1343q = false;
            f1344r = false;
            f1347u = false;
            if (m1139d(trim)) {
                ls.m1344a("contained hour/minute data");
                m1140e(trim);
                f1346t = true;
                break;
            }
            boolean z;
            ls.m1346c("checkHourMinute: true");
            if (bv.matcher(trim).matches()) {
                ls.m1345b("isYear: p2012");
                f1333g = 2012;
                f1339m = true;
                z = true;
            } else if (bw.matcher(trim).matches()) {
                ls.m1345b("isYear: p2013");
                f1333g = 2013;
                f1339m = true;
                z = true;
            } else if (bx.matcher(trim).matches()) {
                ls.m1345b("isYear: p2014");
                f1333g = 2014;
                f1339m = true;
                z = true;
            } else if (by.matcher(trim).matches()) {
                ls.m1345b("isYear: p2015");
                f1333g = 2015;
                f1339m = true;
                z = true;
            } else if (bz.matcher(trim).matches()) {
                ls.m1345b("isYear: p2016");
                f1333g = 2016;
                f1339m = true;
                z = true;
            } else if (bA.matcher(trim).matches()) {
                ls.m1345b("isYear: p2017");
                f1333g = 2017;
                f1339m = true;
                z = true;
            } else if (bB.matcher(trim).matches()) {
                ls.m1345b("isYear: p2018");
                f1333g = 2018;
                f1339m = true;
                z = true;
            } else if (bC.matcher(trim).matches()) {
                ls.m1345b("isYear: p2019");
                f1333g = 2019;
                f1339m = true;
                z = true;
            } else if (bD.matcher(trim).matches()) {
                ls.m1345b("isYear: p2020");
                f1333g = 2020;
                f1339m = true;
                z = true;
            } else {
                z = false;
            }
            f1339m = z;
            if (m1134a(trim)) {
                Calendar instance;
                ls.m1346c("hasTime: TRUE");
                ls.m1346c("in isMonth");
                f1338l = false;
                if (aV.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pJanuary");
                    f1331e = 1;
                    f1338l = true;
                    z = true;
                } else if (aW.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pFebruary");
                    f1331e = 2;
                    f1338l = true;
                    z = true;
                } else if (aX.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pMarch");
                    f1331e = 3;
                    f1338l = true;
                    z = true;
                } else if (aY.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pApril");
                    f1331e = 4;
                    f1338l = true;
                    z = true;
                } else if (aZ.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pMay");
                    f1331e = 5;
                    f1338l = true;
                    z = true;
                } else if (ba.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pJune");
                    f1331e = 6;
                    f1338l = true;
                    z = true;
                } else if (bb.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pJuly");
                    f1331e = 7;
                    f1338l = true;
                    z = true;
                } else if (bc.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pAugust");
                    f1331e = 8;
                    f1338l = true;
                    z = true;
                } else if (bd.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pSeptember");
                    f1331e = 9;
                    f1338l = true;
                    z = true;
                } else if (be.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pOctober");
                    f1331e = 10;
                    f1338l = true;
                    z = true;
                } else if (bf.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pNovember");
                    f1331e = 11;
                    f1338l = true;
                    z = true;
                } else if (bg.matcher(trim).matches()) {
                    ls.m1345b("isMonth: pDecember");
                    f1331e = 12;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 1st") || trim.contains("of the first")) {
                    ls.m1345b("isMonth: of the 1st");
                    f1331e = 1;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 2nd") || trim.contains("of the second")) {
                    ls.m1345b("isMonth: of the 2nd");
                    f1331e = 2;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 3rd") || trim.contains("of the third")) {
                    ls.m1345b("isMonth: of the 3rd");
                    f1331e = 3;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 4th") || trim.contains("of the fourth")) {
                    ls.m1345b("isMonth: of the 4th");
                    f1331e = 4;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 5th") || trim.contains("of the fifth")) {
                    ls.m1345b("isMonth: of the 5th");
                    f1331e = 5;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 6th") || trim.contains("of the sixth")) {
                    ls.m1345b("isMonth: of the 6th");
                    f1331e = 6;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 7th") || trim.contains("of the seventh")) {
                    ls.m1345b("isMonth: of the 7th");
                    f1331e = 7;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 8th") || trim.contains("of the eighth")) {
                    ls.m1345b("isMonth: of the 8th");
                    f1331e = 8;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 9th") || trim.contains("of the ninth")) {
                    ls.m1345b("isMonth: of the 9th");
                    f1331e = 9;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 10th") || trim.contains("of the tenth")) {
                    ls.m1345b("isMonth: of the 10th");
                    f1331e = 10;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 11th") || trim.contains("of the eleventh")) {
                    ls.m1345b("isMonth: of the 11th");
                    f1331e = 11;
                    f1338l = true;
                    z = true;
                } else if (trim.contains("of the 12th") || trim.contains("of the twelth")) {
                    ls.m1345b("isMonth: of the 12th");
                    f1331e = 12;
                    f1338l = true;
                    z = true;
                } else {
                    z = false;
                }
                f1338l = z;
                ls.m1346c("in isDate");
                f1337k = false;
                if (aq.matcher(trim).matches()) {
                    ls.m1345b("isDate: p1st");
                    f1334h = 1;
                    f1337k = true;
                    z = true;
                } else if (ar.matcher(trim).matches()) {
                    ls.m1345b("isDate: p2nd");
                    f1334h = 2;
                    f1337k = true;
                    z = true;
                } else if (as.matcher(trim).matches()) {
                    ls.m1345b("isDate: p3rd");
                    f1334h = 3;
                    f1337k = true;
                    z = true;
                } else if (at.matcher(trim).matches()) {
                    ls.m1345b("isDate: p4th");
                    f1334h = 4;
                    f1337k = true;
                    z = true;
                } else if (au.matcher(trim).matches()) {
                    ls.m1345b("isDate: p5th");
                    f1334h = 5;
                    f1337k = true;
                    z = true;
                } else if (av.matcher(trim).matches()) {
                    ls.m1345b("isDate: p6th");
                    f1334h = 6;
                    f1337k = true;
                    z = true;
                } else if (aw.matcher(trim).matches()) {
                    ls.m1345b("isDate: p7th");
                    f1334h = 7;
                    f1337k = true;
                    z = true;
                } else if (ax.matcher(trim).matches()) {
                    ls.m1345b("isDate: p8th");
                    f1334h = 8;
                    f1337k = true;
                    z = true;
                } else if (ay.matcher(trim).matches()) {
                    ls.m1345b("isDate: p9th");
                    f1334h = 9;
                    f1337k = true;
                    z = true;
                } else if (az.matcher(trim).matches()) {
                    ls.m1345b("isDate: p10th");
                    f1334h = 10;
                    f1337k = true;
                    z = true;
                } else if (aA.matcher(trim).matches()) {
                    ls.m1345b("isDate: p11th");
                    f1334h = 11;
                    f1337k = true;
                    z = true;
                } else if (aB.matcher(trim).matches()) {
                    ls.m1345b("isDate: p12th");
                    f1334h = 12;
                    f1337k = true;
                    z = true;
                } else if (aC.matcher(trim).matches()) {
                    ls.m1345b("isDate: p13th");
                    f1334h = 13;
                    f1337k = true;
                    z = true;
                } else if (aD.matcher(trim).matches()) {
                    ls.m1345b("isDate: p14th");
                    f1334h = 14;
                    f1337k = true;
                    z = true;
                } else if (aE.matcher(trim).matches()) {
                    ls.m1345b("isDate: p15th");
                    f1334h = 15;
                    f1337k = true;
                    z = true;
                } else if (aF.matcher(trim).matches()) {
                    ls.m1345b("isDate: p16th");
                    f1334h = 16;
                    f1337k = true;
                    z = true;
                } else if (aG.matcher(trim).matches()) {
                    ls.m1345b("isDate: p17th");
                    f1334h = 17;
                    f1337k = true;
                    z = true;
                } else if (aH.matcher(trim).matches()) {
                    ls.m1345b("isDate: p18th");
                    f1334h = 18;
                    f1337k = true;
                    z = true;
                } else if (aI.matcher(trim).matches()) {
                    ls.m1345b("isDate: p19th");
                    f1334h = 19;
                    f1337k = true;
                    z = true;
                } else if (aJ.matcher(trim).matches()) {
                    ls.m1345b("isDate: p20th");
                    f1334h = 20;
                    f1337k = true;
                    z = true;
                } else if (aK.matcher(trim).matches()) {
                    ls.m1345b("isDate: p21st");
                    f1334h = 21;
                    f1337k = true;
                    z = true;
                } else if (aL.matcher(trim).matches()) {
                    ls.m1345b("isDate: p22nd");
                    f1334h = 22;
                    f1337k = true;
                    z = true;
                } else if (aM.matcher(trim).matches()) {
                    ls.m1345b("isDate: p23rd");
                    f1334h = 23;
                    f1337k = true;
                    z = true;
                } else if (aN.matcher(trim).matches()) {
                    ls.m1345b("isDate: p24th");
                    f1334h = 24;
                    f1337k = true;
                    z = true;
                } else if (aO.matcher(trim).matches()) {
                    ls.m1345b("isDate: p25th");
                    f1334h = 25;
                    f1337k = true;
                    z = true;
                } else if (aP.matcher(trim).matches()) {
                    ls.m1345b("isDate: p26th");
                    f1334h = 26;
                    f1337k = true;
                    z = true;
                } else if (aQ.matcher(trim).matches()) {
                    ls.m1345b("isDate: p27th");
                    f1334h = 27;
                    f1337k = true;
                    z = true;
                } else if (aR.matcher(trim).matches()) {
                    ls.m1345b("isDate: p28th");
                    f1334h = 28;
                    f1337k = true;
                    z = true;
                } else if (aS.matcher(trim).matches()) {
                    ls.m1345b("isDate: p29th");
                    f1334h = 29;
                    f1337k = true;
                    z = true;
                } else if (aT.matcher(trim).matches()) {
                    ls.m1345b("isDate: p30th");
                    f1334h = 30;
                    f1337k = true;
                    z = true;
                } else if (aU.matcher(trim).matches()) {
                    ls.m1345b("isDate: p31st");
                    f1334h = 31;
                    f1337k = true;
                    z = true;
                } else if (f1322V.matcher(trim).matches()) {
                    ls.m1345b("isDate: pFirst");
                    f1334h = 1;
                    f1337k = true;
                    z = true;
                } else if (f1323W.matcher(trim).matches()) {
                    ls.m1345b("isDate: pSecond");
                    f1334h = 2;
                    f1337k = true;
                    z = true;
                } else if (f1324X.matcher(trim).matches()) {
                    ls.m1345b("isDate: pThird");
                    f1334h = 3;
                    f1337k = true;
                    z = true;
                } else if (f1325Y.matcher(trim).matches()) {
                    ls.m1345b("isDate: pFourth");
                    f1334h = 4;
                    f1337k = true;
                    z = true;
                } else if (f1326Z.matcher(trim).matches()) {
                    ls.m1345b("isDate: pFifth");
                    f1334h = 5;
                    f1337k = true;
                    z = true;
                } else if (aa.matcher(trim).matches()) {
                    ls.m1345b("isDate: pSixth");
                    f1334h = 6;
                    f1337k = true;
                    z = true;
                } else if (ab.matcher(trim).matches()) {
                    ls.m1345b("isDate: pSeventh");
                    f1334h = 7;
                    f1337k = true;
                    z = true;
                } else if (ac.matcher(trim).matches()) {
                    ls.m1345b("isDate: pEight");
                    f1334h = 8;
                    f1337k = true;
                    z = true;
                } else if (ad.matcher(trim).matches()) {
                    ls.m1345b("isDate: pNineth");
                    f1334h = 9;
                    f1337k = true;
                    z = true;
                } else if (ae.matcher(trim).matches()) {
                    ls.m1345b("isDate: pTenth");
                    f1334h = 10;
                    f1337k = true;
                    z = true;
                } else if (af.matcher(trim).matches()) {
                    ls.m1345b("isDate: pEleventh");
                    f1334h = 11;
                    f1337k = true;
                    z = true;
                } else if (ag.matcher(trim).matches()) {
                    ls.m1345b("isDate: pTwelth");
                    f1334h = 12;
                    f1337k = true;
                    z = true;
                } else if (ah.matcher(trim).matches()) {
                    ls.m1345b("isDate: pThirteenth");
                    f1334h = 13;
                    f1337k = true;
                    z = true;
                } else if (ai.matcher(trim).matches()) {
                    ls.m1345b("isDate: pFourteenth");
                    f1334h = 14;
                    f1337k = true;
                    z = true;
                } else if (aj.matcher(trim).matches()) {
                    ls.m1345b("isDate: pFifteenth");
                    f1334h = 15;
                    f1337k = true;
                    z = true;
                } else if (ak.matcher(trim).matches()) {
                    ls.m1345b("isDate: pSixteenth");
                    f1334h = 16;
                    f1337k = true;
                    z = true;
                } else if (al.matcher(trim).matches()) {
                    ls.m1345b("isDate: pSeventeenth");
                    f1334h = 17;
                    f1337k = true;
                    z = true;
                } else if (am.matcher(trim).matches()) {
                    ls.m1345b("isDate: pEighteenth");
                    f1334h = 18;
                    f1337k = true;
                    z = true;
                } else if (an.matcher(trim).matches()) {
                    ls.m1345b("isDate: pNineteenth");
                    f1334h = 19;
                    f1337k = true;
                    z = true;
                } else if (ao.matcher(trim).matches()) {
                    ls.m1345b("isDate: pTwentieth");
                    f1334h = 20;
                    f1337k = true;
                    z = true;
                } else if (ap.matcher(trim).matches()) {
                    ls.m1345b("isDate: pThirtieth");
                    f1334h = 30;
                    f1337k = true;
                    z = true;
                } else {
                    z = false;
                }
                f1337k = z;
                ls.m1346c("in isWeekday");
                if (bE.matcher(trim).matches()) {
                    ls.m1345b("isWeekday: pMonday");
                    f1332f = 2;
                    if (!f1337k) {
                        m1132a(f1332f);
                    }
                    z = true;
                } else if (bF.matcher(trim).matches()) {
                    ls.m1345b("isWeekday: pTuesday");
                    f1332f = 3;
                    if (!f1337k) {
                        m1132a(f1332f);
                    }
                    z = true;
                } else if (bG.matcher(trim).matches()) {
                    ls.m1345b("isWeekday: pWednesday");
                    f1332f = 4;
                    if (!f1337k) {
                        m1132a(f1332f);
                    }
                    z = true;
                } else if (bH.matcher(trim).matches()) {
                    ls.m1345b("isWeekday: pThursday");
                    f1332f = 5;
                    if (!f1337k) {
                        m1132a(f1332f);
                    }
                    z = true;
                } else if (bI.matcher(trim).matches()) {
                    ls.m1345b("isWeekday: pFriday");
                    f1332f = 6;
                    if (!f1337k) {
                        m1132a(f1332f);
                    }
                    z = true;
                } else if (bJ.matcher(trim).matches()) {
                    ls.m1345b("isWeekday: pSaturday");
                    f1332f = 7;
                    if (!f1337k) {
                        m1132a(f1332f);
                    }
                    z = true;
                } else if (bK.matcher(trim).matches()) {
                    ls.m1345b("isWeekday: pSunday");
                    f1332f = 1;
                    if (!f1337k) {
                        m1132a(f1332f);
                    }
                    z = true;
                } else if (bT.matcher(trim).matches()) {
                    ls.m1345b("isWeekday: pToday");
                    instance = Calendar.getInstance();
                    f1332f = instance.get(7);
                    f1331e = instance.get(2) + 1;
                    f1334h = instance.get(5);
                    f1333g = instance.get(1);
                    f1337k = true;
                    f1339m = true;
                    f1338l = true;
                    z = true;
                } else if (bS.matcher(trim).matches()) {
                    ls.m1345b("isWeekday: pTomorrow");
                    int i = Calendar.getInstance().get(7) + 1;
                    f1332f = i;
                    m1132a(i);
                    z = true;
                } else {
                    z = false;
                }
                f1340n = z;
                if (f1338l || f1337k || f1340n) {
                    ls.m1346c("isMonth: or isDate: or isWeekday: true");
                    if (f1340n) {
                        ls.m1346c("isMonth: or isDate: or isWeekday: TRUE : isWeekday: TRUE");
                        if (!f1338l && !f1337k) {
                            ls.m1346c("isMonth: or isDate: or isWeekday: TRUE : isWeekday: TRUE: isMonth: FALSE: isDate: FALSE");
                            z = m1133a();
                        } else if (!f1338l && f1337k) {
                            ls.m1346c("isMonth: or isDate: or isWeekday: TRUE : isWeekday: TRUE: isMonth: FALSE: isDate: TRUE");
                            m1136b(f1334h);
                            z = m1133a();
                        } else if (f1338l && f1337k) {
                            ls.m1346c("isMonth: or isDate: or isWeekday: TRUE : isWeekday: TRUE: isMonth: TRUE: isDate: TRUE");
                            z = m1133a();
                        } else {
                            if (f1338l && !f1337k) {
                                ls.m1346c("isMonth: or isDate: or isWeekday: TRUE : isWeekday: TRUE: isMonth: TRUE: isDate: FALSE");
                            }
                            z = false;
                        }
                    } else if (f1337k && !f1338l) {
                        ls.m1346c("isMonth: or isDate: or isWeekday: TRUE : isDate: TRUE: isMonth: FALSE");
                        m1136b(f1334h);
                        z = m1133a();
                    } else if (!f1338l || f1337k) {
                        ls.m1346c("isMonth: or isDate: or isWeekday: TRUE : isDate: TRUE: isMonth: TRUE");
                        z = m1133a();
                    } else {
                        ls.m1346c("isMonth: or isDate: or isWeekday: TRUE : isMonth: TRUE: isDate: FALSE");
                        z = false;
                    }
                } else {
                    ls.m1346c("isMonth: isDate: isWeekday: FALSE");
                    instance = Calendar.getInstance();
                    f1334h = instance.get(5);
                    f1331e = instance.get(2) + 1;
                    f1333g = instance.get(1);
                    ls.m1344a("getCurrentDate: dateInt: " + f1334h);
                    ls.m1344a("getCurrentDate: monthInt: " + f1331e);
                    ls.m1344a("getCurrentDate: yearInt: " + f1333g);
                    z = m1133a();
                }
            } else {
                ls.m1346c("hasTime: false");
                z = false;
            }
            if (z) {
                ls.m1346c("isStructured: true");
                f1345s = true;
                m1140e(trim);
                break;
            }
            ls.m1346c("isStructured: false");
        }
        if (f1345s) {
            ls.m1346c("hasStructure: true");
            if (f1343q && Integer.valueOf(f1329c).intValue() < 13) {
                i = f1329c;
                ls.m1346c("pmHour");
                switch (i) {
                    case 1:
                        f1329c = 13;
                        break;
                    case 2:
                        f1329c = 14;
                        break;
                    case 3:
                        f1329c = 15;
                        break;
                    case 4:
                        f1329c = 16;
                        break;
                    case 5:
                        f1329c = 17;
                        break;
                    case 6:
                        f1329c = 18;
                        break;
                    case 7:
                        f1329c = 19;
                        break;
                    case 8:
                        f1329c = 20;
                        break;
                    case 9:
                        f1329c = 21;
                        break;
                    case 10:
                        f1329c = 22;
                        break;
                    case 11:
                        f1329c = 23;
                        break;
                }
            }
            String stringBuilder = f1330d < 10 ? new StringBuilder(QueryParamConst.U_VALUE).append(String.valueOf(f1330d)).toString() : String.valueOf(f1330d);
            if (f1342p && f1329c == 12) {
                f1329c = 0;
            }
            ls.m1344a("haveHour: " + f1335i);
            ls.m1344a("haveMinute: " + f1336j);
            ls.m1344a("haveWeekday: " + f1340n);
            ls.m1344a("haveDate: " + f1337k);
            ls.m1344a("haveMonth: " + f1338l);
            ls.m1344a("haveYear: " + f1339m);
            ls.m1344a("am: " + f1342p);
            ls.m1344a("pm: " + f1343q);
            ls.m1344a("hourInt: " + f1329c);
            ls.m1344a("minuteInt: " + f1330d);
            ls.m1344a("monthInt: " + f1331e);
            ls.m1344a("dateInt: " + f1334h);
            ls.m1344a("yearInt: " + f1333g);
            ls.m1344a("allDayEvent: " + f1341o);
            ls.m1344a("called: " + f1344r + " : " + f1349w);
            ls.m1344a("endTime: " + (f1329c + 1) + ":" + f1330d);
            if (f1347u) {
                ls.m1344a("result: " + new StringBuilder(String.valueOf(String.valueOf(f1334h))).append("/").append(String.valueOf(f1331e)).append("/").append(String.valueOf(f1333g)).append(f1348v).toString());
                String str = "That date is " + f1348v;
                f1327a.add("error");
                f1327a.add(str);
            } else if (f1341o) {
                jy.m1226a(context, f1333g, f1331e - 1, f1334h, f1329c, f1330d, f1349w, true);
                ls.m1344a("result: " + new StringBuilder(String.valueOf(String.valueOf(f1334h))).append("/").append(String.valueOf(f1331e)).append("/").append(String.valueOf(f1333g)).append(" : All Day : ").append(f1349w).toString());
                f1327a.add("There you go");
            } else {
                jy.m1226a(context, f1333g, f1331e - 1, f1334h, f1329c, f1330d, f1349w, false);
                ls.m1344a("result: " + new StringBuilder(String.valueOf(String.valueOf(f1334h))).append("/").append(String.valueOf(f1331e)).append("/").append(String.valueOf(f1333g)).append(" : ").append(String.valueOf(f1329c)).append(":").append(stringBuilder).append(" : ").append(f1349w).toString());
                f1327a.add("There you go");
            }
        } else if (f1346t) {
            ls.m1346c("hasAlarmStructure: true");
            ArrayList a = hn.m1125a((ArrayList) arrayList);
            f1328b = a;
            Object obj = !a.isEmpty() ? ((String) f1328b.get(0)).matches("ERROR") ? "Sorry, but I couldn't structure that alarm." : f1328b.size() > 2 ? jy.m1227a(context, Integer.valueOf((String) f1328b.get(0)).intValue(), Integer.valueOf((String) f1328b.get(1)).intValue(), (String) f1328b.get(2)) ? "That's done" : "Sorry, something went wrong setting that alarm." : f1328b.size() == 2 ? jy.m1227a(context, Integer.valueOf((String) f1328b.get(0)).intValue(), Integer.valueOf((String) f1328b.get(1)).intValue(), "") ? "That's done" : "Sorry, something went wrong setting that alarm." : "Sorry, something went wrong setting that alarm." : "Sorry, but I couldn't resolve that alarm structure.";
            f1327a.add("alarm");
            f1327a.add(obj);
        } else {
            ls.m1347d("hasStructure: FALSE");
        }
        return f1327a;
    }

    private static void m1132a(int i) {
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(7);
        if (i < i2) {
            ls.m1344a("getWeekday: dotw < weekday");
            instance.add(6, (7 - i2) + i);
            f1331e = instance.get(2) + 1;
            f1334h = instance.get(5);
            f1333g = instance.get(1);
            f1337k = true;
            f1339m = true;
            f1338l = true;
            ls.m1344a("getWeekday: monthInt: " + f1331e);
            ls.m1344a("getWeekday: dateInt: " + f1334h);
            ls.m1344a("getWeekday: yearInt: " + f1333g);
        } else if (i > i2) {
            ls.m1344a("getWeekday: dotw > weekday");
            instance.add(6, i - i2);
            f1331e = instance.get(2) + 1;
            f1334h = instance.get(5);
            f1333g = instance.get(1);
            f1337k = true;
            f1339m = true;
            f1338l = true;
            ls.m1344a("getWeekday: monthInt: " + f1331e);
            ls.m1344a("getWeekday: dateInt: " + f1334h);
            ls.m1344a("getWeekday: yearInt: " + f1333g);
        } else {
            ls.m1344a("getWeekday: else: compareTime");
            instance = Calendar.getInstance();
            i2 = instance.get(10);
            int i3 = instance.get(12);
            if (f1329c < i2) {
                ls.m1344a("compareTime: hourInt < thisHour: TOMORROW");
                instance.add(6, 7);
                f1331e = instance.get(2) + 1;
                f1334h = instance.get(5);
                f1333g = instance.get(1);
                f1337k = true;
                f1339m = true;
                f1338l = true;
            } else if (f1329c > i2) {
                ls.m1344a("compareTime: hourInt < thisHour: TODAY");
                f1331e = instance.get(2) + 1;
                f1334h = instance.get(5);
                f1333g = instance.get(1);
                f1337k = true;
                f1339m = true;
                f1338l = true;
            } else if (f1330d < i3) {
                ls.m1344a("compareTime: minuteInt < thisMinute: TOMORROW");
                instance.add(6, 1);
                f1331e = instance.get(2) + 1;
                f1334h = instance.get(5);
                f1333g = instance.get(1);
                f1337k = true;
                f1339m = true;
                f1338l = true;
            } else if (f1330d > i3) {
                ls.m1344a("compareTime: minuteInt > thisMinute: TODAY");
                f1331e = instance.get(2) + 1;
                f1334h = instance.get(5);
                f1333g = instance.get(1);
                f1337k = true;
                f1339m = true;
                f1338l = true;
            }
        }
    }

    private static boolean m1133a() {
        int i;
        int i2;
        ls.m1344a("validateDate: dateInt:" + f1334h);
        ls.m1344a("validateDate: monthInt:" + f1331e);
        ls.m1344a("validateDate: yearInt:" + f1333g);
        if (f1331e == 0 && f1334h != 0) {
            m1136b(f1334h);
        }
        if (f1333g == 0 && f1331e != 0) {
            i = f1331e;
            ls.m1346c("getYear: moty: " + i);
            Calendar instance = Calendar.getInstance();
            i2 = instance.get(2) + 1;
            ls.m1346c("getYear: thisMonth: " + i2);
            if (i < i2) {
                ls.m1344a("getYear: moty < thisMonth");
                instance.add(1, 1);
                f1333g = instance.get(1);
                f1339m = true;
                ls.m1344a("getYear: monthInt: " + f1331e);
                ls.m1344a("getYear: dateInt: " + f1334h);
                ls.m1344a("getYear: yearInt: " + f1333g);
            } else if (i > i2) {
                ls.m1344a("getYear: moty > thisMonth");
                f1333g = instance.get(1);
                f1339m = true;
                ls.m1344a("getYear: yearInt: " + f1333g);
            } else {
                ls.m1344a("getYear: else: comparing date");
                if (f1334h < instance.get(5)) {
                    instance.add(1, 1);
                    f1333g = instance.get(1);
                    f1339m = true;
                } else if (f1334h > instance.get(5)) {
                    f1333g = instance.get(1);
                    f1339m = true;
                } else {
                    ls.m1344a("getYear: else: comparing hour");
                    if (f1329c > instance.get(10)) {
                        f1333g = instance.get(1);
                        f1339m = true;
                    } else if (f1329c < instance.get(10)) {
                        instance.add(1, 1);
                        f1333g = instance.get(1);
                        f1339m = true;
                    } else {
                        ls.m1344a("getYear: else: comparing minute");
                        if (f1330d > instance.get(12)) {
                            f1333g = instance.get(1);
                            f1339m = true;
                        } else if (f1330d < instance.get(12)) {
                            instance.add(1, 1);
                            f1333g = instance.get(1);
                            f1339m = true;
                        }
                    }
                }
            }
        }
        String valueOf = String.valueOf(f1334h);
        String valueOf2 = String.valueOf(f1331e);
        String valueOf3 = String.valueOf(f1333g);
        Calendar instance2 = Calendar.getInstance();
        if (f1333g == 0) {
            i = instance2.get(1);
            f1333g = i;
            valueOf3 = String.valueOf(i);
        }
        if (f1331e == 0) {
            int i3 = instance2.get(2) + 1;
            f1331e = i3;
            valueOf2 = String.valueOf(i3);
        }
        if (f1334h == 0) {
            i2 = instance2.get(5);
            f1334h = i2;
            valueOf = String.valueOf(i2);
        }
        if (f1331e > 0 && f1331e < 10) {
            valueOf2 = new StringBuilder(QueryParamConst.U_VALUE).append(String.valueOf(f1331e)).toString();
        }
        if (f1334h > 0 && f1334h < 10) {
            valueOf = new StringBuilder(QueryParamConst.U_VALUE).append(String.valueOf(f1334h)).toString();
        }
        String stringBuilder = new StringBuilder(String.valueOf(valueOf)).append(valueOf2).append(valueOf3).toString();
        ls.m1344a("validateDate: " + stringBuilder);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddmmyyyy");
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(stringBuilder);
            if (f1340n) {
                ls.m1346c("validateDate: haveWeekday: true");
                instance2.set(Integer.valueOf(valueOf3).intValue(), Integer.valueOf(valueOf2).intValue() - 1, Integer.valueOf(valueOf).intValue());
                if (f1332f != instance2.get(7)) {
                    ls.m1347d("validateDate: dayInt != dotw: " + f1332f + " : " + instance2.get(7));
                    f1347u = true;
                    switch (f1332f) {
                        case 0:
                            return false;
                        case 1:
                            f1348v = " not a Sunday";
                            break;
                        case 2:
                            f1348v = " not a Monday";
                            break;
                        case 3:
                            f1348v = " not a Tuesday";
                            break;
                        case 4:
                            f1348v = " not a Wednesday";
                            break;
                        case 5:
                            f1348v = " not a Thursday";
                            break;
                        case 6:
                            f1348v = " not a Friday";
                            break;
                        case 7:
                            f1348v = " not a Saturday";
                            break;
                        default:
                            return false;
                    }
                }
            }
            ls.m1345b("checkDateFormat: True");
            return true;
        } catch (ParseException e) {
            ls.m1348e("checkDateFormat ParseException");
            e.printStackTrace();
            return false;
        }
    }

    private static boolean m1134a(String str) {
        ls.m1346c("in hasTime");
        if (m1138c(str)) {
            return true;
        }
        String str2 = "";
        new String[1][0] = "";
        String replace = str.replace("o'clock", "00").replace("o clock", "00").replace("in the morning", "am").replace("in the afternoon", "pm").replace("in the evening", "pm");
        Matcher matcher;
        String group;
        String[] split;
        if (f1350x.matcher(replace).matches()) {
            ls.m1346c("disectHourMin: threeD");
            matcher = f1350x.matcher(replace);
            if (matcher.find()) {
                ls.m1346c("Matcher found");
                group = matcher.group(1);
                ls.m1344a("timeDigits: " + group);
                split = group.split("(?<=\\G.{1})");
                f1329c = Integer.valueOf(split[0]).intValue();
                f1330d = Integer.valueOf(split[1] + split[2]).intValue();
            }
            ls.m1344a("disectHourMin: hour: " + f1329c);
            ls.m1344a("disectHourMin: minute: " + f1330d);
            if (f1329c >= 25 || f1330d >= 60) {
                ls.m1347d("disectHourMin: out of bounds");
                return false;
            }
            m1137b(replace);
            f1335i = true;
            f1336j = true;
            return true;
        } else if (f1352z.matcher(replace).matches()) {
            ls.m1346c("It matched spaced time! p3DigitsGap");
            matcher = f1352z.matcher(replace);
            if (matcher.find()) {
                ls.m1345b("Matcher found");
                group = matcher.group(1);
                ls.m1344a("timeDigits: " + group);
                split = group.split("\\s");
                f1329c = Integer.valueOf(split[0]).intValue();
                f1330d = Integer.valueOf(split[1]).intValue();
            }
            ls.m1344a("disectHourMin: hour: " + f1329c);
            ls.m1344a("disectHourMin: minute: " + f1330d);
            if (f1329c >= 25 || f1330d >= 60) {
                ls.m1347d("disectHourMin: out of bounds");
                return false;
            }
            m1137b(replace);
            f1335i = true;
            f1336j = true;
            return true;
        } else if (f1301A.matcher(replace).matches()) {
            ls.m1346c("It matched spaced time! p4DigitsGap");
            matcher = f1301A.matcher(replace);
            if (matcher.find()) {
                ls.m1345b("Matcher found");
                group = matcher.group(1);
                ls.m1344a("timeDigits: " + group);
                split = group.split("\\s");
                f1329c = Integer.valueOf(split[0]).intValue();
                f1330d = Integer.valueOf(split[1]).intValue();
            }
            ls.m1344a("disectHourMin: hour: " + f1329c);
            ls.m1344a("disectHourMin: minute: " + f1330d);
            if (f1329c >= 25 || f1330d >= 60) {
                ls.m1347d("disectHourMin: out of bounds");
                return false;
            }
            m1137b(replace);
            f1335i = true;
            f1336j = true;
            return true;
        } else if (f1351y.matcher(replace).matches()) {
            ls.m1345b("hasTime: 4 dddd");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = Pattern.compile("\\b(\\d{4})\\b").matcher(replace);
            int i = 0;
            while (matcher2.find()) {
                i++;
                ls.m1346c("Matcher found count: " + i + " : " + matcher2.group(1));
                arrayList.add(matcher2.group(1));
            }
            if (arrayList.size() <= 1 || !f1339m) {
                f1339m = false;
                f1333g = 0;
                group = (String) arrayList.get(0);
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    group = (String) it.next();
                    if (!group.matches(String.valueOf(f1333g))) {
                        break;
                    }
                }
                group = str2;
            }
            ls.m1344a("timeDigits: " + group);
            split = group.split("(?<=\\G.{2})");
            f1329c = Integer.valueOf(split[0]).intValue();
            f1330d = Integer.valueOf(split[1]).intValue();
            ls.m1344a("disectHourMin: hour: " + f1329c);
            ls.m1344a("disectHourMin: minute: " + f1330d);
            if (f1329c >= 25 || f1330d >= 60) {
                ls.m1347d("disectHourMin: out of bounds");
                return false;
            }
            m1137b(replace);
            f1335i = true;
            f1336j = true;
            return true;
        } else if (replace.contains("five to")) {
            ls.m1346c("hasTime: five to");
            if (!m1135a(replace, "five to", true)) {
                return false;
            }
            f1330d = 55;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("ten to")) {
            ls.m1346c("hasTime: ten to");
            if (!m1135a(replace, "ten to", true)) {
                return false;
            }
            f1330d = 50;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("10 to")) {
            ls.m1346c("hasTime: 10 to");
            if (!m1135a(replace, "10 to", true)) {
                return false;
            }
            f1330d = 50;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("quarter to")) {
            ls.m1346c("hasTime: quarter to");
            if (!m1135a(replace, "quarter to", true)) {
                return false;
            }
            f1330d = 45;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("twenty to")) {
            ls.m1346c("hasTime: twenty to");
            if (!m1135a(replace, "twenty to", true)) {
                return false;
            }
            f1330d = 40;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("25 to")) {
            ls.m1346c("hasTime: 25 to");
            if (!m1135a(replace, "25 to", true)) {
                return false;
            }
            f1330d = 35;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("twenty five to")) {
            ls.m1346c("hasTime: twenty five to");
            if (!m1135a(replace, "twenty five to", true)) {
                return false;
            }
            f1330d = 35;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("half past")) {
            ls.m1346c("hasTime: half past");
            if (!m1135a(replace, "half past", false)) {
                return false;
            }
            f1330d = 30;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("twenty five past")) {
            ls.m1346c("hasTime: twenty five past");
            if (!m1135a(replace, "twenty five past", false)) {
                return false;
            }
            f1330d = 25;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("twenty 5 past")) {
            ls.m1346c("hasTime: twenty five past");
            if (!m1135a(replace, "twenty 5 past", false)) {
                return false;
            }
            f1330d = 25;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("25 past")) {
            ls.m1346c("hasTime: 25 past");
            if (!m1135a(replace, "25 past", false)) {
                return false;
            }
            f1330d = 25;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("twenty past")) {
            ls.m1346c("hasTime: twenty past");
            if (!m1135a(replace, "twenty past", false)) {
                return false;
            }
            f1330d = 20;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("20 past")) {
            ls.m1346c("hasTime: twenty past");
            if (!m1135a(replace, "20 past", false)) {
                return false;
            }
            f1330d = 20;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("quarter past")) {
            ls.m1346c("hasTime: quarter past");
            if (!m1135a(replace, "quarter past", false)) {
                return false;
            }
            f1330d = 15;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("ten past")) {
            ls.m1346c("hasTime: ten past");
            if (!m1135a(replace, "ten past", false)) {
                return false;
            }
            f1330d = 10;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("10 past")) {
            ls.m1346c("hasTime: 10 past");
            if (!m1135a(replace, "10 past", false)) {
                return false;
            }
            f1330d = 10;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("five past")) {
            ls.m1346c("hasTime: five past");
            if (!m1135a(replace, "five past", false)) {
                return false;
            }
            f1330d = 5;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (replace.contains("5 past")) {
            ls.m1346c("hasTime: 5 past");
            if (!m1135a(replace, "5 past", false)) {
                return false;
            }
            f1330d = 5;
            f1335i = true;
            f1336j = true;
            m1137b(replace);
            return true;
        } else if (f1314N.matcher(replace).matches()) {
            ls.m1346c("hasTime: p1DigitAM");
            matcher = Pattern.compile("\\b(\\d)\\sam\\b").matcher(replace);
            if (matcher.find()) {
                ls.m1346c("Matcher found count: " + matcher.group(1));
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1316P.matcher(replace).matches()) {
            ls.m1346c("hasTime: p2DigitAM");
            matcher = Pattern.compile("\\b(\\d\\d)\\sam\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1318R.matcher(replace).matches()) {
            ls.m1346c("hasTime: p1DigitPM");
            matcher = Pattern.compile("\\b(\\d)\\spm\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1320T.matcher(replace).matches()) {
            ls.m1346c("hasTime: p2DigitPM");
            matcher = Pattern.compile("\\b(\\d\\d)\\spm\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1315O.matcher(replace).matches()) {
            ls.m1346c("hasTime: p1DigitASM");
            matcher = Pattern.compile("\\b(\\d)\\sa\\sm\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1317Q.matcher(replace).matches()) {
            ls.m1346c("hasTime: p2DigitASM");
            matcher = Pattern.compile("\\b(\\d\\d)\\sa\\sm\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1319S.matcher(replace).matches()) {
            ls.m1346c("hasTime: p1DigitPSM");
            matcher = Pattern.compile("\\b(\\d)\\sp\\sm\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1321U.matcher(replace).matches()) {
            ls.m1346c("hasTime: p2DigitPSM");
            matcher = Pattern.compile("\\b(\\d\\d)\\sp\\sm\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1302B.matcher(replace).matches()) {
            ls.m1346c("hasTime: p1DigitAMNS");
            matcher = Pattern.compile("\\b(\\d)am\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1303C.matcher(replace).matches()) {
            ls.m1346c("hasTime: p2DigitAMNS");
            matcher = Pattern.compile("\\b(\\d\\d)am\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1305E.matcher(replace).matches()) {
            ls.m1346c("hasTime: p2DigitPMNS");
            matcher = Pattern.compile("\\b(\\d\\d)pm\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1304D.matcher(replace).matches()) {
            ls.m1346c("hasTime: p1DigitPMNS");
            matcher = Pattern.compile("\\b(\\d)pm\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
            }
            m1137b(replace);
            return true;
        } else if (f1308H.matcher(replace).matches()) {
            ls.m1346c("hasTime: p1DigitPMDOT");
            matcher = Pattern.compile("\\b(\\d)[p.m.]\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
                ls.m1344a("group1: " + matcher.group(1));
            }
            m1137b(replace);
            return true;
        } else if (f1309I.matcher(replace).matches()) {
            ls.m1346c("hasTime: p2DigitPMDOT");
            matcher = Pattern.compile("\\b(\\d\\d)[p.m.]\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
                ls.m1344a("group1: " + matcher.group(1));
            }
            m1137b(replace);
            return true;
        } else if (f1306F.matcher(replace).matches()) {
            ls.m1346c("hasTime: p1DigitAMDOT");
            matcher = Pattern.compile("\\b(\\d)[a.m.]\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
                ls.m1344a("group1: " + matcher.group(1));
            }
            m1137b(replace);
            return true;
        } else if (f1307G.matcher(replace).matches()) {
            ls.m1346c("hasTime: p2DigitAMDOT");
            matcher = Pattern.compile("\\b(\\d\\d)[a.m.]\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
                ls.m1344a("group1: " + matcher.group(1));
            }
            m1137b(replace);
            return true;
        } else if (f1312L.matcher(replace).matches()) {
            ls.m1346c("hasTime: p1DigitSPMDOT");
            matcher = Pattern.compile("\\b(\\d)\\s[p.m.]\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
                ls.m1344a("group1: " + matcher.group(1));
            }
            m1137b(replace);
            return true;
        } else if (f1313M.matcher(replace).matches()) {
            ls.m1346c("hasTime: p2DigitSPMDOT");
            matcher = Pattern.compile("\\b(\\d\\d)\\s[p.m.]\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
                ls.m1344a("group1: " + matcher.group(1));
            }
            m1137b(replace);
            return true;
        } else if (f1310J.matcher(replace).matches()) {
            ls.m1346c("hasTime: p1DigitSAMDOT");
            matcher = Pattern.compile("\\b(\\d)\\s[a.m.]\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
                ls.m1344a("group1: " + matcher.group(1));
            }
            m1137b(replace);
            return true;
        } else if (!f1311K.matcher(replace).matches()) {
            return false;
        } else {
            ls.m1346c("hasTime: p2DigitSAMDOT");
            matcher = Pattern.compile("\\b(\\d\\d)\\s[a.m.]\\b").matcher(replace);
            if (matcher.find()) {
                f1329c = Integer.valueOf(matcher.group(1)).intValue();
                ls.m1344a("group1: " + matcher.group(1));
            }
            m1137b(replace);
            return true;
        }
    }

    private static boolean m1135a(String str, String str2, boolean z) {
        String[] split = str.split(str2);
        if (split.length > 0) {
            ls.m1344a("remove length: " + split.length);
            ls.m1344a("remove0: " + split[0]);
            ls.m1344a("remove1: " + split[1]);
            String str3 = split[1];
            ls.m1344a("disectTime hour: " + str3);
            split = str3.split(" ");
            if (split.length > 0) {
                ls.m1344a("disect length: " + split.length);
                ls.m1344a("disect0: " + split[0]);
                ls.m1344a("disect1: " + split[1]);
                str3 = split[1];
                ls.m1344a("disectTime number: " + str3);
                if (str3.matches("[0-9]+")) {
                    ls.m1344a("disectTime number.matches 0-9+: " + str3);
                    try {
                        Integer.parseInt(str3);
                        if (Integer.valueOf(str3).intValue() <= 0 || Integer.valueOf(str3).intValue() >= 25) {
                            return false;
                        }
                        if (z) {
                            ls.m1344a("disectTime less: true");
                            f1329c = Integer.valueOf(str3).intValue() - 1;
                        } else {
                            ls.m1344a("disectTime less: false");
                            f1329c = Integer.valueOf(str3).intValue();
                        }
                        ls.m1344a("disectTime: hourInt: " + f1329c);
                        ls.m1344a("disectTime: minuteInt: " + f1330d);
                        if (f1329c >= 25 || f1330d >= 60) {
                            ls.m1347d("disectHourMin: out of bounds");
                            return m1138c(str);
                        } else {
                            m1137b(str);
                            return true;
                        }
                    } catch (NumberFormatException e) {
                        ls.m1347d("number not numeric");
                        return false;
                    }
                }
                ls.m1344a("disectTime number.matches 0-9+: false" + str3);
                return false;
            }
            ls.m1344a("disectTime number = 0 ");
            return false;
        }
        ls.m1344a("disectTime remove = 0 ");
        return false;
    }

    private static void m1136b(int i) {
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(5);
        if (i < i2) {
            instance.add(2, 1);
            f1331e = instance.get(2) + 1;
            f1333g = instance.get(1);
            f1339m = true;
            f1338l = true;
            ls.m1344a("getMonth: monthInt+1: " + f1331e);
            ls.m1344a("getMonth: yearInt: " + f1333g);
        } else if (i > i2) {
            f1331e = instance.get(2) + 1;
            f1333g = instance.get(1);
            f1339m = true;
            f1338l = true;
            ls.m1344a("getMonth: monthInt: " + f1331e);
            ls.m1344a("getMonth: yearInt: " + f1333g);
        } else {
            ls.m1344a("getMonth: else: compareTime");
            i2 = instance.get(10);
            int i3 = instance.get(12);
            if (f1329c > i2) {
                f1331e = instance.get(2) + 1;
                f1333g = instance.get(1);
                f1339m = true;
                f1338l = true;
            } else if (f1329c < i2) {
                instance.add(2, 1);
                f1331e = instance.get(2) + 1;
                f1333g = instance.get(1);
                f1339m = true;
                f1338l = true;
            } else if (f1330d > i3) {
                f1331e = instance.get(2) + 1;
                f1333g = instance.get(1);
                f1339m = true;
                f1338l = true;
            } else if (f1330d < i3) {
                instance.add(2, 1);
                f1331e = instance.get(2) + 1;
                f1333g = instance.get(1);
                f1339m = true;
                f1338l = true;
            }
        }
    }

    private static boolean m1137b(String str) {
        ls.m1346c("in hasAMPM");
        f1342p = false;
        f1343q = false;
        if (bh.matcher(str).matches() && bi.matcher(str).matches()) {
            ls.m1347d("hasAMPM: BOTH");
            return false;
        } else if (bh.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pAM: AM");
            f1342p = true;
            return true;
        } else if (bi.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pPM: PM");
            f1343q = true;
            return true;
        } else if (bk.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pPMDOT: PM");
            f1343q = true;
            return true;
        } else if (bq.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pPMS: PM");
            f1343q = true;
            return true;
        } else if (bs.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pPM1D: PM");
            f1343q = true;
            return true;
        } else if (bt.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pPM2D: PM");
            f1343q = true;
            return true;
        } else if (bj.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pAMDOT : AM");
            f1342p = true;
            return true;
        } else if (bp.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pAMS: AM");
            f1342p = true;
            return true;
        } else if (br.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pAM1D: AM");
            f1342p = true;
            return true;
        } else if (bu.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pAM2D: AM");
            f1342p = true;
            return true;
        } else if (bl.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pAM1DDOT: AM");
            f1342p = true;
            return true;
        } else if (bn.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pAM2DDOT: AM");
            f1342p = true;
            return true;
        } else if (bm.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pPM1DDOT: PM");
            f1343q = true;
            return true;
        } else if (bo.matcher(str).matches()) {
            ls.m1345b("hasAMPM: pPM2DDOT: PM");
            f1343q = true;
            return true;
        } else if (str.contains(" morning")) {
            ls.m1345b("hasAMPM: morning");
            f1342p = true;
            return false;
        } else if (str.contains(" afternoon")) {
            ls.m1345b("hasAMPM: afternoon");
            f1343q = true;
            return false;
        } else if (str.contains(" evening")) {
            ls.m1345b("hasAMPM: evening");
            f1343q = true;
            return false;
        } else if (!str.contains(" night")) {
            return false;
        } else {
            ls.m1345b("hasAMPM: night");
            f1343q = true;
            return false;
        }
    }

    private static boolean m1138c(String str) {
        f1341o = false;
        if (!str.contains("all day") && !str.contains("allday")) {
            return false;
        }
        ls.m1345b("isAllDay: TRUE");
        f1341o = true;
        return true;
    }

    private static boolean m1139d(String str) {
        String[] split = str.trim().split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("hour")) {
                String str2 = split[i - 1];
                ls.m1344a("disecth: " + str2);
                try {
                    Integer.parseInt(str2);
                    if (!str.contains("minute")) {
                        ls.m1345b("checkHourMinute: hour");
                        return true;
                    }
                } catch (NumberFormatException e) {
                    ls.m1347d("Number of hours not numeric");
                    return false;
                }
            }
            if (split[i].contains("minute")) {
                String str3 = split[i - 1];
                ls.m1344a("disectm: " + str3);
                try {
                    Integer.parseInt(str3);
                    ls.m1345b("checkHourMinute: hour+minute");
                    return true;
                } catch (NumberFormatException e2) {
                    ls.m1347d("Number of minutes not numeric");
                    return false;
                }
            }
        }
        return false;
    }

    private static void m1140e(String str) {
        f1344r = false;
        f1349w = "";
        String[] strArr = new String[]{""};
        if (bL.matcher(str).matches()) {
            strArr = str.split("called");
        } else if (bQ.matcher(str).matches()) {
            strArr = str.split("call");
        } else if (bP.matcher(str).matches()) {
            strArr = str.split("calls");
        } else if (bM.matcher(str).matches()) {
            strArr = str.split("named");
        } else if (bO.matcher(str).matches()) {
            strArr = str.split("name");
        } else if (bN.matcher(str).matches()) {
            strArr = str.split("names");
        } else if (bR.matcher(str).matches()) {
            strArr = str.split("cold");
        }
        if (strArr.length > 1) {
            ls.m1344a("cs length: " + strArr.length);
            ls.m1344a("cs0: " + strArr[0]);
            ls.m1344a("cs1: " + strArr[1]);
            if (!strArr[1].trim().isEmpty()) {
                f1349w = strArr[1].trim();
                f1344r = true;
            }
        }
    }
}
