package org.smoodi.net;

import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;

import java.util.function.Function;

public interface ListeningServer {

    void start(int port, Function<Request, Response> handler);

    void stop();
}
