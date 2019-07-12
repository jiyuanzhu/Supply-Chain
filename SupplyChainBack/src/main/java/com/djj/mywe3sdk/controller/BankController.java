package com.djj.mywe3sdk.controller;



import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.service.BankService;
import com.djj.mywe3sdk.service.BlockChainService;
import com.djj.mywe3sdk.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @Autowired
    private BlockChainService blockChainService;

    /*授信列表*/
    @GetMapping("/creditList")
    public JSONObject list(HttpServletRequest request){
        return bankService.list(CommonUtil.request2Json(request));
    }

    /*新增授信*/
    @PostMapping("/addCredit")
    public JSONObject add(@RequestBody JSONObject requestJson){
        bankService.credit(requestJson);
        JSONObject jsonObject = bankService.getId(requestJson);
        jsonObject.put("name",requestJson.getString("company_name"));
        jsonObject.put("amount",requestJson.getString("limits"));
        blockChainService.creditOnChain(jsonObject);
        return CommonUtil.successJson();
    }

    /*兑换列表*/
    @GetMapping("/exchangeList")
    public JSONObject listExchange(HttpServletRequest request){
        return bankService.listExchange(CommonUtil.request2Json(request));
    }

    /*兑现token*/
    @PostMapping("/exchange")
    public JSONObject exchange(@RequestBody JSONObject requestJson){
        return bankService.exchange(requestJson);
    }

}

