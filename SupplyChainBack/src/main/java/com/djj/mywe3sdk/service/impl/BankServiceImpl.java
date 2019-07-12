package com.djj.mywe3sdk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.dao.BankDao;
import com.djj.mywe3sdk.service.BankService;
import com.djj.mywe3sdk.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Resource
    private BankDao bankDao;

    @Override
    public JSONObject exchange(JSONObject jsonObject){
        bankDao.deleteLine(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject credit(JSONObject jsonObject){
        bankDao.addLine(jsonObject);
//        bankDao.updateType(jsonObject);
//        bankDao.tokenByCredit(jsonObject);
        bankDao.addCompany(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject getId(JSONObject jsonObject){
        return bankDao.getId(jsonObject);
    }

    @Override
    public JSONObject list(JSONObject jsonObject){
        List<JSONObject> list = bankDao.listCredit();
        return CommonUtil.successJson(list);
    }

    @Override
    public JSONObject listExchange(JSONObject jsonObject){
        List<JSONObject> list = bankDao.listExchange();
        return CommonUtil.successJson(list);
    }
}
