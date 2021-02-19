package com.duizhuang.demoownthings.config;

import com.duizhuang.demoownthings.filter.RequestFilter;
import com.duizhuang.demoownthings.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: yangguoxiong
 * @date: 2021/2/19 15:12
 * @description: WebServlet的配置类
 */
@Configuration
public class WebConfigure {

    @Bean
    public FilterRegistrationBean injectFilter() {
        // 过滤器注入对象
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        // 创建自定义filter对象
        RequestFilter filter = new RequestFilter();
        // 添加过滤器
        filterRegistrationBean.setFilter(filter);
        // 配置过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    /**
     * 注入拦截器
     */
    @Autowired
    private RequestInterceptor requestInterceptor;

    /**
     * 添加自定义拦截器配置类
     */
    @Configuration
    class WebInterceptor implements WebMvcConfigurer {
        /**
         * 重写addInterceptors方法,添加拦截器
         *
         * @param registry
         */
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            /**
             * 方式一
             */
            /*registry.addInterceptor(new RequestInterceptor())
                // 所有请求都被拦截,包括静态资源
                .addPathPatterns("/**");*/

            /**
             * 方式二
             */
            registry.addInterceptor(requestInterceptor)
                // 所有请求都被拦截,包括静态资源
                .addPathPatterns("/**");
        }
    }
}
