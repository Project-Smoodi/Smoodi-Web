package org.smoodi.web.handler;

import org.smoodi.core.SmoodiFramework;
import org.smoodi.core.annotation.Module;
import org.smoodi.core.module.ModuleDeclareError;
import org.smoodi.core.util.LazyInitUnmodifiableCollection;
import org.smoodi.physalus.transfer.Request;

import java.util.Set;

@Module
public final class DefaultHandlerContainer implements HandlerContainer {

    LazyInitUnmodifiableCollection<Set<Handler>> handlers = new LazyInitUnmodifiableCollection<>();

    private void init() {
        if (handlers.isInitialized()) {
            return;
        }

        handlers.initWith(
                SmoodiFramework.getInstance().getModuleContainer().getModulesByClass(Handler.class)
        );
    }

    @Override
    public Handler getHandler(Request request) {
        init();
        var supports = handlers.get().stream().filter(
                it -> it.supports(request)
        ).toList();

        if (supports.isEmpty()) {
            return null;
        }
        if (supports.size() > 1) {
            throw new ModuleDeclareError("There are more than one handler for request: " + request);
        }

        return supports.getFirst();
    }
}
