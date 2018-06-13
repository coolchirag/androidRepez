package com.brandall.nutter;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;

public final class hf extends SQLiteOpenHelper {
    private SQLiteDatabase f1275a;

    public hf(Context context) {
        super(context, "userDirectories.db", null, 1);
    }

    private void m1083c() {
        this.f1275a = getWritableDatabase();
    }

    public final ArrayList<String> m1084a() {
        ls.m1346c("DBUD getAllDirNames");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1083c();
            Cursor query = this.f1275a.query("user_directories", new String[]{"dir_name"}, null, null, null, null, null);
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

    public final void m1085a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ls.m1346c("DBUD insertData");
        try {
            m1083c();
            this.f1275a.delete("user_directories", null, null);
            this.f1275a.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            m1083c();
            int size = arrayList.size();
            this.f1275a.beginTransaction();
            SQLiteStatement compileStatement = this.f1275a.compileStatement("insert into user_directories (dir_name, dir_path) values (?, ?)");
            for (int i = 0; i < size; i++) {
                compileStatement.bindString(1, (String) arrayList.get(i));
                compileStatement.bindString(2, (String) arrayList2.get(i));
                compileStatement.executeInsert();
            }
            this.f1275a.setTransactionSuccessful();
            this.f1275a.endTransaction();
            this.f1275a.close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public final ArrayList<String> m1086b() {
        ls.m1346c("DBUD getAllDirPaths");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1083c();
            Cursor query = this.f1275a.query("user_directories", new String[]{"dir_path"}, null, null, null, null, null);
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

    public final void close() {
        this.f1275a.close();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ls.m1346c("DBUC onCreate");
        sQLiteDatabase.execSQL("create table user_directories(_id integer primary key autoincrement, dir_name text not null, dir_path text not null);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ls.m1346c("DBA onUpgrage");
        ls.m1347d("Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_directories");
        onCreate(sQLiteDatabase);
    }
}
