package org.smoodi.net.exchange;

import lombok.NoArgsConstructor;
import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;
import org.smoodi.annotation.StaticFactoryMethod;
import org.smoodi.annotation.array.EmptyableArray;
import org.smoodi.annotation.array.NotEmptyArray;
import org.smoodi.annotation.array.UnmodifiableArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>Wrapper class of TCP headers saved as {@link Map}.</p>
 *
 * @author Daybreak312
 * @since v0.0.1
 */
@NoArgsConstructor
public class MapHeaders implements Headers {

    private final Map<String, String> headers = new HashMap<>();

    public MapHeaders(
            @NotNull @NotEmptyArray final Map<String, String> headers
    ) {
        this.headers.putAll(headers);
    }

    @StaticFactoryMethod
    public static MapHeaders of(@NotNull final Map<String, String> headers) {
        Objects.requireNonNull(headers);
        return new MapHeaders(headers);
    }

    @StaticFactoryMethod
    public static MapHeaders empty() {
        return new MapHeaders();
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

    @EmptyableArray
    @UnmodifiableArray
    @NotNull
    @Override
    public Map<String, String> toMap() {
        return Map.copyOf(headers);
    }
}
