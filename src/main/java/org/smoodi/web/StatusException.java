package org.smoodi.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.smoodi.annotation.StaticFactoryMethod;
import org.smoodi.physalus.transfer.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class StatusException extends RuntimeException {

    public final HttpStatus status;

    private final String message;

    @StaticFactoryMethod
    public static StatusException of(HttpStatus status) {
        return new StatusException(status, status.reason);
    }
}
