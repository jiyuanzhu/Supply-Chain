package com.djj.mywe3sdk.serverTest;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.BaseTest;

import com.djj.mywe3sdk.service.TokenService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TokenServiceTest extends BaseTest {

    @Autowired
    private TokenService tokenService;


    @Test
    public void tokenPayTest() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("companyAddName","aa");
        jsonObject.put("companySubName","aaf");
        jsonObject.put("amount",10);
        System.out.println(jsonObject);
        System.out.println(tokenService.tokenPayment(jsonObject));
    }

    @Test
    public void tokenGiveTest() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","a11dff");
        jsonObject.put("companySubId","co-002");
        jsonObject.put("amount",100);
        jsonObject.put("time","1990-01-02 22:4:2");
        System.out.println(tokenService.tokenGiven(jsonObject));
        System.out.println(jsonObject);

    }

    @Test
    public void tokenIntTest() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","co-002");

        System.out.println(tokenService.tokenQuery(jsonObject));
    }
}
