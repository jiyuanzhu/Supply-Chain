package com.djj.mywe3sdk.service;

import com.alibaba.fastjson.JSONObject;

public interface ContractService {

    /*显示合同列表*/
    JSONObject listContract(JSONObject jsonObject);

    /*甲方签合同*/
    JSONObject addContract(JSONObject jsonObject);

    /*乙方确认*/
    JSONObject signedContract(JSONObject jsonObject);

    /*显示乙方待签合同*/
    JSONObject listUnsignedContract(JSONObject jsonObject);
}
