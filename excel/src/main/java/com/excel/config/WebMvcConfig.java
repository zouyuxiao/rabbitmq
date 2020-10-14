package com.excel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-10-13 11:27
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * 解决继承WebMvcConfigurationSupport,静态资源访问不到
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 配置内部资源视图解析器
     *
     */
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //配置前缀, 不用加static文件夹路径, 后面有文件夹路径在加上 : /page/
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".html");
        registry.viewResolver(viewResolver);
        super.configureViewResolvers(registry);
    }
}
