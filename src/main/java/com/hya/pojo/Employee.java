package com.hya.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Employee {
    private String empId;
    private String empName;
    private String deptName;
    private String phonenum;
    private String gender;
    private String address;
    private String hiredate;
}
