package com.epam.infrastartermavenir;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.beans.Introspector;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Evgeny Borisov
 */
public class AutowiredListAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ApplicationContext context;

    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            AutowireList annotation = field.getAnnotation(AutowireList.class);
            if (annotation != null) {
                Class<?>[] classes = annotation.value();
                List<Object> list = Arrays.stream(classes)
                        .map(aClass -> Introspector.decapitalize(aClass.getSimpleName()))
                        .map(name -> context.getBean(name))
                        .collect(Collectors.toList());
                field.setAccessible(true);
                field.set(bean,list);
            }
        }

        return bean;
    }
}
