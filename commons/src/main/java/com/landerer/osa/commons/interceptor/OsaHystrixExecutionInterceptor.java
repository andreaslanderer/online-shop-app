package com.landerer.osa.commons.interceptor;

import com.netflix.hystrix.HystrixInvokable;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import org.slf4j.MDC;

import java.util.Map;

public class OsaHystrixExecutionInterceptor extends HystrixCommandExecutionHook {

    private Map<String, String> mdc;

    @Override
    public <T> void onStart(HystrixInvokable<T> commandInstance) {
        super.onStart(commandInstance);
        this.mdc = MDC.getCopyOfContextMap();
    }

    @Override
    public <T> void onThreadStart(HystrixInvokable<T> commandInstance) {
        super.onThreadStart(commandInstance);
        MDC.setContextMap(this.mdc);
    }

    @Override
    public <T> void onExecutionStart(HystrixInvokable<T> commandInstance) {
        super.onExecutionStart(commandInstance);
        MDC.setContextMap(this.mdc);
    }

    @Override
    public <T> Exception onExecutionError(HystrixInvokable<T> commandInstance, Exception e) {
        this.mdc = null;
        return super.onExecutionError(commandInstance, e);
    }

    @Override
    public <T> void onExecutionSuccess(HystrixInvokable<T> commandInstance) {
        super.onExecutionSuccess(commandInstance);
        this.mdc = null;
    }

    @Override
    public <T> void onFallbackStart(HystrixInvokable<T> commandInstance) {
        super.onFallbackStart(commandInstance);
        MDC.setContextMap(this.mdc);
    }

    @Override
    public <T> Exception onFallbackError(HystrixInvokable<T> commandInstance, Exception e) {
        this.mdc = null;
        return super.onFallbackError(commandInstance, e);
    }

    @Override
    public <T> void onFallbackSuccess(HystrixInvokable<T> commandInstance) {
        super.onFallbackSuccess(commandInstance);
        this.mdc = null;
    }
}
