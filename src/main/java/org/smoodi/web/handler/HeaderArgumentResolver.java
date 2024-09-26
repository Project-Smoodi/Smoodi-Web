package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.core.annotation.Module;
import org.smoodi.net.exchange.HttpRequest;
import org.smoodi.web.handler.annotation.Header;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

@Module
public class HeaderArgumentResolver extends AnnotationBasedArgumentResolver {

    public HeaderArgumentResolver() {
        super(Header.class);
    }

    @NotNull
    @Override
    protected <T> T resolveArgumentInternal(
            @NotNull final HttpRequest request,
            @NotNull final Parameter methodParameter,
            @NotNull final Class<T> paramType,
            @NotNull final Annotation annotation
    ) {
        assert annotation instanceof Header;

        String header = request.getHeaders().get(((Header) annotation).value());

        if (header == null) {
            throw new MissingParameterException("Missing Header: " + ((Header) annotation).value());
        }

        if (header.isEmpty()) {
            header = request.getHeaders().get(methodParameter.getName());

            if (header == null) {
                throw new MissingParameterException("Missing Header: " + methodParameter.getName());
            }
        }

        if (paramType.equals("".getClass())) {
            // noinspection unchecked
            return (T) header;
        }

        throw new UnsupportedTypeParameterException("Unsupported type for header value: " + paramType.getName());
    }
}
