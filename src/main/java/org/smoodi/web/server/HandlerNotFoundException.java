package org.smoodi.web.server;

import org.smoodi.physalus.transfer.http.HttpStatus;
import org.smoodi.web.StatusException;

/**
 * <p>요청을 처리할 수 있는 Handler를 찾지 못했을 때 발생</p>
 *
 * @author Daybreak312
 * @see org.smoodi.web.handler.annotation.Handler
 * @see org.smoodi.web.handler.annotation.RequestPath
 */
public class HandlerNotFoundException extends StatusException {

    public HandlerNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
