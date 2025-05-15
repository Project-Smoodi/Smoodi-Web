package org.smoodi.web.handler.returnvalue;

import org.smoodi.annotation.array.UnmodifiableArray;
import org.smoodi.core.SmoodiFramework;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.web.handler.MethodHandler;

import java.util.Set;
import java.util.stream.Collectors;


@Module(isPrimary = true)
public class MethodHandlerReturnValueResolverComposite implements MethodHandlerReturnValueResolver {

    @UnmodifiableArray
    private Set<MethodHandlerReturnValueResolver> resolvers;

    private boolean initialized = false;

    private synchronized void init() {
        if (initialized) return;

        resolvers = SmoodiFramework.getInstance().getModuleContainer()
                .getModulesByClass(MethodHandlerReturnValueResolver.class)
                .stream().filter(it -> it != this)
                .collect(Collectors.toSet());

        initialized = true;
    }

    @Override
    public boolean supports(Object returnValue) {
        init();
        return resolvers.stream().anyMatch(resolver -> resolver.supports(returnValue));
    }

    @Override
    public void resolveReturnValue(HttpResponse response, Object returnValue, MethodHandler handler) {
        init();
        assert this.supports(returnValue);

        for (MethodHandlerReturnValueResolver resolver : resolvers) {
            if (resolver.supports(returnValue)) {
                resolver.resolveReturnValue(response, returnValue, handler);
                return;
            }
        }

        // This should never happen
        throw new Error();
    }
}
