package com.hya.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Catalogue {
    private String rawId;
    private String rawName;
    private Float value;
    private String unit;
    @TableField(exist = false)
    private String num;
}
