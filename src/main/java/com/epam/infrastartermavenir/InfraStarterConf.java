package com.epam.infrastartermavenir;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@Configuration
@EnableConfigurationProperties(StarterProps.class)
public class InfraStarterConf {


    @Bean
    @ConditionalOnProperty("corona.package-to-scan-for-exception")
    public CoronaExceptionHandler coronaExceptionHandler(){
        return new CoronaExceptionHandler();
    }

    @Bean
    @ConditionalOnProperty("corona.package-to-scan-for-exception")
    public CustomPointcut customPointcut(){
        return new CustomPointcut();
    }


    @Bean
    @ConditionalOnProperty("corona.package-to-scan-for-exception")
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        return new DefaultPointcutAdvisor(customPointcut(), coronaExceptionHandler());
    }


    @Bean
    public AutowiredListAnnotationBeanPostProcessor autowiredListAnnotationBeanPostProcessor(){
        return new AutowiredListAnnotationBeanPostProcessor();
    }
}
