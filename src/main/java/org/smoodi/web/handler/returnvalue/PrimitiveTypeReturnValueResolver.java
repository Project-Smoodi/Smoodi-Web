package org.smoodi.web.handler.returnvalue;

import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.ContentType;
import org.smoodi.physalus.transfer.http.HttpHeaderNames;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.web.handler.MethodHandler;

import java.util.List;

@Module
public class PrimitiveTypeReturnValueResolver implements MethodHandlerReturnValueResolver {

    private final List<Class<?>> primitiveTypes = List.of(
            Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.TYPE, Character.TYPE
    );

    @Override
    public boolean supports(Object returnValue) {
        return returnValue.getClass().isPrimitive()
                || (returnValue.getClass().isArray() && returnValue.getClass().getComponentType().isPrimitive());
    }

    @Override
    public void resolveReturnValue(HttpResponse response, Object returnValue, MethodHandler handler) {
        assert this.supports(returnValue);

        response.setContent(returnValue.toString());
        response.getHeaders().set(HttpHeaderNames.CONTENT_TYPE, ContentType.TEXT_PLAIN.value);
    }
}
