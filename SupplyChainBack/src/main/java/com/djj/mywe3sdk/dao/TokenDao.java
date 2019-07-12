package com.djj.mywe3sdk.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TokenDao {

    /*增加Token*/
    void tokenAdd(JSONObject jsonObject);

    /*减少Token*/
    void tokenSub(JSONObject jsonObject);

    /*兑换Token*/
    void tokenUnpay(JSONObject jsonObject);

    /*获得Token*/
    JSONObject tokenGet(@Param("company_name") String name);
    JSONObject tokenGetById(@Param("id") String id);

//    /*获得兑付Token用于判断是否够兑付*/
//    int tokenPayGet(JSONObject jsonObject);
//
//    /*获得支付Token用于判断是否够支付*/
//    int tokenSubGet(JSONObject jsonObject);
}
