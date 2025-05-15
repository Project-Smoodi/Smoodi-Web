package org.smoodi.web;

import lombok.RequiredArgsConstructor;
import org.smoodi.core.Processor;
import org.smoodi.core.annotation.Module;
import org.smoodi.core.module.container.ModuleContainer;
import org.smoodi.core.util.AnnotationUtils;
import org.smoodi.web.handler.MethodHandlerInvoker;
import org.smoodi.web.handler.MethodWrapperMethodHandler;
import org.smoodi.web.handler.annotation.Handler;
import org.smoodi.web.handler.annotation.RequestPath;

import java.lang.reflect.Method;

@RequiredArgsConstructor
@Module
public class HandlerRegistrationProcessor implements Processor {

    private final ModuleContainer moduleContainer;

    private final MethodHandlerInvoker invoker;

    @Override
    public void start() {
        var handlerClassModules = moduleContainer
                .filter(it -> AnnotationUtils.findIncludeAnnotation(it, Handler.class) != null);

        handlerClassModules.forEach(handler -> {
            for (Method method : handler.getClass().getMethods()) {
                var anno = AnnotationUtils.findIncludeAnnotation(method, RequestPath.class);
                if (anno != null) {
                    moduleContainer.save(
                            new MethodWrapperMethodHandler(
                                    handler, method, anno, invoker
                            )
                    );
                }
            }
        });
    }

    @Override
    public void stop() {
    }
}
