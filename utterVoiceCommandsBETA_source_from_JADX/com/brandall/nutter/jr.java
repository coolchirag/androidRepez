package com.brandall.nutter;

import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import org.apache.p036a.p037a.p038a.C0559b;
import org.apache.p036a.p037a.p039b.C0563b;

public final class jr {
    public static String m1214a() {
        ls.m1346c("EstablishZipFile scanDir");
        ArrayList arrayList = new ArrayList();
        String str = Environment.getExternalStorageDirectory() + "/utter/Zip_Files";
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            ls.m1346c("zipDir found");
            arrayList.add(str);
        }
        str = "";
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                for (File file2 : new File((String) it.next()).listFiles(C0563b.f3087a)) {
                    ls.m1345b("myFiles: " + file2 + " : " + new Date(file2.lastModified()));
                    if (file2.getPath().toLowerCase().endsWith("zip")) {
                        arrayList2.add(file2);
                    }
                }
            }
            if (GlobalV.av() && GlobalV.aw() != null) {
                File file3 = new File(GlobalV.aw());
                if (!arrayList2.contains(file3)) {
                    arrayList2.add(file3);
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
