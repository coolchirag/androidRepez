package javax.mail;

import java.io.InputStream;

interface StreamLoader {
    void load(InputStream inputStream);
}
