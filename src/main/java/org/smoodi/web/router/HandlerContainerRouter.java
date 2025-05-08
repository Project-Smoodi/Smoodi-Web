package org.smoodi.web.router;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.Request;
import org.smoodi.physalus.transfer.Response;
import org.smoodi.web.handler.HandlerContainer;

@RequiredArgsConstructor
@Module
public class HandlerContainerRouter implements Router {

    private final HandlerContainer handlerContainer;

    @Override
    public boolean supports(Request request) {
        return handlerContainer.getHandler(request) != null;
    }

    @Override
    public void route(@NonNull Request request, Response response) {
        handlerContainer.getHandler(request).handle(request, response);
    }
}
