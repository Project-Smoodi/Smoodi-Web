package org.smoodi.web.server.exchange;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HttpHeaders extends Headers {

    private final Headers headers;

    public String get(HttpHeaderNames name) {
        return headers.get(name.toString());
    }

    public String contentType() {
        return get(HttpHeaderNames.CONTENT_TYPE);
    }

    public String contentEncoding() {
        return get(HttpHeaderNames.CONTENT_ENCODING);
    }

    public String contentLanguage() {
        return get(HttpHeaderNames.CONTENT_LANGUAGE);
    }

    public String authorization() {
        return get(HttpHeaderNames.AUTHORIZATION);
    }

    public String location() {
        return get(HttpHeaderNames.LOCATION);
    }
}
