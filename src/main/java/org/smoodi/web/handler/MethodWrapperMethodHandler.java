package org.smoodi.web.handler;

import lombok.Getter;
import org.smoodi.web.handler.annotation.RequestPath;
import org.smoodi.web.server.exchange.ContentType;
import org.smoodi.web.server.exchange.HttpRequest;
import org.smoodi.web.server.exchange.Request;
import org.smoodi.web.server.exchange.Response;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

public class MethodWrapperMethodHandler implements RequestPathHandler, MethodHandler {

    @Getter
    private final Method method;

    private final RequestPath requestPath;

    private final Parameter[] parameters;

    public MethodWrapperMethodHandler(
            final Method method,
            final RequestPath requestPath
    ) {
        this.method = method;
        this.requestPath = requestPath;
        this.parameters = method.getParameters();
    }

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

    @Override
    public List<String> params() {
        return List.of(this.requestPath.params());
    }

    @Override
    public List<String> getHeaders() {
        return List.of(this.requestPath.headers());
    }

    @Override
    public ContentType[] contentTypes() {
        return this.requestPath.contentTypes();
    }

    @Override
    public boolean supports(final Request request) {
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
    public Response handle(Request request) {

        // TODO("Handler..")
        return null;
    }
}
