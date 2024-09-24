package org.smoodi.net.exchange;

import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;

/**
 * <p>Header VO.</p>
 *
 * <p>It must be Implemented as a key-value stream.</p>
 *
 * @author Daybreak312
 * @since v0.0.1
 */
public interface Headers {

    @Nullable
    String get(@NotNull final String key);

    @NotNull
    String get(@NotNull final String key, @NotNull final String defaultValue);

    void set(@NotNull final String key, @Nullable final String value);

    void remove(@NotNull final String key);

    void clear();
}
