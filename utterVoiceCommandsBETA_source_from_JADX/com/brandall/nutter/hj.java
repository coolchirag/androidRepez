package com.brandall.nutter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public final class hj extends SQLiteOpenHelper {
    private static final String[] f1281a = new String[]{"_id", "var_name", "var_value"};
    private SQLiteDatabase f1282b;

    public hj(Context context) {
        super(context, "userTasker.db", null, 1);
    }

    private void m1107d() {
        this.f1282b = getWritableDatabase();
    }

    public final ArrayList<String> m1108a() {
        ls.m1346c("DBUT getAllVarNames");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1107d();
            Cursor query = this.f1282b.query("user_tasker", new String[]{"var_name"}, null, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
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

    public final void m1109a(String str, String str2) {
        ls.m1346c("DBUT insertRow: varName: " + str + " : varVal: " + str2);
        try {
            m1107d();
            ContentValues contentValues = new ContentValues();
            contentValues.put("var_name", str);
            contentValues.put("var_value", str2);
            Cursor query = this.f1282b.query("user_tasker", f1281a, "_id = " + this.f1282b.insert("user_tasker", null, contentValues), null, null, null, null);
            query.moveToFirst();
            query.close();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final void m1110a(String str, String str2, int i) {
        ls.m1346c("DBUT updateRow");
        try {
            m1107d();
            ContentValues contentValues = new ContentValues();
            contentValues.put("var_name", str);
            contentValues.put("var_value", str2);
            this.f1282b.update("user_tasker", contentValues, "_id = ?", new String[]{String.valueOf(i)});
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final ArrayList<String> m1111b() {
        ls.m1346c("DBUT getAllVarValues");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1107d();
            Cursor query = this.f1282b.query("user_tasker", new String[]{"var_value"}, null, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
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

    public final ArrayList<Integer> m1112c() {
        ls.m1346c("DBUT getColumID");
        ArrayList<Integer> arrayList = new ArrayList();
        try {
            m1107d();
            Cursor query = this.f1282b.query("user_tasker", new String[]{"_id"}, null, null, null, null, null);
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

    public final void close() {
        this.f1282b.close();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ls.m1346c("DBUT onCreate");
        sQLiteDatabase.execSQL("create table user_tasker(_id integer primary key autoincrement, var_name text not null, var_value text not null);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ls.m1346c("DBUT onUpgrage");
        ls.m1347d("Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_tasker");
        onCreate(sQLiteDatabase);
    }
}
