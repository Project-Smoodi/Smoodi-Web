package org.smoodi.net.exchange;

import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;
import org.smoodi.annotation.array.EmptyableArray;
import org.smoodi.annotation.array.UnmodifiableArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>Wrapper class of Header saved as Map.</p>
 *
 * @author Daybreak312
 * @since v0.0.1
 */
public class MapHeaders implements Headers {

    private final Map<String, String> headers = new HashMap<>();

    @EmptyableArray
    @UnmodifiableArray
    @NotNull
    public Map<String, String> toMap() {
        return Map.copyOf(headers);
    }

    @Override
    @Nullable
    public String get(@NotNull final String key) {
        return headers.get(key);
    }

    @Override
    @NotNull
    public String get(@NotNull final String key, @NotNull final String defaultValue) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(defaultValue);

        final String value = headers.get(key);

        if (value == null) {
            set(key, defaultValue);
            return defaultValue;
        }

        return value;
    }

    @Override
    public void set(@NotNull final String key, @NotNull final String value) {
        Objects.requireNonNull(key);
        if (value == null) {
            return;
        }

        headers.put(key, value);
    }

    @Override
    public void remove(@NotNull final String key) {
        Objects.requireNonNull(key);
        headers.remove(key);
    }

    @Override
    public void clear() {
        headers.clear();
    }
}
