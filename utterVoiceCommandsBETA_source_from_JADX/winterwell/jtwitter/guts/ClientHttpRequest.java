package winterwell.jtwitter.guts;

import com.faceture.google.play.HeaderName;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Random;

public class ClientHttpRequest extends Observable {
    private static Random random = new Random();
    String boundary;
    private int bytesSent;
    URLConnection connection;
    Map<String, String> cookies;
    private boolean isCanceled;
    OutputStream os;
    String rawCookies;

    public ClientHttpRequest(String str) {
        this(new URL(str));
    }

    public ClientHttpRequest(URL url) {
        this(url.openConnection());
    }

    public ClientHttpRequest(URLConnection uRLConnection) {
        this.os = null;
        this.cookies = new HashMap();
        this.rawCookies = "";
        this.boundary = "---------------------------" + randomString() + randomString() + randomString();
        this.isCanceled = false;
        this.bytesSent = 0;
        this.connection = uRLConnection;
        uRLConnection.setDoOutput(true);
        uRLConnection.setDoInput(true);
        uRLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.boundary);
    }

    private void boundary() {
        write("--");
        write(this.boundary);
    }

    private long boundaryNumBytes() {
        return (long) (this.boundary.length() + 2);
    }

    private InputStream doPost() {
        boundary();
        writeln("--");
        this.os.close();
        return this.connection.getInputStream();
    }

    private synchronized void pipe(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        this.bytesSent = 0;
        this.isCanceled = false;
        synchronized (inputStream) {
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read < 0) {
                } else {
                    outputStream.write(bArr, 0, read);
                    this.bytesSent = read + this.bytesSent;
                    if (this.isCanceled) {
                        throw new IOException("Canceled");
                    }
                    outputStream.flush();
                    setChanged();
                    notifyObservers(Integer.valueOf(this.bytesSent));
                    clearChanged();
                }
            }
        }
        outputStream.flush();
    }

    public static InputStream post(URL url, Map map) {
        return new ClientHttpRequest(url).post(map);
    }

    public static InputStream post(URL url, Map map, Map map2) {
        return new ClientHttpRequest(url).post(map, map2);
    }

    public static InputStream post(URL url, Object[] objArr) {
        return new ClientHttpRequest(url).post(objArr);
    }

    public static InputStream post(URL url, String[] strArr, Object[] objArr) {
        return new ClientHttpRequest(url).post(strArr, objArr);
    }

    private void postCookies() {
        StringBuffer stringBuffer = new StringBuffer(this.rawCookies);
        for (Entry entry : this.cookies.entrySet()) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("; ");
            }
            stringBuffer.append(new StringBuilder(String.valueOf((String) entry.getKey())).append("=").append((String) entry.getValue()).toString());
        }
        if (stringBuffer.length() > 0) {
            this.connection.setRequestProperty(HeaderName.COOKIE, stringBuffer.toString());
        }
    }

    protected static String randomString() {
        return Long.toString(random.nextLong(), 36);
    }

    private void writeName(String str) {
        newline();
        write("Content-Disposition: form-data; name=\"");
        write(str);
        write('\"');
    }

    private long writeNameNumBytes(String str) {
        return ((newlineNumBytes() + 38) + ((long) str.getBytes().length)) + 1;
    }

    public void cancel() {
        this.isCanceled = true;
    }

    protected void connect() {
        if (this.os == null) {
            this.os = this.connection.getOutputStream();
        }
    }

    public int getBytesSent() {
        return this.bytesSent;
    }

    public long getFilePostSize(String str, File file) {
        String path = file.getPath();
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(path);
        if (guessContentTypeFromName == null) {
            guessContentTypeFromName = "application/octet-stream";
        }
        return ((((((((((boundaryNumBytes() + writeNameNumBytes(str)) + 12) + ((long) path.getBytes().length)) + 1) + newlineNumBytes()) + 14) + ((long) guessContentTypeFromName.length())) + newlineNumBytes()) + newlineNumBytes()) + file.length()) + newlineNumBytes();
    }

    public long getPostFooterSize() {
        return ((boundaryNumBytes() + 2) + newlineNumBytes()) + newlineNumBytes();
    }

    protected void newline() {
        connect();
        write("\r\n");
    }

    protected long newlineNumBytes() {
        return 2;
    }

    public InputStream post() {
        postCookies();
        return doPost();
    }

    public InputStream post(String str, Map map) {
        setCookies(str);
        postCookies();
        setParameters(map);
        return doPost();
    }

    public InputStream post(Map map) {
        postCookies();
        setParameters(map);
        return doPost();
    }

    public InputStream post(Map map, Map map2) {
        setCookies(map);
        postCookies();
        setParameters(map2);
        return doPost();
    }

    public InputStream post(Object... objArr) {
        postCookies();
        setParameters(objArr);
        return doPost();
    }

    public InputStream post(String[] strArr, Object[] objArr) {
        setCookies(strArr);
        postCookies();
        setParameters(objArr);
        return doPost();
    }

    public void setCookie(String str, String str2) {
        this.cookies.put(str, str2);
    }

    public void setCookies(String str) {
        if (str == null) {
            str = "";
        }
        this.rawCookies = str;
        this.cookies.clear();
    }

    public void setCookies(Map map) {
        if (map != null) {
            this.cookies.putAll(map);
        }
    }

    public void setCookies(String[] strArr) {
        if (strArr != null) {
            for (int i = 0; i < strArr.length - 1; i += 2) {
                setCookie(strArr[i], strArr[i + 1]);
            }
        }
    }

    public void setParameter(Object obj, Object obj2) {
        if (obj2 instanceof File) {
            setParameter(obj.toString(), (File) obj2);
        } else {
            setParameter(obj.toString(), obj2.toString());
        }
    }

    public void setParameter(String str, File file) {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                setParameter(str, file.getPath(), fileInputStream);
                fileInputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public void setParameter(String str, String str2) {
        boundary();
        writeName(str);
        newline();
        newline();
        writeln(str2);
    }

    public void setParameter(String str, String str2, InputStream inputStream) {
        boundary();
        writeName(str);
        write("; filename=\"");
        write(str2);
        write('\"');
        newline();
        write("Content-Type: ");
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str2);
        if (guessContentTypeFromName == null) {
            guessContentTypeFromName = "application/octet-stream";
        }
        writeln(guessContentTypeFromName);
        newline();
        pipe(inputStream, this.os);
        newline();
    }

    public void setParameters(Map map) {
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                setParameter(entry.getKey().toString(), entry.getValue());
            }
        }
    }

    public void setParameters(Object... objArr) {
        for (int i = 0; i < objArr.length - 1; i += 2) {
            setParameter(objArr[i].toString(), objArr[i + 1]);
        }
    }

    protected void write(char c) {
        connect();
        this.os.write(c);
    }

    protected void write(String str) {
        connect();
        this.os.write(str.getBytes());
    }

    protected void writeln(String str) {
        connect();
        write(str);
        newline();
    }
}
