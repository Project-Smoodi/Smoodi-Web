package org.smoodi.web.router;

import org.smoodi.web.server.exchange.Request;
import org.smoodi.web.server.exchange.Response;

public interface Router {

    Response route(Request request);

    boolean supports(Request request);
}
