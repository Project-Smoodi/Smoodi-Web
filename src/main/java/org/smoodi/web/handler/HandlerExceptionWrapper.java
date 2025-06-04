package org.smoodi.web.handler;

public class HandlerExceptionWrapper extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HandlerExceptionWrapper() {
        super();
    }

    public HandlerExceptionWrapper(String message) {
        super(message);
    }

    public HandlerExceptionWrapper(String message, Throwable cause) {
        super(message, cause);
    }

    public HandlerExceptionWrapper(Throwable cause) {
        super(cause);
    }

    protected HandlerExceptionWrapper(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
