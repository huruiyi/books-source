package com.yootk.provider.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig { // MybatisPlus配置类
    @Bean
    public MybatisPlusInterceptor getMybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();	// 拦截器
        interceptor.addInnerInterceptor(
                new PaginationInnerInterceptor(DbType.MYSQL)); 	// 分页处理
        return interceptor;
    }
}
