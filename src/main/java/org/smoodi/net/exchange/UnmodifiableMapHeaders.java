package org.smoodi.net.exchange;

import org.smoodi.annotation.NotNull;

import java.lang.instrument.UnmodifiableModuleException;
import java.util.Map;

/**
 * <p><b>Unmodifiable</b> wrapper class of headers saved as {@link java.util.Map Map}.</p>
 *
 * @author Daybreak312
 * @see MapHeaders
 * @since v0.0.1
 */
public class UnmodifiableMapHeaders extends MapHeaders {

    @Override
    public void set(String key, String value) {
        throw new UnmodifiableModuleException();
    }

    @Override
    public void remove(String key) {
        throw new UnmodifiableModuleException();
    }

    @Override
    public void clear() {
        throw new UnmodifiableModuleException();
    }
}
