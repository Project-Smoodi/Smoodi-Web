package org.smoodi.web.handler.returnvalue;

import lombok.extern.slf4j.Slf4j;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.web.handler.MethodHandler;

@Slf4j
@Module(order = Byte.MAX_VALUE)
public class ObjectJsonReturnValueResolver implements MethodHandlerReturnValueResolver {

    @Override
    public boolean supports(Object returnValue) {
        return true;
    }

    @Override
    public void resolveReturnValue(HttpResponse response, Object returnValue, MethodHandler handler) {
        assert response != null;
        assert returnValue != null;
        assert handler != null;

        response.json(returnValue);
    }
}
