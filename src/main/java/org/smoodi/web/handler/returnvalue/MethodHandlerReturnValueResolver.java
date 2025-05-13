package org.smoodi.web.handler.returnvalue;

import org.smoodi.annotation.NotNull;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.web.handler.MethodHandler;

public interface MethodHandlerReturnValueResolver {

    boolean supports(@NotNull Object returnValue);

    void resolveReturnValue(
            @NotNull HttpResponse response,
            @NotNull Object returnValue,
            @NotNull MethodHandler handler
    );
}
