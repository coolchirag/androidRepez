package android.support.v4.p008c;

import android.util.Log;
import java.io.Writer;

public final class C0058b extends Writer {
    private final String f217a;
    private StringBuilder f218b = new StringBuilder(128);

    public C0058b(String str) {
        this.f217a = str;
    }

    private void m174a() {
        if (this.f218b.length() > 0) {
            Log.d(this.f217a, this.f218b.toString());
            this.f218b.delete(0, this.f218b.length());
        }
    }

    public final void close() {
        m174a();
    }

    public final void flush() {
        m174a();
    }

    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m174a();
            } else {
                this.f218b.append(c);
            }
        }
    }
}
