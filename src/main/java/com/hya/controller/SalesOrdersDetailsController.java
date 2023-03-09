package com.hya.controller;

import com.hya.R;
import com.hya.pojo.PurchaseOrderDetails;
import com.hya.pojo.SalesOrdersDetails;
import com.hya.service.SalesOrdersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/saleDetails")
@RestController
public class SalesOrdersDetailsController {
    @Autowired
    private SalesOrdersDetailsService sods;

    @PostMapping("/packing")
    public R save(@RequestBody List<SalesOrdersDetails> details) {
        System.out.println(details);
        return new R(true, details);
    }
}