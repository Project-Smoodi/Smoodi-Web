package org.smoodi.web.handler.annotation;

import java.lang.annotation.*;

/**
 * <p>Handler의 메소드에서, 요청의 Body를 주입할 매개변수임을 표시.</p>
 *
 * <p>해당 매개변수는 {@link org.smoodi.physalus.transfer.http.ContentType#APPLICATION_JSON} 타입의 Body를
 * 가져와야 하며, JSON 형태로 직렬화된 객체를 매핑한다.</p>
 *
 * <p>해당 매개변수는 {@link org.smoodi.physalus.transfer.http.HttpMethod#GET GET} 메소드를 제외한
 * 모든 HTTP 메소드에서 사용 가능하다.</p>
 *
 * <p>매개변수의 타입은 역직렬화를 위한 VO여야 한다.</p>
 *
 * <pre>
 *     &#064RequestPath(path = "/api", parameters = {"key"})
 *     public void api(
 *         &#064RequestBody
 *         RequestValueObject value
 *     ) { ... }
 * </pre>
 *
 * @author Daybreak312
 * @since v0.0.5
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestBody {
}
