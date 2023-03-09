package com.hya.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParser;
import com.hya.R;
import com.hya.dao.UserDao;
import com.hya.pojo.User;
import com.hya.pojo.Warehouse;
import com.hya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

@RequestMapping("/user")
@RestController

public class UserController {
    @Autowired
    private UserService userService;

    //登录功能
    @PostMapping("/login")
    public R login(@RequestBody User user, HttpServletResponse response, HttpServletRequest request) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("user_account", user.getUserAccount()).eq("password", user.getPassword());
        User one = userService.getOne(queryWrapper);
        if (one == null) {
            return new R(false);
        } else {
            HttpSession session = request.getSession();
            ;
            session.setAttribute("user", one);
            return new R(true);
        }
    }

    @GetMapping("/getAll")
    public R getAll() {
        List<User> list = userService.list();
        return new R(true, list);
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable String id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_Account", id);
        return new R(userService.remove(queryWrapper));
    }

    @PostMapping("/add")
    public R add(@RequestBody User user) {
        return new R(userService.save(user));
    }

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable String id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("user_account", id);
        return new R(true, userService.getOne(queryWrapper));
    }

    @PutMapping("/update")
    public R update(@RequestBody User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account", user.getUserAccount());
        user.setUserAccount(null);
        return new R(userService.update(user, queryWrapper));
    }


}
