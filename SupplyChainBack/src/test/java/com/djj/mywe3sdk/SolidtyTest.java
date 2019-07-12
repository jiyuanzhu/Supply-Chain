package com.djj.mywe3sdk;

import com.djj.mywe3sdk.temp.SupplyChain;
import com.djj.mywe3sdk.constants.GasConstants;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class SolidtyTest extends BaseTest{
    @Autowired
    private Web3j web3j;
    @Autowired
    private Credentials credentials;

    @Test
    public void SupplyTest() throws Exception{
        SupplyChain supplyChain = SupplyChain.deploy(web3j,credentials,new StaticGasProvider(GasConstants.GAS_PRICE,GasConstants.GAS_LIMIT)).send();

    }
}
