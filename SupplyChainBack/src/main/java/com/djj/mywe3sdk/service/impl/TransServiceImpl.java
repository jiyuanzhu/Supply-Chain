package com.djj.mywe3sdk.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.dao.TransDao;
import com.djj.mywe3sdk.service.TransService;

import com.djj.mywe3sdk.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.peer.CanvasPeer;
import java.util.List;

@Service
public class TransServiceImpl implements TransService {
    @Resource
    private TransDao transDao;

    @Override
    public JSONObject listTrans(JSONObject jsonObject){
        List<JSONObject> list = transDao.listTrans(jsonObject);
        return CommonUtil.successJson(list);
    }

    @Override
    public JSONObject changeTransState(JSONObject jsonObject){
        transDao.changeState(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject addTrans(JSONObject jsonObject){
        transDao.addTrans(jsonObject);
        return CommonUtil.successJson();
    }


}
