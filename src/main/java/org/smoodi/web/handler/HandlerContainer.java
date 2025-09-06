package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.physalus.transfer.Request;

public interface HandlerContainer {

    Handler getHandler(@NotNull Request request);
}
