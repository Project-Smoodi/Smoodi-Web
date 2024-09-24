package org.smoodi.web.handler;

import org.smoodi.web.server.exchange.Request;
import org.smoodi.web.server.exchange.Response;

public interface Handler {

    boolean supports(Request request);

    Response handle(Request request);
}
