package org.smoodi.web.server;

import org.smoodi.annotation.NotNull;
import org.smoodi.web.router.Router;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>서버의 최전단에서 클라이언트 요청 및 {@link Router} 응답의 가공과 처리 가능한 {@link Router}를 연결하는 역할을 수행</p>
 *
 * <p>1. 클라이언트의 요청을 <i>Smoodi Web</i>에서 사용하는 형태인 {@link org.smoodi.net.exchange.Request Request}로 가공하고 {@link Router}에게 전달</p>
 * <p>2. {@link Router}가 넘겨준 {@link org.smoodi.net.exchange.Response Response} 응답 객체를 클라이언트가 분석 가능한 표준 형태로 가공</p>
 */
public interface Gateway {

    @NotNull
    OutputStream service(@NotNull InputStream inputStream, @NotNull OutputStream outputStream);
}
