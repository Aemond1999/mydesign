package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.PurchaseOrderDetailsDao;
import com.hya.pojo.PurchaseOrderDetails;
import com.hya.service.PurchaseOrderDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseOrderDetailsServiceImpl extends ServiceImpl<PurchaseOrderDetailsDao, PurchaseOrderDetails> implements PurchaseOrderDetailsService {
}
