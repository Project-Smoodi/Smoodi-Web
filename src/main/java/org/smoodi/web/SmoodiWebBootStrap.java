package org.smoodi.web;

import org.smoodi.core.SubprojectBootStrap;
import org.smoodi.core.annotation.Module;

@Module
public class SmoodiWebBootStrap implements SubprojectBootStrap {

    @Override
    public void start() {

        SmoodiWeb.startServer();
    }
}
