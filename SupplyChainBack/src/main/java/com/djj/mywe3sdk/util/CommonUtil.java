package com.djj.mywe3sdk.util;

import java.util.Enumeration;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.constants.MsgConstant;
import com.djj.mywe3sdk.constants.ErrorEnum;
import javax.servlet.http.HttpServletRequest;
public class CommonUtil {

    /*返回一个成功的json*/
    public static JSONObject successJson() {
        return successJson(new JSONObject());
    }

    public static JSONObject successJson(Object info) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", MsgConstant.SUCCESS_CODE);
        resultJson.put("msg", MsgConstant.SUCCESS_MSG);
        resultJson.put("info", info);
        return resultJson;
    }

     /* 返回错误信息JSON*/
    public static JSONObject errorJson(ErrorEnum errorEnum) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", errorEnum.getErrorCode());
        resultJson.put("msg", errorEnum.getErrorMsg());
        resultJson.put("info", new JSONObject());
        return resultJson;
    }

    /*返回正确请求信息和list*/
    public static JSONObject successList(final  List<JSONObject> list){
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", MsgConstant.SUCCESS_CODE);
        resultJson.put("msg", MsgConstant.SUCCESS_MSG);
        resultJson.put("info",list);
        return resultJson;
    }

    /**
     * 将request参数值转为json
     */
    public static JSONObject request2Json(HttpServletRequest request) {
        JSONObject requestJson = new JSONObject();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] pv = request.getParameterValues(paramName);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pv.length; i++) {
                if (pv[i].length() > 0) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(pv[i]);
                }
            }
            requestJson.put(paramName, sb.toString());
        }
        return requestJson;
    }

}
