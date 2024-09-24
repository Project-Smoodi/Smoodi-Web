package org.smoodi.net;

import com.sun.net.httpserver.HttpExchange;
import org.smoodi.net.exchange.HttpRequest;
import org.smoodi.net.exchange.HttpResponse;

import java.util.Map;

@FunctionalInterface
public interface HttpExchangeAdapter {

    Map.Entry<HttpRequest, HttpResponse> toRequestResponse(final HttpExchange exchange);
}
