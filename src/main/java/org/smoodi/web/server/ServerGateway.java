package org.smoodi.web.server;

import org.smoodi.net.ListeningServer;

public interface ServerGateway extends Gateway {

    @Override
    void listen();

    @Override
    void stop();

    ListeningServer getListeningServer();
}
