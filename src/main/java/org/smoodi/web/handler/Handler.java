package org.smoodi.web.handler;

import com.sun.net.httpserver.Request;
import org.smoodi.web.server.exchange.Response;

public interface Handler {

    Response handle(Request request);
}
