package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.CustomerDao;
import com.hya.pojo.Customer;
import com.hya.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl extends ServiceImpl<CustomerDao,Customer> implements CustomerService  {
}
