package com.brandall.nutter;

import android.content.Context;
import com.faceture.google.play.PropertyConsts;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.ispeech.core.InternalResources;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class jh {
    public static int f1535a = 0;
    public static int f1536b = 0;
    public static String f1537c = "null";
    public static String f1538d = "null";
    public static String f1539e = "null";
    public static String f1540f = "null";

    public static ji m1202a(Context context, ArrayList<String> arrayList) {
        jh jhVar = new jh();
        jhVar.getClass();
        ji jiVar = new ji(jhVar);
        if (arrayList.isEmpty()) {
            ls.m1347d("Failed to find a match: ");
            jiVar.f1543c = "Sorry, but I couldn't find a match for the location you requested";
        } else {
            HttpClient defaultHttpClient = new DefaultHttpClient();
            jiVar.f1541a = "rS initialised";
            int i;
            try {
                HttpResponse execute = defaultHttpClient.execute(new HttpGet((String) arrayList.get(0)));
                ls.m1344a("Sending url: " + ((String) arrayList.get(0)));
                if (execute.getStatusLine().getStatusCode() == 200) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    execute.getEntity().writeTo(byteArrayOutputStream);
                    byteArrayOutputStream.close();
                    ls.m1344a("DATA PULL: " + byteArrayOutputStream.toString());
                    if (byteArrayOutputStream.toString().contains("msg") || byteArrayOutputStream.toString().contains("interrupted")) {
                        ls.m1345b("MSG/INTERRUPT FAIL: ");
                    } else if (byteArrayOutputStream.toString().toLowerCase().contains("latlon")) {
                        ls.m1345b("Latitude Longitude detected: ");
                        jiVar.f1541a = "latlon";
                    } else {
                        Document a = m1204a(byteArrayOutputStream.toString());
                        ls.m1346c("docint: " + Integer.valueOf(a.getElementsByTagName("localtime").getLength()));
                        NodeList elementsByTagName = a.getElementsByTagName("localtime");
                        jiVar.f1541a = elementsByTagName.item(0).getChildNodes().item(0).getNodeValue();
                        jiVar.f1542b = a.getElementsByTagName(PropertyConsts.QUERY).item(0).getChildNodes().item(0).getNodeValue();
                        ls.m1344a("Node Name: " + elementsByTagName.item(0).getNodeName());
                        ls.m1344a("childTag: " + elementsByTagName.item(0).getChildNodes().item(0).getNodeValue());
                    }
                    if (jiVar.f1541a == null) {
                        jiVar.f1541a = "nodes.item(0).getNodeValue(); returned null";
                        i = 0;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        ls.m1344a("rS OPE: " + jiVar.f1541a);
                        ls.m1344a("rS OPE: " + jiVar.f1542b);
                        if (!jiVar.f1541a.toLowerCase().contains("rs") || jiVar.f1541a.length() <= 0 || jiVar.f1541a.toLowerCase().contains("latlon")) {
                            ls.m1346c("OPE STOPPED " + jiVar.f1541a);
                            if (jiVar.f1541a.toLowerCase().contains("latlon")) {
                                ls.m1346c("urlList Loop Restarted: ");
                                arrayList.remove(0);
                                m1202a(context, arrayList);
                            } else {
                                ls.m1346c("Latitude Longitude speak: ");
                                jiVar.f1543c = "Sorry. Latitude and Longitude requests, are not yet implemented";
                            }
                        } else {
                            String[] split = jiVar.f1541a.split("\\s+")[1].split(":");
                            f1538d = split[1];
                            f1537c = split[0];
                            ls.m1344a("hour: " + f1537c + " min: " + f1538d);
                            f1535a = Integer.parseInt(f1538d);
                            f1536b = Integer.parseInt(f1537c);
                            f1540f = "";
                            if (f1536b < 12) {
                                if (f1536b == 0) {
                                    f1537c = "12";
                                } else if (f1536b == 1) {
                                    f1537c = "1";
                                } else if (f1536b == 2) {
                                    f1537c = "2";
                                } else if (f1536b == 3) {
                                    f1537c = "3";
                                } else if (f1536b == 4) {
                                    f1537c = "4";
                                } else if (f1536b == 5) {
                                    f1537c = "5";
                                } else if (f1536b == 6) {
                                    f1537c = "6";
                                } else if (f1536b == 7) {
                                    f1537c = "7";
                                } else if (f1536b == 8) {
                                    f1537c = "8";
                                } else if (f1536b == 9) {
                                    f1537c = "9";
                                }
                                f1540f = " in the morning";
                            } else if (f1536b > 11 && f1536b < 19) {
                                if (f1536b == 13) {
                                    f1537c = "1";
                                } else if (f1536b == 14) {
                                    f1537c = "2";
                                } else if (f1536b == 15) {
                                    f1537c = "3";
                                } else if (f1536b == 16) {
                                    f1537c = "4";
                                } else if (f1536b == 17) {
                                    f1537c = "5";
                                } else if (f1536b == 18) {
                                    f1537c = "6";
                                }
                                f1540f = " in the afternoon";
                            } else if (f1536b <= 18 || f1536b >= 24) {
                                f1540f = "";
                            } else {
                                if (f1536b == 19) {
                                    f1537c = "7";
                                } else if (f1536b == 20) {
                                    f1537c = "8";
                                } else if (f1536b == 21) {
                                    f1537c = "9";
                                } else if (f1536b == 22) {
                                    f1537c = "10";
                                } else if (f1536b == 23) {
                                    f1537c = "11";
                                } else if (f1536b == 18) {
                                    f1537c = "6";
                                }
                                f1540f = " in the evening";
                            }
                            if (f1535a == 0) {
                                f1538d = " O'clock";
                            }
                            Object obj = "";
                            if (io.m1181a(jiVar.f1542b.toLowerCase())) {
                                obj = "That's not the most pleasant of searches. Nevertheless. ";
                            }
                            jiVar.f1543c = new StringBuilder(String.valueOf(obj)).append("The time in ").append(jiVar.f1542b).append(" is ").append(f1537c).append(" ").append(f1538d).append(f1540f).toString();
                        }
                    } else {
                        ls.m1347d("httpError: true");
                        jiVar.f1543c = "Sorry, but there was a network error.";
                    }
                } else {
                    jiVar.f1541a = "rs ELSE FAIL";
                    execute.getEntity().getContent().close();
                    i = 0;
                    if (i != 0) {
                        ls.m1347d("httpError: true");
                        jiVar.f1543c = "Sorry, but there was a network error.";
                    } else {
                        ls.m1344a("rS OPE: " + jiVar.f1541a);
                        ls.m1344a("rS OPE: " + jiVar.f1542b);
                        if (jiVar.f1541a.toLowerCase().contains("rs")) {
                        }
                        ls.m1346c("OPE STOPPED " + jiVar.f1541a);
                        if (jiVar.f1541a.toLowerCase().contains("latlon")) {
                            ls.m1346c("urlList Loop Restarted: ");
                            arrayList.remove(0);
                            m1202a(context, arrayList);
                        } else {
                            ls.m1346c("Latitude Longitude speak: ");
                            jiVar.f1543c = "Sorry. Latitude and Longitude requests, are not yet implemented";
                        }
                    }
                }
            } catch (ClientProtocolException e) {
                jiVar.f1541a = "rs CATCH 1";
                ls.m1348e("ClientProtocolException:" + e);
                i = 1;
            } catch (IOException e2) {
                jiVar.f1541a = "rs CATCH 2";
                ls.m1348e("IOException" + e2);
                i = 1;
            }
        }
        return jiVar;
    }

    public static String m1203a() {
        int i;
        int i2 = 1;
        ls.m1346c("getTime");
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(InternalResources.ISPEECH_SCREEN_AD_HEIGHT);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("m");
        f1537c = simpleDateFormat.format(instance.getTime());
        String format = simpleDateFormat2.format(instance.getTime());
        f1538d = format;
        f1535a = Integer.parseInt(format);
        f1536b = Integer.parseInt(f1537c);
        ls.m1346c("formatTime");
        String str = "";
        if (f1535a == 1) {
            ls.m1346c("MIN 1");
            f1538d += " minute past";
            f1539e = "mh";
        }
        if (f1535a == 5 || f1535a == 10 || f1535a == 20 || f1535a == 25) {
            ls.m1346c("MIN 5/10/15/20");
            f1538d += " past";
            f1539e = "mh";
        }
        if (f1535a == 15) {
            ls.m1346c("MIN 15");
            f1538d = "quarter past";
            f1539e = "mh";
        }
        if (f1535a == 30) {
            ls.m1346c("MIN 30");
            f1538d = "half past";
            f1539e = "mh";
        }
        if (!(f1535a <= 1 || f1535a >= 30 || f1535a == 5 || f1535a == 10 || f1535a == 15 || f1535a == 20 || f1535a == 25)) {
            ls.m1346c("MIN 2-29");
            f1538d += " minutes past";
            f1539e = "mh";
        }
        if (!(f1535a <= 30 || f1535a >= 50 || f1535a == 35 || f1535a == 40 || f1535a == 45)) {
            ls.m1346c("MIN 31-49");
            f1539e = "hm";
        }
        if (f1535a == 35) {
            ls.m1346c("MIN 35");
            f1538d = "25 to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 40) {
            ls.m1346c("MIN 40");
            f1538d = "20 to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 45) {
            ls.m1346c("MIN 45");
            f1538d = "quarter to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 50) {
            ls.m1346c("MIN 50");
            f1538d = "10 to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 51) {
            ls.m1346c("MIN 51");
            f1538d = "9 minutes to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 52) {
            ls.m1346c("MIN 52");
            f1538d = "8 minutes to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 53) {
            ls.m1346c("MIN 53");
            f1538d = "7 minutes to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 54) {
            ls.m1346c("MIN 54");
            f1538d = "6 minutes to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 55) {
            ls.m1346c("MIN 55");
            f1538d = "5 to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 56) {
            ls.m1346c("MIN 56");
            f1538d = "4 minutes to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 57) {
            ls.m1346c("MIN 53");
            f1538d = "3 minutes to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 58) {
            ls.m1346c("MIN 53");
            f1538d = "2 minutes to";
            i = f1536b + 1;
            if (i == 13) {
                i = 1;
            }
            f1537c = Integer.toString(i);
            f1539e = "mh";
        }
        if (f1535a == 59) {
            ls.m1346c("MIN 53");
            f1538d = "1 minute to";
            i = f1536b + 1;
            if (i != 13) {
                i2 = i;
            }
            f1537c = Integer.toString(i2);
            f1539e = "mh";
        }
        if (f1535a == 0 || f1535a == 0) {
            ls.m1346c("MIN 00");
            f1538d = " O'clock";
            f1537c = "exactly " + f1537c;
            f1539e = "hm";
        }
        if (f1539e.matches("mh")) {
            ls.m1346c("mh: " + f1538d + f1537c);
            format = "It's " + f1538d + " " + f1537c;
        } else {
            format = str;
        }
        if (!f1539e.matches("hm")) {
            return format;
        }
        ls.m1346c("hm: " + f1537c + f1538d);
        return "It's " + f1537c + " " + f1538d;
    }

    private static Document m1204a(String str) {
        Document document = null;
        ls.m1346c("DB");
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new StringReader(str));
            document = newDocumentBuilder.parse(inputSource);
        } catch (ParserConfigurationException e) {
            ls.m1348e("XML parse error: " + e.getMessage());
        } catch (SAXException e2) {
            ls.m1348e("Wrong XML file structure: " + e2.getMessage());
        } catch (IOException e3) {
            ls.m1348e("IOException: " + e3.getMessage());
        }
        return document;
    }
}
