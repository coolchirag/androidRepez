package com.brandall.nutter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;

public final class hk extends SQLiteOpenHelper {
    private static final String[] f1283a = new String[]{"_id", "user_words", "user_replace"};
    private SQLiteDatabase f1284b;

    public hk(Context context) {
        super(context, "userWords.db", null, 1);
    }

    private void m1113d() {
        this.f1284b = getWritableDatabase();
    }

    public final ArrayList<String> m1114a() {
        ls.m1346c("DBUW getAllWords");
        try {
            m1113d();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<String> arrayList = new ArrayList();
        Cursor query = this.f1284b.query("user_words", new String[]{"user_words"}, null, null, null, null, null);
        query.moveToFirst();
        while (!query.isAfterLast()) {
            arrayList.add(query.getString(0));
            query.moveToNext();
        }
        query.close();
        try {
            close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public final void m1115a(long j) {
        ls.m1346c("DBUW deleteRow");
        try {
            m1113d();
            this.f1284b.delete("user_words", "_id=?", new String[]{String.valueOf(j)});
            this.f1284b.execSQL("VACUUM");
            this.f1284b.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final void m1116a(String str, String str2) {
        ls.m1346c("DBUW insertRow");
        try {
            m1113d();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_words", str);
        contentValues.put("user_replace", str2);
        try {
            Cursor query = this.f1284b.query("user_words", f1283a, "_id = " + this.f1284b.insert("user_words", null, contentValues), null, null, null, null);
            query.moveToFirst();
            query.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            close();
        } catch (SQLException e3) {
            e3.printStackTrace();
        }
    }

    public final void m1117a(String str, String str2, int i) {
        ls.m1346c("DBUW updateRow");
        try {
            m1113d();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_words", str);
        contentValues.put("user_replace", str2);
        this.f1284b.update("user_words", contentValues, "_id = ?", new String[]{String.valueOf(i)});
        try {
            close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean m1118a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ls.m1346c("DBUW insertData");
        try {
            m1113d();
            this.f1284b.delete("user_words", null, null);
            this.f1284b.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            m1113d();
            int size = arrayList.size();
            this.f1284b.beginTransaction();
            SQLiteStatement compileStatement = this.f1284b.compileStatement("insert into user_words (user_words, user_replace) values (?, ?)");
            for (int i = 0; i < size; i++) {
                compileStatement.bindString(1, (String) arrayList.get(i));
                compileStatement.bindString(2, (String) arrayList2.get(i));
                compileStatement.executeInsert();
            }
            this.f1284b.setTransactionSuccessful();
            this.f1284b.endTransaction();
            this.f1284b.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final String m1119b(long j) {
        ls.m1346c("DBUW getUserWords");
        try {
            m1113d();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Cursor query = this.f1284b.query("user_words", new String[]{"user_words"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
        query.moveToFirst();
        String str = "";
        while (!query.isAfterLast()) {
            str = query.getString(0);
            query.moveToNext();
        }
        query.close();
        ls.m1344a("uwords: " + str);
        try {
            close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public final ArrayList<String> m1120b() {
        ls.m1346c("DBUW getAllReplace");
        try {
            m1113d();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<String> arrayList = new ArrayList();
        Cursor query = this.f1284b.query("user_words", new String[]{"user_replace"}, null, null, null, null, null);
        query.moveToFirst();
        while (!query.isAfterLast()) {
            arrayList.add(query.getString(0));
            query.moveToNext();
        }
        query.close();
        try {
            close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public final String m1121c(long j) {
        ls.m1346c("DBUW getReplaceWords");
        try {
            m1113d();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Cursor query = this.f1284b.query("user_words", new String[]{"user_replace"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
        query.moveToFirst();
        String str = "";
        while (!query.isAfterLast()) {
            str = query.getString(0);
            query.moveToNext();
        }
        query.close();
        ls.m1344a("rwords: " + str);
        try {
            close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public final ArrayList<Integer> m1122c() {
        ls.m1346c("DBUN getColumID");
        try {
            m1113d();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> arrayList = new ArrayList();
        Cursor query = this.f1284b.query("user_words", new String[]{"_id"}, null, null, null, null, null);
        query.moveToFirst();
        while (!query.isAfterLast()) {
            arrayList.add(Integer.valueOf(query.getInt(0)));
            query.moveToNext();
        }
        query.close();
        try {
            close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public final void close() {
        this.f1284b.close();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ls.m1346c("DBUC onCreate");
        sQLiteDatabase.execSQL("create table user_words(_id integer primary key autoincrement, user_words text not null, user_replace text not null);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ls.m1346c("DBA onUpgrage");
        ls.m1347d("Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_words");
        onCreate(sQLiteDatabase);
    }
}
