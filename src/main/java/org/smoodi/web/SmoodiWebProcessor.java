package org.smoodi.web;

import lombok.RequiredArgsConstructor;
import org.smoodi.core.Processor;
import org.smoodi.core.annotation.Module;
import org.smoodi.web.server.GatewayAdapter;

@RequiredArgsConstructor
@Module(order = Byte.MAX_VALUE)
public class SmoodiWebProcessor implements Processor {

    private final PhysalusDelegate physalusDelegate;

    private final GatewayAdapter adapter;

    private final SmoodiWeb smoodiWeb;

    @Override
    public void start() {
        registerAdapter();
        smoodiWeb.startServer();

        physalusDelegate.getPhysalus().getServerRuntime().listening();
    }

    private void registerAdapter() {
        physalusDelegate.getPhysalus()
                .getAdapterManager()
                .addAdapter(adapter);
    }

    @Override
    public void stop() {
    }
}
