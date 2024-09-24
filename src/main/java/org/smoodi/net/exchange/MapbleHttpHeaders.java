package org.smoodi.net.exchange;

import lombok.RequiredArgsConstructor;
import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;
import org.smoodi.annotation.Overload;

@RequiredArgsConstructor
public class MapbleHttpHeaders
        extends MapHeaders
        implements HttpHeaders {

    @Nullable
    @Overload
    @Override
    public String get(@NotNull final HttpHeaderNames key) {
        return get(key.toString());
    }

    @Nullable
    @Override
    public String contentType() {
        return get(HttpHeaderNames.CONTENT_TYPE);
    }

    @Nullable
    @Override
    public String contentEncoding() {
        return get(HttpHeaderNames.CONTENT_ENCODING);
    }

    @Nullable
    @Override
    public String contentLanguage() {
        return get(HttpHeaderNames.CONTENT_LANGUAGE);
    }

    @Nullable
    @Override
    public String authorization() {
        return get(HttpHeaderNames.AUTHORIZATION);
    }

    @Nullable
    @Override
    public String location() {
        return get(HttpHeaderNames.LOCATION);
    }
}
