package com.hya.controller;

import com.hya.R;
import com.hya.pojo.PurchaseOrderDetails;
import com.hya.service.PurchaseOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchaseDetails")
public class PurchaseOrderDetailsController {
    @Autowired
    private PurchaseOrderDetailsService pods;
    @PostMapping("/packing")
    public R save(@RequestBody List<PurchaseOrderDetails> details){
        return new R(true,details);
    }
}
