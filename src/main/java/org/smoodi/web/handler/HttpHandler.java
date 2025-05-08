package org.smoodi.web.handler;

import org.smoodi.physalus.transfer.Request;
import org.smoodi.physalus.transfer.Response;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;

public interface HttpHandler extends Handler {

    @Override
    default boolean supports(Request request) {
        if (request instanceof HttpRequest r) {
            return supports(r);
        }

        return false;
    }

    boolean supports(HttpRequest request);

    @Override
    default void handle(Request request, Response response) {
        if (request instanceof HttpRequest && response instanceof HttpResponse) {
            handle(
                    (HttpRequest) request,
                    (HttpResponse) response
            );
        } else {
            throw new IllegalArgumentException(
                    "Unsupported request or response type: " + request.getClass() + ", " + request.getClass());
        }
    }

    void handle(HttpRequest request, HttpResponse response);
}
