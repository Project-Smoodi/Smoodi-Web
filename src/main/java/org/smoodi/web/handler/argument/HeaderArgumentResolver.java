package org.smoodi.web.handler.argument;

import org.smoodi.annotation.NotNull;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.web.handler.annotation.Header;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

@Module
public final class HeaderArgumentResolver extends AnnotationBasedArgumentResolver {

    public HeaderArgumentResolver() {
        super(Header.class);
    }

    @NotNull
    @Override
    protected Object resolveArgumentInternal(
            @NotNull final HttpRequest request,
            @NotNull final Parameter parameter,
            @NotNull final Annotation annotation
    ) {
        assert request != null;
        assert parameter != null;
        assert annotation != null;
        assert annotation instanceof Header;

        String header = request.getHeaders().get(((Header) annotation).value());

        if (header == null) {
            throw new MissingParameterException("Missing Header: " + ((Header) annotation).value());
        }

        if (header.isEmpty()) {
            header = request.getHeaders().get(parameter.getName());

            if (header == null) {
                throw new MissingParameterException("Missing Header: " + parameter.getName());
            }
        }

        return HandlerArgumentCaster.cast(header, parameter.getType());
    }
}
