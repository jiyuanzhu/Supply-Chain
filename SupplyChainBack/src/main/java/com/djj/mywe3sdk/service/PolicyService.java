package com.djj.mywe3sdk.service;

import com.alibaba.fastjson.JSONObject;

public interface PolicyService {
    //    保单列表
    JSONObject listPolicy(JSONObject jsonObject);

//        保单购买,添加
    JSONObject addPolicy(JSONObject jsonObject);
}
