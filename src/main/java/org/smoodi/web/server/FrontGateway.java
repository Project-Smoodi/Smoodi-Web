package org.smoodi.web.server;

import lombok.extern.slf4j.Slf4j;
import org.smoodi.core.SmoodiFramework;
import org.smoodi.core.annotation.Module;
import org.smoodi.core.util.LazyInitUnmodifiableCollection;

import java.io.*;
import java.util.List;
import java.util.Set;

@Slf4j
@Module(isPrimary = true)
public class FrontGateway implements Gateway {

    private final LazyInitUnmodifiableCollection<Set<SimpleGateway>> gateways =
            new LazyInitUnmodifiableCollection<>();

    private void init() {
        if (this.gateways.isInitialized()) {
            return;
        }

        this.gateways.initWith(
                SmoodiFramework.getInstance().getModuleContainer().getModulesByClass(SimpleGateway.class)
        );
    }

    @Override
    public OutputStream service(InputStream inputStream, OutputStream outputStream) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            log.debug(
                    reader.readLine()
            );

            outputStream.write(
                    "I'm free!".getBytes()
            );
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        gateways.get();

        return outputStream;
    }
}
