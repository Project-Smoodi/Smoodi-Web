package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;
import org.smoodi.net.exchange.HttpRequest;

import java.lang.reflect.Parameter;

/**
 * <p>{@link MethodHandler}의 {@link MethodHandler#getMethod 내부 메소드}를 실행하기 위해, 함수의 각 매개변수에게 요구되는 값을 주입하는 모듈.</p>
 *
 * <p>인터페이스의 구현체는 임의의 한 개 타입 혹은 범위에 대해서만 실행해야 함.</p>
 *
 * @author Daybreak312
 * @see MethodHandler
 * @see AnnotationBasedArgumentResolver
 * @see HandlerArgumentCaster
 * @since v0.0.1
 */
public interface HandlerMethodArgumentResolver {

    /**
     * <p>값이 필요한 매개변수의 정보를 제공하고, 주입 가능한 값을 반환.</p>
     *
     * @param request         현재 요청 정보
     * @param methodParameter 매개변수 정보
     * @param paramType       매개변수 타입 Reflection
     * @param T             매개변수 타입
     * @return 매개변수에 주입 가능한 값
     */
    @Nullable
    <T> T resolveArgument(
            @NotNull final HttpRequest request,
            @NotNull final Parameter methodParameter,
            @NotNull final Class<T> paramType
    );
}
