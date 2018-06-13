package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.dnd.peer.DropTargetContextPeer;
import java.nio.charset.Charset;
import org.apache.harmony.awt.internal.nls.Messages;
import org.apache.harmony.misc.SystemUtils;

public abstract class DTK {
    protected final DataTransferThread dataTransferThread = new DataTransferThread(this);
    private NativeClipboard nativeClipboard = null;
    private NativeClipboard nativeSelection = null;
    protected SystemFlavorMap systemFlavorMap;

    protected DTK() {
        this.dataTransferThread.start();
    }

    private static DTK createDTK() {
        String str;
        switch (SystemUtils.getOS()) {
            case 1:
                str = "org.apache.harmony.awt.datatransfer.windows.WinDTK";
                break;
            case 2:
                str = "org.apache.harmony.awt.datatransfer.linux.LinuxDTK";
                break;
            default:
                throw new RuntimeException(Messages.getString("awt.4E"));
        }
        try {
            return (DTK) Class.forName(str).newInstance();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.harmony.awt.datatransfer.DTK getDTK() {
        /*
        r1 = org.apache.harmony.awt.ContextStorage.getContextLock();
        monitor-enter(r1);
        r0 = org.apache.harmony.awt.ContextStorage.shutdownPending();	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x000e;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        r0 = 0;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = org.apache.harmony.awt.ContextStorage.getDTK();	 Catch:{ all -> 0x001d }
        if (r0 != 0) goto L_0x001b;
    L_0x0014:
        r0 = createDTK();	 Catch:{ all -> 0x001d }
        org.apache.harmony.awt.ContextStorage.setDTK(r0);	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x000d;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.awt.datatransfer.DTK.getDTK():org.apache.harmony.awt.datatransfer.DTK");
    }

    protected void appendSystemFlavorMap(SystemFlavorMap systemFlavorMap, DataFlavor dataFlavor, String str) {
        systemFlavorMap.addFlavorForUnencodedNative(str, dataFlavor);
        systemFlavorMap.addUnencodedNativeForFlavor(dataFlavor, str);
    }

    protected void appendSystemFlavorMap(SystemFlavorMap systemFlavorMap, String[] strArr, String str, String str2) {
        TextFlavor.addUnicodeClasses(systemFlavorMap, str2, str);
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i] != null && Charset.isSupported(strArr[i])) {
                TextFlavor.addCharsetClasses(systemFlavorMap, str2, str, strArr[i]);
            }
            i++;
        }
    }

    public abstract DragSourceContextPeer createDragSourceContextPeer(DragGestureEvent dragGestureEvent);

    public abstract DropTargetContextPeer createDropTargetContextPeer(DropTargetContext dropTargetContext);

    protected String[] getCharsets() {
        return new String[]{"UTF-16", "UTF-8", "unicode", "ISO-8859-1", "US-ASCII"};
    }

    public String getDefaultCharset() {
        return "unicode";
    }

    public NativeClipboard getNativeClipboard() {
        if (this.nativeClipboard == null) {
            this.nativeClipboard = newNativeClipboard();
        }
        return this.nativeClipboard;
    }

    public NativeClipboard getNativeSelection() {
        if (this.nativeSelection == null) {
            this.nativeSelection = newNativeSelection();
        }
        return this.nativeSelection;
    }

    public synchronized SystemFlavorMap getSystemFlavorMap() {
        return this.systemFlavorMap;
    }

    public abstract void initDragAndDrop();

    public void initSystemFlavorMap(SystemFlavorMap systemFlavorMap) {
        String[] charsets = getCharsets();
        appendSystemFlavorMap(systemFlavorMap, DataFlavor.stringFlavor, "text/plain");
        appendSystemFlavorMap(systemFlavorMap, charsets, "plain", "text/plain");
        appendSystemFlavorMap(systemFlavorMap, charsets, "html", "text/html");
        appendSystemFlavorMap(systemFlavorMap, DataProvider.urlFlavor, "application/x-java-url");
        appendSystemFlavorMap(systemFlavorMap, charsets, "uri-list", "application/x-java-url");
        appendSystemFlavorMap(systemFlavorMap, DataFlavor.javaFileListFlavor, "application/x-java-file-list");
        appendSystemFlavorMap(systemFlavorMap, DataFlavor.imageFlavor, "image/x-java-image");
    }

    protected abstract NativeClipboard newNativeClipboard();

    protected abstract NativeClipboard newNativeSelection();

    public abstract void runEventLoop();

    public synchronized void setSystemFlavorMap(SystemFlavorMap systemFlavorMap) {
        this.systemFlavorMap = systemFlavorMap;
    }
}
