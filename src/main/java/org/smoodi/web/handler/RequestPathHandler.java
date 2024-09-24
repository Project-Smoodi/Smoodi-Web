package org.smoodi.web.handler;

import org.smoodi.net.exchange.ContentType;
import org.smoodi.web.handler.annotation.RequestPath;

import java.util.List;

public interface RequestPathHandler extends Handler {

    RequestPath getRequestPath();

    String getPath();

    List<String> params();

    List<String> getHeaders();

    ContentType[] contentTypes();
}
