package com.google.gson;

public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof JsonNull);
    }

    public final int hashCode() {
        return JsonNull.class.hashCode();
    }
}
