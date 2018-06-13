package com.brandall.nutter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Pattern;

public final class hn {
    private static ArrayList<String> f1286a = new ArrayList();
    private static boolean f1287b = false;
    private static boolean f1288c = false;
    private static String f1289d = "";
    private static Pattern f1290e = Pattern.compile(".*\\bcalled\\b.*");
    private static Pattern f1291f = Pattern.compile(".*\\bnamed\\b.*");
    private static Pattern f1292g = Pattern.compile(".*\\bnames\\b.*");
    private static Pattern f1293h = Pattern.compile(".*\\bname\\b.*");
    private static Pattern f1294i = Pattern.compile(".*\\bcalls\\b.*");
    private static Pattern f1295j = Pattern.compile(".*\\bcall\\b.*");
    private static Pattern f1296k = Pattern.compile(".*\\bcold\\b.*");

    public static ArrayList<String> m1125a(ArrayList<String> arrayList) {
        boolean z = true;
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            f1289d = ((String) listIterator.next()).toString().toLowerCase(Locale.US).trim();
            ls.m1344a("alarmTime: " + f1289d);
            if (f1289d.contains("to minutes")) {
                f1289d = f1289d.replace("to minutes", "2 minutes");
            }
            if (f1289d.contains("for minutes")) {
                f1289d = f1289d.replace("for minutes", "4 minutes");
            }
            if (m1126a(f1289d)) {
                f1288c = true;
                break;
            }
            ls.m1345b("CheckStructure: false: " + f1289d);
        }
        if (f1288c) {
            ls.m1346c("canStructure : true");
            CharSequence charSequence = f1289d;
            boolean z2 = f1290e.matcher(charSequence).matches() ? true : f1295j.matcher(charSequence).matches() ? true : f1294i.matcher(charSequence).matches() ? true : f1291f.matcher(charSequence).matches() ? true : f1293h.matcher(charSequence).matches() ? true : f1292g.matcher(charSequence).matches() ? true : f1296k.matcher(charSequence).matches();
            f1287b = z2;
            ls.m1346c("called:" + f1287b);
            f1286a = m1127b(f1289d);
            String str = f1289d;
            z2 = str.contains("hour") && str.contains("minute");
            if (z2) {
                ls.m1346c("isHourMinute : true");
                if (f1287b && f1286a.size() < 3) {
                    ls.m1347d("called && toReturn.size() < 3");
                    f1286a.add(0, "ERROR");
                } else if (f1287b || f1286a.size() >= 2) {
                    ls.m1346c("HourMinute successful");
                    f1286a.add(0, "HM");
                    m1128b(f1286a);
                } else {
                    ls.m1347d("!called && toReturn.size() < 2");
                    f1286a.add(0, "ERROR");
                }
            } else {
                str = f1289d;
                z2 = str.contains("hour") && !str.contains("minute");
                if (z2) {
                    ls.m1346c("isHour : true");
                    if (f1287b && f1286a.size() < 2) {
                        ls.m1347d("called && toReturn.size() < 2");
                        f1286a.add(0, "ERROR");
                    } else if (f1287b || f1286a.size() > 0) {
                        ls.m1346c("Hour successful");
                        f1286a.add(0, "H");
                        m1128b(f1286a);
                    } else {
                        ls.m1347d("!called && toReturn.size() < 1");
                        f1286a.add(0, "ERROR");
                    }
                } else {
                    str = f1289d;
                    if (str.contains("hour") || !str.contains("minute")) {
                        z = false;
                    }
                    if (z) {
                        ls.m1346c("isMinute : true");
                        if (f1287b && f1286a.size() < 2) {
                            ls.m1347d("called && toReturn.size() < 2");
                            f1286a.add(0, "ERROR");
                        } else if (f1287b || f1286a.size() > 0) {
                            ls.m1346c("Minute successful");
                            f1286a.add(0, "M");
                            m1128b(f1286a);
                        } else {
                            ls.m1347d("!called && toReturn.size() < 1");
                            f1286a.add(0, "ERROR");
                        }
                    }
                }
            }
        } else {
            ls.m1347d("canStructure : false");
            f1286a.add(0, "ERROR");
        }
        ls.m1344a("toReturn: " + f1286a.size() + " : " + f1286a.toString());
        return f1286a;
    }

    private static boolean m1126a(String str) {
        if (!str.contains("hour")) {
            if (!str.contains("minute")) {
                return false;
            }
            if (!(str.contains(" in ") || str.contains(" at ") || str.contains(" for "))) {
                return false;
            }
        }
        String[] split = str.trim().split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("hour")) {
                String str2 = split[i - 1];
                ls.m1344a("disecth: " + str2);
                try {
                    Integer.parseInt(str2);
                    if (!str.contains("minute")) {
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
                    return true;
                } catch (NumberFormatException e2) {
                    ls.m1347d("Number of minutes not numeric");
                    return false;
                }
            }
        }
        return false;
    }

    private static ArrayList<String> m1127b(String str) {
        ArrayList<String> arrayList = new ArrayList();
        String[] split = str.trim().split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("hour")) {
                arrayList.add(split[i - 1]);
            }
            if (split[i].contains("minute")) {
                arrayList.add(split[i - 1]);
            }
        }
        if (f1287b) {
            String[] strArr = new String[]{""};
            if (f1290e.matcher(str).matches()) {
                strArr = str.split("called");
            } else if (f1295j.matcher(str).matches()) {
                strArr = str.split("call");
            } else if (f1294i.matcher(str).matches()) {
                strArr = str.split("calls");
            } else if (f1291f.matcher(str).matches()) {
                strArr = str.split("named");
            } else if (f1293h.matcher(str).matches()) {
                strArr = str.split("name");
            } else if (f1292g.matcher(str).matches()) {
                strArr = str.split("names");
            } else if (f1296k.matcher(str).matches()) {
                strArr = str.split("cold");
            }
            if (strArr.length > 1) {
                arrayList.add(strArr[1]);
            }
        }
        ls.m1344a("toParams: " + arrayList.size() + " : " + arrayList.toString());
        return arrayList;
    }

    private static ArrayList<String> m1128b(ArrayList<String> arrayList) {
        Calendar instance = Calendar.getInstance();
        ls.m1346c("Original = " + instance.getTime());
        if (((String) arrayList.get(0)).matches("HM")) {
            try {
                instance.add(12, (Integer.valueOf((String) arrayList.get(2)).intValue() + (Integer.valueOf((String) arrayList.get(1)).intValue() * 60)) + 1);
                f1286a.remove(0);
                f1286a.remove(0);
                f1286a.remove(0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                f1286a.clear();
                f1286a.add(0, "ERROR");
                return f1286a;
            }
        } else if (((String) arrayList.get(0)).matches("H")) {
            ls.m1344a("toConvert.get(1): " + ((String) arrayList.get(1)));
            try {
                int intValue = Integer.valueOf((String) arrayList.get(1)).intValue();
                ls.m1344a("adding hour: " + intValue);
                instance.add(10, intValue);
                f1286a.remove(0);
                f1286a.remove(0);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                f1286a.clear();
                f1286a.add(0, "ERROR");
                return f1286a;
            }
        } else if (((String) arrayList.get(0)).matches("M")) {
            try {
                instance.add(12, Integer.valueOf((String) arrayList.get(1)).intValue() + 1);
                f1286a.remove(0);
                f1286a.remove(0);
            } catch (NumberFormatException e22) {
                e22.printStackTrace();
                f1286a.clear();
                f1286a.add(0, "ERROR");
                return f1286a;
            }
        }
        ls.m1344a("updated = " + instance.get(11) + " : " + instance.get(12));
        f1286a.add(0, String.valueOf(instance.get(12)));
        f1286a.add(0, String.valueOf(instance.get(11)));
        return f1286a;
    }
}
