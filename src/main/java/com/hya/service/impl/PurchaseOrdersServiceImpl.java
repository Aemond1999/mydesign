package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.PurchaseOrdersDao;
import com.hya.pojo.PurchaseOrders;
import com.hya.service.PurchaseOrdersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PurchaseOrdersServiceImpl extends ServiceImpl<PurchaseOrdersDao, PurchaseOrders> implements PurchaseOrdersService {
}
