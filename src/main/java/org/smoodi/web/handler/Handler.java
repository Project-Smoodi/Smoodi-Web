package org.smoodi.web.handler;

import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;

public interface Handler {

    boolean supports(Request request);

    Response handle(Request request);
}
