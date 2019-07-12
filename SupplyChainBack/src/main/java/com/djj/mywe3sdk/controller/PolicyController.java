package com.djj.mywe3sdk.controller;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.constants.ErrorEnum;
import com.djj.mywe3sdk.service.PolicyService;
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
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    private String lastHash;
    private String lastPath;
    /*保单列表*/
    @GetMapping("/list")
    public JSONObject listPolicy(HttpServletRequest request){
        return policyService.listPolicy(CommonUtil.request2Json(request));
    }

    /*保单增加*/
    @PostMapping("/update")
    public JSONObject sendTrans(@RequestBody JSONObject requestJson){
        requestJson.put("url",lastPath);
        requestJson.put("md5",lastHash);
        return policyService.addPolicy(requestJson);
    }

    /*保单上传*/
    @PostMapping("/upload")
    public JSONObject uploadFileA(@RequestParam("file") MultipartFile file) throws Exception{
        String path = "D:\\SupplychainFile\\OrderFile\\Policy\\";
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
        hash.put("partyAHash", DigestUtils.md5Hex(new FileInputStream(re)));
        lastHash = DigestUtils.md5Hex(new FileInputStream(re));
        lastPath = re;
        return CommonUtil.successJson(hash);
    }


}
