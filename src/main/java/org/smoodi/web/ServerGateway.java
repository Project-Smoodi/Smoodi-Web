package org.smoodi.web;

import org.smoodi.web.net.ListeningServer;

public interface ServerGateway extends Gateway {

    @Override
    void listen();

    @Override
    void stop();

    ListeningServer getListeningServer();
}
