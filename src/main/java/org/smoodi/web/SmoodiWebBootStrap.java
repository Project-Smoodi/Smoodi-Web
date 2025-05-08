package org.smoodi.web;

import lombok.RequiredArgsConstructor;
import org.smoodi.core.SubprojectBootStrap;
import org.smoodi.core.annotation.Module;
import org.smoodi.web.server.GatewayAdapter;

@RequiredArgsConstructor
@Module
public class SmoodiWebBootStrap implements SubprojectBootStrap {

    private final PhysalusDelegate physalusDelegate;

    private final GatewayAdapter adapter;

    private final SmoodiWeb smoodiWeb;

    @Override
    public void start() {
        registerAdapter();
        smoodiWeb.startServer();
    }

    private void registerAdapter() {
        physalusDelegate.getPhysalus()
                .getAdapterManager()
                .addAdapter(adapter);
    }
}
