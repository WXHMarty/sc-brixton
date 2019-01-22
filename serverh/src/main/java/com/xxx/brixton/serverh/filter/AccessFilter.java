package com.xxx.brixton.serverh.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * access拦截
 * 有四分方法
 */
public class AccessFilter extends ZuulFilter {

    private final Logger log = Logger.getLogger(AccessFilter.class);

    /**
     * 返回一个字符串，代表过滤器的类型，
     * 在Zuul中定义了四种不同周期的过滤器的类型：
     * pre: 指明过滤器在路由前调用
     * routing: 指明过滤器在路由的时候调用
     * post: 指明过滤器在路由和报错之后调用
     * errror: 指明过滤器在发生错误的时候被调用
     * @return String
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 指明过滤器的执行顺序
     * 0最先 然后是1 ...
     * 依此类推
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回一个Boolean类型，
     * 表明过滤器是否要执行
     * true表示要执行
     * false表示不执行
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 这是过滤器真正执行的逻辑
     * 返回的Object具体干什么用待了解
     * @return object
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("url: %s, method: %s", request.getRequestURL().toString(), request.getMethod()));

        String accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty");
            // 过滤掉请求，不对此请求进行路由
            ctx.setSendZuulResponse(false);
            // 返回错误码
            ctx.setResponseStatusCode(404);
            // 返回内容
            ctx.setResponseBody("access token is empty");
            return null;
        }

        log.info("access is OK");
        return null;
    }
}
