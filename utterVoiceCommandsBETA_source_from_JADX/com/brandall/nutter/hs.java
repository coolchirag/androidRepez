package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.faceture.google.play.PropertyConsts;
import com.faceture.google.play.QueryParamConst;
import com.p011a.p012a.C0102b;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import wei.mark.standout.StandOutWindow;
import winterwell.jtwitter.TwitterStream;

public final class hs extends AsyncTask<ArrayList<String>, String, Void> {
    private static ArrayList<String> f1353X;
    public static boolean f1354b = false;
    private ArrayList<String> f1355A = new ArrayList();
    private ArrayList<String> f1356B = new ArrayList();
    private ArrayList<String> f1357C = new ArrayList();
    private ArrayList<String> f1358D = new ArrayList();
    private ArrayList<String> f1359E = new ArrayList();
    private ArrayList<String> f1360F = new ArrayList();
    private ArrayList<String> f1361G = new ArrayList();
    private ArrayList<String> f1362H = new ArrayList();
    private ArrayList<String> f1363I = new ArrayList();
    private ArrayList<String> f1364J = new ArrayList();
    private ArrayList<String> f1365K = new ArrayList();
    private ArrayList<String> f1366L = new ArrayList();
    private ArrayList<String> f1367M = new ArrayList();
    private ArrayList<String> f1368N = new ArrayList();
    private ArrayList<String> f1369O = new ArrayList();
    private ArrayList<String> f1370P = new ArrayList();
    private ArrayList<String> f1371Q = new ArrayList();
    private ArrayList<String> f1372R = new ArrayList();
    private ArrayList<String> f1373S = new ArrayList();
    private ArrayList<String> f1374T = new ArrayList();
    private ArrayList<String> f1375U = new ArrayList();
    private ArrayList<String> f1376V = new ArrayList();
    private ArrayList<String> f1377W = new ArrayList();
    private ArrayList<Integer> f1378Y = new ArrayList();
    private boolean f1379Z = false;
    Context f1380a;
    private boolean aA = false;
    private boolean aB = false;
    private boolean aC = false;
    private boolean aD = false;
    private boolean aE = false;
    private boolean aF = false;
    private boolean aG = false;
    private boolean aH = false;
    private boolean aI = false;
    private boolean aJ = false;
    private boolean aK = false;
    private boolean aL = false;
    private boolean aM = false;
    private boolean aN = false;
    private boolean aO = false;
    private boolean aP = false;
    private boolean aQ = false;
    private boolean aR = false;
    private boolean aS = false;
    private boolean aT = false;
    private boolean aU = false;
    private boolean aV = false;
    private boolean aW = false;
    private boolean aX = false;
    private boolean aY = false;
    private boolean aZ = false;
    private boolean aa = true;
    private boolean ab = false;
    private boolean ac = false;
    private boolean ad = false;
    private boolean ae = false;
    private boolean af = false;
    private boolean ag = false;
    private boolean ah = false;
    private boolean ai = false;
    private boolean aj = false;
    private boolean ak = false;
    private boolean al = false;
    private boolean am = false;
    private boolean an = false;
    private boolean ao = false;
    private boolean ap = false;
    private boolean aq = false;
    private boolean ar = false;
    private boolean as = false;
    private boolean at = false;
    private boolean au = false;
    private boolean av = false;
    private boolean aw = false;
    private boolean ax = false;
    private boolean ay = false;
    private boolean az = false;
    private boolean bA = false;
    private boolean bB = false;
    private boolean bC = false;
    private boolean bD = false;
    private boolean bE = false;
    private boolean bF = false;
    private boolean bG = false;
    private boolean bH = false;
    private boolean bI = false;
    private boolean bJ = false;
    private boolean bK = false;
    private boolean bL = false;
    private boolean bM = false;
    private boolean bN = false;
    private boolean bO = false;
    private boolean bP = false;
    private boolean bQ = false;
    private boolean bR = false;
    private boolean bS = false;
    private boolean bT = false;
    private boolean bU = false;
    private boolean bV = false;
    private boolean bW = false;
    private boolean bX = false;
    private boolean bY = false;
    private boolean bZ = false;
    private boolean ba = false;
    private boolean bb = false;
    private boolean bc = false;
    private boolean bd = false;
    private boolean be = false;
    private boolean bf = false;
    private boolean bg = false;
    private boolean bh = false;
    private boolean bi = false;
    private boolean bj = false;
    private boolean bk = false;
    private boolean bl = false;
    private boolean bm = false;
    private boolean bn = false;
    private boolean bo = false;
    private boolean bp = false;
    private boolean bq = false;
    private boolean br = false;
    private boolean bs = false;
    private boolean bt = false;
    private boolean bu = false;
    private boolean bv = false;
    private boolean bw = false;
    private boolean bx = false;
    private boolean by = false;
    private boolean bz = false;
    long f1381c = 0;
    private boolean cA = false;
    private boolean cB = false;
    private boolean cC = false;
    private boolean cD = false;
    private boolean cE = false;
    private boolean cF = false;
    private boolean cG = false;
    private boolean cH = false;
    private boolean cI = false;
    private boolean cJ = false;
    private boolean cK = false;
    private boolean cL = false;
    private boolean cM = false;
    private boolean cN = false;
    private boolean cO = false;
    private boolean cP = false;
    private boolean cQ = false;
    private boolean cR = false;
    private boolean cS = false;
    private boolean cT = false;
    private boolean cU = false;
    private boolean cV = false;
    private boolean cW = false;
    private boolean cX = false;
    private boolean cY = false;
    private boolean cZ = false;
    private boolean ca = false;
    private boolean cb = false;
    private boolean cc = false;
    private boolean cd = false;
    private boolean ce = false;
    private boolean cf = false;
    private boolean cg = false;
    private boolean ch = false;
    private boolean ci = false;
    private boolean cj = false;
    private boolean ck = false;
    private boolean cl = false;
    private boolean cm = false;
    private boolean cn = false;
    private boolean co = false;
    private boolean cp = false;
    private boolean cq = false;
    private boolean cr = false;
    private boolean cs = false;
    private boolean ct = false;
    private boolean cu = false;
    private boolean cv = false;
    private boolean cw = false;
    private boolean cx = false;
    private boolean cy = false;
    private boolean cz = false;
    private ArrayList<String> f1382d = new ArrayList();
    private String dA = "";
    private String dB = "";
    private String dC = "";
    private String dD = "";
    private String dE = "";
    private String dF = "";
    private int dG = 999;
    private int dH = 0;
    private final String dI = "easter egg";
    private boolean da = false;
    private boolean db = false;
    private boolean dc = false;
    private boolean dd = false;
    private boolean de = false;
    private boolean df = false;
    private Pattern dg = Pattern.compile(".*\\breboot\\b.*");
    private Pattern dh = Pattern.compile(".*\\bweather\\b.*");
    private Pattern di = Pattern.compile(".*\\bin\\b.*");
    private Pattern dj = Pattern.compile(".*\\bgovernor\\b.*");
    private Pattern dk = Pattern.compile(".*\\bgerman\\b.*");
    private Pattern dl = Pattern.compile(".*\\bfrench\\b.*");
    private Pattern dm = Pattern.compile(".*\\bitalian\\b.*");
    private Pattern dn = Pattern.compile(".*\\bpolish\\b.*");
    private Pattern f1383do = Pattern.compile(".*\\bspanish\\b.*");
    private Pattern dp = Pattern.compile(".*\\bromanian\\b.*");
    private String dq = "";
    private String dr = "";
    private String ds = "";
    private String dt = "";
    private String du = "unknown";
    private String dv = "";
    private String dw = "";
    private String dx = "";
    private String dy = "";
    private String dz = "";
    private ArrayList<String> f1384e = new ArrayList();
    private ArrayList<String> f1385f = new ArrayList();
    private ArrayList<String> f1386g = new ArrayList();
    private ArrayList<String> f1387h = new ArrayList();
    private ArrayList<String> f1388i = new ArrayList();
    private ArrayList<String> f1389j = new ArrayList();
    private ArrayList<String> f1390k = new ArrayList();
    private ArrayList<String> f1391l = new ArrayList();
    private ArrayList<String> f1392m = new ArrayList();
    private ArrayList<String> f1393n = new ArrayList();
    private ArrayList<String> f1394o = new ArrayList();
    private ArrayList<String> f1395p = new ArrayList();
    private ArrayList<String> f1396q = new ArrayList();
    private ArrayList<String> f1397r = new ArrayList();
    private ArrayList<String> f1398s = new ArrayList();
    private ArrayList<String> f1399t = new ArrayList();
    private ArrayList<String> f1400u = new ArrayList();
    private ArrayList<String> f1401v = new ArrayList();
    private ArrayList<String> f1402w = new ArrayList();
    private ArrayList<String> f1403x = new ArrayList();
    private ArrayList<String> f1404y = new ArrayList();
    private ArrayList<String> f1405z = new ArrayList();

    public hs(Context context) {
        this.f1380a = context;
    }

    private Void m1142a(ArrayList<String>... arrayListArr) {
        if (hc.f1269b) {
            ls.m1345b("EstablishCommand DIB");
        }
        this.f1381c = System.currentTimeMillis();
        this.f1379Z = GlobalV.aq();
        f1353X = arrayListArr[0];
        if (hc.f1269b) {
            ls.m1344a("ecToProcess: " + f1353X.size() + " : " + f1353X.toString());
        }
        m1144b();
        if (lx.m1374M(this.f1380a)) {
            f1353X = iu.m1184a(this.f1380a, f1353X);
            if (hc.f1269b) {
                ls.m1344a("ecToProcess: " + f1353X.size() + " : " + f1353X.toString());
            }
        }
        if (lx.m1375N(this.f1380a)) {
            f1353X = in.m1180a(this.f1380a, f1353X);
            if (hc.f1269b) {
                ls.m1344a("ecToProcess: " + f1353X.size() + " : " + f1353X.toString());
            }
        }
        if (lx.af(this.f1380a)) {
            this.dF = jk.m1208a(this.f1380a, f1353X);
            if (!this.dF.matches("FALSE")) {
                this.bG = true;
                this.dG = 777;
                if (hc.f1269b) {
                    ls.m1346c("userCommandFound: true : recog : " + f1354b);
                }
            } else if (this.dF.matches("FALSE")) {
                this.dF = "";
            }
        }
        if (!this.bG) {
            String trim;
            String replaceFirst;
            String[] split;
            this.dE = (String) f1353X.get(0);
            ListIterator listIterator = f1353X.listIterator();
            Locale locale = Locale.US;
            while (listIterator.hasNext()) {
                String[] split2;
                double[] b;
                trim = ((String) listIterator.next()).toString().toLowerCase(locale).trim();
                if (hc.f1269b) {
                    ls.m1344a("rawpass: " + trim);
                }
                if (trim.contains("easter egg")) {
                    if (hc.f1269b) {
                        ls.m1346c("EasterEgg " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(73));
                }
                if (gy.aj(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("toCancel: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(74));
                }
                if (gy.m1045p(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isHelp: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(2));
                }
                if (gy.m1044o(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isHeadsetCommand: " + trim);
                    }
                    if (trim.contains("control")) {
                        this.f1378Y.add(Integer.valueOf(3));
                    } else if (trim.contains("release")) {
                        this.f1378Y.add(Integer.valueOf(4));
                    }
                }
                if (gy.m1043n(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isParkedCarCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(5));
                }
                if (gy.m1046q(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isLinkAppCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(6));
                }
                if (gy.m1047r(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isVisualCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(7));
                }
                if (gy.m1048s(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isEditCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(8));
                    if (trim.contains("screenshot") || trim.contains("screen shot")) {
                        this.dc = true;
                    } else if (trim.contains("screenshot") || trim.contains("screen shot")) {
                        this.db = true;
                    }
                }
                if (gy.m1049t(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isFilmCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(9));
                    replaceFirst = trim.replaceFirst("search for the film ", "").replaceFirst("search for film ", "").replaceFirst("search the film ", "").replaceFirst("search for the movie ", "").replaceFirst("search for movie ", "").replaceFirst("search the movie ", "").replaceFirst("search films for ", "").replaceFirst("search films ", "").replaceFirst("search movies for ", "").replaceFirst("search movies ", "");
                    if (trim.matches(replaceFirst)) {
                        replaceFirst = replaceFirst.replaceFirst("search ", "").replaceFirst("movies ", "").replaceFirst("movie ", "").replaceFirst("films ", "").replaceFirst("film ", "");
                    }
                    this.dB = replaceFirst.trim().replaceAll(" +", " ").trim().replaceAll("\\s", "\\%20");
                }
                if (gy.m1050u(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isVoiceNoteCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(10));
                }
                if (gy.m1051v(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isNoteCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(11));
                }
                if (gy.m1052w(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isUploadCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(12));
                }
                if (gy.m1053x(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isCalculateCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(13));
                    this.f1382d.add(trim);
                }
                if (gy.m1054y(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isToastCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(14));
                }
                if (gy.m1055z(trim)) {
                    if (hc.f1269b) {
                        ls.m1344a("isknowledgeCommand: " + trim);
                    }
                    this.f1378Y.add(Integer.valueOf(15));
                    split = trim.split("question ");
                    if (hc.f1269b) {
                        ls.m1344a("raw: " + split.length);
                    }
                    if (split.length > 1) {
                        String trim2;
                        replaceFirst = split[1].trim();
                        this.f1385f.add(replaceFirst);
                        replaceFirst = replaceFirst.replaceAll(" ", "%20").trim();
                        this.f1387h.add("http://api.wolframalpha.com/v2/query?appid=RRTVWX-G83L2WJT2X&input=" + replaceFirst + "&format=plaintext&podindex=1,2,3&parsetimeout=2&scantimeout=.5&formattimeout=1");
                        if (gy.m1014K(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isDefineCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(16));
                            if (replaceFirst.startsWith("define existentialism")) {
                                this.f1385f.add(replaceFirst);
                                replaceFirst = replaceFirst.replaceAll(" ", "%20").trim();
                                this.f1387h.add("http://api.wolframalpha.com/v2/query?appid=RRTVWX-G83L2WJT2X&input=" + replaceFirst + "&format=plaintext&podindex=1,2,3&parsetimeout=2&scantimeout=.5&formattimeout=1");
                            } else {
                                replaceFirst = replaceFirst.replaceAll(" ", "%20").trim();
                                this.f1387h.add("http://api.wolframalpha.com/v2/query?appid=RRTVWX-G83L2WJT2X&input=" + replaceFirst + "&format=plaintext&podindex=1,2,3&parsetimeout=2&scantimeout=.5&formattimeout=1");
                                this.f1387h.add("define existentialism");
                            }
                        }
                        if (gy.m1013J(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isSpellCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(17));
                            if (this.f1388i.isEmpty()) {
                                new String[1][0] = "";
                                if (replaceFirst.startsWith("spell ")) {
                                    split2 = replaceFirst.split("how do you spell ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                } else {
                                    split2 = replaceFirst.split("spell ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                }
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim();
                                    this.f1388i.add(replaceFirst);
                                    replaceFirst = replaceFirst.replaceAll(".(?=.)", "$0 ").trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    this.f1388i.add(replaceFirst);
                                }
                            }
                        }
                        if (gy.m1012I(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isDirectoryCommand: " + replaceFirst);
                            }
                            trim = replaceFirst.replaceFirst(" a ", " ");
                            split = new String[]{""};
                            if (trim.startsWith("browse subdirectory ")) {
                                split = trim.split("browse subdirectory ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split.length);
                                }
                                this.f1378Y.add(Integer.valueOf(75));
                            } else if (trim.startsWith("browse sub directory ")) {
                                split = trim.split("browse sub directory ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split.length);
                                }
                                this.f1378Y.add(Integer.valueOf(75));
                            } else if (trim.startsWith("browse sup directory ")) {
                                split = trim.split("browse sup directory ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split.length);
                                }
                                this.f1378Y.add(Integer.valueOf(75));
                            } else if (trim.startsWith("browse directory ")) {
                                split = trim.split("browse directory ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split.length);
                                }
                            }
                            if (split.length <= 1) {
                                replaceFirst = split[1].trim();
                                if (hc.f1269b) {
                                    ls.m1344a("rawpass: " + replaceFirst);
                                }
                                if (!this.f1389j.contains(replaceFirst)) {
                                    if (this.f1378Y.contains(Integer.valueOf(75))) {
                                        this.f1389j.add(replaceFirst);
                                        this.f1378Y.add(Integer.valueOf(18));
                                    } else if (this.f1389j.size() < 6) {
                                        this.f1389j.add(replaceFirst);
                                    }
                                }
                            } else {
                                replaceFirst = trim;
                            }
                        }
                        if (gy.m1011H(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isShowCommand: " + replaceFirst);
                            }
                            if (replaceFirst.contains("result")) {
                                this.bz = true;
                            }
                            this.f1378Y.add(Integer.valueOf(19));
                        }
                        if (gy.m1009F(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isAlarmCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(20));
                            this.f1374T.add(replaceFirst);
                        }
                        if (gy.m1010G(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isCalendarCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(21));
                            this.f1360F.add(replaceFirst);
                        }
                        if (gy.m1008E(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isNavigateCommand: " + replaceFirst);
                            }
                            if (!this.f1378Y.contains(Integer.valueOf(22))) {
                                replaceFirst = replaceFirst.replace("navigate to ", "").replaceFirst("navigate ", "").trim().replaceAll("\\s", "\\+");
                                this.dA = replaceFirst.trim();
                            }
                            this.f1378Y.add(Integer.valueOf(22));
                        }
                        if (gy.m1006C(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isLocateCarCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(23));
                        }
                        if (gy.m1005B(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isPlayMusicCommand: " + replaceFirst);
                            }
                            split2 = replaceFirst.split("play ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                            if (split2.length > 1) {
                                replaceFirst = split2[1].trim();
                                this.f1378Y.add(Integer.valueOf(24));
                                if (this.f1390k.size() < 6) {
                                    this.f1390k.add(replaceFirst);
                                }
                            }
                        }
                        if (gy.m1015L(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("iseBayCommand: " + replaceFirst);
                            }
                            if (!this.f1378Y.contains(Integer.valueOf(25))) {
                                replaceFirst = replaceFirst.replaceFirst("search ebay", "").trim();
                                if (replaceFirst.startsWith("for")) {
                                    replaceFirst = replaceFirst.replaceFirst("for", "").trim();
                                }
                                replaceFirst = replaceFirst.trim().replaceAll(" +", " ");
                                this.dC = replaceFirst.trim().replaceAll("\\s", "\\%20");
                            }
                            this.f1378Y.add(Integer.valueOf(25));
                        }
                        if (gy.m1016M(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isTranslateCommand: " + replaceFirst);
                            }
                            if (!this.f1378Y.contains(Integer.valueOf(26))) {
                                split2 = new String[]{""};
                                if (this.dk.matcher(replaceFirst).matches()) {
                                    this.cV = true;
                                    split2 = replaceFirst.split("german ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                } else if (this.dl.matcher(replaceFirst).matches()) {
                                    this.cW = true;
                                    split2 = replaceFirst.split("french ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                } else if (this.dm.matcher(replaceFirst).matches()) {
                                    this.cX = true;
                                    split2 = replaceFirst.split("italian ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                } else if (this.f1383do.matcher(replaceFirst).matches()) {
                                    this.cZ = true;
                                    split2 = replaceFirst.split("spanish ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                } else if (this.dn.matcher(replaceFirst).matches()) {
                                    this.cY = true;
                                    split2 = replaceFirst.split("polish ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                } else if (this.dp.matcher(replaceFirst).matches()) {
                                    this.da = true;
                                    split2 = replaceFirst.split("romanian ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                }
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    this.f1391l.add(replaceFirst);
                                }
                            }
                            this.f1378Y.add(Integer.valueOf(26));
                        }
                        if (gy.m1017N(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isCreateCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(27));
                        }
                        if (gy.m1019P(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isJoke: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(28));
                        }
                        if (gy.m1020Q(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isMD5: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(29));
                        }
                        if (gy.m1021R(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isZip: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(30));
                            if (!replaceFirst.contains("screenshot") || replaceFirst.contains("screen shot")) {
                                this.de = true;
                            } else if (replaceFirst.contains("image") || replaceFirst.contains("picture")) {
                                this.dd = true;
                            }
                        }
                        if (gy.m1022S(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isScreenShot: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(31));
                        }
                        if (gy.m1024U(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isGoTo: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(32));
                            this.f1392m.add(replaceFirst);
                        }
                        if (gy.m1023T(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isWhere: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(33));
                        }
                        if (gy.an(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isDate: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(103));
                        }
                        if (gy.m1026W(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isSMS: " + replaceFirst);
                            }
                            split2 = replaceFirst.split("text ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                            if (split2.length > 1) {
                                replaceFirst = split2[1].trim();
                                if (hc.f1269b) {
                                    ls.m1344a("rawpass: " + replaceFirst);
                                }
                                this.f1378Y.add(Integer.valueOf(34));
                                if (!this.f1393n.contains(replaceFirst)) {
                                    if (hc.f1269b) {
                                        ls.m1344a("toSMS: " + replaceFirst);
                                    }
                                    this.f1393n.add(replaceFirst);
                                }
                            }
                        }
                        if (gy.m1025V(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isEmail: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(35));
                            replaceFirst = replaceFirst.replaceAll("\\bemail\\b\\s*", "").trim().replaceAll("\\be-mail\\b\\s*", "").trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst.toString());
                            }
                            if (!this.f1394o.contains(replaceFirst)) {
                                if (hc.f1269b) {
                                    ls.m1344a("toEmail: " + replaceFirst);
                                }
                                this.f1394o.add(replaceFirst);
                            }
                        }
                        if (gy.ap(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isConnection: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(36));
                            this.f1395p.add(replaceFirst);
                        }
                        if (gy.m1027X(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isSkype: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(37));
                            replaceFirst = replaceFirst.replaceAll("\\bskype\\b\\s*", "").trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst.toString());
                            }
                            if (!this.f1396q.contains(replaceFirst)) {
                                if (hc.f1269b) {
                                    ls.m1344a("toSkype: " + replaceFirst);
                                }
                                this.f1396q.add(replaceFirst);
                            }
                        }
                        if (gy.m1028Y(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isKill: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(38));
                            if (replaceFirst.startsWith("kill ")) {
                                if (replaceFirst.contains(" app ")) {
                                    replaceFirst = replaceFirst.replace(" app ", " ");
                                }
                                if (replaceFirst.contains("application")) {
                                    replaceFirst = replaceFirst.replace("application", "");
                                }
                                if (replaceFirst.contains("google plus")) {
                                    if (hc.f1269b) {
                                        ls.m1344a("replacing google plus: " + replaceFirst);
                                    }
                                    replaceFirst = replaceFirst.replace("google plus", "google+");
                                    if (hc.f1269b) {
                                        ls.m1344a("replaced google+: " + replaceFirst);
                                    }
                                } else if (replaceFirst.contains("play store")) {
                                    if (hc.f1269b) {
                                        ls.m1344a("replacing play store: " + replaceFirst);
                                    }
                                    replaceFirst = replaceFirst.replace("play store", "google play store");
                                    if (hc.f1269b) {
                                        ls.m1344a("replaced google play store: " + replaceFirst);
                                    }
                                }
                                split2 = replaceFirst.split("kill ");
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    if (!this.f1397r.contains(replaceFirst)) {
                                        if (hc.f1269b) {
                                            ls.m1344a("toKill: " + replaceFirst);
                                        }
                                        this.f1397r.add(replaceFirst);
                                    }
                                }
                            } else if (replaceFirst.startsWith("kill app ")) {
                                split2 = replaceFirst.split(" app ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split2.length);
                                }
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    if (!this.f1397r.contains(replaceFirst)) {
                                        if (hc.f1269b) {
                                            ls.m1344a("toKill: " + replaceFirst);
                                        }
                                        this.f1397r.add(replaceFirst);
                                    }
                                }
                            }
                        }
                        if (gy.ab(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isForeground: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(39));
                        }
                        if (gy.m1029Z(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isClipboard: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(40));
                        }
                        if (gy.ai(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toRinger: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(41));
                            if (replaceFirst.contains("vibrate")) {
                                this.aF = true;
                            } else if (replaceFirst.contains("silent")) {
                                this.aE = true;
                            } else if (replaceFirst.contains("normal")) {
                                this.aD = true;
                            }
                        }
                        if (gy.ag(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isShakeSetting: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(42));
                            if (this.f1398s.isEmpty()) {
                                if (replaceFirst.startsWith("enable shake")) {
                                    this.dv = "on";
                                    this.f1398s.add(replaceFirst);
                                } else if (replaceFirst.startsWith("disable shake")) {
                                    this.dv = "off";
                                    this.f1398s.add(replaceFirst);
                                } else if (replaceFirst.contains("very low")) {
                                    this.dv = "vlow";
                                    this.f1398s.add(replaceFirst);
                                } else if (replaceFirst.contains("very high")) {
                                    this.dv = "vhigh";
                                    this.f1398s.add(replaceFirst);
                                } else if (replaceFirst.contains(" low")) {
                                    this.dv = "low";
                                    this.f1398s.add(replaceFirst);
                                } else if (replaceFirst.contains(" medium")) {
                                    this.dv = "medium";
                                    this.f1398s.add(replaceFirst);
                                } else if (replaceFirst.contains(" high")) {
                                    this.dv = "high";
                                    this.f1398s.add(replaceFirst);
                                }
                            }
                        }
                        if (gy.ah(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isWaveSetting: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(43));
                            if (this.f1399t.isEmpty()) {
                                if (replaceFirst.startsWith("enable wave")) {
                                    this.dw = "on";
                                    this.f1399t.add(replaceFirst);
                                } else if (replaceFirst.startsWith("disable wave")) {
                                    this.dw = "off";
                                    this.f1399t.add(replaceFirst);
                                }
                            }
                        }
                        if (gy.af(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isUserName: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(44));
                            if (this.f1400u.isEmpty()) {
                                split2 = replaceFirst.split("call me ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split2.length);
                                }
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    this.dx = "";
                                    if (io.m1181a(replaceFirst)) {
                                        this.dx = "I don't really think I should, but you're the boss, ";
                                    }
                                    this.f1400u.add(replaceFirst);
                                }
                            }
                        }
                        if (gy.m1030a(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toSettings: " + replaceFirst);
                            }
                            if (!this.f1378Y.contains(Integer.valueOf(45))) {
                                if (replaceFirst.startsWith("wifi settings")) {
                                    this.cr = true;
                                }
                                if (replaceFirst.startsWith("bluetooth settings")) {
                                    this.ct = true;
                                }
                                if (replaceFirst.startsWith("data settings")) {
                                    this.cq = true;
                                }
                                if (replaceFirst.startsWith("time settings") || replaceFirst.startsWith("date settings")) {
                                    this.cs = true;
                                }
                                if (replaceFirst.startsWith("voice search settings")) {
                                    this.cv = true;
                                }
                                if (replaceFirst.startsWith("tts settings") || replaceFirst.startsWith("text to speech settings") || replaceFirst.startsWith("t t s settings")) {
                                    this.cu = true;
                                }
                                if (replaceFirst.startsWith("apn settings") || replaceFirst.startsWith("a p n settings")) {
                                    this.cy = true;
                                }
                                if (replaceFirst.startsWith("accessibility settings")) {
                                    this.cw = true;
                                }
                                if (replaceFirst.startsWith("application settings")) {
                                    replaceFirst = replaceFirst.replaceFirst("application settings", "").trim().replaceFirst("application setting", "").trim();
                                    if (replaceFirst.length() > 3) {
                                        this.df = true;
                                        this.f1384e.add(replaceFirst);
                                    }
                                    this.cx = true;
                                }
                                if (replaceFirst.startsWith("device settings")) {
                                    this.cz = true;
                                }
                                if (replaceFirst.startsWith("locale settings")) {
                                    this.cE = true;
                                }
                                if (replaceFirst.startsWith("display settings")) {
                                    this.cB = true;
                                }
                                if (replaceFirst.startsWith("input settings")) {
                                    this.cC = true;
                                }
                                if (replaceFirst.startsWith("location settings")) {
                                    this.cA = true;
                                }
                                if (replaceFirst.startsWith("storage settings")) {
                                    this.cD = true;
                                }
                                if (replaceFirst.startsWith("memory card settings") || replaceFirst.startsWith("storage card settings") || replaceFirst.startsWith("sd card settings") || replaceFirst.startsWith("s d card settings")) {
                                    this.cG = true;
                                }
                                if (replaceFirst.startsWith("network operator settings")) {
                                    this.cH = true;
                                }
                                if (replaceFirst.startsWith("nfc settings") || replaceFirst.startsWith("n f c settings")) {
                                    this.cI = true;
                                }
                                if (replaceFirst.startsWith("privacy settings")) {
                                    this.cJ = true;
                                }
                                if (replaceFirst.startsWith("quick launch settings")) {
                                    this.cK = true;
                                }
                                if (replaceFirst.matches("settings")) {
                                    this.cF = true;
                                }
                                if (replaceFirst.startsWith("search settings")) {
                                    this.cO = true;
                                }
                                if (replaceFirst.startsWith("sound settings") || replaceFirst.startsWith("volume settings")) {
                                    this.cL = true;
                                }
                                if (replaceFirst.startsWith("sync settings") || replaceFirst.startsWith("sink settings")) {
                                    this.cM = true;
                                }
                                if (replaceFirst.startsWith("dictionary settings")) {
                                    this.cN = true;
                                }
                            }
                            this.f1378Y.add(Integer.valueOf(45));
                        }
                        if (gy.am(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("found Time: " + replaceFirst);
                            }
                            replaceFirst = replaceFirst.replaceAll("\\p{P}+", "");
                            if (!replaceFirst.contains(" time in ") || replaceFirst.contains(" time is it in ")) {
                                if (hc.f1269b) {
                                    ls.m1344a("found Time In: " + replaceFirst);
                                }
                                if (!replaceFirst.endsWith(" time in") || replaceFirst.endsWith(" time is it in")) {
                                    this.f1364J.add(replaceFirst);
                                    this.f1378Y.add(Integer.valueOf(46));
                                } else {
                                    this.f1378Y.add(Integer.valueOf(47));
                                    split2 = replaceFirst.split(" in ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                    if (split2.length > 1) {
                                        replaceFirst = split2[1].trim();
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass: " + replaceFirst);
                                        }
                                        split2 = replaceFirst.split("\\s+");
                                        if (split2.length > 1) {
                                            if (hc.f1269b) {
                                                ls.m1345b("cc length: " + split2.length);
                                            }
                                            replaceFirst = new StringBuilder(String.valueOf(split2[0].trim())).append(" ").append(split2[1].trim()).toString();
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass stitch: " + replaceFirst);
                                            }
                                            if (!this.f1365K.contains(replaceFirst)) {
                                                this.f1365K.add(replaceFirst);
                                                if (this.f1366L.size() < 5) {
                                                    trim2 = split2[0].trim();
                                                    trim = split2[1].trim();
                                                    if (hc.f1269b) {
                                                        ls.m1346c("ci: " + trim2);
                                                        ls.m1346c("co: " + trim);
                                                    }
                                                    this.f1366L.add("http://www.worldweatheronline.com/feed/tz.ashx?key=2d4d79850a094859122004&q=" + trim2 + "," + trim + "&format=xml");
                                                }
                                            }
                                        }
                                    } else {
                                        if (hc.f1269b) {
                                            ls.m1344a("Short toTime: " + replaceFirst);
                                        }
                                        if (!this.f1364J.contains(replaceFirst)) {
                                            this.f1364J.add(replaceFirst);
                                            this.f1378Y.add(Integer.valueOf(46));
                                        }
                                    }
                                }
                            } else {
                                if (hc.f1269b) {
                                    ls.m1344a("toTime: " + replaceFirst);
                                }
                                this.f1364J.add(replaceFirst);
                                this.f1378Y.add(Integer.valueOf(46));
                            }
                        }
                        if (gy.aq(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("found Call: " + replaceFirst);
                            }
                            replaceFirst = replaceFirst.replaceAll("\\bcall\\b\\s*", "").trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst);
                            }
                            trim = this.dE.replaceAll("\\bcall\\b\\s*", "").trim().replaceAll("o", QueryParamConst.U_VALUE);
                            if (trim.matches("[0-9 ]+")) {
                                if (hc.f1269b) {
                                    ls.m1344a("not temp: " + trim);
                                }
                                this.f1378Y.add(Integer.valueOf(48));
                                if (!replaceFirst.endsWith(" home") || replaceFirst.endsWith(" work") || replaceFirst.endsWith(" mobile") || replaceFirst.endsWith(" office")) {
                                    if (replaceFirst.endsWith(" home")) {
                                        if (hc.f1269b) {
                                            ls.m1345b("ends with home: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceAll("\\bhome\\b\\s*", "").trim();
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass: " + replaceFirst.toString());
                                        }
                                        this.ap = true;
                                    }
                                    if (replaceFirst.endsWith("work") || replaceFirst.endsWith("office")) {
                                        if (hc.f1269b) {
                                            ls.m1345b("ends with work: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceAll("\\bwork\\b\\s*", "").trim().replaceAll("\\boffice\\b\\s*", "").trim();
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass: " + replaceFirst.toString());
                                        }
                                        this.aq = true;
                                    }
                                    if (replaceFirst.endsWith("mobile")) {
                                        if (hc.f1269b) {
                                            ls.m1345b("ends with mobile: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceAll("\\bmobile\\b\\s*", "").trim();
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass: " + replaceFirst.toString());
                                        }
                                        this.ar = true;
                                    }
                                    if (!this.f1401v.contains(replaceFirst)) {
                                        if (hc.f1269b) {
                                            ls.m1344a("toCall: " + replaceFirst);
                                        }
                                        this.f1401v.add(replaceFirst);
                                    }
                                } else if (this.f1401v.isEmpty() && !this.f1402w.contains(replaceFirst)) {
                                    if (hc.f1269b) {
                                        ls.m1345b("toCallI: " + replaceFirst);
                                    }
                                    this.f1402w.add(replaceFirst);
                                }
                            } else {
                                if (hc.f1269b) {
                                    ls.m1344a("temp: " + trim);
                                }
                                this.f1378Y.add(Integer.valueOf(114));
                            }
                        }
                        if (gy.ar(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toSuperUser: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(52));
                            if (this.dg.matcher(replaceFirst).matches() || this.dj.matcher(replaceFirst).matches()) {
                                if (hc.f1269b) {
                                    ls.m1344a("toRoot: " + replaceFirst);
                                }
                                this.f1403x.add(replaceFirst);
                            }
                        }
                        if (gy.as(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toDisplayC: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(1));
                            replaceFirst = replaceFirst.replaceAll("\\bthe\\b\\s*", "").trim().replaceAll("\\bdisplay\\b\\s*", "").trim().replaceAll("\\bcontacts\\b\\s*", "").trim().replaceAll("\\bcontact\\b\\s*", "").trim().replaceAll("\\bshow me\\b\\s*", "").trim().replaceAll("\\bshow\\b\\s*", "").trim();
                            if (!this.f1404y.contains(replaceFirst)) {
                                this.f1404y.add(replaceFirst);
                            }
                        }
                        if (gy.at(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toTasker: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(53));
                            split2 = null;
                            if (replaceFirst.startsWith("display task")) {
                                this.aJ = true;
                            } else if (replaceFirst.startsWith("run task ") || replaceFirst.startsWith("execute task ")) {
                                if (replaceFirst.startsWith("run task ")) {
                                    split2 = replaceFirst.split("run task ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                } else if (replaceFirst.startsWith("execute task ")) {
                                    split2 = replaceFirst.split("execute task ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                }
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim().replaceAll(" ", "").trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    if (!this.f1405z.contains(replaceFirst)) {
                                        this.f1405z.add(replaceFirst);
                                    }
                                }
                            }
                        }
                        if (gy.au(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toFacebook: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(55));
                        }
                        if (gy.ad(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toDeveloperPassword: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(56));
                            if (replaceFirst.contains(" judgement day") || replaceFirst.contains(" judgment day")) {
                                this.aL = true;
                            }
                        }
                        if (gy.av(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toTwitter: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(57));
                            replaceFirst = replaceFirst.replaceFirst("tweet ", "").trim();
                            this.f1355A.add(replaceFirst);
                        }
                        if (gy.aw(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toWeather: " + replaceFirst);
                            }
                            replaceFirst = replaceFirst.replaceAll("\\p{P}+", "");
                            if (!this.dh.matcher(replaceFirst).matches() && this.di.matcher(replaceFirst).matches()) {
                                if (hc.f1269b) {
                                    ls.m1344a("found weather In: " + replaceFirst);
                                }
                                this.f1378Y.add(Integer.valueOf(59));
                                split2 = replaceFirst.split("in ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split2.length);
                                }
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    split2 = replaceFirst.split("\\s+");
                                    if (split2.length > 1) {
                                        if (hc.f1269b) {
                                            ls.m1345b("cc length: " + split2.length);
                                        }
                                        replaceFirst = new StringBuilder(String.valueOf(split2[0].trim())).append(" ").append(split2[1].trim()).toString();
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass stitch: " + replaceFirst);
                                        }
                                        if (!this.f1367M.contains(replaceFirst)) {
                                            this.f1367M.add(replaceFirst);
                                            if (this.f1368N.size() < 5) {
                                                trim2 = split2[0].trim();
                                                trim = split2[1].trim();
                                                if (hc.f1269b) {
                                                    ls.m1346c("ci: " + trim2);
                                                    ls.m1346c("co: " + trim);
                                                }
                                                this.f1368N.add("http://free.worldweatheronline.com/feed/weather.ashx?key=2d4d79850a094859122004&q=" + trim2 + "," + trim + "&format=xml&format=xml&num_of_days=1");
                                            }
                                        }
                                    }
                                }
                            } else if (this.f1367M.isEmpty()) {
                                this.f1378Y.add(Integer.valueOf(58));
                                try {
                                    b = ik.m1176b(this.f1380a);
                                } catch (Exception e) {
                                    if (hc.f1269b) {
                                        ls.m1348e("gps Exception: " + e.toString());
                                    }
                                    b = null;
                                }
                                if (b != null || b.length <= 1) {
                                    this.dF = "Sorry, something went wrong accessing your location data.";
                                } else if (this.f1368N.isEmpty()) {
                                    trim2 = String.valueOf(b[0]);
                                    trim = String.valueOf(b[1]);
                                    if (hc.f1269b) {
                                        ls.m1344a("myLat: " + trim2 + " myLon: " + trim);
                                    }
                                    this.f1368N.add("http://free.worldweatheronline.com/feed/weather.ashx?key=2d4d79850a094859122004&q=" + trim2 + "," + trim + "&format=xml&num_of_days=1");
                                }
                            } else if (hc.f1269b) {
                                ls.m1345b("Ignorning as commandWeatherIn is set:" + replaceFirst);
                            }
                        }
                        if (gy.ao(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toSearch: " + replaceFirst);
                            }
                            if (!replaceFirst.startsWith("search ") && (replaceFirst.contains("image") || replaceFirst.contains("picture"))) {
                                if (replaceFirst.contains("picture")) {
                                    split2 = replaceFirst.split("picture");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                    if (split2.length > 1) {
                                        replaceFirst = split2[1].trim();
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass: " + replaceFirst);
                                        }
                                        if (replaceFirst.startsWith("s ")) {
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass starts with S: " + replaceFirst);
                                            }
                                            replaceFirst = replaceFirst.replaceFirst("s ", "");
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass replaced S: " + replaceFirst);
                                            }
                                            replaceFirst.trim();
                                        }
                                        if (replaceFirst.startsWith("of ")) {
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass starts with OF: " + replaceFirst);
                                            }
                                            replaceFirst = replaceFirst.replaceFirst("of ", "");
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass replaced OF: " + replaceFirst);
                                            }
                                            replaceFirst.trim();
                                        }
                                        if (replaceFirst.startsWith("for ")) {
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass starts with FOR: " + replaceFirst);
                                            }
                                            replaceFirst = replaceFirst.replaceFirst("for ", "");
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass replaced for: " + replaceFirst);
                                            }
                                            replaceFirst.trim();
                                        }
                                        if (replaceFirst.startsWith("4 ")) {
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass starts with 4: " + replaceFirst);
                                            }
                                            replaceFirst = replaceFirst.replaceFirst("4 ", "");
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass replaced 4: " + replaceFirst);
                                            }
                                            replaceFirst.trim();
                                        }
                                    }
                                } else if (replaceFirst.contains("image")) {
                                    split2 = replaceFirst.split("image");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                    if (split2.length > 1) {
                                        replaceFirst = split2[1].trim();
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass: " + replaceFirst);
                                        }
                                        if (replaceFirst.startsWith("s ")) {
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass starts with S: " + replaceFirst);
                                            }
                                            replaceFirst = replaceFirst.replaceFirst("s ", "");
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass replaced S: " + replaceFirst);
                                            }
                                            replaceFirst.trim();
                                        }
                                        if (replaceFirst.startsWith("of ")) {
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass starts with OF: " + replaceFirst);
                                            }
                                            replaceFirst = replaceFirst.replaceFirst("of ", "");
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass replaced OF: " + replaceFirst);
                                            }
                                            replaceFirst.trim();
                                        }
                                        if (replaceFirst.startsWith("for ")) {
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass starts with FOR: " + replaceFirst);
                                            }
                                            replaceFirst = replaceFirst.replaceFirst("for ", "");
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass replaced for: " + replaceFirst);
                                            }
                                            replaceFirst.trim();
                                        }
                                        if (replaceFirst.startsWith("4 ")) {
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass starts with 4: " + replaceFirst);
                                            }
                                            replaceFirst = replaceFirst.replaceFirst("4 ", "");
                                            if (hc.f1269b) {
                                                ls.m1344a("rawpass replaced 4: " + replaceFirst);
                                            }
                                            replaceFirst.trim();
                                        }
                                    }
                                }
                                if (!this.f1356B.contains(replaceFirst)) {
                                    this.f1356B.add(replaceFirst);
                                    this.f1378Y.add(Integer.valueOf(60));
                                }
                            } else if (!replaceFirst.startsWith("search ") && replaceFirst.contains("video")) {
                                split2 = replaceFirst.split("video");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split2.length);
                                }
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    if (replaceFirst.startsWith("s ")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass starts with S: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("s ", "");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced S: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    }
                                    if (replaceFirst.startsWith("of ")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass starts with OF: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("of ", "");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced OF: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    }
                                    if (replaceFirst.contains("sassy bob")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass contains sassy bob: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("sassy bob", "SassiBob");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced with SassiBob: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    } else if (replaceFirst.contains("sassy bar")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass contains sassy bar: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("sassy bar", "SassiBob");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced with SassiBob: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    } else if (replaceFirst.contains("sassy park")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass contains sassy park: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("sassy park", "SassiBob");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced with SassiBob: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    } else if (replaceFirst.contains("sassy box")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass contains sassy box: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("sassy box", "SassiBob");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced with SassiBob: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    }
                                }
                                if (!this.f1356B.contains(replaceFirst)) {
                                    this.f1356B.add(replaceFirst);
                                    this.f1378Y.add(Integer.valueOf(61));
                                }
                            } else if (this.f1378Y.contains(Integer.valueOf(62)) && !this.f1378Y.contains(Integer.valueOf(63)) && !this.f1378Y.contains(Integer.valueOf(60)) && !this.f1378Y.contains(Integer.valueOf(61)) && replaceFirst.startsWith("search google ")) {
                                split2 = replaceFirst.split("search google ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split2.length);
                                }
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    if (replaceFirst.startsWith("for ")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass starts with FOR: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("for ", "");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced FOR: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    }
                                    if (replaceFirst.startsWith("4 ")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass starts with 4: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("4 ", "");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced 4: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    }
                                    if (!this.f1356B.contains(replaceFirst)) {
                                        if (hc.f1269b) {
                                            ls.m1344a("toSearch: " + replaceFirst);
                                        }
                                        this.f1356B.add(replaceFirst);
                                        this.f1378Y.add(Integer.valueOf(64));
                                    }
                                }
                            } else if (this.f1378Y.contains(Integer.valueOf(64)) && !this.f1378Y.contains(Integer.valueOf(63)) && !this.f1378Y.contains(Integer.valueOf(60)) && !this.f1378Y.contains(Integer.valueOf(61)) && replaceFirst.startsWith("search bing ")) {
                                split2 = replaceFirst.split("search bing ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split2.length);
                                }
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    if (replaceFirst.startsWith("for ")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass starts with FOR: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("for ", "");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced FOR: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    }
                                    if (replaceFirst.startsWith("4 ")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass starts with 4: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("4 ", "");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced 4: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    }
                                    if (!this.f1356B.contains(replaceFirst)) {
                                        if (hc.f1269b) {
                                            ls.m1344a("toSearch: " + replaceFirst);
                                        }
                                        this.f1356B.add(replaceFirst);
                                        this.f1378Y.add(Integer.valueOf(62));
                                    }
                                }
                            } else if (!(this.f1378Y.contains(Integer.valueOf(62)) || this.f1378Y.contains(Integer.valueOf(64)) || this.f1378Y.contains(Integer.valueOf(60)) || this.f1378Y.contains(Integer.valueOf(61)) || !replaceFirst.startsWith("search yahoo "))) {
                                split2 = replaceFirst.split("search yahoo ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split2.length);
                                }
                                if (split2.length > 1) {
                                    replaceFirst = split2[1].trim();
                                    if (hc.f1269b) {
                                        ls.m1344a("rawpass: " + replaceFirst);
                                    }
                                    if (replaceFirst.startsWith("for ")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass starts with FOR: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("for ", "");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced FOR: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    }
                                    if (replaceFirst.startsWith("4 ")) {
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass starts with 4: " + replaceFirst);
                                        }
                                        replaceFirst = replaceFirst.replaceFirst("4 ", "");
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass replaced 4: " + replaceFirst);
                                        }
                                        replaceFirst.trim();
                                    }
                                    if (!this.f1356B.contains(replaceFirst)) {
                                        if (hc.f1269b) {
                                            ls.m1344a("toSearch: " + replaceFirst);
                                        }
                                        this.f1356B.add(replaceFirst);
                                        this.f1378Y.add(Integer.valueOf(63));
                                    }
                                }
                            }
                        }
                        if (gy.al(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toApp: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(65));
                            if (replaceFirst.startsWith("open ") || replaceFirst.startsWith("load ") || replaceFirst.startsWith("launch ")) {
                                if (replaceFirst.contains(" app ")) {
                                    replaceFirst = replaceFirst.replace(" app ", " ");
                                }
                                if (replaceFirst.contains("application")) {
                                    replaceFirst = replaceFirst.replace("application", "");
                                }
                                if (replaceFirst.contains("google plus")) {
                                    if (hc.f1269b) {
                                        ls.m1344a("replacing google plus: " + replaceFirst);
                                    }
                                    replaceFirst = replaceFirst.replace("google plus", "google+");
                                    if (hc.f1269b) {
                                        ls.m1344a("replaced google+: " + replaceFirst);
                                    }
                                } else if (replaceFirst.contains("play store")) {
                                    if (hc.f1269b) {
                                        ls.m1344a("replacing play store: " + replaceFirst);
                                    }
                                    replaceFirst = replaceFirst.replace("play store", "google play store");
                                    if (hc.f1269b) {
                                        ls.m1344a("replaced google play store: " + replaceFirst);
                                    }
                                }
                                if (replaceFirst.startsWith("open ")) {
                                    split2 = replaceFirst.split("open ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                    if (split2.length > 1) {
                                        replaceFirst = split2[1].trim();
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass: " + replaceFirst);
                                        }
                                    }
                                } else if (replaceFirst.startsWith("load ")) {
                                    split2 = replaceFirst.split("load ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                    if (split2.length > 1) {
                                        replaceFirst = split2[1].trim();
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass: " + replaceFirst);
                                        }
                                    }
                                } else if (replaceFirst.startsWith("launch ")) {
                                    split2 = replaceFirst.split("launch ");
                                    if (hc.f1269b) {
                                        ls.m1344a("raw: " + split2.length);
                                    }
                                    if (split2.length > 1) {
                                        replaceFirst = split2[1].trim();
                                        if (hc.f1269b) {
                                            ls.m1344a("rawpass: " + replaceFirst);
                                        }
                                    }
                                }
                                if (replaceFirst.contains(" app ")) {
                                    replaceFirst = replaceFirst.replace(" app ", " ");
                                }
                                if (replaceFirst.contains(" application ")) {
                                    replaceFirst = replaceFirst.replace(" application ", " ");
                                }
                                if (replaceFirst.contains("google plus")) {
                                    if (hc.f1269b) {
                                        ls.m1344a("replacing google plus: " + replaceFirst);
                                    }
                                    replaceFirst = replaceFirst.replace("google plus", "google+");
                                    if (hc.f1269b) {
                                        ls.m1344a("replaced google+: " + replaceFirst);
                                    }
                                } else if (replaceFirst.contains("play store")) {
                                    if (hc.f1269b) {
                                        ls.m1344a("replacing play store: " + replaceFirst);
                                    }
                                    replaceFirst = replaceFirst.replace("play store", "google play store");
                                    if (hc.f1269b) {
                                        ls.m1344a("replaced google play store: " + replaceFirst);
                                    }
                                }
                                if (!this.f1357C.contains(replaceFirst)) {
                                    if (hc.f1269b) {
                                        ls.m1344a("toApp: " + replaceFirst);
                                    }
                                    this.f1357C.add(replaceFirst);
                                }
                            }
                        }
                        if (gy.ak(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toFly: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(66));
                            if (replaceFirst.startsWith("fly to the ")) {
                                split2 = replaceFirst.split("fly to ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split2.length);
                                }
                            } else {
                                split2 = replaceFirst.split("fly to the ");
                                if (hc.f1269b) {
                                    ls.m1344a("raw: " + split2.length);
                                }
                            }
                            if (split2.length > 1) {
                                replaceFirst = split2[1].trim();
                                if (hc.f1269b) {
                                    ls.m1344a("rawpass: " + replaceFirst);
                                }
                                if (this.f1358D.isEmpty()) {
                                    if (hc.f1269b) {
                                        ls.m1344a("toFly: " + replaceFirst);
                                    }
                                    this.f1358D.add(replaceFirst);
                                }
                            }
                        }
                        if (gy.ac(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toBattery: " + replaceFirst);
                            }
                            if (replaceFirst.contains("level")) {
                                this.du = "level";
                            } else if (replaceFirst.contains("temperature")) {
                                this.du = "temperature";
                            } else if (replaceFirst.contains("voltage")) {
                                this.du = "voltage";
                            } else if (replaceFirst.contains("status")) {
                                this.du = "status";
                            } else if (replaceFirst.contains("health")) {
                                if (hc.f1269b) {
                                    ls.m1344a("toBattery unknown: " + replaceFirst);
                                }
                                this.du = "unknown";
                            } else {
                                this.du = "health";
                            }
                            if (!this.du.matches("unknown")) {
                                this.f1378Y.add(Integer.valueOf(67));
                                if (this.f1359E.isEmpty()) {
                                    if (hc.f1269b) {
                                        ls.m1346c("batRequest: " + this.du);
                                    }
                                    this.f1359E.add("rawpass");
                                }
                            } else if (hc.f1269b) {
                                ls.m1344a("unknown Battery request: " + replaceFirst);
                            }
                        }
                        if (gy.m1042m(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isPardon: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(101));
                        }
                        if (gy.ae(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toUserPassword: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(102));
                        }
                        if (gy.m1041l(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isStreamMusic: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(104));
                            replaceFirst = replaceFirst.replaceFirst("stream ", "").replaceFirst("google play ", "");
                            if (!replaceFirst.isEmpty()) {
                                this.f1386g.add(replaceFirst);
                            }
                        }
                        if (gy.m1040k(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isUserVolume: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(105));
                            if (replaceFirst.contains(" loud")) {
                                this.bJ = true;
                            } else if (replaceFirst.contains(" soft")) {
                                this.bL = true;
                            } else if (replaceFirst.contains("max")) {
                                this.bK = true;
                            } else if (replaceFirst.contains("min")) {
                                this.bM = true;
                            }
                        }
                        if (gy.aa(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isReadSMS: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(106));
                        }
                        if (gy.m1039j(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isFloatCommands: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(107));
                        }
                        if (gy.m1038i(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isFOffCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(108));
                        }
                        if (gy.m1037h(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isRedialCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(109));
                        }
                        if (gy.m1036g(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isRememberCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(110));
                        }
                        if (gy.m1035f(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isFindCarCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(111));
                        }
                        if (gy.m1034e(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isAppSearchCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(112));
                            this.f1361G.add(replaceFirst);
                        }
                        if (gy.m1018O(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isSubmitJoke: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(113));
                        }
                        gy.m1004A(replaceFirst);
                        if (gy.m1033d(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isReleaseResourcesCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(117));
                        }
                        if (gy.m1007D(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isNavigateContactCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(118));
                            replaceFirst = replaceFirst.replace("navigate to the contacts ", "").replace("navigate to the contact ", "").replace("navigate to contacts ", "").replace("navigate to contact ", "").replaceFirst("navigate contacts ", "").replaceFirst("navigate contact ", "").replaceFirst("navigate ", "").replaceFirst("contacts ", "").replaceFirst("contact ", "").replaceFirst("to ", "").replaceFirst("the ", "");
                            if (replaceFirst.contains(" work")) {
                                replaceFirst = replaceFirst.replaceAll("\\bwork\\b\\s*", "").trim();
                                hx.f1420b = true;
                            } else if (replaceFirst.contains(" office")) {
                                replaceFirst = replaceFirst.replaceAll("\\boffice\\b\\s*", "").trim();
                                hx.f1420b = true;
                            } else if (replaceFirst.contains(" home")) {
                                replaceFirst = replaceFirst.replaceAll("\\bhome\\b\\s*", "").trim();
                                hx.f1419a = true;
                            }
                            this.f1377W.add(replaceFirst);
                        }
                        if (gy.m1032c(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isFourSquareCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(119));
                            replaceFirst = replaceFirst.replaceFirst("check me in to ", "").replaceFirst("check me into ", "").replaceFirst("checkin to ", "").replaceFirst("check in to ", "").replaceFirst("check into ", "");
                            this.f1363I.add(replaceFirst);
                        }
                        if (!gy.m1031b(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("isCallBackCommand: " + replaceFirst);
                            }
                            this.f1378Y.add(Integer.valueOf(120));
                        }
                    }
                }
                replaceFirst = trim;
                if (gy.m1014K(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isDefineCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(16));
                    if (replaceFirst.startsWith("define existentialism")) {
                        replaceFirst = replaceFirst.replaceAll(" ", "%20").trim();
                        this.f1387h.add("http://api.wolframalpha.com/v2/query?appid=RRTVWX-G83L2WJT2X&input=" + replaceFirst + "&format=plaintext&podindex=1,2,3&parsetimeout=2&scantimeout=.5&formattimeout=1");
                        this.f1387h.add("define existentialism");
                    } else {
                        this.f1385f.add(replaceFirst);
                        replaceFirst = replaceFirst.replaceAll(" ", "%20").trim();
                        this.f1387h.add("http://api.wolframalpha.com/v2/query?appid=RRTVWX-G83L2WJT2X&input=" + replaceFirst + "&format=plaintext&podindex=1,2,3&parsetimeout=2&scantimeout=.5&formattimeout=1");
                    }
                }
                if (gy.m1013J(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isSpellCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(17));
                    if (this.f1388i.isEmpty()) {
                        new String[1][0] = "";
                        if (replaceFirst.startsWith("spell ")) {
                            split2 = replaceFirst.split("how do you spell ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                        } else {
                            split2 = replaceFirst.split("spell ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                        }
                        if (split2.length > 1) {
                            replaceFirst = split2[1].trim();
                            this.f1388i.add(replaceFirst);
                            replaceFirst = replaceFirst.replaceAll(".(?=.)", "$0 ").trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst);
                            }
                            this.f1388i.add(replaceFirst);
                        }
                    }
                }
                if (gy.m1012I(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isDirectoryCommand: " + replaceFirst);
                    }
                    trim = replaceFirst.replaceFirst(" a ", " ");
                    split = new String[]{""};
                    if (trim.startsWith("browse subdirectory ")) {
                        split = trim.split("browse subdirectory ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split.length);
                        }
                        this.f1378Y.add(Integer.valueOf(75));
                    } else if (trim.startsWith("browse sub directory ")) {
                        split = trim.split("browse sub directory ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split.length);
                        }
                        this.f1378Y.add(Integer.valueOf(75));
                    } else if (trim.startsWith("browse sup directory ")) {
                        split = trim.split("browse sup directory ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split.length);
                        }
                        this.f1378Y.add(Integer.valueOf(75));
                    } else if (trim.startsWith("browse directory ")) {
                        split = trim.split("browse directory ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split.length);
                        }
                    }
                    if (split.length <= 1) {
                        replaceFirst = trim;
                    } else {
                        replaceFirst = split[1].trim();
                        if (hc.f1269b) {
                            ls.m1344a("rawpass: " + replaceFirst);
                        }
                        if (this.f1389j.contains(replaceFirst)) {
                            if (this.f1378Y.contains(Integer.valueOf(75))) {
                                this.f1389j.add(replaceFirst);
                                this.f1378Y.add(Integer.valueOf(18));
                            } else if (this.f1389j.size() < 6) {
                                this.f1389j.add(replaceFirst);
                            }
                        }
                    }
                }
                if (gy.m1011H(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isShowCommand: " + replaceFirst);
                    }
                    if (replaceFirst.contains("result")) {
                        this.bz = true;
                    }
                    this.f1378Y.add(Integer.valueOf(19));
                }
                if (gy.m1009F(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isAlarmCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(20));
                    this.f1374T.add(replaceFirst);
                }
                if (gy.m1010G(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isCalendarCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(21));
                    this.f1360F.add(replaceFirst);
                }
                if (gy.m1008E(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isNavigateCommand: " + replaceFirst);
                    }
                    if (this.f1378Y.contains(Integer.valueOf(22))) {
                        replaceFirst = replaceFirst.replace("navigate to ", "").replaceFirst("navigate ", "").trim().replaceAll("\\s", "\\+");
                        this.dA = replaceFirst.trim();
                    }
                    this.f1378Y.add(Integer.valueOf(22));
                }
                if (gy.m1006C(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isLocateCarCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(23));
                }
                if (gy.m1005B(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isPlayMusicCommand: " + replaceFirst);
                    }
                    split2 = replaceFirst.split("play ");
                    if (hc.f1269b) {
                        ls.m1344a("raw: " + split2.length);
                    }
                    if (split2.length > 1) {
                        replaceFirst = split2[1].trim();
                        this.f1378Y.add(Integer.valueOf(24));
                        if (this.f1390k.size() < 6) {
                            this.f1390k.add(replaceFirst);
                        }
                    }
                }
                if (gy.m1015L(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("iseBayCommand: " + replaceFirst);
                    }
                    if (this.f1378Y.contains(Integer.valueOf(25))) {
                        replaceFirst = replaceFirst.replaceFirst("search ebay", "").trim();
                        if (replaceFirst.startsWith("for")) {
                            replaceFirst = replaceFirst.replaceFirst("for", "").trim();
                        }
                        replaceFirst = replaceFirst.trim().replaceAll(" +", " ");
                        this.dC = replaceFirst.trim().replaceAll("\\s", "\\%20");
                    }
                    this.f1378Y.add(Integer.valueOf(25));
                }
                if (gy.m1016M(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isTranslateCommand: " + replaceFirst);
                    }
                    if (this.f1378Y.contains(Integer.valueOf(26))) {
                        split2 = new String[]{""};
                        if (this.dk.matcher(replaceFirst).matches()) {
                            this.cV = true;
                            split2 = replaceFirst.split("german ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                        } else if (this.dl.matcher(replaceFirst).matches()) {
                            this.cW = true;
                            split2 = replaceFirst.split("french ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                        } else if (this.dm.matcher(replaceFirst).matches()) {
                            this.cX = true;
                            split2 = replaceFirst.split("italian ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                        } else if (this.f1383do.matcher(replaceFirst).matches()) {
                            this.cZ = true;
                            split2 = replaceFirst.split("spanish ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                        } else if (this.dn.matcher(replaceFirst).matches()) {
                            this.cY = true;
                            split2 = replaceFirst.split("polish ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                        } else if (this.dp.matcher(replaceFirst).matches()) {
                            this.da = true;
                            split2 = replaceFirst.split("romanian ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                        }
                        if (split2.length > 1) {
                            replaceFirst = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst);
                            }
                            this.f1391l.add(replaceFirst);
                        }
                    }
                    this.f1378Y.add(Integer.valueOf(26));
                }
                if (gy.m1017N(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isCreateCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(27));
                }
                if (gy.m1019P(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isJoke: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(28));
                }
                if (gy.m1020Q(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isMD5: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(29));
                }
                if (gy.m1021R(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isZip: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(30));
                    if (replaceFirst.contains("screenshot")) {
                    }
                    this.de = true;
                }
                if (gy.m1022S(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isScreenShot: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(31));
                }
                if (gy.m1024U(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isGoTo: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(32));
                    this.f1392m.add(replaceFirst);
                }
                if (gy.m1023T(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isWhere: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(33));
                }
                if (gy.an(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isDate: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(103));
                }
                if (gy.m1026W(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isSMS: " + replaceFirst);
                    }
                    split2 = replaceFirst.split("text ");
                    if (hc.f1269b) {
                        ls.m1344a("raw: " + split2.length);
                    }
                    if (split2.length > 1) {
                        replaceFirst = split2[1].trim();
                        if (hc.f1269b) {
                            ls.m1344a("rawpass: " + replaceFirst);
                        }
                        this.f1378Y.add(Integer.valueOf(34));
                        if (this.f1393n.contains(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toSMS: " + replaceFirst);
                            }
                            this.f1393n.add(replaceFirst);
                        }
                    }
                }
                if (gy.m1025V(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isEmail: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(35));
                    replaceFirst = replaceFirst.replaceAll("\\bemail\\b\\s*", "").trim().replaceAll("\\be-mail\\b\\s*", "").trim();
                    if (hc.f1269b) {
                        ls.m1344a("rawpass: " + replaceFirst.toString());
                    }
                    if (this.f1394o.contains(replaceFirst)) {
                        if (hc.f1269b) {
                            ls.m1344a("toEmail: " + replaceFirst);
                        }
                        this.f1394o.add(replaceFirst);
                    }
                }
                if (gy.ap(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isConnection: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(36));
                    this.f1395p.add(replaceFirst);
                }
                if (gy.m1027X(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isSkype: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(37));
                    replaceFirst = replaceFirst.replaceAll("\\bskype\\b\\s*", "").trim();
                    if (hc.f1269b) {
                        ls.m1344a("rawpass: " + replaceFirst.toString());
                    }
                    if (this.f1396q.contains(replaceFirst)) {
                        if (hc.f1269b) {
                            ls.m1344a("toSkype: " + replaceFirst);
                        }
                        this.f1396q.add(replaceFirst);
                    }
                }
                if (gy.m1028Y(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isKill: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(38));
                    if (replaceFirst.startsWith("kill ")) {
                        if (replaceFirst.contains(" app ")) {
                            replaceFirst = replaceFirst.replace(" app ", " ");
                        }
                        if (replaceFirst.contains("application")) {
                            replaceFirst = replaceFirst.replace("application", "");
                        }
                        if (replaceFirst.contains("google plus")) {
                            if (hc.f1269b) {
                                ls.m1344a("replacing google plus: " + replaceFirst);
                            }
                            replaceFirst = replaceFirst.replace("google plus", "google+");
                            if (hc.f1269b) {
                                ls.m1344a("replaced google+: " + replaceFirst);
                            }
                        } else if (replaceFirst.contains("play store")) {
                            if (hc.f1269b) {
                                ls.m1344a("replacing play store: " + replaceFirst);
                            }
                            replaceFirst = replaceFirst.replace("play store", "google play store");
                            if (hc.f1269b) {
                                ls.m1344a("replaced google play store: " + replaceFirst);
                            }
                        }
                        split2 = replaceFirst.split("kill ");
                        if (split2.length > 1) {
                            replaceFirst = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst);
                            }
                            if (this.f1397r.contains(replaceFirst)) {
                                if (hc.f1269b) {
                                    ls.m1344a("toKill: " + replaceFirst);
                                }
                                this.f1397r.add(replaceFirst);
                            }
                        }
                    } else if (replaceFirst.startsWith("kill app ")) {
                        split2 = replaceFirst.split(" app ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split2.length);
                        }
                        if (split2.length > 1) {
                            replaceFirst = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst);
                            }
                            if (this.f1397r.contains(replaceFirst)) {
                                if (hc.f1269b) {
                                    ls.m1344a("toKill: " + replaceFirst);
                                }
                                this.f1397r.add(replaceFirst);
                            }
                        }
                    }
                }
                if (gy.ab(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isForeground: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(39));
                }
                if (gy.m1029Z(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isClipboard: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(40));
                }
                if (gy.ai(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toRinger: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(41));
                    if (replaceFirst.contains("vibrate")) {
                        this.aF = true;
                    } else if (replaceFirst.contains("silent")) {
                        this.aE = true;
                    } else if (replaceFirst.contains("normal")) {
                        this.aD = true;
                    }
                }
                if (gy.ag(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isShakeSetting: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(42));
                    if (this.f1398s.isEmpty()) {
                        if (replaceFirst.startsWith("enable shake")) {
                            this.dv = "on";
                            this.f1398s.add(replaceFirst);
                        } else if (replaceFirst.startsWith("disable shake")) {
                            this.dv = "off";
                            this.f1398s.add(replaceFirst);
                        } else if (replaceFirst.contains("very low")) {
                            this.dv = "vlow";
                            this.f1398s.add(replaceFirst);
                        } else if (replaceFirst.contains("very high")) {
                            this.dv = "vhigh";
                            this.f1398s.add(replaceFirst);
                        } else if (replaceFirst.contains(" low")) {
                            this.dv = "low";
                            this.f1398s.add(replaceFirst);
                        } else if (replaceFirst.contains(" medium")) {
                            this.dv = "medium";
                            this.f1398s.add(replaceFirst);
                        } else if (replaceFirst.contains(" high")) {
                            this.dv = "high";
                            this.f1398s.add(replaceFirst);
                        }
                    }
                }
                if (gy.ah(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isWaveSetting: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(43));
                    if (this.f1399t.isEmpty()) {
                        if (replaceFirst.startsWith("enable wave")) {
                            this.dw = "on";
                            this.f1399t.add(replaceFirst);
                        } else if (replaceFirst.startsWith("disable wave")) {
                            this.dw = "off";
                            this.f1399t.add(replaceFirst);
                        }
                    }
                }
                if (gy.af(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isUserName: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(44));
                    if (this.f1400u.isEmpty()) {
                        split2 = replaceFirst.split("call me ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split2.length);
                        }
                        if (split2.length > 1) {
                            replaceFirst = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst);
                            }
                            this.dx = "";
                            if (io.m1181a(replaceFirst)) {
                                this.dx = "I don't really think I should, but you're the boss, ";
                            }
                            this.f1400u.add(replaceFirst);
                        }
                    }
                }
                if (gy.m1030a(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toSettings: " + replaceFirst);
                    }
                    if (this.f1378Y.contains(Integer.valueOf(45))) {
                        if (replaceFirst.startsWith("wifi settings")) {
                            this.cr = true;
                        }
                        if (replaceFirst.startsWith("bluetooth settings")) {
                            this.ct = true;
                        }
                        if (replaceFirst.startsWith("data settings")) {
                            this.cq = true;
                        }
                        this.cs = true;
                        if (replaceFirst.startsWith("voice search settings")) {
                            this.cv = true;
                        }
                        this.cu = true;
                        this.cy = true;
                        if (replaceFirst.startsWith("accessibility settings")) {
                            this.cw = true;
                        }
                        if (replaceFirst.startsWith("application settings")) {
                            replaceFirst = replaceFirst.replaceFirst("application settings", "").trim().replaceFirst("application setting", "").trim();
                            if (replaceFirst.length() > 3) {
                                this.df = true;
                                this.f1384e.add(replaceFirst);
                            }
                            this.cx = true;
                        }
                        if (replaceFirst.startsWith("device settings")) {
                            this.cz = true;
                        }
                        if (replaceFirst.startsWith("locale settings")) {
                            this.cE = true;
                        }
                        if (replaceFirst.startsWith("display settings")) {
                            this.cB = true;
                        }
                        if (replaceFirst.startsWith("input settings")) {
                            this.cC = true;
                        }
                        if (replaceFirst.startsWith("location settings")) {
                            this.cA = true;
                        }
                        if (replaceFirst.startsWith("storage settings")) {
                            this.cD = true;
                        }
                        this.cG = true;
                        if (replaceFirst.startsWith("network operator settings")) {
                            this.cH = true;
                        }
                        this.cI = true;
                        if (replaceFirst.startsWith("privacy settings")) {
                            this.cJ = true;
                        }
                        if (replaceFirst.startsWith("quick launch settings")) {
                            this.cK = true;
                        }
                        if (replaceFirst.matches("settings")) {
                            this.cF = true;
                        }
                        if (replaceFirst.startsWith("search settings")) {
                            this.cO = true;
                        }
                        this.cL = true;
                        this.cM = true;
                        if (replaceFirst.startsWith("dictionary settings")) {
                            this.cN = true;
                        }
                    }
                    this.f1378Y.add(Integer.valueOf(45));
                }
                if (gy.am(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("found Time: " + replaceFirst);
                    }
                    replaceFirst = replaceFirst.replaceAll("\\p{P}+", "");
                    if (replaceFirst.contains(" time in ")) {
                    }
                    if (hc.f1269b) {
                        ls.m1344a("found Time In: " + replaceFirst);
                    }
                    if (replaceFirst.endsWith(" time in")) {
                    }
                    this.f1364J.add(replaceFirst);
                    this.f1378Y.add(Integer.valueOf(46));
                }
                if (gy.aq(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("found Call: " + replaceFirst);
                    }
                    replaceFirst = replaceFirst.replaceAll("\\bcall\\b\\s*", "").trim();
                    if (hc.f1269b) {
                        ls.m1344a("rawpass: " + replaceFirst);
                    }
                    trim = this.dE.replaceAll("\\bcall\\b\\s*", "").trim().replaceAll("o", QueryParamConst.U_VALUE);
                    if (trim.matches("[0-9 ]+")) {
                        if (hc.f1269b) {
                            ls.m1344a("not temp: " + trim);
                        }
                        this.f1378Y.add(Integer.valueOf(48));
                        if (replaceFirst.endsWith(" home")) {
                        }
                        if (replaceFirst.endsWith(" home")) {
                            if (hc.f1269b) {
                                ls.m1345b("ends with home: " + replaceFirst);
                            }
                            replaceFirst = replaceFirst.replaceAll("\\bhome\\b\\s*", "").trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst.toString());
                            }
                            this.ap = true;
                        }
                        if (hc.f1269b) {
                            ls.m1345b("ends with work: " + replaceFirst);
                        }
                        replaceFirst = replaceFirst.replaceAll("\\bwork\\b\\s*", "").trim().replaceAll("\\boffice\\b\\s*", "").trim();
                        if (hc.f1269b) {
                            ls.m1344a("rawpass: " + replaceFirst.toString());
                        }
                        this.aq = true;
                        if (replaceFirst.endsWith("mobile")) {
                            if (hc.f1269b) {
                                ls.m1345b("ends with mobile: " + replaceFirst);
                            }
                            replaceFirst = replaceFirst.replaceAll("\\bmobile\\b\\s*", "").trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst.toString());
                            }
                            this.ar = true;
                        }
                        if (this.f1401v.contains(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toCall: " + replaceFirst);
                            }
                            this.f1401v.add(replaceFirst);
                        }
                    } else {
                        if (hc.f1269b) {
                            ls.m1344a("temp: " + trim);
                        }
                        this.f1378Y.add(Integer.valueOf(114));
                    }
                }
                if (gy.ar(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toSuperUser: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(52));
                    if (hc.f1269b) {
                        ls.m1344a("toRoot: " + replaceFirst);
                    }
                    this.f1403x.add(replaceFirst);
                }
                if (gy.as(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toDisplayC: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(1));
                    replaceFirst = replaceFirst.replaceAll("\\bthe\\b\\s*", "").trim().replaceAll("\\bdisplay\\b\\s*", "").trim().replaceAll("\\bcontacts\\b\\s*", "").trim().replaceAll("\\bcontact\\b\\s*", "").trim().replaceAll("\\bshow me\\b\\s*", "").trim().replaceAll("\\bshow\\b\\s*", "").trim();
                    if (this.f1404y.contains(replaceFirst)) {
                        this.f1404y.add(replaceFirst);
                    }
                }
                if (gy.at(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toTasker: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(53));
                    split2 = null;
                    if (replaceFirst.startsWith("display task")) {
                        this.aJ = true;
                    } else {
                        if (replaceFirst.startsWith("run task ")) {
                            split2 = replaceFirst.split("run task ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                        } else if (replaceFirst.startsWith("execute task ")) {
                            split2 = replaceFirst.split("execute task ");
                            if (hc.f1269b) {
                                ls.m1344a("raw: " + split2.length);
                            }
                        }
                        if (split2.length > 1) {
                            replaceFirst = split2[1].trim().replaceAll(" ", "").trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst);
                            }
                            if (this.f1405z.contains(replaceFirst)) {
                                this.f1405z.add(replaceFirst);
                            }
                        }
                    }
                }
                if (gy.au(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toFacebook: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(55));
                }
                if (gy.ad(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toDeveloperPassword: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(56));
                    this.aL = true;
                }
                if (gy.av(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toTwitter: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(57));
                    replaceFirst = replaceFirst.replaceFirst("tweet ", "").trim();
                    this.f1355A.add(replaceFirst);
                }
                if (gy.aw(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toWeather: " + replaceFirst);
                    }
                    replaceFirst = replaceFirst.replaceAll("\\p{P}+", "");
                    if (!this.dh.matcher(replaceFirst).matches()) {
                    }
                    if (this.f1367M.isEmpty()) {
                        this.f1378Y.add(Integer.valueOf(58));
                        b = ik.m1176b(this.f1380a);
                        if (b != null) {
                        }
                        this.dF = "Sorry, something went wrong accessing your location data.";
                    } else if (hc.f1269b) {
                        ls.m1345b("Ignorning as commandWeatherIn is set:" + replaceFirst);
                    }
                }
                if (gy.ao(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toSearch: " + replaceFirst);
                    }
                    if (!replaceFirst.startsWith("search ")) {
                    }
                    if (!replaceFirst.startsWith("search ")) {
                    }
                    if (this.f1378Y.contains(Integer.valueOf(62))) {
                    }
                    if (this.f1378Y.contains(Integer.valueOf(64))) {
                    }
                    split2 = replaceFirst.split("search yahoo ");
                    if (hc.f1269b) {
                        ls.m1344a("raw: " + split2.length);
                    }
                    if (split2.length > 1) {
                        replaceFirst = split2[1].trim();
                        if (hc.f1269b) {
                            ls.m1344a("rawpass: " + replaceFirst);
                        }
                        if (replaceFirst.startsWith("for ")) {
                            if (hc.f1269b) {
                                ls.m1344a("rawpass starts with FOR: " + replaceFirst);
                            }
                            replaceFirst = replaceFirst.replaceFirst("for ", "");
                            if (hc.f1269b) {
                                ls.m1344a("rawpass replaced FOR: " + replaceFirst);
                            }
                            replaceFirst.trim();
                        }
                        if (replaceFirst.startsWith("4 ")) {
                            if (hc.f1269b) {
                                ls.m1344a("rawpass starts with 4: " + replaceFirst);
                            }
                            replaceFirst = replaceFirst.replaceFirst("4 ", "");
                            if (hc.f1269b) {
                                ls.m1344a("rawpass replaced 4: " + replaceFirst);
                            }
                            replaceFirst.trim();
                        }
                        if (this.f1356B.contains(replaceFirst)) {
                            if (hc.f1269b) {
                                ls.m1344a("toSearch: " + replaceFirst);
                            }
                            this.f1356B.add(replaceFirst);
                            this.f1378Y.add(Integer.valueOf(63));
                        }
                    }
                }
                if (gy.al(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toApp: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(65));
                    if (replaceFirst.contains(" app ")) {
                        replaceFirst = replaceFirst.replace(" app ", " ");
                    }
                    if (replaceFirst.contains("application")) {
                        replaceFirst = replaceFirst.replace("application", "");
                    }
                    if (replaceFirst.contains("google plus")) {
                        if (hc.f1269b) {
                            ls.m1344a("replacing google plus: " + replaceFirst);
                        }
                        replaceFirst = replaceFirst.replace("google plus", "google+");
                        if (hc.f1269b) {
                            ls.m1344a("replaced google+: " + replaceFirst);
                        }
                    } else if (replaceFirst.contains("play store")) {
                        if (hc.f1269b) {
                            ls.m1344a("replacing play store: " + replaceFirst);
                        }
                        replaceFirst = replaceFirst.replace("play store", "google play store");
                        if (hc.f1269b) {
                            ls.m1344a("replaced google play store: " + replaceFirst);
                        }
                    }
                    if (replaceFirst.startsWith("open ")) {
                        split2 = replaceFirst.split("open ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split2.length);
                        }
                        if (split2.length > 1) {
                            replaceFirst = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst);
                            }
                        }
                    } else if (replaceFirst.startsWith("load ")) {
                        split2 = replaceFirst.split("load ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split2.length);
                        }
                        if (split2.length > 1) {
                            replaceFirst = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst);
                            }
                        }
                    } else if (replaceFirst.startsWith("launch ")) {
                        split2 = replaceFirst.split("launch ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split2.length);
                        }
                        if (split2.length > 1) {
                            replaceFirst = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1344a("rawpass: " + replaceFirst);
                            }
                        }
                    }
                    if (replaceFirst.contains(" app ")) {
                        replaceFirst = replaceFirst.replace(" app ", " ");
                    }
                    if (replaceFirst.contains(" application ")) {
                        replaceFirst = replaceFirst.replace(" application ", " ");
                    }
                    if (replaceFirst.contains("google plus")) {
                        if (hc.f1269b) {
                            ls.m1344a("replacing google plus: " + replaceFirst);
                        }
                        replaceFirst = replaceFirst.replace("google plus", "google+");
                        if (hc.f1269b) {
                            ls.m1344a("replaced google+: " + replaceFirst);
                        }
                    } else if (replaceFirst.contains("play store")) {
                        if (hc.f1269b) {
                            ls.m1344a("replacing play store: " + replaceFirst);
                        }
                        replaceFirst = replaceFirst.replace("play store", "google play store");
                        if (hc.f1269b) {
                            ls.m1344a("replaced google play store: " + replaceFirst);
                        }
                    }
                    if (this.f1357C.contains(replaceFirst)) {
                        if (hc.f1269b) {
                            ls.m1344a("toApp: " + replaceFirst);
                        }
                        this.f1357C.add(replaceFirst);
                    }
                }
                if (gy.ak(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toFly: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(66));
                    if (replaceFirst.startsWith("fly to the ")) {
                        split2 = replaceFirst.split("fly to ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split2.length);
                        }
                    } else {
                        split2 = replaceFirst.split("fly to the ");
                        if (hc.f1269b) {
                            ls.m1344a("raw: " + split2.length);
                        }
                    }
                    if (split2.length > 1) {
                        replaceFirst = split2[1].trim();
                        if (hc.f1269b) {
                            ls.m1344a("rawpass: " + replaceFirst);
                        }
                        if (this.f1358D.isEmpty()) {
                            if (hc.f1269b) {
                                ls.m1344a("toFly: " + replaceFirst);
                            }
                            this.f1358D.add(replaceFirst);
                        }
                    }
                }
                if (gy.ac(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toBattery: " + replaceFirst);
                    }
                    if (replaceFirst.contains("level")) {
                        this.du = "level";
                    } else if (replaceFirst.contains("temperature")) {
                        this.du = "temperature";
                    } else if (replaceFirst.contains("voltage")) {
                        this.du = "voltage";
                    } else if (replaceFirst.contains("status")) {
                        this.du = "status";
                    } else if (replaceFirst.contains("health")) {
                        if (hc.f1269b) {
                            ls.m1344a("toBattery unknown: " + replaceFirst);
                        }
                        this.du = "unknown";
                    } else {
                        this.du = "health";
                    }
                    if (!this.du.matches("unknown")) {
                        this.f1378Y.add(Integer.valueOf(67));
                        if (this.f1359E.isEmpty()) {
                            if (hc.f1269b) {
                                ls.m1346c("batRequest: " + this.du);
                            }
                            this.f1359E.add("rawpass");
                        }
                    } else if (hc.f1269b) {
                        ls.m1344a("unknown Battery request: " + replaceFirst);
                    }
                }
                if (gy.m1042m(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isPardon: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(101));
                }
                if (gy.ae(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("toUserPassword: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(102));
                }
                if (gy.m1041l(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isStreamMusic: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(104));
                    replaceFirst = replaceFirst.replaceFirst("stream ", "").replaceFirst("google play ", "");
                    if (replaceFirst.isEmpty()) {
                        this.f1386g.add(replaceFirst);
                    }
                }
                if (gy.m1040k(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isUserVolume: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(105));
                    if (replaceFirst.contains(" loud")) {
                        this.bJ = true;
                    } else if (replaceFirst.contains(" soft")) {
                        this.bL = true;
                    } else if (replaceFirst.contains("max")) {
                        this.bK = true;
                    } else if (replaceFirst.contains("min")) {
                        this.bM = true;
                    }
                }
                if (gy.aa(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isReadSMS: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(106));
                }
                if (gy.m1039j(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isFloatCommands: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(107));
                }
                if (gy.m1038i(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isFOffCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(108));
                }
                if (gy.m1037h(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isRedialCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(109));
                }
                if (gy.m1036g(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isRememberCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(110));
                }
                if (gy.m1035f(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isFindCarCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(111));
                }
                if (gy.m1034e(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isAppSearchCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(112));
                    this.f1361G.add(replaceFirst);
                }
                if (gy.m1018O(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isSubmitJoke: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(113));
                }
                gy.m1004A(replaceFirst);
                if (gy.m1033d(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isReleaseResourcesCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(117));
                }
                if (gy.m1007D(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isNavigateContactCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(118));
                    replaceFirst = replaceFirst.replace("navigate to the contacts ", "").replace("navigate to the contact ", "").replace("navigate to contacts ", "").replace("navigate to contact ", "").replaceFirst("navigate contacts ", "").replaceFirst("navigate contact ", "").replaceFirst("navigate ", "").replaceFirst("contacts ", "").replaceFirst("contact ", "").replaceFirst("to ", "").replaceFirst("the ", "");
                    if (replaceFirst.contains(" work")) {
                        replaceFirst = replaceFirst.replaceAll("\\bwork\\b\\s*", "").trim();
                        hx.f1420b = true;
                    } else if (replaceFirst.contains(" office")) {
                        replaceFirst = replaceFirst.replaceAll("\\boffice\\b\\s*", "").trim();
                        hx.f1420b = true;
                    } else if (replaceFirst.contains(" home")) {
                        replaceFirst = replaceFirst.replaceAll("\\bhome\\b\\s*", "").trim();
                        hx.f1419a = true;
                    }
                    this.f1377W.add(replaceFirst);
                }
                if (gy.m1032c(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isFourSquareCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(119));
                    replaceFirst = replaceFirst.replaceFirst("check me in to ", "").replaceFirst("check me into ", "").replaceFirst("checkin to ", "").replaceFirst("check in to ", "").replaceFirst("check into ", "");
                    this.f1363I.add(replaceFirst);
                }
                if (!gy.m1031b(replaceFirst)) {
                    if (hc.f1269b) {
                        ls.m1344a("isCallBackCommand: " + replaceFirst);
                    }
                    this.f1378Y.add(Integer.valueOf(120));
                }
            }
            this.dG = is.m1183a(this.f1378Y);
            if (hc.f1269b) {
                ls.m1344a("intArray: " + this.f1378Y.size() + " : " + this.f1378Y.toString());
            }
            switch (this.dG) {
                case 1:
                    this.af = true;
                    break;
                case 2:
                    this.bD = true;
                    break;
                case 3:
                    this.bB = true;
                    break;
                case 4:
                    this.bC = true;
                    break;
                case 5:
                    this.bA = true;
                    break;
                case 6:
                    this.by = true;
                    break;
                case 7:
                    this.bx = true;
                    break;
                case 8:
                    this.bw = true;
                    break;
                case 9:
                    this.bu = true;
                    break;
                case 10:
                    this.bt = true;
                    break;
                case 11:
                    this.bs = true;
                    break;
                case 12:
                    this.bq = true;
                    break;
                case 13:
                    this.br = true;
                    break;
                case 14:
                    this.bp = true;
                    break;
                case 15:
                    this.bo = true;
                    break;
                case 16:
                    this.be = true;
                    break;
                case 17:
                    this.bf = true;
                    break;
                case 18:
                    this.bg = true;
                    break;
                case 19:
                    this.bi = true;
                    break;
                case 20:
                    this.bj = true;
                    break;
                case 21:
                    this.bk = true;
                    break;
                case 22:
                    this.bl = true;
                    break;
                case 23:
                    this.bm = true;
                    break;
                case 24:
                    this.bn = true;
                    break;
                case 25:
                    this.bd = true;
                    break;
                case 26:
                    this.bc = true;
                    break;
                case 27:
                    this.bb = true;
                    break;
                case 28:
                    this.ba = true;
                    break;
                case 29:
                    this.aZ = true;
                    break;
                case 30:
                    this.aY = true;
                    break;
                case 31:
                    this.aX = true;
                    break;
                case 32:
                    this.aW = true;
                    break;
                case 33:
                    this.aV = true;
                    break;
                case 34:
                    this.aU = true;
                    break;
                case 35:
                    this.aT = true;
                    break;
                case 36:
                    this.aR = true;
                    break;
                case 37:
                    this.aS = true;
                    break;
                case 38:
                    this.aQ = true;
                    break;
                case 39:
                    this.aP = true;
                    break;
                case 40:
                    this.aO = true;
                    break;
                case 41:
                    this.aC = true;
                    break;
                case 42:
                    this.aH = true;
                    break;
                case 43:
                    this.aI = true;
                    break;
                case 44:
                    this.aG = true;
                    break;
                case 45:
                    this.as = true;
                    if (this.df) {
                        this.dG = 115;
                        break;
                    }
                    break;
                case 46:
                    this.ah = true;
                    break;
                case 47:
                    this.ai = true;
                    break;
                case 48:
                    this.ag = true;
                    break;
                case 49:
                    this.ap = true;
                    break;
                case 50:
                    this.aq = true;
                    break;
                case 51:
                    this.ar = true;
                    break;
                case 52:
                    this.ac = true;
                    break;
                case 53:
                    this.ak = true;
                    break;
                case 54:
                    this.aJ = true;
                    break;
                case 55:
                    this.al = true;
                    break;
                case 56:
                    this.aK = true;
                    break;
                case 57:
                    this.am = true;
                    break;
                case 58:
                    this.an = true;
                    break;
                case 59:
                    this.ao = true;
                    break;
                case TwitterStream.MAX_KEYWORD_LENGTH /*60*/:
                    this.aw = true;
                    break;
                case 61:
                    this.ax = true;
                    break;
                case 62:
                    this.au = true;
                    break;
                case 63:
                    this.av = true;
                    break;
                case 64:
                    this.at = true;
                    break;
                case 65:
                    this.ay = true;
                    break;
                case 66:
                    this.az = true;
                    break;
                case 67:
                    this.aA = true;
                    break;
                case 68:
                    this.cP = true;
                    break;
                case 69:
                    this.cQ = true;
                    break;
                case 70:
                    this.cR = true;
                    break;
                case 71:
                    this.cS = true;
                    break;
                case 72:
                    this.cT = true;
                    break;
                case 73:
                    this.ae = true;
                    GlobalV.m896v(true);
                    GlobalV.m893u(true);
                    break;
                case 74:
                    this.aB = true;
                    break;
                case 75:
                    this.bh = true;
                    break;
                case 76:
                    this.ca = true;
                    break;
                case 77:
                    this.cb = true;
                    break;
                case 78:
                    this.cc = true;
                    break;
                case 79:
                    this.cd = true;
                    break;
                case 80:
                    this.ce = true;
                    break;
                case 81:
                    this.cf = true;
                    break;
                case 82:
                    this.cg = true;
                    break;
                case 83:
                    this.ch = true;
                    break;
                case 84:
                    this.ci = true;
                    break;
                case 85:
                    this.cj = true;
                    break;
                case 86:
                    this.ck = true;
                    break;
                case 87:
                    this.db = true;
                    break;
                case 88:
                    this.dc = true;
                    break;
                case 89:
                    this.dd = true;
                    break;
                case 90:
                    this.de = true;
                    break;
                case 91:
                    this.cV = true;
                    break;
                case 92:
                    this.cW = true;
                    break;
                case 93:
                    this.cX = true;
                    break;
                case 94:
                    this.cY = true;
                    break;
                case 95:
                    this.cZ = true;
                    break;
                case 96:
                    this.da = true;
                    break;
                case 97:
                    this.bz = true;
                    break;
                case 98:
                    this.aD = true;
                    break;
                case 99:
                    this.aE = true;
                    break;
                case 100:
                    this.aF = true;
                    break;
                case 101:
                    this.bE = true;
                    break;
                case 102:
                    this.aM = true;
                    break;
                case 103:
                    this.bF = true;
                    break;
                case 104:
                    this.bH = true;
                    break;
                case 105:
                    this.bI = true;
                    break;
                case 106:
                    this.bN = true;
                    break;
                case 107:
                    this.bO = true;
                    break;
                case 108:
                    this.ad = true;
                    break;
                case 109:
                    this.bP = true;
                    break;
                case 110:
                    this.bQ = true;
                    break;
                case 111:
                    this.bR = true;
                    break;
                case 112:
                    this.bS = true;
                    break;
                case 113:
                    this.bT = true;
                    break;
                case 114:
                    this.bU = true;
                    break;
                case 115:
                    this.df = true;
                    break;
                case 116:
                    this.bV = true;
                    break;
                case 117:
                    this.bW = true;
                    break;
                case 118:
                    this.bX = true;
                    break;
                case 119:
                    this.bY = true;
                    break;
                case 120:
                    this.bZ = true;
                    break;
                case 911:
                    this.ab = true;
                    break;
            }
            if (this.ae) {
                if (hc.f1269b) {
                    ls.m1344a("commandEasterEgg: " + this.ae);
                }
            } else if (this.ab || this.aB) {
                if (hc.f1269b) {
                    ls.m1345b("multipleCommand: " + this.ab);
                }
                this.ab = true;
            } else if (this.as) {
                if (hc.f1269b) {
                    ls.m1346c("commandSettings: " + this.as);
                }
                if (this.cx && this.df) {
                    if (this.f1384e.isEmpty()) {
                        this.df = false;
                    } else {
                        this.f1370P = new ho().m1129a(this.f1380a, this.f1384e);
                        if (hc.f1269b) {
                            ls.m1344a("toCheckApp: " + this.f1384e.size() + " : " + this.f1384e.toString());
                        }
                    }
                }
            } else if (this.bV) {
                if (hc.f1269b) {
                    ls.m1346c("commandPlaylist: " + this.bV);
                }
            } else if (this.bX) {
                if (hc.f1269b) {
                    ls.m1346c("commandNavigateContact: " + this.bX);
                }
                this.f1369O = hx.m1150a(this.f1380a, this.f1377W);
                if (hc.f1269b) {
                    ls.m1344a("getContact: " + this.f1369O.size() + " : " + this.f1369O.toString());
                }
                if (this.f1369O.isEmpty()) {
                    this.dF = "Sorry, but I couldn't find a match for that contact";
                    this.dH = 1;
                } else if (this.f1369O.size() <= 1) {
                    this.dF = (String) this.f1369O.get(1);
                    this.dH = 1;
                } else if (((String) this.f1369O.get(0)).matches("ERROR")) {
                    this.dF = (String) this.f1369O.get(1);
                    this.dH = 1;
                } else {
                    this.cU = true;
                    this.dr = (String) this.f1369O.get(0);
                    this.dq = (String) this.f1369O.get(1);
                    trim = hx.m1149a(this.f1380a, (String) this.f1369O.get(1));
                    if (hc.f1269b) {
                        ls.m1346c("getAddress: " + trim);
                    }
                    replaceFirst = "";
                    if (trim.matches("null")) {
                        replaceFirst = hx.f1420b ? " work" : hx.f1419a ? " home" : "n";
                        this.dF = "Sorry, but I couldn't find a" + replaceFirst + " address for " + this.dr;
                    } else {
                        if (hx.f1420b) {
                            replaceFirst = "work ";
                        } else if (hx.f1419a) {
                            replaceFirst = "home ";
                        }
                        jy.m1261l(this.f1380a, trim);
                        this.dF = "Navigating to the " + replaceFirst + "address of " + this.dr;
                    }
                }
            } else if (this.bA) {
                if (hc.f1269b) {
                    ls.m1346c("commandParkedCar: " + this.bA);
                }
                publishProgress(new String[]{"Ok, I'll get a GPS fix."});
                if (Looper.myLooper() == null) {
                    if (hc.f1269b) {
                        ls.m1346c("Preparing looper");
                    }
                    Looper.prepare();
                }
                r0 = ik.m1175a(this.f1380a);
                if (Looper.myLooper() != null) {
                    if (hc.f1269b) {
                        ls.m1346c("Quitting myLooper");
                    }
                    Looper.myLooper().quit();
                }
                if (r0 != null) {
                    double latitude = r0.getLatitude();
                    double longitude = r0.getLongitude();
                    lx.m1448q(this.f1380a);
                    lx.m1398b(this.f1380a, latitude);
                    lx.m1388a(this.f1380a, longitude);
                    if (hc.f1269b) {
                        ls.m1344a("carLock: Lat: " + latitude + " : Lon :" + longitude);
                    }
                    this.dF = "Ok, I know exactly where it is";
                } else {
                    if (hc.f1269b) {
                        ls.m1347d("carLock was null");
                    }
                    this.dF = "I'm afraid I coudn't get a GPS fix.";
                    this.dH = 1;
                }
            } else if (this.bT) {
                if (hc.f1269b) {
                    ls.m1346c("commandSubmitJoke: " + this.bT);
                }
                if (!hc.f1270c) {
                    this.dF = "I'm a bit busy at the moment. Tell me later.";
                } else if (mb.m1470a(this.f1380a)) {
                    this.dF = "Okay, please say the joke in its entirety.";
                    f1354b = true;
                    GlobalV.m893u(true);
                    GlobalV.m827c(true);
                    GlobalV.m844g(true);
                    GlobalV.m862l(1);
                } else {
                    this.dF = "You need to create an account or register this device before you can submit content.";
                    Intent intent = new Intent(this.f1380a, ActivityAccount.class);
                    intent.addFlags(268435456);
                    try {
                        this.f1380a.startActivity(intent);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (this.bY) {
                if (hc.f1269b) {
                    ls.m1346c("commandFourSquare: " + this.bY);
                }
                if (!jy.m1262m(this.f1380a, "com.joelapenna.foursquared")) {
                    this.dF = "You need to install Four Square to use this feature.";
                    jy.m1264o(this.f1380a, "com.joelapenna.foursquared");
                } else if (lx.m1405c(this.f1380a).matches("")) {
                    this.dF = "You'll need to manually authorise Four Square in the linked applications section, before you can use this feature.";
                    jy.m1228a(this.f1380a, ActivityLinkApps.class, true);
                } else {
                    publishProgress(new String[]{"Okay, let me grab your location"});
                    if (Looper.myLooper() == null) {
                        if (hc.f1269b) {
                            ls.m1346c("Preparing looper");
                        }
                        Looper.prepare();
                    }
                    r0 = ik.m1175a(this.f1380a);
                    if (r0 == null) {
                        if (hc.f1269b) {
                            ls.m1347d("sendLocation GPS null");
                        }
                        r0 = ik.m1177c(this.f1380a);
                        if (r0 == null && hc.f1269b) {
                            ls.m1347d("sendLocation lastKnown null");
                        }
                    }
                    if (Looper.myLooper() != null) {
                        if (hc.f1269b) {
                            ls.m1346c("Quitting myLooper");
                        }
                        Looper.myLooper().quit();
                    }
                    if (r0 != null) {
                        C0152if a = ie.m1167a(r0.getLatitude(), r0.getLongitude());
                        if (a.f1442a.isEmpty()) {
                            this.dF = "Sorry, but I couldn't find any nearby locations. You may need to reauthorise Four Square in the linked applications section. ";
                            jy.m1252g(this.f1380a);
                        } else {
                            if (hc.f1269b) {
                                ls.m1346c("myVenueProcess.toVenueName: " + a.f1442a.size() + " : " + a.f1442a.toString());
                                ls.m1346c("myVenueProcess.toVenueID: " + a.f1443b.size() + " : " + a.f1443b.toString());
                            }
                            this.f1376V = new ArrayList();
                            Context context = this.f1380a;
                            this.f1376V = ie.m1169a(this.f1363I, a.f1442a, a.f1443b);
                            if (this.f1376V.isEmpty()) {
                                this.dF = "Sorry, but I couldn't find a matching nearby location.";
                                jy.m1252g(this.f1380a);
                            } else {
                                if (hc.f1269b) {
                                    ls.m1346c("toReturn: " + this.f1376V.size() + " : " + this.f1376V.toString());
                                }
                                if (this.f1376V.size() > 2) {
                                    if (hc.f1269b) {
                                        ls.m1346c("FourSquare loc closest match");
                                    }
                                    this.dF = "I found the closest match of " + ((String) this.f1376V.get(0)) + " nearby";
                                    jy.m1255h(this.f1380a, (String) this.f1376V.get(1));
                                } else {
                                    if (hc.f1269b) {
                                        ls.m1346c("FourSquare loc exact match");
                                    }
                                    this.dF = "I found " + ((String) this.f1376V.get(0)) + " nearby";
                                    jy.m1255h(this.f1380a, (String) this.f1376V.get(1));
                                }
                            }
                        }
                    } else {
                        this.dF = "Sorry, but I couldn't get a location fix.";
                        jy.m1252g(this.f1380a);
                    }
                }
            } else if (this.bR) {
                if (hc.f1269b) {
                    ls.m1346c("commandFindCar: " + this.bR);
                }
            } else if (this.bW) {
                if (hc.f1269b) {
                    ls.m1346c("commandReleaseResources: " + this.bW);
                }
            } else if (this.bU) {
                if (hc.f1269b) {
                    ls.m1346c("commandCallNumber: " + this.bU);
                }
            } else if (this.bS) {
                if (hc.f1269b) {
                    ls.m1346c("commandAppSearch: " + this.bS);
                }
                if (this.dE.endsWith("applications") || this.dE.endsWith("applications") || this.dE.endsWith("apps")) {
                    this.dE = "null";
                    Iterator it = this.f1361G.iterator();
                    while (it.hasNext()) {
                        replaceFirst = (String) it.next();
                        if (replaceFirst.contains("featured")) {
                            this.dE = "http://play.google.com/store/apps/collection/featured";
                        } else if (replaceFirst.contains("editor") && replaceFirst.contains("choice")) {
                            this.dE = "http://play.google.com/store/apps/collection/editors_choice";
                        } else if (replaceFirst.contains("top") && replaceFirst.contains("new") && replaceFirst.contains("free")) {
                            this.dE = "http://play.google.com/store/apps/collection/topselling_new_free";
                        } else if (replaceFirst.contains("top") && replaceFirst.contains("new") && replaceFirst.contains("paid")) {
                            this.dE = "http://play.google.com/store/apps/collection/topselling_new_paid";
                        } else if (replaceFirst.contains("top") && replaceFirst.contains("paid")) {
                            this.dE = "http://play.google.com/store/apps/collection/topselling_paid";
                        } else if (replaceFirst.contains("top") && replaceFirst.contains("free")) {
                            this.dE = "http://play.google.com/store/apps/collection/topselling_free";
                        } else if (replaceFirst.contains("top") && replaceFirst.contains("grossing")) {
                            this.dE = "http://play.google.com/store/apps/collection/topgrossing";
                        } else if (replaceFirst.contains("trending")) {
                            this.dE = "http://play.google.com/store/apps/collection/movers_shakers";
                        }
                    }
                } else {
                    split = null;
                    if (this.dE.contains("apps")) {
                        split = this.dE.split("apps");
                    } else if (this.dE.contains("applications")) {
                        split = this.dE.split("applications");
                    } else if (this.dE.contains("application")) {
                        split = this.dE.split("application");
                    } else if (this.dE.contains("app")) {
                        split = this.dE.split("app");
                    }
                    if (split == null || split.length <= 1) {
                        this.dE = "null";
                    } else {
                        this.dE = "market://search?q=" + split[1] + "&c=apps";
                    }
                }
            } else if (this.bx) {
                if (hc.f1269b) {
                    ls.m1346c("commandVisual: " + this.bx);
                }
            } else if (this.bQ) {
                if (hc.f1269b) {
                    ls.m1346c("commandRemember: " + this.bQ);
                }
                this.dE = this.dE.replaceFirst("remember this ", "");
            } else if (this.bP) {
                if (hc.f1269b) {
                    ls.m1346c("commandRedial: " + this.bP);
                }
            } else if (this.ad) {
                if (hc.f1269b) {
                    ls.m1346c("commandFuckOff: " + this.ad);
                }
            } else if (this.bO) {
                if (hc.f1269b) {
                    ls.m1346c("commandFloatCommands: " + this.bO);
                }
            } else if (this.bN) {
                if (hc.f1269b) {
                    ls.m1346c("commandReadSMS: " + this.bN);
                }
            } else if (this.bI) {
                if (hc.f1269b) {
                    ls.m1346c("commandUserVolume: " + this.bI);
                }
                if (this.bJ) {
                    nm.m1499c(this.f1380a);
                } else if (this.bK) {
                    nm.m1497a(this.f1380a);
                } else if (this.bL) {
                    nm.m1500d(this.f1380a);
                } else if (this.bM) {
                    nm.m1498b(this.f1380a);
                }
                this.dF = "How's this?";
            } else if (this.bH) {
                if (hc.f1269b) {
                    ls.m1346c("commandStreamMusic: " + this.bH);
                }
                publishProgress(new String[]{"I'm searching for that track."});
                ArrayList arrayList = new ArrayList();
                arrayList = new ArrayList();
                arrayList = new ArrayList();
                jx playMusicSearch = ExecuteGoogleMusic.playMusicSearch(this.f1380a, (String) this.f1386g.get(0));
                ArrayList arrayList2 = playMusicSearch.f1581a;
                ArrayList arrayList3 = playMusicSearch.f1582b;
                if (hc.f1269b) {
                    ls.m1344a("In trackAT: " + arrayList2.size() + " : " + arrayList2.toString());
                }
                if (hc.f1269b) {
                    ls.m1344a("In trackURI: " + arrayList3.size() + " : " + arrayList3.toString());
                }
                if (arrayList2.isEmpty()) {
                    if (hc.f1269b) {
                        ls.m1347d("musicList empty");
                    }
                    this.dF = "Sorry, but I couldn't get a match for that track";
                    this.dH = 1;
                } else if (((String) arrayList2.get(0)).matches("error")) {
                    if (hc.f1269b) {
                        ls.m1347d("musicList error");
                    }
                    if (((String) arrayList2.get(1)).matches("network")) {
                        if (hc.f1269b) {
                            ls.m1347d("network error");
                        }
                        this.dF = "I'm getting a network error";
                    } else if (((String) arrayList2.get(1)).matches(PropertyConsts.PASSWORD)) {
                        if (hc.f1269b) {
                            ls.m1347d("password error");
                        }
                        this.dF = "I couldn't verify your credentials. Please log in to Google Music from the Linked Applications tab.";
                    } else {
                        this.dF = "Something went wrong searching your cloud music data base";
                        this.dH = 1;
                    }
                } else {
                    r0 = this.f1380a;
                    arrayList = ig.m1170a(this.f1386g, arrayList2, arrayList3);
                    if (arrayList.isEmpty()) {
                        this.dF = "Sorry, but I couldn't find that track";
                        this.dH = 1;
                    } else {
                        if (hc.f1269b) {
                            ls.m1344a("In trackResult: " + arrayList.size() + " : " + arrayList.toString());
                        }
                        if (!jy.m1233a(this.f1380a, (String) arrayList.get(1), true)) {
                            this.dF = "Sorry, but I couldn't find an application that supports media streaming";
                            this.dH = 1;
                        }
                    }
                }
            } else if (this.bF) {
                if (hc.f1269b) {
                    ls.m1346c("commandDate: " + this.bF);
                }
                this.dF = hy.m1158a();
            } else if (this.bD) {
                if (hc.f1269b) {
                    ls.m1346c("commandHelp: " + this.bD);
                }
            } else if (this.al) {
                if (hc.f1269b) {
                    ls.m1344a("commandFacebook: " + this.al);
                }
            } else if (this.by) {
                if (hc.f1269b) {
                    ls.m1346c("commandLink: " + this.by);
                }
            } else if (this.bw) {
                if (hc.f1269b) {
                    ls.m1346c("commandEdit: " + this.bw);
                }
                if (this.dc) {
                    this.dD = iz.m1194a();
                }
            } else if (this.bu) {
                if (hc.f1269b) {
                    ls.m1346c("commandFilm: " + this.bu);
                }
            } else if (this.bE) {
                if (hc.f1269b) {
                    ls.m1346c("commandPardon: " + this.bE);
                }
                replaceFirst = GlobalV.m797J();
                if (replaceFirst == null || replaceFirst.matches("")) {
                    this.dF = "Sorry, but I've completely forgotten what I was talking about.";
                } else {
                    this.dF = "I said. " + replaceFirst;
                }
            } else if (this.bq) {
                if (hc.f1269b) {
                    ls.m1346c("commandDropbox: " + this.bq);
                }
            } else if (this.bZ) {
                if (hc.f1269b) {
                    ls.m1346c("commandCallBack: " + this.bZ);
                }
                jy.m1224a(this.f1380a);
            } else if (this.bB) {
                if (hc.f1269b) {
                    ls.m1346c("commandHeadsetC: " + this.bB);
                }
                if (GlobalV.m802O()) {
                    this.dF = "I think I'm already controlling the headset";
                } else {
                    GlobalV.m871n(true);
                    this.dF = "Okay, I'm controlling the headset";
                }
            } else if (this.bC) {
                if (hc.f1269b) {
                    ls.m1346c("commandHeadsetR: " + this.bC);
                }
                if (GlobalV.m802O()) {
                    GlobalV.m871n(false);
                    this.dF = "Okay, I've released the headset";
                } else {
                    this.dF = "I don't think I have control of the headset";
                }
            } else if (this.br) {
                if (hc.f1269b) {
                    ls.m1346c("commandCalculate: " + this.br);
                }
                r0 = this.f1380a;
                this.f1376V = hp.m1130a(this.f1382d);
                if (!this.f1376V.isEmpty() && this.f1376V.size() == 2) {
                    GlobalV.m899w(true);
                    this.dF = (String) this.f1376V.get(0);
                    this.dz = new StringBuilder(String.valueOf((String) this.f1376V.get(1))).append(" = ").append((String) this.f1376V.get(0)).toString();
                } else if (this.f1379Z) {
                    this.f1382d.add(0, "http://api.wolframalpha.com/v2/query?appid=RRTVWX-G83L2WJT2X&input=" + ((String) this.f1382d.get(0)).replaceAll(" ", "%20").trim() + "&format=plaintext");
                    r0 = this.f1380a;
                    r0 = ii.m1172a(this.f1382d);
                    if (r0.f1445a == null || r0.f1445a.matches("error")) {
                        this.dF = "Sorry, but I couldn't " + ((String) this.f1382d.get(1));
                    } else {
                        if (hc.f1269b) {
                            ls.m1346c("calculate.structuredResponse: " + r0.f1445a);
                        }
                        GlobalV.m899w(true);
                        this.dF = r0.f1445a;
                    }
                } else if (!jy.m1262m(this.f1380a, "com.wolfram.android.alpha")) {
                    this.dF = "Sorry, but I couldn't get an answer for that. Complex calculation is currently disabled.";
                    this.dH = 1;
                } else if (this.f1382d.isEmpty()) {
                    this.dF = "Sorry, but I couldn't structure that calculation";
                } else if (jy.m1238b(this.f1380a, (String) this.f1382d.get(0))) {
                    this.dF = "Calculating";
                } else {
                    this.dF = "Sorry, something went wrong passing the calculation to Wolfram Alpha";
                }
            } else if (this.bt) {
                if (hc.f1269b) {
                    ls.m1346c("commandVoiceNote: " + this.bt);
                }
            } else if (this.bs) {
                if (hc.f1269b) {
                    ls.m1346c("commandNote: " + this.bs);
                }
            } else if (this.be || this.bo) {
                if (hc.f1269b) {
                    ls.m1346c("commandDefine: " + this.be);
                    ls.m1346c("commandKnowledge: " + this.bo);
                }
                if (this.f1379Z) {
                    r0 = this.f1380a;
                    r0 = ii.m1172a(this.f1387h);
                    if (r0.f1445a == null || r0.f1445a.matches("error")) {
                        this.dF = r0.f1445a;
                    } else {
                        if (hc.f1269b) {
                            ls.m1346c("myKnowledgeProcess.structuredResponse: " + r0.f1445a);
                        }
                        GlobalV.m899w(true);
                        if (this.f1387h.size() <= 1) {
                            this.dF = r0.f1445a;
                        } else if (this.f1387h.contains("define existentialism")) {
                            this.dF = "Existentialism has English word origins. Definition. Noun. A philosophical theory or approach that emphasizes the existence of the individual person as a free and responsible agent determining their own development through acts of the will.";
                        } else {
                            this.dF = r0.f1445a;
                        }
                    }
                } else if (!jy.m1262m(this.f1380a, "com.wolfram.android.alpha")) {
                    this.dF = "Sorry, but this feature is currently disabled.";
                } else if (this.f1385f.isEmpty()) {
                    this.dF = "Sorry, but I couldn't structure that question";
                } else if (jy.m1238b(this.f1380a, (String) this.f1385f.get(0))) {
                    this.dF = "One moment";
                } else {
                    this.dF = "Sorry, something went wrong passing the query to Wolfram Alpha";
                }
            } else if (this.bf) {
                if (hc.f1269b) {
                    ls.m1346c("commandSpell: " + this.bf);
                }
            } else if (this.bp) {
                if (hc.f1269b) {
                    ls.m1346c("commandToast: " + this.bp);
                }
            } else if (this.bg || this.bh) {
                if (hc.f1269b) {
                    ls.m1346c("commandDirectory: " + this.bg);
                }
                if (this.bh) {
                    this.f1373S = new ic().m1164a(this.f1380a, this.f1389j, true);
                } else {
                    this.f1373S = new ic().m1164a(this.f1380a, this.f1389j, false);
                }
            } else if (this.bi) {
                if (hc.f1269b) {
                    ls.m1346c("commandShow: " + this.bi);
                }
            } else if (this.bj) {
                if (hc.f1269b) {
                    ls.m1346c("commandAlarm: " + this.bj);
                }
                this.f1375U = hn.m1125a(this.f1374T);
            } else if (this.bk) {
                if (hc.f1269b) {
                    ls.m1346c("commandCalendar: " + this.bk);
                }
                this.f1375U = hq.m1131a(this.f1380a, this.f1360F);
            } else if (this.bl) {
                if (hc.f1269b) {
                    ls.m1346c("commandNavigate: " + this.bl);
                }
            } else if (this.bm) {
                if (hc.f1269b) {
                    ls.m1346c("commandLocateCar: " + this.bm);
                }
            } else if (this.bn) {
                if (hc.f1269b) {
                    ls.m1346c("commandPlayMusic: " + this.bn);
                }
                im imVar = new im();
                this.f1372R = im.m1178a(this.f1380a, this.f1390k);
                if (hc.f1269b) {
                    ls.m1344a("getTrack: " + this.f1372R.toString());
                }
            } else if (this.bb) {
                if (hc.f1269b) {
                    ls.m1346c("commandCreate: " + this.bb);
                }
            } else if (this.bc) {
                if (hc.f1269b) {
                    ls.m1346c("commandTranslate: " + this.bc);
                }
                if (this.f1391l.isEmpty()) {
                    this.dF = "Sorry, but I didn't hear anything to translate.";
                    this.dH = 1;
                } else if (this.cV) {
                    GlobalV.m884r(true);
                    GlobalV.m885s("german");
                    this.dF = kk.m1303a((String) this.f1391l.get(0));
                } else if (this.cW) {
                    GlobalV.m884r(true);
                    GlobalV.m885s("french");
                    this.dF = kk.m1303a((String) this.f1391l.get(0));
                } else if (this.cX) {
                    GlobalV.m884r(true);
                    GlobalV.m885s("italian");
                    this.dF = kk.m1303a((String) this.f1391l.get(0));
                } else if (this.cY) {
                    GlobalV.m884r(true);
                    GlobalV.m885s("polish");
                    this.dF = kk.m1303a((String) this.f1391l.get(0));
                } else if (this.cZ) {
                    GlobalV.m884r(true);
                    GlobalV.m885s("spanish");
                    this.dF = kk.m1303a((String) this.f1391l.get(0));
                } else if (this.da) {
                    GlobalV.m884r(true);
                    GlobalV.m885s("romanian");
                    this.dF = kk.m1303a((String) this.f1391l.get(0));
                }
            } else if (this.aZ) {
                if (hc.f1269b) {
                    ls.m1346c("commandMD5: " + this.aZ);
                }
                this.dD = jr.m1214a();
            } else if (this.aG) {
                if (hc.f1269b) {
                    ls.m1346c("commandUserName: " + this.aG);
                }
                if (this.dx.matches("")) {
                    this.dF = "Okay " + ((String) this.f1400u.get(0));
                } else {
                    this.dF = this.dx + ((String) this.f1400u.get(0));
                }
                lx.m1411c(this.f1380a, (String) this.f1400u.get(0), true);
                lx.m1416d(this.f1380a, "", false);
            } else if (this.aY) {
                if (hc.f1269b) {
                    ls.m1346c("commandZip: " + this.aY);
                }
                if (this.de) {
                    this.dD = iz.m1194a();
                }
            } else if (this.ba) {
                if (hc.f1269b) {
                    ls.m1346c("commandJoke: " + this.ba);
                }
                if (hc.f1270c) {
                    boolean z;
                    trim = "";
                    try {
                        trim = ih.m1171a(this.f1380a, ki.m1302d(this.f1380a));
                        if (!trim.matches("null")) {
                            z = true;
                            if (z) {
                                this.dF = "Sorry, something went wrong getting a joke to tell you.";
                            } else {
                                if (hc.f1269b) {
                                    ls.m1346c("joke: " + trim);
                                }
                                if (trim.matches("null")) {
                                    this.dF = "Sorry, something went wrong formatting the joke.";
                                } else if (trim.matches("response")) {
                                    this.dF = GlobalV.m814a(0).replace("S:", "");
                                    if (this.dF.matches("null")) {
                                        GlobalV.m889t(true);
                                        GlobalV.m862l(1);
                                        f1354b = true;
                                    } else {
                                        this.dF = "Sorry, something went wrong with my joke telling skills";
                                    }
                                } else if (trim.matches("obsen")) {
                                    this.dF = "Sorry, I was about to tell an unsuitable joke. My database may have been compromised.";
                                }
                            }
                        }
                    } catch (InvalidKeyException e3) {
                        e3.printStackTrace();
                        z = false;
                    } catch (NoSuchAlgorithmException e4) {
                        e4.printStackTrace();
                        z = false;
                    } catch (NoSuchPaddingException e5) {
                        e5.printStackTrace();
                        z = false;
                    } catch (IllegalBlockSizeException e6) {
                        e6.printStackTrace();
                        z = false;
                    } catch (BadPaddingException e7) {
                        e7.printStackTrace();
                        z = false;
                    } catch (InvalidAlgorithmParameterException e8) {
                        e8.printStackTrace();
                        z = false;
                    } catch (UnsupportedEncodingException e9) {
                        e9.printStackTrace();
                        z = false;
                    } catch (ClientProtocolException e10) {
                        e10.printStackTrace();
                        z = false;
                    } catch (ParseException e11) {
                        e11.printStackTrace();
                        z = false;
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    z = false;
                    if (z) {
                        this.dF = "Sorry, something went wrong getting a joke to tell you.";
                    } else {
                        if (hc.f1269b) {
                            ls.m1346c("joke: " + trim);
                        }
                        if (trim.matches("null")) {
                            this.dF = "Sorry, something went wrong formatting the joke.";
                        } else if (trim.matches("response")) {
                            this.dF = GlobalV.m814a(0).replace("S:", "");
                            if (this.dF.matches("null")) {
                                GlobalV.m889t(true);
                                GlobalV.m862l(1);
                                f1354b = true;
                            } else {
                                this.dF = "Sorry, something went wrong with my joke telling skills";
                            }
                        } else if (trim.matches("obsen")) {
                            this.dF = "Sorry, I was about to tell an unsuitable joke. My database may have been compromised.";
                        }
                    }
                } else {
                    this.dF = "Sorry, but I don't have a great sense of humor at the moment. Please feel free to email the developer with any family friendly jokes you think I should tell.";
                }
            } else if (this.aX) {
                if (hc.f1269b) {
                    ls.m1346c("commandScreenShot: " + this.aX);
                }
            } else if (this.bd) {
                if (hc.f1269b) {
                    ls.m1346c("commandeBay: " + this.bd);
                }
            } else if (this.aW) {
                if (hc.f1269b) {
                    ls.m1346c("commandGoTo: " + this.aW);
                }
                replaceFirst = jj.m1205a(this.f1392m);
                if (replaceFirst.matches("false")) {
                    if (hc.f1269b) {
                        ls.m1344a("getURL: " + replaceFirst);
                    }
                    this.dF = "Sorry, but I couldn't resolve that web address.";
                    this.dH = 1;
                } else {
                    if (hc.f1269b) {
                        ls.m1344a("getURL: " + replaceFirst);
                    }
                    jy.m1274y(this.f1380a, replaceFirst);
                    replaceFirst = replaceFirst.replaceFirst("http://www.", "").trim();
                    if (replaceFirst.contains("androidpolice")) {
                        this.dF = "Browsing Android Police dot com";
                    } else {
                        this.dF = "Browsing " + replaceFirst;
                    }
                }
            } else if (this.aT) {
                if (hc.f1269b) {
                    ls.m1346c("commandEmail: " + this.aT);
                }
                this.f1394o.add(0, "getEmail");
                this.f1369O = hx.m1150a(this.f1380a, this.f1394o);
                if (hc.f1269b) {
                    ls.m1344a("getContact: " + this.f1369O.size() + " : " + this.f1369O.toString());
                }
                if (this.f1369O.isEmpty()) {
                    this.dF = "Sorry, something went wrong trying to email that contact";
                    this.dH = 1;
                } else if (this.f1369O.size() <= 2) {
                    this.dF = (String) this.f1369O.get(1);
                } else if (((String) this.f1369O.get(0)).matches("ERROR")) {
                    this.dF = (String) this.f1369O.get(1);
                } else {
                    this.dr = (String) this.f1369O.get(0);
                    this.dq = (String) this.f1369O.get(1);
                    this.dt = (String) this.f1369O.get(2);
                    GlobalV.m893u(true);
                    GlobalV.m785A(true);
                    GlobalV.m866m(1);
                    GlobalV.m888t(this.dt);
                    f1354b = true;
                    this.dF = "Ok, what do you want to say to " + this.dr;
                    GlobalV.m860k(true);
                }
            } else if (this.aU) {
                if (hc.f1269b) {
                    ls.m1346c("commandSMS: " + this.aU);
                }
                this.f1393n.add(0, "getSMS");
                this.f1369O = hx.m1150a(this.f1380a, this.f1393n);
                if (hc.f1269b) {
                    ls.m1344a("getContact: " + this.f1369O.size() + " : " + this.f1369O.toString());
                }
                if (this.f1369O.isEmpty()) {
                    this.dF = "Sorry, something went wrong trying to text that contact";
                    this.dH = 1;
                } else if (this.f1369O.size() <= 2) {
                    this.dF = (String) this.f1369O.get(1);
                } else if (((String) this.f1369O.get(0)).matches("ERROR")) {
                    this.dF = (String) this.f1369O.get(1);
                } else {
                    this.dr = (String) this.f1369O.get(0);
                    this.dq = (String) this.f1369O.get(1);
                    this.ds = (String) this.f1369O.get(2);
                    GlobalV.m784A(this.ds);
                    GlobalV.m893u(true);
                    GlobalV.m787B(true);
                    GlobalV.m869n(1);
                    f1354b = true;
                    this.dF = "Ok, what do you want to say to " + this.dr;
                    GlobalV.m860k(true);
                }
            } else if (this.aV) {
                if (hc.f1269b) {
                    ls.m1346c("commandWhere: " + this.aV);
                }
            } else if (this.aS) {
                if (hc.f1269b) {
                    ls.m1346c("commandSkype: " + this.aS);
                }
                this.f1396q.add(0, "getSkype");
                this.f1371Q = hx.m1150a(this.f1380a, this.f1396q);
                if (hc.f1269b) {
                    ls.m1344a("getSkypeID: " + this.f1371Q.size() + this.f1371Q.toString());
                }
                if (this.f1371Q.isEmpty()) {
                    this.dF = "Sorry, something went wrong trying to Skype that contact";
                    this.dH = 1;
                } else if (this.f1371Q.size() <= 2) {
                    this.dF = (String) this.f1371Q.get(1);
                } else if (((String) this.f1371Q.get(0)).matches("ERROR")) {
                    this.dF = (String) this.f1371Q.get(1);
                } else {
                    this.cU = true;
                    this.dr = (String) this.f1371Q.get(0);
                    this.dq = (String) this.f1371Q.get(1);
                    this.dy = (String) this.f1371Q.get(2);
                    this.dF = "Skyping " + this.dr;
                }
            } else if (this.aP) {
                if (hc.f1269b) {
                    ls.m1346c("commandForeground: " + this.aP);
                }
                replaceFirst = id.m1165a(this.f1380a);
                if (replaceFirst.matches("none")) {
                    if (hc.f1269b) {
                        ls.m1344a("getFA: " + replaceFirst);
                    }
                    this.dF = "Sorry, but I can't detect the foreground application.";
                    this.dH = 1;
                } else {
                    if (hc.f1269b) {
                        ls.m1344a("getFA: " + replaceFirst);
                    }
                    if (replaceFirst.contains("utter!")) {
                        this.dF = "That would be me.";
                    } else {
                        this.dF = "I'm watching you use the " + replaceFirst + " application";
                    }
                }
            } else if (this.aH) {
                if (hc.f1269b) {
                    ls.m1346c("commandShakeSetting: " + this.aH);
                }
            } else if (this.ak) {
                if (hc.f1269b) {
                    ls.m1346c("commandTasker: " + this.ak);
                }
            } else if (this.aK) {
                if (hc.f1269b) {
                    ls.m1346c("commandDeveloperPassword: " + this.aK);
                }
            } else if (this.aM) {
                if (hc.f1269b) {
                    ls.m1346c("commandUserPassword: " + this.aM);
                }
            } else if (this.aQ) {
                if (hc.f1269b) {
                    ls.m1346c("commandKill: " + this.aQ);
                }
                this.dF = ka.m1277a(this.f1380a, this.f1397r);
            } else if (this.aO) {
                if (hc.f1269b) {
                    ls.m1346c("commandClipboard: " + this.aO);
                }
            } else if (this.az) {
                if (hc.f1269b) {
                    ls.m1346c("commandFly: " + this.az);
                }
            } else if (this.aC) {
                if (hc.f1269b) {
                    ls.m1346c("commandRinger: " + this.aC);
                }
            } else if (this.aA) {
                if (hc.f1269b) {
                    ls.m1346c("commandBattery: " + this.aA);
                }
                if (this.du.matches("unknown")) {
                    this.dF = "Sorry, but I didn't recognise that battery information request.";
                    this.dH = 1;
                } else {
                    replaceFirst = gv.m1000a(this.f1380a, this.du);
                    if (hc.f1269b) {
                        ls.m1344a("batResponse: " + replaceFirst);
                    }
                    if (replaceFirst.matches("error")) {
                        this.dF = "Sorry, but there was a problem retrieving your battery information.";
                        this.dH = 1;
                    } else {
                        this.dF = "Your battery " + this.du + " is " + replaceFirst;
                    }
                }
            } else if (this.ay) {
                if (hc.f1269b) {
                    ls.m1346c("commandApplication: " + this.ay);
                }
                if (this.f1357C.size() > 0) {
                    this.f1370P = new ho().m1129a(this.f1380a, this.f1357C);
                    if (hc.f1269b) {
                        ls.m1344a("getApp: " + this.f1370P.size() + " : " + this.f1370P.toString());
                    }
                }
            } else if (this.at || this.au) {
                if (hc.f1269b) {
                    ls.m1346c("commandSearchGoogle: " + this.at);
                }
                if (hc.f1269b) {
                    ls.m1346c("commandSearchBing: " + this.au);
                }
            } else if (this.aR) {
                if (hc.f1269b) {
                    ls.m1346c("commandConnection: " + this.aR);
                }
                hv a2 = ht.m1145a(this.f1395p);
                if (hc.f1269b) {
                    ls.m1346c("asResponse.returnStatus: " + a2.f1417a);
                }
                if (a2.f1417a.equals(hu.bluetooth) || a2.f1417a.equals(hu.wifi) || a2.f1417a.equals(hu.data) || a2.f1417a.equals(hu.airplance)) {
                    ir a3 = ip.m1182a(this.f1395p);
                    if (hc.f1269b) {
                        ls.m1346c("oopResponse.returnStatus: " + a3.f1479a);
                        ls.m1346c("oopResponse.returnData: " + a3.f1480b.size() + " : " + a3.f1480b.toString());
                    }
                    if (a3.f1479a.equals(iq.on)) {
                        if (a2.f1417a.equals(hu.bluetooth)) {
                            this.cb = true;
                            if (hc.f1269b) {
                                ls.m1346c("blueON: " + this.cb);
                            }
                        }
                        if (a2.f1417a.equals(hu.wifi)) {
                            this.cf = true;
                            if (hc.f1269b) {
                                ls.m1346c("wifiON: " + this.cf);
                            }
                        }
                        if (a2.f1417a.equals(hu.data)) {
                            this.cj = true;
                            if (hc.f1269b) {
                                ls.m1346c("dataON: " + this.cj);
                            }
                        }
                        if (a2.f1417a.equals(hu.airplance)) {
                            this.cm = true;
                            if (hc.f1269b) {
                                ls.m1346c("airON: " + this.cm);
                            }
                        }
                    } else if (a3.f1479a.equals(iq.off)) {
                        if (a2.f1417a.equals(hu.bluetooth)) {
                            this.cc = true;
                            if (hc.f1269b) {
                                ls.m1346c("blueOFF: " + this.cc);
                            }
                        }
                        if (a2.f1417a.equals(hu.wifi)) {
                            this.cg = true;
                            if (hc.f1269b) {
                                ls.m1346c("wifiOFF: " + this.cg);
                            }
                        }
                        if (a2.f1417a.equals(hu.data)) {
                            this.ck = true;
                            if (hc.f1269b) {
                                ls.m1346c("dataOFF: " + this.ck);
                            }
                        }
                        if (a2.f1417a.equals(hu.airplance)) {
                            this.cn = true;
                            if (hc.f1269b) {
                                ls.m1346c("airOFF: " + this.cn);
                            }
                        }
                    } else if (a3.f1479a.equals(iq.toggle)) {
                        if (a2.f1417a.equals(hu.bluetooth)) {
                            this.ca = true;
                            if (hc.f1269b) {
                                ls.m1346c("blueTOG: " + this.ca);
                            }
                        }
                        if (a2.f1417a.equals(hu.wifi)) {
                            this.ce = true;
                            if (hc.f1269b) {
                                ls.m1346c("wifiTOG: " + this.ce);
                            }
                        }
                        if (a2.f1417a.equals(hu.data)) {
                            this.ci = true;
                            if (hc.f1269b) {
                                ls.m1346c("dataTOG: " + this.ci);
                            }
                        }
                        if (a2.f1417a.equals(hu.airplance)) {
                            this.cp = true;
                            if (hc.f1269b) {
                                ls.m1346c("airTOG: " + this.cp);
                            }
                        }
                    } else if (a3.f1479a.equals(iq.multipleOnOff)) {
                        if (a2.f1417a.equals(hu.bluetooth)) {
                            this.cd = true;
                            if (hc.f1269b) {
                                ls.m1346c("blueMULTI: " + this.cd);
                            }
                        }
                        if (a2.f1417a.equals(hu.wifi)) {
                            this.ch = true;
                            if (hc.f1269b) {
                                ls.m1346c("wifiMULTI: " + this.ch);
                            }
                        }
                        if (a2.f1417a.equals(hu.data)) {
                            this.cl = true;
                            if (hc.f1269b) {
                                ls.m1346c("dataMULTI: " + this.cl);
                            }
                        }
                        if (a2.f1417a.equals(hu.airplance)) {
                            this.co = true;
                            if (hc.f1269b) {
                                ls.m1346c("airMULTI: " + this.co);
                            }
                        }
                    } else if (a3.f1479a.equals(iq.error)) {
                        this.dF = "Sorry, something went wrong processing that command.";
                        this.dH = 1;
                    }
                } else if (a2.f1417a.equals(hu.multipleCommand)) {
                    this.dF = "Sorry, but I detected multiple connection commands.";
                    this.dH = 1;
                }
            } else if (this.ag) {
                if (hc.f1269b) {
                    ls.m1344a("commandCall: " + this.ag);
                }
                if (this.aq) {
                    this.f1401v.add(0, "getWork");
                } else if (this.ap) {
                    this.f1401v.add(0, "getHome");
                } else if (this.ar) {
                    this.f1401v.add(0, "getMobile");
                }
                if (!this.f1401v.isEmpty()) {
                    this.f1369O = hx.m1150a(this.f1380a, this.f1401v);
                } else if (!this.f1402w.isEmpty()) {
                    this.f1402w.add(0, "getAll");
                    this.f1369O = hx.m1150a(this.f1380a, this.f1402w);
                }
                if (hc.f1269b) {
                    ls.m1344a("getContact: " + this.f1369O.toString());
                }
                if (this.f1369O.isEmpty()) {
                    this.dF = "Sorry, something went wrong searching for that contact";
                    this.dH = 1;
                } else if (this.f1401v.isEmpty()) {
                    if (this.f1369O.size() <= 2) {
                        this.dF = "Sorry, something went wrong searching for that contact";
                        this.dH = 1;
                    } else if (((String) this.f1369O.get(0)).matches("ERROR")) {
                        this.dF = (String) this.f1369O.get(1);
                        this.dH = 1;
                    } else if (this.f1369O.contains("mobile") && this.f1369O.contains("work") && this.f1369O.contains("home")) {
                        GlobalV.m846h((String) this.f1369O.get(0));
                        f1354b = true;
                        GlobalV.m893u(true);
                        GlobalV.m864l(true);
                        this.dF = "Do you want to call " + ((String) this.f1369O.get(0)) + " at work, at home, or on their mobile?";
                    } else if (this.f1369O.contains("mobile") && this.f1369O.contains("work") && !this.f1369O.contains("home")) {
                        GlobalV.m846h((String) this.f1369O.get(0));
                        f1354b = true;
                        GlobalV.m893u(true);
                        GlobalV.m864l(true);
                        this.dF = "Do you want to call " + ((String) this.f1369O.get(0)) + " at work, or on their mobile?";
                    } else if (this.f1369O.contains("mobile") && !this.f1369O.contains("work") && this.f1369O.contains("home")) {
                        GlobalV.m846h((String) this.f1369O.get(0));
                        f1354b = true;
                        GlobalV.m893u(true);
                        GlobalV.m864l(true);
                        this.dF = "Do you want to call " + ((String) this.f1369O.get(0)) + " at home, or on their mobile?";
                    } else if (!this.f1369O.contains("mobile") && this.f1369O.contains("work") && this.f1369O.contains("home")) {
                        GlobalV.m846h((String) this.f1369O.get(0));
                        f1354b = true;
                        GlobalV.m893u(true);
                        GlobalV.m864l(true);
                        this.dF = "Do you want to call " + ((String) this.f1369O.get(0)) + " at work, or at home?";
                    } else if (this.f1369O.contains("mobile") && !this.f1369O.contains("work") && !this.f1369O.contains("home")) {
                        this.cU = true;
                        this.dr = (String) this.f1369O.get(0);
                        this.dq = (String) this.f1369O.get(1);
                        this.ds = GlobalV.m795H();
                        this.ar = true;
                    } else if (!this.f1369O.contains("mobile") && this.f1369O.contains("work") && !this.f1369O.contains("home")) {
                        this.cU = true;
                        this.dr = (String) this.f1369O.get(0);
                        this.dq = (String) this.f1369O.get(1);
                        this.ds = GlobalV.m794G();
                        this.aq = true;
                    } else if (this.f1369O.contains("mobile") || this.f1369O.contains("work") || !this.f1369O.contains("home")) {
                        this.dF = "Sorry, but I couldn't find a match for that contact.";
                        this.dH = 1;
                    } else {
                        this.cU = true;
                        this.dr = (String) this.f1369O.get(0);
                        this.dq = (String) this.f1369O.get(1);
                        this.ds = GlobalV.m793F();
                        this.ap = true;
                    }
                } else if (this.f1369O.size() <= 2) {
                    this.dF = (String) this.f1369O.get(1);
                } else if (((String) this.f1369O.get(0)).matches("ERROR")) {
                    this.dF = (String) this.f1369O.get(1);
                } else {
                    this.cU = true;
                    this.dr = (String) this.f1369O.get(0);
                    this.dq = (String) this.f1369O.get(1);
                    this.ds = (String) this.f1369O.get(2);
                }
            } else if (this.af) {
                if (hc.f1269b) {
                    ls.m1344a("commandDisplay: " + this.af);
                }
                this.f1369O = hx.m1150a(this.f1380a, this.f1404y);
                if (hc.f1269b) {
                    ls.m1344a("getContact: " + this.f1369O.size() + " : " + this.f1369O.toString());
                }
                if (this.f1369O.isEmpty()) {
                    this.dF = "Sorry, but I couldn't find a match for that contact";
                    this.dH = 1;
                } else if (this.f1369O.size() <= 1) {
                    this.dF = (String) this.f1369O.get(1);
                    this.dH = 1;
                } else if (((String) this.f1369O.get(0)).matches("ERROR")) {
                    this.dF = (String) this.f1369O.get(1);
                    this.dH = 1;
                } else {
                    this.cU = true;
                    this.dr = (String) this.f1369O.get(0);
                    this.dq = (String) this.f1369O.get(1);
                }
            } else if (this.ac) {
                if (hc.f1269b) {
                    ls.m1344a("commandSuperUser: " + this.ac);
                }
                if (lx.ac(this.f1380a)) {
                    iy a4 = iw.m1193a(this.f1403x);
                    if (hc.f1269b) {
                        ls.m1346c("rpResponse.returnStatus: " + a4.f1513a);
                    }
                    if (hc.f1269b) {
                        ls.m1346c("rpResponse.returnData: " + a4.f1514b.size() + " : " + a4.f1514b.toString());
                    }
                    if (a4.f1513a.equals(ix.error)) {
                        this.dF = "Sorry, but an unknown Root command detected.";
                        this.dH = 1;
                    } else if (a4.f1513a.equals(ix.multipleCommand)) {
                        this.dF = "Sorry, but multiple Root commands were detected.";
                        this.dH = 1;
                    } else {
                        if (a4.f1513a.equals(ix.reboot)) {
                            this.cP = true;
                            if (hc.f1269b) {
                                ls.m1346c("rootReboot: " + this.cP);
                            }
                            GlobalV.m786B("rootReboot");
                        } else if (a4.f1513a.equals(ix.bootloader)) {
                            this.cR = true;
                            if (hc.f1269b) {
                                ls.m1346c("rootBootloader: " + this.cR);
                            }
                            GlobalV.m786B("rootBootloader");
                        } else if (a4.f1513a.equals(ix.recovery)) {
                            this.cQ = true;
                            if (hc.f1269b) {
                                ls.m1346c("rootRecovery: " + this.cQ);
                            }
                            GlobalV.m786B("rootRecovery");
                        } else if (a4.f1513a.equals(ix.hot)) {
                            this.cS = true;
                            if (hc.f1269b) {
                                ls.m1346c("rootHot: " + this.cS);
                            }
                            GlobalV.m786B("rootHot");
                        } else if (!(!a4.f1513a.equals(ix.governor) || a4.f1514b.isEmpty() || ((String) a4.f1514b.get(0)).matches("error"))) {
                            this.cT = true;
                            if (hc.f1269b) {
                                ls.m1346c("rootGovernor: " + this.cT);
                            }
                            GlobalV.m786B("rootGovernor");
                        }
                        if (a4.f1514b.isEmpty()) {
                            this.dF = "Sorry, but I couldn't identify that governor";
                            this.dH = 1;
                        } else if (((String) a4.f1514b.get(0)).matches("error")) {
                            this.dF = "Sorry, there was a problem retrieving your C P U governors";
                            this.dH = 1;
                        } else {
                            GlobalV.m898w((String) a4.f1514b.get(0));
                            f1354b = true;
                            this.dF = "Do you wish to grant the application, Utter, superuser permissions.";
                            GlobalV.m790C(true);
                            GlobalV.m904y(true);
                            GlobalV.m893u(true);
                        }
                    }
                } else {
                    this.dF = "Sorry, but your device needs root access for this function";
                    this.dH = 1;
                }
            } else if (this.ah || this.ai) {
                if (hc.f1269b) {
                    ls.m1344a("commandTime: " + this.ah);
                }
                if (hc.f1269b) {
                    ls.m1344a("commandTimeIn: " + this.ai);
                }
                if (!this.ai) {
                    r0 = this.f1380a;
                    this.dF = jh.m1203a();
                } else if (this.f1366L.isEmpty()) {
                    if (hc.f1269b) {
                        ls.m1347d("urlTime empty: " + this.f1366L.toString());
                    }
                    this.dF = "Sorry, something went wrong processing that time request";
                    this.dH = 1;
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("urlTime: " + this.f1366L.size() + " : " + this.f1366L.toString());
                    }
                    ji a5 = jh.m1202a(this.f1380a, this.f1366L);
                    if (hc.f1269b) {
                        ls.m1346c("myTimeProcess.locationName: " + a5.f1542b);
                    }
                    this.dF = a5.f1543c;
                }
            } else if (this.an || this.ao) {
                if (hc.f1269b) {
                    ls.m1344a("commandWeather: " + this.an);
                    ls.m1344a("commandWeatherIn: " + this.ao);
                }
                if (this.f1368N.isEmpty()) {
                    if (hc.f1269b) {
                        ls.m1347d("urlWeather empty");
                    }
                    this.dF = "Sorry, but I couldn't access any recent location data for you.";
                    this.dH = 1;
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("urlWeather: " + this.f1368N.size() + " : " + this.f1368N.toString());
                    }
                    jm a6 = jl.m1210a(this.f1380a, this.f1368N);
                    if (hc.f1269b) {
                        ls.m1346c("myWeatherProcess.locationName: " + a6.f1547a);
                    }
                    this.dF = a6.f1551e;
                }
            } else if (hc.f1269b) {
                ls.m1347d("No Command Detected");
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private void m1143a() {
        if (hc.f1269b) {
            ls.m1345b("EstablishCommand onPostEx");
            ls.m1345b("haveCommand " + this.bv);
            ls.m1345b("commandSuperUser " + this.ac);
            ls.m1345b("commandEasterEgg " + this.ae);
            ls.m1345b("commandCancel " + this.aB);
            ls.m1345b("commandDisplay " + this.af);
            ls.m1345b("commandCall " + this.ag);
            ls.m1345b("commandDate " + this.bF);
            ls.m1345b("commandNone " + this.aj);
            ls.m1345b("multipleCommand " + this.ab);
            ls.m1345b("commandTasker " + this.ak);
            ls.m1345b("commandTaskerDisplay " + this.aJ);
            ls.m1345b("commandFacebook " + this.al);
            ls.m1345b("commandTwitter " + this.am);
            ls.m1345b("commandWeather " + this.an);
            ls.m1345b("commandWeatherIn " + this.ao);
            ls.m1345b("commandTime " + this.ah);
            ls.m1345b("commandTimeIn " + this.ai);
            ls.m1345b("commandHome " + this.ap);
            ls.m1345b("commandWork " + this.aq);
            ls.m1345b("commandMobile " + this.ar);
            ls.m1345b("commandSettings " + this.as);
            ls.m1345b("commandSearchGoogle " + this.at);
            ls.m1345b("commandSearchBing " + this.au);
            ls.m1345b("commandSearchYahoo " + this.av);
            ls.m1345b("commandImageSearch " + this.aw);
            ls.m1345b("commandVideoSearch " + this.ax);
            ls.m1345b("commandApplication " + this.ay);
            ls.m1345b("commandBattery " + this.aA);
            ls.m1345b("commandRinger " + this.aC);
            ls.m1345b("commandFly " + this.az);
            ls.m1345b("commandRing " + this.aD);
            ls.m1345b("commandSilent " + this.aE);
            ls.m1345b("commandVibrate " + this.aF);
            ls.m1345b("commandUserName " + this.aG);
            ls.m1345b("commandShakeSetting " + this.aH);
            ls.m1345b("commandWaveSetting " + this.aI);
            ls.m1345b("commandDeveloperPassword " + this.aK);
            ls.m1345b("commandDeveloperPasswordY " + this.aL);
            ls.m1345b("commandUserPassword " + this.aM);
            ls.m1345b("commandUserPasswordY " + this.aN);
            ls.m1345b("commandClipboard " + this.aO);
            ls.m1345b("commandForeground " + this.aP);
            ls.m1345b("commandKill " + this.aQ);
            ls.m1345b("commandConnection " + this.aR);
            ls.m1345b("commandSkype " + this.aS);
            ls.m1345b("commandEmail " + this.aT);
            ls.m1345b("commandSMS " + this.aU);
            ls.m1345b("commandWhere " + this.aV);
            ls.m1345b("commandGoTo " + this.aW);
            ls.m1345b("commandScreenShot " + this.aX);
            ls.m1345b("commandZip " + this.aY);
            ls.m1345b("commandMD5 " + this.aZ);
            ls.m1345b("commandJoke " + this.ba);
            ls.m1345b("commandCreate " + this.bb);
            ls.m1345b("commandTranslate " + this.bc);
            ls.m1345b("commandeBay " + this.bd);
            ls.m1345b("commandDefine " + this.be);
            ls.m1345b("commandSpell " + this.bf);
            ls.m1345b("commandDirectory " + this.bg);
            ls.m1345b("commandSubDirectory " + this.bh);
            ls.m1345b("commandShow " + this.bi);
            ls.m1345b("commandAlarm " + this.bj);
            ls.m1345b("commandCalendar " + this.bk);
            ls.m1345b("commandNavigate " + this.bl);
            ls.m1345b("commandLocateCar " + this.bm);
            ls.m1345b("commandPlayMusic " + this.bn);
            ls.m1345b("commandKnowledge " + this.bo);
            ls.m1345b("commandToast " + this.bp);
            ls.m1345b("commandDropbox " + this.bq);
            ls.m1345b("commandCalculate " + this.br);
            ls.m1345b("commandNote " + this.bs);
            ls.m1345b("commandVoiceNote " + this.bt);
            ls.m1345b("commandFuckOff " + this.ad);
            ls.m1345b("commandFilm " + this.bu);
            ls.m1345b("commandEdit " + this.bw);
            ls.m1345b("commandVisual " + this.bx);
            ls.m1345b("commandLinkApp " + this.by);
            ls.m1345b("commandParkedCar " + this.bA);
            ls.m1345b("commandHeadsetR " + this.bC);
            ls.m1345b("commandHeadsetC " + this.bB);
            ls.m1345b("commandHelp " + this.bD);
            ls.m1345b("commandPardon " + this.bE);
            ls.m1345b("userCommandFound " + this.bG);
            ls.m1345b("commandStreamMusic " + this.bH);
            ls.m1345b("commandUserVolume " + this.bI);
            ls.m1345b("commandReadSMS " + this.bN);
            ls.m1345b("commandFloatCommands " + this.bO);
            ls.m1345b("commandRedial " + this.bP);
            ls.m1345b("commandRemember " + this.bQ);
            ls.m1345b("commandFindCar " + this.bR);
            ls.m1345b("commandAppSearch " + this.bS);
            ls.m1345b("commandSubmitJoke " + this.bT);
            ls.m1345b("commandPlaylist " + this.bV);
            ls.m1345b("commandReleaseResources " + this.bW);
            ls.m1345b("commandNavigateContact " + this.bX);
            ls.m1345b("commandFourSquare " + this.bY);
            ls.m1345b("commandCallBack " + this.bZ);
            ls.m1345b("blueTOG " + this.ca);
            ls.m1345b("blueON " + this.cb);
            ls.m1345b("blueOFF " + this.cc);
            ls.m1345b("blueMULTI " + this.cd);
            ls.m1345b("wifiTOG " + this.ce);
            ls.m1345b("wifiON " + this.cf);
            ls.m1345b("wifiOFF " + this.cg);
            ls.m1345b("wifiMULTI " + this.ch);
            ls.m1345b("dataTOG " + this.ci);
            ls.m1345b("dataON " + this.cj);
            ls.m1345b("dataOFF " + this.ck);
            ls.m1345b("airTOG " + this.cp);
            ls.m1345b("airON " + this.cm);
            ls.m1345b("airOFF " + this.cn);
            ls.m1345b("airMULTI " + this.co);
            ls.m1345b("dataSettings " + this.cq);
            ls.m1345b("wifiSettings " + this.cr);
            ls.m1345b("datSettings " + this.cs);
            ls.m1345b("bluetoothSettings " + this.ct);
            ls.m1345b("ttsSettings " + this.cu);
            ls.m1345b("voiceSearchSettings " + this.cv);
            ls.m1345b("apnSettings " + this.cy);
            ls.m1345b("applicationSettings " + this.cx);
            ls.m1345b("checkApp " + this.df);
            ls.m1345b("deviceSettings " + this.cz);
            ls.m1345b("accessibilitySettings " + this.cw);
            ls.m1345b("displaySettings " + this.cB);
            ls.m1345b("inputSettings " + this.cC);
            ls.m1345b("storageSettings " + this.cD);
            ls.m1345b("localeSettings " + this.cE);
            ls.m1345b("settingsSettings " + this.cF);
            ls.m1345b("memoryCardSettings " + this.cG);
            ls.m1345b("networkOperatorSettings " + this.cH);
            ls.m1345b("nfcSettings " + this.cI);
            ls.m1345b("privacySettings " + this.cJ);
            ls.m1345b("quickLaunchSettings " + this.cK);
            ls.m1345b("soundSettings " + this.cL);
            ls.m1345b("syncSettings " + this.cM);
            ls.m1345b("dictionarySettings " + this.cN);
            ls.m1345b("searchSettings " + this.cO);
            ls.m1345b("locationSettings " + this.cA);
            ls.m1345b("rootReboot " + this.cP);
            ls.m1345b("rootRecovery " + this.cQ);
            ls.m1345b("rootBootloader " + this.cR);
            ls.m1345b("rootHot " + this.cS);
            ls.m1345b("rootGovernor " + this.cT);
            ls.m1345b("german " + this.cV);
            ls.m1345b("french " + this.cW);
            ls.m1345b("italian " + this.cX);
            ls.m1345b("polish " + this.cY);
            ls.m1345b("spanish " + this.cZ);
            ls.m1345b("romanian " + this.da);
            ls.m1345b("editScreenshot " + this.dc);
            ls.m1345b("editImage " + this.db);
            ls.m1345b("zipScreenshot " + this.de);
            ls.m1345b("zipImage " + this.dd);
            ls.m1345b("nameEMID " + this.dq);
            ls.m1345b("nameEM " + this.dr);
            ls.m1345b("batRequest " + this.du);
            ls.m1345b("shakeSetting " + this.dv);
            ls.m1345b("waveSetting " + this.dw);
            ls.m1345b("obsen " + this.dx);
            ls.m1345b("toSay " + this.dF);
            ls.m1345b("startRecog " + f1354b);
            ls.m1345b("myNavigate " + this.dA);
            ls.m1345b("myFilm " + this.dB);
            ls.m1345b("myEbay " + this.dC);
            ls.m1345b("commandInt " + this.dG);
        }
        if (this.ae) {
            if (hc.f1269b) {
                ls.m1344a("commandEasterEgg: " + this.ae);
            }
            jy.m1258j(this.f1380a);
        } else {
            if (this.ab || this.aB || this.aj) {
                if (hc.f1269b) {
                    ls.m1344a("multipleCommand: " + this.ab);
                    ls.m1344a("commandCancel: " + this.aB);
                    ls.m1344a("commandNone: " + this.aj);
                }
                if (this.aB) {
                    if (hc.f1269b) {
                        ls.m1346c("commandCancel: " + this.aB);
                    }
                    this.dF = "Okay.";
                } else if (this.ab) {
                    this.dF = "Multiple commands were detected.";
                    this.dH = 1;
                } else if (this.aj) {
                    if (hc.f1269b) {
                        ls.m1344a("commandNone: " + this.aj);
                    }
                    this.dF = "No recognisable command was detected.";
                    this.dH = 1;
                }
            } else if (this.aW) {
                if (hc.f1269b) {
                    ls.m1346c("commandGoTo: " + this.aW);
                }
            } else if (this.by) {
                if (hc.f1269b) {
                    ls.m1346c("commandLinkApp: " + this.by);
                }
                jy.m1254h(this.f1380a);
                this.dF = "You'll need to perform any initial authorisation manually.";
            } else if (this.bA) {
                if (hc.f1269b) {
                    ls.m1346c("commandParkedCar: " + this.bA);
                }
            } else if (this.bZ) {
                if (hc.f1269b) {
                    ls.m1346c("commandCallBack: " + this.bZ);
                }
            } else if (this.bY) {
                if (hc.f1269b) {
                    ls.m1346c("commandFourSquare: " + this.bY);
                }
            } else if (this.bX) {
                if (hc.f1269b) {
                    ls.m1346c("commandNavigateContact: " + this.bX);
                }
            } else if (this.bT) {
                if (hc.f1269b) {
                    ls.m1346c("commandSubmitJoke: " + this.bT);
                }
            } else if (this.bU) {
                if (hc.f1269b) {
                    ls.m1346c("commandCallNumber: " + this.bU);
                }
                this.dE = this.dE.replaceAll("\\bcall\\b\\s*", "").trim();
                this.dE = this.dE.replaceAll("\\s", "");
                if (!jy.m1272w(this.f1380a, "tel:" + this.dE)) {
                    this.dF = "Sorry, something went wrong calling that number";
                    this.dH = 1;
                }
            } else if (this.bV) {
                if (hc.f1269b) {
                    ls.m1346c("commandPlaylist: " + this.bV);
                }
            } else if (this.bR) {
                if (hc.f1269b) {
                    ls.m1346c("commandFindCar: " + this.bR);
                }
                if (lx.m1447p(this.f1380a)) {
                    jy.m1225a(this.f1380a, lx.m1444o(this.f1380a), lx.m1442n(this.f1380a));
                    this.dF = "Let's go";
                } else {
                    this.dF = "I don't have a stored location for your car.";
                    this.dH = 1;
                }
            } else if (this.bS) {
                if (hc.f1269b) {
                    ls.m1346c("commandAppSearch: " + this.bS);
                }
                if (this.dE.matches("null")) {
                    this.dF = "Sorry, something went wrong performing that application search.";
                    this.dH = 1;
                } else if (jy.m1229a(this.f1380a, this.dE)) {
                    this.dF = "There you go";
                } else {
                    this.dF = "Please install the Play Store application to use this feature.";
                }
            } else if (this.bQ) {
                if (hc.f1269b) {
                    ls.m1346c("commandRemember: " + this.bQ);
                }
                ((ClipboardManager) this.f1380a.getSystemService("clipboard")).setText(this.dE);
                this.dF = "I've remembered that. It's copied to the clipboard for you.";
            } else if (this.bP) {
                if (hc.f1269b) {
                    ls.m1346c("commandRedial: " + this.bP);
                }
                jy.m1236b(this.f1380a);
            } else if (this.bN) {
                if (hc.f1269b) {
                    ls.m1346c("commandReadSMS: " + this.bN);
                }
                this.dF = lw.m1360a(this.f1380a);
            } else if (this.bW) {
                if (hc.f1269b) {
                    ls.m1346c("commandReleaseResources: " + this.bW);
                }
                lp.m1341a(this.f1380a);
            } else if (this.bH) {
                if (hc.f1269b) {
                    ls.m1346c("commandStreamMusic: " + this.bH);
                }
            } else if (this.bO) {
                if (hc.f1269b) {
                    ls.m1346c("commandFloatCommands: " + this.bO);
                }
                ly.m1460a(this.f1380a, 13000, true);
                StandOutWindow.m741a(this.f1380a, VoiceResultsWindow.class, 2);
                this.dF = "There you go.";
            } else if (this.bI) {
                if (hc.f1269b) {
                    ls.m1346c("commandUserVolume: " + this.bI);
                }
            } else if (this.bG) {
                if (hc.f1269b) {
                    ls.m1346c("userCommandFound: " + this.bG);
                }
            } else if (this.bE) {
                if (hc.f1269b) {
                    ls.m1346c("commandPardon: " + this.bE);
                }
            } else if (this.ad) {
                if (hc.f1269b) {
                    ls.m1346c("commandFuckOff: " + this.ad);
                }
                jy.m1243c(this.f1380a, "com.brandall.nutter");
                this.dF = "If you insist";
            } else if (this.aT) {
                if (hc.f1269b) {
                    ls.m1346c("commandEmail: " + this.aT);
                }
            } else if (this.aU) {
                if (hc.f1269b) {
                    ls.m1346c("commandSMS: " + this.aU);
                }
            } else if (this.bD) {
                if (hc.f1269b) {
                    ls.m1346c("commandHelp: " + this.bD);
                }
                r0 = new Intent(this.f1380a, ActivityCommand.class);
                r0.addFlags(268435456);
                try {
                    this.f1380a.startActivity(r0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.dF = "Please see the structured command list to understand what I can do, and how you can get me to do it. If you have a problem, please see the troubleshooting and bugs tab in the main application. If you're still stuck, do feel free to email the developer.";
                GlobalV.m899w(true);
            } else if (this.bo) {
                if (hc.f1269b) {
                    ls.m1346c("commandKnowledge: " + this.bo);
                }
            } else if (this.bB) {
                if (hc.f1269b) {
                    ls.m1346c("commandHeadsetC: " + this.bB);
                }
            } else if (this.bC) {
                if (hc.f1269b) {
                    ls.m1346c("commandHeadsetR: " + this.bC);
                }
            } else if (this.bF) {
                if (hc.f1269b) {
                    ls.m1346c("commandDate: " + this.bF);
                }
            } else if (this.bx) {
                if (hc.f1269b) {
                    ls.m1346c("commandVisual: " + this.bx);
                }
                if (lx.aa(this.f1380a)) {
                    if (hc.f1269b) {
                        ls.m1346c("visualSet was: true");
                    }
                    lx.m1432i(this.f1380a, false);
                    this.dF = "Visual results disabled";
                    ly.m1460a(this.f1380a, 13000, false);
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("visualSet was: false");
                    }
                    lx.m1432i(this.f1380a, true);
                    this.dF = "Visual results enabled";
                    ly.m1460a(this.f1380a, 13000, true);
                }
            } else if (this.bw) {
                if (hc.f1269b) {
                    ls.m1346c("commandEdit: " + this.bw);
                }
                if (this.dD == null || this.dD.matches("")) {
                    this.dH = 1;
                    if (this.dc) {
                        this.dF = "Sorry, but I don't have record of a screenshot to edit.";
                    } else if (this.db) {
                        this.dF = "Sorry, but I don't have record of an image to edit.";
                    }
                } else {
                    if (hc.f1269b) {
                        ls.m1344a("modResult: " + this.dD);
                    }
                    if (this.dc) {
                        GlobalV.ar();
                        GlobalV.m900x(this.dD);
                    }
                    if (jy.m1259j(this.f1380a, GlobalV.at())) {
                        this.dF = "Editing";
                    } else {
                        this.dH = 1;
                        if (this.dc) {
                            this.dF = "Sorry, but I couldn't find an application to edit the screenshot. I suggest installing Instagram";
                        } else if (this.db) {
                            this.dF = "Sorry, but I couldn't find an application to edit the image. I suggest installing Instagram";
                        }
                    }
                }
            } else if (this.bu) {
                if (hc.f1269b) {
                    ls.m1346c("commandFilm: " + this.bu);
                }
                if (jy.m1260k(this.f1380a, this.dB)) {
                    this.dF = "Searching for the film, " + this.dB.replaceAll("\\%20", " ");
                } else {
                    this.dF = "I suggest installing the I M D B application to display your movie search results.";
                }
            } else if (this.bt) {
                if (hc.f1269b) {
                    ls.m1346c("commandVoiceNote: " + this.bt);
                }
                r0 = hz.m1159a(this.f1380a, "notes");
                if (r0.f1426c) {
                    this.dF = "You do not have a notes application installed that supports this feature. Please see the Linked Applications Tab in the main application, for a suggested download.";
                    this.dH = 1;
                } else {
                    this.dF = "Fire away";
                    switch (r0.f1428e) {
                        case 1:
                            jy.m1271v(this.f1380a, new Date().toString());
                            break;
                        case 2:
                            jy.m1256i(this.f1380a);
                            break;
                        default:
                            this.dF = "Sorry, something went wrong with the note creation";
                            break;
                    }
                    if (r0.f1424a && !r0.f1425b) {
                        this.dF = "Your default notes application is no longer installed.";
                    } else if (!r0.f1424a) {
                        this.dF = "Please take a moment to select your default notes application, from the Settings Tab.";
                    }
                }
            } else if (this.bs) {
                if (hc.f1269b) {
                    ls.m1346c("commandNote: " + this.bs);
                }
                if (jy.m1262m(this.f1380a, "com.evernote") || jy.m1262m(this.f1380a, "com.threebanana.notes")) {
                    GlobalV.m893u(true);
                    GlobalV.m880q(true);
                    GlobalV.m854j(1);
                    f1354b = true;
                    this.dF = "Please say the content of the note.";
                    GlobalV.m860k(true);
                } else {
                    this.dF = "You do not have a notes application installed that supports this feature. Please see the Linked Applications Tab in the main application, for a suggested download.";
                    this.dH = 1;
                }
            } else if (this.br) {
                if (hc.f1269b) {
                    ls.m1346c("commandCalculate: " + this.br);
                }
                if (!this.dz.matches("")) {
                    Toast.makeText(this.f1380a, this.dz, 1).show();
                }
            } else if (this.bq) {
                if (hc.f1269b) {
                    ls.m1346c("commandDropbox: " + this.bq);
                }
                if (!jy.m1262m(this.f1380a, "com.dropbox.android")) {
                    this.dF = "Please install the Dropbox application to use this feature.";
                    this.dH = 1;
                } else if (this.f1379Z) {
                    r0 = new File(jr.m1214a());
                    if (VERSION.SDK_INT >= 11) {
                        new js(this.f1380a, r0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    } else {
                        new js(this.f1380a, r0).execute(new Void[0]);
                    }
                    this.dF = "Uploading the zip to drop box.";
                } else {
                    this.dF = "Sorry, this feature won't be available until the next release.";
                    this.dH = 1;
                }
            } else if (this.bp) {
                if (hc.f1269b) {
                    ls.m1346c("commandToast: " + this.bp);
                }
                r0 = (ClipboardManager) this.f1380a.getSystemService("clipboard");
                if (r0.hasText()) {
                    Toast.makeText(this.f1380a, r0.getText(), 1).show();
                } else {
                    this.dF = "The clipboard has no data.";
                }
            } else if (this.be) {
                if (hc.f1269b) {
                    ls.m1346c("commandDefine: " + this.be);
                }
            } else if (this.bf) {
                if (hc.f1269b) {
                    ls.m1346c("commandSpell: " + this.bf);
                }
                if (this.f1388i.size() > 1) {
                    ((ClipboardManager) this.f1380a.getSystemService("clipboard")).setText((CharSequence) this.f1388i.get(0));
                    this.dF = new StringBuilder(String.valueOf((String) this.f1388i.get(1))).append(". I've copied it to the clipboard.").toString();
                    Toast.makeText(this.f1380a, new StringBuilder(String.valueOf((String) this.f1388i.get(1))).append(".").toString(), 1).show();
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("toSpell is empty");
                    }
                    this.dF = "Sorry, I didn't detect a word to spell for you";
                    this.dH = 1;
                }
            } else if (this.bg || this.bh) {
                if (hc.f1269b) {
                    ls.m1346c("commandDirectory: " + this.bg);
                }
                if (this.f1373S.isEmpty()) {
                    if (hc.f1269b) {
                        ls.m1347d("getDir.isEmpty");
                    }
                    this.dF = "Sorry, but I got an error when searching through your directories.";
                    this.dH = 1;
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("In getDir: " + this.f1373S.size() + " : " + this.f1373S.toString());
                    }
                    r1 = null;
                    if (((String) this.f1373S.get(0)).matches("ALGORITHM")) {
                        r0 = (String) this.f1373S.get(2);
                        this.dF = "Browsing the closest match.";
                        r1 = r0;
                        r0 = true;
                    } else if (((String) this.f1373S.get(0)).matches("NOTFOUND")) {
                        this.dF = "Sorry, but I couldn't find that directory.";
                        this.dH = 1;
                        r0 = false;
                    } else if (((String) this.f1373S.get(0)).matches("NOTMOUNTED")) {
                        this.dF = "Sorry, but your external storage does not appear to be mounted correctly.";
                        this.dH = 1;
                        r0 = false;
                    } else if (this.f1373S.size() == 2) {
                        r0 = (String) this.f1373S.get(1);
                        this.dF = "browsing";
                        r1 = r0;
                        r0 = true;
                    } else {
                        if (hc.f1269b) {
                            ls.m1347d("commandDirectory oPE - why am I here");
                        }
                        this.dF = "Sorry, but something went wrong in the directory search";
                        this.dH = 1;
                        r0 = false;
                    }
                    if (r0) {
                        r0 = hz.m1159a(this.f1380a, "explorer");
                        if (!r0.f1426c) {
                            if (r0.f1424a && !r0.f1425b) {
                                this.dF = "Your default explorer is no longer installed";
                            } else if (!r0.f1424a) {
                                this.dF = "Please take a moment to select your default explorer, from the Settings Tab";
                            }
                            switch (r0.f1428e) {
                                case 1:
                                    jy.m1270u(this.f1380a, r1);
                                    break;
                                case 2:
                                    jy.m1268s(this.f1380a, r1);
                                    break;
                                case 3:
                                    jy.m1266q(this.f1380a, r1);
                                    break;
                                case 4:
                                    jy.m1269t(this.f1380a, r1);
                                    break;
                                case 5:
                                    jy.m1267r(this.f1380a, r1);
                                    break;
                                case 6:
                                    jy.m1265p(this.f1380a, r1);
                                    break;
                                default:
                                    this.dF = "Sorry, something went wrong searching for that directory";
                                    this.dH = 1;
                                    break;
                            }
                        }
                        this.dF = "You do not have a file explorer that supports this feature. Please see the Linked Applications Tab in the main application, for a suggested download.";
                        this.dH = 1;
                    }
                }
            } else if (this.bi) {
                if (hc.f1269b) {
                    ls.m1346c("commandShow: " + this.bi);
                }
                if (this.bz) {
                    this.dF = "Wolfram Alpha integration is coming very soon.";
                } else {
                    this.dF = "Sorry, but I didn't detect an application that can display the results.";
                    this.dH = 1;
                }
            } else if (this.bj) {
                if (hc.f1269b) {
                    ls.m1346c("commandAlarm: " + this.bj);
                }
                if (hc.f1269b) {
                    ls.m1344a("getAlarm: " + this.f1375U.size() + " : " + this.f1375U.toString());
                }
                if (this.f1375U.isEmpty()) {
                    this.dF = "Sorry, but I couldn't resolve that alarm structure.";
                    this.dH = 1;
                } else if (((String) this.f1375U.get(0)).matches("ERROR")) {
                    this.dF = "Sorry, but I couldn't structure that alarm.";
                } else if (this.f1375U.size() > 2) {
                    if (jy.m1227a(this.f1380a, Integer.valueOf((String) this.f1375U.get(0)).intValue(), Integer.valueOf((String) this.f1375U.get(1)).intValue(), (String) this.f1375U.get(2))) {
                        this.dF = "That's done";
                    } else {
                        this.dF = "Sorry, something went wrong setting that alarm.";
                        this.dH = 1;
                    }
                } else if (this.f1375U.size() == 2) {
                    if (jy.m1227a(this.f1380a, Integer.valueOf((String) this.f1375U.get(0)).intValue(), Integer.valueOf((String) this.f1375U.get(1)).intValue(), "")) {
                        this.dF = "That's done";
                    } else {
                        this.dF = "Sorry, something went wrong setting that alarm.";
                        this.dH = 1;
                    }
                }
            } else if (this.bk) {
                if (hc.f1269b) {
                    ls.m1346c("commandCalendar: " + this.bk);
                }
                if (this.f1375U.isEmpty()) {
                    this.dF = "Sorry, but I couldn't structure that event";
                    this.dH = 1;
                } else if (((String) this.f1375U.get(0)).matches("error")) {
                    this.dF = (String) this.f1375U.get(1);
                } else if (((String) this.f1375U.get(0)).matches("alarm")) {
                    this.dF = (String) this.f1375U.get(1);
                } else {
                    this.dF = (String) this.f1375U.get(0);
                }
            } else if (this.bl) {
                if (hc.f1269b) {
                    ls.m1346c("commandNavigate: " + this.bl);
                }
                if (hc.f1269b) {
                    ls.m1346c("myNavigate: " + this.dA);
                }
                jy.m1261l(this.f1380a, this.dA);
                this.dF = "Let's go";
            } else if (this.bm) {
                if (hc.f1269b) {
                    ls.m1346c("commandLocateCar: " + this.bm);
                }
                if (!jy.m1262m(this.f1380a, "com.google.android.street")) {
                    this.dF = "Please install Google Street View to use this feature.";
                    this.dH = 1;
                } else if (lx.m1447p(this.f1380a)) {
                    jy.m1237b(this.f1380a, lx.m1444o(this.f1380a), lx.m1442n(this.f1380a));
                    this.dF = "Here is its last known whereabouts";
                } else {
                    this.dF = "I don't have a stored location for your car.";
                    this.dH = 1;
                }
            } else if (this.bn) {
                if (hc.f1269b) {
                    ls.m1346c("commandPlayMusic: " + this.bn);
                }
                if (this.f1372R.isEmpty()) {
                    if (hc.f1269b) {
                        ls.m1347d("getTrack isEmpty");
                    }
                    this.dF = "Sorry, something went wrong searching for that track";
                    this.dH = 1;
                } else if (((String) this.f1372R.get(0)).contains("ERROR") || ((String) this.f1372R.get(0)).contains("ALGORITHM")) {
                    if (((String) this.f1372R.get(0)).contains("ALGORITHM")) {
                        if (hc.f1269b) {
                            ls.m1346c("getTrack ALGORITHM");
                        }
                        if (jy.m1233a(this.f1380a, (String) this.f1372R.get(2), false)) {
                            Toast.makeText(this.f1380a, "Closest match...", 0).show();
                            this.dF = "";
                        } else {
                            this.dF = "Sorry, but I couldn't find a suitable application to play that track.";
                            this.dH = 1;
                        }
                    } else if (((String) this.f1372R.get(0)).contains("ERROR")) {
                        if (hc.f1269b) {
                            ls.m1347d("getTrack ERROR");
                        }
                        this.dF = "Sorry, something went wrong searching for that track";
                        this.dH = 1;
                    }
                } else if (jy.m1233a(this.f1380a, (String) this.f1372R.get(1), false)) {
                    this.dF = "";
                } else {
                    this.dF = "Sorry, but I couldn't find a suitable application to play that track.";
                    this.dH = 1;
                }
            } else if (this.bd) {
                if (hc.f1269b) {
                    ls.m1346c("commandeBay: " + this.bd);
                }
                jy.m1257i(this.f1380a, this.dC);
                this.dF = "Searching eBay for " + this.dC.replaceAll("\\%20", " ");
            } else if (this.bc) {
                if (hc.f1269b) {
                    ls.m1346c("commandTranslate: " + this.bc);
                }
                if (!this.dF.contains("there was a translation error")) {
                    ((ClipboardManager) this.f1380a.getSystemService("clipboard")).setText(this.dF);
                }
            } else if (this.bb) {
                if (hc.f1269b) {
                    ls.m1346c("commandCreate: " + this.bb);
                }
                GlobalV.m886s(true);
                GlobalV.m858k(1);
                f1354b = true;
                this.dF = "What do you want the command to do?";
            } else if (this.ba) {
                if (hc.f1269b) {
                    ls.m1346c("commandJoke: " + this.ba);
                }
            } else if (this.aZ) {
                if (hc.f1269b) {
                    ls.m1346c("commandMD5: " + this.aZ);
                }
                if (this.dD == null || this.dD.matches("")) {
                    this.dF = "Sorry, but I don't have record of a zip file.";
                    this.dH = 1;
                } else {
                    if (hc.f1269b) {
                        ls.m1344a("modResult: " + this.dD);
                    }
                    this.dF = "I'm on it";
                    GlobalV.au();
                    GlobalV.m903y(this.dD);
                    GlobalV.m786B("md5Sum");
                    if (VERSION.SDK_INT >= 11) {
                        new kf(this.f1380a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    } else {
                        new kf(this.f1380a).execute(new String[0]);
                    }
                }
            } else if (this.aY) {
                if (hc.f1269b) {
                    ls.m1346c("commandZip: " + this.aY);
                }
                if (this.dD == null || this.dD.matches("")) {
                    this.dH = 1;
                    if (this.de) {
                        this.dF = "Sorry, but I don't have record of a screenshot to zip.";
                    } else if (this.dd) {
                        this.dF = "Sorry, but I don't have record of an image to zip.";
                    }
                } else {
                    if (hc.f1269b) {
                        ls.m1344a("modResult: " + this.dD);
                    }
                    r0 = new File(Environment.getExternalStorageDirectory() + "/utter/Zip_Files");
                    if (!r0.exists() || !r0.isDirectory()) {
                        if (hc.f1269b) {
                            ls.m1346c("Zip_Files dir doesnt exist. Creating");
                        }
                        r0.mkdirs();
                    } else if (hc.f1269b) {
                        ls.m1346c("Zip_Files dir exists");
                    }
                    if (this.de) {
                        String[] strArr = new String[]{this.dD};
                        r0 = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString())).append("/utter/Zip_Files/").append(new File(this.dD).getName()).append(".zip").toString();
                        try {
                            km.m1305a(strArr, r0);
                            GlobalV.au();
                            GlobalV.m903y(r0);
                            this.dF = "I've zipped the screenshot";
                            Toast.makeText(this.f1380a, "Saved to " + GlobalV.aw(), 0).show();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            this.dF = "Sorry, something went wrong trying to zip the screenshot";
                            this.dH = 1;
                        }
                    } else if (this.dd) {
                        this.dF = "Sorry, but I don't have record of an image to zip.";
                        this.dH = 1;
                    }
                }
            } else if (this.aX) {
                if (hc.f1269b) {
                    ls.m1346c("commandScreenShot: " + this.aX);
                }
                if (!this.f1380a.getSharedPreferences("utterPref", 0).getBoolean("device_rooted", false)) {
                    this.dF = "Your device needs root access to use this feature.";
                    this.dH = 1;
                } else if (jy.m1262m(this.f1380a, "com.ms.screencast")) {
                    jy.m1248e(this.f1380a);
                    new lr(Environment.getExternalStorageDirectory() + "/Screencast").startWatching();
                    this.dF = "Cheese";
                } else if (jy.m1262m(this.f1380a, "com.ms.screencastfree")) {
                    jy.m1250f(this.f1380a);
                    new lr(Environment.getExternalStorageDirectory() + "/Screencast").startWatching();
                    this.dF = "Cheese";
                } else {
                    GlobalV.m786B("screenShot");
                    if (VERSION.SDK_INT >= 11) {
                        new kf(this.f1380a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    } else {
                        new kf(this.f1380a).execute(new String[0]);
                    }
                }
            } else if (this.aV) {
                if (hc.f1269b) {
                    ls.m1346c("commandWhere: " + this.aV);
                }
                this.dF = "Location based profiling will be enabled very soon.";
            } else if (this.aS) {
                if (hc.f1269b) {
                    ls.m1346c("commandSkype: " + this.aS);
                }
                if (this.cU && !jy.m1221A(this.f1380a, this.dy)) {
                    this.dF = "You need to have Skype installed to use this function";
                    this.dH = 1;
                }
            } else if (this.aQ) {
                if (hc.f1269b) {
                    ls.m1346c("commandKill: " + this.aQ);
                }
            } else if (this.aP) {
                if (hc.f1269b) {
                    ls.m1346c("commandForeground: " + this.aP);
                }
            } else if (this.aO) {
                if (hc.f1269b) {
                    ls.m1346c("commandClipboard: " + this.aO);
                }
                r0 = (ClipboardManager) this.f1380a.getSystemService("clipboard");
                if (r0.hasText()) {
                    if (hc.f1269b) {
                        ls.m1346c("ClipContent: " + r0.hasText());
                    }
                    r0 = String.valueOf(r0.getText());
                    GlobalV.m899w(true);
                    this.dF = r0;
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("ClipContent: " + r0.hasText());
                    }
                    this.dF = "The clipboard does not appear to contain any data";
                }
            } else if (this.aK) {
                if (hc.f1269b) {
                    ls.m1346c("commandDeveloperPassword: " + this.aK);
                }
                if (this.aL) {
                    GlobalV.m901x(true);
                    this.dF = "Password accepted. Thank you.";
                } else {
                    this.dF = "Sorry, that is not the correct password.";
                    GlobalV.m901x(false);
                }
            } else if (this.aM) {
                if (hc.f1269b) {
                    ls.m1346c("commandUserPassword: " + this.aM);
                }
                if (this.f1380a.getSharedPreferences("utterPref", 0).getBoolean("user_password", false)) {
                    GlobalV.m868m(true);
                    GlobalV.m842g(1);
                    GlobalV.m893u(true);
                    f1354b = true;
                    this.dF = "You already have a password set. If you'd like to change it, please say your current password now. Or say cancel.";
                } else {
                    this.dF = "It may be easier to configure your password manually in the Customisation Tab of the main application. Say cancel, if you'd prefer to do this. Otherwise, please say your password clearly now. You will be asked to confirm it.";
                    GlobalV.m868m(true);
                    GlobalV.m842g(2);
                    GlobalV.m893u(true);
                    f1354b = true;
                }
            } else if (this.aH) {
                if (hc.f1269b) {
                    ls.m1346c("commandShakeSetting: " + this.aH);
                }
                if (this.dv.matches("on")) {
                    lx.m1441m(this.f1380a, true);
                    if (ly.m1467d(this.f1380a)) {
                        if (hc.f1269b) {
                            ls.m1346c("shake service running");
                        }
                        this.dF = "Shake to wake is already on.";
                    } else {
                        if (hc.f1269b) {
                            ls.m1346c("shake service not running");
                        }
                        this.dF = "I've turned shake to wake on.";
                        jy.m1241b(this.f1380a, true);
                    }
                } else if (this.dv.matches("off")) {
                    lx.m1441m(this.f1380a, false);
                    if (ly.m1467d(this.f1380a)) {
                        if (hc.f1269b) {
                            ls.m1346c("shake service running");
                        }
                        this.dF = "I've turned shake to wake off.";
                        jy.m1241b(this.f1380a, false);
                    } else {
                        if (hc.f1269b) {
                            ls.m1346c("shake service not running");
                        }
                        this.dF = "Shake to wake is already off.";
                    }
                } else if (this.dv.matches("low")) {
                    lx.m1399b(this.f1380a, 14);
                    this.dF = "Shake sensitivity has been set to low.";
                } else if (this.dv.matches("vlow")) {
                    lx.m1399b(this.f1380a, 16);
                    this.dF = "Shake sensitivity has been set to very low.";
                } else if (this.dv.matches("medium")) {
                    lx.m1399b(this.f1380a, 11);
                    this.dF = "Shake sensitivity has been set to medium.";
                } else if (this.dv.matches("high")) {
                    lx.m1399b(this.f1380a, 8);
                    this.dF = "Shake sensitivity has been set to high.";
                } else if (this.dv.matches("vhigh")) {
                    lx.m1399b(this.f1380a, 6);
                    this.dF = "Shake sensitivity has been set to very high.";
                } else {
                    this.dF = "I couldn't quite make out the shake setting you requested.";
                    this.dH = 1;
                }
            } else if (this.aI) {
                if (hc.f1269b) {
                    ls.m1346c("commandWaveSetting: " + this.aI);
                }
                if (this.dw.matches("on")) {
                    lx.m1443n(this.f1380a, true);
                    if (ly.m1466c(this.f1380a)) {
                        if (hc.f1269b) {
                            ls.m1346c("wave service running");
                        }
                        this.dF = "Wave to wake is already on.";
                    } else {
                        if (hc.f1269b) {
                            ls.m1346c("wave service not running");
                        }
                        this.dF = "I've turned wave to wake on.";
                        jy.m1245c(this.f1380a, true);
                    }
                } else if (this.dw.matches("off")) {
                    lx.m1443n(this.f1380a, false);
                    if (ly.m1466c(this.f1380a)) {
                        if (hc.f1269b) {
                            ls.m1346c("wave service running");
                        }
                        this.dF = "I've turned wave to wake off.";
                        jy.m1245c(this.f1380a, false);
                    } else {
                        if (hc.f1269b) {
                            ls.m1346c("wave service not running");
                        }
                        this.dF = "Wave to wake is already off.";
                    }
                } else {
                    this.dF = "I couldn't quite make out the wave setting you requested.";
                    this.dH = 1;
                }
            } else if (this.aG) {
                if (hc.f1269b) {
                    ls.m1346c("commandUserName: " + this.aG);
                }
                if (hc.f1270c) {
                    kz.f1638g = true;
                    if (VERSION.SDK_INT >= 11) {
                        new kz(this.f1380a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    } else {
                        new kz(this.f1380a).execute(new Void[0]);
                    }
                }
            } else if (this.aC) {
                if (hc.f1269b) {
                    ls.m1346c("commandRinger: " + this.aC);
                }
                if (this.aE) {
                    if (hc.f1269b) {
                        ls.m1346c("commandSilent: " + this.aE);
                    }
                    r0 = ke.m1285b(this.f1380a);
                    if (r0) {
                        if (hc.f1269b) {
                            ls.m1346c("checkIfSilent: " + r0);
                        }
                        Toast.makeText(this.f1380a, "The sound profile is already set to silent", 0).show();
                    } else {
                        r0 = ke.m1288e(this.f1380a);
                        if (r0) {
                            if (hc.f1269b) {
                                ls.m1346c("setToSilent: " + r0);
                            }
                            Toast.makeText(this.f1380a, "The sound profile has been set to silent", 0).show();
                        } else {
                            this.dF = "Something went wrong setting to silent mode.";
                            this.dH = 1;
                        }
                    }
                } else if (this.aD) {
                    if (hc.f1269b) {
                        ls.m1346c("commandRing: " + this.aD);
                    }
                    r0 = ke.m1287d(this.f1380a);
                    if (r0) {
                        if (hc.f1269b) {
                            ls.m1346c("checkIfRing: " + r0);
                        }
                        this.dF = "The sound profile is already set to normal.";
                    } else {
                        r0 = ke.m1290g(this.f1380a);
                        if (r0) {
                            if (hc.f1269b) {
                                ls.m1346c("setToRing: " + r0);
                            }
                            this.dF = "Your sound profile has been set to normal.";
                        } else {
                            this.dF = "Something went wrong setting the normal sound profile.";
                            Toast.makeText(this.f1380a, "Something went wrong setting the normal sound profile.", 0).show();
                            this.dH = 1;
                        }
                    }
                } else if (this.aF) {
                    if (hc.f1269b) {
                        ls.m1346c("commandVibrate: " + this.aF);
                    }
                    r0 = ke.m1286c(this.f1380a);
                    if (r0) {
                        if (hc.f1269b) {
                            ls.m1346c("checkIfVibrate: " + r0);
                        }
                        Toast.makeText(this.f1380a, "The sound profile is already set to vibrate", 0).show();
                    } else {
                        r0 = ke.m1289f(this.f1380a);
                        if (r0) {
                            if (hc.f1269b) {
                                ls.m1346c("setToVibrate: " + r0);
                            }
                            Toast.makeText(this.f1380a, "The sound profile has been set to vibrate", 0).show();
                        } else {
                            this.dF = "Something went wrong setting the sound profile to vibrate.";
                            this.dH = 1;
                        }
                    }
                }
            } else if (this.aA) {
                if (hc.f1269b) {
                    ls.m1346c("commandBattery: " + this.aA);
                }
            } else if (this.az) {
                if (hc.f1269b) {
                    ls.m1344a("commandFly: " + this.az);
                }
                if (this.f1358D.isEmpty()) {
                    this.dF = "Sorry, but I couldn't detect a suitable location.";
                    this.dH = 1;
                } else if (jy.m1222B(this.f1380a, (String) this.f1358D.get(0))) {
                    this.dF = "Bon voyage";
                } else {
                    this.dF = "Please install Google Earth to use this feature.";
                    this.dH = 1;
                }
            } else if (this.at || this.au || this.av || this.aw || this.ax) {
                if (hc.f1269b) {
                    ls.m1346c("commandSearchGoogle: " + this.at);
                    ls.m1346c("commandSearchBing: " + this.au);
                    ls.m1346c("commandSearchYahoo: " + this.av);
                    ls.m1346c("commandImageSearch: " + this.aw);
                }
                if (this.f1356B.isEmpty()) {
                    this.dF = "Sorry, something went wrong with the search data";
                    this.dH = 1;
                } else if (this.aw) {
                    if (hc.f1269b) {
                        ls.m1344a("commandImageSearch: " + ((String) this.f1356B.get(0)));
                    }
                    this.dF = "Searching for images of " + ((String) this.f1356B.get(0));
                    jn.f1553a = true;
                    jy.m1274y(this.f1380a, "http://google." + jn.m1212a() + "/search?q=" + ((String) this.f1356B.get(0)) + "&tbm=isch");
                } else if (this.at) {
                    if (hc.f1269b) {
                        ls.m1344a("commandSearchGoogle: " + ((String) this.f1356B.get(0)));
                    }
                    this.dF = "Searching Google for " + ((String) this.f1356B.get(0));
                    jn.f1553a = true;
                    jy.m1274y(this.f1380a, "http://google." + jn.m1212a() + "/search?q=" + ((String) this.f1356B.get(0)));
                } else if (this.au) {
                    if (hc.f1269b) {
                        ls.m1344a("commandSearchBing: " + ((String) this.f1356B.get(0)));
                    }
                    this.dF = "Searching Bing for " + ((String) this.f1356B.get(0));
                    jn.f1555c = true;
                    jy.m1274y(this.f1380a, "http://bing.com/search?q=" + ((String) this.f1356B.get(0)) + jn.m1212a());
                } else if (this.av) {
                    if (hc.f1269b) {
                        ls.m1344a("commandSearchYahoo: " + ((String) this.f1356B.get(0)));
                    }
                    this.dF = "Searching Yahoo for " + ((String) this.f1356B.get(0));
                    jn.f1554b = true;
                    jy.m1274y(this.f1380a, "http://" + jn.m1212a() + "/search?q=" + ((String) this.f1356B.get(0)));
                } else if (this.ax) {
                    if (hc.f1269b) {
                        ls.m1344a("commandVideoSearch: " + ((String) this.f1356B.get(0)));
                    }
                    if (jy.m1275z(this.f1380a, (String) this.f1356B.get(0))) {
                        this.dF = "Searching YouTube for videos of " + ((String) this.f1356B.get(0));
                    } else {
                        this.dF = "Sorry, something went wrong searching for that video";
                        this.dH = 1;
                    }
                }
            } else if (this.as) {
                if (hc.f1269b) {
                    ls.m1344a("commandNone: " + this.aj);
                }
                if (this.cr) {
                    r0 = jy.m1223C(this.f1380a, "wifiSettings");
                } else if (this.cq) {
                    r0 = jy.m1223C(this.f1380a, "dataSettings");
                } else if (this.cs) {
                    r0 = jy.m1223C(this.f1380a, "datSettings");
                } else if (this.ct) {
                    r0 = jy.m1223C(this.f1380a, "bluetoothSettings");
                } else if (this.cv) {
                    r0 = jy.m1223C(this.f1380a, "voiceSearchSettings");
                } else if (this.cA) {
                    r0 = jy.m1223C(this.f1380a, "locationSettings");
                } else if (this.cu) {
                    r0 = jy.m1223C(this.f1380a, "ttsSettings");
                } else if (this.cw) {
                    r0 = jy.m1223C(this.f1380a, "accessibilitySettings");
                } else if (this.cy) {
                    r0 = jy.m1223C(this.f1380a, "apnSettings");
                } else if (this.cx) {
                    if (!this.df) {
                        r0 = jy.m1223C(this.f1380a, "applicationSettings");
                    } else if (this.f1370P.isEmpty()) {
                        this.df = false;
                        r0 = jy.m1223C(this.f1380a, "applicationSettings");
                    } else if (((String) this.f1370P.get(0)).matches("oom")) {
                        this.dF = "Sorry, but I couldn't generate the application list. The developer is working on a fix for this problem.";
                        this.dH = 1;
                        r0 = jy.m1223C(this.f1380a, "applicationSettings");
                    } else if (!jy.m1247d(this.f1380a, (String) this.f1370P.get(1))) {
                        this.dF = "Sorry, there was a problem opening the specific application settings.";
                        this.dH = 1;
                        r0 = jy.m1223C(this.f1380a, "applicationSettings");
                    } else if (this.f1370P.size() == 3) {
                        if (hc.f1269b) {
                            ls.m1346c("getApp used: " + ((String) this.f1370P.get(2)));
                        }
                        this.dF = "Opened " + ((String) this.f1370P.get(0)) + " application settings, as the closest match.";
                        r0 = false;
                    } else {
                        this.dF = "Opened " + ((String) this.f1370P.get(0)) + " application settings";
                        r0 = false;
                    }
                } else if (this.cz) {
                    r0 = jy.m1223C(this.f1380a, "deviceSettings");
                } else if (this.cB) {
                    r0 = jy.m1223C(this.f1380a, "displaySettings");
                } else if (this.cC) {
                    r0 = jy.m1223C(this.f1380a, "inputSettings");
                } else if (this.cD) {
                    r0 = jy.m1223C(this.f1380a, "storageSettings");
                } else if (this.cE) {
                    r0 = jy.m1223C(this.f1380a, "localeSettings");
                } else if (this.cF) {
                    r0 = jy.m1223C(this.f1380a, "settingsSettings");
                } else if (this.cG) {
                    r0 = jy.m1223C(this.f1380a, "memoryCardSettings");
                } else if (this.cH) {
                    r0 = jy.m1223C(this.f1380a, "networkOperatorSettings");
                } else if (this.cI) {
                    r0 = jy.m1223C(this.f1380a, "nfcSettings");
                } else if (this.cJ) {
                    r0 = jy.m1223C(this.f1380a, "privacySettings");
                } else if (this.cK) {
                    r0 = jy.m1223C(this.f1380a, "quickLaunchSettings");
                } else if (this.cO) {
                    r0 = jy.m1223C(this.f1380a, "searchSettings");
                } else if (this.cL) {
                    r0 = jy.m1223C(this.f1380a, "soundSettings");
                } else if (this.cM) {
                    r0 = jy.m1223C(this.f1380a, "syncSettings");
                } else if (this.cN) {
                    r0 = jy.m1223C(this.f1380a, "dictionarySettings");
                } else {
                    r0 = false;
                }
                if (r0) {
                    if (!this.df) {
                        this.dF = "Settings displayed.";
                    }
                } else if (!this.df) {
                    this.dF = "Settings error.";
                }
            } else if (this.ac) {
                if (hc.f1269b) {
                    ls.m1344a("commandSuperUser: " + this.ac);
                }
            } else if (this.aR) {
                if (hc.f1269b) {
                    ls.m1346c("commandConnection: " + this.aR);
                }
                if (this.cb || this.cc || this.ca || this.cd) {
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        if (this.cb || this.cc) {
                            if (this.cb) {
                                if (hc.f1269b) {
                                    ls.m1344a("blueON: " + this.cb);
                                }
                                if (defaultAdapter.isEnabled()) {
                                    this.dF = "It's already on.";
                                } else {
                                    defaultAdapter.enable();
                                    if (hc.f1269b) {
                                        ls.m1346c("Enabled Bluetooth");
                                    }
                                    this.dF = "I've turned Blue-Tooth on.";
                                }
                            }
                            if (this.cc) {
                                if (hc.f1269b) {
                                    ls.m1344a("blueOFF: " + this.cc);
                                }
                                if (defaultAdapter.isEnabled()) {
                                    defaultAdapter.disable();
                                    if (hc.f1269b) {
                                        ls.m1346c("Disabled Bluetooth");
                                    }
                                    this.dF = "I've switched Blue-Tooth off.";
                                } else {
                                    this.dF = "It's already off.";
                                }
                            }
                        } else if (this.ca || this.cd) {
                            if (hc.f1269b) {
                                ls.m1344a("blueTOG: " + this.ca);
                            }
                            if (this.ca) {
                                if (hc.f1269b) {
                                    ls.m1344a("blueTOG: " + this.ca);
                                }
                                if (defaultAdapter.isEnabled()) {
                                    defaultAdapter.disable();
                                    if (hc.f1269b) {
                                        ls.m1346c("Disabled Bluetooth");
                                    }
                                    this.dF = "I've toggled Blue-Tooth.";
                                } else {
                                    defaultAdapter.enable();
                                    if (hc.f1269b) {
                                        ls.m1346c("Enabled Bluetooth");
                                    }
                                    this.dF = "I've toggled Blue-Tooth.";
                                }
                            }
                            if (this.cd) {
                                if (hc.f1269b) {
                                    ls.m1344a("blueMULTI: " + this.cd);
                                }
                                if (defaultAdapter.isEnabled()) {
                                    defaultAdapter.disable();
                                    if (hc.f1269b) {
                                        ls.m1346c("Disabled Bluetooth");
                                    }
                                    this.dF = "I've toggled Blue-Tooth for you.";
                                } else {
                                    defaultAdapter.enable();
                                    if (hc.f1269b) {
                                        ls.m1346c("Enabled Bluetooth");
                                    }
                                    this.dF = "I've toggled Blue-Tooth.";
                                }
                            }
                        }
                    } else if (hc.f1269b) {
                        ls.m1348e("bluetooth adapter is null");
                    }
                } else if (this.cf || this.cg || this.ce || this.ch) {
                    WifiManager wifiManager = (WifiManager) this.f1380a.getSystemService("wifi");
                    if (this.cf || this.cg) {
                        if (this.cf) {
                            if (hc.f1269b) {
                                ls.m1344a("wifiON: " + this.cf);
                            }
                            if (wifiManager.isWifiEnabled()) {
                                this.dF = "It's already on.";
                            } else {
                                try {
                                    wifiManager.setWifiEnabled(true);
                                    this.dF = "I've turned WiFi on.";
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    this.dF = "Sorry, something went wrong attempting to change your WiFi state.";
                                    this.dH = 1;
                                }
                            }
                        }
                        if (this.cg) {
                            if (hc.f1269b) {
                                ls.m1344a("wifiOFF: " + this.cg);
                            }
                            if (wifiManager.isWifiEnabled()) {
                                try {
                                    wifiManager.setWifiEnabled(false);
                                    this.dF = "I've switched WiFi off.";
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    this.dF = "Sorry, something went wrong attempting to change your WiFi state.";
                                    this.dH = 1;
                                }
                            } else {
                                this.dF = "It's already off.";
                            }
                        }
                    } else if (this.ce || this.ch) {
                        if (this.ce) {
                            if (hc.f1269b) {
                                ls.m1344a("wifiTOG: " + this.ce);
                            }
                            if (wifiManager.isWifiEnabled()) {
                                try {
                                    wifiManager.setWifiEnabled(false);
                                    this.dF = "I've toggled WiFi.";
                                } catch (Exception e32) {
                                    e32.printStackTrace();
                                    this.dF = "Sorry, something went wrong attempting to change your WiFi state.";
                                    this.dH = 1;
                                }
                            } else {
                                try {
                                    wifiManager.setWifiEnabled(true);
                                    this.dF = "I've toggled WiFi.";
                                } catch (Exception e322) {
                                    e322.printStackTrace();
                                    this.dF = "Sorry, something went wrong attempting to change your WiFi state.";
                                    this.dH = 1;
                                }
                            }
                        }
                        if (this.ch) {
                            if (hc.f1269b) {
                                ls.m1344a("wifiMULTI: " + this.ch);
                            }
                            if (wifiManager.isWifiEnabled()) {
                                try {
                                    wifiManager.setWifiEnabled(false);
                                    this.dF = "I've toggled WiFi.";
                                } catch (Exception e42) {
                                    e42.printStackTrace();
                                    this.dF = "Sorry, something went wrong attempting to change your WiFi state.";
                                    this.dH = 1;
                                }
                            } else {
                                try {
                                    wifiManager.setWifiEnabled(true);
                                    this.dF = "I've toggled WiFi.";
                                } catch (Exception e422) {
                                    e422.printStackTrace();
                                    this.dF = "Sorry, something went wrong attempting to change your WiFi state.";
                                    this.dH = 1;
                                }
                            }
                        }
                    }
                } else if (this.cj || this.ck || this.ci || this.cl) {
                    if (this.cj || this.ck) {
                        if (this.cj) {
                            if (hc.f1269b) {
                                ls.m1344a("dataON: " + this.cj);
                            }
                            if (kb.m1280a(this.f1380a)) {
                                this.dF = "It's already on.";
                            } else {
                                kb.m1282c(this.f1380a);
                                this.dF = "I've turned data on.";
                            }
                        }
                        if (this.ck) {
                            if (hc.f1269b) {
                                ls.m1344a("dataOFF: " + this.ck);
                            }
                            if (kb.m1280a(this.f1380a)) {
                                kb.m1281b(this.f1380a);
                                this.dF = "I've switched data off.";
                            } else {
                                this.dF = "It's already off.";
                            }
                        }
                    } else if (this.ci || this.cl) {
                        if (this.ci) {
                            if (hc.f1269b) {
                                ls.m1344a("dataTOG: " + this.ci);
                            }
                            if (kb.m1280a(this.f1380a)) {
                                kb.m1281b(this.f1380a);
                                this.dF = "I've toggled mobile data.";
                            } else {
                                kb.m1282c(this.f1380a);
                                this.dF = "I've toggled mobile data.";
                            }
                        }
                        if (this.cl) {
                            if (hc.f1269b) {
                                ls.m1344a("dataMULTI: " + this.cl);
                            }
                            if (kb.m1280a(this.f1380a)) {
                                kb.m1281b(this.f1380a);
                                this.dF = "I've toggled mobile data.";
                            } else {
                                kb.m1282c(this.f1380a);
                                this.dF = "I've toggled mobile data.";
                            }
                        }
                    }
                } else if (!this.cm && !this.cn && !this.cp && !this.co) {
                    this.dF = "Sorry, but I couldn't understand the connection you wished to change.";
                    this.dH = 1;
                } else if (VERSION.SDK_INT < 17) {
                    if (this.cm) {
                        jy.m1234a(this.f1380a, true);
                        this.dF = "I've toggled airplane mode";
                    } else if (this.cn) {
                        jy.m1234a(this.f1380a, false);
                        this.dF = "I've toggled airplane mode";
                    } else if (this.cp || this.co) {
                        if (ht.m1146a(this.f1380a)) {
                            jy.m1234a(this.f1380a, false);
                        } else {
                            jy.m1234a(this.f1380a, true);
                        }
                        this.dF = "I've toggled airplane mode";
                    }
                } else if (lx.ac(this.f1380a)) {
                    this.dF = "This feature will be available for rooted Jelly Bean devices very soon";
                } else {
                    this.dF = "As of Android 4 point 2, you need to be rooted to change the airplane mode configuration";
                }
            } else if (this.af) {
                if (hc.f1269b) {
                    ls.m1344a("commandDisplay: " + this.af);
                }
                if (this.cU) {
                    this.dF = "Displayed " + this.dr;
                    jy.m1273x(this.f1380a, this.dq);
                }
            } else if (this.ak) {
                if (hc.f1269b) {
                    ls.m1344a("commandTasker: " + this.ak);
                }
                mw b = mv.m1489b(this.f1380a);
                if (b.equals(mw.NotInstalled)) {
                    if (hc.f1269b) {
                        ls.m1347d("taskerStatus: NotInstalled");
                    }
                    this.dF = "You don't have Tasker installed.";
                    this.dH = 1;
                } else if (b.equals(mw.NotEnabled)) {
                    if (hc.f1269b) {
                        ls.m1347d("taskerStatus: NotEnabled or wrong version");
                    }
                    r1 = mv.m1485a(this.f1380a);
                    if (r1.matches("net.dinglisch.android.tasker") || r1.matches("net.dinglisch.android.taskerm")) {
                        r0 = "";
                        if (r1.matches("net.dinglisch.android.tasker")) {
                            if (hc.f1269b) {
                                ls.m1346c("tskpack Direct: " + r1);
                            }
                            r0 = "net.dinglisch.android.tasker";
                        } else if (r1.matches("net.dinglisch.android.taskerm")) {
                            if (hc.f1269b) {
                                ls.m1346c("tskpack Market: " + r1);
                            }
                            r0 = "net.dinglisch.android.taskerm";
                        }
                        if (jy.m1251f(this.f1380a, r0)) {
                            this.dF = "Please check that Tasker is enabled.";
                            this.dH = 1;
                        } else {
                            this.dF = "Sorry, but there appears to be a problem with your Tasker installation.";
                            this.dH = 1;
                        }
                    } else {
                        if (hc.f1269b) {
                            ls.m1347d("Tasker Version not detected: " + r1);
                        }
                        this.dF = "I couldn't detect your Tasker version.";
                        this.dH = 1;
                    }
                } else if (b.equals(mw.AccessBlocked)) {
                    if (hc.f1269b) {
                        ls.m1347d("taskerStatus: AccessBlocked");
                    }
                    r0 = new Intent(mv.m1488b());
                    r0.setFlags(268435456);
                    this.f1380a.startActivity(r0);
                    this.dF = "So I can execute tasks for you, please tick the box that allows external access.";
                } else if (b.equals(mw.OK)) {
                    if (hc.f1269b) {
                        ls.m1346c("taskerStatus: OK");
                    }
                    if (this.aJ) {
                        if (hc.f1269b) {
                            ls.m1344a("commandTaskerDisplay: " + this.aJ);
                        }
                        r0 = new Intent(mv.m1484a());
                        r0.setFlags(268435456);
                        this.f1380a.startActivity(r0);
                        this.dF = "Tasks displayed.";
                    } else {
                        r0 = jb.m1196a(this.f1380a, this.f1405z);
                        if (r0.matches("")) {
                            this.dF = "I couldn't detect that task.";
                            this.dH = 1;
                        } else {
                            this.f1380a.sendBroadcast(new mv(r0));
                            this.dF = "Task executed.";
                        }
                    }
                } else {
                    if (hc.f1269b) {
                        ls.m1347d("taskerStatus: " + b);
                    }
                    this.dF = "There was an error communicating with Tasker.";
                    this.dH = 1;
                }
            } else if (this.ag) {
                if (hc.f1269b) {
                    ls.m1344a("commandCall: " + this.ag);
                }
                if (this.cU) {
                    jy.m1272w(this.f1380a, "tel:" + this.ds);
                    if (this.ap) {
                        if (hc.f1269b) {
                            ls.m1344a("commandHome: " + this.ap);
                        }
                    } else if (this.aq) {
                        if (hc.f1269b) {
                            ls.m1344a("commandWork: " + this.aq);
                        }
                    } else if (this.ar && hc.f1269b) {
                        ls.m1344a("commandMobile: " + this.ar);
                    }
                }
            } else if (this.al) {
                if (hc.f1269b) {
                    ls.m1344a("commandFacebook: " + this.al);
                }
                r0 = lx.m1383V(this.f1380a);
                long longValue = lx.m1382U(this.f1380a).longValue();
                C0102b c0102b = new C0102b("337811739620196");
                if (!r0.matches("")) {
                    c0102b.m308b(r0);
                }
                if (longValue != 0) {
                    c0102b.m304a(longValue);
                }
                if (c0102b.m306a()) {
                    if (hc.f1269b) {
                        ls.m1346c("Facebook Session Valid");
                    }
                    GlobalV.m893u(true);
                    GlobalV.m845h(1);
                    GlobalV.m875o(true);
                    f1354b = true;
                    this.dF = "What do you want to say?";
                    GlobalV.m860k(true);
                } else {
                    if (hc.f1269b) {
                        ls.m1347d("Facebook Session Invalid");
                    }
                    this.dF = "Please manually authorise Facebook.";
                    r0 = new Intent(this.f1380a, ActivityLinkApps.class);
                    r0.addFlags(268435456);
                    this.f1380a.startActivity(r0);
                }
            } else if (this.am) {
                if (hc.f1269b) {
                    ls.m1344a("commandTwitter: " + this.am);
                }
                SharedPreferences sharedPreferences = this.f1380a.getSharedPreferences("utterPref", 0);
                r1 = sharedPreferences.getString("tw_token_key", null);
                r0 = sharedPreferences.getString("tw_token_secret", null);
                if (r1 == null || r0 == null) {
                    this.dF = "You need to manually authorise Twitter before I can tweet on your behalf";
                    r0 = new Intent(this.f1380a, ActivityLinkApps.class);
                    r0.addFlags(268435456);
                    this.f1380a.startActivity(r0);
                } else {
                    GlobalV.m877p(true);
                    GlobalV.m850i(1);
                    GlobalV.m893u(true);
                    f1354b = true;
                    this.dF = "What do you want to tweet?";
                    GlobalV.m860k(true);
                }
            } else if (this.an || this.ao) {
                if (hc.f1269b) {
                    ls.m1344a("commandWeather: " + this.an);
                    ls.m1344a("commandWeatherIn: " + this.ao);
                }
            } else if (this.ah || this.ai) {
                if (hc.f1269b) {
                    ls.m1344a("commandTime: " + this.ah);
                    ls.m1344a("commandTimeIn: " + this.ai);
                }
            } else if (this.ay) {
                if (hc.f1269b) {
                    ls.m1344a("commandApplication: " + this.ay);
                }
                if (this.f1370P.isEmpty()) {
                    this.dF = "Sorry, but I couldn't find that application.";
                    this.dH = 1;
                } else if (((String) this.f1370P.get(0)).matches("oom")) {
                    this.dF = "Sorry, but I couldn't generate the application list. The developer is working on a fix for this problem.";
                    this.dH = 1;
                } else if (!jy.m1251f(this.f1380a, (String) this.f1370P.get(1))) {
                    this.dF = "Sorry, but I had a problem opening that application.";
                    this.dH = 1;
                } else if (this.f1370P.size() == 3) {
                    if (hc.f1269b) {
                        ls.m1346c("getApp used: " + ((String) this.f1370P.get(2)));
                    }
                    this.dF = "Opened " + ((String) this.f1370P.get(0)) + " as the closest match.";
                } else {
                    this.dF = "Opened " + ((String) this.f1370P.get(0));
                }
            } else {
                this.dH = 1;
                if (lx.m1455x(this.f1380a) > 3) {
                    if (lx.m1453v(this.f1380a)) {
                        switch (lx.m1397b(this.f1380a)) {
                            case 0:
                                this.dF = lv.m1358b(this.f1380a);
                                break;
                            case 1:
                                this.dF = lv.m1357a(this.f1380a);
                                f1354b = true;
                                break;
                            case 2:
                                jn.f1553a = true;
                                jy.m1274y(this.f1380a, "http://google." + jn.m1212a() + "/search?q=" + this.dE);
                                this.dF = "I'm going to Google that";
                                break;
                            case 3:
                                this.dE = this.dE.replaceAll(" ", "%20");
                                jy.m1238b(this.f1380a, this.dE);
                                this.dF = "I'm going to let Wolfram Alpha answer that";
                                break;
                            case 4:
                                this.dF = "Sorry, I didn't understand that";
                                f1354b = true;
                                GlobalV.m817a(this.dE);
                                GlobalV.m819a(true);
                                GlobalV.m893u(true);
                                break;
                            default:
                                break;
                        }
                    }
                    this.dF = "We seem to be having problems communicating. I've enabled visual feedback, so you can see what is being returned from the Google Servers. If you haven't already, please do read the structured commands, or for help, tap the link to the user guide, from the application's main page.";
                    GlobalV.m899w(true);
                    lx.m1432i(this.f1380a, true);
                    ly.m1460a(this.f1380a, 12000, true);
                    r0 = new Intent(this.f1380a, ActivityCommand.class);
                    r0.setFlags(268435456);
                    try {
                        this.f1380a.startActivity(r0);
                    } catch (Exception e4222) {
                        e4222.printStackTrace();
                    }
                    lx.m1454w(this.f1380a);
                } else {
                    lx.m1413d(this.f1380a, lx.m1455x(this.f1380a) + 1);
                    switch (lx.m1397b(this.f1380a)) {
                        case 0:
                            this.dF = lv.m1358b(this.f1380a);
                            break;
                        case 1:
                            this.dF = lv.m1357a(this.f1380a);
                            f1354b = true;
                            break;
                        case 2:
                            jn.f1553a = true;
                            jy.m1274y(this.f1380a, "http://google." + jn.m1212a() + "/search?q=" + this.dE);
                            this.dF = "I'm going to Google that";
                            break;
                        case 3:
                            this.dE = this.dE.replaceAll(" ", "%20");
                            jy.m1238b(this.f1380a, this.dE);
                            this.dF = "I'm going to let Wolfram Alpha answer that";
                            break;
                        case 4:
                            this.dF = "Sorry, I didn't understand that";
                            f1354b = true;
                            GlobalV.m817a(this.dE);
                            GlobalV.m819a(true);
                            GlobalV.m893u(true);
                            break;
                    }
                    this.aa = false;
                }
            }
            if (this.dF == null) {
                if (hc.f1269b) {
                    ls.m1347d("myWords NULL");
                }
                this.dH = 1;
                lc.m1313a(this.f1380a, false, "Sorry, but an error occurred.");
                lt.m1349a(1);
            } else if (this.dF.matches("")) {
                if (hc.f1269b) {
                    ls.m1347d("myWords empty");
                }
                lt.m1349a(1);
            } else if (f1354b) {
                if (hc.f1269b) {
                    ls.m1346c("startRecog: true");
                }
                lc.m1313a(this.f1380a, true, this.dF);
            } else {
                if (hc.f1269b) {
                    ls.m1346c("startRecog: false");
                }
                lc.m1313a(this.f1380a, false, this.dF);
            }
        }
        mb.m1469a(this.f1380a, this.dG, this.dH);
        if (this.aa) {
            lx.m1413d(this.f1380a, 0);
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f1381c;
        if (hc.f1269b) {
            ls.m1344a("EstablishCommand elapsed: " + currentTimeMillis);
        }
        m1144b();
        super.onPostExecute(null);
    }

    private void m1144b() {
        this.f1364J.clear();
        this.f1365K.clear();
        this.f1366L.clear();
        this.f1369O.clear();
        this.f1367M.clear();
        this.f1368N.clear();
        this.f1370P.clear();
        this.f1371Q.clear();
        this.f1373S.clear();
        this.f1374T.clear();
        this.f1375U.clear();
        this.f1378Y.clear();
        this.f1382d.clear();
        this.f1387h.clear();
        this.f1388i.clear();
        this.f1389j.clear();
        this.f1390k.clear();
        this.f1391l.clear();
        this.f1392m.clear();
        this.f1393n.clear();
        this.f1394o.clear();
        this.f1395p.clear();
        this.f1396q.clear();
        this.f1397r.clear();
        this.f1398s.clear();
        this.f1399t.clear();
        this.f1400u.clear();
        this.f1401v.clear();
        this.f1403x.clear();
        this.f1404y.clear();
        this.f1405z.clear();
        this.f1355A.clear();
        this.f1356B.clear();
        this.f1357C.clear();
        this.f1358D.clear();
        this.f1359E.clear();
        this.f1360F.clear();
        this.f1402w.clear();
        this.f1386g.clear();
        this.f1376V.clear();
        this.f1361G.clear();
        this.f1384e.clear();
        this.f1362H.clear();
        this.f1377W.clear();
        this.f1363I.clear();
        this.bv = false;
        this.aA = false;
        this.ab = false;
        this.ac = false;
        this.ae = false;
        this.af = false;
        this.ag = false;
        this.aj = false;
        this.as = false;
        this.ak = false;
        this.aJ = false;
        this.al = false;
        this.am = false;
        this.an = false;
        this.ao = false;
        this.ah = false;
        this.ai = false;
        this.at = false;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.aS = false;
        this.aB = false;
        this.az = false;
        this.aC = false;
        this.aD = false;
        this.aE = false;
        this.aF = false;
        this.aG = false;
        this.aH = false;
        this.aI = false;
        this.aK = false;
        this.aL = false;
        this.aO = false;
        this.aP = false;
        this.aQ = false;
        this.aR = false;
        this.aT = false;
        this.aU = false;
        this.aV = false;
        this.aW = false;
        this.aX = false;
        this.aY = false;
        this.aZ = false;
        this.ba = false;
        this.bb = false;
        this.bc = false;
        this.bd = false;
        this.be = false;
        this.bf = false;
        this.bg = false;
        this.bh = false;
        this.bi = false;
        this.bj = false;
        this.bk = false;
        this.bl = false;
        this.bm = false;
        this.bn = false;
        this.bo = false;
        this.bp = false;
        this.bq = false;
        this.br = false;
        this.bs = false;
        this.bt = false;
        this.bu = false;
        this.bw = false;
        this.bx = false;
        this.by = false;
        this.bz = false;
        this.bA = false;
        this.ap = false;
        this.aq = false;
        this.ad = false;
        this.ar = false;
        this.bB = false;
        this.bC = false;
        this.bD = false;
        this.bE = false;
        this.bG = false;
        this.aM = false;
        this.aN = false;
        this.bF = false;
        this.bH = false;
        this.bI = false;
        this.bJ = false;
        this.bK = false;
        this.bL = false;
        this.bM = false;
        this.bN = false;
        this.bO = false;
        this.bP = false;
        this.bQ = false;
        this.bR = false;
        this.bS = false;
        this.bT = false;
        this.bU = false;
        this.bX = false;
        this.bY = false;
        this.cV = false;
        this.cW = false;
        this.cX = false;
        this.cY = false;
        this.cZ = false;
        this.da = false;
        this.ca = false;
        this.cb = false;
        this.cc = false;
        this.cd = false;
        this.ce = false;
        this.cf = false;
        this.cg = false;
        this.ch = false;
        this.ci = false;
        this.cj = false;
        this.ck = false;
        this.cl = false;
        this.cm = false;
        this.cn = false;
        this.co = false;
        this.cp = false;
        this.cq = false;
        this.cr = false;
        this.cs = false;
        this.ct = false;
        this.cu = false;
        this.cv = false;
        this.cw = false;
        this.cx = false;
        this.cy = false;
        this.cz = false;
        this.cA = false;
        this.df = false;
        this.bV = false;
        this.bW = false;
        this.bZ = false;
        this.cB = false;
        this.cC = false;
        this.cD = false;
        this.cE = false;
        this.cF = false;
        this.cG = false;
        this.cH = false;
        this.cI = false;
        this.cJ = false;
        this.cK = false;
        this.cL = false;
        this.cM = false;
        this.cN = false;
        this.cO = false;
        this.cU = false;
        this.db = false;
        this.dc = false;
        this.dd = false;
        this.de = false;
        this.dq = "";
        this.dr = "";
        this.ds = "";
        this.dt = "";
        this.du = "unknown";
        this.dv = "";
        this.dw = "";
        this.dx = "";
        this.dz = "";
        this.dA = "";
        this.dB = "";
        this.dC = "";
        this.dD = "";
        this.dE = "";
        this.cP = false;
        this.cQ = false;
        this.cR = false;
        this.cS = false;
        this.cT = false;
        this.dF = "";
        f1354b = false;
        hx.f1419a = false;
        hx.f1420b = false;
        this.dG = 0;
        this.dH = 0;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m1142a((ArrayList[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        m1143a();
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        if (hc.f1269b) {
            ls.m1345b("EstablishCommand onPreEx");
        }
    }

    protected final /* synthetic */ void onProgressUpdate(Object... objArr) {
        String[] strArr = (String[]) objArr;
        super.onProgressUpdate(strArr);
        lc.m1313a(this.f1380a, false, strArr[0]);
    }
}
