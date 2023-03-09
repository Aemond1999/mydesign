package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.RawMaterialDao;
import com.hya.pojo.RawMaterial;
import com.hya.service.RawMaterialService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RawMaterialServiceImpl extends ServiceImpl<RawMaterialDao, RawMaterial> implements RawMaterialService {
}
