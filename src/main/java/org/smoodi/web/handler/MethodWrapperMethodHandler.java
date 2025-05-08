package org.smoodi.web.handler;

import lombok.Getter;
import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.array.EmptyableArray;
import org.smoodi.annotation.array.UnmodifiableArray;
import org.smoodi.physalus.transfer.http.ContentType;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.web.handler.annotation.RequestPath;
import org.smoodi.web.handler.argument.MethodHandlerInvoker;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MethodWrapperMethodHandler implements RequestPathMethodHandler {

    @Getter
    private final Object declaredObject;

    @Getter
    private final Method method;

    private final RequestPath requestPath;

    @EmptyableArray
    private final Parameter[] parameters;

    private final MethodHandlerInvoker invoker;

    public MethodWrapperMethodHandler(
            @NotNull final Object object,
            @NotNull final Method method,
            @NotNull final RequestPath requestPath,
            @NotNull final MethodHandlerInvoker invoker
    ) {
        this.declaredObject = Objects.requireNonNull(object);
        this.method = Objects.requireNonNull(method);
        this.requestPath = Objects.requireNonNull(requestPath);
        this.parameters = method.getParameters();
        this.invoker = Objects.requireNonNull(invoker);
    }

    @EmptyableArray
    @UnmodifiableArray
    @Override
    public List<Parameter> getParameters() {
        return Arrays.stream(parameters.clone()).toList();
    }

    @Override
    public int getParameterCount() {
        return parameters.length;
    }

    @Override
    public String getName() {
        return method.getName();
    }

    @Override
    public RequestPath getRequestPath() {
        return requestPath;
    }

    @Override
    public String getPath() {
        return requestPath.path();
    }

    @EmptyableArray
    @UnmodifiableArray
    @Override
    public List<String> params() {
        return List.of(this.requestPath.params());
    }

    @EmptyableArray
    @UnmodifiableArray
    @Override
    public List<String> getHeaders() {
        return List.of(this.requestPath.headers());
    }

    @Override
    public ContentType[] contentTypes() {
        return this.requestPath.contentTypes();
    }

    @Override
    public boolean supports(@NotNull final HttpRequest request) {

        if (!request.getPath().equals(this.requestPath.path())) {
            return false;
        }

        if (!(request.getParams().keySet()
                .containsAll(
                        List.of(this.requestPath.params())
                ))) {
            return false;
        }

        if (!(request.getHeaders().toMap().keySet()
                .containsAll(
                        List.of(this.requestPath.headers())
                ))) {
            return false;
        }

        return request.getMethod().equals(this.requestPath.method());
    }

    @Override
    public void handle(@NotNull HttpRequest request, @NotNull HttpResponse response) {
        invoker.invoke(this, Objects.requireNonNull(request), Objects.requireNonNull(response));
    }
}
