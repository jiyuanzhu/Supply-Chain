package com.djj.mywe3sdk.controller;


import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.service.LoginService;
import com.djj.mywe3sdk.service.UserService;
import com.djj.mywe3sdk.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    /*登陆*/
    @PostMapping("/login")
    public JSONObject login(@RequestBody JSONObject requestJson){
        return loginService.userLogin(requestJson);
    }

    /*注册*/
    @PostMapping("/register")
    public JSONObject register(@RequestBody JSONObject requestJson){
        return loginService.registerUser(requestJson);
    }

    /*修改密码*/
    @PostMapping("/changePass")
    public JSONObject changePass(@RequestBody JSONObject requestJson){
        System.out.println(requestJson);
        return userService.changePass(requestJson);
    }

    /*修改个人信息*/
    @PostMapping("/info")
    public JSONObject infoChange(@RequestBody JSONObject requestJson){
        return userService.infoChange(requestJson);
    }

    /*显示个人信息*/
    @GetMapping("/info")
    public JSONObject listTrans(HttpServletRequest request){
        return userService.getInfo(CommonUtil.request2Json(request));
    }

}
