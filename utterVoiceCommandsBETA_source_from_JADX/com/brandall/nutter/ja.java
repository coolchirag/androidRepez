package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.apache.p036a.p037a.p039b.C0563b;

public final class ja {
    @SuppressLint({"NewApi"})
    public static String m1195a(Context context, String str) {
        ls.m1346c("EstablishSoundEffect replaceSoundEffectURIs");
        String str2 = "Sound effect external storage error";
        if (Environment.getExternalStorageState().equals("mounted")) {
            ls.m1346c("Mounted: true");
            ArrayList arrayList = new ArrayList();
            String str3 = Environment.getExternalStorageDirectory() + "/utter/Sound_Effects";
            File file = new File(str3);
            if (file.exists() && file.isDirectory()) {
                ls.m1346c("soundEffectDir dir found");
                arrayList.add(str3);
                if (arrayList.isEmpty()) {
                    ls.m1347d("directory empty");
                    return "Sound effect not found";
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    for (File file2 : new File((String) it.next()).listFiles(C0563b.f3087a)) {
                        ls.m1345b("myFiles: " + file2);
                        if (file2.getPath().toLowerCase().contains(str) && (file2.getPath().toLowerCase().endsWith("ogg") || file2.getPath().endsWith("wav") || file2.getPath().endsWith("mp3"))) {
                            arrayList2.add(file2.getPath());
                        }
                    }
                }
                ls.m1344a("soundArray: " + arrayList2.size() + " : " + arrayList2.toString());
                if (arrayList2.isEmpty()) {
                    ls.m1347d("soundArray empty");
                    return "Sound effect not found";
                } else if (arrayList2.size() <= 1) {
                    return (String) arrayList2.get(0);
                } else {
                    arrayList2.addAll(arrayList2);
                    return (String) arrayList2.get(new Random().nextInt(arrayList2.size() - 1));
                }
            }
            ls.m1347d("directory exists: false");
            if (VERSION.SDK_INT >= 11) {
                new hb(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new hb(context).execute(new Void[0]);
            }
            return "Sound effect directory not found";
        }
        ls.m1347d("media mounted: false");
        return str2;
    }
}
