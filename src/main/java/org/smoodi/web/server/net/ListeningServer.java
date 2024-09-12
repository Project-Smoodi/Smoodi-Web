package org.smoodi.web.server.net;

import org.smoodi.web.server.exchange.Request;
import org.smoodi.web.server.exchange.Response;

import java.util.function.Function;

public interface ListeningServer {

    void start(int port, Function<Request, Response> handler);

    void stop();
}
