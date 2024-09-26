package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;
import org.smoodi.net.exchange.HttpRequest;

import java.lang.reflect.Parameter;

public interface HandlerMethodArgumentResolver {

    @Nullable
    <T> T resolveArgument(
            @NotNull final HttpRequest request,
            @NotNull final Parameter methodParameter,
            @NotNull final Class<T> paramType
    );
}
