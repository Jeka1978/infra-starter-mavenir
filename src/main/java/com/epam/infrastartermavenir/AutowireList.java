package com.epam.infrastartermavenir;/**
 * @author Evgeny Borisov
 */

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface AutowireList {
    Class<?>[] value();
}
