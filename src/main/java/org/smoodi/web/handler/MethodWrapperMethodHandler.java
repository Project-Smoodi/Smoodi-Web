package org.smoodi.web.handler;

import lombok.Getter;
import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.array.EmptyableArray;
import org.smoodi.annotation.array.UnmodifiableArray;
import org.smoodi.net.exchange.ContentType;
import org.smoodi.net.exchange.HttpRequest;
import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;
import org.smoodi.web.handler.annotation.RequestPath;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MethodWrapperMethodHandler implements RequestPathHandler, MethodHandler {

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
    public boolean supports(@NotNull final Request request) {
        if (!(request instanceof HttpRequest)) {
            return false;
        }

        if (!((HttpRequest) request).getPath().equals(this.requestPath.path())) {
            return false;
        }

        if (!(((HttpRequest) request).getParams().keySet()
                .containsAll(
                        Arrays.stream(this.requestPath.params()).toList()
                ))) {
            return false;
        }

        if (!(((HttpRequest) request).getHeaders().toMap().keySet()
                .containsAll(
                        Arrays.stream(this.requestPath.headers()).toList()
                ))) {
            return false;
        }

        return ((HttpRequest) request).getMethod().equals(this.requestPath.method());
    }

    @Override
    public void handle(@NotNull Request request, @NotNull Response response) {
        invoker.invoke(this, Objects.requireNonNull(request), Objects.requireNonNull(response));
    }
}
