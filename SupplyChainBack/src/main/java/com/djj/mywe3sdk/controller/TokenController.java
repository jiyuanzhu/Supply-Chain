package com.djj.mywe3sdk.controller;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.service.BlockChainService;
import com.djj.mywe3sdk.service.TokenService;
import com.djj.mywe3sdk.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private BlockChainService blockChainService;

    @PostMapping("/pay")
    public JSONObject tokenPay(@RequestBody JSONObject requestJson){
        return tokenService.tokenPayment(requestJson);
    }

    /*token查询*/
    @GetMapping("/lines")
    public JSONObject tokenQuery(HttpServletRequest request){
        return tokenService.tokenQuery(CommonUtil.request2Json(request));
    }

    /*token兑付*/
    @PostMapping("/exchange")
    public JSONObject tokenGive(@RequestBody JSONObject requestJson){
//        String name = requestJson.getString("companySubName");
//        System.out.println(requestJson);
//        JSONObject na = new JSONObject();
//        na.put("company_name",name);
//        JSONObject jsonObject = tokenService.getId(na);
//        String a = requestJson.getString("amount");
//        jsonObject.put("amount",a);
//        blockChainService.exchangeOnChain(jsonObject);
        return tokenService.tokenGiven(requestJson);
    }

}
