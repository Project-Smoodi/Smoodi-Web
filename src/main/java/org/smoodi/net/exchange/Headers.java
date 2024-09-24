package org.smoodi.net.exchange;

import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;
import org.smoodi.annotation.array.EmptyableArray;
import org.smoodi.annotation.array.UnmodifiableArray;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>Wrapper class of Header saved as Map.</p>
 *
 * @author Daybreak312
 * @since v0.0.1-SNAPSHOT
 */
public class Headers {

    private final Map<String, String> headers = new HashMap<>();

    @EmptyableArray
    @UnmodifiableArray
    public Map<String, String> toMap() {
        return Collections.unmodifiableMap(headers);
    }

    @Nullable
    public String get(@NotNull final String key) {
        return headers.get(key);
    }

    @NotNull
    public String get(@NotNull final String key, @NotNull final String defaultValue) {
        Objects.requireNonNull(key);

        if (defaultValue == null) {
            return headers.get(key);
        }

        final String value = headers.get(key);

        if (value == null) {
            set(key, defaultValue);
            return defaultValue;
        }

        return value;
    }

    public void set(@NotNull final String key, @NotNull final String value) {
        Objects.requireNonNull(key);
        if (value == null) {
            return;
        }

        headers.put(key, value);
    }

    public void remove(@NotNull final String key) {
        Objects.requireNonNull(key);
        headers.remove(key);
    }

    public void clear() {
        headers.clear();
    }
}
