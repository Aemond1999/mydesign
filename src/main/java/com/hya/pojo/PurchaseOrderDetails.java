package com.hya.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@TableName(value = "purchase_orders_detail")
public class PurchaseOrderDetails   {
    private String poId;
    private String rawId;
    private String rawName;
    private Float value;
    private Integer num;
    private String unit;
    @TableId
    private Integer id;


}
