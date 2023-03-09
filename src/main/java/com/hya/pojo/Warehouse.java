package com.hya.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Warehouse {
    private String wid;
    private String wname;
    private String address;
    private String description;
};
