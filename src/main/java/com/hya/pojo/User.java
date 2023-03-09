package com.hya.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class User {
    private String userName;
    private String userAccount;
    private String password;
    private String roleName;


}
