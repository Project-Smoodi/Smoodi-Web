package org.smoodi.web.handler.argument;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.smoodi.core.annotation.Module;
import org.smoodi.net.config.DefaultJacksonConfiguration;
import org.smoodi.physalus.transfer.http.ContentType;
import org.smoodi.physalus.transfer.http.HttpRequest;
import org.smoodi.web.handler.MethodHandler;
import org.smoodi.web.handler.annotation.RequestBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.Objects;

@Module
public class RequestBodyArgumentResolver extends AnnotationBasedArgumentResolver {


    public RequestBodyArgumentResolver() {
        super(RequestBody.class);
    }

    @Override
    protected Object resolveArgumentInternal(
            HttpRequest request,
            Parameter parameter,
            Annotation annotation,
            MethodHandler handler) {
        assert request != null;
        assert parameter != null;
        assert annotation != null;
        assert annotation instanceof RequestBody;

        Object body = request.getContent();
        String body0;

        if (body == null) {
            throw new MissingParameterException("Missing Request Body");
        }

        if (body instanceof String) {
            body0 = ((String) body).trim();
        } else {
            throw new UnsupportedTypeParameterException(
                    "Request Body must be a String, but was: " + body.getClass().getName()
            );
        }

        Object result;
        String contentType = request.getHeaders().contentType();
        if (Objects.equals(contentType, ContentType.APPLICATION_JSON.value)) {
            result = Serializers.JSON().deserialize(
                    body0, parameter.getType()
            );
        } else if (Objects.equals(contentType, ContentType.APPLICATION_XML.value)) {
            result = Serializers.XML().deserialize(
                    body0, parameter.getType()
            );
        } else {
            throw new InvalidParameterValueException(
                    "Unsupported Content-Type for Request Body: " + request.getHeaders().contentType()
            );
        }

        return result;
    }
}
