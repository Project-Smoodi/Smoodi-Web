package org.smoodi.web.handler.annotation;

import org.smoodi.core.annotation.Module;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Module
public @interface Handler {
}
