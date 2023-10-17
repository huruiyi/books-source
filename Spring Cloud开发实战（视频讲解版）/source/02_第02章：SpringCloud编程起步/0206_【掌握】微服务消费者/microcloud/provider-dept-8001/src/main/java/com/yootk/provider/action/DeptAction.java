package com.yootk.provider.action;

import com.yootk.common.dto.DeptDTO;
import com.yootk.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider/dept/*") // 微服务提供者父路径
public class DeptAction {
    @Autowired
    private IDeptService deptService;
    @GetMapping("get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.deptService.get(id);
    }
    @PostMapping("add")
    public Object add(@RequestBody  DeptDTO deptDTO) {    // 后面会修改参数模式为JSON
        return this.deptService.add(deptDTO);
    }
    @GetMapping("list")
    public Object list() {
        return this.deptService.list();
    }
    @GetMapping("split")
    public Object split(int cp, int ls, String col, String kw) {
        return this.deptService.split(cp, ls, col, kw);
    }
}
