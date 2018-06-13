package com.brandall.nutter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class ii {
    public static ij m1172a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ii iiVar = new ii();
        iiVar.getClass();
        ij ijVar = new ij(iiVar);
        if (arrayList.isEmpty()) {
            ls.m1347d("No url information supplied");
            ijVar.f1445a = "error. No url information supplied";
        } else {
            ijVar.f1445a = "";
            try {
                HttpResponse execute = new DefaultHttpClient().execute(new HttpGet((String) arrayList.get(0)));
                ls.m1344a("Sending url: " + ((String) arrayList.get(0)));
                if (execute.getStatusLine().getStatusCode() == 200) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    execute.getEntity().writeTo(byteArrayOutputStream);
                    byteArrayOutputStream.close();
                    ls.m1344a("Full output: " + byteArrayOutputStream.toString());
                    Document a = m1173a(byteArrayOutputStream.toString());
                    NodeList elementsByTagName = a.getElementsByTagName("queryresult");
                    String nodeValue = elementsByTagName.item(0).getAttributes().getNamedItem("success").getNodeValue();
                    if (nodeValue.contains("true")) {
                        Object obj;
                        Object obj2;
                        Object obj3;
                        Object obj4;
                        Object obj5;
                        int i;
                        String toLowerCase;
                        int i2;
                        ls.m1346c("querySuccess: true");
                        String toLowerCase2 = elementsByTagName.item(0).getAttributes().getNamedItem("datatypes").getNodeValue().toLowerCase();
                        ls.m1344a("dataType: " + toLowerCase2);
                        if (toLowerCase2.contains("word")) {
                            obj = null;
                            obj2 = null;
                            obj3 = null;
                            obj4 = 1;
                            obj5 = null;
                        } else {
                            if (toLowerCase2.contains("math")) {
                                obj5 = null;
                                obj2 = null;
                                int i3 = 1;
                                obj4 = null;
                                obj = null;
                            } else {
                                if (toLowerCase2.contains("people")) {
                                    obj2 = null;
                                    obj3 = null;
                                    obj4 = null;
                                    int i4 = 1;
                                    obj5 = null;
                                } else {
                                    if (toLowerCase2.contains("astronomical")) {
                                        int i5 = 1;
                                        obj3 = null;
                                        obj4 = null;
                                        obj = null;
                                        obj5 = null;
                                    } else {
                                        if (toLowerCase2.contains("weather")) {
                                            obj2 = null;
                                            obj3 = null;
                                            obj4 = null;
                                            obj = null;
                                            int i6 = 1;
                                        } else {
                                            obj2 = null;
                                            obj3 = null;
                                            obj4 = null;
                                            obj = null;
                                            obj5 = null;
                                        }
                                    }
                                }
                            }
                        }
                        NodeList elementsByTagName2 = a.getElementsByTagName("pod");
                        int length = elementsByTagName2.getLength();
                        ls.m1344a("podCount: " + length);
                        for (i = 0; i < length; i++) {
                            if (elementsByTagName2.item(i) != null) {
                                toLowerCase = elementsByTagName2.item(i).getAttributes().getNamedItem("id").getNodeValue().toLowerCase();
                                ls.m1344a("idPod: " + toLowerCase);
                                arrayList4.add(toLowerCase);
                            }
                        }
                        ls.m1344a("podID: " + arrayList4.size() + " : " + arrayList4.toString());
                        NodeList elementsByTagName3 = a.getElementsByTagName("plaintext");
                        int length2 = elementsByTagName3.getLength();
                        ls.m1344a("plainTextCount: " + length2);
                        String str = "";
                        for (i2 = 0; i2 < length2; i2++) {
                            if (elementsByTagName3.item(i2).getChildNodes().item(0) != null) {
                                String[] split = elementsByTagName3.item(i2).getChildNodes().item(0).getNodeValue().split(System.getProperty("line.separator"));
                                int length3 = split.length;
                                str = "";
                                length = 0;
                                while (length < length3) {
                                    toLowerCase = split[length] + " ";
                                    ls.m1346c("passLine: " + toLowerCase);
                                    String replaceAll = toLowerCase.replaceAll(" \\| ", ". ").replaceAll(" ~~ ", " ").replaceAll("\\^", " to the power of ").replaceAll("\\(open curly double quote\\)", "\"").replaceAll("\\(close curly double quote\\)", "\"").replaceAll("sqrt", "square root");
                                    toLowerCase = new StringBuilder(String.valueOf(str)).append(replaceAll).toString();
                                    arrayList2.add(replaceAll);
                                    length++;
                                    str = toLowerCase;
                                }
                                arrayList3.add(new StringBuilder(String.valueOf(str)).append(".").toString());
                            }
                        }
                        ls.m1344a("plainTextData: " + arrayList2.size() + " : " + arrayList2.toString());
                        ls.m1344a("plainTextDataAppend: " + arrayList3.size() + " : " + arrayList3.toString());
                        ls.m1344a("appendPlainText: " + str);
                        if (arrayList2.isEmpty()) {
                            ijVar.f1445a = "error. Plain text data empty";
                        } else {
                            ls.m1346c("Structuring response");
                            Iterator it;
                            if (obj4 == null || !arrayList4.contains("definition:worddata") || arrayList2.size() <= 1) {
                                if (obj != null) {
                                    if (arrayList4.contains("basicinformation:peopledata")) {
                                        ls.m1345b("Structure: people && basicinformation:peopledata");
                                        it = arrayList2.iterator();
                                        while (it.hasNext()) {
                                            ijVar.f1445a += ((String) it.next());
                                        }
                                    }
                                }
                                if (obj3 != null) {
                                    if (arrayList4.contains("decimalapproximation") && arrayList2.size() > 1) {
                                        ls.m1345b("Structure: math && decimalaprox plainTextData.size >1");
                                        ListIterator listIterator = arrayList4.listIterator();
                                        String str2 = "";
                                        while (listIterator.hasNext()) {
                                            int nextIndex = listIterator.nextIndex();
                                            str = ((String) listIterator.next()).toString().toLowerCase().trim();
                                            ls.m1344a("podpass: " + str);
                                            if (str.matches("decimalapproximation")) {
                                                str2 = (String) arrayList3.get(nextIndex);
                                                break;
                                            }
                                        }
                                        ijVar.f1445a = new StringBuilder(String.valueOf((String) arrayList3.get(0))).append("equals, ").append(str2).toString();
                                    }
                                }
                                if (obj3 != null && arrayList2.size() > 1) {
                                    ls.m1345b("Structure: math && plainTextData.size >1");
                                    ijVar.f1445a = new StringBuilder(String.valueOf((String) arrayList2.get(0))).append("equals, ").append((String) arrayList2.get(1)).toString();
                                } else if (obj5 != null && arrayList2.size() > 3) {
                                    ls.m1345b("Structure: weather && plainTextData.size >1");
                                    ijVar.f1445a = new StringBuilder(String.valueOf((String) arrayList2.get(0))).append(" ").append((String) arrayList2.get(1)).append(". ").append((String) arrayList2.get(2)).append(". ").append((String) arrayList2.get(3)).toString();
                                } else if (obj2 != null && arrayList2.size() > 1) {
                                    ls.m1345b("Structure: astronomical && plainTextData.size >1");
                                    ijVar.f1445a = new StringBuilder(String.valueOf((String) arrayList2.get(0))).append(" ").append((String) arrayList2.get(1)).toString();
                                } else if (toLowerCase2.isEmpty()) {
                                    ls.m1345b("Structure: dataTypes empty");
                                    ijVar.f1445a = new StringBuilder(String.valueOf((String) arrayList2.get(0))).append(". ").append((String) arrayList2.get(1)).toString();
                                } else {
                                    ls.m1345b("Structure: Final - just allowing 2");
                                    if (arrayList2.size() > 1) {
                                        i = 0;
                                        ijVar.f1445a = "";
                                        length = 0;
                                        while (length < arrayList2.size()) {
                                            i2 = i + 1;
                                            if (i2 < 5) {
                                                ijVar.f1445a += ((String) arrayList2.get(length)) + ". ";
                                            }
                                            length++;
                                            i = i2;
                                        }
                                    } else {
                                        ls.m1347d("Structure: Final - data < 1");
                                        ijVar.f1445a = "error. Limited information";
                                    }
                                }
                            } else {
                                ls.m1345b("Structure: word && definition:worddata plainTextData>1");
                                str = new StringBuilder(String.valueOf(((String) arrayList2.get(0)).replaceFirst("\\(", "has ").replaceFirst("\\)", " origins."))).append(".").toString();
                                arrayList2.remove(0);
                                arrayList2.add(0, str);
                                it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    ijVar.f1445a += ((String) it.next());
                                }
                            }
                        }
                    } else {
                        ls.m1347d("querySuccess: " + nodeValue);
                        ijVar.f1445a = "Wolfram Alpha did not understand the question.";
                    }
                } else {
                    ijVar.f1445a = "H T T P error";
                }
            } catch (ClientProtocolException e) {
                ijVar.f1445a = "error. Client Protocol Exception";
                ls.m1348e("ClientProtocolException");
                e.printStackTrace();
            } catch (IOException e2) {
                ijVar.f1445a = "error. IO Exception";
                ls.m1348e("IOException");
                e2.printStackTrace();
            }
        }
        return ijVar;
    }

    private static Document m1173a(String str) {
        Document document = null;
        ls.m1346c("Document wolframString");
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
