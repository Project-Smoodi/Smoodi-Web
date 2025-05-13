package org.smoodi.web.handler.argument;

import org.smoodi.annotation.NotNull;
import org.smoodi.core.annotation.Module;
import org.smoodi.net.util.PathUtils;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.web.handler.HandlerDefineError;
import org.smoodi.web.handler.MethodHandler;
import org.smoodi.web.handler.RequestPathMethodHandler;
import org.smoodi.web.handler.annotation.PathParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.Arrays;

@Module
public class PathParamArgumentResolver extends AnnotationBasedArgumentResolver {

    public PathParamArgumentResolver() {
        super(PathParam.class);
    }

    @NotNull
    @Override
    protected Object resolveArgumentInternal(
            @NotNull final HttpRequest request,
            @NotNull final Parameter methodParameter,
            @NotNull final Annotation annotation,
            @NotNull final MethodHandler handler
    ) {
        assert request != null;
        assert methodParameter != null;
        assert annotation != null;
        assert annotation instanceof PathParam;
        assert handler instanceof RequestPathMethodHandler;

        final RequestPathMethodHandler handler1 = (RequestPathMethodHandler) handler;

        final var pathParamRegex = "{" + ((PathParam) annotation).value() + "}";

        if (!handler1.getRequestPath().path().contains(pathParamRegex)) {
            throw new HandlerDefineError("Invalid path param: " + ((PathParam) annotation).value() + " for request path: " + handler1.getRequestPath().path());
        }

        final var path = Arrays.stream(PathUtils.formatPath(((PathParam) annotation).value()).split("/")).toList();
        final var reqPath = Arrays.stream(PathUtils.formatPath(request.getPath()).split("/")).toList();

        return reqPath.get(path.indexOf(pathParamRegex));
    }
}
