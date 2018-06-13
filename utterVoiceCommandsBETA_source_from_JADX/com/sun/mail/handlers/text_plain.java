package com.sun.mail.handlers;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeUtility;
import myjava.awt.datatransfer.DataFlavor;

public class text_plain implements DataContentHandler {
    private static ActivationDataFlavor myDF = new ActivationDataFlavor(String.class, "text/plain", "Text String");

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

    public Object getContent(DataSource dataSource) {
        String str = null;
        try {
            str = getCharset(dataSource.getContentType());
            Object inputStream = dataSource.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
            try {
                int i = 0;
                Object obj = new char[1024];
                while (true) {
                    int read = inputStreamReader.read(obj, i, obj.length - i);
                    if (read == -1) {
                        break;
                    }
                    inputStream = read + i;
                    if (inputStream >= obj.length) {
                        i = obj.length;
                        Object obj2 = new char[(i < 262144 ? i + i : i + 262144)];
                        System.arraycopy(obj, 0, obj2, 0, inputStream);
                        obj = obj2;
                        i = inputStream;
                    } else {
                        i = inputStream;
                    }
                }
                inputStream = new String(obj, 0, i);
                return inputStream;
            } finally {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                }
            }
        } catch (IllegalArgumentException e2) {
            throw new UnsupportedEncodingException(str);
        }
    }

    protected ActivationDataFlavor getDF() {
        return myDF;
    }

    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) {
        return getDF().equals(dataFlavor) ? getContent(dataSource) : null;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{getDF()};
    }

    public void writeTo(Object obj, String str, OutputStream outputStream) {
        if (obj instanceof String) {
            String str2 = null;
            try {
                str2 = getCharset(str);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, str2);
                String str3 = (String) obj;
                outputStreamWriter.write(str3, 0, str3.length());
                outputStreamWriter.flush();
                return;
            } catch (IllegalArgumentException e) {
                throw new UnsupportedEncodingException(str2);
            }
        }
        throw new IOException("\"" + getDF().getMimeType() + "\" DataContentHandler requires String object, was given object of type " + obj.getClass().toString());
    }
}
