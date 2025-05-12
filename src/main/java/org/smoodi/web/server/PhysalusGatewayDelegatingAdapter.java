package org.smoodi.web.server;

import lombok.RequiredArgsConstructor;
import org.smoodi.core.annotation.Module;
import org.smoodi.physalus.transfer.Exchange;
import org.smoodi.physalus.transfer.http.HttpExchange;

@RequiredArgsConstructor
@Module
public class PhysalusGatewayDelegatingAdapter implements GatewayAdapter {

    private final PhysalusBasedGateway gateway;

    @Override
    public HttpGateway getGateway() {
        return gateway;
    }

    @Override
    public void execute(Exchange exchange) {
        if (exchange instanceof HttpExchange exchange1) {
            gateway.service(exchange1.getRequest(), exchange1.getResponse());
        }
    }

    @Override
    public String getTag() {
        return "HTTP";
    }
}
