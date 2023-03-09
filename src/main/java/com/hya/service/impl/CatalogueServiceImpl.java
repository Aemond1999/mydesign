package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.CatalogueDao;
import com.hya.pojo.Catalogue;
import com.hya.service.CatalogueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatalogueServiceImpl extends ServiceImpl<CatalogueDao, Catalogue> implements CatalogueService {
}
