package org.smoodi.web.server;

import org.smoodi.web.server.net.ListeningServer;

public interface ServerGateway extends Gateway {

    @Override
    void listen();

    @Override
    void stop();

    ListeningServer getListeningServer();
}
