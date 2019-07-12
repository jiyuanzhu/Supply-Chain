package com.djj.mywe3sdk.serverTest;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.BaseTest;
import com.djj.mywe3sdk.service.TransService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TransServiceTeset extends BaseTest {

    @Autowired
    private TransService transService;

    @Test
    public void addTransTest()throws Exception{
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("company","trsf");
        jsonObject.put("sender","tradf");
        jsonObject.put("receiver","t001");
        jsonObject.put("item","qwr");

        jsonObject.put("time","1990-5-6");
        jsonObject.put("cost","12");
        jsonObject.put("order_state","1");
        transService.addTrans(jsonObject);
        System.out.println(jsonObject);
    }

    @Test
    public void listTransTest() throws Exception{
//        System.out.println(transService.listTrans());
    }

    @Test
    public void changeStateTest() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","1");;
        jsonObject.put("order_state","1");
        System.out.println(transService.changeTransState(jsonObject));
    }

}
