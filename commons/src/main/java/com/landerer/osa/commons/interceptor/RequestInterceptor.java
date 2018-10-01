package com.landerer.osa.commons.interceptor;

import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger;

    public RequestInterceptor(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String rid = request.getHeader("rid");
        String sid = request.getHeader("sid");
        MDC.put("sid", rid);
        MDC.put("rid", sid);
        return true;
    }
}
