package com.hya.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@TableName(value = "purchase_orders")

public class PurchaseOrders {
    private String poId;
    private String provId;
    private String creationDate;
    private String sum;
    private Boolean status;
    private String empId;
    private String message;
    private String storageDate;
    private String wname;
    @Autowired
    @TableField(exist = false)
    private List<PurchaseOrderDetails> detail;
}
