package com.att.android.speech;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

final class ao extends Thread {
    final /* synthetic */ al f488a;
    private volatile boolean f489b = false;

    ao(al alVar) {
        this.f488a = alVar;
    }

    public final void m393a() {
        this.f489b = true;
        this.f488a.f463N.f484a = true;
    }

    public final void run() {
        FileOutputStream fileOutputStream = null;
        Object obj = null;
        File file = new File(this.f488a.f451B.getFilesDir(), "test.amr");
        this.f488a.f463N.start();
        try {
            fileOutputStream = new FileOutputStream((!file.exists() ? ParcelFileDescriptor.open(file, 939524099) : ParcelFileDescriptor.open(file, 872415232)).getFileDescriptor());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (obj == null) {
            try {
                byte[] bArr = (byte[]) this.f488a.f452C.poll();
                if (bArr != null) {
                    this.f488a.f471o.write(bArr, 0, bArr.length);
                    fileOutputStream.write(bArr, 0, bArr.length);
                }
                if (this.f489b) {
                    ac.m345a("StreamingAudioRecorder", "******************* Stopped - waiting for audio buffer to empty");
                    if (this.f488a.f452C.isEmpty()) {
                        ac.m345a("StreamingAudioRecorder", "******************* Audio buffer is empty.");
                        obj = 1;
                    }
                }
            } catch (IOException e2) {
            }
        }
        if (this.f488a.f471o != null) {
            try {
                this.f488a.f471o.flush();
                this.f488a.f471o.close();
                ac.m345a("StreamingAudioRecorder", "Should have closed the audio output stream");
                this.f488a.f471o = null;
            } catch (IOException e3) {
            }
        }
        this.f488a.mo60d();
        ac.m345a("StreamingAudioRecorder", "Audio Buffer size = " + this.f488a.f452C.size());
    }
}
