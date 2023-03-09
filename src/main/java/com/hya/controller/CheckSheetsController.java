package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hya.R;
import com.hya.pojo.*;
import com.hya.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckSheetsController {
    @Autowired
    private CheckSheetsService checkSheetsService;
    @Autowired
    private CheckSheetDetailsService checkSheetDetailsService;
    @Autowired
    private FinishedProductService finishedProductService;


    @GetMapping("/pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current, @PathVariable int size, CheckSheets checkSheets) {
        IPage<CheckSheets> iPage = new Page<>(current, size);
        QueryWrapper<CheckSheets> one = new QueryWrapper<>();
        System.out.println(checkSheets.getCsId().isEmpty()+"/"+checkSheets.getWname().isEmpty());
        one.eq(!checkSheets.getCsId().isEmpty(), "cs_id", checkSheets.getCsId());
        one.like(!checkSheets.getWname().isEmpty(), "wname", checkSheets.getWname());
        IPage<CheckSheets> page = checkSheetsService.page(iPage, one);
        for (CheckSheets sheet : page.getRecords()) {
            sheet.setDetail(checkSheetDetailsService.list(new QueryWrapper<CheckSheetsDetails>().eq("cs_id", sheet.getCsId())));
        }
        return new R(page);
    }


    @PostMapping("/add")
    private R addOrders(@RequestBody CheckSheets cs) {
        List<CheckSheetsDetails> details = cs.getDetail();
        for (CheckSheetsDetails detail : details) {
            detail.setCsId(cs.getCsId());
            cs.setOriginalNum(detail.getNum());

        }

        boolean a = checkSheetDetailsService.saveBatch(details);
        cs.setDetail(null);
        boolean b = checkSheetsService.save(cs);
        return new R(a && b);
    }

    @PostMapping("/pullOrPush")
    private R putInStorage(@RequestBody CheckSheets checkSheets) {
        QueryWrapper<FinishedProduct> queryWrapper = new QueryWrapper<>();
        List<CheckSheetsDetails> details = checkSheets.getDetail();
        FinishedProduct finishedProduct = new FinishedProduct();
        for (CheckSheetsDetails detail : details) {
            finishedProduct.setPid(detail.getPid());
        }
        finishedProduct.setNum(checkSheets.getRealNum());
        queryWrapper.eq("pid", finishedProduct.getPid());
        if (checkSheets.getProfitAndLoss() != 0) {
            if (finishedProductService.update(finishedProduct, queryWrapper)) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(calendar.getTime());
                checkSheets.setCheckDate(date);
                checkSheets.setStatus(true);
                QueryWrapper<CheckSheets> checkSheetsQueryWrapper = new QueryWrapper<>();
                checkSheetsQueryWrapper.eq("cs_id", checkSheets.getCsId());
                return new R(checkSheetsService.update(checkSheets, checkSheetsQueryWrapper));
            } else {
                return new R(false);
            }
        } else {
            return new R(false);
        }


    }

}
