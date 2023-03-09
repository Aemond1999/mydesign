package com.hya.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.hya.pojo.CheckSheets;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckSheetsDao extends BaseMapper<CheckSheets> {
}
