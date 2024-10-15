package org.smoodi.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.smoodi.core.annotation.Module;
import org.smoodi.net.GatewayServer;
import org.smoodi.web.server.Gateway;

@Slf4j
@RequiredArgsConstructor
@Module
public final class SmoodiWeb {

    private final Gateway frontGateway;

    private final GatewayServer server;

    private static SmoodiWeb instance;

    {
        SmoodiWeb.instance = this;
    }

    public static void startServer() {
        instance.server.start();
    }
}
