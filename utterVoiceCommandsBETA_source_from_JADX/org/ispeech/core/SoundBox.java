package org.ispeech.core;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.ispeech.tools.Utilities;

public class SoundBox {
    private static final String TAG = "SoundBox";
    private static SoundBox instance;
    private Context context;
    private SoundPool soundPool;
    private Map<Integer, Integer> soundPoolMap;

    private SoundBox(Context context) {
        this.context = context;
        if (this.soundPool == null) {
            this.soundPool = new SoundPool(4, InternalResources.STREAM_TYPE, 100);
            try {
                File loadFileFromPackage = Utilities.loadFileFromPackage(context, "org/ispeech/raw/voice_open.mp3", "voice_open.mp3");
                File loadFileFromPackage2 = Utilities.loadFileFromPackage(context, "org/ispeech/raw/voice_close.mp3", "voice_close.mp3");
                this.soundPoolMap = new HashMap();
                this.soundPoolMap.put(Integer.valueOf(0), Integer.valueOf(this.soundPool.load(loadFileFromPackage2.getAbsolutePath(), 1)));
                this.soundPoolMap.put(Integer.valueOf(1), Integer.valueOf(this.soundPool.load(loadFileFromPackage.getAbsolutePath(), 1)));
                try {
                    Thread.sleep(100);
                } catch (Throwable e) {
                    Log.w(TAG, "Thread interrupted in SoundBox.", e);
                }
            } catch (Throwable e2) {
                Log.e(TAG, e2.getMessage(), e2);
            }
        }
    }

    public static SoundBox getInstance(Context context) {
        if (instance == null) {
            instance = new SoundBox(context);
        }
        return instance;
    }

    private void playSound(int i) {
        AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
        audioManager.getStreamVolume(InternalResources.STREAM_TYPE);
        float streamMaxVolume = ((float) audioManager.getStreamMaxVolume(InternalResources.STREAM_TYPE)) / 2.0f;
        this.soundPool.play(((Integer) this.soundPoolMap.get(Integer.valueOf(i))).intValue(), streamMaxVolume, streamMaxVolume, 1, 0, 1.0f);
    }

    public void playClose() {
        playSound(0);
    }

    public void playOpen() {
        playSound(1);
    }
}
