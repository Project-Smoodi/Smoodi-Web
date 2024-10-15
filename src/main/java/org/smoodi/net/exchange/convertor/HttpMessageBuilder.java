package org.smoodi.net.exchange.convertor;

import org.smoodi.net.exchange.HttpResponse;

public interface HttpMessageBuilder {

    HttpMessageBuilder setProtocol(String protocol);

    HttpMessageBuilder setStatusCode(int statusCode);

    HttpMessageBuilder addHeader(String header, String value);

    HttpMessageBuilder setBody(String body);

    HttpResponse finish();
}
