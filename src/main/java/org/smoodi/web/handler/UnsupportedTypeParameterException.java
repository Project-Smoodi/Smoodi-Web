package org.smoodi.web.handler;

import org.smoodi.physalus.transfer.http.HttpStatus;
import org.smoodi.web.StatusException;

/**
 * <p>{@link org.smoodi.web.handler.annotation.Handler Handler}에서 호환되지 않는 타입으로 요청 정보를 받아오려 했을 때 발생하는 예외.</p>
 *
 * <p>{@link org.smoodi.web.handler.annotation.Handler Handler}가 잘못 작성된 것을 의미함.</p>
 *
 * @author Daybreak312
 * @since v0.0.1
 */
public class UnsupportedTypeParameterException extends StatusException {

    public UnsupportedTypeParameterException(final String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
