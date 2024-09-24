package org.smoodi.net.config;

import org.smoodi.core.annotation.SmoodiDefaultConfiguration;

/**
 * <p>HTTP 서버 관련 기본값 설정.</p>
 *
 * @author Daybreak312
 * @since v0.0.1
 */
@SmoodiDefaultConfiguration
public class HttpDefaultConfigure implements HttpConfiguration {

    @Override
    public int port() {
        return 8080;
    }

    @Override
    public String pathPrefix() {
        return "";
    }

    @Override
    public JsonKeyCase jsonKeyCase() {
        return JsonKeyCase.LOWER_SNAKE_CASE;
    }
}
