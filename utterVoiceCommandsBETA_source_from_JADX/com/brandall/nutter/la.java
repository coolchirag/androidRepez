package com.brandall.nutter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class la extends AsyncTask<Void, Void, Boolean> {
    Context f1651a;
    private final Locale f1652b = Locale.US;

    public la(Context context) {
        this.f1651a = context;
    }

    private Boolean m1310a() {
        ls.m1346c("DIB GenerateSubDirectoryList");
        try {
            System.gc();
            long currentTimeMillis = System.currentTimeMillis();
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            List<File> asList = Arrays.asList(externalStorageDirectory.listFiles());
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (hc.f1269b) {
                    ls.m1346c("Mounted: true");
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (File externalStorageDirectory2 : asList) {
                    if (!(externalStorageDirectory2.isFile() || !externalStorageDirectory2.canRead() || externalStorageDirectory2.isHidden())) {
                        asList = m1311a(externalStorageDirectory2);
                        if (!(asList == null || asList.isEmpty())) {
                            Collections.sort(asList);
                        }
                        for (File externalStorageDirectory22 : asList) {
                            arrayList2.add(externalStorageDirectory22.getPath().replaceAll(absolutePath, "").toLowerCase(this.f1652b).replaceAll("\\/", " ").trim().replaceAll(" +", " "));
                            arrayList.add(externalStorageDirectory22.toString());
                        }
                    }
                }
                if (hc.f1269b) {
                    ls.m1346c("dirPath: " + arrayList.size() + " : " + arrayList.toString());
                    ls.m1346c("dirName: " + arrayList2.size() + " : " + arrayList2.toString());
                }
                if (!(arrayList.isEmpty() || arrayList2.isEmpty())) {
                    new hf(this.f1651a).m1085a(arrayList2, arrayList);
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (hc.f1269b) {
                    ls.m1346c("GSDL elapsed: " + currentTimeMillis2);
                }
                return Boolean.valueOf(true);
            }
            if (hc.f1269b) {
                ls.m1347d("media mounted: false");
            }
            return Boolean.valueOf(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<File> m1311a(File file) {
        List<File> arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : Arrays.asList(listFiles)) {
                if (!(file2.isFile() || !file2.canRead() || file2.isHidden() || file2.getName().toLowerCase(this.f1652b).startsWith("cache") || file2.getName().toLowerCase(this.f1652b).startsWith("temp"))) {
                    arrayList.add(file2);
                    arrayList.addAll(m1311a(file2));
                }
            }
        }
        return arrayList;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m1310a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        if (hc.f1269b) {
            ls.m1345b("GenerateSubDirectoryList onPostEx");
        }
        try {
            ActivityHome.m555a();
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1347d("GenerateSubDirectoryList AH Activity dead");
            }
        }
        super.onPostExecute(bool);
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        if (hc.f1269b) {
            ls.m1345b("GenerateSubDirectoryList onPreEx");
        }
    }
}
