package com.djj.mywe3sdk.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BankDao {
    //  删除exchange表条目
    void deleteLine(JSONObject jsonObject);

    //    授信表新建条目
    void addLine(JSONObject jsonObject);

    //更改user表中的type
    void updateType(JSONObject jsonObject);

    //授信要给被授信的一笔token
    void tokenByCredit(JSONObject jsonObject);

    /*全部授信列表*/
    List<JSONObject> listCredit();

    /*全部兑付列表*/
    List<JSONObject> listExchange();

    //新增一个company
    void addCompany(JSONObject jsonObject);

    //获取公司id
    JSONObject getId(JSONObject jsonObject);
}
