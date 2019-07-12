package com.djj.mywe3sdk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.constants.ErrorEnum;
import com.djj.mywe3sdk.dao.BankDao;
import com.djj.mywe3sdk.dao.TokenDao;
import com.djj.mywe3sdk.service.BankService;
import com.djj.mywe3sdk.service.TokenService;
import com.djj.mywe3sdk.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TokenServiceImpl implements TokenService{

    @Resource
    private TokenDao tokenDao;
    @Resource
    private BankDao bankDao;

    @Override
    public JSONObject getId(JSONObject jsonObject){
        return bankDao.getId(jsonObject);
    }

    @Override
    public JSONObject tokenGiven(JSONObject jsonObject) {
        String name = jsonObject.getString("companySubName");
        JSONObject result = tokenDao.tokenGet(name);
        if(result.getIntValue("companyToken")<jsonObject.getIntValue("amount")){
            /*100000处应为 jsonObject.getIntValue(key:"companyPayId"），但是一直报错*/
            /*此处token不够兑换报错*/
            return CommonUtil.errorJson(ErrorEnum.E_2001);
        }
        System.out.println(jsonObject);
        tokenDao.tokenUnpay(jsonObject);
        tokenDao.tokenSub(jsonObject);

        return CommonUtil.successJson();
    }

    @Override
    public JSONObject tokenPayment(JSONObject jsonObject) {
        String payerName = jsonObject.getString("companySubName");
        JSONObject result = tokenDao.tokenGet(payerName);
        if(result.getIntValue("companyToken")<jsonObject.getIntValue("amount")){
            /*200000处应为 jsonObject.getIntValue(key:"companySubId"），但是一直报错*/
            /*此处token不够支付报错*/
            return CommonUtil.errorJson(ErrorEnum.E_2001);
        }
        tokenDao.tokenAdd (jsonObject);
        tokenDao.tokenSub (jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject tokenQuery(JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        JSONObject result = tokenDao.tokenGetById(id);
        return CommonUtil.successJson(result);
    }
}
