package com.hya.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hya.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleDao extends BaseMapper<Role> {
}
