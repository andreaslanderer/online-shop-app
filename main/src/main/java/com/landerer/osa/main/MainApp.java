package com.landerer.osa.main;

import com.landerer.osa.commons.config.CommonsConfig;
import com.landerer.osa.commons.interceptor.OsaHystrixExecutionInterceptor;
import com.landerer.osa.product.config.ProductConfiguration;
import com.netflix.hystrix.strategy.HystrixPlugins;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration
@Import({ CommonsConfig.class,
        ProductConfiguration.class })
public class MainApp {

    public static void main(String[] args) {
        HystrixPlugins.getInstance().registerCommandExecutionHook(new OsaHystrixExecutionInterceptor());
        SpringApplication.run(MainApp.class, args);
    }
}
