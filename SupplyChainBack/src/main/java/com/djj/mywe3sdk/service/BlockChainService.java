package com.djj.mywe3sdk.service;


import com.alibaba.fastjson.JSONObject;

public interface BlockChainService {

    /*授信对象上链*/
    boolean creditOnChain(JSONObject jsonObject);

    /*普通企业创建*/
    boolean createOnChain(JSONObject jsonObject);

    /*链上token转账*/
    boolean payOnChain(JSONObject jsonObject);

    /*链上兑换*/
    boolean exchangeOnChain(JSONObject jsonObject);

    /*查询链上的token余额*/
    JSONObject balanceOnChain(JSONObject jsonObject);

    /*订单信息上链*/
    boolean orderInfoOnChain(JSONObject jsonObject);

    /*链上创建合同*/
    boolean createContractOnChain(JSONObject jsonObject);

    /*修改合同状态*/
    boolean changeContractStateOnChain(JSONObject jsonObject);

    /*查看合同状态*/
    JSONObject stateContract(JSONObject jsonObject);
}
