package org.smoodi.net.exchange.convertor;

import org.smoodi.annotation.NotNull;
import org.smoodi.annotation.Nullable;
import org.smoodi.annotation.array.EmptyableArray;
import org.smoodi.annotation.array.UnmodifiableArray;
import org.smoodi.net.exchange.HttpHeaders;
import org.smoodi.net.exchange.HttpMethod;
import org.smoodi.net.exchange.HttpRequest;

public interface HttpMessageReader {

    @NotNull
    HttpMethod readHttpMethod();

    @NotNull
    String readPath();

    @NotNull
    String readHttpVersion();

    @UnmodifiableArray
    @EmptyableArray
    @NotNull
    HttpHeaders readHeaders();

    @Nullable
    String readBody();

    @NotNull
    HttpRequest toHttpRequest();
}
