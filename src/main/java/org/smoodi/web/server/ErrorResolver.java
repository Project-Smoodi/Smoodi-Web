package org.smoodi.web.server;

import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;

public interface ErrorResolver {

    boolean supports(Throwable error);

    void resolve(Throwable error, HttpRequest request, HttpResponse response);
}
