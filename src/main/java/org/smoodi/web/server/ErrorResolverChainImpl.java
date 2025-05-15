package org.smoodi.web.server;

import org.smoodi.core.SmoodiFramework;
import org.smoodi.core.annotation.Module;
import org.smoodi.core.util.LazyInitUnmodifiableCollection;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.physalus.transfer.http.HttpStatus;
import org.smoodi.web.StatusException;

@Module
public class ErrorResolverChainImpl implements ErrorResolverChain {

    private final LazyInitUnmodifiableCollection<ErrorResolver> resolvers = new LazyInitUnmodifiableCollection<>();

    private boolean initialized = false;

    private synchronized void init() {
        if (initialized)
            return;
        initialized = true;

        resolvers.initWith(
                SmoodiFramework.getInstance().getModuleContainer().getModulesByClass(ErrorResolver.class)
        );
    }

    @Override
    public void resolve(Throwable throwable, HttpRequest request, HttpResponse response) {
        init();

        for (ErrorResolver resolver : resolvers.get()) {
            if (resolver.supports(throwable)) {
                resolver.resolve(throwable, request, response);
                return;
            }
        }

        response.json(ErrorResponse.of(new StatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error")));
    }
}
