package org.smoodi.web;

import org.smoodi.web.exchange.Request;
import org.smoodi.web.exchange.Response;

public interface Router {

    Response route(Request request);

    boolean supports(Request request);
}
