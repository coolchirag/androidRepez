package com.brandall.nutter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public final class hi extends SQLiteOpenHelper {
    private static final String[] f1279a = new String[]{"_id", "command_int", "command_success", "command_fail", "command_error", "connection_type"};
    private SQLiteDatabase f1280b;

    public hi(Context context) {
        super(context, "userStats.db", null, 1);
    }

    private void m1101c() {
        this.f1280b = getWritableDatabase();
    }

    public final ArrayList<Integer> m1102a(int i, int i2) {
        String str = "command_int=" + i + " AND connection_type=" + i2;
        ArrayList<Integer> arrayList = new ArrayList();
        try {
            m1101c();
            Cursor query = this.f1280b.query("user_stats", f1279a, str, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                arrayList.add(Integer.valueOf(query.getInt(0)));
                arrayList.add(Integer.valueOf(query.getInt(2)));
                arrayList.add(Integer.valueOf(query.getInt(3)));
                arrayList.add(Integer.valueOf(query.getInt(4)));
                query.moveToNext();
            }
            query.close();
            close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public final void m1103a() {
        try {
            m1101c();
            this.f1280b.delete("user_stats", null, null);
            this.f1280b.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final void m1104a(int i, int i2, int i3, int i4) {
        ls.m1346c("DBUS updateRow");
        try {
            m1101c();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("command_success", Integer.valueOf(i2));
        contentValues.put("command_fail", Integer.valueOf(i3));
        contentValues.put("command_error", Integer.valueOf(i4));
        this.f1280b.update("user_stats", contentValues, "_id = ?", new String[]{String.valueOf(i)});
        try {
            close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public final void m1105a(int i, int i2, int i3, int i4, int i5) {
        ls.m1346c("DBUS insertRow");
        try {
            m1101c();
            ContentValues contentValues = new ContentValues();
            contentValues.put("command_int", Integer.valueOf(i));
            contentValues.put("connection_type", Integer.valueOf(i5));
            contentValues.put("command_success", Integer.valueOf(i2));
            contentValues.put("command_fail", Integer.valueOf(i3));
            contentValues.put("command_error", Integer.valueOf(i4));
            Cursor query = this.f1280b.query("user_stats", f1279a, "_id = " + this.f1280b.insert("user_stats", null, contentValues), null, null, null, null);
            query.moveToFirst();
            query.close();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final ArrayList<String> m1106b() {
        ls.m1346c("DBUS getAllData");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1101c();
            Cursor query = this.f1280b.query("user_stats", f1279a, null, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                arrayList.add(query.getString(1) + "," + query.getString(2) + "," + query.getString(3) + "," + query.getString(4) + "," + query.getString(5) + "|");
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
        this.f1280b.close();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ls.m1346c("DBUS onCreate");
        sQLiteDatabase.execSQL("create table user_stats(_id integer primary key autoincrement, command_int integer not null, command_success integer not null, command_fail integer not null, command_error integer not null, connection_type integer not null);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ls.m1346c("DBUS onUpgrage");
        ls.m1347d("Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_stats");
        onCreate(sQLiteDatabase);
    }
}
