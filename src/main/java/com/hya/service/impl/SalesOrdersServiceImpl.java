package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.SalesOrdersDao;
import com.hya.pojo.SalesOrders;
import com.hya.service.SalesOrdersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SalesOrdersServiceImpl  extends ServiceImpl<SalesOrdersDao, SalesOrders> implements SalesOrdersService {
}
