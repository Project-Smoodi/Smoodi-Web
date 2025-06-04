package org.smoodi.web;

import lombok.Getter;
import org.smoodi.annotation.StaticFactoryMethod;
import org.smoodi.physalus.transfer.http.HttpStatus;

@Getter
public class StatusException extends RuntimeException {

    public final HttpStatus status;

    private final String message;

    public StatusException(HttpStatus status) {
        this(status, status.reason);
    }

    public StatusException(HttpStatus status, String message) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public StatusException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.status = status;
    }

    public StatusException(HttpStatus status, Throwable cause) {
        super(status.reason, cause);
        this.message = status.reason;
        this.status = status;
    }

    @StaticFactoryMethod
    public static StatusException of(HttpStatus status) {
        return new StatusException(status, status.reason);
    }
}
