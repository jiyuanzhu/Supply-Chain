package com.djj.mywe3sdk.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {
//    改密码
    void changePass(JSONObject jsonObject);

//    获取信息
    JSONObject infoGet(JSONObject jsonObject);

    //修改信息
    void infoChange(JSONObject jsonObject);

    //获取旧密码
    JSONObject getPass(JSONObject jsonObject);

    //查看用户存在
    JSONObject existId(@Param("id")String id);
}
