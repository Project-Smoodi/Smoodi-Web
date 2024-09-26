package org.smoodi.web.handler;

import org.smoodi.net.exchange.HttpStatus;
import org.smoodi.web.StatusException;

public class UnsupportedTypeParameterException extends StatusException {

    public UnsupportedTypeParameterException(final String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
