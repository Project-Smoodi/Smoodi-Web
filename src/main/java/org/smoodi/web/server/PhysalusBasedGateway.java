package org.smoodi.web.server;

import lombok.RequiredArgsConstructor;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.web.router.HandlerContainerRouter;

@RequiredArgsConstructor
@Module
public class PhysalusBasedGateway implements HttpGateway {

    private final HandlerContainerRouter router;

    @Override
    public HttpResponse service(HttpRequest request, HttpResponse response) {
        if (router.supports(request)) {
            router.route(request, response);
        }

        return response;
    }
}
