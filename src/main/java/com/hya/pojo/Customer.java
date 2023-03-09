package com.hya.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Customer {
    private String cid;
    private String cname;
    private String linkman;
    private String phonenum;
    private String address;
    private String bankname;
    private String banknum;
};
;