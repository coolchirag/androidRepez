package org.apache.harmony.awt.datatransfer;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataSource implements DataProvider {
    protected final Transferable contents;
    private DataFlavor[] flavors;
    private List<String> nativeFormats;

    public DataSource(Transferable transferable) {
        this.contents = transferable;
    }

    private RawBitmap getImageBitmap(Image image) {
        if (image instanceof BufferedImage) {
            BufferedImage bufferedImage = (BufferedImage) image;
            if (bufferedImage.getType() == 1) {
                return getImageBitmap32(bufferedImage);
            }
        }
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        if (width <= 0 || height <= 0) {
            return null;
        }
        BufferedImage bufferedImage2 = new BufferedImage(width, height, 1);
        Graphics graphics = bufferedImage2.getGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();
        return getImageBitmap32(bufferedImage2);
    }

    private RawBitmap getImageBitmap32(BufferedImage bufferedImage) {
        int i = 0;
        Object obj = new int[(bufferedImage.getWidth() * bufferedImage.getHeight())];
        DataBufferInt dataBufferInt = (DataBufferInt) bufferedImage.getRaster().getDataBuffer();
        int numBanks = dataBufferInt.getNumBanks();
        int[] offsets = dataBufferInt.getOffsets();
        int i2 = 0;
        while (i < numBanks) {
            Object data = dataBufferInt.getData(i);
            System.arraycopy(data, offsets[i], obj, i2, data.length - offsets[i]);
            i2 += data.length - offsets[i];
            i++;
        }
        return new RawBitmap(bufferedImage.getWidth(), bufferedImage.getHeight(), bufferedImage.getWidth(), 32, 16711680, 65280, 255, obj);
    }

    private static List<String> getNativesForFlavors(DataFlavor[] dataFlavorArr) {
        List arrayList = new ArrayList();
        SystemFlavorMap systemFlavorMap = (SystemFlavorMap) SystemFlavorMap.getDefaultFlavorMap();
        for (DataFlavor nativesForFlavor : dataFlavorArr) {
            for (String str : systemFlavorMap.getNativesForFlavor(nativesForFlavor)) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    private String getText(boolean z) {
        DataFlavor[] transferDataFlavors = this.contents.getTransferDataFlavors();
        for (DataFlavor dataFlavor : transferDataFlavors) {
            if (dataFlavor.isFlavorTextType() && (!z || isHtmlFlavor(dataFlavor))) {
                try {
                    return String.class.isAssignableFrom(dataFlavor.getRepresentationClass()) ? (String) this.contents.getTransferData(dataFlavor) : getTextFromReader(dataFlavor.getReaderForText(this.contents));
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    private String getTextFromReader(Reader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArr = new char[1024];
        while (true) {
            int read = reader.read(cArr);
            if (read <= 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    private boolean isHtmlFlavor(DataFlavor dataFlavor) {
        return "html".equalsIgnoreCase(dataFlavor.getSubType());
    }

    protected DataFlavor[] getDataFlavors() {
        if (this.flavors == null) {
            this.flavors = this.contents.getTransferDataFlavors();
        }
        return this.flavors;
    }

    public String[] getFileList() {
        try {
            List list = (List) this.contents.getTransferData(DataFlavor.javaFileListFlavor);
            return (String[]) list.toArray(new String[list.size()]);
        } catch (Exception e) {
            return null;
        }
    }

    public String getHTML() {
        return getText(true);
    }

    public String[] getNativeFormats() {
        return (String[]) getNativeFormatsList().toArray(new String[0]);
    }

    public List<String> getNativeFormatsList() {
        if (this.nativeFormats == null) {
            this.nativeFormats = getNativesForFlavors(getDataFlavors());
        }
        return this.nativeFormats;
    }

    public RawBitmap getRawBitmap() {
        DataFlavor[] transferDataFlavors = this.contents.getTransferDataFlavors();
        for (DataFlavor dataFlavor : transferDataFlavors) {
            Class representationClass = dataFlavor.getRepresentationClass();
            if (representationClass != null && Image.class.isAssignableFrom(representationClass) && (dataFlavor.isMimeTypeEqual(DataFlavor.imageFlavor) || dataFlavor.isFlavorSerializedObjectType())) {
                try {
                    return getImageBitmap((Image) this.contents.getTransferData(dataFlavor));
                } catch (Throwable th) {
                }
            }
        }
        return null;
    }

    public byte[] getSerializedObject(Class<?> cls) {
        try {
            Serializable serializable = (Serializable) this.contents.getTransferData(new DataFlavor(cls, null));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializable);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            return null;
        }
    }

    public String getText() {
        return getText(false);
    }

    public String getURL() {
        try {
            return ((URL) this.contents.getTransferData(urlFlavor)).toString();
        } catch (Exception e) {
            try {
                return ((URL) this.contents.getTransferData(uriFlavor)).toString();
            } catch (Exception e2) {
                try {
                    return new URL(getText()).toString();
                } catch (Exception e3) {
                    return null;
                }
            }
        }
    }

    public boolean isNativeFormatAvailable(String str) {
        return getNativeFormatsList().contains(str);
    }
}
