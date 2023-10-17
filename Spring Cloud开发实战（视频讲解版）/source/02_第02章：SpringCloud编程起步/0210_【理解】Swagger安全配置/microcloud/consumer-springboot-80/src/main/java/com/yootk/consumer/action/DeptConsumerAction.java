package com.yootk.consumer.action;

import com.yootk.common.dto.DeptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumer/dept/*") // 两个不同的服务路径
public class DeptConsumerAction { // 消费端Action
    // 定义出要访问的部门微服务所需要的核心路径前缀，随后在具体请求的时候添加传递的参数
    public static final String DEPT_ADD_URL =
            "http://provider-dept-8001:8001/provider/dept/add";
    public static final String DEPT_GET_URL =
            "http://provider-dept-8001:8001/provider/dept/get/"; // id是自己变更的
    public static final String DEPT_LIST_URL =
            "http://provider-dept-8001:8001/provider/dept/list";
    public static final String DEPT_SPLIT_URL =
            "http://provider-dept-8001:8001/provider/dept/split";
    @Autowired
    private RestTemplate restTemplate; // 本章你是主角儿
    @GetMapping("add") // 消费端接口名称
    public Object addDept(DeptDTO dto) {
        // 需要将当前的DTO对象传递到部门微服务之中，所以此时就要通过RestTemplate对象处理
        return this.restTemplate.postForObject(DEPT_ADD_URL, dto, Boolean.class);
    }
    @GetMapping("get")
    public Object get(Long deptno) {
        return this.restTemplate.getForObject(DEPT_GET_URL + deptno, DeptDTO.class);
    }
    @GetMapping("list")
    public Object list() {
        return this.restTemplate.getForObject(DEPT_LIST_URL, List.class);
    }
    @GetMapping("split")
    public Object split(int cp, int ls, String col, String kw) {
        return this.restTemplate.getForObject(DEPT_SPLIT_URL + "?cp=" + cp + "&ls=" + ls + "&col=" + col + "&kw=" + kw, Map.class);
    }
}
