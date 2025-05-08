package org.smoodi.web.handler.argument;

/**
 * <p>{@link org.smoodi.web.handler.annotation.Handler}가 잘못 정의되었을 때 발생하는 에러.</p>
 *
 * <p>{@link org.smoodi.web.handler.annotation.PathParam @PathParam}이 정의되어 있으나, {@link org.smoodi.web.handler.annotation.RequestPath @RequestPath}에는 PathParam에 대한 정보가 기입되어 있지 않은 {@link PathParamArgumentResolver 상황} 등에서 발생</p>
 */
public class HandlerDefineError extends Error {

    public HandlerDefineError(String message) {
        super(message);
    }
}
