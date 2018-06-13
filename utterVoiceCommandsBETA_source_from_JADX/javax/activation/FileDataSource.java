package javax.activation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileDataSource implements DataSource {
    private File _file;
    private FileTypeMap typeMap;

    public FileDataSource(File file) {
        this._file = null;
        this.typeMap = null;
        this._file = file;
    }

    public FileDataSource(String str) {
        this(new File(str));
    }

    public String getContentType() {
        return this.typeMap == null ? FileTypeMap.getDefaultFileTypeMap().getContentType(this._file) : this.typeMap.getContentType(this._file);
    }

    public File getFile() {
        return this._file;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this._file);
    }

    public String getName() {
        return this._file.getName();
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this._file);
    }

    public void setFileTypeMap(FileTypeMap fileTypeMap) {
        this.typeMap = fileTypeMap;
    }
}
