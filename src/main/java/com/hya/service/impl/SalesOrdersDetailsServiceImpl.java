package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.SalesOrdersDetailsDao;
import com.hya.pojo.SalesOrdersDetails;
import com.hya.service.SalesOrdersDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SalesOrdersDetailsServiceImpl extends ServiceImpl<SalesOrdersDetailsDao, SalesOrdersDetails> implements SalesOrdersDetailsService {
}
