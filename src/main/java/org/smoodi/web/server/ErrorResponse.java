package org.smoodi.web.server;

import org.smoodi.web.StatusException;

public record ErrorResponse(
        // RFC 7807
        String type,
        String title,
        String status,
        String detail,
        String instance
) {
    public static ErrorResponse of(StatusException e) {
        return new ErrorResponse("about:blank", e.getMessage(), String.valueOf(e.getStatus().status), e.getMessage(), null);
    }
}
