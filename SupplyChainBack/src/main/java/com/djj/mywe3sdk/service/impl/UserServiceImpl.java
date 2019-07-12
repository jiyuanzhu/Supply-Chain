package com.djj.mywe3sdk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.constants.ErrorEnum;
import com.djj.mywe3sdk.dao.LoginDao;
import com.djj.mywe3sdk.dao.UserDao;
import com.djj.mywe3sdk.service.UserService;
import com.djj.mywe3sdk.util.CommonUtil;
import lombok.Builder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private LoginDao loginDao;

    @Override
    public JSONObject changePass(JSONObject jsonObject){
        String username = jsonObject.getString("username");
        String oldPass = jsonObject.getString("oldPass");
        JSONObject re = loginDao.getUser(username);
        if(re == null)
            return CommonUtil.errorJson(ErrorEnum.E_1001);
        String pass = userDao.getPass(jsonObject).getString("password");
        if(pass.equals(oldPass))
        {
            userDao.changePass(jsonObject);
            return CommonUtil.successJson();
        }
        else
            return CommonUtil.errorJson(ErrorEnum.E_1002);
    }

    @Override
    public JSONObject getInfo(JSONObject jsonObject){
        String id = jsonObject.getString("id");
        JSONObject re = userDao.existId(id);
        if(re == null)
            return CommonUtil.errorJson(ErrorEnum.E_1001);
        JSONObject result = userDao.infoGet(jsonObject);
        return CommonUtil.successJson(result);
    }

    @Override
    public JSONObject infoChange(JSONObject jsonObject){
        String id = jsonObject.getString("id");
        JSONObject re = userDao.existId(id);
        if(re == null)
            return CommonUtil.errorJson(ErrorEnum.E_1001);
        userDao.infoChange(jsonObject);
        return CommonUtil.successJson();
    }

}
