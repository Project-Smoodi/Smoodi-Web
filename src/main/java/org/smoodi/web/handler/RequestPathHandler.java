package org.smoodi.web.handler;

import org.smoodi.net.exchange.ContentType;
import org.smoodi.web.handler.annotation.RequestPath;

import java.util.List;

/**
 * <p>{@link RequestPath}를 통해 작성된 {@link org.smoodi.web.handler.annotation.Handler Handler}를 위한 인터페이스.</p>
 *
 * @author Daybreak312
 * @see RequestPath
 * @see org.smoodi.web.handler.annotation.Handler
 * @see Handler
 * @see MethodHandler
 * @since v0.0.1
 */
public interface RequestPathHandler extends Handler {

    RequestPath getRequestPath();

    String getPath();

    List<String> params();

    List<String> getHeaders();

    ContentType[] contentTypes();
}
