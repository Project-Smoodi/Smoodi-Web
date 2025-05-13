package org.smoodi.web.handler.returnvalue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.ContentType;
import org.smoodi.physalus.transfer.http.HttpHeaderNames;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.web.handler.MethodHandler;

@Slf4j
@Module(order = Byte.MAX_VALUE)
public class ObjectJsonReturnValueResolver implements MethodHandlerReturnValueResolver {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean supports(Object returnValue) {
        return true;
    }

    @Override
    public void resolveReturnValue(HttpResponse response, Object returnValue, MethodHandler handler) {
        assert response != null;
        assert returnValue != null;
        assert handler != null;

        try {
            response.setContent(
                    mapper.writeValueAsString(returnValue)
            );
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            throw new IllegalArgumentException(e);
        }

        response.getHeaders().set(HttpHeaderNames.CONTENT_TYPE, ContentType.APPLICATION_JSON.value);
    }
}
