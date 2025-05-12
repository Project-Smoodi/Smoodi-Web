package org.smoodi.web.server;

import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Overload;
import org.smoodi.physalus.transfer.Request;
import org.smoodi.physalus.transfer.Response;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;

public interface HttpGateway extends Gateway {

    @NotNull
    @Override
    default HttpResponse service(@NotNull Request request, @NotNull Response response) {
        if (request instanceof HttpRequest && response instanceof HttpResponse) {
            return service((HttpRequest) request, (HttpResponse) response);
        }

        throw new UnsupportedOperationException("Only http exchanges are supported.");
    }

    @NotNull
    @Overload
    HttpResponse service(@NotNull HttpRequest request, @NotNull HttpResponse response);
}
