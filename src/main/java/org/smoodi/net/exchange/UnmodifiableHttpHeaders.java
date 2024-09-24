package org.smoodi.net.exchange;

import java.lang.instrument.UnmodifiableModuleException;

public class UnmodifiableHttpHeaders extends MapbleHttpHeaders {

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
