package com.djj.mywe3sdk.service;

import com.alibaba.fastjson.JSONObject;

public interface TransService {
    /*物流列表*/
    JSONObject listTrans(JSONObject jsonObject);

    /*订单确认*/
    JSONObject addTrans(JSONObject jsonObject);

    /*改变物流状态*/
    JSONObject  changeTransState(JSONObject jsonObject);

}
