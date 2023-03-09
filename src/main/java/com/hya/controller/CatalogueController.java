package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hya.R;
import com.hya.dao.RoleDao;
import com.hya.pojo.Catalogue;
import com.hya.pojo.Customer;
import com.hya.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {
    @Autowired
    private CatalogueService catalogueService;

    @GetMapping("/getByProvId/{id}")
    public R getByProvId(@PathVariable String id) {
        QueryWrapper<Catalogue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("prov_id", id);
        List<Catalogue> list = catalogueService.list(queryWrapper);
        return new R(true, list);
    }
}
