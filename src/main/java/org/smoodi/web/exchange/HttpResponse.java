package org.smoodi.web.exchange;

public interface HttpResponse extends Response {

    @Override
    int getPort();

    @Override
    String getAddress();

    @Override
    Object getContent();

    @Override
    HttpHeaders getHeaders();
}
