package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;
import myjava.awt.datatransfer.DataFlavor;
import myjava.awt.datatransfer.Transferable;

public class DataHandler implements Transferable {
    private static final DataFlavor[] emptyFlavors = new DataFlavor[0];
    private static DataContentHandlerFactory factory = null;
    private CommandMap currentCommandMap = null;
    private DataContentHandler dataContentHandler = null;
    private DataSource dataSource = null;
    private DataContentHandler factoryDCH = null;
    private DataSource objDataSource = null;
    private Object object = null;
    private String objectMimeType = null;
    private DataContentHandlerFactory oldFactory = null;
    private String shortType = null;
    private DataFlavor[] transferFlavors = emptyFlavors;

    public DataHandler(Object obj, String str) {
        this.object = obj;
        this.objectMimeType = str;
        this.oldFactory = factory;
    }

    public DataHandler(URL url) {
        this.dataSource = new URLDataSource(url);
        this.oldFactory = factory;
    }

    public DataHandler(DataSource dataSource) {
        this.dataSource = dataSource;
        this.oldFactory = factory;
    }

    private synchronized String getBaseType() {
        if (this.shortType == null) {
            String contentType = getContentType();
            try {
                this.shortType = new MimeType(contentType).getBaseType();
            } catch (MimeTypeParseException e) {
                this.shortType = contentType;
            }
        }
        return this.shortType;
    }

    private synchronized CommandMap getCommandMap() {
        return this.currentCommandMap != null ? this.currentCommandMap : CommandMap.getDefaultCommandMap();
    }

    private synchronized DataContentHandler getDataContentHandler() {
        DataContentHandler dataContentHandler;
        if (factory != this.oldFactory) {
            this.oldFactory = factory;
            this.factoryDCH = null;
            this.dataContentHandler = null;
            this.transferFlavors = emptyFlavors;
        }
        if (this.dataContentHandler != null) {
            dataContentHandler = this.dataContentHandler;
        } else {
            String baseType = getBaseType();
            if (this.factoryDCH == null && factory != null) {
                this.factoryDCH = factory.createDataContentHandler(baseType);
            }
            if (this.factoryDCH != null) {
                this.dataContentHandler = this.factoryDCH;
            }
            if (this.dataContentHandler == null) {
                if (this.dataSource != null) {
                    this.dataContentHandler = getCommandMap().createDataContentHandler(baseType, this.dataSource);
                } else {
                    this.dataContentHandler = getCommandMap().createDataContentHandler(baseType);
                }
            }
            if (this.dataSource != null) {
                this.dataContentHandler = new DataSourceDataContentHandler(this.dataContentHandler, this.dataSource);
            } else {
                this.dataContentHandler = new ObjectDataContentHandler(this.dataContentHandler, this.object, this.objectMimeType);
            }
            dataContentHandler = this.dataContentHandler;
        }
        return dataContentHandler;
    }

    public static synchronized void setDataContentHandlerFactory(DataContentHandlerFactory dataContentHandlerFactory) {
        synchronized (DataHandler.class) {
            if (factory != null) {
                throw new Error("DataContentHandlerFactory already defined");
            }
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                try {
                    securityManager.checkSetFactory();
                } catch (SecurityException e) {
                    if (DataHandler.class.getClassLoader() != dataContentHandlerFactory.getClass().getClassLoader()) {
                        throw e;
                    }
                }
            }
            factory = dataContentHandlerFactory;
        }
    }

    public CommandInfo[] getAllCommands() {
        return this.dataSource != null ? getCommandMap().getAllCommands(getBaseType(), this.dataSource) : getCommandMap().getAllCommands(getBaseType());
    }

    public Object getBean(CommandInfo commandInfo) {
        Object obj = null;
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            obj = commandInfo.getCommandObject(this, contextClassLoader);
        } catch (IOException e) {
        } catch (ClassNotFoundException e2) {
        }
        return obj;
    }

    public CommandInfo getCommand(String str) {
        return this.dataSource != null ? getCommandMap().getCommand(getBaseType(), str, this.dataSource) : getCommandMap().getCommand(getBaseType(), str);
    }

    public Object getContent() {
        return this.object != null ? this.object : getDataContentHandler().getContent(getDataSource());
    }

    public String getContentType() {
        return this.dataSource != null ? this.dataSource.getContentType() : this.objectMimeType;
    }

    public DataSource getDataSource() {
        if (this.dataSource != null) {
            return this.dataSource;
        }
        if (this.objDataSource == null) {
            this.objDataSource = new DataHandlerDataSource(this);
        }
        return this.objDataSource;
    }

    public InputStream getInputStream() {
        if (this.dataSource != null) {
            return this.dataSource.getInputStream();
        }
        final DataContentHandler dataContentHandler = getDataContentHandler();
        if (dataContentHandler == null) {
            throw new UnsupportedDataTypeException("no DCH for MIME type " + getBaseType());
        } else if ((dataContentHandler instanceof ObjectDataContentHandler) && ((ObjectDataContentHandler) dataContentHandler).getDCH() == null) {
            throw new UnsupportedDataTypeException("no object DCH for MIME type " + getBaseType());
        } else {
            final PipedOutputStream pipedOutputStream = new PipedOutputStream();
            InputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
            new Thread(new Runnable() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    r4 = this;
                    r0 = r1;	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                    r1 = javax.activation.DataHandler.this;	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                    r1 = r1.object;	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                    r2 = javax.activation.DataHandler.this;	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                    r2 = r2.objectMimeType;	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                    r3 = r2;	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                    r0.writeTo(r1, r2, r3);	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                    r0 = r2;	 Catch:{ IOException -> 0x0029 }
                    r0.close();	 Catch:{ IOException -> 0x0029 }
                L_0x0018:
                    return;
                L_0x0019:
                    r0 = move-exception;
                    r0 = r2;	 Catch:{ IOException -> 0x0020 }
                    r0.close();	 Catch:{ IOException -> 0x0020 }
                    goto L_0x0018;
                L_0x0020:
                    r0 = move-exception;
                    goto L_0x0018;
                L_0x0022:
                    r0 = move-exception;
                    r1 = r2;	 Catch:{ IOException -> 0x002b }
                    r1.close();	 Catch:{ IOException -> 0x002b }
                L_0x0028:
                    throw r0;
                L_0x0029:
                    r0 = move-exception;
                    goto L_0x0018;
                L_0x002b:
                    r1 = move-exception;
                    goto L_0x0028;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: javax.activation.DataHandler.1.run():void");
                }
            }, "DataHandler.getInputStream").start();
            return pipedInputStream;
        }
    }

    public String getName() {
        return this.dataSource != null ? this.dataSource.getName() : null;
    }

    public OutputStream getOutputStream() {
        return this.dataSource != null ? this.dataSource.getOutputStream() : null;
    }

    public CommandInfo[] getPreferredCommands() {
        return this.dataSource != null ? getCommandMap().getPreferredCommands(getBaseType(), this.dataSource) : getCommandMap().getPreferredCommands(getBaseType());
    }

    public Object getTransferData(DataFlavor dataFlavor) {
        return getDataContentHandler().getTransferData(dataFlavor, this.dataSource);
    }

    public synchronized DataFlavor[] getTransferDataFlavors() {
        if (factory != this.oldFactory) {
            this.transferFlavors = emptyFlavors;
        }
        if (this.transferFlavors == emptyFlavors) {
            this.transferFlavors = getDataContentHandler().getTransferDataFlavors();
        }
        return this.transferFlavors;
    }

    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        DataFlavor[] transferDataFlavors = getTransferDataFlavors();
        for (DataFlavor equals : transferDataFlavors) {
            if (equals.equals(dataFlavor)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void setCommandMap(CommandMap commandMap) {
        if (commandMap != this.currentCommandMap || commandMap == null) {
            this.transferFlavors = emptyFlavors;
            this.dataContentHandler = null;
            this.currentCommandMap = commandMap;
        }
    }

    public void writeTo(OutputStream outputStream) {
        if (this.dataSource != null) {
            byte[] bArr = new byte[8192];
            InputStream inputStream = this.dataSource.getInputStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                try {
                    outputStream.write(bArr, 0, read);
                } finally {
                    inputStream.close();
                }
            }
            return;
        }
        getDataContentHandler().writeTo(this.object, this.objectMimeType, outputStream);
    }
}
