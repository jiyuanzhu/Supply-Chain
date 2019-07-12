package com.djj.mywe3sdk.serverTest;


import com.djj.mywe3sdk.BaseTest;
import com.djj.mywe3sdk.dao.LoginDao;
import com.djj.mywe3sdk.service.LoginService;
import org.junit.Test;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertTrue;

public class LoginServiceTest extends BaseTest {

    @Autowired
    private LoginService loginService;


    /*注册的测试*/
    @Test
    public void registerTest()throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type","e");
        jsonObject.put("username","first1");
        jsonObject.put("password","pass");
        System.out.println(jsonObject);
        System.out.println(loginService.registerUser(jsonObject));
    }

    /*登陆获取用户密码*/
    @Test
    public void loginTest() throws Exception{
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("username","Ffsa");
        jsonObject.put("password","");
        System.out.println(jsonObject);
        System.out.println(loginService.userLogin(jsonObject));
    }
}
