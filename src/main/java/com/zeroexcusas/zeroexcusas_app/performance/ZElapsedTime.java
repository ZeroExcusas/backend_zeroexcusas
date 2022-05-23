package com.zeroexcusas.zeroexcusas_app.performance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation allows to precise how long time takes one given
 * method to execute all their logic (Marker Annotaion)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ZElapsedTime {
}

