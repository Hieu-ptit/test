package com.dslplatform.json;

public class DslJsonHelper {

    public DslJsonHelper() {
    }

    public static <T> void reset(JsonReader<T> reader) {
        reader.reset();
    }
}
