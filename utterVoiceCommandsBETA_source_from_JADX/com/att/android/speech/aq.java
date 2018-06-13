package com.att.android.speech;

import android.os.SystemClock;
import java.nio.ByteBuffer;

final class aq extends Thread {
    final /* synthetic */ al f496a;
    private volatile boolean f497b = false;

    aq(al alVar) {
        this.f496a = alVar;
    }

    public final void m395a() {
        this.f497b = true;
    }

    public final void run() {
        this.f496a.f452C.add("#!AMR\n".getBytes());
        if (this.f496a.f477u != null) {
            do {
            } while (this.f496a.f477u.getState() != 1);
            ac.m345a("StreamingAudioRecorder", "Audio recoder was initialized");
            this.f496a.f477u.startRecording();
            ac.m345a("StreamingAudioRecorder", "Audio recoder was started");
            this.f496a.j = SystemClock.uptimeMillis();
            this.f496a.f475s.start();
            short[] sArr = new short[160];
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length);
            byte[] bArr = new byte[sArr.length];
            int i = 0;
            do {
                allocateDirect.rewind();
                int read = this.f496a.f477u.read(allocateDirect, 160);
                i += read;
                allocateDirect.rewind();
                if (read > 0) {
                    allocateDirect.get(bArr);
                    al.m377a(this.f496a, bArr);
                }
                if (this.f496a.f468l == null || this.f497b || this.f496a.f477u == null) {
                    ac.m345a("StreamingAudioRecorder", "Read " + i + " bytes of data from the audio recorder.");
                    ac.m345a("StreamingAudioRecorder", "AMR Buffer pointer (number of bytes amr encoded) = " + this.f496a.f464O);
                }
            } while (this.f496a.f477u.getRecordingState() == 3);
            ac.m345a("StreamingAudioRecorder", "Read " + i + " bytes of data from the audio recorder.");
            ac.m345a("StreamingAudioRecorder", "AMR Buffer pointer (number of bytes amr encoded) = " + this.f496a.f464O);
        }
        this.f496a.f469m = false;
    }
}
