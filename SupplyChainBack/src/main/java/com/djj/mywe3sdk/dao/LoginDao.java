package com.djj.mywe3sdk.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    /*根据用户名返回对应的账号信息*/
    JSONObject getUser(@Param("username") String username);

    /*注册新增用户*/
    void addUser(JSONObject jsonObject);

    /*取用户id*/
    JSONObject getId(JSONObject jsonObject);

    /*获取用户名字*/
    JSONObject getName(JSONObject jsonObject);
}
