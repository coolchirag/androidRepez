package com.brandall.nutter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public final class jb {
    static ArrayList<String> f1518a = new ArrayList();
    static ArrayList<String> f1519b = new ArrayList();
    static ArrayList<String> f1520c = new ArrayList();
    private static String f1521d = "";
    private static boolean f1522e = false;

    public static String m1196a(Context context, ArrayList<String> arrayList) {
        if (hc.f1269b) {
            ls.m1346c("taskerAlgorithm");
        }
        ArrayList a = m1198a(context);
        f1519b = a;
        if (!a.isEmpty() && !arrayList.isEmpty()) {
            ListIterator listIterator = arrayList.listIterator();
            Arrays.asList(arrayList.toArray());
            while (listIterator.hasNext()) {
                String trim = listIterator.next().toString().toLowerCase().trim();
                if (hc.f1269b) {
                    ls.m1344a("rawpass: " + trim);
                }
                if (f1519b.contains(trim)) {
                    f1522e = true;
                    f1521d = (String) f1518a.get(f1519b.indexOf(trim));
                    if (hc.f1269b) {
                        ls.m1344a("taskMatch: " + f1521d);
                    }
                }
            }
        } else if (hc.f1269b) {
            ls.m1347d("Empty tasksRWS: " + f1519b.size() + " : " + f1519b.toString());
        }
        if (!f1522e) {
            if (hc.f1269b) {
                ls.m1346c("exactMatch: " + f1522e);
            }
            f1521d = m1197a((ArrayList) arrayList);
        }
        return f1521d;
    }

    private static String m1197a(ArrayList<String> arrayList) {
        if (hc.f1269b) {
            ls.m1346c("taskAlgorithm");
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ListIterator listIterator = f1520c.listIterator();
        Arrays.asList(f1520c.toArray());
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            String trim = listIterator.next().toString().toLowerCase().trim();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                double a = new le().mo94a(trim, (String) it.next());
                Object max;
                ListIterator listIterator2;
                int nextIndex2;
                String str;
                if (a > 0.9d) {
                    if (hc.f1269b) {
                        ls.m1344a("test2: " + a);
                    }
                    f1522e = true;
                    f1521d = (String) f1518a.get(nextIndex);
                    if (!f1522e) {
                        if (hc.f1269b) {
                            ls.m1346c("toKeep: " + arrayList2.size() + " " + arrayList2.toString());
                        }
                        if (hc.f1269b) {
                            ls.m1346c("toKeepTT2: " + arrayList3.size() + " " + arrayList3.toString());
                        }
                        if (!arrayList3.isEmpty()) {
                            max = Collections.max(arrayList3);
                            listIterator2 = arrayList3.listIterator();
                            Arrays.asList(arrayList3.toArray());
                            while (listIterator2.hasNext()) {
                                nextIndex2 = listIterator2.nextIndex();
                                if (listIterator2.next().equals(max)) {
                                    str = (String) arrayList2.get(nextIndex2);
                                    if (hc.f1269b) {
                                        ls.m1346c("Highest TT2: " + max + " Name: " + str);
                                    }
                                    f1521d = str;
                                }
                            }
                        } else if (hc.f1269b) {
                            ls.m1347d("toKeepTT2 empty!?");
                        }
                    } else if (hc.f1269b) {
                        ls.m1346c("exactMatch: " + f1522e);
                    }
                    return f1521d;
                }
                String valueOf = String.valueOf(a);
                if (a > 0.35d) {
                    arrayList2.add((String) f1518a.get(nextIndex));
                    arrayList3.add(valueOf);
                }
            }
        }
        if (!f1522e) {
            if (hc.f1269b) {
                ls.m1346c("toKeep: " + arrayList2.size() + " " + arrayList2.toString());
            }
            if (hc.f1269b) {
                ls.m1346c("toKeepTT2: " + arrayList3.size() + " " + arrayList3.toString());
            }
            if (!arrayList3.isEmpty()) {
                max = Collections.max(arrayList3);
                listIterator2 = arrayList3.listIterator();
                Arrays.asList(arrayList3.toArray());
                while (listIterator2.hasNext()) {
                    nextIndex2 = listIterator2.nextIndex();
                    if (listIterator2.next().equals(max)) {
                        str = (String) arrayList2.get(nextIndex2);
                        if (hc.f1269b) {
                            ls.m1346c("Highest TT2: " + max + " Name: " + str);
                        }
                        f1521d = str;
                    }
                }
            } else if (hc.f1269b) {
                ls.m1347d("toKeepTT2 empty!?");
            }
        } else if (hc.f1269b) {
            ls.m1346c("exactMatch: " + f1522e);
        }
        return f1521d;
    }

    private static ArrayList<String> m1198a(Context context) {
        Cursor query;
        if (hc.f1269b) {
            ls.m1346c("getTaskerTasks");
        }
        try {
            query = context.getContentResolver().query(Uri.parse("content://net.dinglisch.android.tasker/tasks"), null, null, null, null);
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("arrayTask: Exception on cursor: " + e.getLocalizedMessage());
            }
            query = null;
        }
        if (query != null) {
            if (hc.f1269b) {
                ls.m1346c("C != null");
            }
            if (query.moveToFirst()) {
                if (hc.f1269b) {
                    ls.m1346c("c moving to first");
                }
                String[] strArr = new String[query.getCount()];
                for (int i = 0; i < query.getCount(); i++) {
                    strArr[i] = query.getString(query.getColumnIndex("name"));
                    f1518a.add(strArr[i]);
                    strArr[i] = strArr[i].toLowerCase().replaceAll(" ", "").trim();
                    if (hc.f1269b) {
                        ls.m1344a("RESULTS: " + strArr[i].toString());
                    }
                    f1520c.add(strArr[i]);
                    query.moveToNext();
                }
                query.close();
                if (hc.f1269b) {
                    ls.m1344a("taskerTasksRWS: " + f1520c.size() + " : " + f1520c.toString());
                }
                if (hc.f1269b) {
                    ls.m1344a("taskerTasks: " + f1518a.size() + " : " + f1518a.toString());
                }
            } else {
                if (hc.f1269b) {
                    ls.m1347d("c didn't move to first - Checking Tasker task directory");
                }
                File file = new File(Environment.getExternalStorageDirectory() + "/Tasker/tasks");
                if (file.exists() && file.isDirectory()) {
                    if (hc.f1269b) {
                        ls.m1346c("Tasker dir exists");
                    }
                    if (file.list() != null) {
                        if (hc.f1269b) {
                            ls.m1347d("Tasks detected but can't be displayed - not imported??");
                        }
                    } else if (hc.f1269b) {
                        ls.m1347d("User has no tasks");
                    }
                } else if (hc.f1269b) {
                    ls.m1347d("Tasker directory is missing");
                }
            }
        } else if (hc.f1269b) {
            ls.m1348e("null cursor");
        }
        return f1520c;
    }
}
