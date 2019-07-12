package com.djj.mywe3sdk.serverTest;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.BaseTest;
import com.djj.mywe3sdk.service.BlockChainService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BlockChainTest extends BaseTest {
    @Autowired
    private BlockChainService blockChainService;

    @Test
    public void testCreate(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","66");
        jsonObject.put("name","你好");
        jsonObject.put("amount","600");
        blockChainService.creditOnChain(jsonObject);
        JSONObject j = new JSONObject();
        j.put("id","66");
        blockChainService.balanceOnChain(j);

    }

}
