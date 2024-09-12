package org.smoodi.web.server.exchange;

public interface Response {

    int getPort();

    String getAddress();

    Object getContent();

    Headers getHeaders();
}
