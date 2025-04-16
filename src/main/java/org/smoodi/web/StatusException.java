package org.smoodi.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.smoodi.physalus.transfer.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class StatusException extends RuntimeException {

    public final HttpStatus status;

    private final String message;
}
