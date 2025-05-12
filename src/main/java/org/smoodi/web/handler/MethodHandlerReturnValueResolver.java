package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.physalus.transfer.http.HttpResponse;

public interface MethodHandlerReturnValueResolver {

    boolean supports(@NotNull Object returnValue);

    void resolveReturnValue(
            @NotNull HttpResponse response,
            @NotNull Object returnValue,
            @NotNull RequestPathMethodHandler handler
    );
}
