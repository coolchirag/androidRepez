package org.ispeech;

public enum MetaType {
    META_FIRST_NAME("meta_first"),
    META_LAST_NAME("meta_last"),
    META_ID("meta_id"),
    META_OS("meta_os"),
    META_PHONETYPE("meta_phonetype"),
    META_PROVIDER("meta_provider"),
    META_APPLICATION_NAME("meta_app"),
    META_LATITUDE("lat"),
    META_LONGITUDE("lon");
    
    private String value;

    private MetaType(String str) {
        this.value = str;
    }

    final String getValue() {
        return this.value;
    }
}
