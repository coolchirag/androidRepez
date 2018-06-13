package javax.activation;

import java.io.OutputStream;
import myjava.awt.datatransfer.DataFlavor;

public interface DataContentHandler {
    Object getContent(DataSource dataSource);

    Object getTransferData(DataFlavor dataFlavor, DataSource dataSource);

    DataFlavor[] getTransferDataFlavors();

    void writeTo(Object obj, String str, OutputStream outputStream);
}
