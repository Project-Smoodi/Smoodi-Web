package org.smoodi.web.handler.argument;

import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.array.UnmodifiableArray;
import org.smoodi.core.SmoodiFramework;
import org.smoodi.core.annotation.Module;
import org.smoodi.core.util.LazyInitUnmodifiableCollection;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.web.handler.MethodHandler;

import java.lang.reflect.Parameter;

@Module(isPrimary = true)
public final class MethodHandlerArgumentResolverComposite implements MethodHandlerArgumentResolver {

    @UnmodifiableArray
    private final LazyInitUnmodifiableCollection<MethodHandlerArgumentResolver> resolvers = new LazyInitUnmodifiableCollection<>();

    private boolean initialized = false;

    private void init() {
        if (initialized) {
            return;
        }

        resolvers.initWith(
                SmoodiFramework.getInstance().getModuleContainer()
                        .getModulesByClass(MethodHandlerArgumentResolver.class).stream()
                        .filter(it -> !this.equals(it))
                        .toList()
        );

        initialized = true;
    }

    @NotNull
    @Override
    public boolean supports(Parameter parameter) {
        return resolvers.get().stream()
                .anyMatch(resolver -> resolver.supports(parameter));
    }

    @NotNull
    @Override
    public Object resolveArgument(
            @NotNull final HttpRequest request,
            @NotNull final Parameter parameter,
            @NotNull final MethodHandler handler) {
        init();
        assert this.supports(parameter);

        for (final var resolver : resolvers.get()) {
            if (resolver.supports(parameter)) {
                return resolver.resolveArgument(request, parameter, handler);
            }
        }

        // This should never happen
        throw new Error();
    }
}
