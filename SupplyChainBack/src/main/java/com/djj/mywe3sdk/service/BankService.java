package com.djj.mywe3sdk.service;


import com.alibaba.fastjson.JSONObject;

public interface BankService {
    //    授信
    JSONObject credit(JSONObject jsonObject);
    //    承兑
    JSONObject exchange(JSONObject jsonObject);

    //  显示授信列表
    JSONObject list(JSONObject jsonObject);

    //  显示兑付列表
    JSONObject listExchange(JSONObject jsonObject);

    //getId
    JSONObject getId(JSONObject jsonObject);
}
