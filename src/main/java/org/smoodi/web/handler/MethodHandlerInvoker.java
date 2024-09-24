package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;

public interface MethodHandlerInvoker {

    void invoke(@NotNull MethodHandler handler, @NotNull Request request, @NotNull Response response);
}