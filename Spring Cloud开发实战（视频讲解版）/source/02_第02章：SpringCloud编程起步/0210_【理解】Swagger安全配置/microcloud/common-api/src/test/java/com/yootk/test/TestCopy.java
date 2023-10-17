package com.yootk.test;

import com.yootk.common.dto.DeptDTO;
import com.yootk.common.util.DeepBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class TestCopy {
    public static void main(String[] args) {
        List<DeptDTO> sources = new ArrayList<>();
        for (int x = 0; x < 10; x++) {  // 循环生成数据
            DeptDTO deptDTO = new DeptDTO();
            deptDTO.setDeptno(10L + x);
            deptDTO.setDname("沐言科技 - " + x);
            deptDTO.setLoc("北京");
            sources.add(deptDTO);
        }
        List<DeptDTO> copy = DeepBeanUtils.copyListProperties(sources, DeptDTO::new);
        System.out.println(copy);
    }
}
