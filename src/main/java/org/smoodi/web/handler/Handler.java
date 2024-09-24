package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;

public interface Handler {

    boolean supports(@NotNull Request request);

    void handle(@NotNull Request request, @NotNull Response response);
}
