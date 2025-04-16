package org.smoodi.web.handler.argument;

import lombok.RequiredArgsConstructor;
import org.smoodi.annotation.NotNull;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.web.handler.MethodHandler;

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

    @NotNull
    @Override
    public final boolean supports(@NotNull final Parameter parameter) {
        assert parameter != null;

        return Arrays.stream(parameter.getAnnotations())
                .anyMatch(it -> it.annotationType().equals(targetAnnotation));
    }

    @NotNull
    @Override
    public final Object resolveArgument(
            @NotNull final HttpRequest request,
            @NotNull final Parameter parameter
    ) {
        assert this.supports(parameter);

        final var annotation = Arrays.stream(parameter.getAnnotations())
                .filter(it -> it.annotationType().equals(targetAnnotation)).findFirst();

        return annotation
                .map(value ->
                        resolveArgumentInternal(request, parameter, value))
                .orElse(null);
    }

    @NotNull
    protected abstract Object resolveArgumentInternal(
            @NotNull final HttpRequest request,
            @NotNull final Parameter methodParameter,
            @NotNull final Annotation annotation
    );
}
