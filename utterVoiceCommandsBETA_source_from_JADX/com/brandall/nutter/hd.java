package com.brandall.nutter;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;

public final class hd extends SQLiteOpenHelper {
    private SQLiteDatabase f1272a;

    public hd(Context context) {
        super(context, "userApplications.db", null, 1);
    }

    private void m1059c() {
        this.f1272a = getWritableDatabase();
    }

    public final ArrayList<String> m1060a() {
        ls.m1346c("DBA getAllAppNames");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1059c();
            Cursor query = this.f1272a.query("user_applications", new String[]{"app_name"}, null, null, null, null, null);
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

    public final void m1061a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ls.m1346c("DBUA insertRow");
        try {
            m1059c();
            this.f1272a.delete("user_applications", null, null);
            this.f1272a.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            m1059c();
            int size = arrayList.size();
            this.f1272a.beginTransaction();
            SQLiteStatement compileStatement = this.f1272a.compileStatement("insert into user_applications (app_name, package_name) values (?, ?)");
            for (int i = 0; i < size; i++) {
                compileStatement.bindString(1, (String) arrayList.get(i));
                compileStatement.bindString(2, (String) arrayList2.get(i));
                compileStatement.executeInsert();
            }
            this.f1272a.setTransactionSuccessful();
            this.f1272a.endTransaction();
            this.f1272a.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final ArrayList<String> m1062b() {
        ls.m1346c("DBA getAllPackageNames");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1059c();
            Cursor query = this.f1272a.query("user_applications", new String[]{"package_name"}, null, null, null, null, null);
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

    public final void close() {
        this.f1272a.close();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ls.m1346c("DBUC onCreate");
        sQLiteDatabase.execSQL("create table user_applications(_id integer primary key autoincrement, app_name text not null, package_name text not null);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ls.m1346c("DBA onUpgrage");
        ls.m1347d("Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_applications");
        onCreate(sQLiteDatabase);
    }
}
