package com.yootk.provider.action;

import com.yootk.common.dto.DeptDTO;
import com.yootk.service.IDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@RequestMapping("/provider/dept/*") // 微服务提供者父路径
@Slf4j // 使用一个注解
public class DeptAction {
    @Autowired
    private IDeptService deptService;
    @GetMapping("get/{id}")
    public Object get(@PathVariable("id") long id) {
        this.printRequestHeaders("get");
        return this.deptService.get(id);
    }
    @PostMapping("add")
    public Object add(@RequestBody  DeptDTO deptDTO) {    // 后面会修改参数模式为JSON
        this.printRequestHeaders("add");
        return this.deptService.add(deptDTO);
    }
    @GetMapping("list")
    public Object list() {
        this.printRequestHeaders("list");
        return this.deptService.list();
    }
    @GetMapping("split")
    public Object split(int cp, int ls, String col, String kw) {
        this.printRequestHeaders("split");
        return this.deptService.split(cp, ls, col, kw);
    }
    private void printRequestHeaders(String restName) {    // 实现所有请求头信息的输出
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Enumeration<String> headerEnums = request.getHeaderNames();
        while (headerEnums.hasMoreElements()) {
            String headerName = headerEnums.nextElement();
            log.info("【{}】头信息：{} = {}", restName, headerName, request.getHeader(headerName));
        }
    }
}
