package org.smoodi.web.handler;

import org.smoodi.net.exchange.HttpStatus;
import org.smoodi.web.StatusException;

/**
 * <p>{@link org.smoodi.web.handler.annotation.Handler Handler}에서 요구하는 요청 인자에 잘못된 값을 제공했을 경우 발생.</p>
 *
 * @author Daybreak312
 * @see MissingParameterException
 * @since v0.0.1
 */
public class InvalidParameterValueException extends StatusException {

    public InvalidParameterValueException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
