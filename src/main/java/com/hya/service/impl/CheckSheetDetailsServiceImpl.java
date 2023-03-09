package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.CheckSheetsDao;
import com.hya.dao.CheckSheetsDetailDao;
import com.hya.pojo.CheckSheetsDetails;
import com.hya.service.CheckSheetDetailsService;
import com.hya.service.CheckSheetsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckSheetDetailsServiceImpl extends ServiceImpl<CheckSheetsDetailDao, CheckSheetsDetails>implements CheckSheetDetailsService {
}
