package com.hya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hya.dao.UserDao;
import com.hya.pojo.User;
import com.hya.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
