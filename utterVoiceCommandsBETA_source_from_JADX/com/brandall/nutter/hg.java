package com.brandall.nutter;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;

public final class hg extends SQLiteOpenHelper {
    private SQLiteDatabase f1276a;

    public hg(Context context) {
        super(context, "userMusic.db", null, 1);
    }

    private void m1087c() {
        this.f1276a = getWritableDatabase();
    }

    public final ArrayList<String> m1088a() {
        ls.m1346c("DBUM getAllTrackTags");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1087c();
            Cursor query = this.f1276a.query("user_music", new String[]{"track_tag"}, null, null, null, null, null);
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

    public final void m1089a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ls.m1346c("DBUM insertData");
        try {
            m1087c();
            this.f1276a.delete("user_music", null, null);
            this.f1276a.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            m1087c();
            int size = arrayList.size();
            this.f1276a.beginTransaction();
            SQLiteStatement compileStatement = this.f1276a.compileStatement("insert into user_music (track_tag, track_uri) values (?, ?)");
            for (int i = 0; i < size; i++) {
                compileStatement.bindString(1, (String) arrayList.get(i));
                compileStatement.bindString(2, (String) arrayList2.get(i));
                compileStatement.executeInsert();
            }
            this.f1276a.setTransactionSuccessful();
            this.f1276a.endTransaction();
            this.f1276a.close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public final ArrayList<String> m1090b() {
        ls.m1346c("DBUM getAllTrackURIs");
        ArrayList<String> arrayList = new ArrayList();
        try {
            m1087c();
            Cursor query = this.f1276a.query("user_music", new String[]{"track_uri"}, null, null, null, null, null);
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
        this.f1276a.close();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ls.m1346c("DBUC onCreate");
        sQLiteDatabase.execSQL("create table user_music(_id integer primary key autoincrement, track_tag text not null, track_uri text not null);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ls.m1346c("DBA onUpgrage");
        ls.m1347d("Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_music");
        onCreate(sQLiteDatabase);
    }
}
