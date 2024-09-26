package org.smoodi.web.handler;

import org.smoodi.net.exchange.HttpStatus;
import org.smoodi.web.StatusException;

public class MissingParameterException extends StatusException {

    public MissingParameterException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
