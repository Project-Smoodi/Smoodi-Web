package org.smoodi.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.smoodi.net.exchange.HttpStatus;

@Getter
@RequiredArgsConstructor
public class StatusException extends RuntimeException {

    public final HttpStatus status;

    private final String message;
}
