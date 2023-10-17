package com.yootk.consumer.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Slf4j // 添加日志注解
@Component // 配置之后自动拦截生效
public class MicroServiceHTTPInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.info("【HTTP请求拦截】服务主机：{}、REST路径：{}",
                request.getURI().getHost(), request.getURI().getPath());
        // 此时可以将一些Token的数据保存在头信息之中，会随着每次的请求一起发送到服务端
        request.getHeaders().set("token", "www.yootk.com"); // 随意添加的头信息
        return execution.execute(request, body); // 发送请求
    }
}
