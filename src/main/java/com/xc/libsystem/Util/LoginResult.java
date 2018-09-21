package com.xc.libsystem.Util;

import java.io.Serializable;

public class LoginResult {
    private String code;
    private String msg;

    //承载实体对象
    private Object object;

    public static LoginResult failLogin() {
        return new LoginResult("404", "用户名或密码错误");
    }

    public static LoginResult success() {
        return new LoginResult("200", "登陆成功");
    }

    public static LoginResult success(Object obj) {
        return new LoginResult("200", "登录成功", obj);
    }

    public LoginResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public LoginResult(String code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
