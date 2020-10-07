package com.example.framework.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @Description 上传文件配置
 * @Author zouyuxiao
 * @Date 2020-09-29 13:43
 */
@Configuration
public class FileConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();

        //factory.setMaxFileSize(1024);
        //单个文件最大
//        factory.setMaxFileSize("10240KB"); //KB,MB
        /// 设置总上传数据总大小
//        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }
}
