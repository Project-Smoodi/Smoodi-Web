package org.smoodi.web.handler.returnvalue;

import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.http.HttpResponse;
import org.smoodi.web.handler.MethodHandler;

@Module(order = Byte.MIN_VALUE)
public class VoidReturnValueResolver implements MethodHandlerReturnValueResolver {

    @Override
    public boolean supports(Object returnValue) {
        return returnValue == null;
    }

    @Override
    public void resolveReturnValue(HttpResponse response, Object returnValue, MethodHandler handler) {
        assert this.supports(returnValue);
    }
}
