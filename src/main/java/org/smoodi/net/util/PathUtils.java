package org.smoodi.net.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PathUtils {

    public static boolean matches(String path, String pattern) {
        if (path == null || pattern == null) {
            return false;
        }

        String[] pathParts = formatPath(path).split("/");
        String[] patternParts = formatPath(pattern).split("/");

        if (pathParts.length != patternParts.length) {
            return false;
        }

        for (int i = 0; i < pathParts.length; i++) {
            if (!patternParts[i].equals("*")
                    && !patternParts[i].matches("\\{.*}")
                    && !pathParts[i].equals(patternParts[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * <p>Path String을 {@code /api/path/path} 의 형태와 같이 포맷</p>
     *
     * @param raw path string
     * @return 포맷된 path string
     */
    public static String formatPath(String raw) {
        if (raw == null || raw.trim().isEmpty()) {
            return "/";
        }

        String cleaned = raw.trim()
                .replaceAll("/+", "/")
                .replaceAll("^/+", "")
                .replaceAll("/+$", "");

        String result = cleaned.isEmpty() ? "" : "/" + cleaned;

        return "/" + result;
    }
}
