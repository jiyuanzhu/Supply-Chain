package com.djj.mywe3sdk.controller;



import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.constants.ErrorEnum;
import com.djj.mywe3sdk.service.PolicyService;
import com.djj.mywe3sdk.service.TransService;
import com.djj.mywe3sdk.util.CommonUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;

@CrossOrigin
@RestController
@RequestMapping("/trans")
public class TransController {

    @Autowired
    private TransService transService;


    private String lastHash;
    private String lastPath;

    /*物流表*/
    @GetMapping("/list")
    public JSONObject listTrans(HttpServletRequest request){
        return transService.listTrans(CommonUtil.request2Json(request));
    }

    /*增加物流*/
    @ResponseBody
    @PostMapping("/add")
    public JSONObject addTrans(@RequestBody JSONObject requestJson){
        requestJson.put("url",lastPath);
        requestJson.put("md5",lastHash);
        requestJson.put("state","-1");
        return transService.addTrans(requestJson);
    }


    /*改变物流状态*/
    @PostMapping("/update")
    public JSONObject sendTrans(@RequestBody JSONObject requestJson){
        return transService.changeTransState(requestJson);
    }

    /*上传文件*/
    @PostMapping("/upload")
    public JSONObject uploadFileB(@RequestParam("file") MultipartFile file) throws Exception{
        String path = "D:\\SupplychainFile\\OrderFile\\Trans\\";
        if(file == null)
        {
            System.out.println("文件为空");
            return CommonUtil.errorJson(ErrorEnum.E_3001);
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);

        String re = path + fileName;
        file.transferTo(new File(re));
        JSONObject hash = new JSONObject();
        hash.put("hash", DigestUtils.md5Hex(new FileInputStream(re)));
        lastHash = DigestUtils.md5Hex(new FileInputStream(re));
        lastPath = re;
        return CommonUtil.successJson();
    }
}
