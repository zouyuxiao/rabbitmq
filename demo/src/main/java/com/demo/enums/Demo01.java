package com.demo.enums;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-28 13:52
 */
public enum Demo01 {
    SUCCESS(200,"操作成功"),
    ERROR(500,"操作失败");

    private Integer code;
    private String msg;

    Demo01(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
