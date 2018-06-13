package org.ispeech;

public class SpeechResult {
    private float confidence;
    private String text = null;

    public SpeechResult(String str, float f) {
        this.text = str;
        this.confidence = f;
    }

    public float getConfidence() {
        return this.confidence;
    }

    public String getText() {
        return this.text;
    }

    public void setConfidence(float f) {
        this.confidence = f;
    }

    public void setText(String str) {
        this.text = str;
    }
}
