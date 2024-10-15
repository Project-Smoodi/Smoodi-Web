package org.smoodi.net;

import org.smoodi.web.server.Gateway;

public interface GatewayServer extends Server {

    Gateway getGateway();
}
