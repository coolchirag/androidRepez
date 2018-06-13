package com.brandall.nutter;

import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import org.apache.p036a.p037a.p038a.C0559b;
import org.apache.p036a.p037a.p039b.C0563b;

public final class iz {
    public static String m1194a() {
        ls.m1346c("EstablishScreenshot scanDir");
        ArrayList arrayList = new ArrayList();
        String str = Environment.getExternalStorageDirectory() + "/Screencast";
        String str2 = Environment.getExternalStorageDirectory() + "/utter/Screenshots";
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists() && file.isDirectory()) {
            ls.m1346c("Screencast dir found");
            arrayList.add(str);
        }
        if (file2.exists() && file2.isDirectory()) {
            ls.m1346c("Screenshot dir found");
            arrayList.add(str2);
        }
        str = "";
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                for (File file3 : new File((String) it.next()).listFiles(C0563b.f3087a)) {
                    ls.m1345b("myFiles: " + file3 + " : " + new Date(file3.lastModified()));
                    if (file3.getPath().toLowerCase().endsWith("jpg") || file3.getPath().endsWith("gif") || file3.getPath().endsWith("png")) {
                        arrayList2.add(file3);
                    }
                }
            }
            if (GlobalV.as() && GlobalV.at() != null) {
                File file4 = new File(GlobalV.at());
                if (!arrayList2.contains(file4)) {
                    arrayList2.add(file4);
                }
            }
            ls.m1344a("fileArray: " + arrayList2.size() + " : " + arrayList2.toString());
            if (!arrayList2.isEmpty()) {
                File[] fileArr = (File[]) arrayList2.toArray(new File[arrayList2.size()]);
                Arrays.sort(fileArr, C0559b.f3085b);
                ls.m1344a("Last modified: " + fileArr[0]);
                return fileArr[0].getPath();
            }
        }
        return str;
    }
}
