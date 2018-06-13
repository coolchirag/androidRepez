package com.sun.mail.dsn;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeUtility;
import myjava.awt.datatransfer.DataFlavor;

public class text_rfc822headers implements DataContentHandler {
    private static ActivationDataFlavor myDF = new ActivationDataFlavor(MessageHeaders.class, "text/rfc822-headers", "RFC822 headers");
    private static ActivationDataFlavor myDFs = new ActivationDataFlavor(String.class, "text/rfc822-headers", "RFC822 headers");

    private String getCharset(String str) {
        try {
            String parameter = new ContentType(str).getParameter("charset");
            if (parameter == null) {
                parameter = "us-ascii";
            }
            return MimeUtility.javaCharset(parameter);
        } catch (Exception e) {
            return null;
        }
    }

    private Object getStringContent(DataSource dataSource) {
        String str = null;
        try {
            str = getCharset(dataSource.getContentType());
            InputStreamReader inputStreamReader = new InputStreamReader(dataSource.getInputStream(), str);
            Object obj = new char[1024];
            int i = 0;
            while (true) {
                int read = inputStreamReader.read(obj, i, obj.length - i);
                if (read == -1) {
                    return new String(obj, 0, i);
                }
                read += i;
                if (read >= obj.length) {
                    i = obj.length;
                    Object obj2 = new char[(i < 262144 ? i + i : i + 262144)];
                    System.arraycopy(obj, 0, obj2, 0, read);
                    obj = obj2;
                    i = read;
                } else {
                    i = read;
                }
            }
        } catch (IllegalArgumentException e) {
            throw new UnsupportedEncodingException(str);
        }
    }

    public Object getContent(DataSource dataSource) {
        try {
            return new MessageHeaders(dataSource.getInputStream());
        } catch (MessagingException e) {
            throw new IOException("Exception creating MessageHeaders: " + e);
        }
    }

    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) {
        return myDF.equals(dataFlavor) ? getContent(dataSource) : myDFs.equals(dataFlavor) ? getStringContent(dataSource) : null;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{myDF, myDFs};
    }

    public void writeTo(Object obj, String str, OutputStream outputStream) {
        if (obj instanceof MessageHeaders) {
            try {
                ((MessageHeaders) obj).writeTo(outputStream);
            } catch (MessagingException e) {
                Exception nextException = e.getNextException();
                if (nextException instanceof IOException) {
                    throw ((IOException) nextException);
                }
                throw new IOException("Exception writing headers: " + e);
            }
        } else if (obj instanceof String) {
            String str2 = null;
            try {
                str2 = getCharset(str);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, str2);
                String str3 = (String) obj;
                outputStreamWriter.write(str3, 0, str3.length());
                outputStreamWriter.flush();
            } catch (IllegalArgumentException e2) {
                throw new UnsupportedEncodingException(str2);
            }
        } else {
            throw new IOException("\"" + myDFs.getMimeType() + "\" DataContentHandler requires String object, was given object of type " + obj.getClass().toString());
        }
    }
}
