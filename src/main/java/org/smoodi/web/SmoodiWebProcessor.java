package org.smoodi.web;

import lombok.RequiredArgsConstructor;
import org.smoodi.core.Processor;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.engine.Physalus;
import org.smoodi.web.server.GatewayAdapter;

@RequiredArgsConstructor
@Module(order = Byte.MAX_VALUE)
public class SmoodiWebProcessor implements Processor {

    private final GatewayAdapter adapter;

    private final SmoodiWeb smoodiWeb;

    @Override
    public void start() {
        registerAdapter();
        smoodiWeb.startServer();

        Physalus.instance().listening();
    }

    private void registerAdapter() {
        Physalus.instance()
                .getAdapterManager()
                .addAdapter(adapter);
    }

    @Override
    public void stop() {
    }
}
