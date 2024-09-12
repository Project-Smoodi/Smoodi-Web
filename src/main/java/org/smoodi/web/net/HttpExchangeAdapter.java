package org.smoodi.web.net;

import com.sun.net.httpserver.HttpExchange;
import org.smoodi.web.exchange.HttpRequest;
import org.smoodi.web.exchange.HttpResponse;

import java.util.Map;

@FunctionalInterface
public interface HttpExchangeAdapter {

    Map.Entry<HttpRequest, HttpResponse> adapt(final HttpExchange exchange);
}
