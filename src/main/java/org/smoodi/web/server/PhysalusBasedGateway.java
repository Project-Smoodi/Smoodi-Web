package org.smoodi.web.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.web.router.Router;

@Slf4j
@RequiredArgsConstructor
@Module
public class PhysalusBasedGateway implements HttpGateway {

    private final Router router;

    private final ErrorResolverChain errorResolver;

    @Override
    public HttpResponse service(HttpRequest request, HttpResponse response) {
        try {
            routing(request, response);
        } catch (Exception e) {
            errorResolver.resolve(e, request, response);
        }

        loggingResponse(request, response);

        return response;
    }

    public void routing(HttpRequest request, HttpResponse response) {
        if (router.supports(request)) {
            router.route(request, response);
        } else {
            throw new HandlerNotFoundException(String.format("Handler not found for request: %s", request.getPath()));
        }
    }

    public void loggingResponse(HttpRequest request, HttpResponse response) {
        log.info("{} {} :: [{} {}]",
                request.getMethod().value,
                request.getPath(),
                response.getStatusCode().status,
                response.getStatusCode().reason
        );
    }
}
