package org.smoodi.web.server.exchange;

public interface Request {

    int getPort();

    String getAddress();

    Object getContent();

    Headers getHeaders();
}
