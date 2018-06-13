package com.brandall.nutter;

import android.os.Handler;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;

final class mr extends Thread {
    final /* synthetic */ mq f1736a;
    private final /* synthetic */ Handler f1737b;

    mr(mq mqVar, String str, Handler handler) {
        this.f1736a = mqVar;
        this.f1737b = handler;
        super(str);
    }

    public final void run() {
        mq mqVar = this.f1736a;
        Handler handler = this.f1737b;
        try {
            mqVar.f1734b.setDoOutput(true);
            OutputStream outputStream = mqVar.f1734b.getOutputStream();
            outputStream.write(mqVar.f1735c);
            outputStream.close();
            InputStream inputStream = mqVar.f1734b.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    handler.post(new ms(mqVar, new JSONObject(new String(byteArrayOutputStream.toByteArray(), "UTF8")).getString("access_token")));
                    return;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            handler.post(new mt(mqVar, e));
        }
    }
}
