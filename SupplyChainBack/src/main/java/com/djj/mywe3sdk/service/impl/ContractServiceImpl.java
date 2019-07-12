package com.djj.mywe3sdk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.dao.ContractDao;
import com.djj.mywe3sdk.service.ContractService;
import com.djj.mywe3sdk.util.CommonUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Resource
    private ContractDao contractDao;

    @Override
    public JSONObject listContract(JSONObject jsonObject){
        List<JSONObject> list = contractDao.listContract(jsonObject);
        return CommonUtil.successList(list);
    }

    @Override
    public JSONObject addContract(JSONObject jsonObject){
        contractDao.addContract(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject signedContract(JSONObject jsonObject){
        contractDao.signedContract(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listUnsignedContract(JSONObject jsonObject){
        List<JSONObject> list = contractDao.listUnsignedContract(jsonObject);
        return CommonUtil.successJson(list);
    }
}
