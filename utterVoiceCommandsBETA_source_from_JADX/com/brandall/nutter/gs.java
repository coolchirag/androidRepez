package com.brandall.nutter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

public final class gs extends AsyncTask<Boolean, Void, Boolean> {
    Context f1249a;

    public gs(Context context) {
        this.f1249a = context;
    }

    private static boolean m995a() {
        if (hc.f1269b) {
            ls.m1346c("in copyHosts");
        }
        if (m998d()) {
            try {
                File file = new File("/etc/hosts");
                File file2 = new File(Environment.getExternalStorageDirectory() + "/utter/Files/hosts");
                InputStream fileInputStream = new FileInputStream(file);
                OutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        fileInputStream.close();
                        fileOutputStream.close();
                        return true;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else if (!hc.f1269b) {
            return false;
        } else {
            ls.m1346c("copyHosts: utterDir: false");
            return false;
        }
    }

    private static boolean m996b() {
        try {
            if (new File(Environment.getExternalStorageDirectory() + "/utter/Files/hosts").exists()) {
                File file = new File("/etc/hosts");
                File file2 = new File(Environment.getExternalStorageDirectory() + "/utter/Files/hosts1");
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
                Locale locale = Locale.US;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedWriter.close();
                        try {
                            mj.m1473a("busybox mount -o remount,rw /system && busybox rm /etc/hosts && busybox cp " + file2 + " /etc/hosts && busybox mount -o remount,ro /system");
                            return true;
                        } catch (mn e) {
                            if (hc.f1269b) {
                                ls.m1348e("ShellException");
                            }
                            e.printStackTrace();
                            return false;
                        }
                    } else if (!readLine.toLowerCase(locale).contains("googleads")) {
                        bufferedWriter.write("\n" + readLine);
                    } else if (hc.f1269b) {
                        ls.m1345b("removing: " + readLine);
                    }
                }
            } else if (!hc.f1269b) {
                return false;
            } else {
                ls.m1347d("utter/Files/hosts does not exist. Cancelling");
                return false;
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private static boolean m997c() {
        try {
            mj.m1473a("busybox mount -o remount,rw /system && busybox rm /etc/hosts && busybox cp " + new File(Environment.getExternalStorageDirectory() + "/utter/Files/hosts") + " /etc/hosts && busybox mount -o remount,ro /system");
            return true;
        } catch (mn e) {
            if (hc.f1269b) {
                ls.m1348e("ShellException");
            }
            e.printStackTrace();
            return false;
        }
    }

    private static boolean m998d() {
        if (hc.f1269b) {
            ls.m1346c("in utterDir");
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/utter");
            if (!file.exists() || !file.isDirectory()) {
                if (hc.f1269b) {
                    ls.m1346c("utter dir doesnt exist. Creating");
                }
                file.mkdirs();
            } else if (hc.f1269b) {
                ls.m1346c("utter dir exists");
            }
            file = new File(Environment.getExternalStorageDirectory() + "/utter/Files");
            if (!file.exists() || !file.isDirectory()) {
                if (hc.f1269b) {
                    ls.m1346c("utter/Files dir doesnt exist. Creating");
                }
                file.mkdirs();
            } else if (hc.f1269b) {
                ls.m1346c("utter/Files dir exists");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        boolean a;
        Boolean[] boolArr = (Boolean[]) objArr;
        if (hc.f1269b) {
            ls.m1346c("AHA doInBackground");
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            long currentTimeMillis = System.currentTimeMillis();
            if (boolArr.length > 0) {
                if (hc.f1269b) {
                    ls.m1345b("condition[0]: " + boolArr[0]);
                }
                if (boolArr[0].booleanValue()) {
                    if (hc.f1269b) {
                        ls.m1346c("start: true");
                        ls.m1346c("sp1: " + System.getProperty("networkaddress.cache.ttl"));
                        ls.m1346c("sp2: " + System.getProperty("networkaddress.cache.negative.ttl"));
                    }
                    a = m995a();
                    if (a) {
                        a = m996b();
                        if (a) {
                            if (hc.f1269b) {
                                ls.m1345b("updateHosts: success");
                            }
                        } else if (hc.f1269b) {
                            ls.m1347d("updateHosts: failed");
                        }
                        GlobalV.m824b(a);
                    } else if (hc.f1269b) {
                        ls.m1347d("copyHosts: failed");
                    }
                } else {
                    if (hc.f1269b) {
                        ls.m1346c("start: false: replacing");
                    }
                    a = m997c();
                    GlobalV.m824b(false);
                }
            } else {
                if (hc.f1269b) {
                    ls.m1348e("AHA condition empty. Cancelling");
                }
                a = false;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (hc.f1269b) {
                ls.m1346c("AHA elapsed: " + currentTimeMillis2);
            }
        } else {
            if (hc.f1269b) {
                ls.m1347d("AHA media not mounted. Cancelling");
            }
            a = false;
        }
        return Boolean.valueOf(a);
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        if (hc.f1269b) {
            ls.m1345b("AdMobHelperAsync onPreEx");
        }
    }
}
