package org.smoodi.web.server;

import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.physalus.transfer.http.HttpStatus;
import org.smoodi.web.StatusException;

import java.util.Set;

@Module
public class JavaExceptionResolver implements ErrorResolver {

    private static final Set<Class<? extends Throwable>> SUPPORTED_EXCEPTIONS = Set.of(
            IllegalArgumentException.class
    );

    @Override
    public boolean supports(Throwable error) {
        return SUPPORTED_EXCEPTIONS.stream()
                .anyMatch(supportedException -> supportedException.isAssignableFrom(error.getClass()));
    }

    @Override
    public void resolve(Throwable error, HttpRequest request, HttpResponse response) {
        assert supports(error);

        if (error instanceof IllegalArgumentException) {
            response.setStatusCode(HttpStatus.BAD_REQUEST); // Bad Request
            response.json(ErrorResponse.of(
                    new StatusException(HttpStatus.BAD_REQUEST, error.getMessage()
                    )));
        }
    }
}
