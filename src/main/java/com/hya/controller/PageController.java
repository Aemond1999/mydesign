package com.hya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/toHomepage")
    public String toHomepage() {
        return "homepage";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toEmployee")
    public String toEmployee() {
        return "employee";
    }

    @RequestMapping("/toPurchase")
    public String toPurchase() {
        return "purchase";
    }

    @RequestMapping("/toPurchaseOrders")
    public String toPurchaseOrders() {
        return "purchaseorders";
    }

    @RequestMapping("/toRawMaterials")
    public String toRawMaterials() {
        return "rawmaterial";
    }

    @RequestMapping("/toProduct")
    public String toProduct() {
        return "product";
    }

    @RequestMapping("/toWarehouse")
    public String toWarehouse() {
        return "warehouse";
    }

    @RequestMapping("/toProvider")
    public String toProvider() {
        return "provider";
    }
    @RequestMapping("/toCustomer")
    public String toCustomer() {
        return "customer";
    }
    @RequestMapping("/toRole")
    public String toRole() {
        return "role";
    }
    @RequestMapping("/toUser")
    public String toUser() {
        return "user";
    }
    @RequestMapping("/toSale")
    public String toSale() {
        return "sale";
    }

    @RequestMapping("/toSalesOrders")
    public String toSalesOrders() {
        return "salesorders";
    }
    @RequestMapping("/toCheck")
    public String toCheck() {
        return "checksheets";
    }
}
