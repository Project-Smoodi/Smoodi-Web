package org.smoodi.web.handler.argument;

import lombok.RequiredArgsConstructor;
import org.smoodi.annotation.NotNull;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.Request;
import org.smoodi.physalus.transfer.Response;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.web.handler.MethodHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Module
public class MethodHandlerInvokerImpl implements MethodHandlerInvoker {

    private final HandlerMethodArgumentResolver resolver;

    @Override
    public void invoke(@NotNull MethodHandler handler, @NotNull Request request, @NotNull Response response) {
        final List<Object> extracted = new ArrayList<>(handler.getParameterCount());

        handler.getParameters().forEach(parameter ->
                extracted.add(
                        resolver.resolveArgument((HttpRequest) request, parameter)
                ));

        try {
            handler.getMethod().invoke(handler.getDeclaredObject(), extracted.toArray());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
