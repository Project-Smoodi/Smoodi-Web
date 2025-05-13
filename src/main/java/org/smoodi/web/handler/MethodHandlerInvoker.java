package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;

/**
 * <p>{@link MethodHandler}를 실행.</p>
 *
 * @author Daybreak312
 * @see MethodHandler
 * @see Handler
 * @since v0.0.1
 */
public interface MethodHandlerInvoker {

    void invoke(
            @NotNull MethodHandler handler,
            @NotNull HttpRequest request,
            @NotNull HttpResponse response
    );
}
