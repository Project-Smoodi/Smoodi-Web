package org.smoodi.web.exchange;

public interface Request {

    int getPort();

    String getAddress();

    Object getContent();

    Headers getHeaders();
}
