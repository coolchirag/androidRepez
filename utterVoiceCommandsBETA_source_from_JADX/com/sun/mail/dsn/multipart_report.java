package com.sun.mail.dsn;

import java.io.IOException;
import java.io.OutputStream;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import myjava.awt.datatransfer.DataFlavor;

public class multipart_report implements DataContentHandler {
    private ActivationDataFlavor myDF = new ActivationDataFlavor(MultipartReport.class, "multipart/report", "Multipart Report");

    public Object getContent(DataSource dataSource) {
        try {
            return new MultipartReport(dataSource);
        } catch (Throwable e) {
            IOException iOException = new IOException("Exception while constructing MultipartReport");
            iOException.initCause(e);
            throw iOException;
        }
    }

    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) {
        return this.myDF.equals(dataFlavor) ? getContent(dataSource) : null;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{this.myDF};
    }

    public void writeTo(Object obj, String str, OutputStream outputStream) {
        if (obj instanceof MultipartReport) {
            try {
                ((MultipartReport) obj).writeTo(outputStream);
            } catch (MessagingException e) {
                throw new IOException(e.toString());
            }
        }
    }
}
