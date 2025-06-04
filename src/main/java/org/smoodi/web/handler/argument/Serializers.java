package org.smoodi.web.handler.argument;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.smoodi.core.SmoodiFramework;
import org.smoodi.net.config.DefaultJacksonConfiguration;

import java.io.StringReader;
import java.io.StringWriter;

public class Serializers {

    private Serializers() {
    }

    public static JsonSerializer JSON() {
        if (JsonSerializer.INSTANCE == null) {
            JsonSerializer.INSTANCE = new JsonSerializer();
        }
        return JsonSerializer.INSTANCE;
    }

    public static XmlSerializer XML() {
        if (XmlSerializer.INSTANCE == null) {
            XmlSerializer.INSTANCE = new XmlSerializer();
        }
        return XmlSerializer.INSTANCE;
    }

    private static abstract class AbstractSerializer {

        protected AbstractSerializer() {
        }

        public abstract String serialize(Object object);

        public abstract <T> T deserialize(String data, Class<T> type);
    }

    public static class JsonSerializer extends AbstractSerializer {

        private static JsonSerializer INSTANCE;

        private final ObjectMapper objectMapper =
                SmoodiFramework.getInstance()
                        .getModuleContainer()
                        .getPrimaryModuleByClass(DefaultJacksonConfiguration.class)
                        .objectMapper;

        @Override
        public String serialize(Object object) {
            try {
                return objectMapper.writeValueAsString(object);
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to serialize object to JSON: " + e.getMessage(), e);
            }
        }

        @Override
        public <T> T deserialize(String data, Class<T> type) {
            try {
                return objectMapper.readValue(data, type);
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to deserialize JSON to object: " + e.getMessage(), e);
            }
        }
    }

    public static class XmlSerializer extends AbstractSerializer {

        private static XmlSerializer INSTANCE;

        @Override
        public String serialize(Object object) {
            try {
                Marshaller marshaller = JAXBContext.newInstance(object.getClass()).createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                StringWriter writer = new StringWriter();

                marshaller.marshal(object, writer);

                return writer.toString();
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to serialize object to XML: " + e.getMessage(), e);
            }
        }

        @Override
        public <T> T deserialize(String data, Class<T> type) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(type);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                return type.cast(
                        unmarshaller.unmarshal(new StringReader(data))
                );
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to deserialize XML to object: " + e.getMessage(), e);
            }
        }
    }
}
