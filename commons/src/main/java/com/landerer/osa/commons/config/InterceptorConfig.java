package com.landerer.osa.commons.config;

import com.landerer.osa.commons.interceptor.RequestInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    private ApplicationContext context;

    public InterceptorConfig(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        final RequestInterceptor interceptor = this.context.getBean(RequestInterceptor.class);
        registry.addInterceptor(interceptor);
    }
}
