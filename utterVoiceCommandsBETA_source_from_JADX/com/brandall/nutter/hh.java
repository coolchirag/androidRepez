package com.brandall.nutter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public final class hh extends SQLiteOpenHelper {
    private static final String[] f1277a = new String[]{"_id", "nick_name", "contact_name", "contact_id"};
    private SQLiteDatabase f1278b;

    public hh(Context context) {
        super(context, "userNicknames.db", null, 1);
    }

    private void m1091d() {
        this.f1278b = getWritableDatabase();
    }

    public final ArrayList<String> m1092a() {
        ls.m1346c("DBUN getAllNickNames");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1091d();
            Cursor query = this.f1278b.query("user_nicknames", new String[]{"nick_name"}, null, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                arrayList.add(query.getString(0));
                query.moveToNext();
            }
            query.close();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final void m1093a(long j) {
        ls.m1346c("DBUN deleteRow");
        try {
            m1091d();
            this.f1278b.delete("user_nicknames", "_id=?", new String[]{String.valueOf(j)});
            this.f1278b.execSQL("VACUUM");
            this.f1278b.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final void m1094a(String str, String str2, String str3) {
        ls.m1346c("DBUN insertRow");
        try {
            m1091d();
            ContentValues contentValues = new ContentValues();
            contentValues.put("nick_name", str);
            contentValues.put("contact_name", str2);
            contentValues.put("contact_id", str3);
            Cursor query = this.f1278b.query("user_nicknames", f1277a, "_id = " + this.f1278b.insert("user_nicknames", null, contentValues), null, null, null, null);
            query.moveToFirst();
            query.close();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final void m1095a(String str, String str2, String str3, int i) {
        ls.m1346c("DBUN updateRow");
        try {
            m1091d();
            ContentValues contentValues = new ContentValues();
            contentValues.put("nick_name", str);
            contentValues.put("contact_name", str2);
            contentValues.put("contact_id", str3);
            this.f1278b.update("user_nicknames", contentValues, "_id = ?", new String[]{String.valueOf(i)});
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final String m1096b(long j) {
        String str;
        SQLException sQLException;
        ls.m1346c("DBUN getNickName");
        String str2 = "";
        try {
            m1091d();
            Cursor query = this.f1278b.query("user_nicknames", new String[]{"nick_name"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            str = str2;
            while (!query.isAfterLast()) {
                try {
                    String string = query.getString(0);
                    try {
                        query.moveToNext();
                        str = string;
                    } catch (SQLException e) {
                        SQLException sQLException2 = e;
                        str = string;
                        sQLException = sQLException2;
                    }
                } catch (SQLException e2) {
                    sQLException = e2;
                }
            }
            query.close();
            ls.m1344a("nname: " + str);
            close();
        } catch (SQLException e3) {
            sQLException = e3;
            str = str2;
            sQLException.printStackTrace();
            return str;
        }
        return str;
    }

    public final ArrayList<String> m1097b() {
        ls.m1346c("DBUN getAllContactNames");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1091d();
            Cursor query = this.f1278b.query("user_nicknames", new String[]{"contact_name"}, null, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                arrayList.add(query.getString(0));
                query.moveToNext();
            }
            query.close();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final String m1098c(long j) {
        String str;
        SQLException sQLException;
        ls.m1346c("DBUN getContactName");
        String str2 = "";
        try {
            m1091d();
            Cursor query = this.f1278b.query("user_nicknames", new String[]{"contact_name"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            str = str2;
            while (!query.isAfterLast()) {
                try {
                    String string = query.getString(0);
                    try {
                        query.moveToNext();
                        str = string;
                    } catch (SQLException e) {
                        SQLException sQLException2 = e;
                        str = string;
                        sQLException = sQLException2;
                    }
                } catch (SQLException e2) {
                    sQLException = e2;
                }
            }
            query.close();
            ls.m1344a("cname: " + str);
            close();
        } catch (SQLException e3) {
            sQLException = e3;
            str = str2;
            sQLException.printStackTrace();
            return str;
        }
        return str;
    }

    public final ArrayList<Integer> m1099c() {
        ls.m1346c("DBUN getColumID");
        ArrayList<Integer> arrayList = new ArrayList();
        try {
            m1091d();
            Cursor query = this.f1278b.query("user_nicknames", new String[]{"_id"}, null, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                arrayList.add(Integer.valueOf(query.getInt(0)));
                query.moveToNext();
            }
            query.close();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final void close() {
        this.f1278b.close();
    }

    public final String m1100d(long j) {
        String str;
        SQLException sQLException;
        ls.m1346c("DBUN getContactID");
        String str2 = "";
        try {
            m1091d();
            Cursor query = this.f1278b.query("user_nicknames", new String[]{"contact_id"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
            query.moveToFirst();
            str = str2;
            while (!query.isAfterLast()) {
                try {
                    String string = query.getString(0);
                    try {
                        query.moveToNext();
                        str = string;
                    } catch (SQLException e) {
                        SQLException sQLException2 = e;
                        str = string;
                        sQLException = sQLException2;
                    }
                } catch (SQLException e2) {
                    sQLException = e2;
                }
            }
            query.close();
            ls.m1344a("cid: " + str);
            close();
        } catch (SQLException e3) {
            sQLException = e3;
            str = str2;
            sQLException.printStackTrace();
            return str;
        }
        return str;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ls.m1346c("DBUC onCreate");
        sQLiteDatabase.execSQL("create table user_nicknames(_id integer primary key autoincrement, nick_name text not null, contact_name text not null, contact_id text not null);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ls.m1346c("DBA onUpgrage");
        ls.m1347d("Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_nicknames");
        onCreate(sQLiteDatabase);
    }
}
