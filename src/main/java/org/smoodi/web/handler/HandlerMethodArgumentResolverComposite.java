package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;
import org.smoodi.annotation.array.UnmodifiableArray;
import org.smoodi.core.SmoodiFramework;
import org.smoodi.core.annotation.Module;
import org.smoodi.net.exchange.HttpRequest;

import java.lang.reflect.Parameter;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Module
public class HandlerMethodArgumentResolverComposite implements HandlerMethodArgumentResolver {

    @UnmodifiableArray
    private final Set<HandlerMethodArgumentResolver> resolvers =
            SmoodiFramework.getInstance().getModuleContainer()
                    .getModulesByClass(HandlerMethodArgumentResolver.class)
                    .stream().collect(Collectors.toUnmodifiableSet());

    @Nullable
    @Override
    public <T> T resolveArgument(
            @NotNull HttpRequest request,
            @NotNull Parameter methodParameter,
            @NotNull Class<T> paramType
    ) {
        return resolvers.stream()
                .map(it -> it.resolveArgument(request, methodParameter, paramType))
                .filter(Objects::nonNull)
                .findFirst().orElse(null);
    }
}
