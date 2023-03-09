package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.ProviderDao;
import com.hya.pojo.Provider;
import com.hya.service.ProviderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProviderServiceImpl extends ServiceImpl<ProviderDao, Provider> implements ProviderService {
}
