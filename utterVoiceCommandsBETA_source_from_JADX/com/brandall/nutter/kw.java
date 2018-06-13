package com.brandall.nutter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import java.util.Locale;

public final class kw {
    public static kx m1307a(Context context) {
        if (hc.f1269b) {
            ls.m1346c("MusicProcess getTracks");
        }
        long currentTimeMillis = System.currentTimeMillis();
        System.gc();
        kw kwVar = new kw();
        kwVar.getClass();
        kx kxVar = new kx(kwVar);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Uri uri = Media.EXTERNAL_CONTENT_URI;
        String[] strArr = new String[]{"_id", "_display_name", "_data"};
        if (uri != null) {
            Cursor query = context.getContentResolver().query(uri, strArr, null, null, null);
            Locale locale = Locale.US;
            if (query != null && query.getCount() > 0) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    if (string != null) {
                        String trim = string.toLowerCase(locale).replaceAll(absolutePath, "").replaceAll("[^A-Za-z0-9]", " ").trim();
                        if (trim.endsWith("mp3") || trim.endsWith("wma")) {
                            if (trim.startsWith("music")) {
                                trim = trim.replaceFirst("music", "");
                            }
                            if (trim.startsWith("albums")) {
                                trim = trim.replaceFirst("albums", "");
                            }
                            if (trim.startsWith("artists")) {
                                trim = trim.replaceFirst("artists", "");
                            }
                            if (trim.startsWith("notifications")) {
                                trim = trim.replaceFirst("notifications", "");
                            }
                            if (trim.startsWith("ringtones")) {
                                trim = trim.replaceFirst("ringtones", "");
                            }
                            if (trim.startsWith("alarms")) {
                                trim = trim.replaceFirst("alarms", "");
                            }
                            trim = trim.trim().replaceAll(" +", " ");
                            if (trim.length() > 4) {
                                trim = trim.substring(0, trim.length() - 4);
                                if (!kxVar.f1626a.contains(string)) {
                                    kxVar.f1626a.add(string);
                                    kxVar.f1627b.add(trim);
                                }
                            }
                        }
                    }
                }
                query.close();
            }
            if (hc.f1269b) {
                ls.m1344a("trackURI: " + kxVar.f1626a.size() + " : " + kxVar.f1626a.toString());
                ls.m1344a("trackURIEdit: " + kxVar.f1627b.size() + " : " + kxVar.f1627b.toString());
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (hc.f1269b) {
            ls.m1346c("getTracks elapsed: " + currentTimeMillis2);
        }
        return kxVar;
    }
}
