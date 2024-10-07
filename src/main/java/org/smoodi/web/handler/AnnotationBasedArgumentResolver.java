package org.smoodi.web.handler;

import lombok.RequiredArgsConstructor;
import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;
import org.smoodi.net.exchange.HttpRequest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * <p>매개변수에 부착된 어노테이션을 기반으로 값을 주입하는 {@link HandlerMethodArgumentResolver}</p>
 *
 * @author Daybreak312
 * @see MethodHandler
 * @see HandlerMethodArgumentResolver
 * @since 0.0.1
 */
@RequiredArgsConstructor
public abstract class AnnotationBasedArgumentResolver implements HandlerMethodArgumentResolver {

    protected final Class<? extends Annotation> targetAnnotation;

    @Nullable
    @Override
    public final <T> T resolveArgument(
            @NotNull final HttpRequest request,
            @NotNull final Parameter methodParameter,
            @NotNull final Class<T> paramType
    ) {

        final var annotation = Arrays.stream(methodParameter.getAnnotations())
                .filter(it -> it.annotationType().equals(targetAnnotation)).findFirst();

        return annotation
                .map(value ->
                        resolveArgumentInternal(request, methodParameter, paramType, value))
                .orElse(null);
    }

    @NotNull
    protected abstract <T> T resolveArgumentInternal(
            @NotNull final HttpRequest request,
            @NotNull final Parameter methodParameter,
            @NotNull final Class<T> paramType,
            @NotNull final Annotation annotation
    );
}
