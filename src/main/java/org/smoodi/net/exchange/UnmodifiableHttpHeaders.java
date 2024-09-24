package org.smoodi.net.exchange;

import java.lang.instrument.UnmodifiableModuleException;

/**
 * <p><b>Unmodifiable</b> wrapper class of HTTP headers saved as {@link java.util.Map Map}.</p>
 *
 * @author Daybreak312
 * @see HttpHeaders
 * @since v0.0.1
 */
public class UnmodifiableHttpHeaders extends MapHttpHeaders {

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
