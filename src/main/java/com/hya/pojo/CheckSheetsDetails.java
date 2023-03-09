package com.hya.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@TableName(value = "check_sheets_details")
public class CheckSheetsDetails {
    private Integer pid;
    private String fpId;
    private String fpName;
    private Float value;
    private Integer num;
    private String unit;
    private String wname;
    @TableId
    private String csId;

}
