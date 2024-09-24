package org.smoodi.web.handler.annotation;

import org.smoodi.net.exchange.ContentType;
import org.smoodi.net.exchange.HttpMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestPath {

    String path() default "**";

    HttpMethod method() default HttpMethod.GET;

    String[] params() default {};

    String[] headers() default {};

    ContentType[] contentTypes() default {};
}
