package com.hya.pojo;

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
@TableName("check_sheets")
public class CheckSheets {
    @TableId
    private String csId;
    private String creationDate;
    private String checkDate;
    private Boolean status;
    private Integer originalNum;
    private Integer realNum;
    private String message;
    private String empId;
    private String wname;
    @TableField("profit_and_loss")
    private Integer profitAndLoss;
    @TableField(exist = false)
    private List<CheckSheetsDetails>  detail;

}
