package org.smoodi.web.server;

import org.smoodi.physalus.engine.adapter.Adapter;

public interface GatewayAdapter extends Adapter {

    HttpGateway getGateway();
}
