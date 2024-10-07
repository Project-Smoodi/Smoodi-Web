package org.smoodi.web.handler.annotation;

import org.smoodi.core.annotation.Module;

import java.lang.annotation.*;

/**
 * <p>클라이언트 요청을 처리하는 종단인 {@code Handler}임을 표시.</p>
 *
 * <p>해당 어노테이션 사용시 {@link Module}로 등록됨.</p>
 *
 * @author Daybreak312
 * @see org.smoodi.web.handler.Handler Handler
 * @see Module
 * @since v0.0.1
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Module
public @interface Handler {
}
