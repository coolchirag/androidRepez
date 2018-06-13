package com.brandall.nutter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;

public final class he extends SQLiteOpenHelper {
    private static final String[] f1273a = new String[]{"_id", "keyword", "command_int", "success_words", "fail_words", "string_1", "string_2", "string_3", "string_4", "int_1", "int_2", "int_3", "int_4"};
    private SQLiteDatabase f1274b;

    public he(Context context) {
        super(context, "userCommands.db", null, 2);
    }

    private lb m1063a(Cursor cursor) {
        ls.m1346c("DBUC cursorToGUC");
        lb lbVar = new lb();
        try {
            m1064h();
            lbVar.f1653a = cursor.getLong(0);
            lbVar.f1654b = cursor.getString(1);
            lbVar.f1655c = cursor.getInt(2);
            lbVar.f1665m = cursor.getString(3);
            lbVar.f1664l = cursor.getString(4);
            lbVar.f1656d = cursor.getString(5);
            lbVar.f1658f = cursor.getString(6);
            lbVar.f1660h = cursor.getString(7);
            lbVar.f1662j = cursor.getString(8);
            lbVar.f1657e = cursor.getInt(9);
            lbVar.f1659g = cursor.getInt(10);
            lbVar.f1661i = cursor.getInt(11);
            lbVar.f1663k = cursor.getInt(12);
            this.f1274b.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lbVar;
    }

    private void m1064h() {
        this.f1274b = getWritableDatabase();
    }

    public final lb m1065a(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7) {
        lb a;
        Exception e;
        ls.m1346c("DBUC insertPopulatedRow");
        lb lbVar = new lb();
        try {
            m1064h();
            ContentValues contentValues = new ContentValues();
            contentValues.put("keyword", str);
            contentValues.put("command_int", Integer.valueOf(i));
            contentValues.put("success_words", str2);
            contentValues.put("fail_words", str3);
            contentValues.put("string_1", str4);
            contentValues.put("string_2", str5);
            contentValues.put("string_3", str6);
            contentValues.put("string_4", str7);
            contentValues.put("int_1", Integer.valueOf(0));
            contentValues.put("int_2", Integer.valueOf(0));
            contentValues.put("int_3", Integer.valueOf(0));
            contentValues.put("int_4", Integer.valueOf(0));
            Cursor query = this.f1274b.query("user_commands", f1273a, "_id = " + this.f1274b.insert("user_commands", null, contentValues), null, null, null, null);
            query.moveToFirst();
            a = m1063a(query);
            try {
                query.close();
                close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return a;
            }
        } catch (Exception e3) {
            e = e3;
            a = lbVar;
            e.printStackTrace();
            return a;
        }
        return a;
    }

    public final ArrayList<String> m1066a() {
        ls.m1346c("DBUC getUserCommandPhrases");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"keyword"}, null, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                ls.m1346c("cursor.getString(0): " + query.getString(0));
                arrayList.add(query.getString(0));
                query.moveToNext();
            }
            query.close();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final void m1067a(long j) {
        ls.m1346c("DBUC deleteRow");
        try {
            m1064h();
            this.f1274b.delete("user_commands", "_id=?", new String[]{String.valueOf(j)});
            this.f1274b.execSQL("VACUUM");
            this.f1274b.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean m1068a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4) {
        ls.m1346c("DBUC insertPhraseData");
        String str = "command_int=777";
        try {
            m1064h();
            this.f1274b.delete("user_commands", str, null);
            this.f1274b.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            m1064h();
            int size = arrayList.size();
            this.f1274b.beginTransaction();
            SQLiteStatement compileStatement = this.f1274b.compileStatement("insert into user_commands (keyword, command_int, success_words, fail_words, string_1, string_2, string_3, string_4, int_1, int_2, int_3, int_4) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for (int i = 0; i < size; i++) {
                compileStatement.bindString(1, (String) arrayList.get(i));
                compileStatement.bindString(2, "777");
                compileStatement.bindString(3, (String) arrayList2.get(i));
                compileStatement.bindString(4, "NULL");
                compileStatement.bindString(5, (String) arrayList4.get(i));
                compileStatement.bindString(6, "NULL");
                compileStatement.bindString(7, "NULL");
                compileStatement.bindString(8, (String) arrayList3.get(i));
                compileStatement.bindString(9, "NULL");
                compileStatement.bindString(10, "NULL");
                compileStatement.bindString(11, "NULL");
                compileStatement.bindString(12, "NULL");
                compileStatement.executeInsert();
            }
            this.f1274b.setTransactionSuccessful();
            this.f1274b.endTransaction();
            this.f1274b.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final String m1069b(long j) {
        String str;
        Exception exception;
        ls.m1346c("DBUC getUserCommandPhrase");
        String str2 = "";
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"keyword"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            str = str2;
            while (!query.isAfterLast()) {
                try {
                    String string = query.getString(0);
                    try {
                        query.moveToNext();
                        str = string;
                    } catch (Exception e) {
                        Exception exception2 = e;
                        str = string;
                        exception = exception2;
                    }
                } catch (Exception e2) {
                    exception = e2;
                }
            }
            query.close();
            ls.m1344a("commandPhrase: " + str);
            close();
        } catch (Exception e3) {
            exception = e3;
            str = str2;
            exception.printStackTrace();
            return str;
        }
        return str;
    }

    public final ArrayList<String> m1070b() {
        ls.m1346c("DBUC getUserAllCustomPhrasesOnly");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"keyword", "command_int"}, "command_int=777", null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                ls.m1346c("cursor.getString(0): " + query.getString(0));
                arrayList.add(query.getString(0));
                query.moveToNext();
            }
            query.close();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final String m1071c(long j) {
        String str;
        Exception exception;
        ls.m1346c("DBUC getString1");
        String str2 = "";
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"string_1"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            str = str2;
            while (!query.isAfterLast()) {
                try {
                    String string = query.getString(0);
                    try {
                        query.moveToNext();
                        str = string;
                    } catch (Exception e) {
                        Exception exception2 = e;
                        str = string;
                        exception = exception2;
                    }
                } catch (Exception e2) {
                    exception = e2;
                }
            }
            query.close();
            ls.m1344a("string1: " + str);
            close();
        } catch (Exception e3) {
            exception = e3;
            str = str2;
            exception.printStackTrace();
            return str;
        }
        return str;
    }

    public final ArrayList<String> m1072c() {
        ls.m1346c("DBUC getUserSuccessWordsCustomPhrasesOnly");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"success_words", "command_int"}, "command_int=777", null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                ls.m1346c("cursor.getString(0): " + query.getString(0));
                arrayList.add(query.getString(0));
                query.moveToNext();
            }
            query.close();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final void close() {
        this.f1274b.close();
    }

    public final String m1073d(long j) {
        String str;
        Exception exception;
        ls.m1346c("DBUC getString2");
        String str2 = "";
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"string_2"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            str = str2;
            while (!query.isAfterLast()) {
                try {
                    String string = query.getString(0);
                    try {
                        query.moveToNext();
                        str = string;
                    } catch (Exception e) {
                        Exception exception2 = e;
                        str = string;
                        exception = exception2;
                    }
                } catch (Exception e2) {
                    exception = e2;
                }
            }
            query.close();
            ls.m1344a("string2: " + str);
            close();
        } catch (Exception e3) {
            exception = e3;
            str = str2;
            exception.printStackTrace();
            return str;
        }
        return str;
    }

    public final ArrayList<String> m1074d() {
        ls.m1346c("DBUC getString1CustomPhrasesOnly");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"string_1", "command_int"}, "command_int=777", null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                ls.m1346c("cursor.getString(0): " + query.getString(0));
                arrayList.add(query.getString(0));
                query.moveToNext();
            }
            query.close();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final String m1075e(long j) {
        String str;
        Exception exception;
        ls.m1346c("DBUC getString3");
        String str2 = "";
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"string_3"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            str = str2;
            while (!query.isAfterLast()) {
                try {
                    String string = query.getString(0);
                    try {
                        query.moveToNext();
                        str = string;
                    } catch (Exception e) {
                        Exception exception2 = e;
                        str = string;
                        exception = exception2;
                    }
                } catch (Exception e2) {
                    exception = e2;
                }
            }
            query.close();
            ls.m1344a("string3: " + str);
            close();
        } catch (Exception e3) {
            exception = e3;
            str = str2;
            exception.printStackTrace();
            return str;
        }
        return str;
    }

    public final ArrayList<String> m1076e() {
        ls.m1346c("DBUC getString4CustomPhrasesOnly");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"string_4", "command_int"}, "command_int=777", null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                ls.m1346c("cursor.getString(0): " + query.getString(0));
                arrayList.add(query.getString(0));
                query.moveToNext();
            }
            query.close();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final String m1077f(long j) {
        String str;
        Exception exception;
        ls.m1346c("DBUC getString4");
        String str2 = "";
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"string_4"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            str = str2;
            while (!query.isAfterLast()) {
                try {
                    String string = query.getString(0);
                    try {
                        query.moveToNext();
                        str = string;
                    } catch (Exception e) {
                        Exception exception2 = e;
                        str = string;
                        exception = exception2;
                    }
                } catch (Exception e2) {
                    exception = e2;
                }
            }
            query.close();
            ls.m1344a("string4: " + str);
            close();
        } catch (Exception e3) {
            exception = e3;
            str = str2;
            exception.printStackTrace();
            return str;
        }
        return str;
    }

    public final ArrayList<Integer> m1078f() {
        ls.m1346c("DBUC getColumID");
        ArrayList<Integer> arrayList = new ArrayList();
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"_id"}, null, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                ls.m1346c("cursor.getString(0): " + query.getString(0));
                arrayList.add(Integer.valueOf(query.getInt(0)));
                query.moveToNext();
            }
            query.close();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final String m1079g(long j) {
        String str;
        Exception exception;
        ls.m1346c("DBUC getSuccessWords");
        String str2 = "";
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"success_words"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            str = str2;
            while (!query.isAfterLast()) {
                try {
                    String string = query.getString(0);
                    try {
                        query.moveToNext();
                        str = string;
                    } catch (Exception e) {
                        Exception exception2 = e;
                        str = string;
                        exception = exception2;
                    }
                } catch (Exception e2) {
                    exception = e2;
                }
            }
            query.close();
            ls.m1344a("successWords: " + str);
            close();
        } catch (Exception e3) {
            exception = e3;
            str = str2;
            exception.printStackTrace();
            return str;
        }
        return str;
    }

    public final ArrayList<Integer> m1080g() {
        ls.m1346c("DBUC getAllCommandInt");
        ArrayList<Integer> arrayList = new ArrayList();
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"command_int"}, null, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                ls.m1346c("cursor.getString(0): " + query.getString(0));
                arrayList.add(Integer.valueOf(query.getInt(0)));
                query.moveToNext();
            }
            query.close();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final String m1081h(long j) {
        String str;
        Exception exception;
        ls.m1346c("DBUC getFailWords");
        String str2 = "";
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"fail_words"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            str = str2;
            while (!query.isAfterLast()) {
                try {
                    String string = query.getString(0);
                    try {
                        query.moveToNext();
                        str = string;
                    } catch (Exception e) {
                        Exception exception2 = e;
                        str = string;
                        exception = exception2;
                    }
                } catch (Exception e2) {
                    exception = e2;
                }
            }
            query.close();
            ls.m1344a("failWords: " + str);
            close();
        } catch (Exception e3) {
            exception = e3;
            str = str2;
            exception.printStackTrace();
            return str;
        }
        return str;
    }

    public final int m1082i(long j) {
        int i;
        Exception exception;
        ls.m1346c("DBUC getCommandInt");
        try {
            m1064h();
            Cursor query = this.f1274b.query("user_commands", new String[]{"command_int"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            i = 0;
            while (!query.isAfterLast()) {
                try {
                    int i2 = query.getInt(0);
                    try {
                        query.moveToNext();
                        i = i2;
                    } catch (Exception e) {
                        Exception exception2 = e;
                        i = i2;
                        exception = exception2;
                    }
                } catch (Exception e2) {
                    exception = e2;
                }
            }
            query.close();
            ls.m1344a("DBUC getCommandInt commandInt: " + i);
            close();
        } catch (Exception e3) {
            exception = e3;
            i = 0;
            exception.printStackTrace();
            return i;
        }
        return i;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ls.m1346c("DBUC onCreate");
        sQLiteDatabase.execSQL("create table user_commands(_id integer primary key autoincrement, keyword text not null, command_int integer not null, success_words text not null, fail_words text not null, string_1 text not null, string_2 text not null, string_3 text not null, string_4 text not null, int_1 integer not null, int_2 integer not null, int_3 integer not null, int_4 integer not null);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ls.m1346c("DBUC onUpgrage");
        ls.m1347d("Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_commands");
        onCreate(sQLiteDatabase);
    }
}
