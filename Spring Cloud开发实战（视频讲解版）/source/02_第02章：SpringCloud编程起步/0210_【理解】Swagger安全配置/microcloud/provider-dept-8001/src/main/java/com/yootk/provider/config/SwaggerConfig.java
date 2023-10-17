package com.yootk.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig { // Swagger配置类
    private ApiInfo getApiInfo() { // 文档之中的头部的信息项
        return new ApiInfoBuilder().title("【沐言科技】部门微服务")
                .description("实现部门数据的统一管理，包括：增加部门信息、查询部门信息、部门列表显示等，此处省略5000字...")
                .termsOfServiceUrl("https://www.yootk.com")
                .contact(new Contact("爆可爱的小李老师", "edu.yootk.com", "784420216@qq.com"))
                .license("沐言科技 - 授权管理").version("1.0.0").build();
    }
    @Bean
    public Docket getDocker() { // 所有的详细描述在此类中定义
        return new Docket(DocumentationType.SWAGGER_2) // 使用的文档版本类型
            .apiInfo(this.getApiInfo())
            .select() // 所有的接口一定要放在指定的包中
            .apis(RequestHandlerSelectors.basePackage("com.yootk.provider.action"))
                .paths(PathSelectors.any()).build();

    }
}
