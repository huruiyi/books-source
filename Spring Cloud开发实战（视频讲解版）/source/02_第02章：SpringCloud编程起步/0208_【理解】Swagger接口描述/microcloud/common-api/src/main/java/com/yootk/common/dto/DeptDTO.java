package com.yootk.common.dto;

import lombok.Data;

import java.io.Serializable;
// 该类主要实现部门数据结构的映射，实现数据的远程传输
@Data // Lombok注解，自动生成所需要的类结构
public class DeptDTO implements Serializable { // 定义数据传输类
    private Long deptno; // 部门编号
    private String dname; // 部门名称
    private String loc; // 部门位置
}
