package com.denshiksmle.friendly.di.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by denglob on 12/23/17.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface RegistrationScope {
}
