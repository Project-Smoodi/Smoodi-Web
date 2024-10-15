package org.smoodi.web.server;

import org.smoodi.annotation.NotNull;
import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;

public interface SimpleGateway {

    @NotNull
    Response service(@NotNull Request request, @NotNull Response response);
}
