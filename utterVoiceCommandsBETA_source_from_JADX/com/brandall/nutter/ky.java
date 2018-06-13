package com.brandall.nutter;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import java.util.ArrayList;
import java.util.Locale;

public final class ky extends AsyncTask<Void, Void, Void> {
    Context f1629a;
    private final String f1630b = "mp3";
    private final String f1631c = "wma";
    private final String f1632d = "flac";

    public ky(Context context) {
        this.f1629a = context;
    }

    private Void m1308a() {
        if (hc.f1269b) {
            ls.m1346c("DIB GenerateMusicTagList");
        }
        Locale locale = Locale.US;
        try {
            System.gc();
            long currentTimeMillis = System.currentTimeMillis();
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (hc.f1269b) {
                    ls.m1346c("Mounted: true");
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Cursor query = this.f1629a.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "artist", "title"}, null, null, null);
                if (query != null && query.getCount() > 0) {
                    while (query.moveToNext()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        String string2 = query.getString(query.getColumnIndexOrThrow("title"));
                        String string3 = query.getString(query.getColumnIndexOrThrow("artist"));
                        if (!(string == null || ((!string.toLowerCase(locale).trim().endsWith("mp3") && !string.toLowerCase(locale).trim().endsWith("wma") && !string.toLowerCase(locale).trim().endsWith("flac")) || string3 == null || string2 == null))) {
                            string2 = new StringBuilder(String.valueOf(string3)).append(" ").append(string2).toString().toLowerCase(locale).replaceAll("[^A-Za-z0-9]", " ").trim().replaceAll(" +", " ");
                            if (!arrayList.contains(string2)) {
                                arrayList.add(string2);
                                arrayList2.add(string);
                            }
                        }
                    }
                    query.close();
                }
                if (hc.f1269b) {
                    ls.m1346c("trackTag: " + arrayList.size() + " " + arrayList.toString());
                    ls.m1346c("trackURI: " + arrayList2.size() + " " + arrayList2.toString());
                }
                if (!(arrayList.isEmpty() || arrayList2.isEmpty())) {
                    new hg(this.f1629a).m1089a(arrayList, arrayList2);
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (hc.f1269b) {
                    ls.m1346c("GMTL elapsed: " + currentTimeMillis2);
                }
            } else if (hc.f1269b) {
                ls.m1347d("media mounted: false");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m1308a();
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        if (hc.f1269b) {
            ls.m1345b("GenerateMusicTagList onPreEx");
        }
    }
}
