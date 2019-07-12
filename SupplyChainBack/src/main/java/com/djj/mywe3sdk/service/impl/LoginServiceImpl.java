package com.djj.mywe3sdk.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.constants.ErrorEnum;
import com.djj.mywe3sdk.dao.LoginDao;
import com.djj.mywe3sdk.service.LoginService;
import com.djj.mywe3sdk.util.CommonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;

    @Override
    public JSONObject userLogin(JSONObject jsonObject){
        String username = jsonObject.getString("username");
        String pass = jsonObject.getString("password");
        if(pass.isEmpty()|| username.isEmpty())
            return CommonUtil.errorJson(ErrorEnum.E_1004);
        JSONObject result = loginDao.getUser(username);
        if(result != null)
        {
            String password = result.getString("password");
            if(password.equals(pass)) {
                JSONObject u = loginDao.getId(jsonObject);
                String id = u.getString("id");
                String name = loginDao.getName(u).getString("company_name");
                u.put("company_name",name);
                return CommonUtil.successJson(u);
            }
            else
                return CommonUtil.errorJson(ErrorEnum.E_1002);

        }
        return CommonUtil.errorJson(ErrorEnum.E_1001);
    }

    @Override
    public JSONObject registerUser(JSONObject jsonObject){
        String name = jsonObject.getString("username");
        String pass = jsonObject.getString("password");
        if(pass.isEmpty()|| name.isEmpty())
            return CommonUtil.errorJson(ErrorEnum.E_1004);
        if(loginDao.getUser(name) != null)
            return CommonUtil.errorJson(ErrorEnum.E_1003);
        loginDao.addUser(jsonObject);
        return CommonUtil.successJson();
    }

}
