package com.epam.infrastartermavenir;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class CustomPointcut extends DynamicMethodMatcherPointcut {

    @Autowired
    private StarterProps props;

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        return true;
    }

    @Override
    public ClassFilter getClassFilter() {
        return aClass -> aClass.getPackage().getName().contains(props.getPackageToScanForException());
    }
}











