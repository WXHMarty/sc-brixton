package com.xxx.brixton.common.interceptor;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ServerInterceptor implements HandlerInterceptor {

    private final Logger log = Logger.getLogger(ServerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        log.info("preHandle==此处可以在路由前面拦截所有请求，进行权限登录等操作的校验==");
        log.info("preHandle==如果校验失败直接用response返回客户端，并return false表示不再走后面的流程==");
        log.info("preHandle==如果校验成功则return true表示继续走后面的流程==");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("postHandle==此处可以在controller之后，modelAndView之前拦截请求==");
        log.info("postHandle==如果controller中出现异常，则不会再走到这一步拦截==");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("afterCompletion==此处可以在modelAndView之后拦截所有请求==");
        log.info("afterCompletion==如果在controller中出现异常，也可以走到此处拦截==");
    }
}
