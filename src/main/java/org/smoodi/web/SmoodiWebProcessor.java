package org.smoodi.web;

import org.smoodi.core.Processor;
import org.smoodi.core.annotation.Module;

@Module
public class SmoodiWebProcessor implements Processor {

    @Override
    public void start() {
        SmoodiWeb.startServer();
    }

    @Override
    public void stop() {
    }
}
