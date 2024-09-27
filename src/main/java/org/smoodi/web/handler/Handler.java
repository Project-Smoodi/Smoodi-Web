package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;

/**
 * <p>{@link org.smoodi.web.handler.annotation.Handler Handler}를 Smoodi에서 일관된 표현으로 사용하기 위한 Reflection-like Interface.</p>
 *
 * @author Daybreak312
 * @since v0.0.1
 */
public interface Handler {

    /**
     * <p>해당 {@link org.smoodi.web.handler.annotation.Handler Handler}가 주어진 요청을 처리할 수 있는지 확인.</p>
     *
     * @param request {@link org.smoodi.web.handler.annotation.Handler Handler}에게 요구하는 처리해야 할 요청 객체
     * @return 요청을 처리 가능한지의 여부
     */
    boolean supports(@NotNull Request request);

    /**
     * <p>주어진 요청을 처리.</p>
     *
     * @param request 요청 객체.
     * @param response 요청 처리 결과를 담을 응답 객체.
     */
    void handle(@NotNull Request request, @NotNull Response response);
}
