package org.smoodi.web.net;

import org.smoodi.web.exchange.Request;
import org.smoodi.web.exchange.Response;

import java.util.function.Function;

public interface ListeningServer {

    void start(int port, Function<Request, Response> handler);

    void stop();
}
