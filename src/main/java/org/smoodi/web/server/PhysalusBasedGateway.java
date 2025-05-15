package org.smoodi.web.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.physalus.transfer.http.HttpStatus;
import org.smoodi.web.router.Router;

@Slf4j
@RequiredArgsConstructor
@Module
public class PhysalusBasedGateway implements HttpGateway {

    private final Router router;

    @Override
    public HttpResponse service(HttpRequest request, HttpResponse response) {
        if (router.supports(request)) {
            try {
                router.route(request, response);
            } catch (Exception e) {
                // TODO("Error Handling")
                log.error(e.getMessage(), e);
                response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND);
        }

        return response;
    }
}
