package com.duizhuang.demoownthings.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author: yangguoxiong
 * @date: 2021/2/19 15:08
 * @description: 自定义Servlet的filter拦截器.
 * 步骤:
 * 1. 实现Servlet的Filter接口
 * 2. 创建配置类,通过FilterRegistrationBean注入自定义filter
 */
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器前置处理: " + new Date().toLocaleString());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤器后置处理: " + new Date().toLocaleString());
    }
}
