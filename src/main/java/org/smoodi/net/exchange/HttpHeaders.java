package org.smoodi.net.exchange;

import lombok.RequiredArgsConstructor;
import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;

@RequiredArgsConstructor
public class HttpHeaders extends Headers {

    @Nullable
    public String get(@NotNull final HttpHeaderNames key) {
        return get(key.toString());
    }

    @Nullable
    public String contentType() {
        return get(HttpHeaderNames.CONTENT_TYPE);
    }

    @Nullable
    public String contentEncoding() {
        return get(HttpHeaderNames.CONTENT_ENCODING);
    }

    @Nullable
    public String contentLanguage() {
        return get(HttpHeaderNames.CONTENT_LANGUAGE);
    }

    @Nullable
    public String authorization() {
        return get(HttpHeaderNames.AUTHORIZATION);
    }

    @Nullable
    public String location() {
        return get(HttpHeaderNames.LOCATION);
    }
}
