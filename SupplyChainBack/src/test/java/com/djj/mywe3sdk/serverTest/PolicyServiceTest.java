package com.djj.mywe3sdk.serverTest;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.BaseTest;
import com.djj.mywe3sdk.service.PolicyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class PolicyServiceTest extends BaseTest {

    @Autowired
    private PolicyService policyService;

    @Test
    public void addTest(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("insured","he");
        jsonObject.put("insurer","she");
        jsonObject.put("cost",15);
        jsonObject.put("time","2010-10-12");

        jsonObject.put("url","hewww");
        jsonObject.put("md5","hssasfde");
        policyService.addPolicy(jsonObject);

    }
}
