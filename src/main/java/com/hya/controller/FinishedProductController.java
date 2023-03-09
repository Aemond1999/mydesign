package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hya.R;
import com.hya.pojo.FinishedProduct;
import com.hya.pojo.RawMaterial;
import com.hya.service.FinishedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class FinishedProductController {
    @Autowired
    private FinishedProductService finishedProductService;

    @GetMapping("/pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current, @PathVariable int size, FinishedProduct finishedProduct) {
        IPage<FinishedProduct> iPage = new Page<>(current, size);
        QueryWrapper<FinishedProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!finishedProduct.getFpId().isEmpty(), "fp_id", finishedProduct.getFpId());
        queryWrapper.like(!finishedProduct.getFpName().isEmpty(), "fp_name", finishedProduct.getFpName());
        queryWrapper.like(!finishedProduct.getWname().isEmpty(), "wname", finishedProduct.getWname());
        return new R(finishedProductService.page(iPage, queryWrapper));
    }

    @GetMapping("/getAll")
    public R getAll() {
        return new R(finishedProductService.list());
    }

    @GetMapping("/getByWname/{wname}")
    public R getByWname(@PathVariable String wname) {
        QueryWrapper<FinishedProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wname",wname);
        return new R(finishedProductService.list(queryWrapper));
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable String id) {
        QueryWrapper<FinishedProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("fp_id", id);
        return new R(finishedProductService.remove(queryWrapper));
    }

    @PostMapping("/add")
    public R add(@RequestBody FinishedProduct finishedProduct) {
        return new R(finishedProductService.save(finishedProduct));
    }

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable String id) {
        QueryWrapper<FinishedProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("fp_id", id);
        return new R(true, finishedProductService.getOne(queryWrapper));
    }

    @PutMapping("/update")
    public R update(@RequestBody FinishedProduct finishedProduct) {
        QueryWrapper<FinishedProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("fp_id", finishedProduct.getFpId());
        finishedProduct.setFpId(null);
        return new R(finishedProductService.update(finishedProduct, queryWrapper));
    }

}
