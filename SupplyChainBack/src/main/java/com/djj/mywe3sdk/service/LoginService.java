package com.djj.mywe3sdk.service;

import com.alibaba.fastjson.JSONObject;

public interface LoginService {
    /*处理登陆*/
    JSONObject userLogin(JSONObject jsonObject);

    /*注册*/
    JSONObject registerUser(JSONObject jsonObject);

}
