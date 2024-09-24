package org.smoodi.net.config;

import org.smoodi.core.annotation.SmoodiDefaultConfiguration;

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
