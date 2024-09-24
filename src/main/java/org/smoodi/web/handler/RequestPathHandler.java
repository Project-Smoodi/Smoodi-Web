package org.smoodi.web.handler;

import org.smoodi.web.handler.annotation.RequestPath;
import org.smoodi.web.server.exchange.ContentType;

import java.util.List;

public interface RequestPathHandler extends Handler {

    public RequestPath getRequestPath();

    public String getPath();

    List<String> params();

    List<String> getHeaders();

    ContentType[] contentTypes();
}
