package org.smoodi.web.handler.annotation;

import java.lang.annotation.*;

/**
 * <p>Handler의 메소드에서, 요청의 Query-String 파라미터를 주입할 매개변수임을 표시.</p>
 *
 * <pre>
 *     &#064;RequestPath(path = "/api", parameters = {"key"})
 *     public void api(
 *         &#064;QueryParam("key") String value
 *     ) { ... }
 * </pre>
 *
 * @author Daybreak312
 * @since v0.0.5
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueryParam {

    String value() default "";
}
