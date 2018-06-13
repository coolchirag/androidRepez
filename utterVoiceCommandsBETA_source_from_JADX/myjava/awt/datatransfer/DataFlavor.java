package myjava.awt.datatransfer;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.Externalizable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.harmony.awt.datatransfer.DTK;
import org.apache.harmony.awt.datatransfer.DataProvider;
import org.apache.harmony.awt.internal.nls.Messages;
import org.ispeech.core.HttpRequestParams;

public class DataFlavor implements Externalizable, Cloneable {
    public static final DataFlavor javaFileListFlavor = new DataFlavor("application/x-java-file-list; class=java.util.List", "application/x-java-file-list");
    public static final String javaJVMLocalObjectMimeType = "application/x-java-jvm-local-objectref";
    public static final String javaRemoteObjectMimeType = "application/x-java-remote-object";
    public static final String javaSerializedObjectMimeType = "application/x-java-serialized-object";
    @Deprecated
    public static final DataFlavor plainTextFlavor = new DataFlavor("text/plain; charset=unicode; class=java.io.InputStream", "Plain Text");
    private static DataFlavor plainUnicodeFlavor = null;
    private static final long serialVersionUID = 8367026044764648243L;
    private static final String[] sortedTextFlavors = new String[]{"text/sgml", "text/xml", "text/html", "text/rtf", "text/enriched", "text/richtext", DataProvider.TYPE_URILIST, "text/tab-separated-values", "text/t140", "text/rfc822-headers", "text/parityfec", "text/directory", "text/css", "text/calendar", "application/x-java-serialized-object", "text/plain"};
    public static final DataFlavor stringFlavor = new DataFlavor("application/x-java-serialized-object; class=java.lang.String", "Unicode String");
    private String humanPresentableName;
    private MimeType mimeInfo;
    private Class<?> representationClass;

    public DataFlavor() {
        this.mimeInfo = null;
        this.humanPresentableName = null;
        this.representationClass = null;
    }

    public DataFlavor(Class<?> cls, String str) {
        this.mimeInfo = new MimeType("application", "x-java-serialized-object");
        if (str != null) {
            this.humanPresentableName = str;
        } else {
            this.humanPresentableName = "application/x-java-serialized-object";
        }
        this.mimeInfo.addParameter("class", cls.getName());
        this.representationClass = cls;
    }

    public DataFlavor(String str) {
        init(str, null, null);
    }

    public DataFlavor(String str, String str2) {
        try {
            init(str, str2, null);
        } catch (Throwable e) {
            throw new IllegalArgumentException(Messages.getString("awt.16C", this.mimeInfo.getParameter("class")), e);
        }
    }

    public DataFlavor(String str, String str2, ClassLoader classLoader) {
        init(str, str2, classLoader);
    }

    private static List<DataFlavor> fetchTextFlavors(List<DataFlavor> list, String str) {
        LinkedList linkedList = new LinkedList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DataFlavor dataFlavor = (DataFlavor) it.next();
            if (!dataFlavor.isFlavorTextType()) {
                it.remove();
            } else if (dataFlavor.mimeInfo.getFullType().equals(str)) {
                if (!linkedList.contains(dataFlavor)) {
                    linkedList.add(dataFlavor);
                }
                it.remove();
            }
        }
        return linkedList.isEmpty() ? null : linkedList;
    }

    private String getCharset() {
        if (this.mimeInfo == null || isCharsetRedundant()) {
            return "";
        }
        String parameter = this.mimeInfo.getParameter("charset");
        return (isCharsetRequired() && (parameter == null || parameter.length() == 0)) ? DTK.getDTK().getDefaultCharset() : parameter == null ? "" : parameter;
    }

    private static List<DataFlavor> getFlavors(List<DataFlavor> list, Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        for (DataFlavor dataFlavor : list) {
            if (dataFlavor.representationClass.equals(cls)) {
                linkedList.add(dataFlavor);
            }
        }
        return linkedList.isEmpty() ? null : list;
    }

    private static List<DataFlavor> getFlavors(List<DataFlavor> list, String[] strArr) {
        LinkedList linkedList = new LinkedList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DataFlavor dataFlavor = (DataFlavor) it.next();
            if (isCharsetSupported(dataFlavor.getCharset())) {
                for (String forName : strArr) {
                    if (Charset.forName(forName).equals(Charset.forName(dataFlavor.getCharset()))) {
                        linkedList.add(dataFlavor);
                    }
                }
            } else {
                it.remove();
            }
        }
        return linkedList.isEmpty() ? null : list;
    }

    private String getKeyInfo() {
        String stringBuilder = new StringBuilder(String.valueOf(this.mimeInfo.getFullType())).append(";class=").append(this.representationClass.getName()).toString();
        return (!this.mimeInfo.getPrimaryType().equals(HttpRequestParams.TEXT) || isUnicodeFlavor()) ? stringBuilder : new StringBuilder(String.valueOf(stringBuilder)).append(";charset=").append(getCharset().toLowerCase()).toString();
    }

    public static final DataFlavor getTextPlainUnicodeFlavor() {
        if (plainUnicodeFlavor == null) {
            plainUnicodeFlavor = new DataFlavor("text/plain; charset=" + DTK.getDTK().getDefaultCharset() + "; class=java.io.InputStream", "Plain Text");
        }
        return plainUnicodeFlavor;
    }

    private void init(String str, String str2, ClassLoader classLoader) {
        try {
            this.mimeInfo = MimeTypeProcessor.parse(str);
            if (str2 != null) {
                this.humanPresentableName = str2;
            } else {
                this.humanPresentableName = new StringBuilder(String.valueOf(this.mimeInfo.getPrimaryType())).append('/').append(this.mimeInfo.getSubType()).toString();
            }
            String parameter = this.mimeInfo.getParameter("class");
            if (parameter == null) {
                parameter = "java.io.InputStream";
                this.mimeInfo.addParameter("class", parameter);
            }
            this.representationClass = classLoader == null ? Class.forName(parameter) : classLoader.loadClass(parameter);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Messages.getString("awt.16D", (Object) str));
        }
    }

    private boolean isByteCodeFlavor() {
        return this.representationClass != null && (this.representationClass.equals(InputStream.class) || this.representationClass.equals(ByteBuffer.class) || this.representationClass.equals(byte[].class));
    }

    private boolean isCharsetRedundant() {
        String fullType = this.mimeInfo.getFullType();
        return fullType.equals("text/rtf") || fullType.equals("text/tab-separated-values") || fullType.equals("text/t140") || fullType.equals("text/rfc822-headers") || fullType.equals("text/parityfec");
    }

    private boolean isCharsetRequired() {
        String fullType = this.mimeInfo.getFullType();
        return fullType.equals("text/sgml") || fullType.equals("text/xml") || fullType.equals("text/html") || fullType.equals("text/enriched") || fullType.equals("text/richtext") || fullType.equals(DataProvider.TYPE_URILIST) || fullType.equals("text/directory") || fullType.equals("text/css") || fullType.equals("text/calendar") || fullType.equals("application/x-java-serialized-object") || fullType.equals("text/plain");
    }

    private static boolean isCharsetSupported(String str) {
        try {
            return Charset.isSupported(str);
        } catch (IllegalCharsetNameException e) {
            return false;
        }
    }

    private boolean isUnicodeFlavor() {
        return this.representationClass != null && (this.representationClass.equals(Reader.class) || this.representationClass.equals(String.class) || this.representationClass.equals(CharBuffer.class) || this.representationClass.equals(char[].class));
    }

    private static List<DataFlavor> selectBestByAlphabet(List<DataFlavor> list) {
        String[] strArr = new String[list.size()];
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = ((DataFlavor) list.get(i)).getCharset();
        }
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        for (DataFlavor dataFlavor : list) {
            if (strArr[0].equalsIgnoreCase(dataFlavor.getCharset())) {
                linkedList.add(dataFlavor);
            }
        }
        return linkedList.isEmpty() ? null : linkedList;
    }

    private static DataFlavor selectBestByCharset(List<DataFlavor> list) {
        List flavors = getFlavors((List) list, new String[]{"UTF-16", "UTF-8", "UTF-16BE", "UTF-16LE"});
        if (flavors == null) {
            flavors = getFlavors((List) list, new String[]{DTK.getDTK().getDefaultCharset()});
            if (flavors == null) {
                flavors = getFlavors((List) list, new String[]{"US-ASCII"});
                if (flavors == null) {
                    flavors = selectBestByAlphabet(list);
                }
            }
        }
        return flavors != null ? flavors.size() == 1 ? (DataFlavor) flavors.get(0) : selectBestFlavorWOCharset(flavors) : null;
    }

    private static DataFlavor selectBestFlavorWCharset(List<DataFlavor> list) {
        List flavors = getFlavors((List) list, Reader.class);
        if (flavors != null) {
            return (DataFlavor) flavors.get(0);
        }
        flavors = getFlavors((List) list, String.class);
        if (flavors != null) {
            return (DataFlavor) flavors.get(0);
        }
        flavors = getFlavors((List) list, CharBuffer.class);
        if (flavors != null) {
            return (DataFlavor) flavors.get(0);
        }
        flavors = getFlavors((List) list, char[].class);
        return flavors != null ? (DataFlavor) flavors.get(0) : selectBestByCharset(list);
    }

    private static DataFlavor selectBestFlavorWOCharset(List<DataFlavor> list) {
        List flavors = getFlavors((List) list, InputStream.class);
        if (flavors != null) {
            return (DataFlavor) flavors.get(0);
        }
        flavors = getFlavors((List) list, ByteBuffer.class);
        if (flavors != null) {
            return (DataFlavor) flavors.get(0);
        }
        flavors = getFlavors((List) list, byte[].class);
        return flavors != null ? (DataFlavor) flavors.get(0) : (DataFlavor) list.get(0);
    }

    public static final DataFlavor selectBestTextFlavor(DataFlavor[] dataFlavorArr) {
        if (dataFlavorArr == null) {
            return null;
        }
        List sortTextFlavorsByType = sortTextFlavorsByType(new LinkedList(Arrays.asList(dataFlavorArr)));
        if (sortTextFlavorsByType.isEmpty()) {
            return null;
        }
        List list = (List) sortTextFlavorsByType.get(0);
        return list.size() == 1 ? (DataFlavor) list.get(0) : ((DataFlavor) list.get(0)).getCharset().length() == 0 ? selectBestFlavorWOCharset(list) : selectBestFlavorWCharset(list);
    }

    private static List<List<DataFlavor>> sortTextFlavorsByType(List<DataFlavor> list) {
        List linkedList = new LinkedList();
        for (String fetchTextFlavors : sortedTextFlavors) {
            List fetchTextFlavors2 = fetchTextFlavors(list, fetchTextFlavors);
            if (fetchTextFlavors2 != null) {
                linkedList.addLast(fetchTextFlavors2);
            }
        }
        if (!list.isEmpty()) {
            linkedList.addLast(list);
        }
        return linkedList;
    }

    protected static final Class<?> tryToLoadClass(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            try {
                return ClassLoader.getSystemClassLoader().loadClass(str);
            } catch (ClassNotFoundException e2) {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null) {
                    try {
                        return contextClassLoader.loadClass(str);
                    } catch (ClassNotFoundException e3) {
                        return classLoader.loadClass(str);
                    }
                }
                return classLoader.loadClass(str);
            }
        }
    }

    public Object clone() {
        DataFlavor dataFlavor = new DataFlavor();
        dataFlavor.humanPresentableName = this.humanPresentableName;
        dataFlavor.representationClass = this.representationClass;
        dataFlavor.mimeInfo = this.mimeInfo != null ? (MimeType) this.mimeInfo.clone() : null;
        return dataFlavor;
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof DataFlavor)) ? false : equals((DataFlavor) obj);
    }

    @Deprecated
    public boolean equals(String str) {
        return str == null ? false : isMimeTypeEqual(str);
    }

    public boolean equals(DataFlavor dataFlavor) {
        if (dataFlavor == this) {
            return true;
        }
        if (dataFlavor == null) {
            return false;
        }
        if (this.mimeInfo == null) {
            return dataFlavor.mimeInfo == null;
        } else {
            if (!this.mimeInfo.equals(dataFlavor.mimeInfo) || !this.representationClass.equals(dataFlavor.representationClass)) {
                return false;
            }
            if (!this.mimeInfo.getPrimaryType().equals(HttpRequestParams.TEXT) || isUnicodeFlavor()) {
                return true;
            }
            String charset = getCharset();
            String charset2 = dataFlavor.getCharset();
            return (isCharsetSupported(charset) && isCharsetSupported(charset2)) ? Charset.forName(charset).equals(Charset.forName(charset2)) : charset.equalsIgnoreCase(charset2);
        }
    }

    public final Class<?> getDefaultRepresentationClass() {
        return InputStream.class;
    }

    public final String getDefaultRepresentationClassAsString() {
        return getDefaultRepresentationClass().getName();
    }

    public String getHumanPresentableName() {
        return this.humanPresentableName;
    }

    MimeType getMimeInfo() {
        return this.mimeInfo;
    }

    public String getMimeType() {
        return this.mimeInfo != null ? MimeTypeProcessor.assemble(this.mimeInfo) : null;
    }

    public String getParameter(String str) {
        String toLowerCase = str.toLowerCase();
        return toLowerCase.equals("humanpresentablename") ? this.humanPresentableName : this.mimeInfo != null ? this.mimeInfo.getParameter(toLowerCase) : null;
    }

    public String getPrimaryType() {
        return this.mimeInfo != null ? this.mimeInfo.getPrimaryType() : null;
    }

    public Reader getReaderForText(Transferable transferable) {
        Object transferData = transferable.getTransferData(this);
        if (transferData == null) {
            throw new IllegalArgumentException(Messages.getString("awt.16E"));
        } else if (transferData instanceof Reader) {
            Reader reader = (Reader) transferData;
            reader.reset();
            return reader;
        } else if (transferData instanceof String) {
            return new StringReader((String) transferData);
        } else {
            if (transferData instanceof CharBuffer) {
                return new CharArrayReader(((CharBuffer) transferData).array());
            }
            if (transferData instanceof char[]) {
                return new CharArrayReader((char[]) transferData);
            }
            InputStream inputStream;
            String charset = getCharset();
            if (transferData instanceof InputStream) {
                inputStream = (InputStream) transferData;
                inputStream.reset();
            } else if (transferData instanceof ByteBuffer) {
                inputStream = new ByteArrayInputStream(((ByteBuffer) transferData).array());
            } else if (transferData instanceof byte[]) {
                inputStream = new ByteArrayInputStream((byte[]) transferData);
            } else {
                throw new IllegalArgumentException(Messages.getString("awt.16F"));
            }
            return charset.length() == 0 ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, charset);
        }
    }

    public Class<?> getRepresentationClass() {
        return this.representationClass;
    }

    public String getSubType() {
        return this.mimeInfo != null ? this.mimeInfo.getSubType() : null;
    }

    public int hashCode() {
        return getKeyInfo().hashCode();
    }

    public boolean isFlavorJavaFileListType() {
        return List.class.isAssignableFrom(this.representationClass) && isMimeTypeEqual(javaFileListFlavor);
    }

    public boolean isFlavorRemoteObjectType() {
        return isMimeTypeEqual(javaRemoteObjectMimeType) && isRepresentationClassRemote();
    }

    public boolean isFlavorSerializedObjectType() {
        return isMimeTypeSerializedObject() && isRepresentationClassSerializable();
    }

    public boolean isFlavorTextType() {
        if (equals(stringFlavor) || equals(plainTextFlavor)) {
            return true;
        }
        if (this.mimeInfo != null && !this.mimeInfo.getPrimaryType().equals(HttpRequestParams.TEXT)) {
            return false;
        }
        String charset = getCharset();
        return isByteCodeFlavor() ? charset.length() != 0 ? isCharsetSupported(charset) : true : isUnicodeFlavor();
    }

    public boolean isMimeTypeEqual(String str) {
        try {
            return this.mimeInfo.equals(MimeTypeProcessor.parse(str));
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public final boolean isMimeTypeEqual(DataFlavor dataFlavor) {
        return this.mimeInfo != null ? this.mimeInfo.equals(dataFlavor.mimeInfo) : dataFlavor.mimeInfo == null;
    }

    public boolean isMimeTypeSerializedObject() {
        return isMimeTypeEqual("application/x-java-serialized-object");
    }

    public boolean isRepresentationClassByteBuffer() {
        return ByteBuffer.class.isAssignableFrom(this.representationClass);
    }

    public boolean isRepresentationClassCharBuffer() {
        return CharBuffer.class.isAssignableFrom(this.representationClass);
    }

    public boolean isRepresentationClassInputStream() {
        return InputStream.class.isAssignableFrom(this.representationClass);
    }

    public boolean isRepresentationClassReader() {
        return Reader.class.isAssignableFrom(this.representationClass);
    }

    public boolean isRepresentationClassRemote() {
        return false;
    }

    public boolean isRepresentationClassSerializable() {
        return Serializable.class.isAssignableFrom(this.representationClass);
    }

    public boolean match(DataFlavor dataFlavor) {
        return equals(dataFlavor);
    }

    @Deprecated
    protected String normalizeMimeType(String str) {
        return str;
    }

    @Deprecated
    protected String normalizeMimeTypeParameter(String str, String str2) {
        return str2;
    }

    public synchronized void readExternal(ObjectInput objectInput) {
        this.humanPresentableName = (String) objectInput.readObject();
        this.mimeInfo = (MimeType) objectInput.readObject();
        this.representationClass = this.mimeInfo != null ? Class.forName(this.mimeInfo.getParameter("class")) : null;
    }

    public void setHumanPresentableName(String str) {
        this.humanPresentableName = str;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getName())).append("[MimeType=(").append(getMimeType()).append(");humanPresentableName=").append(this.humanPresentableName).append("]").toString();
    }

    public synchronized void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.humanPresentableName);
        objectOutput.writeObject(this.mimeInfo);
    }
}
