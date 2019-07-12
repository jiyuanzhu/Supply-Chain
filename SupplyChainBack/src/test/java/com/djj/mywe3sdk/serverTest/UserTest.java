package com.djj.mywe3sdk.serverTest;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.BaseTest;
import com.djj.mywe3sdk.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void changeinfoTest(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("name","hel");
        jsonObject.put("address","1234");
        jsonObject.put("telephone","123456");
        jsonObject.put("size","123456");
        jsonObject.put("list","1");
        userService.infoChange(jsonObject);

    }

    @Test
    public void getinfoTest(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        System.out.println(userService.getInfo(jsonObject));

    }

    @Test
    public void changePass(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","first");
        jsonObject.put("oldPass","pass");
        jsonObject.put("newPass","fi");
        System.out.println(userService.changePass(jsonObject));
    }
}
