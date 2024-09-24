package org.smoodi.net.exchange;

public interface Request {

    /**
     * <p>Return the IP Address of Client.</p>
     *
     * @return The IP Address of client. ex) {@code 127.0.0.1}
     */
    String getIpAddress();

    /**
     * <p>Return the content of request.</p>
     *
     * @return The content of request.
     */
    Object getContent();

    /**
     * <p>Return headers of request.</p>
     *
     * @return Headers of request.
     * @see Headers
     */
    Headers getHeaders();
}
