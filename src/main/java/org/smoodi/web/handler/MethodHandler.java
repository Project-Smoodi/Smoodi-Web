package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * <p>{@link Method}를 통해 작성된 {@link org.smoodi.web.handler.annotation.Handler Handler}를 사용하기 위한 인터페이스.</p>
 *
 * @author Daybreak312
 * @see Method`
 * @see org.smoodi.web.handler.annotation.Handler
 * @see Handler
 * @see RequestPathHandler
 * @since v0.0.1
 */
public interface MethodHandler extends Handler {

    Object getDeclaredObject();

    Method getMethod();

    List<Parameter> getParameters();

    int getParameterCount();

    String getName();

    @Override
    boolean supports(@NotNull Request request);

    @Override
    void handle(@NotNull Request request, @NotNull Response response);
}
