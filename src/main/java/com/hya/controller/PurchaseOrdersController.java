package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hya.R;
import com.hya.pojo.PurchaseOrderDetails;
import com.hya.pojo.PurchaseOrders;
import com.hya.pojo.RawMaterial;
import com.hya.service.PurchaseOrderDetailsService;
import com.hya.service.PurchaseOrdersService;
import com.hya.service.RawMaterialService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/po")
public class PurchaseOrdersController {
    @Autowired
    private PurchaseOrdersService purchaseOrdersService;
    @Autowired
    private PurchaseOrderDetailsService purchaseOrderDetailsService;
    @Autowired
    private RawMaterialService rawMaterialService;


    @GetMapping("/pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current, @PathVariable int size, PurchaseOrders purchaseOrders) {
        IPage<PurchaseOrders> iPage = new Page<>(current, size);
        QueryWrapper<PurchaseOrders> one = new QueryWrapper<>();
        one.eq(!purchaseOrders.getPoId().isEmpty(), "po_id", purchaseOrders.getPoId());
        one.like(!purchaseOrders.getWname().isEmpty(), "wname", purchaseOrders.getWname());
        IPage<PurchaseOrders> page = purchaseOrdersService.page(iPage, one);
        for (PurchaseOrders orders : page.getRecords()) {
            orders.setDetail(purchaseOrderDetailsService.list(new QueryWrapper<PurchaseOrderDetails>().eq("po_id", orders.getPoId())));
        }
        return new R(page);
    }


    @PostMapping("/add")
    private R addOrders(@RequestBody PurchaseOrders po) {
        List<PurchaseOrderDetails> detail = po.getDetail();
        for (PurchaseOrderDetails purchaseOrderDetails : detail) {
            purchaseOrderDetails.setPoId(po.getPoId());
        }
        boolean a = purchaseOrderDetailsService.saveBatch(detail);
        po.setDetail(null);
        boolean b = purchaseOrdersService.save(po);
        return new R(a && b);
    }

    @PostMapping("/putInStorage")
    private R putInStorage(@RequestBody PurchaseOrders po) {
        List<PurchaseOrderDetails> details = po.getDetail();
        List<RawMaterial> rawMaterials = new ArrayList<>();
        QueryWrapper<PurchaseOrders> queryWrapper = new QueryWrapper<>();
        for (PurchaseOrderDetails detail : details) {
            RawMaterial r = new RawMaterial();
            r.setRawId(detail.getRawId());
            r.setUnit(detail.getUnit());
            r.setNum(detail.getNum());
            r.setRawName(detail.getRawName());
            r.setValue(detail.getValue());
            r.setWname(po.getWname());
            rawMaterials.add(r);
        }
        if (rawMaterialService.saveOrUpdateBatch(rawMaterials)) {
            //设置入库日期
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = format.format(calendar.getTime());
            po.setStorageDate(date);
            //设置状态
            po.setStatus(true);
            queryWrapper.eq("po_id", po.getPoId());
            purchaseOrdersService.update(po, queryWrapper);
            return new R(rawMaterialService.saveOrUpdateBatch(rawMaterials));
        } else {
            return new R(false);
        }


    }
}
