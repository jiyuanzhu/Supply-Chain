package com.djj.mywe3sdk.constants;

public enum ErrorEnum {
//    E_400("400", "请求处理异常，请稍后再试"),
//    E_500("500", "请求方式有误,请检查 GET/POST"),
//    E_501("501", "请求路径不存在"),
//    E_502("502", "权限不足"),
//    E_10008("10008", "角色删除失败,尚有用户属于此角色"),
//    E_10009("10009", "账户已存在"),
//
//    E_20011("20011", "登陆已过期,请重新登陆"),
//
//    E_90003("90003", "缺少必填参数");

    E_1001("1001","账号不存在"),
    E_1002("1002","密码错误"),


    E_1003("1003","账号已存在"),
    E_1004("1004","账号或密码不能为空"),
    E_2001("2001","账户余额不足"),

    E_3001("3001","文件为空");

    private String errorCode;

    private String errorMsg;

    ErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
