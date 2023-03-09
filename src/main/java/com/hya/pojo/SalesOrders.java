package com.hya.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@TableName("sales_orders")
public class SalesOrders {
    private String soId;
    private String cid;
    private String creationDate;
    private String sum;
    private Boolean status;
    private String empId;
    private String message;
    private String deliveryDate;
    private String wname;
    @Autowired
    @TableField(exist = false)
    private List<SalesOrdersDetails> detail;
}
