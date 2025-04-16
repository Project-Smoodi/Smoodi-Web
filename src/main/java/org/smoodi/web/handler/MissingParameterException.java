package org.smoodi.web.handler;

import org.smoodi.physalus.transfer.http.HttpStatus;
import org.smoodi.web.StatusException;

/**
 * <p>{@link org.smoodi.web.handler.annotation.Handler Handler}에서 요구하는 요청 인자를 클라이언트에서 제공하지 않은 경우 발생.</p>
 *
 * @author Daybreak312
 * @see InvalidParameterValueException
 * @since v0.0.1
 */
public class MissingParameterException extends StatusException {

    public MissingParameterException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
