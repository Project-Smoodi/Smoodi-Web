package org.smoodi.web.handler;

import org.smoodi.web.server.exchange.Request;
import org.smoodi.web.server.exchange.Response;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

public interface MethodHandler extends Handler {

    Method getMethod();

    List<Parameter> getParameters();

    int getParameterCount();

    String getName();

    @Override
    boolean supports(Request request);

    @Override
    Response handle(Request request);
}
