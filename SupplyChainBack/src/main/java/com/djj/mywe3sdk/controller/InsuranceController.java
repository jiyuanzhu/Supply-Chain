package com.djj.mywe3sdk.controller;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.service.PolicyService;
import com.djj.mywe3sdk.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    private PolicyService policyService;

    /*保单列表*/
    @GetMapping("/policy/list")
    public JSONObject listPolicy(HttpServletRequest request){
        return policyService.listPolicy(CommonUtil.request2Json(request));
    }
}
