package com.brandall.nutter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class km {
    public static void m1305a(String[] strArr, String str) {
        ls.m1346c("ExecuteZip Zip");
        long currentTimeMillis = System.currentTimeMillis();
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
        byte[] bArr = new byte[200];
        for (int i = 0; i < strArr.length; i++) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(strArr[i]), 200);
            zipOutputStream.putNextEntry(new ZipEntry(strArr[i].substring(strArr[i].lastIndexOf("/") + 1)));
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 200);
                if (read == -1) {
                    try {
                        break;
                    } catch (Throwable th) {
                        zipOutputStream.close();
                    }
                } else {
                    zipOutputStream.write(bArr, 0, read);
                }
            }
            bufferedInputStream.close();
        }
        zipOutputStream.close();
        ls.m1344a("ExecuteZip Zip elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
    }
}
