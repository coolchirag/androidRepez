package com.brandall.nutter;

import android.content.Context;
import com.faceture.google.play.PropertyConsts;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class jl {
    public static jm m1210a(Context context, ArrayList<String> arrayList) {
        Locale locale = Locale.US;
        jl jlVar = new jl();
        jlVar.getClass();
        jm jmVar = new jm(jlVar);
        if (arrayList.isEmpty()) {
            ls.m1347d("Failed to find a match: ");
            jmVar.f1551e = "Sorry, but I couldn't find a match for the location you requested";
        } else {
            HttpClient defaultHttpClient = new DefaultHttpClient();
            jmVar.f1548b = "rS initialised";
            int i;
            try {
                HttpResponse execute = defaultHttpClient.execute(new HttpGet((String) arrayList.get(0)));
                ls.m1344a("Sending url: " + ((String) arrayList.get(0)));
                if (execute.getStatusLine().getStatusCode() == 200) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    execute.getEntity().writeTo(byteArrayOutputStream);
                    byteArrayOutputStream.close();
                    if (byteArrayOutputStream.toString() != null) {
                        ls.m1344a("DATA PULL: " + byteArrayOutputStream.toString());
                        if (byteArrayOutputStream.toString().contains("msg") || byteArrayOutputStream.toString().contains("interrupted")) {
                            ls.m1345b("MSG/INTERRUPT FAIL: ");
                        } else {
                            Document a = m1211a(byteArrayOutputStream.toString());
                            ls.m1346c("docint: " + Integer.valueOf(a.getElementsByTagName("weatherDesc").getLength()));
                            NodeList elementsByTagName = a.getElementsByTagName("temp_C");
                            jmVar.f1548b = elementsByTagName.item(0).getChildNodes().item(0).getNodeValue();
                            jmVar.f1549c = a.getElementsByTagName("temp_F").item(0).getChildNodes().item(0).getNodeValue();
                            jmVar.f1550d = a.getElementsByTagName("weatherDesc").item(0).getChildNodes().item(0).getNodeValue();
                            jmVar.f1547a = a.getElementsByTagName(PropertyConsts.QUERY).item(0).getChildNodes().item(0).getNodeValue();
                            ls.m1346c("Node Name: " + elementsByTagName.item(0).getNodeName());
                            ls.m1346c("childTag: " + elementsByTagName.item(0).getChildNodes().item(0).getNodeValue());
                        }
                    }
                    if (jmVar.f1548b == null) {
                        jmVar.f1548b = "nodes.item(0).getNodeValue(); returned null";
                        i = 0;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        ls.m1344a("rS OPE: " + jmVar.f1548b);
                        ls.m1344a("rS OPE: " + jmVar.f1549c);
                        ls.m1344a("rS OPE: " + jmVar.f1547a);
                        ls.m1344a("rS OPE: " + jmVar.f1550d);
                        if (!jmVar.f1548b.toLowerCase(locale).contains("rs") || jmVar.f1548b.length() <= 0 || jmVar.f1548b.toLowerCase(locale).contains("latlon")) {
                            ls.m1346c("OPE STOPPED " + jmVar.f1548b);
                            ls.m1346c("urlList Loop Restarted: ");
                            arrayList.remove(0);
                            m1210a(context, arrayList);
                        } else {
                            String str;
                            Object obj = "";
                            if (io.m1181a(jmVar.f1547a.toLowerCase(locale))) {
                                obj = "That's not the most pleasant of searches. Nevertheless. ";
                            }
                            if (jmVar.f1547a.contains("Lat") && jmVar.f1547a.contains("Lon")) {
                                ls.m1346c("Latitude Longitude: ");
                                str = "Outside it's ";
                            } else {
                                str = "In " + jmVar.f1547a + " it's ";
                            }
                            r2 = lx.m1449r(context).matches("c") ? jmVar.f1548b + " degrees celsius, " : lx.m1449r(context).matches("f") ? jmVar.f1549c + " degrees fahrenheit, " : jmVar.f1548b + " degrees celsius, that's " + jmVar.f1549c + " degrees fahrenheit, ";
                            if (jmVar.f1550d.toLowerCase(locale).contains("light rain shower")) {
                                jmVar.f1551e = new StringBuilder(String.valueOf(obj)).append(str).append(r2).append(" with a ").append(jmVar.f1550d).append(" around ").toString();
                            } else if (jmVar.f1550d.toLowerCase(locale).contains("light")) {
                                jmVar.f1551e = new StringBuilder(String.valueOf(obj)).append(str).append(r2).append(" and there's ").append(jmVar.f1550d).append(" around ").toString();
                            } else if (jmVar.f1550d.toLowerCase(locale).startsWith("patchy")) {
                                jmVar.f1551e = new StringBuilder(String.valueOf(obj)).append(str).append(r2).append(" and there's ").append(jmVar.f1550d).toString();
                            } else if (jmVar.f1550d.toLowerCase(locale).contains(" or ")) {
                                jmVar.f1551e = new StringBuilder(String.valueOf(obj)).append(str).append(r2).append(" with a ").append(jmVar.f1550d).append(" likely").toString();
                            } else if (jmVar.f1550d.toLowerCase(locale).startsWith("moderate") || jmVar.f1550d.toLowerCase(locale).startsWith("mist")) {
                                jmVar.f1551e = new StringBuilder(String.valueOf(obj)).append(str).append(r2).append(" with ").append(jmVar.f1550d).toString();
                            } else {
                                jmVar.f1551e = new StringBuilder(String.valueOf(obj)).append(str).append(r2).append(" and ").append(jmVar.f1550d).toString();
                            }
                        }
                    } else {
                        ls.m1347d("httpError: true");
                        jmVar.f1551e = "Sorry, but there was a network error.";
                    }
                } else {
                    jmVar.f1548b = "rs ELSE FAIL";
                    execute.getEntity().getContent().close();
                    i = 0;
                    if (i != 0) {
                        ls.m1347d("httpError: true");
                        jmVar.f1551e = "Sorry, but there was a network error.";
                    } else {
                        ls.m1344a("rS OPE: " + jmVar.f1548b);
                        ls.m1344a("rS OPE: " + jmVar.f1549c);
                        ls.m1344a("rS OPE: " + jmVar.f1547a);
                        ls.m1344a("rS OPE: " + jmVar.f1550d);
                        if (jmVar.f1548b.toLowerCase(locale).contains("rs")) {
                        }
                        ls.m1346c("OPE STOPPED " + jmVar.f1548b);
                        ls.m1346c("urlList Loop Restarted: ");
                        arrayList.remove(0);
                        m1210a(context, arrayList);
                    }
                }
            } catch (ClientProtocolException e) {
                jmVar.f1548b = "rs CATCH 1";
                ls.m1348e("ClientProtocolException:" + e);
                i = 1;
            } catch (IOException e2) {
                jmVar.f1548b = "rs CATCH 2";
                ls.m1348e("IOException" + e2);
                i = 1;
            }
        }
        ls.m1347d("Returning weatherProcess");
        ls.m1344a("rS OPE: " + jmVar.f1548b);
        ls.m1344a("rS OPE: " + jmVar.f1549c);
        ls.m1344a("rS OPE: " + jmVar.f1547a);
        ls.m1344a("rS OPE: " + jmVar.f1550d);
        return jmVar;
    }

    private static Document m1211a(String str) {
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
