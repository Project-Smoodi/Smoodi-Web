package org.smoodi.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.engine.Physalus;

@Slf4j
@RequiredArgsConstructor
@Module
public final class SmoodiWeb {

    public void startServer() {
        Physalus.instance().getServerRuntime()
                .addPort(8080);

        Physalus.instance().startEngine();
    }
}
