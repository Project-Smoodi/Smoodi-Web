package org.smoodi.web.server;

import org.smoodi.annotation.NotNull;
import org.smoodi.physalus.transfer.Request;
import org.smoodi.physalus.transfer.Response;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;

public interface SimpleHttpGateway extends SimpleGateway {

    @NotNull
    @Override
    default HttpResponse service(@NotNull Request request, @NotNull Response response) {
        if (request instanceof HttpRequest && response instanceof HttpResponse) {
            return serviceInner((HttpRequest) request, (HttpResponse) response);
        }

        throw new UnsupportedOperationException("Only http exchanges are supported.");
    }

    @NotNull
    HttpResponse serviceInner(@NotNull HttpRequest request, @NotNull HttpResponse response);
}
