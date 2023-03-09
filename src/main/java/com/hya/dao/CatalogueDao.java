package com.hya.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hya.pojo.Catalogue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CatalogueDao extends BaseMapper<Catalogue> {
}
