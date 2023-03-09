package com.hya.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@TableName(value = "finished_product")
public class FinishedProduct {

    @TableId
    private Integer pid;
    private String fpId;
    private String fpName;
    private Float value;
    private Integer num;
    private String unit;
    private String wname;

    @TableField(exist = false)
    private Integer outnum;

}
