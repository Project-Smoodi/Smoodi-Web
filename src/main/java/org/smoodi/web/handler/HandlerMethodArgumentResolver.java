package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.net.exchange.HttpRequest;

import java.lang.reflect.Parameter;

/**
 * <p>{@link MethodHandler}의 {@link MethodHandler#getMethod 내부 메소드}를 실행하기 위해, 함수의 각 매개변수에서 요구되는 값을 요청에서 찾고 주입하는 모듈.</p>
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
     * <p>이 객체가 주어진 매개변수에서 요구되는 값을 찾을 수 있는지 여부를 반환.</p>
     *
     * @param parameter 값을 요구하는 매개변수
     * @return 주어진 매개변수를 처리할 수 있다면 {@code true}, 아닐 경우 {@code false}
     */
    @NotNull
    boolean supports(@NotNull final Parameter parameter);

    /**
     * <p>값이 필요한 매개변수의 정보를 제공하고, 주입 가능한 값을 반환.</p>
     *
     * <p>이 메소드 호출 이전에, {@link HandlerMethodArgumentResolver#supports} 메소드를 통해 매개변수를 처리할 수 있는지 확인할 것.</p>
     *
     * @param request   현재 요청 정보
     * @param parameter 매개변수 정보
     * @return 매개변수에 주입 가능한 값
     * @throws AssertionError 주어진 매개변수를 처리할 수 없을 경우
     */
    @NotNull
    Object resolveArgument(
            @NotNull final HttpRequest request,
            @NotNull final Parameter parameter
    );
}
