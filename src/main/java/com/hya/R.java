package com.hya;

import lombok.Data;

@Data
public class R {
    private boolean flag;
    private Object data;

    public R() {
    }

    public R(Object data) {
        this.data = data;
    }

    public R(boolean flag) {
        this.flag = flag;
    }
    public R(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
