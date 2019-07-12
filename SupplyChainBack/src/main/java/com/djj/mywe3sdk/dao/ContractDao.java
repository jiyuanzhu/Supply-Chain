package com.djj.mywe3sdk.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContractDao {
    /*全部合同列表*/
    List<JSONObject>listContract(JSONObject jsonObject);

    /*甲方增加合同*/
    void addContract(JSONObject jsonObject);

    /*乙方确认合同*/
    void signedContract(JSONObject jsonObject);

    /*显示待签合同*/
    List<JSONObject>listUnsignedContract(JSONObject jsonObject);


}
