package org.smoodi.web.server;

import org.smoodi.annotation.NotNull;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;

public interface ErrorResolverChain {

    void resolve(
            @NotNull Throwable throwable,
            @NotNull HttpRequest request,
            @NotNull HttpResponse response
    );
}
