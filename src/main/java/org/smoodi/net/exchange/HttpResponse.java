package org.smoodi.net.exchange;

public interface HttpResponse extends Response {

    /**
     * <p>Return the content of response.</p>
     *
     * <p>Depending on the {@code Content-Type} in {@link HttpResponse#getHeaders() http headers}, it can be cast as a specific type.</p>
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
     * @return The content of response.
     */
    @Override
    Object getContent();

    /**
     * <p>Return headers of response.</p>
     *
     * @return Headers of response.
     * @see HttpHeaders
     */
    @Override
    HttpHeaders getHeaders();
}
