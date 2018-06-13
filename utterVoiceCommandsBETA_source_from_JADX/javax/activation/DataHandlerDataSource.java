package javax.activation;

import java.io.InputStream;
import java.io.OutputStream;

class DataHandlerDataSource implements DataSource {
    DataHandler dataHandler = null;

    public DataHandlerDataSource(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public String getContentType() {
        return this.dataHandler.getContentType();
    }

    public InputStream getInputStream() {
        return this.dataHandler.getInputStream();
    }

    public String getName() {
        return this.dataHandler.getName();
    }

    public OutputStream getOutputStream() {
        return this.dataHandler.getOutputStream();
    }
}
