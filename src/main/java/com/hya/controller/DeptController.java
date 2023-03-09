package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hya.R;
import com.hya.pojo.Dept;
import com.hya.pojo.Warehouse;
import com.hya.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dept")
@RestController

public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/getAll")
    public R getAll() {
        List<Dept> list = deptService.list();
        return new R(true, list);
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable String id) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dept_id",id);
        return new R(deptService.remove(queryWrapper));
    }

    @PostMapping("/add")
    public R add(@RequestBody Dept dept) {
        return new R(deptService.save(dept));
    }

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable String id) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("dept_id", id);
        return new R(true, deptService.getOne(queryWrapper));
    }

    @PostMapping("/update")
    public R update(@RequestBody Dept dept) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dept_id", dept.getDeptId());
        return new R(deptService.update(dept, queryWrapper));
    }
}
