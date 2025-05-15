package org.smoodi.web.router;

import org.smoodi.core.SmoodiFramework;
import org.smoodi.core.annotation.Module;
import org.smoodi.core.util.LazyInitUnmodifiableCollection;
import org.smoodi.physalus.transfer.Request;
import org.smoodi.physalus.transfer.Response;

@Module(isPrimary = true)
public class RouterComposite implements Router {

    private final LazyInitUnmodifiableCollection<Router> routers = new LazyInitUnmodifiableCollection<>();

    private boolean initialized = false;

    private synchronized void init() {
        if (initialized) return;
        initialized = true;

        routers.initWith(
                SmoodiFramework.getInstance().getModuleContainer()
                        .getModulesByClass(Router.class).stream()
                        .filter(it -> !this.equals(it))
                        .toList()
        );
    }

    @Override
    public boolean supports(Request request) {
        init();

        return routers.get().stream().anyMatch(it -> it.supports(request));
    }

    @Override
    public void route(Request request, Response response) {
        init();
        assert supports(request);

        var supports = routers.get().stream().filter(it -> it.supports(request)).findFirst();

        supports.get().route(request, response);
    }
}
