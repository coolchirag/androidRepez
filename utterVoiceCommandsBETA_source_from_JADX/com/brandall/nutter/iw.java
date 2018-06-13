package com.brandall.nutter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.regex.Pattern;

public final class iw {
    private static ArrayList<String> f1489a = new ArrayList();
    private static ArrayList<String> f1490b = new ArrayList();
    private static ArrayList<String> f1491c = new ArrayList();
    private static ArrayList<String> f1492d = new ArrayList();
    private static Pattern f1493e = Pattern.compile(".*\\brecovery\\b.*");
    private static Pattern f1494f = Pattern.compile(".*\\bbootloader\\b.*");
    private static Pattern f1495g = Pattern.compile(".*\\bhot\\b.*");
    private static Pattern f1496h = Pattern.compile(".*\\bgovernor\\b.*");
    private static Pattern f1497i = Pattern.compile(".*\\bto\\b.*");
    private static boolean f1498j = false;
    private static boolean f1499k = false;
    private static boolean f1500l = false;
    private static boolean f1501m = false;
    private static boolean f1502n = false;
    private static boolean f1503o = false;
    private static boolean f1504p = false;

    public static iy m1193a(ArrayList<String> arrayList) {
        if (hc.f1269b) {
            ls.m1345b("rootCommandEstablish");
        }
        if (hc.f1269b) {
            ls.m1346c("rootCommandData: " + arrayList.size() + " : " + arrayList.toString());
        }
        f1498j = false;
        f1500l = false;
        f1499k = false;
        f1501m = false;
        f1502n = false;
        f1503o = false;
        f1504p = false;
        f1489a.clear();
        f1491c.clear();
        f1490b.clear();
        f1492d.clear();
        iw iwVar = new iw();
        iwVar.getClass();
        iy iyVar = new iy(iwVar);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ListIterator listIterator = arrayList.listIterator();
        Arrays.asList(arrayList.toArray());
        while (listIterator.hasNext()) {
            Object next = listIterator.next();
            String trim = next.toString().toLowerCase().trim();
            if (hc.f1269b) {
                ls.m1345b("rawpass: " + trim);
            }
            if (f1496h.matcher(trim).matches()) {
                f1489a.add(trim);
                f1503o = true;
            } else if (!f1503o) {
                if ((f1494f.matcher(trim).matches() && f1493e.matcher(trim).matches()) || ((f1495g.matcher(trim).matches() && f1493e.matcher(trim).matches()) || (f1494f.matcher(trim).matches() && f1495g.matcher(trim).matches()))) {
                    f1498j = true;
                    break;
                } else if (f1494f.matcher(trim).matches() || f1493e.matcher(trim).matches() || f1495g.matcher(trim).matches()) {
                    if (f1494f.matcher(trim).matches()) {
                        if (hc.f1269b) {
                            ls.m1344a("ER bootloader.matcher: " + trim);
                        }
                        if (f1501m || f1502n) {
                            f1498j = true;
                            break;
                        }
                        arrayList3.add(trim);
                        f1500l = true;
                        f1499k = false;
                    }
                    if (f1493e.matcher(trim).matches()) {
                        if (hc.f1269b) {
                            ls.m1344a("ER recovery.matcher: " + trim);
                        }
                        if (f1500l || f1502n) {
                            f1498j = true;
                            break;
                        }
                        arrayList3.add(trim);
                        f1501m = true;
                        f1499k = false;
                    }
                    if (f1495g.matcher(trim).matches()) {
                        if (hc.f1269b) {
                            ls.m1344a("ER hot.matcher: " + trim);
                        }
                        if (f1500l || f1501m) {
                            f1498j = true;
                            break;
                        }
                        arrayList3.add(trim);
                        f1502n = true;
                        f1499k = false;
                    } else {
                        continue;
                    }
                } else if (f1501m || f1500l || f1502n) {
                    if (hc.f1269b) {
                        ls.m1347d("Removed as commandRecovery commandBootloader already set: " + next);
                    }
                    arrayList2.add(trim);
                } else {
                    arrayList3.add(trim);
                    f1499k = true;
                }
            } else if (hc.f1269b) {
                ls.m1346c("ER skipping as commandGovernor: true: " + trim);
            }
        }
        if (f1503o) {
            if (hc.f1269b) {
                ls.m1346c("ER commandGovernor: true: " + f1489a.toString());
            }
            ArrayList arrayList4 = new ArrayList();
            ArrayList a = kf.m1292a();
            if (a.size() == 1) {
                if (hc.f1269b) {
                    ls.m1347d("govArray == 1");
                }
                iyVar.f1514b.add("error");
                f1504p = true;
            } else {
                ListIterator listIterator2 = f1489a.listIterator();
                Arrays.asList(f1489a.toArray());
                while (listIterator2.hasNext()) {
                    String trim2 = listIterator2.next().toString().toLowerCase().trim();
                    if (hc.f1269b) {
                        ls.m1345b("rawpass: " + trim2);
                    }
                    String[] split = trim2.split("governor ");
                    if (hc.f1269b) {
                        ls.m1344a("raw: " + split.length);
                    }
                    if (split.length > 1) {
                        trim2 = split[1].trim();
                        if (hc.f1269b) {
                            ls.m1344a("rawpass: " + trim2);
                        }
                        if (f1497i.matcher(trim2).matches()) {
                            trim2 = trim2.replaceAll("to ", "").trim();
                        }
                        String trim3 = trim2.replaceAll("\\s", "").trim();
                        Iterator it = a.iterator();
                        while (it.hasNext()) {
                            trim2 = (String) it.next();
                            if (trim3.matches(trim2)) {
                                if (hc.f1269b) {
                                    ls.m1344a("govArray match: " + trim2 + " : " + trim3);
                                }
                                iyVar.f1514b.add(trim3);
                                f1504p = true;
                            } else {
                                double a2 = new le().mo94a(trim3, trim2);
                                if (hc.f1269b) {
                                    ls.m1346c("test: " + a2 + " : " + trim3 + " : " + trim2);
                                }
                                f1490b.add(String.valueOf(a2));
                                f1492d.add(trim2);
                            }
                        }
                        continue;
                    }
                }
            }
            iyVar.f1513a = ix.governor;
        } else if (f1498j) {
            if (hc.f1269b) {
                ls.m1347d("ER multipleCommand: " + f1498j);
            }
            iyVar.f1513a = ix.multipleCommand;
        } else if (f1500l) {
            if (hc.f1269b) {
                ls.m1345b("ER commandBootloader: " + f1500l);
            }
            iyVar.f1513a = ix.bootloader;
        } else if (f1499k) {
            if (hc.f1269b) {
                ls.m1345b("ER commandReboot: " + f1499k);
            }
            iyVar.f1513a = ix.reboot;
        } else if (f1501m) {
            if (hc.f1269b) {
                ls.m1345b("ER commandRecovery: " + f1501m);
            }
            iyVar.f1513a = ix.recovery;
        } else if (f1502n) {
            if (hc.f1269b) {
                ls.m1345b("ER commandHot: " + f1502n);
            }
            iyVar.f1513a = ix.hot;
        } else {
            if (hc.f1269b) {
                ls.m1347d("ER AndroidSystem no command");
            }
            iyVar.f1513a = ix.error;
        }
        if (hc.f1269b) {
            ls.m1344a("toKeep: " + arrayList3.size() + " : " + arrayList3.toString());
        }
        if (hc.f1269b) {
            ls.m1344a("toRemove: " + arrayList2.size() + " : " + arrayList2.toString());
        }
        arrayList2.clear();
        if (!f1503o) {
            iyVar.f1514b = arrayList3;
        } else if (!f1504p) {
            if (hc.f1269b) {
                ls.m1346c("exactMatch: false");
            }
            if (!f1490b.isEmpty()) {
                Object max = Collections.max(f1490b);
                ListIterator listIterator3 = f1490b.listIterator();
                Arrays.asList(f1490b.toArray());
                while (listIterator3.hasNext()) {
                    int nextIndex = listIterator3.nextIndex();
                    if (listIterator3.next().equals(max)) {
                        iyVar.f1514b.add((String) f1492d.get(nextIndex));
                        if (hc.f1269b) {
                            ls.m1346c("Best gov match: " + ((String) f1492d.get(nextIndex)));
                        }
                    }
                }
            }
        }
        return iyVar;
    }
}
