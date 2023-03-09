package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hya.R;
import com.hya.pojo.Dept;
import com.hya.pojo.Employee;
import com.hya.pojo.Warehouse;
import com.hya.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/warehouse")
@RestController
public class WareHouseController {
    @Autowired
    private WarehouseService warehouseService;
    @GetMapping("/getAll")
    public R getAll() {
        List<Warehouse> list = warehouseService.list();
        return new R(true, list);
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable String id) {
        QueryWrapper<Warehouse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wid", id);
        return new R(warehouseService.remove(queryWrapper));
    }

    @PostMapping("/add")
    public R add(@RequestBody Warehouse warehouse) {
        return new R(warehouseService.save(warehouse));
    }

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable String id) {
        QueryWrapper<Warehouse> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("wid", id);
        return new R(true, warehouseService.getOne(queryWrapper));
    }

    @PutMapping("/update")
    public R update(@RequestBody Warehouse warehouse) {
        QueryWrapper<Warehouse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wid", warehouse.getWid());
        warehouse.setWid(null);
        return new R(warehouseService.update(warehouse, queryWrapper));
    }


}
