package com.permission.util;

import com.common.util.Json;
import com.dslplatform.json.JsonReader;
import com.dslplatform.json.runtime.Generics;

import java.util.Map;

public class Global {

    public Global() {
    }

    public static final JsonReader.ReadObject<Map<String, Integer>> mapReader =
            Json.findReader(Generics.makeParameterizedType(Map.class, String.class, Integer.class));

}
