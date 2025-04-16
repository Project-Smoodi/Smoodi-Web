package org.smoodi.web.server;

import org.smoodi.annotation.NotNull;
import org.smoodi.physalus.transfer.Request;
import org.smoodi.physalus.transfer.Response;

public interface SimpleGateway {

    @NotNull
    Response service(@NotNull Request request, @NotNull Response response);
}
