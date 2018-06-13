package com.brandall.nutter;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public final class kf extends AsyncTask<String, Integer, Boolean> {
    public static boolean f1590b = false;
    Context f1591a;
    private String f1592c = "";
    private String f1593d = "";
    private String f1594e = "";
    private boolean f1595f = false;
    private boolean f1596g = false;
    private boolean f1597h = false;
    private boolean f1598i = false;
    private boolean f1599j = false;
    private boolean f1600k = false;
    private boolean f1601l = false;
    private boolean f1602m = false;
    private boolean f1603n = false;
    private boolean f1604o = false;
    private boolean f1605p = false;
    private boolean f1606q = false;
    private boolean f1607r = false;
    private boolean f1608s = false;
    private boolean f1609t = false;
    private boolean f1610u = true;
    private String f1611v = "com.test.test";

    public kf(Context context) {
        this.f1591a = context;
    }

    private Boolean m1291a(String... strArr) {
        if (hc.f1269b) {
            ls.m1346c("rootCommand: " + strArr.length);
        }
        GlobalV.m907z(false);
        GlobalV.m904y(false);
        Locale locale = Locale.US;
        this.f1609t = false;
        if (strArr.length > 0) {
            if (hc.f1269b) {
                ls.m1345b("rootCommand[0]: " + strArr[0]);
            }
            if (strArr[0].matches("requestAccess")) {
                this.f1607r = true;
            }
            if (strArr[0].matches("remote")) {
                this.f1608s = true;
                if (hc.f1269b) {
                    ls.m1346c("remote: True");
                }
            }
            if (strArr.length > 1 && strArr[0].matches("kill")) {
                this.f1611v = strArr[1];
                if (hc.f1269b) {
                    ls.m1344a("appToKill: " + this.f1611v);
                }
            }
        }
        if (this.f1607r) {
            if (hc.f1269b) {
                ls.m1346c("requestAccess: True");
            }
            if (mj.m1474a()) {
                this.f1610u = true;
                lx.m1434j(this.f1591a, true);
            } else {
                if (hc.f1269b) {
                    ls.m1346c("deviceRooted: False");
                }
                this.f1610u = false;
                lx.m1434j(this.f1591a, false);
            }
            this.f1597h = gr.m994b(this.f1591a);
        }
        if (this.f1610u) {
            File file;
            if (hc.f1269b) {
                ls.m1346c("deviceRooted: True");
            }
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (!new File(externalStorageDirectory + "/utter/toolbox").exists()) {
                if (hc.f1269b) {
                    ls.m1347d("toolbox missing. Checking utter dir");
                }
                file = new File(externalStorageDirectory + "/utter");
                if (!file.exists() || !file.isDirectory()) {
                    if (hc.f1269b) {
                        ls.m1346c("utter dir doesnt exist. Creating");
                    }
                    file.mkdirs();
                } else if (hc.f1269b) {
                    ls.m1346c("utter dir exists");
                }
                try {
                    InputStream openRawResource = this.f1591a.getResources().openRawResource(R.raw.toolbox);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = openRawResource.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    openRawResource.close();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    FileOutputStream fileOutputStream = new FileOutputStream(externalStorageDirectory + "/utter/toolbox/");
                    fileOutputStream.write(toByteArray);
                    fileOutputStream.close();
                } catch (NotFoundException e) {
                    if (hc.f1269b) {
                        ls.m1348e("NotFoundException");
                    }
                    e.printStackTrace();
                    this.f1609t = false;
                    return Boolean.valueOf(this.f1609t);
                } catch (FileNotFoundException e2) {
                    if (hc.f1269b) {
                        ls.m1348e("FileNotFoundException");
                    }
                    e2.printStackTrace();
                    this.f1609t = false;
                    return Boolean.valueOf(this.f1609t);
                } catch (IOException e3) {
                    if (hc.f1269b) {
                        ls.m1348e("IOException");
                    }
                    e3.printStackTrace();
                    this.f1609t = false;
                    return Boolean.valueOf(this.f1609t);
                }
            } else if (hc.f1269b) {
                ls.m1346c("External Storage toolbox found");
            }
            if (hc.f1269b) {
                ls.m1345b("Checking Binary");
            }
            try {
                String a = mj.m1473a("busybox install -D -m 750 -o 0 -g 0 " + externalStorageDirectory + "/utter/toolbox /data/utter/toolbox && echo toolbox installation true || echo toolbox installation false");
                if (a != null) {
                    if (hc.f1269b) {
                        ls.m1344a("output: " + a);
                    }
                    if (a.toLowerCase(locale).contains("permission") || a.toLowerCase(locale).contains("not found")) {
                        if (hc.f1269b) {
                            ls.m1347d("PERMISSION DENIED: " + a);
                        }
                        this.f1609t = false;
                        return Boolean.valueOf(this.f1609t);
                    } else if (!this.f1607r) {
                        a = GlobalV.aB();
                        if (a.matches("rootReboot")) {
                            if (hc.f1269b) {
                                ls.m1344a("shellCommand: " + a);
                            }
                            this.f1598i = true;
                        } else if (a.matches("rootRecovery")) {
                            if (hc.f1269b) {
                                ls.m1344a("shellCommand: " + a);
                            }
                            this.f1600k = true;
                        } else if (a.matches("rootBootloader")) {
                            if (hc.f1269b) {
                                ls.m1344a("shellCommand: " + a);
                            }
                            this.f1601l = true;
                        } else if (a.matches("logCat")) {
                            if (hc.f1269b) {
                                ls.m1344a("shellCommand: " + a);
                            }
                            this.f1602m = true;
                        } else if (a.matches("rootHot")) {
                            if (hc.f1269b) {
                                ls.m1344a("shellCommand: " + a);
                            }
                            this.f1603n = true;
                        } else if (a.matches("killApp")) {
                            if (hc.f1269b) {
                                ls.m1344a("shellCommand: " + a);
                            }
                            this.f1604o = true;
                        } else if (a.matches("rootGovernor")) {
                            if (hc.f1269b) {
                                ls.m1344a("shellCommand: " + a);
                            }
                            this.f1599j = true;
                        } else if (a.matches("screenShot")) {
                            if (hc.f1269b) {
                                ls.m1344a("shellCommand: " + a);
                            }
                            this.f1605p = true;
                        } else if (a.matches("md5Sum")) {
                            if (hc.f1269b) {
                                ls.m1344a("shellCommand: " + a);
                            }
                            this.f1606q = true;
                        } else if (!this.f1608s) {
                            if (hc.f1269b) {
                                ls.m1347d("shellCommand unknown: " + a);
                            }
                            GlobalV.m786B("");
                            this.f1609t = false;
                            return Boolean.valueOf(this.f1609t);
                        } else if (hc.f1269b) {
                            ls.m1344a("remote: " + this.f1608s);
                        }
                        a = "";
                        if (!this.f1608s) {
                            GlobalV.m786B("");
                        }
                        if (this.f1600k) {
                            if (hc.f1269b) {
                                ls.m1346c("xrr: " + this.f1600k);
                            }
                            a = "/data/utter/./toolbox reboot recovery";
                            if (hc.f1269b) {
                                ls.m1344a("Running Shell: " + a);
                            }
                        } else if (this.f1598i) {
                            if (hc.f1269b) {
                                ls.m1346c("xr: " + this.f1598i);
                            }
                            a = "/data/utter/./toolbox reboot";
                            if (hc.f1269b) {
                                ls.m1344a("Running Shell: " + a);
                            }
                        } else if (this.f1601l) {
                            if (hc.f1269b) {
                                ls.m1346c("xrb: " + this.f1601l);
                            }
                            a = "/data/utter/./toolbox reboot bootloader";
                            if (hc.f1269b) {
                                ls.m1344a("Running Shell: " + a);
                            }
                        } else if (this.f1602m) {
                            if (hc.f1269b) {
                                ls.m1346c("xlc: " + this.f1602m);
                            }
                            a = "logcat -d | grep nutter > " + externalStorageDirectory + "/utter/Files/utterlog.txt && echo logcat written true || echo logcat written false";
                            if (hc.f1269b) {
                                ls.m1344a("Running Shell: " + a);
                            }
                        } else if (this.f1603n) {
                            if (hc.f1269b) {
                                ls.m1346c("xhr: " + this.f1603n);
                            }
                            a = "pkill system_server";
                            if (hc.f1269b) {
                                ls.m1344a("Running Shell: " + a);
                            }
                        } else if (this.f1599j) {
                            if (hc.f1269b) {
                                ls.m1346c("xrg: " + this.f1599j);
                            }
                            a = "echo " + GlobalV.ak() + " > /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor && echo governor changed true || echo governor changed false";
                            if (hc.f1269b) {
                                ls.m1344a("Running Shell: " + a);
                            }
                        } else if (this.f1604o) {
                            if (hc.f1269b) {
                                ls.m1346c("xka: " + this.f1604o);
                            }
                            a = "busybox killall -9 " + this.f1611v + " && echo true || echo false";
                            if (hc.f1269b) {
                                ls.m1344a("Running Shell: " + a);
                            }
                        } else if (this.f1606q) {
                            if (hc.f1269b) {
                                ls.m1346c("xmd: " + this.f1606q);
                            }
                            a = "busybox md5sum " + GlobalV.aw();
                            if (hc.f1269b) {
                                ls.m1344a("Running Shell: " + a);
                            }
                        } else if (this.f1605p) {
                            if (hc.f1269b) {
                                ls.m1346c("xss: " + this.f1605p);
                            }
                            file = new File(externalStorageDirectory + "/utter/Screenshots");
                            if (!file.exists() || !file.isDirectory()) {
                                if (hc.f1269b) {
                                    ls.m1346c("screenshot dir doesnt exist. Creating");
                                }
                                file.mkdirs();
                            } else if (hc.f1269b) {
                                ls.m1346c("screenshot dir exists");
                            }
                            a = externalStorageDirectory + "/utter/Screenshots/";
                            a = "now=$(date +%m_%d_%H%M); /system/bin/screencap -p " + a + "utter_screenshot_$now.png && echo " + a + "utter_screenshot_$now.png || echo false";
                            if (hc.f1269b) {
                                ls.m1344a("Running Shell: " + a);
                            }
                        } else if (this.f1608s) {
                            if (hc.f1269b) {
                                ls.m1346c("remote: " + this.f1608s);
                            }
                            a = GlobalV.aB();
                            if (hc.f1269b) {
                                ls.m1344a("Running Shell: " + a);
                            }
                        } else if (hc.f1269b) {
                            ls.m1347d("exShell FAILED or did nothing");
                        }
                        try {
                            a = mj.m1473a(a);
                            if (a != null) {
                                if (hc.f1269b) {
                                    ls.m1344a("shellOP: " + a);
                                }
                                if (this.f1608s) {
                                    GlobalV.m863l(a);
                                    GlobalV.m786B("");
                                }
                                if (a.toLowerCase(locale).contains("permission") || a.toLowerCase(locale).contains("not found")) {
                                    if (hc.f1269b) {
                                        ls.m1347d("PERMISSION DENIED: " + a);
                                    }
                                    if (this.f1608s) {
                                        GlobalV.m863l("error");
                                    } else {
                                        this.f1595f = true;
                                        this.f1592c = "Your device does not appear to have root permissions?";
                                    }
                                } else {
                                    this.f1609t = true;
                                    if (this.f1599j && a.contains("true")) {
                                        this.f1595f = true;
                                        this.f1592c = "I've set the CPU governor to " + GlobalV.ak();
                                    } else if (this.f1599j && a.contains("false")) {
                                        this.f1595f = true;
                                        this.f1592c = "Sorry, but an error occured when I tried to change the CPU governor.";
                                    } else if (this.f1605p && a.contains("utter")) {
                                        this.f1595f = true;
                                        this.f1592c = "Cheese";
                                        this.f1596g = true;
                                        this.f1593d = "Saved to /utter/Screenshots";
                                        GlobalV.ar();
                                        GlobalV.m900x(a);
                                    } else if (this.f1605p && a.contains("false")) {
                                        this.f1595f = true;
                                        this.f1592c = "Something went wrong taking the screen shot. I suggest installing the application Screen Cast to use this feature";
                                    } else if (this.f1606q) {
                                        if (a.contains("utter")) {
                                            String[] split = a.split(" ");
                                            if (split.length > 0) {
                                                this.f1594e = split[0];
                                                if (hc.f1269b) {
                                                    ls.m1344a("md5Sum: " + this.f1594e);
                                                }
                                            } else {
                                                if (hc.f1269b) {
                                                    ls.m1347d("md5Sum split failed null");
                                                }
                                                this.f1595f = true;
                                                this.f1592c = "Something went wrong generating the check sum";
                                            }
                                        } else {
                                            if (hc.f1269b) {
                                                ls.m1347d("xmd shellOP doesn't contain utter");
                                            }
                                            this.f1595f = true;
                                            this.f1592c = "Something went wrong generating the check sum";
                                        }
                                    }
                                }
                            } else {
                                if (hc.f1269b) {
                                    ls.m1345b("Output is null: " + a);
                                }
                                if (this.f1608s) {
                                    GlobalV.m863l("null");
                                    GlobalV.m786B("");
                                } else {
                                    this.f1595f = true;
                                    this.f1592c = "Your device does not appear to have root permissions?";
                                }
                            }
                        } catch (mn e4) {
                            if (hc.f1269b) {
                                ls.m1348e("ShellException");
                            }
                            e4.getLocalizedMessage();
                            this.f1609t = false;
                            return Boolean.valueOf(this.f1609t);
                        }
                    }
                }
                if (hc.f1269b) {
                    ls.m1347d("strCommandOutput null");
                }
                this.f1609t = false;
                return Boolean.valueOf(this.f1609t);
            } catch (mn e42) {
                if (hc.f1269b) {
                    ls.m1348e("ShellException");
                }
                e42.printStackTrace();
                this.f1609t = false;
                return Boolean.valueOf(this.f1609t);
            }
        } else if (hc.f1269b) {
            ls.m1347d("deviceRooted: False");
        }
        return Boolean.valueOf(this.f1609t);
    }

    public static ArrayList<String> m1292a() {
        String b;
        ArrayList<String> arrayList = new ArrayList();
        String str = "";
        try {
            b = mj.m1476b("cat /sys/devices/system/cpu/cpu0/cpufreq/scaling_available_governors");
        } catch (mn e) {
            if (hc.f1269b) {
                ls.m1348e("ShellException:");
            }
            e.getLocalizedMessage();
            b = str;
        }
        if (b != null && !b.matches(" ")) {
            if (hc.f1269b) {
                ls.m1344a("shellOutput: " + b);
            }
            for (Object add : b.split("\\s")) {
                arrayList.add(add);
            }
        } else if (hc.f1269b) {
            ls.m1347d("No Governor output");
        }
        if (hc.f1269b) {
            ls.m1344a("myGovs: " + arrayList.size() + " : " + arrayList.toString());
        }
        return arrayList;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m1291a((String[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        if (hc.f1269b) {
            ls.m1346c("ExecuteRoot onPostEx");
        }
        if (this.f1595f) {
            lc.m1313a(this.f1591a, false, this.f1592c);
        }
        if (this.f1596g) {
            Toast.makeText(this.f1591a, this.f1593d, 0).show();
        }
        if (this.f1606q) {
            lt.m1352a(this.f1591a, "utter! md5sum generated", "md5sum", this.f1594e, 17301659, false, 0, 2);
        }
        if (this.f1605p) {
            MediaPlayer create = MediaPlayer.create(this.f1591a, R.raw.camerashutter);
            create.start();
            create.setOnCompletionListener(new kg(this));
        }
        if (this.f1597h && lx.ac(this.f1591a) && hc.f1269b) {
            if (VERSION.SDK_INT >= 11) {
                new gs(this.f1591a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Boolean[]{Boolean.valueOf(true)});
            } else {
                new gs(this.f1591a).execute(new Boolean[]{Boolean.valueOf(true)});
            }
        }
        f1590b = false;
        super.onPostExecute(bool);
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        if (hc.f1269b) {
            ls.m1345b("ExecuteRoot onPreEx");
        }
    }
}
