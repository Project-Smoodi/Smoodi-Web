package org.smoodi.web.server;

import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.web.StatusException;

@Module
public class StatusExceptionResolver implements ErrorResolver {

    @Override
    public boolean supports(Throwable error) {
        return error instanceof StatusException;
    }

    @Override
    public void resolve(Throwable error, HttpRequest request, HttpResponse response) {
        assert supports(error);

        var statusException = (StatusException) error;

        response.setStatusCode(statusException.getStatus());
        response.json(ErrorResponse.of(statusException));
    }
}
