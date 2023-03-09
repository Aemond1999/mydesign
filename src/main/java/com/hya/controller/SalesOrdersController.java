package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hya.R;
import com.hya.pojo.*;
import com.hya.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/so")
public class SalesOrdersController {
    @Autowired
    private SalesOrdersDetailsService salesOrdersDetailsService;
    @Autowired
    private SalesOrdersService salesOrdersService;
    @Autowired
    private FinishedProductService finishedProductService;

    @GetMapping("/pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current, @PathVariable int size, SalesOrders salesOrders) {
        IPage<SalesOrders> iPage = new Page<>(current, size);
        QueryWrapper<SalesOrders> one = new QueryWrapper<>();
        one.eq(!salesOrders.getSoId().isEmpty(), "so_id", salesOrders.getSoId());
        one.like(!salesOrders.getWname().isEmpty(), "wname", salesOrders.getWname());
        IPage<SalesOrders> page = salesOrdersService.page(iPage, one);
        for (SalesOrders orders : page.getRecords()) {
            orders.setDetail(salesOrdersDetailsService.list(new QueryWrapper<SalesOrdersDetails>().eq("so_id", orders.getSoId())));
        }
        return new R(page);
    }


    @PostMapping("/add")
    private R addOrders(@RequestBody SalesOrders so) {
        List<SalesOrdersDetails> details = so.getDetail();
        System.out.println(details);
        for (SalesOrdersDetails detail : details) {
            detail.setSoId(so.getSoId());
            detail.setId(null);
        }
        boolean a = salesOrdersDetailsService.saveBatch(details);
        so.setDetail(null);
        boolean b = salesOrdersService.save(so);
        return new R(a && b);
    }

    @PostMapping("/takeInStorage")
    private R takeInStorage(@RequestBody SalesOrders so) {

        List<SalesOrdersDetails> details = so.getDetail();
        System.out.println(details);
        List<FinishedProduct> finishedProducts = new ArrayList<>();
        QueryWrapper<SalesOrders> queryWrapper = new QueryWrapper<>();
        QueryWrapper<FinishedProduct> updateWrapper = new QueryWrapper<>();
        for (SalesOrdersDetails detail : details) {

            FinishedProduct fp = new FinishedProduct();
            fp.setFpId(detail.getFpId());
            fp.setUnit(detail.getUnit());
            fp.setNum(detail.getNum() - detail.getOutnum());
            fp.setFpName(detail.getFpName());
            fp.setValue(detail.getValue());
            fp.setWname(detail.getWname());
            fp.setPid(detail.getPid());
            finishedProducts.add(fp);
        }
        if (finishedProductService.saveOrUpdateBatch(finishedProducts)) {
            //设置入库日期
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = format.format(calendar.getTime());
            so.setDeliveryDate(date);
            //设置状态
            so.setStatus(true);
            queryWrapper.eq("so_id", so.getSoId());
            salesOrdersService.update(so, queryWrapper);

            return new R(finishedProductService.updateBatchById(finishedProducts));
        } else {
            return new R(false);
        }
    }
}
