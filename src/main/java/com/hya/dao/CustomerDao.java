package com.hya.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hya.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDao  extends BaseMapper<Customer> {
}
