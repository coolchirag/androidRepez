package org.apache.harmony.awt.datatransfer;

import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.harmony.awt.internal.nls.Messages;

public final class DataProxy implements Transferable {
    public static final Class[] charsetTextClasses = new Class[]{byte[].class, ByteBuffer.class, InputStream.class};
    public static final Class[] unicodeTextClasses = new Class[]{String.class, Reader.class, CharBuffer.class, char[].class};
    private final DataProvider data;
    private final SystemFlavorMap flavorMap = ((SystemFlavorMap) SystemFlavorMap.getDefaultFlavorMap());

    public DataProxy(DataProvider dataProvider) {
        this.data = dataProvider;
    }

    private BufferedImage createBufferedImage(RawBitmap rawBitmap) {
        if (rawBitmap == null || rawBitmap.buffer == null || rawBitmap.width <= 0 || rawBitmap.height <= 0) {
            return null;
        }
        WritableRaster createPackedRaster;
        ColorModel colorModel;
        int[] iArr;
        DirectColorModel directColorModel;
        if (rawBitmap.bits == 32 && (rawBitmap.buffer instanceof int[])) {
            if (!isRGB(rawBitmap) && !isBGR(rawBitmap)) {
                return null;
            }
            iArr = new int[]{rawBitmap.rMask, rawBitmap.gMask, rawBitmap.bMask};
            int[] iArr2 = (int[]) rawBitmap.buffer;
            directColorModel = new DirectColorModel(24, rawBitmap.rMask, rawBitmap.gMask, rawBitmap.bMask);
            createPackedRaster = Raster.createPackedRaster(new DataBufferInt(iArr2, iArr2.length), rawBitmap.width, rawBitmap.height, rawBitmap.stride, iArr, null);
            colorModel = directColorModel;
        } else if (rawBitmap.bits == 24 && (rawBitmap.buffer instanceof byte[])) {
            int[] iArr3;
            int[] iArr4 = new int[]{8, 8, 8};
            int[] iArr5;
            if (isRGB(rawBitmap)) {
                iArr5 = new int[3];
                iArr5[1] = 1;
                iArr5[2] = 2;
                iArr3 = iArr5;
            } else if (!isBGR(rawBitmap)) {
                return null;
            } else {
                iArr5 = new int[3];
                iArr5[0] = 2;
                iArr5[1] = 1;
                iArr3 = iArr5;
            }
            byte[] bArr = (byte[]) rawBitmap.buffer;
            ComponentColorModel componentColorModel = new ComponentColorModel(ColorSpace.getInstance(1000), iArr4, false, false, 1, 0);
            createPackedRaster = Raster.createInterleavedRaster(new DataBufferByte(bArr, bArr.length), rawBitmap.width, rawBitmap.height, rawBitmap.stride, 3, iArr3, null);
            colorModel = componentColorModel;
        } else if ((rawBitmap.bits == 16 || rawBitmap.bits == 15) && (rawBitmap.buffer instanceof short[])) {
            iArr = new int[]{rawBitmap.rMask, rawBitmap.gMask, rawBitmap.bMask};
            short[] sArr = (short[]) rawBitmap.buffer;
            directColorModel = new DirectColorModel(rawBitmap.bits, rawBitmap.rMask, rawBitmap.gMask, rawBitmap.bMask);
            createPackedRaster = Raster.createPackedRaster(new DataBufferUShort(sArr, sArr.length), rawBitmap.width, rawBitmap.height, rawBitmap.stride, iArr, null);
            colorModel = directColorModel;
        } else {
            colorModel = null;
            createPackedRaster = null;
        }
        return (colorModel == null || createPackedRaster == null) ? null : new BufferedImage(colorModel, createPackedRaster, false, null);
    }

    private String getCharset(DataFlavor dataFlavor) {
        return dataFlavor.getParameter("charset");
    }

    private Object getFileList(DataFlavor dataFlavor) {
        if (this.data.isNativeFormatAvailable("application/x-java-file-list")) {
            String[] fileList = this.data.getFileList();
            if (fileList != null) {
                return Arrays.asList(fileList);
            }
            throw new IOException(Messages.getString("awt.4F"));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Object getHTML(DataFlavor dataFlavor) {
        if (this.data.isNativeFormatAvailable("text/html")) {
            String html = this.data.getHTML();
            if (html != null) {
                return getTextRepresentation(html, dataFlavor);
            }
            throw new IOException(Messages.getString("awt.4F"));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Image getImage(DataFlavor dataFlavor) {
        if (this.data.isNativeFormatAvailable("image/x-java-image")) {
            RawBitmap rawBitmap = this.data.getRawBitmap();
            if (rawBitmap != null) {
                return createBufferedImage(rawBitmap);
            }
            throw new IOException(Messages.getString("awt.4F"));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Object getPlainText(DataFlavor dataFlavor) {
        if (this.data.isNativeFormatAvailable("text/plain")) {
            String text = this.data.getText();
            if (text != null) {
                return getTextRepresentation(text, dataFlavor);
            }
            throw new IOException(Messages.getString("awt.4F"));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Object getSerializedObject(DataFlavor dataFlavor) {
        String encodeDataFlavor = SystemFlavorMap.encodeDataFlavor(dataFlavor);
        if (encodeDataFlavor == null || !this.data.isNativeFormatAvailable(encodeDataFlavor)) {
            throw new UnsupportedFlavorException(dataFlavor);
        }
        byte[] serializedObject = this.data.getSerializedObject(dataFlavor.getRepresentationClass());
        if (serializedObject == null) {
            throw new IOException(Messages.getString("awt.4F"));
        }
        try {
            return new ObjectInputStream(new ByteArrayInputStream(serializedObject)).readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e.getMessage());
        }
    }

    private Object getTextRepresentation(String str, DataFlavor dataFlavor) {
        if (dataFlavor.getRepresentationClass() == String.class) {
            return str;
        }
        if (dataFlavor.isRepresentationClassReader()) {
            return new StringReader(str);
        }
        if (dataFlavor.isRepresentationClassCharBuffer()) {
            return CharBuffer.wrap(str);
        }
        if (dataFlavor.getRepresentationClass() == char[].class) {
            Object obj = new char[str.length()];
            str.getChars(0, str.length(), obj, 0);
            return obj;
        }
        String charset = getCharset(dataFlavor);
        if (dataFlavor.getRepresentationClass() == byte[].class) {
            return str.getBytes(charset);
        }
        if (dataFlavor.isRepresentationClassByteBuffer()) {
            return ByteBuffer.wrap(str.getBytes(charset));
        }
        if (dataFlavor.isRepresentationClassInputStream()) {
            return new ByteArrayInputStream(str.getBytes(charset));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Object getURL(DataFlavor dataFlavor) {
        if (this.data.isNativeFormatAvailable("application/x-java-url")) {
            String url = this.data.getURL();
            if (url == null) {
                throw new IOException(Messages.getString("awt.4F"));
            }
            URL url2 = new URL(url);
            if (dataFlavor.getRepresentationClass().isAssignableFrom(URL.class)) {
                return url2;
            }
            if (dataFlavor.isFlavorTextType()) {
                return getTextRepresentation(url2.toString(), dataFlavor);
            }
            throw new UnsupportedFlavorException(dataFlavor);
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private boolean isBGR(RawBitmap rawBitmap) {
        return rawBitmap.rMask == 255 && rawBitmap.gMask == 65280 && rawBitmap.bMask == 16711680;
    }

    private boolean isRGB(RawBitmap rawBitmap) {
        return rawBitmap.rMask == 16711680 && rawBitmap.gMask == 65280 && rawBitmap.bMask == 255;
    }

    public final DataProvider getDataProvider() {
        return this.data;
    }

    public final Object getTransferData(DataFlavor dataFlavor) {
        String str = dataFlavor.getPrimaryType() + "/" + dataFlavor.getSubType();
        if (dataFlavor.isFlavorTextType()) {
            return str.equalsIgnoreCase("text/html") ? getHTML(dataFlavor) : str.equalsIgnoreCase(DataProvider.TYPE_URILIST) ? getURL(dataFlavor) : getPlainText(dataFlavor);
        } else {
            if (dataFlavor.isFlavorJavaFileListType()) {
                return getFileList(dataFlavor);
            }
            if (dataFlavor.isFlavorSerializedObjectType()) {
                return getSerializedObject(dataFlavor);
            }
            if (dataFlavor.equals(DataProvider.urlFlavor)) {
                return getURL(dataFlavor);
            }
            if (str.equalsIgnoreCase("image/x-java-image") && Image.class.isAssignableFrom(dataFlavor.getRepresentationClass())) {
                return getImage(dataFlavor);
            }
            throw new UnsupportedFlavorException(dataFlavor);
        }
    }

    public final DataFlavor[] getTransferDataFlavors() {
        ArrayList arrayList = new ArrayList();
        String[] nativeFormats = this.data.getNativeFormats();
        for (String flavorsForNative : nativeFormats) {
            for (DataFlavor dataFlavor : this.flavorMap.getFlavorsForNative(flavorsForNative)) {
                if (!arrayList.contains(dataFlavor)) {
                    arrayList.add(dataFlavor);
                }
            }
        }
        return (DataFlavor[]) arrayList.toArray(new DataFlavor[arrayList.size()]);
    }

    public final boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        DataFlavor[] transferDataFlavors = getTransferDataFlavors();
        for (DataFlavor equals : transferDataFlavors) {
            if (equals.equals(dataFlavor)) {
                return true;
            }
        }
        return false;
    }
}
