package com.djj.mywe3sdk.dao;


import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PolicyDao {
    /*保单列表*/
    List<JSONObject> listPolicy(JSONObject jsonObject);

    /*添加保单*/
    void addPolicy(JSONObject jsonObject);
}
