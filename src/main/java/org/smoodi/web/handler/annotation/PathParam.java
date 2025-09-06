package org.smoodi.web.handler.annotation;

import java.lang.annotation.*;

/**
 * <p>Handler의 메소드에서, 요청의 헤더를 주입할 매개변수임을 표시.</p>
 *
 * <pre>
 *     &#064RequestPath(path = "/api", headers = {"Content-Type"})
 *     public void api(
 *         &#064Header("Content-Type") String contentType
 *     ) { ... }
 * </pre>
 *
 * @author Daybreak312
 * @since v0.0.5
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PathParam {

    String value() default "";
}
