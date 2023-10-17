package com.yootk.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig { // 实现RestTemplate的相关配置
    @Bean // 向Spring容器之中进行Bean注册
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
