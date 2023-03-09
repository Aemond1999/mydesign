package com.hya.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@TableName(value = "rawmaterial")
public class RawMaterial {
    @TableId
    private Integer id;
    private String rawId;
    private String rawName;
    private Float   value;
    private Integer num;
    private Integer warning;
    private String unit;
    private String wname;

}
