package com.brandall.nutter;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import com.faceture.google.play.QueryParamConst;
import com.faceture.http.Scheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public final class ki {
    static int m1295a() {
        return new Random().nextInt(127);
    }

    public static String m1296a(Context context) {
        String uuid;
        ArrayList arrayList = new ArrayList();
        arrayList.add(lx.m1450s(context));
        arrayList.add("null");
        arrayList.add(context.getSharedPreferences("utterPref", 0).getString("web_user_name", "null"));
        arrayList.add(context.getString(R.string.app_version_short));
        arrayList.add(Build.MANUFACTURER);
        arrayList.add(Build.MODEL);
        arrayList.add(String.valueOf(VERSION.SDK_INT));
        arrayList.add(VERSION.RELEASE);
        arrayList.add(ib.m1160a());
        arrayList.add(Locale.getDefault().toString());
        arrayList.add(ib.m1162b(context));
        if (lx.m1451t(context).matches("")) {
            uuid = UUID.randomUUID().toString();
            Editor edit = context.getSharedPreferences("utterPref", 0).edit();
            edit.putString("user_uuid", uuid);
            edit.commit();
            lx.ar(context);
        }
        arrayList.add(lx.m1451t(context));
        Object e = ServiceTTS.m926e();
        if (e.matches("")) {
            e = "null";
        }
        arrayList.add(e);
        e = GlobalV.m873o();
        if (e == null) {
            e = "null";
        }
        arrayList.add(e);
        arrayList.add(ib.m1161a(context));
        arrayList.add(String.valueOf(context.getSharedPreferences("utterPref", 0).getBoolean("ad_block", false)));
        arrayList.add(String.valueOf(lx.ac(context)));
        Iterator it = arrayList.iterator();
        String str = "";
        while (it.hasNext()) {
            uuid = (String) it.next();
            if (hc.f1269b) {
                ls.m1346c("Si: " + uuid);
            }
            uuid = new StringBuilder(String.valueOf(str)).append(uuid).append("|").toString();
            if (hc.f1269b) {
                ls.m1346c("returnInfo: " + uuid);
            }
            str = uuid;
        }
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost("error");
        int a = m1295a();
        int a2 = m1295a();
        if (hc.f1269b) {
            ls.m1346c("int 1: " + a + " - int2: " + a2);
        }
        str = new StringBuilder(String.valueOf(Character.toString((char) a))).append(Character.toString((char) a2)).append("STARTUP=").append(str).toString();
        if (hc.f1269b) {
            ls.m1346c("myPost constuct: " + str);
        }
        str = kc.m1283a(str, GlobalV.az());
        HttpProtocolParams.setUserAgent(defaultHttpClient.getParams(), "utter");
        List arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair("p", str));
        httpPost.setEntity(new UrlEncodedFormEntity(arrayList2));
        uuid = EntityUtils.toString(defaultHttpClient.execute(httpPost).getEntity());
        if (hc.f1269b) {
            ls.m1346c("myPost httpContent: " + uuid);
        }
        return uuid;
    }

    public static String m1297a(Context context, String str) {
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost("error");
        int a = m1295a();
        int a2 = m1295a();
        if (hc.f1269b) {
            ls.m1346c("int 1: " + a + " - int2: " + a2);
        }
        String stringBuilder = new StringBuilder(String.valueOf(Character.toString((char) a))).append(Character.toString((char) a2)).append("USAGE=").append(lx.m1450s(context)).append("|").append(str).toString();
        if (hc.f1269b) {
            ls.m1346c("myPostUsage constuct: " + stringBuilder);
        }
        stringBuilder = kc.m1283a(stringBuilder, GlobalV.az());
        HttpProtocolParams.setUserAgent(defaultHttpClient.getParams(), "utter");
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("p", stringBuilder));
        httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
        String entityUtils = EntityUtils.toString(defaultHttpClient.execute(httpPost).getEntity());
        if (hc.f1269b) {
            ls.m1346c("myPostUsage httpContent: " + entityUtils);
        }
        return entityUtils;
    }

    public static String m1298b(Context context) {
        String str = "null";
        String str2 = "unknown";
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost("error");
        int a = m1295a();
        int a2 = m1295a();
        if (hc.f1269b) {
            ls.m1346c("int 1: " + a + " - int2: " + a2);
        }
        Location a3 = ik.m1175a(context);
        if (a3 == null) {
            if (hc.f1269b) {
                ls.m1347d("sendLocation GPS null");
            }
            a3 = ik.m1177c(context);
            if (a3 == null && hc.f1269b) {
                ls.m1347d("sendLocation lastKnown null");
            }
        }
        if (a3 != null) {
            if (a3.getProvider() != null) {
                str2 = a3.getProvider();
            }
            str2 = new StringBuilder(String.valueOf(Character.toString((char) a))).append(Character.toString((char) a2)).append("LOCATION=").append(lx.m1450s(context)).append("|").append("ADHOC|" + str2 + "|" + String.valueOf(a3.getLatitude()) + "|" + String.valueOf(a3.getLongitude()) + "|" + String.valueOf(a3.getAltitude()) + "|" + String.valueOf(a3.getBearing()) + "|" + String.valueOf(a3.getSpeed()) + "|" + String.valueOf(a3.getAccuracy()) + "|" + String.valueOf(a3.getTime())).append("|").toString();
            if (hc.f1269b) {
                ls.m1346c("sendLocation constuct: " + str2);
            }
            str2 = kc.m1283a(str2, GlobalV.az());
            HttpProtocolParams.setUserAgent(defaultHttpClient.getParams(), "utter");
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("p", str2));
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
            str2 = EntityUtils.toString(defaultHttpClient.execute(httpPost).getEntity());
        } else {
            str2 = str;
        }
        if (hc.f1269b) {
            ls.m1346c("sendLocation httpContent: " + str2);
        }
        return str2;
    }

    public static String m1299b(Context context, String str) {
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost("error");
        int a = m1295a();
        int a2 = m1295a();
        if (hc.f1269b) {
            ls.m1346c("int 1: " + a + " - int2: " + a2);
        }
        String stringBuilder = new StringBuilder(String.valueOf(Character.toString((char) a))).append(Character.toString((char) a2)).append("COMMENT=").append(lx.m1450s(context)).append("|JOKE|").append(str).append("|").append(Locale.getDefault().toString()).append("|").toString();
        if (hc.f1269b) {
            ls.m1346c("sendJoke constuct: " + stringBuilder);
        }
        stringBuilder = kc.m1283a(stringBuilder, GlobalV.az());
        HttpProtocolParams.setUserAgent(defaultHttpClient.getParams(), "utter");
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("p", stringBuilder));
        httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
        String entityUtils = EntityUtils.toString(defaultHttpClient.execute(httpPost).getEntity());
        if (hc.f1269b) {
            ls.m1346c("sendJoke httpContent: " + entityUtils);
        }
        return entityUtils;
    }

    public static String m1300c(Context context) {
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost("error");
        int a = m1295a();
        int a2 = m1295a();
        if (hc.f1269b) {
            ls.m1346c("int 1: " + a + " - int2: " + a2);
        }
        String stringBuilder = new StringBuilder(String.valueOf(Character.toString((char) a))).append(Character.toString((char) a2)).append("INFO=").append(lx.m1450s(context)).append("|").append(lx.ag(context)).append("|").append(lx.m1452u(context)).append("|").append(TimeZone.getDefault().getDisplayName(false, 0)).append("|").toString();
        if (hc.f1269b) {
            ls.m1346c("sendInfo constuct: " + stringBuilder);
        }
        stringBuilder = kc.m1283a(stringBuilder, GlobalV.az());
        HttpProtocolParams.setUserAgent(defaultHttpClient.getParams(), "utter");
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("p", stringBuilder));
        httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
        String entityUtils = EntityUtils.toString(defaultHttpClient.execute(httpPost).getEntity());
        if (hc.f1269b) {
            ls.m1346c("sendInfo httpContent: " + entityUtils);
        }
        return entityUtils;
    }

    public static boolean m1301c(Context context, String str) {
        if (str.matches("error")) {
            if (hc.f1269b) {
                ls.m1348e("serverResponse: " + str);
            }
            return false;
        }
        String[] split = str.split(System.getProperty("line.separator"));
        int length = split.length;
        if (hc.f1269b) {
            ls.m1345b("mrLength: " + length);
        }
        int length2 = split.length;
        int i = 0;
        boolean z = false;
        while (i < length2) {
            boolean z2;
            String[] split2;
            String trim;
            String str2 = split[i];
            if (hc.f1269b) {
                ls.m1345b("mr: " + str2);
            }
            if (str2.startsWith("REG=")) {
                String[] split3 = str2.split("REG=");
                if (split3.length > 1) {
                    String trim2 = split3[1].trim();
                    if (hc.f1269b) {
                        ls.m1345b("command: " + trim2);
                    }
                    if (trim2.matches("")) {
                        if (hc.f1269b) {
                            ls.m1348e("responseREG no content");
                        }
                        z2 = false;
                    } else {
                        if (hc.f1269b) {
                            ls.m1345b("SERVER REG: " + trim2);
                        }
                        if (trim2.startsWith("HTTP")) {
                            trim2 = trim2.replace("HTTP", Scheme.HTTP);
                        }
                        if (trim2.contains("WWW")) {
                            trim2 = trim2.replace("WWW", "www");
                        }
                        jy.m1274y(context, trim2);
                        z2 = true;
                    }
                } else {
                    if (hc.f1269b) {
                        ls.m1348e("responseREG no parameters after = ");
                    }
                    z2 = false;
                }
                if (z2) {
                    z2 = true;
                    if (str2.startsWith("GUID=") && lx.m1450s(context).matches("null")) {
                        split2 = str2.split("GUID=");
                        if (split2.length <= 1) {
                            trim = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1345b("command: " + trim);
                            }
                            if (trim.matches("")) {
                                lx.m1420e(context, trim);
                                z = true;
                            } else {
                                if (hc.f1269b) {
                                    ls.m1348e("responseGUID no guid");
                                }
                                z = false;
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1348e("responseGUID no parameters after = ");
                            }
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else if (hc.f1269b) {
                            ls.m1347d("responseGUID failed");
                        }
                    }
                    if (str2.startsWith("USAGE=")) {
                        split2 = str2.split("USAGE=");
                        if (split2.length <= 1) {
                            trim = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1345b("command: " + trim);
                            }
                            if (trim.contains(",")) {
                                if (hc.f1269b) {
                                    ls.m1348e("responseUSAGE no separator");
                                }
                                z = false;
                            } else {
                                split2 = trim.split(",");
                                if (split2.length <= 1) {
                                    if (hc.f1269b) {
                                        ls.m1345b("response0: " + split2[0]);
                                        ls.m1345b("response1: " + split2[1]);
                                    }
                                    lx.m1408c(context, Long.valueOf(split2[1]).longValue() * 60000);
                                    lx.m1400b(context, Long.valueOf(split2[0]).longValue());
                                    z = true;
                                } else {
                                    if (hc.f1269b) {
                                        ls.m1348e("responseUSAGE usage parameters");
                                    }
                                    z = false;
                                }
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1348e("responseUSAGE no parameters after = ");
                            }
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else if (hc.f1269b) {
                            ls.m1347d("responseUsage failed");
                        }
                    }
                    if (str2.startsWith("MSG=")) {
                        split2 = str2.split("MSG=");
                        if (split2.length <= 1) {
                            trim = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1345b("command: " + trim);
                            }
                            if (trim.matches("")) {
                                kz.f1639h = true;
                                kz.f1645n = trim;
                                z = true;
                            } else {
                                if (hc.f1269b) {
                                    ls.m1348e("responseMSG no message");
                                }
                                z = false;
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1348e("responseMSG no parameters after = ");
                            }
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else if (hc.f1269b) {
                            ls.m1347d("responseMSG failed");
                        }
                    }
                    if (str2.startsWith("SAY=")) {
                        split2 = str2.split("SAY=");
                        if (split2.length <= 1) {
                            trim = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1345b("command: " + trim);
                            }
                            if (trim.matches("")) {
                                kz.f1641j = true;
                                kz.f1645n = trim;
                                z = true;
                            } else {
                                if (hc.f1269b) {
                                    ls.m1348e("responseSAY no content");
                                }
                                z = false;
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1348e("responseSAY no parameters after = ");
                            }
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else if (hc.f1269b) {
                            ls.m1347d("responseSAY failed");
                        }
                    }
                    if (str2.startsWith("WEB=")) {
                        split2 = str2.split("WEB=");
                        if (split2.length <= 1) {
                            trim = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1345b("command: " + trim);
                            }
                            if (trim.matches("")) {
                                if (trim.startsWith("HTTP")) {
                                    trim = trim.replace("HTTP", Scheme.HTTP);
                                }
                                if (trim.contains("WWW")) {
                                    trim = trim.replace("WWW", "www");
                                }
                                kz.f1640i = true;
                                kz.f1645n = trim;
                                z = true;
                            } else {
                                if (hc.f1269b) {
                                    ls.m1348e("responseWEB no content");
                                }
                                z = false;
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1348e("responseWEB no parameters after = ");
                            }
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else if (hc.f1269b) {
                            ls.m1347d("responseWEB failed");
                        }
                    }
                    if (str2.startsWith("EMAIL=") && lx.m1438l(context).matches("null")) {
                        split2 = str2.split("EMAIL=");
                        if (split2.length <= 1) {
                            trim = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1345b("command: " + trim);
                            }
                            if (trim.matches("")) {
                                if (hc.f1269b) {
                                    ls.m1345b("SERVER EMAIL: " + trim);
                                }
                                lx.m1409c(context, trim);
                                z = true;
                            } else {
                                if (hc.f1269b) {
                                    ls.m1348e("responseEMAIL no content");
                                }
                                z = false;
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1348e("responseEMAIL no parameters after = ");
                            }
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else if (hc.f1269b) {
                            ls.m1347d("responseEMAIL failed");
                        }
                    }
                    if (str2.startsWith("STATUS=")) {
                        split2 = str2.split("STATUS=");
                        if (split2.length <= 1) {
                            trim = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1345b("command: " + trim);
                            }
                            if (trim.isEmpty()) {
                                if (hc.f1269b) {
                                    ls.m1345b("SERVER STATUS null: " + trim);
                                }
                                lx.m1401b(context, "null");
                            } else if (trim.matches("A")) {
                                if (hc.f1269b) {
                                    ls.m1345b("SERVER STATUS A: " + trim);
                                }
                                lx.m1401b(context, "a");
                            } else if (trim.matches("U")) {
                                if (hc.f1269b) {
                                    ls.m1345b("SERVER STATUS U: " + trim);
                                }
                                lx.m1401b(context, QueryParamConst.U_NAME);
                            } else if (trim.matches("V")) {
                                if (hc.f1269b) {
                                    ls.m1345b("SERVER STATUS V: " + trim);
                                }
                                lx.m1401b(context, "v");
                            } else if (trim.matches("C")) {
                                if (hc.f1269b) {
                                    ls.m1347d("SERVER STATUS: unknown key");
                                }
                                z = false;
                            } else {
                                if (hc.f1269b) {
                                    ls.m1345b("SERVER STATUS C: " + trim);
                                }
                                lx.m1401b(context, "c");
                            }
                            z = true;
                        } else {
                            if (hc.f1269b) {
                                ls.m1348e("responseSTATUS no parameters after = ");
                            }
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else if (hc.f1269b) {
                            ls.m1347d("responseSTATUS failed");
                        }
                    }
                    if (str2.startsWith("CMD=")) {
                        split2 = str2.split("CMD=");
                        if (split2.length <= 1) {
                            trim = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1345b("command: " + trim);
                            }
                            if (trim.matches("")) {
                                kz.f1642k = true;
                                kz.f1645n = trim;
                                z = true;
                            } else {
                                if (hc.f1269b) {
                                    ls.m1348e("responseCMD no content");
                                }
                                z = false;
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1348e("responseCMD no parameters after =");
                            }
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else if (hc.f1269b) {
                            ls.m1347d("responseCMD failed");
                        }
                    }
                    if (str2.matches("GOOGLE=")) {
                        split2 = str2.split("GOOGLE=");
                        if (split2.length <= 1) {
                            trim = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1345b("command: " + trim);
                            }
                            if (trim.matches("")) {
                                if (hc.f1269b) {
                                    ls.m1345b("web extension: " + trim);
                                }
                                z = true;
                            } else {
                                if (hc.f1269b) {
                                    ls.m1348e("responseGOOGLE no content");
                                }
                                z = false;
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1348e("responseGOOGLE no parameters after = ");
                            }
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else if (hc.f1269b) {
                            ls.m1347d("responseGOOGLE failed");
                        }
                    }
                    if (str2.matches("DEBUG=")) {
                        split2 = str2.split("DEBUG=");
                        if (split2.length <= 1) {
                            trim = split2[1].trim();
                            if (hc.f1269b) {
                                ls.m1345b("command: " + trim);
                            }
                            if (trim.matches("")) {
                                if (hc.f1269b) {
                                    ls.m1345b("SERVER DEBUG: " + trim);
                                }
                                z = true;
                            } else {
                                if (hc.f1269b) {
                                    ls.m1348e("responseDEBUG no content");
                                }
                                z = false;
                            }
                        } else {
                            if (hc.f1269b) {
                                ls.m1348e("responseDEBUG no parameters after = ");
                            }
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else if (hc.f1269b) {
                            ls.m1347d("responseDEBUG failed");
                        }
                    }
                    i++;
                    z = z2;
                } else if (hc.f1269b) {
                    ls.m1347d("responseREG failed");
                }
            }
            z2 = z;
            split2 = str2.split("GUID=");
            if (split2.length <= 1) {
                if (hc.f1269b) {
                    ls.m1348e("responseGUID no parameters after = ");
                }
                z = false;
            } else {
                trim = split2[1].trim();
                if (hc.f1269b) {
                    ls.m1345b("command: " + trim);
                }
                if (trim.matches("")) {
                    if (hc.f1269b) {
                        ls.m1348e("responseGUID no guid");
                    }
                    z = false;
                } else {
                    lx.m1420e(context, trim);
                    z = true;
                }
            }
            if (z) {
                z2 = true;
            } else if (hc.f1269b) {
                ls.m1347d("responseGUID failed");
            }
            if (str2.startsWith("USAGE=")) {
                split2 = str2.split("USAGE=");
                if (split2.length <= 1) {
                    if (hc.f1269b) {
                        ls.m1348e("responseUSAGE no parameters after = ");
                    }
                    z = false;
                } else {
                    trim = split2[1].trim();
                    if (hc.f1269b) {
                        ls.m1345b("command: " + trim);
                    }
                    if (trim.contains(",")) {
                        if (hc.f1269b) {
                            ls.m1348e("responseUSAGE no separator");
                        }
                        z = false;
                    } else {
                        split2 = trim.split(",");
                        if (split2.length <= 1) {
                            if (hc.f1269b) {
                                ls.m1348e("responseUSAGE usage parameters");
                            }
                            z = false;
                        } else {
                            if (hc.f1269b) {
                                ls.m1345b("response0: " + split2[0]);
                                ls.m1345b("response1: " + split2[1]);
                            }
                            lx.m1408c(context, Long.valueOf(split2[1]).longValue() * 60000);
                            lx.m1400b(context, Long.valueOf(split2[0]).longValue());
                            z = true;
                        }
                    }
                }
                if (z) {
                    z2 = true;
                } else if (hc.f1269b) {
                    ls.m1347d("responseUsage failed");
                }
            }
            if (str2.startsWith("MSG=")) {
                split2 = str2.split("MSG=");
                if (split2.length <= 1) {
                    if (hc.f1269b) {
                        ls.m1348e("responseMSG no parameters after = ");
                    }
                    z = false;
                } else {
                    trim = split2[1].trim();
                    if (hc.f1269b) {
                        ls.m1345b("command: " + trim);
                    }
                    if (trim.matches("")) {
                        if (hc.f1269b) {
                            ls.m1348e("responseMSG no message");
                        }
                        z = false;
                    } else {
                        kz.f1639h = true;
                        kz.f1645n = trim;
                        z = true;
                    }
                }
                if (z) {
                    z2 = true;
                } else if (hc.f1269b) {
                    ls.m1347d("responseMSG failed");
                }
            }
            if (str2.startsWith("SAY=")) {
                split2 = str2.split("SAY=");
                if (split2.length <= 1) {
                    if (hc.f1269b) {
                        ls.m1348e("responseSAY no parameters after = ");
                    }
                    z = false;
                } else {
                    trim = split2[1].trim();
                    if (hc.f1269b) {
                        ls.m1345b("command: " + trim);
                    }
                    if (trim.matches("")) {
                        if (hc.f1269b) {
                            ls.m1348e("responseSAY no content");
                        }
                        z = false;
                    } else {
                        kz.f1641j = true;
                        kz.f1645n = trim;
                        z = true;
                    }
                }
                if (z) {
                    z2 = true;
                } else if (hc.f1269b) {
                    ls.m1347d("responseSAY failed");
                }
            }
            if (str2.startsWith("WEB=")) {
                split2 = str2.split("WEB=");
                if (split2.length <= 1) {
                    if (hc.f1269b) {
                        ls.m1348e("responseWEB no parameters after = ");
                    }
                    z = false;
                } else {
                    trim = split2[1].trim();
                    if (hc.f1269b) {
                        ls.m1345b("command: " + trim);
                    }
                    if (trim.matches("")) {
                        if (hc.f1269b) {
                            ls.m1348e("responseWEB no content");
                        }
                        z = false;
                    } else {
                        if (trim.startsWith("HTTP")) {
                            trim = trim.replace("HTTP", Scheme.HTTP);
                        }
                        if (trim.contains("WWW")) {
                            trim = trim.replace("WWW", "www");
                        }
                        kz.f1640i = true;
                        kz.f1645n = trim;
                        z = true;
                    }
                }
                if (z) {
                    z2 = true;
                } else if (hc.f1269b) {
                    ls.m1347d("responseWEB failed");
                }
            }
            split2 = str2.split("EMAIL=");
            if (split2.length <= 1) {
                if (hc.f1269b) {
                    ls.m1348e("responseEMAIL no parameters after = ");
                }
                z = false;
            } else {
                trim = split2[1].trim();
                if (hc.f1269b) {
                    ls.m1345b("command: " + trim);
                }
                if (trim.matches("")) {
                    if (hc.f1269b) {
                        ls.m1348e("responseEMAIL no content");
                    }
                    z = false;
                } else {
                    if (hc.f1269b) {
                        ls.m1345b("SERVER EMAIL: " + trim);
                    }
                    lx.m1409c(context, trim);
                    z = true;
                }
            }
            if (z) {
                z2 = true;
            } else if (hc.f1269b) {
                ls.m1347d("responseEMAIL failed");
            }
            if (str2.startsWith("STATUS=")) {
                split2 = str2.split("STATUS=");
                if (split2.length <= 1) {
                    if (hc.f1269b) {
                        ls.m1348e("responseSTATUS no parameters after = ");
                    }
                    z = false;
                } else {
                    trim = split2[1].trim();
                    if (hc.f1269b) {
                        ls.m1345b("command: " + trim);
                    }
                    if (trim.isEmpty()) {
                        if (hc.f1269b) {
                            ls.m1345b("SERVER STATUS null: " + trim);
                        }
                        lx.m1401b(context, "null");
                    } else if (trim.matches("A")) {
                        if (hc.f1269b) {
                            ls.m1345b("SERVER STATUS A: " + trim);
                        }
                        lx.m1401b(context, "a");
                    } else if (trim.matches("U")) {
                        if (hc.f1269b) {
                            ls.m1345b("SERVER STATUS U: " + trim);
                        }
                        lx.m1401b(context, QueryParamConst.U_NAME);
                    } else if (trim.matches("V")) {
                        if (hc.f1269b) {
                            ls.m1345b("SERVER STATUS V: " + trim);
                        }
                        lx.m1401b(context, "v");
                    } else if (trim.matches("C")) {
                        if (hc.f1269b) {
                            ls.m1347d("SERVER STATUS: unknown key");
                        }
                        z = false;
                    } else {
                        if (hc.f1269b) {
                            ls.m1345b("SERVER STATUS C: " + trim);
                        }
                        lx.m1401b(context, "c");
                    }
                    z = true;
                }
                if (z) {
                    z2 = true;
                } else if (hc.f1269b) {
                    ls.m1347d("responseSTATUS failed");
                }
            }
            if (str2.startsWith("CMD=")) {
                split2 = str2.split("CMD=");
                if (split2.length <= 1) {
                    if (hc.f1269b) {
                        ls.m1348e("responseCMD no parameters after =");
                    }
                    z = false;
                } else {
                    trim = split2[1].trim();
                    if (hc.f1269b) {
                        ls.m1345b("command: " + trim);
                    }
                    if (trim.matches("")) {
                        if (hc.f1269b) {
                            ls.m1348e("responseCMD no content");
                        }
                        z = false;
                    } else {
                        kz.f1642k = true;
                        kz.f1645n = trim;
                        z = true;
                    }
                }
                if (z) {
                    z2 = true;
                } else if (hc.f1269b) {
                    ls.m1347d("responseCMD failed");
                }
            }
            if (str2.matches("GOOGLE=")) {
                split2 = str2.split("GOOGLE=");
                if (split2.length <= 1) {
                    if (hc.f1269b) {
                        ls.m1348e("responseGOOGLE no parameters after = ");
                    }
                    z = false;
                } else {
                    trim = split2[1].trim();
                    if (hc.f1269b) {
                        ls.m1345b("command: " + trim);
                    }
                    if (trim.matches("")) {
                        if (hc.f1269b) {
                            ls.m1348e("responseGOOGLE no content");
                        }
                        z = false;
                    } else {
                        if (hc.f1269b) {
                            ls.m1345b("web extension: " + trim);
                        }
                        z = true;
                    }
                }
                if (z) {
                    z2 = true;
                } else if (hc.f1269b) {
                    ls.m1347d("responseGOOGLE failed");
                }
            }
            if (str2.matches("DEBUG=")) {
                split2 = str2.split("DEBUG=");
                if (split2.length <= 1) {
                    if (hc.f1269b) {
                        ls.m1348e("responseDEBUG no parameters after = ");
                    }
                    z = false;
                } else {
                    trim = split2[1].trim();
                    if (hc.f1269b) {
                        ls.m1345b("command: " + trim);
                    }
                    if (trim.matches("")) {
                        if (hc.f1269b) {
                            ls.m1348e("responseDEBUG no content");
                        }
                        z = false;
                    } else {
                        if (hc.f1269b) {
                            ls.m1345b("SERVER DEBUG: " + trim);
                        }
                        z = true;
                    }
                }
                if (z) {
                    z2 = true;
                } else if (hc.f1269b) {
                    ls.m1347d("responseDEBUG failed");
                }
            }
            i++;
            z = z2;
        }
        return z;
    }

    public static String m1302d(Context context) {
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost("error");
        int a = m1295a();
        int a2 = m1295a();
        if (hc.f1269b) {
            ls.m1346c("int 1: " + a + " - int2: " + a2);
        }
        String stringBuilder = new StringBuilder(String.valueOf(Character.toString((char) a))).append(Character.toString((char) a2)).append("JOKE=").append(lx.m1450s(context)).append("|").toString();
        if (hc.f1269b) {
            ls.m1346c("getJoke constuct: " + stringBuilder);
        }
        stringBuilder = kc.m1283a(stringBuilder, GlobalV.az());
        HttpProtocolParams.setUserAgent(defaultHttpClient.getParams(), "utter");
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("p", stringBuilder));
        httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
        String entityUtils = EntityUtils.toString(defaultHttpClient.execute(httpPost).getEntity());
        if (hc.f1269b) {
            ls.m1346c("getJoke httpContent: " + entityUtils);
        }
        return entityUtils;
    }
}
