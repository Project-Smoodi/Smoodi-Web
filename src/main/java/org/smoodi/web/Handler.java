package org.smoodi.web;

import com.sun.net.httpserver.Request;
import org.smoodi.web.exchange.Response;

public interface Handler {

    Response handle(Request request);
}
