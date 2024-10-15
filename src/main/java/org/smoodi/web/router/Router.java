package org.smoodi.web.router;

import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;

public interface Router {

    boolean supports(Request request);

    Response route(Request request);
}
