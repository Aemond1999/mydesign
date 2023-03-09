package com.hya.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CheckSheetsDetails {
    private Integer id;
    private String  commodityId;
    private String  wname;
    private Integer num;
    private String name;
    private String ckId;

}
