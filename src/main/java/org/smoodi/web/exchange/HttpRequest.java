package org.smoodi.web.exchange;

public interface HttpRequest extends Request {

    @Override
    int getPort();

    @Override
    String getAddress();

    @Override
    Object getContent();

    @Override
    HttpHeaders getHeaders();
}
