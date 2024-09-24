package org.smoodi.web.handler;

import org.smoodi.annotation.NotNull;
import org.smoodi.net.exchange.Request;
import org.smoodi.net.exchange.Response;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

public interface MethodHandler extends Handler {

    Object getDeclaredObject();

    Method getMethod();

    List<Parameter> getParameters();

    int getParameterCount();

    String getName();

    @Override
    boolean supports(@NotNull Request request);

    @Override
    void handle(@NotNull Request request, @NotNull Response response);
}
