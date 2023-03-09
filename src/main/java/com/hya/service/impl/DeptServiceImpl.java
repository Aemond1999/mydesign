package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.DeptDao;
import com.hya.pojo.Dept;
import com.hya.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept>implements DeptService {
}
