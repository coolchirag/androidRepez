package com.nuance.nmdp.speechkit;

public interface Recognizer {

    public interface Listener {
        void onError(Recognizer recognizer, SpeechError speechError);

        void onRecordingBegin(Recognizer recognizer);

        void onRecordingDone(Recognizer recognizer);

        void onResults(Recognizer recognizer, Recognition recognition);
    }

    public class EndOfSpeechDetection {
        public static final int Long = 2;
        public static final int None = 0;
        public static final int Short = 1;
    }

    public class PromptType {
        public static final int ERROR = 3;
        public static final int RECORDING_START = 0;
        public static final int RECORDING_STOP = 1;
        public static final int RESULT = 2;
    }

    public class RecognizerType {
        public static final String Dictation = "dictation";
        public static final String Search = "websearch";
    }

    void cancel();

    float getAudioLevel();

    void setListener(Listener listener);

    void setPrompt(int i, Prompt prompt);

    void start();

    void stopRecording();
}
