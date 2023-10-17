package com.yootk.test;

import com.yootk.common.dto.DeptDTO;
import com.yootk.provider.StartProviderDept8001Application;
import com.yootk.service.IDeptService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest(classes = StartProviderDept8001Application.class)
public class TestDeptService {
    @Autowired
    private IDeptService deptService; // 注入业务接口对象
    @Test
    public void testGet() {
        System.out.println(this.deptService.get(1));
    }
    @Test
    public void testList() {
        System.out.println(this.deptService.list());
    }
    @Test
    public void testAdd() {
        DeptDTO dto = new DeptDTO();
        dto.setDname("公益部");
        dto.setLoc("洛阳");
        System.out.println(this.deptService.add(dto));
    }
    @Test
    public void testSplit() {
        Map<String, Object> map = this.deptService.split(1, 2, "dname", "");
        System.out.println(map);
    }
}
