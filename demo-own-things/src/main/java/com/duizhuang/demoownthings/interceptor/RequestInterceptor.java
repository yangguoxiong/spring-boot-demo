package com.duizhuang.demoownthings.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author: yangguoxiong
 * @date: 2021/2/19 15:36
 * @description: springMvc的拦截器, 拦截controller请求, 用来测试filter和interceptor的执行顺序
 * 方式一:
 * 1. 实现HandlerInterceptor
 * 2. 重写preHandle、postHandle、afterCompletion
 * 3. 编写配置类将自定义拦截器加入到spring中.
 * 方式二: 继承HandlerInterceptorAdapter,将自定义拦截器放入到spring容器中,配置类通过注入方式添加自定义拦截器.
 */

/**
 * 方式一
 */
/*public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("前置拦截器: " + new Date().toLocaleString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后置拦截器: " + new Date().toLocaleString());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}*/

/**
 * 方式二, 拦截器注入到spring容器中
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("前置拦截器: " + new Date().toLocaleString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后置拦截器: " + new Date().toLocaleString());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
