package com.djj.mywe3sdk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.dao.PolicyDao;
import com.djj.mywe3sdk.service.PolicyService;
import com.djj.mywe3sdk.util.CommonUtil;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Resource
    private PolicyDao policyDao;

    @Override
    public JSONObject listPolicy(JSONObject jsonObject){
        List<JSONObject> list = policyDao.listPolicy(jsonObject);
        return CommonUtil.successList(list);
    }

    @Override
    public JSONObject addPolicy(JSONObject jsonObject){
        policyDao.addPolicy(jsonObject);
        return CommonUtil.successJson();
    }
}

