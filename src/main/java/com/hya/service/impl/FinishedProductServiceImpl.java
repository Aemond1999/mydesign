package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.FinishedProductDao;
import com.hya.pojo.FinishedProduct;
import com.hya.service.FinishedProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FinishedProductServiceImpl extends ServiceImpl<FinishedProductDao, FinishedProduct> implements FinishedProductService {
}
