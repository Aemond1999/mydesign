package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hya.R;
import com.hya.pojo.Employee;
import com.hya.pojo.Provider;
import com.hya.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/provider")
@RestController
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/getAll")
    public R getAll() {
        List<Provider> list = providerService.list();
        return new R(true, list);
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable String id) {
        QueryWrapper<Provider> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("prov_id", id);
        return new R(providerService.remove(queryWrapper));
    }

    @PostMapping("/add")
    public R add(@RequestBody Provider provider) {

        return new R(providerService.save(provider));
    }

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable String id) {
        QueryWrapper<Provider> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("prov_id", id);
        return new R(true, providerService.getOne(queryWrapper));
    }

    @PutMapping("/update")
    public R update(@RequestBody Provider provider) {
        QueryWrapper<Provider> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("prov_id", provider.getProvId());
        provider.setProvId(null);
        return new R(providerService.update(provider, queryWrapper));
    }
}
