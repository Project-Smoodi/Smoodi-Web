package org.smoodi.web.router;

import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;

public interface Router {

    Response route(Request request);

    boolean supports(Request request);
}
