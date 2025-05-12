package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.physalus.transfer.Request;
import org.smoodi.physalus.transfer.Response;

/**
 * <p>{@link MethodHandler}를 실행.</p>
 *
 * @author Daybreak312
 * @see MethodHandler
 * @see Handler
 * @since v0.0.1
 */
public interface MethodHandlerInvoker {

    void invoke(@NotNull MethodHandler handler, @NotNull Request request, @NotNull Response response);
}
