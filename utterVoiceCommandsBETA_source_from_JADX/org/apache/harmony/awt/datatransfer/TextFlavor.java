package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class TextFlavor {
    public static final Class[] charsetTextClasses = new Class[]{InputStream.class, ByteBuffer.class, byte[].class};
    public static final Class[] unicodeTextClasses = new Class[]{String.class, Reader.class, CharBuffer.class, char[].class};

    public static void addCharsetClasses(SystemFlavorMap systemFlavorMap, String str, String str2, String str3) {
        for (Class name : charsetTextClasses) {
            String str4 = "text/" + str2;
            DataFlavor dataFlavor = new DataFlavor(new StringBuilder(String.valueOf(str4)).append(";class=\"" + name.getName() + "\";charset=\"" + str3 + "\"").toString(), str4);
            systemFlavorMap.addFlavorForUnencodedNative(str, dataFlavor);
            systemFlavorMap.addUnencodedNativeForFlavor(dataFlavor, str);
        }
    }

    public static void addUnicodeClasses(SystemFlavorMap systemFlavorMap, String str, String str2) {
        for (Class name : unicodeTextClasses) {
            String str3 = "text/" + str2;
            DataFlavor dataFlavor = new DataFlavor(new StringBuilder(String.valueOf(str3)).append(";class=\"" + name.getName() + "\"").toString(), str3);
            systemFlavorMap.addFlavorForUnencodedNative(str, dataFlavor);
            systemFlavorMap.addUnencodedNativeForFlavor(dataFlavor, str);
        }
    }
}
