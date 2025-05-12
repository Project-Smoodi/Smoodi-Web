package org.smoodi.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.smoodi.core.annotation.Module;

@Slf4j
@RequiredArgsConstructor
@Module
public final class SmoodiWeb {

    private final PhysalusDelegate engine;

    public void startServer() {
        engine.getPhysalus().getServerRuntime()
                .addPort(8080);

        engine.startEngine();
    }
}
