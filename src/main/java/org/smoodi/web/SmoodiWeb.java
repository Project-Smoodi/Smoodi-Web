package org.smoodi.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.engine.Engine;

@Slf4j
@RequiredArgsConstructor
@Module
public final class SmoodiWeb {

    private final Engine engine;

    public void startServer() {
        engine.startEngine();
    }
}
