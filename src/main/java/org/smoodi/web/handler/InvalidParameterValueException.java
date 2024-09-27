package org.smoodi.web.handler;

import org.smoodi.net.exchange.HttpStatus;
import org.smoodi.web.StatusException;

public class InvalidParameterValueException extends StatusException {

    public InvalidParameterValueException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
