package com.djj.mywe3sdk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.djj.mywe3sdk.constants.GasConstants;
import com.djj.mywe3sdk.contract.SupplyChain;
import com.djj.mywe3sdk.service.BlockChainService;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigInteger;

@Service
public class BlockChainServiceImpl implements BlockChainService{



    @Autowired
    private Web3j web3j;
    @Autowired
    private Credentials credentials;

    public SupplyChain bank;

    @PostConstruct
    public void init() throws Exception{
            bank = SupplyChain.deploy(
                    web3j,
                    credentials,
                    new StaticGasProvider(
                            GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
                    .send();
    }

    @Override
    public boolean creditOnChain(JSONObject jsonObject) {
        String userNo = jsonObject.getString("id");
        String name = jsonObject.getString("name");
        BigInteger a = new BigInteger(jsonObject.getString("amount"));
        try{
        System.out.println(bank.getCreditUserinfoEvents(bank.credit(userNo,name,a).send()));
        }catch (Exception e){
            System.out.println("credit fail!");
            return false;
        }
        return true;
    }

    @Override
    public boolean createOnChain(JSONObject jsonObject){
        String userNo = jsonObject.getString("id");
        String name = jsonObject.getString("name");
        try{
            System.out.println(bank.getCreateUserinfoEvents(bank.createUser(userNo,name).send()));
        }catch (Exception e){
            System.out.println("create fail!");
            return false;
        }
        return true;
    }

    @Override
    public boolean payOnChain(JSONObject jsonObject){
        String payer = jsonObject.getString("payer");
        String payee = jsonObject.getString("payee");
        BigInteger a = new BigInteger(jsonObject.getString("amount"));
        try{
            System.out.println(bank.getPayinfoEvents(bank.pay(payer,payee,a).send()));
        }catch (Exception e){
            System.out.println("pay fail!");
            return  false;
        }
        return true;
    }

    @Override
    public boolean exchangeOnChain(JSONObject jsonObject){
        String user = jsonObject.getString("id");
        BigInteger a = new BigInteger(jsonObject.getString("amount"));
        try {
            System.out.println(bank.getExchangeinfoEvents(bank.exchange(user,a).send()));
        }catch (Exception e){
            System.out.println("exchange fail!");
            return  false;
        }
        return true;
    }

    @Override
    public JSONObject balanceOnChain(JSONObject jsonObject){
        String user = jsonObject.getString("id");
        JSONObject result = new JSONObject();
        try{
            BigInteger i = bank.getBalance(user).send();
            System.out.println(i.toString());
            result.put("balance",i.intValue());
        }catch (Exception e){
            System.out.println("query fail!");
        }
        return result;
    }

    @Override
    public boolean orderInfoOnChain(JSONObject jsonObject){
        String no = jsonObject.getString("id");
        String ha = jsonObject.getString("hash");
        String time = jsonObject.getString("time");
        try{
            bank.formInfoOnChain(no,ha,time).send();
        }catch (Exception e){
            System.out.println("order on chain fail!");
            return  false;
        }
        return true;
    }

    @Override
    public boolean createContractOnChain(JSONObject jsonObject){
        String noA = jsonObject.getString("partyA");
        String noB = jsonObject.getString("partyB");
        String ha = jsonObject.getString("hasn");
        String t = jsonObject.getString("time");
        try {
            bank.createContract(noA,noB,ha,t).send();
        }catch (Exception e){
            System.out.println("create contract fail!");
            return  false;
        }
        return true;
    }

    @Override
    public boolean changeContractStateOnChain(JSONObject jsonObject){
        String ha = jsonObject.getString("hash");
        BigInteger state = new BigInteger(jsonObject.getString("state"));
        try{
            bank.changeContract(ha,state).send();
        }catch (Exception e){
            System.out.println("state change chain fail!");
            return  false;
        }
        return  true;
    }

    @Override
    public JSONObject stateContract(JSONObject jsonObject){
        String hash = jsonObject.getString("hash");
        JSONObject result = new JSONObject();
        try{
            BigInteger i = bank.getContractState(hash).send();
            System.out.println(i.toString());
            result.put("state",i.intValue());
        }catch (Exception e){
            System.out.println("query fail!");
        }
        return result;
    }

}
