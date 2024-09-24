package org.smoodi.net.exchange;

import java.util.Map;

public interface HttpRequest extends Request {

    /**
     * <p>Return the request URL.</p>
     *
     * @return The request URL. ex) {@code http://loaclhost:8080/home?key=value}
     */
    String getUrl();

    /**
     * <p>Return the host.</p>
     *
     * <p>It's part of {@link HttpRequest#getUrl()}</p>
     *
     * @return The host. ex) When {@link HttpRequest#getUrl()} is {@code http://loaclhost:8080/home?key=value}, then {@code localhost:8080}
     */
    String getHost();

    /**
     * <p>Return the request URI.</p>
     *
     * <p>It's part of {@link HttpRequest#getUrl()}</p>
     *
     * @return The request URI. ex) When {@link HttpRequest#getUrl()} is {@code http://loaclhost:8080/home?key=value}, then {@code localhost:8080/home}
     */
    String getUri();

    /**
     * <p>Return is it secured protocol.</p>
     *
     * @return {@code true} If the protocol is HTTPS. {@code false} If the protocol is HTTP.
     */
    boolean isSecureProtocol();

    /**
     * <p>Return the http method of request.</p>
     *
     * @return The http method of request.
     * @see HttpMethod
     */
    HttpMethod getMethod();

    /**
     * <p>Return the content of request.</p>
     *
     * <p>Depending on the {@code Content-Type} in {@link HttpRequest#getHeaders() http headers}, it can be cast as a specific type.</p>
     *
     * <p>Like this:</p>
     * <table>
     *     <thead>
     *         <td><b>Content-Type</b></td>
     *         <td><b>Java Type</b></td>
     *     </thead>
     *     <tr>
     *         <td>application/json</td>
     *         <td>Object</td>
     *     </tr>
     *     <tr>
     *         <td>text/html</td>
     *         <td>String</td>
     *     </tr>
     *     <tr>
     *         <td>text/plain</td>
     *         <td>String</td>
     *     </tr>
     * </table>
     *
     * @return The content of request.
     */
    @Override
    Object getContent();

    /**
     * <p>Return headers of request.</p>
     *
     * @return Headers of request.
     * @see HttpHeaders
     */
    @Override
    HttpHeaders getHeaders();

    /**
     * <p>Return URL parameters of request.</p>
     *
     * @return URL parameters of request by String Key-Value.
     */
    Map<String, String> getParams();

    /**
     * <p>Return the path of request.</p>
     *
     * <p>It's part of URL.</p>
     *
     * @return The path of request. ex) When {@link HttpRequest#getUrl()} is {@code http://localhost:8080/home?key=value}, then {@code /home}
     */
    String getPath();
}
