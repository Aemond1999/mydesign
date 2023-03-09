package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hya.R;
import com.hya.pojo.RawMaterial;
import com.hya.pojo.Warehouse;
import com.hya.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/raw")
@RestController
public class RawMaterialController {
    @Autowired
    private RawMaterialService rawMaterialService;

    @GetMapping("/pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current, @PathVariable int size, RawMaterial rawMaterial) {
        IPage<RawMaterial> iPage = new Page<>(current, size);
        QueryWrapper<RawMaterial> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!rawMaterial.getRawId().isEmpty(), "raw_id", rawMaterial.getRawId());
        queryWrapper.like(!rawMaterial.getRawName().isEmpty(), "raw_name", rawMaterial.getRawName());
        queryWrapper.like(!rawMaterial.getWname().isEmpty(), "wname", rawMaterial.getWname());
        return new R(rawMaterialService.page(iPage, queryWrapper));
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable String id) {
        QueryWrapper<RawMaterial> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("raw_id", id);
        return new R(rawMaterialService.remove(queryWrapper));
    }

    @PostMapping("/add")
    public R add(@RequestBody RawMaterial rawMaterial) {
        return new R(rawMaterialService.save(rawMaterial));
    }

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable String id) {
        QueryWrapper<RawMaterial> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("raw_id", id);
        return new R(true, rawMaterialService.getOne(queryWrapper));
    }

    @PutMapping("/update")
    public R update(@RequestBody RawMaterial rawMaterial) {
        QueryWrapper<RawMaterial> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("raw_id", rawMaterial.getRawId());
        rawMaterial.setRawId(null);
        return new R(rawMaterialService.update(rawMaterial, queryWrapper));
    }

}
