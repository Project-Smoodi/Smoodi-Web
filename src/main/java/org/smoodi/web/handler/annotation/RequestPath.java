package org.smoodi.web.handler.annotation;

import org.smoodi.physalus.transfer.http.ContentType;
import org.smoodi.physalus.transfer.http.HttpMethod;

import java.lang.annotation.*;

/**
 * <p>요청을 받는 API 메소드임을 표시.</p>
 *
 * <p>프레임워크에 의해 자동으로 엔드 포인트로써 지정됨.</p>
 *
 * @author Daybreak312
 * @since v0.0.5
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestPath {

    /**
     * <p>엔드 포인트의 경로를 정의.</p>
     *
     * <p>"*" 와일드카드를 이용해서도 지정 가능</p>
     *
     * <p>아래와 같이 경로 일부를 중괄호( {} )로 감싸 {@link PathParam}에서 참조 가능</p>
     *
     * <pre>
     *     &#64RequestPath(path = "api/{num}")
     *     public void api(
     *         &#064PathParam("num") int num
     *     ) { ... }
     * </pre>
     *
     * @see PathParam
     */
    String path() default "**";

    /**
     * <p>엔드 포인트의 HTTP 메소드를 정의.</p>
     *
     * @see HttpMethod
     */
    HttpMethod method() default HttpMethod.GET;

    /**
     * <p>엔드 포인트에서 요구하는 Query-String 파라미터 목록을 정의.</p>
     *
     * <p>같은 경로와 메소드를 가진 엔드 포인트가 있더라도, 해당 항목이 다를 경우 서로 다른 엔드 포인트로 식별함.</p>
     *
     * @see QueryParam
     */
    String[] params() default {};

    /**
     * <p>엔드 포인트에서 요구하는 Header 목록을 정의.</p>
     *
     * <p>같은 경로와 메소드를 가진 엔드 포인트가 있더라도, 해당 항목이 다를 경우 서로 다른 엔드 포인트로 식별함.</p>
     *
     * @see Header
     */
    String[] headers() default {};

    /**
     * <p>엔드 포인트에서 요구하는 Content-Type 헤더 값을 정의.</p>
     *
     * <p>같은 경로와 메소드를 가진 엔드 포인트가 있더라도, 해당 항목이 다를 경우 서로 다른 엔드 포인트로 식별함.</p>
     *
     * @see Header
     */
    ContentType[] contentTypes() default {};
}
