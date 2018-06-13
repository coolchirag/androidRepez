package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DataSnapshot implements DataProvider {
    private final String[] fileList;
    private final String html;
    private final String[] nativeFormats;
    private final RawBitmap rawBitmap;
    private final Map<Class<?>, byte[]> serializedObjects = Collections.synchronizedMap(new HashMap());
    private final String text;
    private final String url;

    public DataSnapshot(DataProvider dataProvider) {
        this.nativeFormats = dataProvider.getNativeFormats();
        this.text = dataProvider.getText();
        this.fileList = dataProvider.getFileList();
        this.url = dataProvider.getURL();
        this.html = dataProvider.getHTML();
        this.rawBitmap = dataProvider.getRawBitmap();
        for (String decodeDataFlavor : this.nativeFormats) {
            DataFlavor dataFlavor = null;
            try {
                dataFlavor = SystemFlavorMap.decodeDataFlavor(decodeDataFlavor);
            } catch (ClassNotFoundException e) {
            }
            if (dataFlavor != null) {
                Class representationClass = dataFlavor.getRepresentationClass();
                Object serializedObject = dataProvider.getSerializedObject(representationClass);
                if (serializedObject != null) {
                    this.serializedObjects.put(representationClass, serializedObject);
                }
            }
        }
    }

    public String[] getFileList() {
        return this.fileList;
    }

    public String getHTML() {
        return this.html;
    }

    public String[] getNativeFormats() {
        return this.nativeFormats;
    }

    public RawBitmap getRawBitmap() {
        return this.rawBitmap;
    }

    public short[] getRawBitmapBuffer16() {
        return (this.rawBitmap == null || !(this.rawBitmap.buffer instanceof short[])) ? null : (short[]) this.rawBitmap.buffer;
    }

    public int[] getRawBitmapBuffer32() {
        return (this.rawBitmap == null || !(this.rawBitmap.buffer instanceof int[])) ? null : (int[]) this.rawBitmap.buffer;
    }

    public byte[] getRawBitmapBuffer8() {
        return (this.rawBitmap == null || !(this.rawBitmap.buffer instanceof byte[])) ? null : (byte[]) this.rawBitmap.buffer;
    }

    public int[] getRawBitmapHeader() {
        return this.rawBitmap != null ? this.rawBitmap.getHeader() : null;
    }

    public byte[] getSerializedObject(Class<?> cls) {
        return (byte[]) this.serializedObjects.get(cls);
    }

    public byte[] getSerializedObject(String str) {
        try {
            return getSerializedObject(SystemFlavorMap.decodeDataFlavor(str).getRepresentationClass());
        } catch (Exception e) {
            return null;
        }
    }

    public String getText() {
        return this.text;
    }

    public String getURL() {
        return this.url;
    }

    public boolean isNativeFormatAvailable(String str) {
        boolean z = false;
        if (str == null) {
            return z;
        }
        if (str.equals("text/plain")) {
            return this.text != null ? true : z;
        } else {
            if (str.equals("application/x-java-file-list")) {
                return this.fileList != null ? true : z;
            } else {
                if (str.equals("application/x-java-url")) {
                    return this.url != null ? true : z;
                } else {
                    if (str.equals("text/html")) {
                        return this.html != null ? true : z;
                    } else {
                        if (str.equals("image/x-java-image")) {
                            return this.rawBitmap != null ? true : z;
                        } else {
                            try {
                                return this.serializedObjects.containsKey(SystemFlavorMap.decodeDataFlavor(str).getRepresentationClass());
                            } catch (Exception e) {
                                return z;
                            }
                        }
                    }
                }
            }
        }
    }
}
