package com.hya.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hya.pojo.SalesOrders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalesOrdersDao extends BaseMapper<SalesOrders> {
}
