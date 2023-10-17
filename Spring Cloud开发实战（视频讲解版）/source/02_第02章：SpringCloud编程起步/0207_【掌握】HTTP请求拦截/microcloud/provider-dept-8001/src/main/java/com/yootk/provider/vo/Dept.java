package com.yootk.provider.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("dept")
@Data // Lombok代码生成
public class Dept { // 这个类所需要追加MBP所需要的注解
    @TableId(type = IdType.AUTO) // 采用自动增长列配置
    private Long deptno; // 与deptno字段映射
    private String dname;
    private String loc;
}
