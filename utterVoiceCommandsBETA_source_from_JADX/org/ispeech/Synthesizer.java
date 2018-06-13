package org.ispeech;

public interface Synthesizer {
    void addMeta(MetaType metaType, String str);

    void addOptionalCommand(String str, String str2);

    void clearOptionalCommand();

    void speak(String str);

    void stop();
}
