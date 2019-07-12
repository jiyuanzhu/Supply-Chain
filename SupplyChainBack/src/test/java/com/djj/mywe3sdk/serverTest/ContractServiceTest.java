package com.djj.mywe3sdk.serverTest;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.BaseTest;
import com.djj.mywe3sdk.dao.ContractDao;
import com.djj.mywe3sdk.service.ContractService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ContractServiceTest extends BaseTest {
    @Autowired
    private ContractService contractService;


    @Test
    public void addContractTest() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","con-005");
        jsonObject.put("name","conD");
        jsonObject.put("partyA","甲方2");
        jsonObject.put("partyB","乙方2");
        jsonObject.put("time","2010-1-2 20:02:13");
        jsonObject.put("url","//:C/13");
        jsonObject.put("md5","adfdhladfahdf11");
        jsonObject.put("state","1");
        System.out.println(jsonObject);
        contractService.addContract(jsonObject);

    }

    @Test
    public void listContractTest() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("company_name","甲方2");
        System.out.println(contractService.listUnsignedContract(jsonObject));
    }

    @Test
    public void signedContractTest() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","con-002");
        jsonObject.put("name","conD");
        jsonObject.put("partyA","甲方2");
        jsonObject.put("partyB","乙方2");
        jsonObject.put("time","2010-1-2 20:02:13");
        jsonObject.put("url","//:C/13");
        jsonObject.put("md5","adfdhladfahdf11");
        jsonObject.put("state","0");
        System.out.println(jsonObject);
        contractService.signedContract(jsonObject);
    }

}
