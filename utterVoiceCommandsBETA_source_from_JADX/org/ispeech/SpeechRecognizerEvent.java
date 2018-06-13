package org.ispeech;

import android.util.Log;

public abstract class SpeechRecognizerEvent {
    private static /* synthetic */ int[] $SWITCH_TABLE$org$ispeech$SpeechRecognizerEvent$EventType = null;
    private static final String TAG = "iSpeech SDK";

    public enum EventType {
        RECORDING_COMPLETE,
        RECOGNITION_COMPLETE,
        RECORDING_CANCELED,
        RECOGNITION_CANCELED,
        ERROR
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$ispeech$SpeechRecognizerEvent$EventType() {
        int[] iArr = $SWITCH_TABLE$org$ispeech$SpeechRecognizerEvent$EventType;
        if (iArr == null) {
            iArr = new int[EventType.values().length];
            try {
                iArr[EventType.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.RECOGNITION_CANCELED.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EventType.RECOGNITION_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EventType.RECORDING_CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EventType.RECORDING_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            $SWITCH_TABLE$org$ispeech$SpeechRecognizerEvent$EventType = iArr;
        }
        return iArr;
    }

    public void onError(Exception exception) {
        Log.e(TAG, "onError", exception);
    }

    public abstract void onRecognitionComplete(SpeechResult speechResult);

    public void onRecordingCancelled() {
        Log.e(TAG, "onRecordingCancelled");
    }

    public void onRecordingComplete() {
        Log.e(TAG, "onRecordingComplete");
    }

    void stateChanged(EventType eventType, Object obj) {
        switch ($SWITCH_TABLE$org$ispeech$SpeechRecognizerEvent$EventType()[eventType.ordinal()]) {
            case 1:
                onRecordingComplete();
                return;
            case 2:
                onRecognitionComplete((SpeechResult) obj);
                return;
            case 3:
                onRecordingCancelled();
                return;
            case 5:
                onError((Exception) obj);
                return;
            default:
                return;
        }
    }
}
