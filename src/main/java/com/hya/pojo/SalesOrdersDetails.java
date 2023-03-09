package com.hya.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@TableName(value = "sales_orders_details")
public class SalesOrdersDetails {
    private String soId;
    private String fpId;
    private String fpName;
    private Float value;
    private Integer outnum;
    private Integer pid;
    private Integer num;
    private String unit;
    private String wname;
    @TableId
    private Integer id;
}
