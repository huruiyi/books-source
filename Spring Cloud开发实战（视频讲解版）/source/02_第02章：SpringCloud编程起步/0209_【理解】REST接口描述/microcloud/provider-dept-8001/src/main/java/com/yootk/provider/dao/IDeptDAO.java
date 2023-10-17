package com.yootk.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yootk.provider.vo.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IDeptDAO extends BaseMapper<Dept> { // DAO接口开发完成
}
