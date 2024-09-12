package org.smoodi.web.server.net;

import com.sun.net.httpserver.HttpExchange;
import org.smoodi.web.server.exchange.HttpRequest;
import org.smoodi.web.server.exchange.HttpResponse;

import java.util.Map;

@FunctionalInterface
public interface HttpExchangeAdapter {

    Map.Entry<HttpRequest, HttpResponse> adapt(final HttpExchange exchange);
}
