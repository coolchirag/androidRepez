package org.ispeech;

import android.content.Context;
import org.ispeech.error.InvalidApiKeyException;
import org.ispeech.tools.Utilities;

public class SpeechRecognizer implements Recognizer {
    private static SpeechRecognizer instance;
    private String _key;
    private Recognizer currentRecognizer;
    private FreeformRecognizerImpl freeformRecognizer;

    private SpeechRecognizer(Context context, String str) {
        if (str == null || str.length() != 32) {
            throw new InvalidApiKeyException();
        }
        this._key = str;
        this.freeformRecognizer = FreeformRecognizerImpl.getInstance(context);
    }

    public static SpeechRecognizer getInstance(Context context) {
        String apiKey = Utilities.getApiKey(context);
        if (instance == null) {
            instance = new SpeechRecognizer(context, apiKey);
        } else {
            FreeformRecognizerImpl.getInstance(context, apiKey);
            instance._key = apiKey;
        }
        return instance;
    }

    public void addAlias(String str, String[] strArr) {
        this.currentRecognizer.addAlias(str.toUpperCase(), strArr);
    }

    public void addCommand(String str) {
        this.currentRecognizer.addCommand(str);
    }

    public void addCommand(String[] strArr) {
        this.currentRecognizer.addCommand(strArr);
    }

    public void addMeta(MetaType metaType, String str) {
        this.freeformRecognizer.addMeta(metaType, str);
    }

    public void addOptionalCommand(String str, String str2) {
        this.freeformRecognizer.addOptionalCommand(str, str2);
    }

    public void cancelProcessing() {
        this.currentRecognizer.cancelProcessing();
    }

    public void cancelRecord() {
        this.currentRecognizer.cancelRecord();
    }

    public void clearAlias() {
    }

    public void clearCommand() {
    }

    public void clearOptionalCommand() {
        this.freeformRecognizer.clearOptionalCommand();
    }

    public FreeformType getFreeForm() {
        return this.currentRecognizer.getFreeForm();
    }

    public boolean isRunning() {
        return this.currentRecognizer.isRunning();
    }

    public void setChime(boolean z) {
        this.freeformRecognizer.setChime(z);
    }

    public void setFreeForm(FreeformType freeformType) {
        this.currentRecognizer = this.freeformRecognizer;
        this.currentRecognizer.setFreeForm(freeformType);
    }

    public void setLocale(String str) {
        this.freeformRecognizer.setLocale(str);
    }

    public void setModel(String str) {
        this.freeformRecognizer.setModel(str);
    }

    public void setSilenceDetection(boolean z) {
        this.freeformRecognizer.setSilenceDetection(z);
    }

    public void setStreaming(boolean z) {
        this.freeformRecognizer.setStreaming(z);
    }

    public void setTimeout(int i) {
        this.freeformRecognizer.setTimeout(i);
    }

    public void startRecord(SpeechRecognizerEvent speechRecognizerEvent) {
        try {
            this.currentRecognizer.startRecord(speechRecognizerEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopRecord() {
        this.currentRecognizer.stopRecord();
    }

    public void toDisableTheDialogContact_salesATiSpeechDOTorg() {
    }
}
