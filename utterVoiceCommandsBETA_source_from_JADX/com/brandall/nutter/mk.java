package com.brandall.nutter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

final class mk extends Thread {
    private InputStream f1717a;
    private StringBuffer f1718b = new StringBuffer();

    public mk(InputStream inputStream) {
        this.f1717a = inputStream;
        start();
    }

    public final String m1480a() {
        return this.f1718b.toString();
    }

    public final void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f1717a));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                this.f1718b.append(readLine);
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.f1718b.append(mj.f1714c).append(readLine);
                    } else {
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
