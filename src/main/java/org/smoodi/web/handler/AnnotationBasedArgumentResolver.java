package org.smoodi.web.handler;

import lombok.RequiredArgsConstructor;
import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;
import org.smoodi.net.exchange.HttpRequest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class AnnotationBasedArgumentResolver implements HandlerMethodArgumentResolver {

    protected final Class<? extends Annotation> targetAnnotation;

    @Nullable
    @Override
    public final <T> T resolveArgument(
            @NotNull HttpRequest request,
            @NotNull Parameter methodParameter,
            @NotNull Class<T> paramType
    ) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(methodParameter);
        Objects.requireNonNull(paramType);

        final var annotation = Arrays.stream(methodParameter.getAnnotations())
                .filter(it -> it.annotationType().equals(targetAnnotation)).findFirst();

        return annotation
                .map(value ->
                        resolveArgumentInternal(request, methodParameter, paramType, value))
                .orElse(null);
    }

    @NotNull
    protected abstract <T> T resolveArgumentInternal(
            @NotNull HttpRequest request,
            @NotNull Parameter methodParameter,
            @NotNull Class<T> paramType,
            @NotNull Annotation annotation
    );
}
