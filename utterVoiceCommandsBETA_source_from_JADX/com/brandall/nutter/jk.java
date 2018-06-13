package com.brandall.nutter;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class jk {
    static final Locale f1546a = Locale.US;

    public static int m1207a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList = new ArrayList();
        he heVar = new he(context);
        ArrayList a = heVar.m1066a();
        ArrayList f = heVar.m1078f();
        if (hc.f1269b) {
            ls.m1344a("arrayUC: " + a.size() + " : " + a.toString());
        }
        if (a.isEmpty()) {
            if (hc.f1269b) {
                ls.m1346c("EUC arrayUC empty - new command");
            }
            return 0;
        }
        ListIterator listIterator = a.listIterator();
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            String trim = ((String) listIterator.next()).toString().toLowerCase(f1546a).replaceAll("\\p{P}", "").trim();
            if (hc.f1269b) {
                ls.m1344a("ucPass: " + trim);
            }
            str = str.toLowerCase(f1546a).replaceAll("\\p{P}", "").trim();
            if (hc.f1269b) {
                ls.m1344a("newEntry: " + str);
            }
            if (str.matches(trim)) {
                return ((Integer) f.get(nextIndex)).intValue();
            }
        }
        return 0;
    }

    public static String m1208a(Context context, ArrayList<String> arrayList) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        arrayList2 = new ArrayList();
        he heVar = new he(context);
        arrayList2 = heVar.m1066a();
        ArrayList f = heVar.m1078f();
        if (hc.f1269b) {
            ls.m1344a("arrayUC: " + arrayList2.size() + " : " + arrayList2.toString());
            ls.m1344a("arrayID: " + f.size() + " : " + f.toString());
        }
        if (arrayList2 == null || arrayList2.isEmpty()) {
            if (hc.f1269b) {
                ls.m1347d("EUC arrayUC empty");
            }
            str = "FALSE";
        } else {
            mp leVar = new le();
            ListIterator listIterator = arrayList2.listIterator();
            Object obj = null;
            int i = 0;
            while (listIterator.hasNext()) {
                int nextIndex = listIterator.nextIndex();
                String trim = ((String) listIterator.next()).toString().toLowerCase(f1546a).replaceAll("\\p{P}", "").trim();
                if (hc.f1269b) {
                    ls.m1344a("ucPass: " + trim);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    str = ((String) it.next()).toLowerCase(f1546a).replaceAll("\\p{P}", "").trim();
                    if (hc.f1269b) {
                        ls.m1344a("vd: " + str);
                    }
                    if (str.matches(trim)) {
                        obj = 1;
                        i = ((Integer) f.get(nextIndex)).intValue();
                        break;
                    }
                    double a = leVar.mo94a(str, trim);
                    if (a > 0.97d) {
                        if (hc.f1269b) {
                            ls.m1344a("vd: " + str + " ucPass: " + trim + " : " + a);
                        }
                        obj = 1;
                        i = ((Integer) f.get(nextIndex)).intValue();
                    }
                }
            }
            if (obj != null) {
                if (hc.f1269b) {
                    ls.m1344a("userCommandNumber: " + i);
                }
                int i2 = heVar.m1082i((long) i);
                if (i2 != 999) {
                    if (i2 != 777) {
                        str = "Sorry, but something went wrong executing your custom command";
                        he heVar2;
                        String d;
                        switch (i2) {
                            case 1:
                                ls.m1346c("CommandInteger actionCommandNumber: 1");
                                heVar2 = new he(context);
                                d = heVar2.m1073d((long) i);
                                if (d == null) {
                                    ls.m1347d("EUC displayContact: getContactID null");
                                    str = heVar2.m1081h((long) i);
                                    ls.m1344a("EUC displayContact getFailWords: " + str);
                                    break;
                                }
                                ls.m1344a("getContactID: " + d);
                                if (!jy.m1273x(context, d)) {
                                    ls.m1347d("EUC displayContact success: false");
                                    str = heVar2.m1081h((long) i);
                                    ls.m1344a("EUC displayContact getFailWords: " + str);
                                    break;
                                }
                                ls.m1344a("EUC displayContact success: true");
                                str = heVar2.m1079g((long) i);
                                ls.m1344a("EUC displayContact getSuccessWords: " + str);
                                break;
                            case 2:
                                ls.m1346c("CommandInteger actionCommandNumber: 2");
                                heVar2 = new he(context);
                                d = heVar2.m1071c((long) i);
                                if (d == null) {
                                    ls.m1347d("EUC taskerTask: taskName null");
                                    str = heVar2.m1081h((long) i);
                                    ls.m1344a("EUC taskerTask getFailWords: " + str);
                                    break;
                                }
                                ls.m1344a("taskName: " + d);
                                if (!jy.m1253g(context, d)) {
                                    ls.m1347d("EUC taskerTask success: false");
                                    str = heVar2.m1081h((long) i);
                                    ls.m1344a("EUC taskerTask getFailWords: " + str);
                                    break;
                                }
                                ls.m1344a("EUC taskerTask success: true");
                                str = heVar2.m1079g((long) i);
                                ls.m1344a("EUC taskerTask getSuccessWords: " + str);
                                break;
                            case 3:
                                ls.m1346c("CommandInteger actionCommandNumber: 3");
                                heVar2 = new he(context);
                                d = heVar2.m1071c((long) i);
                                String d2 = heVar2.m1073d((long) i);
                                if (d2 != null && d != null) {
                                    ls.m1344a("aname: " + d2);
                                    ls.m1344a("pname: " + d);
                                    if (!jy.m1230a(context, d, d2)) {
                                        ls.m1347d("EUC executeIntent success: false");
                                        str = heVar2.m1081h((long) i);
                                        ls.m1344a("EUC executeIntent getFailWords: " + str);
                                        break;
                                    }
                                    ls.m1344a("EUC executeIntent success: true");
                                    str = heVar2.m1079g((long) i);
                                    ls.m1344a("EUC executeIntent getSuccessWords: " + str);
                                    break;
                                }
                                ls.m1347d("EUC executeIntent: taskName null");
                                str = heVar2.m1081h((long) i);
                                ls.m1344a("EUC executeIntent getFailWords: " + str);
                                break;
                                break;
                            case 4:
                                ls.m1346c("CommandInteger actionCommandNumber: 4");
                                heVar2 = new he(context);
                                d = heVar2.m1075e((long) i);
                                if (d != null && !d.matches("NULL")) {
                                    ls.m1344a("getContactNumber: " + d);
                                    if (!jy.m1272w(context, "tel:" + d)) {
                                        ls.m1347d("EUC callContact success: false");
                                        str = heVar2.m1081h((long) i);
                                        ls.m1344a("EUC callContact getFailWords: " + str);
                                        break;
                                    }
                                    ls.m1344a("EUC callContact success: true");
                                    str = heVar2.m1079g((long) i);
                                    ls.m1344a("EUC callContact getSuccessWords: " + str);
                                    break;
                                }
                                ls.m1347d("EUC callContact: getContactID null");
                                str = heVar2.m1081h((long) i);
                                ls.m1344a("EUC callContact getFailWords: " + str);
                                break;
                                break;
                            case 5:
                                ls.m1346c("CommandInteger actionCommandNumber: 5");
                                heVar2 = new he(context);
                                d = heVar2.m1073d((long) i);
                                if (d != null && !d.isEmpty()) {
                                    ls.m1344a("pname: " + d);
                                    if (!jy.m1251f(context, d)) {
                                        ls.m1347d("EUC launchApp success: false");
                                        str = heVar2.m1081h((long) i);
                                        ls.m1344a("EUC launchApp getFailWords: " + str);
                                        break;
                                    }
                                    ls.m1344a("EUC launchApp success: true");
                                    str = heVar2.m1079g((long) i);
                                    ls.m1344a("EUC launchApp getSuccessWords: " + str);
                                    break;
                                }
                                ls.m1347d("EUC launchApp: getContactID null");
                                str = heVar2.m1081h((long) i);
                                ls.m1344a("EUC launchApp getFailWords: " + str);
                                break;
                                break;
                            default:
                                ls.m1347d("CommandInteger actionCommandNumber: default");
                                break;
                        }
                    }
                    str = heVar.m1075e((long) i).toLowerCase(f1546a).trim();
                    if (!(str.matches("null") || str.isEmpty())) {
                        if (hc.f1269b) {
                            ls.m1344a("EUC getRecogLocale: " + str);
                        }
                        GlobalV.m852i(true);
                        GlobalV.m831d(str);
                    }
                    str = heVar.m1077f((long) i).toLowerCase(f1546a).trim();
                    if (!(str.matches("null") || str.isEmpty())) {
                        if (hc.f1269b) {
                            ls.m1344a("EUC getVoiceLocale: " + str);
                        }
                        ly.f1700a = true;
                        String[] split;
                        if (str.contains("-")) {
                            split = str.split("-");
                            if (split.length > 1) {
                                if (hc.f1269b) {
                                    ls.m1344a("EUC-: gls0: " + split[0] + "  : gls1 :" + split[1]);
                                }
                                ly.f1701b = new Locale(split[0], split[1]);
                            } else {
                                ly.f1701b = new Locale(str);
                            }
                        } else if (str.contains("\\s")) {
                            split = str.split("\\s");
                            if (split.length > 1) {
                                if (hc.f1269b) {
                                    ls.m1344a("EUC ws: gls0: " + split[0] + "  : gls1 :" + split[1]);
                                }
                                ly.f1701b = new Locale(split[0], split[1]);
                            } else {
                                ly.f1701b = new Locale(str);
                            }
                        } else if (str.contains("_")) {
                            split = str.split("_");
                            if (split.length > 1) {
                                if (hc.f1269b) {
                                    ls.m1344a("EUC_: gls0: " + split[0] + "  : gls1 :" + split[1]);
                                }
                                ly.f1701b = new Locale(split[0], split[1]);
                            } else {
                                ly.f1701b = new Locale(str);
                            }
                        } else {
                            ly.f1701b = new Locale(str);
                        }
                    }
                    boolean matches = heVar.m1071c((long) i).toLowerCase(f1546a).matches("true");
                    hs.f1354b = true;
                    str = heVar.m1079g((long) i).toLowerCase(f1546a);
                    if (context.getSharedPreferences("utterPref", 0).getBoolean("tasker_variables", false)) {
                        str = jc.m1199a(context, str);
                    }
                    if (hc.f1269b) {
                        ls.m1346c("successWords post Tasker: " + str);
                    }
                    if (str.contains("se~")) {
                        m1209b(context, str);
                        ServiceTTS.f859k = matches;
                    } else {
                        hs.f1354b = matches;
                    }
                } else {
                    if (hc.f1269b) {
                        ls.m1347d("EUC gotActionCommandNumber = 999");
                    }
                    str = "Sorry, but something went wrong executing your custom command";
                }
            } else {
                if (hc.f1269b) {
                    ls.m1345b("EUC user command not matched");
                }
                str = "FALSE";
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (hc.f1269b) {
            ls.m1346c("EstablishUserCommand elapsed: " + currentTimeMillis2);
        }
        return str;
    }

    public static void m1209b(Context context, String str) {
        if (hc.f1269b) {
            ls.m1346c("in structureSoundEffectArray");
        }
        ServiceTTS.f857i = true;
        ArrayList arrayList = new ArrayList();
        String replaceAll = str.replaceAll("~", "zzz");
        Matcher matcher = Pattern.compile("(.*?)\\b(sezzz(.*?))\\b").matcher(replaceAll);
        int i = 0;
        while (matcher.find()) {
            i++;
            if (hc.f1269b) {
                ls.m1346c("Matcher found count: " + i);
                ls.m1346c("group1: " + matcher.group(1));
                ls.m1346c("group2: " + matcher.group(2));
                ls.m1346c("group3: " + matcher.group(3));
            }
            if (!matcher.group(1).replaceAll("\\s", "").isEmpty()) {
                arrayList.add(matcher.group(1).trim());
                replaceAll = replaceAll.replaceFirst(matcher.group(1), "");
                if (hc.f1269b) {
                    ls.m1346c("soundSearch post group1: " + replaceAll);
                }
            }
            if (!matcher.group(2).replaceAll("\\s", "").isEmpty()) {
                replaceAll = replaceAll.replaceFirst(matcher.group(2), "");
                if (hc.f1269b) {
                    ls.m1346c("soundSearch post group2: " + replaceAll);
                }
            }
            arrayList.add(ja.m1195a(context, matcher.group(3).trim()));
        }
        if (!replaceAll.trim().replaceAll("\\s+", "").isEmpty()) {
            if (hc.f1269b) {
                ls.m1346c("soundSearch before adding to combined: " + replaceAll);
            }
            arrayList.add(replaceAll.trim().replaceAll("\\s+", " "));
        }
        ServiceTTS.f858j.clear();
        ServiceTTS.f858j.addAll(arrayList);
        if (hc.f1269b) {
            ls.m1346c("soundSearch: " + replaceAll);
            ls.m1344a("combined: " + arrayList.size() + " : " + arrayList.toString());
        }
    }
}
