package com.djj.mywe3sdk.serverTest;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.BaseTest;
import com.djj.mywe3sdk.service.BankService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BankServiceTest extends BaseTest {
    @Autowired
    private BankService bankService;

    @Test
    public void list(){
        System.out.println(bankService.list(new JSONObject()));
    }

    @Test
    public void add(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("company_name","helo");
        jsonObject.put("limits",100);
        jsonObject.put("time","helo");
        bankService.credit(jsonObject);

    }

    @Test
    public void delete(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","7");
        bankService.exchange(jsonObject);
    }
}
