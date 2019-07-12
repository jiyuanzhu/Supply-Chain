package com.djj.mywe3sdk.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransDao {

    /*读取物流列表*/
    List<JSONObject> listTrans(JSONObject jsonObject);

    /*增加条目*/
    void addTrans(JSONObject jsonObject);

    /*修改物流状态*/
    void changeState(JSONObject jsonObject);


    /**/

}
