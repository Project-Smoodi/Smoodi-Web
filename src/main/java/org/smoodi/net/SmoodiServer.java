package org.smoodi.net;

import lombok.extern.slf4j.Slf4j;
import org.smoodi.annotation.NotNull;
import org.smoodi.core.annotation.Module;
import org.smoodi.core.annotation.ModuleInitConstructor;
import org.smoodi.net.config.HttpConfiguration;
import org.smoodi.web.server.Gateway;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
@Module
public final class SmoodiServer implements GatewayServer {

    private final Gateway gateway;

    private final HttpConfiguration httpConfiguration;

    private final ServerSocket serverSocket;

    private Thread listeningThread;

    @ModuleInitConstructor
    public SmoodiServer(
            @NotNull final Gateway gateway,
            @NotNull final HttpConfiguration httpConfiguration
    ) {
        assert gateway != null;
        assert httpConfiguration != null;

        this.gateway = gateway;
        this.httpConfiguration = httpConfiguration;
        try {
            this.serverSocket = new ServerSocket(httpConfiguration.port());
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Cannot open the socket server with port " + httpConfiguration.port() + ": " + e.getMessage(), e);
        }
    }

    @Override
    public void start() {
        listen();
    }

    private void listen() {
        this.listeningThread = new Thread(() -> {
            while (true) {
                try {
                    process(serverSocket.accept());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.listeningThread.start();
    }

    private void process(final Socket socket) {
        if (!socket.isConnected()) {
            return;
        }

        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {
            gateway.service(input, output);
        } catch (IOException e) {
            // TODO("예외 처리 할 것")
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stop() {
        this.listeningThread.interrupt();

        log.info("Server stopped at port {}", httpConfiguration.port());
    }

    @Override
    public Gateway getGateway() {
        return this.gateway;
    }
}
