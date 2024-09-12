package org.smoodi.web.server.exchange;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    private final Map<String, String> headers = new HashMap<>();

    public String get(final String key) {
        return headers.get(key);
    }

    public String get(final String key, final String defaultValue) {
        final String value = headers.get(key);
        return value == null ? defaultValue : value;
    }

    public void set(final String key, final String value) {
        headers.put(key, value);
    }

    public void remove(final String key) {
        headers.remove(key);
    }

    public void clear() {
        headers.clear();
    }
}
