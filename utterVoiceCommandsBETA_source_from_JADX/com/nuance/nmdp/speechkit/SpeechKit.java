package com.nuance.nmdp.speechkit;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Handler;
import com.nuance.nmdp.speechkit.Recognizer.Listener;
import java.io.IOException;

public final class SpeechKit extends C0373e {
    private final C0464f f2327a;
    private final Context f2328b;

    final class C03721 implements Runnable {
        private /* synthetic */ C0484m f2325a;
        private /* synthetic */ AssetFileDescriptor f2326b;

        C03721(C0484m c0484m, AssetFileDescriptor assetFileDescriptor) {
            this.f2325a = c0484m;
            this.f2326b = assetFileDescriptor;
        }

        public final void run() {
            this.f2325a.m2592a(this.f2326b);
        }
    }

    private SpeechKit(C0464f c0464f, Context context) {
        this.f2327a = c0464f;
        this.f2328b = context;
    }

    private Prompt m1900a(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor == null) {
            return null;
        }
        Object c0484m = new C0484m();
        Prompt prompt = new Prompt(c0484m, this.f2327a);
        synchronized (C0464f.m2515b()) {
            if (!this.f2327a.m2525a()) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e) {
                }
                C0464f.m2518f();
            }
            this.f2327a.m2527b(prompt);
        }
        ax.m2055a(new C03721(c0484m, assetFileDescriptor));
        return prompt;
    }

    public static SpeechKit initialize(Context context, String str, String str2, int i, boolean z, byte[] bArr) {
        C0464f a = C0464f.m2507a(context, str, str2, i, z, bArr);
        if (a == null) {
            return null;
        }
        SpeechKit speechKit;
        synchronized (C0464f.m2515b()) {
            speechKit = (SpeechKit) a.m2529d();
            if (speechKit == null) {
                speechKit = new SpeechKit(a, context);
                a.m2524a((Object) speechKit);
            }
        }
        return speechKit;
    }

    public final void cancelCurrent() {
        this.f2327a.m2534j();
    }

    public final void connect() {
        this.f2327a.m2532h();
    }

    public final Recognizer createRecognizer(String str, int i, String str2, Listener listener, Handler handler) {
        return this.f2327a.m2520a(str, i, str2, listener, handler);
    }

    public final Vocalizer createVocalizerWithLanguage(String str, Vocalizer.Listener listener, Handler handler) {
        return this.f2327a.m2521a(str, listener, handler);
    }

    public final Vocalizer createVocalizerWithVoice(String str, Vocalizer.Listener listener, Handler handler) {
        return this.f2327a.m2526b(str, listener, handler);
    }

    public final Prompt defineAudioPrompt(int i) {
        AssetFileDescriptor openRawResourceFd = this.f2328b.getResources().openRawResourceFd(i);
        if (openRawResourceFd != null) {
            return m1900a(openRawResourceFd);
        }
        throw new IllegalArgumentException("resourceId must refer to an uncompressed resource");
    }

    public final String getSessionId() {
        return this.f2327a.m2533i();
    }

    public final void release() {
        this.f2327a.m2531g();
    }

    public final void setDefaultRecognizerPrompts(Prompt prompt, Prompt prompt2, Prompt prompt3, Prompt prompt4) {
        this.f2327a.m2523a(prompt, prompt2, prompt3, prompt4);
    }
}
