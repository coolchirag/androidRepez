package org.ispeech;

public interface Recognizer {
    void addAlias(String str, String[] strArr);

    void addCommand(String str);

    void addCommand(String[] strArr);

    void addMeta(MetaType metaType, String str);

    void addOptionalCommand(String str, String str2);

    void cancelProcessing();

    void cancelRecord();

    void clearAlias();

    void clearCommand();

    void clearOptionalCommand();

    FreeformType getFreeForm();

    boolean isRunning();

    void setChime(boolean z);

    void setFreeForm(FreeformType freeformType);

    void setLocale(String str);

    void setModel(String str);

    void startRecord(SpeechRecognizerEvent speechRecognizerEvent);

    void stopRecord();
}
