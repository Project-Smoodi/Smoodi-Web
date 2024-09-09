package org.smoodi.web.exchange;

public interface Response {

    int getPort();

    String getAddress();

    Object getContent();

    Headers getHeaders();
}
