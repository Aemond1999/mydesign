package com.hya.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hya.pojo.PurchaseOrders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseOrdersDao extends BaseMapper<PurchaseOrders> {
}
