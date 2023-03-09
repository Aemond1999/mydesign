package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.CheckSheetsDao;
import com.hya.pojo.CheckSheets;
import com.hya.service.CheckSheetsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckSheetsServiceImpl extends ServiceImpl<CheckSheetsDao, CheckSheets> implements CheckSheetsService {
}
