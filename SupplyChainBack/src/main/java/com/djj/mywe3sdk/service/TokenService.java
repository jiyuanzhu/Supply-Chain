package com.djj.mywe3sdk.service;

import com.alibaba.fastjson.JSONObject;

public interface TokenService {
    /*支付Token*/
    JSONObject tokenPayment(JSONObject jsonObject);

    /*兑付Token,是添加一个条目到待确认兑付token表*/
    JSONObject tokenGiven(JSONObject jsonObject);

    /*查询Token*/
    JSONObject tokenQuery(JSONObject jsonObject);

    /*获取公司id*/
    JSONObject getId(JSONObject jsonObject);
}