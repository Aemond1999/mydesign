package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hya.R;
import com.hya.pojo.Customer;
import com.hya.pojo.Provider;
import com.hya.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public R getAll() {
        List<Customer> list = customerService.list();
        return new R(true, list);
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable String id) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid", id);
        return new R(customerService.remove(queryWrapper));
    }

    @PostMapping("/add")
    public R add(@RequestBody Customer customer) {
        return new R(customerService.save(customer));
    }

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable String id) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("cid", id);
        return new R(true, customerService.getOne(queryWrapper));
    }

    @PutMapping("/update")
    public R update(@RequestBody Customer customer) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid", customer.getCid());
        customer.setCid(null);
        return new R(customerService.update(customer, queryWrapper));
    }
}
