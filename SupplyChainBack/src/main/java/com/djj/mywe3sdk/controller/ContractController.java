package com.djj.mywe3sdk.controller;


import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.constants.ErrorEnum;
import com.djj.mywe3sdk.service.ContractService;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    private String lastHash;
    private String lastPath;

    /*查询合同列表*/
    @GetMapping("/list")
    public JSONObject listContract(HttpServletRequest request){
        return contractService.listContract(CommonUtil.request2Json(request));
    }

    /*查询未签合同列表*/
    @GetMapping("/unsignedList")
    public JSONObject listContractUnsigned(HttpServletRequest request){
        return contractService.listUnsignedContract(CommonUtil.request2Json(request));
    }

    /*文件上传到指定目录*/
    @PostMapping("/uploadA")
    public JSONObject uploadFileA(@RequestParam("file") MultipartFile file) throws Exception{
        String path = "D:\\SupplychainFile\\SupplyContractFile\\A\\";
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

    /*上传文件到B*/
    @PostMapping("/uploadB")
    public JSONObject uploadFileB(@RequestParam("file") MultipartFile file) throws Exception{
        String path = "D:\\SupplychainFile\\SupplyContractFile\\B\\";
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
        hash.put("partyBHash",DigestUtils.md5Hex(new FileInputStream(re)));
        lastHash = DigestUtils.md5Hex(new FileInputStream(re));
        lastPath = re;
        return CommonUtil.successJson(hash);
    }

    /*甲方上传新合同*/
    @PostMapping("/signedA")
    public JSONObject addContract(@RequestBody JSONObject requestJson){
        requestJson.put("url",lastPath);
        requestJson.put("md5",lastHash);
        requestJson.put("state","0");
        return(contractService.addContract(requestJson));
    }

    /*乙方签署或者取消合同*/
    @PostMapping("/signedB")
    public JSONObject signedContract(@RequestBody JSONObject requestJson){
        return(contractService.signedContract(requestJson));
    }
}
