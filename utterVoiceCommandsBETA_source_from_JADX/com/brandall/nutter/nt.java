package com.brandall.nutter;

import android.os.Environment;
import android.util.Xml;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import org.xmlpull.v1.XmlSerializer;

public final class nt {
    public static boolean m1506a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, ArrayList<String> arrayList5, ArrayList<String> arrayList6) {
        File file = new File(Environment.getExternalStorageDirectory() + "/utter/User_Commands/Backup.xml");
        try {
            file.createNewFile();
            try {
                ListIterator listIterator;
                int nextIndex;
                String str;
                OutputStream fileOutputStream = new FileOutputStream(file);
                XmlSerializer newSerializer = Xml.newSerializer();
                newSerializer.setOutput(fileOutputStream, "UTF-8");
                newSerializer.startDocument(null, Boolean.valueOf(true));
                newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                newSerializer.startTag(null, "root");
                if (!(arrayList == null || arrayList2 == null || arrayList4 == null || arrayList3 == null)) {
                    listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        try {
                            nextIndex = listIterator.nextIndex();
                            str = ((String) listIterator.next()).toString();
                            ls.m1344a("rawpass: " + str);
                            newSerializer.startTag(null, "phrase");
                            newSerializer.startTag(null, "user");
                            newSerializer.text(str);
                            newSerializer.endTag(null, "user");
                            newSerializer.startTag(null, "utter");
                            newSerializer.text((String) arrayList2.get(nextIndex));
                            newSerializer.endTag(null, "utter");
                            newSerializer.startTag(null, "listen");
                            newSerializer.text((String) arrayList4.get(nextIndex));
                            newSerializer.endTag(null, "listen");
                            newSerializer.startTag(null, "locale");
                            newSerializer.text((String) arrayList3.get(nextIndex));
                            newSerializer.endTag(null, "locale");
                            newSerializer.endTag(null, "phrase");
                        } catch (Exception e) {
                            ls.m1348e("XML Exception - failed to create output");
                            e.printStackTrace();
                            return false;
                        }
                    }
                }
                if (!(arrayList5 == null || arrayList6 == null)) {
                    listIterator = arrayList5.listIterator();
                    while (listIterator.hasNext()) {
                        nextIndex = listIterator.nextIndex();
                        str = ((String) listIterator.next()).toString();
                        ls.m1344a("rawpass: " + str);
                        newSerializer.startTag(null, "substitute");
                        newSerializer.startTag(null, "words");
                        newSerializer.text(str);
                        newSerializer.endTag(null, "words");
                        newSerializer.startTag(null, "replace");
                        newSerializer.text((String) arrayList6.get(nextIndex));
                        newSerializer.endTag(null, "replace");
                        newSerializer.endTag(null, "substitute");
                    }
                }
                newSerializer.endTag(null, "root");
                newSerializer.endDocument();
                newSerializer.flush();
                fileOutputStream.close();
                return true;
            } catch (FileNotFoundException e2) {
                ls.m1348e("FileNotFoundException - can't create FileOutputStream");
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            ls.m1348e("IOException exception in createNewFile() method");
            return false;
        }
    }
}
