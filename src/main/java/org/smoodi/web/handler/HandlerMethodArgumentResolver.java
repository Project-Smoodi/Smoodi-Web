package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.net.exchange.HttpRequest;

import java.lang.reflect.Parameter;

public interface HandlerMethodArgumentResolver {

    <T> T resolveArgument(
            @NotNull HttpRequest request,
            @NotNull Parameter methodParameter,
            @NotNull Class<T> paramType
    );
}
