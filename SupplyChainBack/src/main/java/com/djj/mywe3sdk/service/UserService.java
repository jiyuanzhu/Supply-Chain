package com.djj.mywe3sdk.service;

import com.alibaba.fastjson.JSONObject;

public interface UserService {
//    修改密码
    JSONObject changePass(JSONObject jsonObject);

//    获取个人信息
    JSONObject getInfo(JSONObject jsonObject);

    //修改个人信息
    JSONObject infoChange(JSONObject jsonObject);
}
