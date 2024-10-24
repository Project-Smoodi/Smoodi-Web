package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.core.annotation.Module;
import org.smoodi.core.util.Nullability;
import org.smoodi.net.exchange.HttpRequest;
import org.smoodi.web.handler.annotation.QueryParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

@Module
public class QueryParamArgumentResolver extends AnnotationBasedArgumentResolver {

    public QueryParamArgumentResolver() {
        super(QueryParam.class);
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
        assert annotation instanceof QueryParam;

        String key = Nullability.firstOrSecondIfBlank(
                ((QueryParam) annotation).value(),
                parameter::getName
        );

        String param = request.getParams().get(key);

        if (param == null) {
            throw new MissingParameterException("Missing Query String Parameter: " + key);
        }

        return HandlerArgumentCaster.cast(param, parameter.getType());
    }
}
