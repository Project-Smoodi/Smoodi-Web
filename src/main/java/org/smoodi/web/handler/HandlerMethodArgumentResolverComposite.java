package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.array.UnmodifiableArray;
import org.smoodi.core.SmoodiFramework;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpRequest;

import java.lang.reflect.Parameter;
import java.util.Set;
import java.util.stream.Collectors;

@Module(isPrimary = true)
public final class HandlerMethodArgumentResolverComposite implements HandlerMethodArgumentResolver {

    @UnmodifiableArray
    private Set<HandlerMethodArgumentResolver> resolvers;

    private boolean initialized = false;

    private void init() {
        if (initialized) {
            return;
        }

        resolvers = SmoodiFramework.getInstance().getModuleContainer()
                .getModulesByClass(HandlerMethodArgumentResolver.class)
                .stream().collect(Collectors.toUnmodifiableSet());

        initialized = true;
    }

    @NotNull
    @Override
    public boolean supports(Parameter parameter) {
        return resolvers.stream()
                .anyMatch(resolver -> resolver.supports(parameter));
    }

    @NotNull
    @Override
    public Object resolveArgument(
            @NotNull HttpRequest request,
            @NotNull Parameter parameter
    ) {
        init();
        assert this.supports(parameter);

        final var supports = resolvers.stream()
                .filter(it -> it.supports(parameter));

        if (supports.count() != 1) {
            throw new IllegalStateException("More than one " + HandlerMethodArgumentResolver.class.getSimpleName() + " was found about one type.");
        }

        return supports.findFirst().get().resolveArgument(request, parameter);
    }
}
