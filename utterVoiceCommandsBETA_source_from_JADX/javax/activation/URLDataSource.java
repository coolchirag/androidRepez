package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDataSource implements DataSource {
    private URL url = null;
    private URLConnection url_conn = null;

    public URLDataSource(URL url) {
        this.url = url;
    }

    public String getContentType() {
        String str = null;
        try {
            if (this.url_conn == null) {
                this.url_conn = this.url.openConnection();
            }
        } catch (IOException e) {
        }
        if (this.url_conn != null) {
            str = this.url_conn.getContentType();
        }
        return str == null ? "application/octet-stream" : str;
    }

    public InputStream getInputStream() {
        return this.url.openStream();
    }

    public String getName() {
        return this.url.getFile();
    }

    public OutputStream getOutputStream() {
        this.url_conn = this.url.openConnection();
        if (this.url_conn == null) {
            return null;
        }
        this.url_conn.setDoOutput(true);
        return this.url_conn.getOutputStream();
    }

    public URL getURL() {
        return this.url;
    }
}
