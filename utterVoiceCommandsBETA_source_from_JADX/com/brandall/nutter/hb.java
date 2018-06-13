package com.brandall.nutter;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class hb extends AsyncTask<Void, Void, Void> {
    Context f1267a;

    public hb(Context context) {
        this.f1267a = context;
    }

    private Void m1057a() {
        if (hc.f1269b) {
            ls.m1346c("DIB CreateDirectories");
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (hc.f1269b) {
                ls.m1346c("Mounted: true");
            }
            long currentTimeMillis = System.currentTimeMillis();
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory + "/utter");
            if (!file.exists() || !file.isDirectory()) {
                if (hc.f1269b) {
                    ls.m1346c("utter dir doesnt exist. Creating");
                }
                file.mkdirs();
            } else if (hc.f1269b) {
                ls.m1346c("utter dir exists");
            }
            file = new File(externalStorageDirectory + "/utter/Files");
            if (!file.exists() || !file.isDirectory()) {
                if (hc.f1269b) {
                    ls.m1346c("utter/Files dir doesnt exist. Creating");
                }
                file.mkdirs();
            } else if (hc.f1269b) {
                ls.m1346c("utter/Files dir exists");
            }
            file = new File(externalStorageDirectory + "/utter/Pictures");
            if (!file.exists() || !file.isDirectory()) {
                if (hc.f1269b) {
                    ls.m1346c("utter/Pictures dir doesnt exist. Creating");
                }
                file.mkdirs();
            } else if (hc.f1269b) {
                ls.m1346c("utter/Pictures dir exists");
            }
            file = new File(externalStorageDirectory + "/utter/Profiles");
            if (!file.exists() || !file.isDirectory()) {
                if (hc.f1269b) {
                    ls.m1346c("utter/Profiles dir doesnt exist. Creating");
                }
                file.mkdirs();
            } else if (hc.f1269b) {
                ls.m1346c("utter/Profiles dir exists");
            }
            file = new File(externalStorageDirectory + "/utter/Screenshots");
            if (!file.exists() || !file.isDirectory()) {
                if (hc.f1269b) {
                    ls.m1346c("utter/Screenshots dir doesnt exist. Creating");
                }
                file.mkdirs();
            } else if (hc.f1269b) {
                ls.m1346c("utter/Screenshots dir exists");
            }
            file = new File(externalStorageDirectory + "/utter/User_Commands");
            if (!file.exists() || !file.isDirectory()) {
                if (hc.f1269b) {
                    ls.m1346c("utter/User_Commands dir doesnt exist. Creating");
                }
                file.mkdirs();
            } else if (hc.f1269b) {
                ls.m1346c("utter/User_Commands dir exists");
            }
            file = new File(externalStorageDirectory + "/utter/Voice_Notes");
            if (!file.exists() || !file.isDirectory()) {
                if (hc.f1269b) {
                    ls.m1346c("utter/Voice_Notes dir doesnt exist. Creating");
                }
                file.mkdirs();
            } else if (hc.f1269b) {
                ls.m1346c("utter/Voice_Notes dir exists");
            }
            file = new File(externalStorageDirectory + "/utter/Zip_Files");
            if (!file.exists() || !file.isDirectory()) {
                if (hc.f1269b) {
                    ls.m1346c("utter/Zip_Files dir doesnt exist. Creating");
                }
                file.mkdirs();
            } else if (hc.f1269b) {
                ls.m1346c("utter/Zip_Files dir exists");
            }
            file = new File(externalStorageDirectory + "/utter/Sound_Effects");
            if (!file.exists() || !file.isDirectory()) {
                InputStream openRawResource;
                ByteArrayOutputStream byteArrayOutputStream;
                byte[] bArr;
                int read;
                byte[] toByteArray;
                FileOutputStream fileOutputStream;
                if (hc.f1269b) {
                    ls.m1346c("utter/Sound_Effects dir doesnt exist. Creating");
                }
                file.mkdirs();
                try {
                    openRawResource = this.f1267a.getResources().openRawResource(R.raw.burp);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    bArr = new byte[1024];
                    while (true) {
                        read = openRawResource.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    openRawResource.close();
                    toByteArray = byteArrayOutputStream.toByteArray();
                    fileOutputStream = new FileOutputStream(externalStorageDirectory + "/utter/Sound_Effects/burp.ogg/");
                    fileOutputStream.write(toByteArray);
                    fileOutputStream.close();
                } catch (NotFoundException e) {
                    if (hc.f1269b) {
                        ls.m1348e("NotFoundException");
                    }
                    e.printStackTrace();
                } catch (FileNotFoundException e2) {
                    if (hc.f1269b) {
                        ls.m1348e("FileNotFoundException");
                    }
                    e2.printStackTrace();
                } catch (IOException e3) {
                    if (hc.f1269b) {
                        ls.m1348e("IOException");
                    }
                    e3.printStackTrace();
                }
                try {
                    openRawResource = this.f1267a.getResources().openRawResource(R.raw.fart);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    bArr = new byte[1024];
                    while (true) {
                        read = openRawResource.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    openRawResource.close();
                    toByteArray = byteArrayOutputStream.toByteArray();
                    fileOutputStream = new FileOutputStream(externalStorageDirectory + "/utter/Sound_Effects/fart.ogg/");
                    fileOutputStream.write(toByteArray);
                    fileOutputStream.close();
                } catch (NotFoundException e4) {
                    if (hc.f1269b) {
                        ls.m1348e("NotFoundException");
                    }
                    e4.printStackTrace();
                } catch (FileNotFoundException e22) {
                    if (hc.f1269b) {
                        ls.m1348e("FileNotFoundException");
                    }
                    e22.printStackTrace();
                } catch (IOException e32) {
                    if (hc.f1269b) {
                        ls.m1348e("IOException");
                    }
                    e32.printStackTrace();
                }
                try {
                    openRawResource = this.f1267a.getResources().openRawResource(R.raw.fart);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    bArr = new byte[1024];
                    while (true) {
                        read = openRawResource.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    openRawResource.close();
                    toByteArray = byteArrayOutputStream.toByteArray();
                    fileOutputStream = new FileOutputStream(externalStorageDirectory + "/utter/Sound_Effects/fart.ogg/");
                    fileOutputStream.write(toByteArray);
                    fileOutputStream.close();
                } catch (NotFoundException e42) {
                    if (hc.f1269b) {
                        ls.m1348e("NotFoundException");
                    }
                    e42.printStackTrace();
                } catch (FileNotFoundException e222) {
                    if (hc.f1269b) {
                        ls.m1348e("FileNotFoundException");
                    }
                    e222.printStackTrace();
                } catch (IOException e322) {
                    if (hc.f1269b) {
                        ls.m1348e("IOException");
                    }
                    e322.printStackTrace();
                }
                try {
                    openRawResource = this.f1267a.getResources().openRawResource(R.raw.fart1);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    bArr = new byte[1024];
                    while (true) {
                        read = openRawResource.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    openRawResource.close();
                    toByteArray = byteArrayOutputStream.toByteArray();
                    fileOutputStream = new FileOutputStream(externalStorageDirectory + "/utter/Sound_Effects/fart1.ogg/");
                    fileOutputStream.write(toByteArray);
                    fileOutputStream.close();
                } catch (NotFoundException e422) {
                    if (hc.f1269b) {
                        ls.m1348e("NotFoundException");
                    }
                    e422.printStackTrace();
                } catch (FileNotFoundException e2222) {
                    if (hc.f1269b) {
                        ls.m1348e("FileNotFoundException");
                    }
                    e2222.printStackTrace();
                } catch (IOException e3222) {
                    if (hc.f1269b) {
                        ls.m1348e("IOException");
                    }
                    e3222.printStackTrace();
                }
                try {
                    openRawResource = this.f1267a.getResources().openRawResource(R.raw.fart2);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    bArr = new byte[1024];
                    while (true) {
                        read = openRawResource.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    openRawResource.close();
                    toByteArray = byteArrayOutputStream.toByteArray();
                    fileOutputStream = new FileOutputStream(externalStorageDirectory + "/utter/Sound_Effects/fart2.ogg/");
                    fileOutputStream.write(toByteArray);
                    fileOutputStream.close();
                } catch (NotFoundException e4222) {
                    if (hc.f1269b) {
                        ls.m1348e("NotFoundException");
                    }
                    e4222.printStackTrace();
                } catch (FileNotFoundException e22222) {
                    if (hc.f1269b) {
                        ls.m1348e("FileNotFoundException");
                    }
                    e22222.printStackTrace();
                } catch (IOException e32222) {
                    if (hc.f1269b) {
                        ls.m1348e("IOException");
                    }
                    e32222.printStackTrace();
                }
                try {
                    openRawResource = this.f1267a.getResources().openRawResource(R.raw.cough);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    bArr = new byte[1024];
                    while (true) {
                        read = openRawResource.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    openRawResource.close();
                    toByteArray = byteArrayOutputStream.toByteArray();
                    fileOutputStream = new FileOutputStream(externalStorageDirectory + "/utter/Sound_Effects/cough.ogg/");
                    fileOutputStream.write(toByteArray);
                    fileOutputStream.close();
                } catch (NotFoundException e42222) {
                    if (hc.f1269b) {
                        ls.m1348e("NotFoundException");
                    }
                    e42222.printStackTrace();
                } catch (FileNotFoundException e222222) {
                    if (hc.f1269b) {
                        ls.m1348e("FileNotFoundException");
                    }
                    e222222.printStackTrace();
                } catch (IOException e322222) {
                    if (hc.f1269b) {
                        ls.m1348e("IOException");
                    }
                    e322222.printStackTrace();
                }
                try {
                    openRawResource = this.f1267a.getResources().openRawResource(R.raw.giggle);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    bArr = new byte[1024];
                    while (true) {
                        read = openRawResource.read(bArr, 0, 1024);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    openRawResource.close();
                    toByteArray = byteArrayOutputStream.toByteArray();
                    fileOutputStream = new FileOutputStream(externalStorageDirectory + "/utter/Sound_Effects/giggle.ogg/");
                    fileOutputStream.write(toByteArray);
                    fileOutputStream.close();
                } catch (NotFoundException e422222) {
                    if (hc.f1269b) {
                        ls.m1348e("NotFoundException");
                    }
                    e422222.printStackTrace();
                } catch (FileNotFoundException e2222222) {
                    if (hc.f1269b) {
                        ls.m1348e("FileNotFoundException");
                    }
                    e2222222.printStackTrace();
                } catch (IOException e3222222) {
                    if (hc.f1269b) {
                        ls.m1348e("IOException");
                    }
                    e3222222.printStackTrace();
                }
                try {
                    new File(new File(externalStorageDirectory + "/utter/Sound_Effects/"), ".nomedia").createNewFile();
                } catch (IOException e32222222) {
                    if (hc.f1269b) {
                        ls.m1348e("IOException");
                    }
                    e32222222.printStackTrace();
                }
            } else if (hc.f1269b) {
                ls.m1346c("utter/Sound_Effects dir exists");
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (hc.f1269b) {
                ls.m1346c("CD elapsed: " + currentTimeMillis2);
            }
        } else if (hc.f1269b) {
            ls.m1347d("media mounted: false");
        }
        return null;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m1057a();
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        if (hc.f1269b) {
            ls.m1345b("CreateDirectories onPreEx");
        }
    }
}
