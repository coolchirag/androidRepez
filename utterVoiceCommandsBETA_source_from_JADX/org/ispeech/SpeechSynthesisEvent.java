package org.ispeech;

import android.util.Log;

public abstract class SpeechSynthesisEvent {
    private static /* synthetic */ int[] $SWITCH_TABLE$org$ispeech$SpeechSynthesisEvent$EventType = null;
    private static final String TAG = "iSpeech SDK";

    public enum EventType {
        PLAY_STARTED,
        PLAY_SUCCESSFUL,
        PLAY_STOPPED,
        PLAY_FAILURE,
        PLAY_CANCELED
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$ispeech$SpeechSynthesisEvent$EventType() {
        int[] iArr = $SWITCH_TABLE$org$ispeech$SpeechSynthesisEvent$EventType;
        if (iArr == null) {
            iArr = new int[EventType.values().length];
            try {
                iArr[EventType.PLAY_CANCELED.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.PLAY_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EventType.PLAY_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EventType.PLAY_STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EventType.PLAY_SUCCESSFUL.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            $SWITCH_TABLE$org$ispeech$SpeechSynthesisEvent$EventType = iArr;
        }
        return iArr;
    }

    public void onPlayCanceled() {
        Log.i(TAG, "onPlayCanceled");
    }

    public void onPlayFailed(Exception exception) {
        Log.e(TAG, "onPlayFailed", exception);
    }

    public void onPlayStart() {
        Log.i(TAG, "onPlayStart");
    }

    public void onPlayStopped() {
        Log.i(TAG, "onPlayStopped");
    }

    public void onPlaySuccessful() {
        Log.i(TAG, "onPlaySuccessful");
    }

    void stateChanged(EventType eventType, Object obj) {
        switch ($SWITCH_TABLE$org$ispeech$SpeechSynthesisEvent$EventType()[eventType.ordinal()]) {
            case 1:
                onPlayStart();
                return;
            case 2:
                onPlaySuccessful();
                return;
            case 3:
                onPlayStopped();
                return;
            case 4:
                onPlayFailed((Exception) obj);
                return;
            case 5:
                onPlayCanceled();
                return;
            default:
                return;
        }
    }
}
