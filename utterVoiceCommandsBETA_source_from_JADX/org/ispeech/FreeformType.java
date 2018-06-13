package org.ispeech;

public enum FreeformType {
    FREEFORM_DISABLED(0),
    FREEFORM_SMS(1),
    FREEFORM_VOICEMAIL(2),
    FREEFORM_DICTATION(3),
    FREEFORM_MESSAGE(4),
    FREEFORM_INSTANT_MESSAGE(5),
    FREEFORM_TRANSCRIPT(6),
    FREEFORM_MEMO(7);
    
    private final int value;

    private FreeformType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
