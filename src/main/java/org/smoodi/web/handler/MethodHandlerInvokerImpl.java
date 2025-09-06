package org.smoodi.web.handler;

import lombok.RequiredArgsConstructor;
import org.smoodi.annotation.NotNull;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.physalus.transfer.http.HttpStatus;
import org.smoodi.web.StatusException;
import org.smoodi.web.handler.argument.MethodHandlerArgumentResolver;
import org.smoodi.web.handler.returnvalue.MethodHandlerReturnValueResolver;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Module
public class MethodHandlerInvokerImpl implements MethodHandlerInvoker {

    private final MethodHandlerArgumentResolver argumentResolver;

    private final MethodHandlerReturnValueResolver returnValueResolver;

    @Override
    public void invoke(@NotNull MethodHandler handler, @NotNull HttpRequest request, @NotNull HttpResponse response) {
        final List<Object> extracted = new ArrayList<>(handler.getParameterCount());

        handler.getParameters().forEach(parameter ->
                extracted.add(
                        argumentResolver.resolveArgument(request, parameter, handler)
                ));
        Object returnValue;

        try {
            returnValue = handler.getMethod().invoke(handler.getDeclaredObject(), extracted.toArray());
        } catch (IllegalAccessException e) {
            throw new StatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Method access error: " + e.getMessage(), e);
        } catch (InvocationTargetException e) {
            throw new HandlerExceptionWrapper(e.getCause());
        }

        if (returnValueResolver.supports(returnValue)) {
            returnValueResolver.resolveReturnValue(response, returnValue, handler);
        }
    }
}
