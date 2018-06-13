package com.dropbox.client2.p021a;

import java.io.BufferedReader;
import java.io.IOException;

public final class C0190d extends C0187a {
    public C0190d(BufferedReader bufferedReader) {
        super("failed to parse: " + C0190d.m1517a(bufferedReader));
    }

    private static String m1517a(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.reset();
            } catch (IOException e) {
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            } catch (IOException e2) {
            }
        }
        return stringBuffer.toString();
    }
}
