package org.smoodi.net.exchange;

public interface Response {

    /**
     * <p>Return the IP Address of Client.</p>
     *
     * @return The IP Address of client. ex) {@code 127.0.0.1}
     */
    String getIpAddress();

    /**
     * <p>Return the content of response.</p>
     *
     * @return The content of response.
     */
    Object getContent();

    /**
     * <p>Return headers of response.</p>
     *
     * @return Headers of response.
     * @see Headers
     */
    Headers getHeaders();
}
