package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.WarehouseDao;
import com.hya.pojo.Employee;
import com.hya.pojo.Warehouse;
import com.hya.service.EmployeeService;
import com.hya.service.WarehouseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class WarehouseServiceImpl  extends ServiceImpl<WarehouseDao, Warehouse> implements WarehouseService {
}
