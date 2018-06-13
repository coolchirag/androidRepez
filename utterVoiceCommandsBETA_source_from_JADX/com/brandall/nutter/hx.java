package com.brandall.nutter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredPostal;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.PhoneLookup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;
import java.util.Locale;

public final class hx {
    public static boolean f1419a = false;
    public static boolean f1420b = false;

    public static String m1148a(Context context, Uri uri) {
        String str = "error";
        try {
            Cursor query = context.getContentResolver().query(uri, null, null, null, null);
            String string = query.moveToFirst() ? query.getString(query.getColumnIndex("display_name")) : str;
            query.close();
            return string == null ? "error" : string;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static String m1149a(Context context, String str) {
        String string;
        Exception exception;
        String str2 = "null";
        if (hc.f1269b) {
            ls.m1344a("atHome: " + f1419a);
            ls.m1344a("atWork: " + f1420b);
        }
        try {
            Cursor query = context.getContentResolver().query(StructuredPostal.CONTENT_URI, null, "contact_id = " + str, null, null);
            String str3 = str2;
            while (query.moveToNext()) {
                try {
                    string = query.getString(query.getColumnIndex("data2"));
                    String string2 = query.getString(query.getColumnIndex("data1"));
                    if (!f1419a || !string.matches("1")) {
                        if (f1420b && string.matches("2")) {
                            if (string2 != null) {
                                string = string2;
                                break;
                            }
                        } else if (string2 != null) {
                            try {
                                if (!f1420b && !f1419a && string2 != null) {
                                    string = string2;
                                    break;
                                }
                                str3 = string2;
                            } catch (Exception e) {
                                exception = e;
                                string = string2;
                            }
                        }
                    } else if (string2 != null) {
                        string = string2;
                        break;
                    }
                    if (hc.f1269b) {
                        ls.m1344a("formattedAddress: " + str3);
                        ls.m1344a("type: " + string);
                    }
                } catch (Exception e2) {
                    Exception exception2 = e2;
                    string = str3;
                    exception = exception2;
                }
            }
            string = str3;
            try {
                query.close();
            } catch (Exception e3) {
                exception = e3;
                exception.printStackTrace();
                return string;
            }
        } catch (Exception e22) {
            exception = e22;
            string = str2;
            exception.printStackTrace();
            return string;
        }
        return string;
    }

    public static ArrayList<String> m1150a(Context context, ArrayList<String> arrayList) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        ListIterator listIterator;
        Locale locale;
        String replaceAll;
        String[] split;
        String str;
        Cursor query;
        String trim;
        Object obj7;
        je a;
        int i;
        ArrayList arrayList2;
        Collection h;
        ls.m1346c("contactAlgorithm");
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList<String> arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        if (arrayList.size() > 0) {
            if (((String) arrayList.get(0)).matches("getHome")) {
                arrayList.remove(0);
                ls.m1346c("getHome: true");
                obj = null;
                obj2 = null;
                obj3 = null;
                obj4 = null;
                obj5 = null;
                obj6 = 1;
            } else if (((String) arrayList.get(0)).matches("getWork")) {
                arrayList.remove(0);
                ls.m1346c("getWork: true");
                obj2 = null;
                obj3 = null;
                int i2 = 1;
                obj5 = null;
                obj6 = null;
                obj = null;
            } else if (((String) arrayList.get(0)).matches("getMobile") || ((String) arrayList.get(0)).matches("getSMS")) {
                arrayList.remove(0);
                ls.m1346c("getMobile: true");
                obj2 = null;
                int i3 = 1;
                obj4 = null;
                obj5 = null;
                obj6 = null;
                obj = null;
            } else if (((String) arrayList.get(0)).matches("getSkype")) {
                arrayList.remove(0);
                ls.m1346c("getSkype: true");
                int i4 = 1;
                obj3 = null;
                obj4 = null;
                obj5 = null;
                obj6 = null;
                obj = null;
            } else if (((String) arrayList.get(0)).matches("getEmail")) {
                arrayList.remove(0);
                ls.m1346c("getEmail: true");
                obj2 = null;
                obj3 = null;
                obj4 = null;
                obj5 = null;
                obj6 = null;
                int i5 = 1;
            } else if (((String) arrayList.get(0)).matches("getAll")) {
                arrayList.remove(0);
                ls.m1346c("getAll: true");
                obj2 = null;
                obj3 = null;
                obj4 = null;
                int i6 = 1;
                obj6 = null;
                obj = null;
            } else {
                ls.m1347d("no instruction");
            }
            listIterator = arrayList.listIterator();
            locale = Locale.US;
            while (listIterator.hasNext()) {
                replaceAll = ((String) listIterator.next()).toString().toLowerCase(locale).trim().replaceAll("\\bthe\\b\\s*", "").trim().replaceAll("\\bat\\b\\s*", "").trim().replaceAll("\\bon\\b\\s*", "").trim().replaceAll("\\bhis\\b\\s*", "").trim().replaceAll("\\bher\\b\\s*", "").trim().replaceAll("\\btheir\\b\\s*", "").trim().replaceAll("\\bthere\\b\\s*", "").trim().replaceAll("[^a-zA-Z] ", "").trim().trim().replaceAll(" +", " ");
                if (!arrayList3.contains(replaceAll)) {
                    arrayList3.add(replaceAll);
                    split = replaceAll.split("\\s");
                    if (split.length == 2) {
                        str = split[0];
                        replaceAll = split[1];
                        str = str.replaceAll("[^a-zA-Z]", "");
                        replaceAll = replaceAll.replaceAll("[^a-zA-Z]", "");
                        if (!arrayList4.contains(str)) {
                            arrayList4.add(str);
                        }
                        if (!arrayList5.contains(replaceAll)) {
                            arrayList5.add(replaceAll);
                        }
                    }
                }
            }
            query = context.getContentResolver().query(Contacts.CONTENT_URI, null, null, null, null);
            while (query.moveToNext()) {
                if (Integer.parseInt(query.getString(query.getColumnIndex("has_phone_number"))) > 0) {
                    str = query.getString(query.getColumnIndex("_id"));
                    replaceAll = query.getString(query.getColumnIndex("display_name"));
                    if (!(str == null || replaceAll == null)) {
                        trim = replaceAll.toLowerCase(locale).trim();
                        if (arrayList3.contains(trim)) {
                            arrayList6.add(trim);
                            arrayList6.add(str);
                            obj7 = 1;
                            ls.m1346c("exactMatch: " + trim + " : " + str);
                            break;
                        }
                        split = trim.split("\\s");
                        if (split.length == 2) {
                            String str2;
                            str2 = split[0];
                            replaceAll = split[1];
                            str2 = str2.replaceAll("[^a-zA-Z]", "").trim();
                            replaceAll = replaceAll.replaceAll("[^a-zA-Z]", "").trim();
                            if (!arrayList4.contains(str2) || arrayList5.contains(replaceAll)) {
                                arrayList8.add(str);
                                arrayList7.add(trim);
                            }
                        }
                    }
                }
            }
            obj7 = null;
            query.close();
            ls.m1344a("Built Contact Array: " + (System.currentTimeMillis() - currentTimeMillis));
            ls.m1346c("toContactName: " + arrayList7.size() + " " + arrayList7.toString());
            ls.m1346c("toContactID: " + arrayList8.size() + " " + arrayList8.toString());
            ls.m1346c("In toKeep: " + arrayList3.toString());
            ls.m1346c("In toKeepFN: " + arrayList4.toString());
            ls.m1346c("In toKeepLN: " + arrayList5.toString());
            if (obj7 != null) {
                ls.m1346c("exactMatch: false");
                a = jd.m1200a(arrayList, arrayList7, arrayList8, 0.5d);
                if (a.f1523a) {
                    ls.m1346c("myScoreProcess.exactMatch: false");
                    if (a.f1524b) {
                        ls.m1347d("myScoreProcess.testMaxResult: false");
                        arrayList6.clear();
                        arrayList6.add("ERROR");
                        arrayList6.add("Sorry, but I couldn't find a match for that contact.");
                        obj7 = null;
                    } else {
                        ls.m1346c("myScoreProcess.testMaxResult: true");
                        arrayList6.add((String) a.f1529g.get(1));
                        arrayList6.add((String) a.f1529g.get(2));
                        i = 1;
                    }
                } else {
                    ls.m1346c("myScoreProcess.exactMatch: true");
                    if (((String) a.f1528f.get(0)).matches("ALGORITHM")) {
                        ls.m1346c("myScoreProcess.exactMatch : true");
                        arrayList6.add((String) a.f1528f.get(0));
                        arrayList6.add((String) a.f1528f.get(1));
                        i = 1;
                    } else {
                        ls.m1346c("myScoreProcess.exactMatch ALGORITHM: true");
                        arrayList6.add((String) a.f1528f.get(1));
                        arrayList6.add((String) a.f1528f.get(2));
                        obj7 = 1;
                    }
                }
            } else {
                i = 1;
            }
            if (obj7 != null) {
                ls.m1346c("gotContact: true");
                if (obj6 != null) {
                    replaceAll = m1156g(context, (String) arrayList6.get(1));
                    if (replaceAll != null || replaceAll.matches("")) {
                        replaceAll = (String) arrayList6.get(0);
                        arrayList6.clear();
                        arrayList6.add("ERROR");
                        arrayList6.add("Sorry, but there was no home number listed for " + replaceAll);
                    } else {
                        arrayList6.add(replaceAll);
                    }
                } else if (obj4 != null) {
                    replaceAll = m1155f(context, (String) arrayList6.get(1));
                    if (replaceAll != null || replaceAll.matches("")) {
                        replaceAll = (String) arrayList6.get(0);
                        arrayList6.clear();
                        arrayList6.add("ERROR");
                        arrayList6.add("Sorry, but there was no work number listed for " + replaceAll);
                    } else {
                        arrayList6.add(replaceAll);
                    }
                } else if (obj3 != null) {
                    arrayList2 = new ArrayList();
                    h = m1157h(context, (String) arrayList6.get(1));
                    if (h.isEmpty()) {
                        arrayList6.addAll(h);
                    } else {
                        replaceAll = (String) arrayList6.get(0);
                        arrayList6.clear();
                        arrayList6.add("ERROR");
                        arrayList6.add("Sorry, but there was no mobile number listed for " + replaceAll);
                    }
                } else if (obj2 != null) {
                    replaceAll = m1154e(context, (String) arrayList6.get(1));
                    if (replaceAll != null || replaceAll.matches("")) {
                        replaceAll = (String) arrayList6.get(0);
                        arrayList6.clear();
                        arrayList6.add("ERROR");
                        arrayList6.add("Sorry, but there was no Skype I D listed for " + replaceAll);
                    } else {
                        arrayList6.add(replaceAll);
                    }
                } else if (obj != null) {
                    arrayList2 = new ArrayList();
                    h = m1153d(context, (String) arrayList6.get(1));
                    if (h.isEmpty()) {
                        arrayList6.addAll(h);
                    } else {
                        replaceAll = (String) arrayList6.get(0);
                        arrayList6.clear();
                        arrayList6.add("ERROR");
                        arrayList6.add("Sorry, but there was no email address listed for " + replaceAll);
                    }
                } else if (obj5 != null) {
                    arrayList2 = new ArrayList();
                    arrayList2 = m1157h(context, (String) arrayList6.get(1));
                    if (!arrayList2.isEmpty()) {
                        arrayList6.add("mobile");
                        GlobalV.m859k((String) arrayList2.get(0));
                    }
                    replaceAll = m1155f(context, (String) arrayList6.get(1));
                    if (!(replaceAll == null || replaceAll.matches(""))) {
                        ls.m1344a("myWork: " + replaceAll);
                        arrayList6.add("work");
                        GlobalV.m855j(replaceAll);
                    }
                    replaceAll = m1156g(context, (String) arrayList6.get(1));
                    if (!(replaceAll == null || replaceAll.matches(""))) {
                        ls.m1344a("myHome: " + replaceAll);
                        arrayList6.add("home");
                        GlobalV.m851i(replaceAll);
                    }
                }
            }
            ls.m1344a("EstablishContact elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
            return arrayList6;
        }
        obj2 = null;
        obj3 = null;
        obj4 = null;
        obj5 = null;
        obj6 = null;
        obj = null;
        listIterator = arrayList.listIterator();
        locale = Locale.US;
        while (listIterator.hasNext()) {
            replaceAll = ((String) listIterator.next()).toString().toLowerCase(locale).trim().replaceAll("\\bthe\\b\\s*", "").trim().replaceAll("\\bat\\b\\s*", "").trim().replaceAll("\\bon\\b\\s*", "").trim().replaceAll("\\bhis\\b\\s*", "").trim().replaceAll("\\bher\\b\\s*", "").trim().replaceAll("\\btheir\\b\\s*", "").trim().replaceAll("\\bthere\\b\\s*", "").trim().replaceAll("[^a-zA-Z] ", "").trim().trim().replaceAll(" +", " ");
            if (!arrayList3.contains(replaceAll)) {
                arrayList3.add(replaceAll);
                split = replaceAll.split("\\s");
                if (split.length == 2) {
                    str = split[0];
                    replaceAll = split[1];
                    str = str.replaceAll("[^a-zA-Z]", "");
                    replaceAll = replaceAll.replaceAll("[^a-zA-Z]", "");
                    if (arrayList4.contains(str)) {
                        arrayList4.add(str);
                    }
                    if (!arrayList5.contains(replaceAll)) {
                        arrayList5.add(replaceAll);
                    }
                }
            }
        }
        query = context.getContentResolver().query(Contacts.CONTENT_URI, null, null, null, null);
        while (query.moveToNext()) {
            if (Integer.parseInt(query.getString(query.getColumnIndex("has_phone_number"))) > 0) {
                str = query.getString(query.getColumnIndex("_id"));
                replaceAll = query.getString(query.getColumnIndex("display_name"));
                trim = replaceAll.toLowerCase(locale).trim();
                if (arrayList3.contains(trim)) {
                    arrayList6.add(trim);
                    arrayList6.add(str);
                    obj7 = 1;
                    ls.m1346c("exactMatch: " + trim + " : " + str);
                    break;
                }
                split = trim.split("\\s");
                if (split.length == 2) {
                    str2 = split[0];
                    replaceAll = split[1];
                    str2 = str2.replaceAll("[^a-zA-Z]", "").trim();
                    replaceAll = replaceAll.replaceAll("[^a-zA-Z]", "").trim();
                    if (arrayList4.contains(str2)) {
                    }
                    arrayList8.add(str);
                    arrayList7.add(trim);
                }
            }
        }
        obj7 = null;
        query.close();
        ls.m1344a("Built Contact Array: " + (System.currentTimeMillis() - currentTimeMillis));
        ls.m1346c("toContactName: " + arrayList7.size() + " " + arrayList7.toString());
        ls.m1346c("toContactID: " + arrayList8.size() + " " + arrayList8.toString());
        ls.m1346c("In toKeep: " + arrayList3.toString());
        ls.m1346c("In toKeepFN: " + arrayList4.toString());
        ls.m1346c("In toKeepLN: " + arrayList5.toString());
        if (obj7 != null) {
            i = 1;
        } else {
            ls.m1346c("exactMatch: false");
            a = jd.m1200a(arrayList, arrayList7, arrayList8, 0.5d);
            if (a.f1523a) {
                ls.m1346c("myScoreProcess.exactMatch: false");
                if (a.f1524b) {
                    ls.m1347d("myScoreProcess.testMaxResult: false");
                    arrayList6.clear();
                    arrayList6.add("ERROR");
                    arrayList6.add("Sorry, but I couldn't find a match for that contact.");
                    obj7 = null;
                } else {
                    ls.m1346c("myScoreProcess.testMaxResult: true");
                    arrayList6.add((String) a.f1529g.get(1));
                    arrayList6.add((String) a.f1529g.get(2));
                    i = 1;
                }
            } else {
                ls.m1346c("myScoreProcess.exactMatch: true");
                if (((String) a.f1528f.get(0)).matches("ALGORITHM")) {
                    ls.m1346c("myScoreProcess.exactMatch : true");
                    arrayList6.add((String) a.f1528f.get(0));
                    arrayList6.add((String) a.f1528f.get(1));
                    i = 1;
                } else {
                    ls.m1346c("myScoreProcess.exactMatch ALGORITHM: true");
                    arrayList6.add((String) a.f1528f.get(1));
                    arrayList6.add((String) a.f1528f.get(2));
                    obj7 = 1;
                }
            }
        }
        if (obj7 != null) {
            ls.m1346c("gotContact: true");
            if (obj6 != null) {
                replaceAll = m1156g(context, (String) arrayList6.get(1));
                if (replaceAll != null) {
                }
                replaceAll = (String) arrayList6.get(0);
                arrayList6.clear();
                arrayList6.add("ERROR");
                arrayList6.add("Sorry, but there was no home number listed for " + replaceAll);
            } else if (obj4 != null) {
                replaceAll = m1155f(context, (String) arrayList6.get(1));
                if (replaceAll != null) {
                }
                replaceAll = (String) arrayList6.get(0);
                arrayList6.clear();
                arrayList6.add("ERROR");
                arrayList6.add("Sorry, but there was no work number listed for " + replaceAll);
            } else if (obj3 != null) {
                arrayList2 = new ArrayList();
                h = m1157h(context, (String) arrayList6.get(1));
                if (h.isEmpty()) {
                    replaceAll = (String) arrayList6.get(0);
                    arrayList6.clear();
                    arrayList6.add("ERROR");
                    arrayList6.add("Sorry, but there was no mobile number listed for " + replaceAll);
                } else {
                    arrayList6.addAll(h);
                }
            } else if (obj2 != null) {
                replaceAll = m1154e(context, (String) arrayList6.get(1));
                if (replaceAll != null) {
                }
                replaceAll = (String) arrayList6.get(0);
                arrayList6.clear();
                arrayList6.add("ERROR");
                arrayList6.add("Sorry, but there was no Skype I D listed for " + replaceAll);
            } else if (obj != null) {
                arrayList2 = new ArrayList();
                h = m1153d(context, (String) arrayList6.get(1));
                if (h.isEmpty()) {
                    replaceAll = (String) arrayList6.get(0);
                    arrayList6.clear();
                    arrayList6.add("ERROR");
                    arrayList6.add("Sorry, but there was no email address listed for " + replaceAll);
                } else {
                    arrayList6.addAll(h);
                }
            } else if (obj5 != null) {
                arrayList2 = new ArrayList();
                arrayList2 = m1157h(context, (String) arrayList6.get(1));
                if (arrayList2.isEmpty()) {
                    arrayList6.add("mobile");
                    GlobalV.m859k((String) arrayList2.get(0));
                }
                replaceAll = m1155f(context, (String) arrayList6.get(1));
                ls.m1344a("myWork: " + replaceAll);
                arrayList6.add("work");
                GlobalV.m855j(replaceAll);
                replaceAll = m1156g(context, (String) arrayList6.get(1));
                ls.m1344a("myHome: " + replaceAll);
                arrayList6.add("home");
                GlobalV.m851i(replaceAll);
            }
        }
        ls.m1344a("EstablishContact elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList6;
    }

    public static ArrayList<String> m1151b(Context context, String str) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + str, null, null);
        while (query.moveToNext()) {
            String string = query.getString(query.getColumnIndex("data1"));
            if (!(string == null || string.isEmpty() || string.contains("@"))) {
                arrayList.add(string);
            }
        }
        try {
            query.close();
        } catch (Exception e) {
        }
        ls.m1344a("toReturn: " + arrayList.size() + " " + arrayList.toString());
        return arrayList;
    }

    public static String m1152c(Context context, String str) {
        String string;
        ls.m1346c("in getNameFromNumber");
        String str2 = "error";
        String[] strArr = new String[]{"display_name", "_id"};
        Uri withAppendedPath = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str));
        if (withAppendedPath != null) {
            Cursor query = context.getContentResolver().query(withAppendedPath, strArr, null, null, null);
            string = (query == null || !query.moveToFirst()) ? str2 : query.getString(query.getColumnIndex("display_name"));
            try {
                query.close();
            } catch (Exception e) {
                ls.m1348e("getNameFromNumber cursor close");
            }
        } else {
            string = str2;
        }
        if (string == null || string.isEmpty()) {
            ls.m1347d("returning error");
            return "error";
        }
        ls.m1344a("name: " + string);
        return string;
    }

    private static ArrayList<String> m1153d(Context context, String str) {
        ls.m1346c("getEmailAddress");
        String str2 = "";
        ArrayList<String> arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(Data.CONTENT_URI, null, "contact_id = " + str, null, null);
        Object obj = null;
        Object obj2 = str2;
        while (query.moveToNext()) {
            try {
                String string = query.getString(query.getColumnIndex("data1"));
                int i = query.getInt(query.getColumnIndex("data2"));
                String string2 = query.getString(query.getColumnIndex("is_primary"));
                if (!(string == null || string2 == null || !string.contains("@"))) {
                    switch (i) {
                        case 1:
                            ls.m1344a("TYPE_HOME: " + string);
                            if (!string2.matches("1")) {
                                if (!arrayList.contains(string)) {
                                    arrayList.add(string);
                                    break;
                                }
                                break;
                            }
                            obj = 1;
                            obj2 = string;
                            break;
                        case 2:
                            ls.m1344a("TYPE_WORK: " + string);
                            if (!string2.matches("1")) {
                                if (!arrayList.contains(string)) {
                                    arrayList.add(string);
                                    break;
                                }
                                break;
                            }
                            obj = 1;
                            obj2 = string;
                            break;
                        case 3:
                            ls.m1344a("TYPE_OTHER: " + string);
                            if (!string2.matches("1")) {
                                if (!arrayList.contains(string)) {
                                    arrayList.add(string);
                                    break;
                                }
                                break;
                            }
                            obj = 1;
                            obj2 = string;
                            break;
                        default:
                            ls.m1344a("default: " + string);
                            if (!string2.matches("1")) {
                                if (!arrayList.contains(string)) {
                                    arrayList.add(string);
                                    break;
                                }
                                break;
                            }
                            obj = 1;
                            obj2 = string;
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        query.close();
        if (obj != null) {
            arrayList.add(0, obj2);
        }
        ls.m1344a("toEmails: " + arrayList.size() + " : " + arrayList.toString());
        return arrayList;
    }

    private static String m1154e(Context context, String str) {
        String str2;
        ls.m1346c("getContactNumber");
        String str3 = "null";
        try {
            Cursor query = context.getContentResolver().query(Data.CONTENT_URI, null, "contact_id = " + str, null, null);
            str2 = str3;
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(query.getColumnIndex("data5"));
                    str3 = query.getString(query.getColumnIndex("data1"));
                    switch (i) {
                        case 3:
                            ls.m1344a("contactID: " + str + " type: " + i + " imName: " + str3);
                            str2 = str3;
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    e = e;
                }
            }
            query.close();
        } catch (Exception e2) {
            Exception e3;
            e3 = e2;
            str2 = str3;
            e3.printStackTrace();
            return str2;
        }
        return str2;
    }

    private static String m1155f(Context context, String str) {
        ls.m1346c("getWorkNumber");
        Cursor query = context.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + str, null, null);
        String str2 = "";
        while (query.moveToNext()) {
            str2 = query.getString(query.getColumnIndex("data1"));
            int i = query.getInt(query.getColumnIndex("data2"));
            if (str2 == null || str2.matches("") || str2.contains("@")) {
                str2 = "";
            } else {
                switch (i) {
                    case 3:
                        ls.m1344a("TYPE_WORK: " + str2);
                        break;
                    default:
                        str2 = "";
                        continue;
                }
                query.close();
                return str2;
            }
        }
        query.close();
        return str2;
    }

    private static String m1156g(Context context, String str) {
        ls.m1346c("getHomeNumber");
        Cursor query = context.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + str, null, null);
        String str2 = "";
        while (query.moveToNext()) {
            str2 = query.getString(query.getColumnIndex("data1"));
            int i = query.getInt(query.getColumnIndex("data2"));
            if (str2 == null || str2.matches("") || str2.contains("@")) {
                str2 = "";
            } else {
                switch (i) {
                    case 1:
                        ls.m1344a("TYPE_HOME: " + str2);
                        break;
                    default:
                        str2 = "";
                        continue;
                }
                query.close();
                return str2;
            }
        }
        query.close();
        return str2;
    }

    private static ArrayList<String> m1157h(Context context, String str) {
        ls.m1346c("getMobileNumber");
        ArrayList<String> arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + str, null, null);
        int i = 0;
        Object obj = "";
        while (query.moveToNext()) {
            String string = query.getString(query.getColumnIndex("data1"));
            int i2 = query.getInt(query.getColumnIndex("data2"));
            String string2 = query.getString(query.getColumnIndex("is_primary"));
            if (!(string == null || string2 == null || string.matches(""))) {
                switch (i2) {
                    case 2:
                        ls.m1344a("TYPE_MOBILE: " + string + " : " + string2);
                        if (!string2.matches("1")) {
                            if (!(arrayList.contains(string) || string.matches(""))) {
                                arrayList.add(string);
                                break;
                            }
                        }
                        i = 1;
                        obj = string;
                        break;
                    default:
                        break;
                }
            }
        }
        query.close();
        if (i != 0) {
            arrayList.add(0, obj);
        }
        return arrayList;
    }
}
