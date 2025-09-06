package org.smoodi.web.router;

import org.smoodi.physalus.transfer.Request;
import org.smoodi.physalus.transfer.Response;

public interface Router {

    boolean supports(Request request);

    void route(Request request, Response response);
}
