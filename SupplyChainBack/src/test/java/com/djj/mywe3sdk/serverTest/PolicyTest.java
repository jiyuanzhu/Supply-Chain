package com.djj.mywe3sdk.serverTest;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.BaseTest;
import com.djj.mywe3sdk.service.PolicyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PolicyTest extends BaseTest {

    @Autowired
    private PolicyService policyService;

    @Test
    public void list(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","甲");
        System.out.println(policyService.listPolicy(jsonObject));
    }


}
