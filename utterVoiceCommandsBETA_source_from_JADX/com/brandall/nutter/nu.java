package com.brandall.nutter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class nu extends AsyncTask<Void, Void, Boolean> {
    Context f1804a;
    boolean f1805b = false;
    boolean f1806c = false;
    boolean f1807d = true;
    boolean f1808e = false;
    boolean f1809f = false;
    boolean f1810g = false;
    boolean f1811h = false;
    boolean f1812i = false;
    boolean f1813j = false;
    boolean f1814k = false;
    boolean f1815l = true;

    public nu(Context context) {
        this.f1804a = context;
    }

    private Boolean m1507a() {
        ls.m1346c("DIB XMLR");
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/utter/User_Commands/Backup.xml");
            if (file.exists()) {
                int i;
                Node item;
                Element element;
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
                parse.getDocumentElement().normalize();
                ls.m1345b("Root element :" + parse.getDocumentElement().getNodeName());
                NodeList elementsByTagName = parse.getElementsByTagName("phrase");
                NodeList elementsByTagName2 = parse.getElementsByTagName("substitute");
                ls.m1345b("-----------------------");
                for (i = 0; i < elementsByTagName2.getLength(); i++) {
                    item = elementsByTagName2.item(i);
                    if (item.getNodeType() == (short) 1) {
                        element = (Element) item;
                        arrayList5.add(m1508a("words", element));
                        arrayList6.add(m1508a("replace", element));
                        ls.m1345b("WORDS : " + m1508a("words", element));
                        ls.m1345b("REPLACE : " + m1508a("replace", element));
                        ls.m1345b("-----------------------");
                    }
                }
                ls.m1345b("-----------------------");
                for (i = 0; i < elementsByTagName.getLength(); i++) {
                    item = elementsByTagName.item(i);
                    if (item.getNodeType() == (short) 1) {
                        element = (Element) item;
                        arrayList.add(m1508a("user", element));
                        arrayList2.add(m1508a("utter", element));
                        arrayList3.add(m1508a("locale", element));
                        String a = m1508a("listen", element);
                        if (a.matches("true") || a.matches("false")) {
                            arrayList4.add(a);
                        } else {
                            arrayList4.add("false");
                        }
                        ls.m1345b("USER : " + m1508a("user", element));
                        ls.m1345b("UTTER : " + m1508a("utter", element));
                        ls.m1345b("LISTEN : " + m1508a("listen", element));
                        ls.m1345b("LOCALE : " + m1508a("locale", element));
                        ls.m1345b("-----------------------");
                    }
                }
                hk hkVar = new hk(this.f1804a);
                he heVar = new he(this.f1804a);
                if (arrayList.size() != arrayList2.size() || arrayList3.size() != arrayList4.size() || arrayList.size() != arrayList4.size()) {
                    this.f1809f = true;
                } else if (arrayList.isEmpty()) {
                    this.f1814k = true;
                } else if (!heVar.m1068a(arrayList, arrayList2, arrayList3, arrayList4)) {
                    this.f1811h = false;
                    return Boolean.valueOf(false);
                }
                if (arrayList5.size() != arrayList6.size()) {
                    this.f1810g = true;
                } else if (arrayList5.isEmpty()) {
                    this.f1813j = true;
                } else if (!hkVar.m1118a(arrayList5, arrayList6)) {
                    this.f1812i = false;
                    return Boolean.valueOf(false);
                }
                if (this.f1814k && this.f1813j) {
                    this.f1805b = true;
                    return Boolean.valueOf(false);
                }
                if (this.f1810g && this.f1809f) {
                    this.f1807d = true;
                } else if ((!this.f1810g && this.f1809f) || (this.f1810g && !this.f1809f)) {
                    this.f1815l = true;
                }
                ls.m1346c("XMLR elapsed: " + (System.currentTimeMillis() - currentTimeMillis));
                return Boolean.valueOf(true);
            }
            this.f1805b = true;
            return Boolean.valueOf(false);
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    private static String m1508a(String str, Element element) {
        Node item = element.getElementsByTagName(str).item(0).getChildNodes().item(0);
        if (item == null) {
            return "NULL";
        }
        String nodeValue = item.getNodeValue();
        return (nodeValue == null || nodeValue.isEmpty() || nodeValue.replaceAll("\\s", "").isEmpty()) ? "NULL" : nodeValue.trim();
    }

    private void m1509a(String str) {
        lc.m1313a(this.f1804a, false, str);
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m1507a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        ls.m1345b("XMLRestore onPostEx");
        try {
            ActivityCustomise.m525a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bool.booleanValue()) {
            m1509a("The restore completed successfully.");
            lx.m1439l(this.f1804a, true);
        } else if (this.f1805b) {
            m1509a("Sorry, but I didn't detect a back up file to import.");
        } else if (this.f1806c) {
            m1509a("Sorry, the back up failed due to an XML error");
        } else if (this.f1807d) {
            m1509a("Sorry, the back up failed due to corrupt user data");
        } else if (this.f1815l) {
            m1509a("Sorry, the back up only partially completed. Please validate the data in the back up file.");
        } else {
            m1509a("Sorry, but something went wrong");
        }
        super.onPostExecute(bool);
    }
}
