package com.hya.pojo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Provider {
    private String provId;
    private String provName;
    private String linkman;
    private String phonenum;
    private String address;
    private String bankname;
    private String banknum;
}
