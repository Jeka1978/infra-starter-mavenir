package com.epam.infrastartermavenir;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Evgeny Borisov
 */

public class CoronaExceptionHandler implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            return methodInvocation.proceed();
        } catch (ClassCastException ex) {
            System.out.println("pcr is not working, please fix it!");
            throw ex;
        }
    }
}
