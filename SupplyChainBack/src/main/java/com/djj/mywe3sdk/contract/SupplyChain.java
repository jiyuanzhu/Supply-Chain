package com.djj.mywe3sdk.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.request.BcosFilter;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class SupplyChain extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5033600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550611a1d806100616000396000f3006080604052600436106100af576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806311ef6085146100b45780633416ea27146101315780633a51d246146101bc5780634e8322601461023957806376cdb03b1461029057806387b162b5146102e7578063cf8d40d4146103ae578063d8260eab14610501578063e95efcdd1461060e578063e984c08714610699578063f621217e1461076a575b600080fd5b3480156100c057600080fd5b5061011b600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929050505061083b565b6040518082815260200191505060405180910390f35b34801561013d57600080fd5b506101a2600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001909291905050506108b3565b604051808215151515815260200191505060405180910390f35b3480156101c857600080fd5b50610223600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610b53565b6040518082815260200191505060405180910390f35b34801561024557600080fd5b5061024e610bcb565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561029c57600080fd5b506102a5610bf5565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156102f357600080fd5b50610394600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610c1b565b604051808215151515815260200191505060405180910390f35b3480156103ba57600080fd5b506104e7600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929050505061103b565b604051808215151515815260200191505060405180910390f35b34801561050d57600080fd5b506105f4600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611139565b604051808215151515815260200191505060405180910390f35b34801561061a57600080fd5b5061067f600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001909291905050506111e8565b604051808215151515815260200191505060405180910390f35b3480156106a557600080fd5b50610750600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001909291905050506112f8565b604051808215151515815260200191505060405180910390f35b34801561077657600080fd5b50610821600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190505050611677565b604051808215151515815260200191505060405180910390f35b60006003826040518082805190602001908083835b6020831015156108755780518252602082019150602081019050602083039250610850565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600301549050919050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561097d577f38804489c3a027bf1d61fbe9d298cedcb367417465f0c2c9c8c38f08f42463146040518080602001828103825260158152602001807f6e6f20656e6f756768207065726d69737373696f6e000000000000000000000081525060200191505060405180910390a160009050610b4d565b816002846040518082805190602001908083835b6020831015156109b65780518252602082019150602081019050602083039250610991565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600301541015610a64577f38804489c3a027bf1d61fbe9d298cedcb367417465f0c2c9c8c38f08f424631460405180806020018281038252600e8152602001807f746f6b656e20756e656e6f75676800000000000000000000000000000000000081525060200191505060405180910390a160009050610b4d565b7f38804489c3a027bf1d61fbe9d298cedcb367417465f0c2c9c8c38f08f42463146040518080602001828103825260078152602001807f737563636573730000000000000000000000000000000000000000000000000081525060200191505060405180910390a1816002846040518082805190602001908083835b602083101515610b055780518252602082019150602081019050602083039250610ae0565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160008282540392505081905550600190505b92915050565b60006002826040518082805190602001908083835b602083101515610b8d5780518252602082019150602081019050602083039250610b68565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600301549050919050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60006002836040518082805190602001908083835b602083101515610c555780518252602082019150602081019050602083039250610c30565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060040160009054906101000a900460ff1615610d0f577f58d6c76daf62d9f6818e55d9930c245c221989e7dc358e71756873566f6a40b560405180806020018281038252600e8152602001807f616c72656164792065786973742100000000000000000000000000000000000081525060200191505060405180910390a160009050611035565b826002846040518082805190602001908083835b602083101515610d485780518252602082019150602081019050602083039250610d23565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206000019080519060200190610d919291906118cc565b50816002846040518082805190602001908083835b602083101515610dcb5780518252602082019150602081019050602083039250610da6565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206001019080519060200190610e149291906118cc565b506040805190810160405280600181526020017f65000000000000000000000000000000000000000000000000000000000000008152506002846040518082805190602001908083835b602083101515610e835780518252602082019150602081019050602083039250610e5e565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206002019080519060200190610ecc9291906118cc565b5060006002846040518082805190602001908083835b602083101515610f075780518252602082019150602081019050602083039250610ee2565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206003018190555060016002846040518082805190602001908083835b602083101515610f7b5780518252602082019150602081019050602083039250610f56565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060040160006101000a81548160ff0219169083151502179055507f58d6c76daf62d9f6818e55d9930c245c221989e7dc358e71756873566f6a40b56040518080602001828103825260078152602001807f737563636573730000000000000000000000000000000000000000000000000081525060200191505060405180910390a1600190505b92915050565b6000806003846040518082805190602001908083835b6020831015156110765780518252602082019150602081019050602083039250611051565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390209050858160000190805190602001906110c39291906118cc565b50848160040190805190602001906110dc9291906118cc565b50828160020190805190602001906110f59291906118cc565b508381600101908051906020019061110e9291906118cc565b5060018160050160006101000a81548160ff0219169083151502179055506001915050949350505050565b6000806060604051908101604052808681526020018581526020018481525090806001815401808255809150509060018203906000526020600020906003020160009091929091909150600082015181600001908051906020019061119f92919061194c565b5060208201518160010190805190602001906111bc92919061194c565b5060408201518160020190805190602001906111d992919061194c565b50505050600190509392505050565b6000806003846040518082805190602001908083835b60208310151561122357805182526020820191506020810190506020830392506111fe565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902090508060050160009054906101000a900460ff16151561127957600091506112f1565b826003856040518082805190602001908083835b6020831015156112b2578051825260208201915060208101905060208303925061128d565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030181905550600191505b5092915050565b60006002846040518082805190602001908083835b602083101515611332578051825260208201915060208101905060208303925061130d565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060040160009054906101000a900460ff16156113ec577fbd8a2b77c52634ae7d2d3792a8793ff17e8f00615be493e36bc8a5ca3001ded660405180806020018281038252600e8152602001807f616c72656164792065786973742100000000000000000000000000000000000081525060200191505060405180910390a160009050611670565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156114b4577fbd8a2b77c52634ae7d2d3792a8793ff17e8f00615be493e36bc8a5ca3001ded66040518080602001828103825260148152602001807f68617665206e6f207065726d69737373696f6e2100000000000000000000000081525060200191505060405180910390a160009050611670565b60a0604051908101604052808581526020018481526020016040805190810160405280600181526020017f65000000000000000000000000000000000000000000000000000000000000008152508152602001838152602001600115158152506002856040518082805190602001908083835b60208310151561154c5780518252602082019150602081019050602083039250611527565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600082015181600001908051906020019061159b92919061194c565b5060208201518160010190805190602001906115b892919061194c565b5060408201518160020190805190602001906115d592919061194c565b506060820151816003015560808201518160040160006101000a81548160ff0219169083151502179055509050507fbd8a2b77c52634ae7d2d3792a8793ff17e8f00615be493e36bc8a5ca3001ded66040518080602001828103825260078152602001807f737563636573730000000000000000000000000000000000000000000000000081525060200191505060405180910390a1600190505b9392505050565b6000816002856040518082805190602001908083835b6020831015156116b2578051825260208201915060208101905060208303925061168d565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600301541015611760577f97da8b8ce2fa26e4907bec6b43daf318a7a22575e7e0c946fcc15404c4a9dfe760405180806020018281038252600e8152602001807f746f6b656e20756e656e6f75676800000000000000000000000000000000000081525060200191505060405180910390a1600090506118c5565b816002856040518082805190602001908083835b6020831015156117995780518252602082019150602081019050602083039250611774565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160008282540392505081905550816002846040518082805190602001908083835b60208310151561181557805182526020820191506020810190506020830392506117f0565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600301600082825401925050819055507f97da8b8ce2fa26e4907bec6b43daf318a7a22575e7e0c946fcc15404c4a9dfe76040518080602001828103825260078152602001807f737563636573730000000000000000000000000000000000000000000000000081525060200191505060405180910390a1600190505b9392505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061190d57805160ff191683800117855561193b565b8280016001018555821561193b579182015b8281111561193a57825182559160200191906001019061191f565b5b50905061194891906119cc565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061198d57805160ff19168380011785556119bb565b828001600101855582156119bb579182015b828111156119ba57825182559160200191906001019061199f565b5b5090506119c891906119cc565b5090565b6119ee91905b808211156119ea5760008160009055506001016119d2565b5090565b905600a165627a7a72305820c9036ced330fad13e2b891f0d1ab497c2c4674efb9c13abc78e036fa7ca3a1d20029";

    public static final String FUNC_GETCONTRACTSTATE = "getContractState";

    public static final String FUNC_EXCHANGE = "exchange";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_GETDEPLOYADDR = "getDeployAddr";

    public static final String FUNC_BANK = "bank";

    public static final String FUNC_CREATEUSER = "createUser";

    public static final String FUNC_CREATECONTRACT = "createContract";

    public static final String FUNC_FORMINFOONCHAIN = "formInfoOnChain";

    public static final String FUNC_CHANGECONTRACT = "changeContract";

    public static final String FUNC_CREDIT = "credit";

    public static final String FUNC_PAY = "pay";

    public static final Event CREDITUSERINFO_EVENT = new Event("creditUserinfo", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event CREATEUSERINFO_EVENT = new Event("createUserinfo", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event PAYINFO_EVENT = new Event("payinfo", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event EXCHANGEINFO_EVENT = new Event("exchangeinfo", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getContractState(String hash) {
        final Function function = new Function(FUNC_GETCONTRACTSTATE, 
                Arrays.<Type>asList(new Utf8String(hash)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> exchange(String userNo, BigInteger amount) {
        final Function function = new Function(
                FUNC_EXCHANGE, 
                Arrays.<Type>asList(new Utf8String(userNo),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void exchange(String userNo, BigInteger amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_EXCHANGE, 
                Arrays.<Type>asList(new Utf8String(userNo),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<BigInteger> getBalance(String userNo) {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(new Utf8String(userNo)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> getDeployAddr() {
        final Function function = new Function(
                FUNC_GETDEPLOYADDR, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void getDeployAddr(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GETDEPLOYADDR, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<String> bank() {
        final Function function = new Function(FUNC_BANK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createUser(String userNo, String name) {
        final Function function = new Function(
                FUNC_CREATEUSER, 
                Arrays.<Type>asList(new Utf8String(userNo),
                new Utf8String(name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void createUser(String userNo, String name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATEUSER, 
                Arrays.<Type>asList(new Utf8String(userNo),
                new Utf8String(name)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> createContract(String partyA, String partyB, String hash, String time) {
        final Function function = new Function(
                FUNC_CREATECONTRACT, 
                Arrays.<Type>asList(new Utf8String(partyA),
                new Utf8String(partyB),
                new Utf8String(hash),
                new Utf8String(time)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void createContract(String partyA, String partyB, String hash, String time, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATECONTRACT, 
                Arrays.<Type>asList(new Utf8String(partyA),
                new Utf8String(partyB),
                new Utf8String(hash),
                new Utf8String(time)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> formInfoOnChain(String formNo, String hash, String time) {
        final Function function = new Function(
                FUNC_FORMINFOONCHAIN, 
                Arrays.<Type>asList(new Utf8String(formNo),
                new Utf8String(hash),
                new Utf8String(time)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void formInfoOnChain(String formNo, String hash, String time, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_FORMINFOONCHAIN, 
                Arrays.<Type>asList(new Utf8String(formNo),
                new Utf8String(hash),
                new Utf8String(time)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> changeContract(String hash, BigInteger s) {
        final Function function = new Function(
                FUNC_CHANGECONTRACT, 
                Arrays.<Type>asList(new Utf8String(hash),
                new Int256(s)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void changeContract(String hash, BigInteger s, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CHANGECONTRACT, 
                Arrays.<Type>asList(new Utf8String(hash),
                new Int256(s)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> credit(String userNo, String name, BigInteger bal) {
        final Function function = new Function(
                FUNC_CREDIT, 
                Arrays.<Type>asList(new Utf8String(userNo),
                new Utf8String(name),
                new Uint256(bal)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void credit(String userNo, String name, BigInteger bal, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREDIT, 
                Arrays.<Type>asList(new Utf8String(userNo),
                new Utf8String(name),
                new Uint256(bal)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> pay(String payerUserNo, String payeeUserNo, BigInteger amount) {
        final Function function = new Function(
                FUNC_PAY, 
                Arrays.<Type>asList(new Utf8String(payerUserNo),
                new Utf8String(payeeUserNo),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void pay(String payerUserNo, String payeeUserNo, BigInteger amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_PAY, 
                Arrays.<Type>asList(new Utf8String(payerUserNo),
                new Utf8String(payeeUserNo),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public List<CreditUserinfoEventResponse> getCreditUserinfoEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(CREDITUSERINFO_EVENT, transactionReceipt);
        ArrayList<CreditUserinfoEventResponse> responses = new ArrayList<CreditUserinfoEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            CreditUserinfoEventResponse typedResponse = new CreditUserinfoEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.info = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CreditUserinfoEventResponse> creditUserinfoEventFlowable(BcosFilter filter) {
        return web3j.logFlowable(filter).map(new io.reactivex.functions.Function<Log, CreditUserinfoEventResponse>() {
            @Override
            public CreditUserinfoEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(CREDITUSERINFO_EVENT, log);
                CreditUserinfoEventResponse typedResponse = new CreditUserinfoEventResponse();
                typedResponse.log = log;
                typedResponse.info = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CreditUserinfoEventResponse> creditUserinfoEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        BcosFilter filter = new BcosFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CREDITUSERINFO_EVENT));
        return creditUserinfoEventFlowable(filter);
    }

    public List<CreateUserinfoEventResponse> getCreateUserinfoEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(CREATEUSERINFO_EVENT, transactionReceipt);
        ArrayList<CreateUserinfoEventResponse> responses = new ArrayList<CreateUserinfoEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            CreateUserinfoEventResponse typedResponse = new CreateUserinfoEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.info = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CreateUserinfoEventResponse> createUserinfoEventFlowable(BcosFilter filter) {
        return web3j.logFlowable(filter).map(new io.reactivex.functions.Function<Log, CreateUserinfoEventResponse>() {
            @Override
            public CreateUserinfoEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(CREATEUSERINFO_EVENT, log);
                CreateUserinfoEventResponse typedResponse = new CreateUserinfoEventResponse();
                typedResponse.log = log;
                typedResponse.info = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CreateUserinfoEventResponse> createUserinfoEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        BcosFilter filter = new BcosFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CREATEUSERINFO_EVENT));
        return createUserinfoEventFlowable(filter);
    }

    public List<PayinfoEventResponse> getPayinfoEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(PAYINFO_EVENT, transactionReceipt);
        ArrayList<PayinfoEventResponse> responses = new ArrayList<PayinfoEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            PayinfoEventResponse typedResponse = new PayinfoEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.info = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PayinfoEventResponse> payinfoEventFlowable(BcosFilter filter) {
        return web3j.logFlowable(filter).map(new io.reactivex.functions.Function<Log, PayinfoEventResponse>() {
            @Override
            public PayinfoEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(PAYINFO_EVENT, log);
                PayinfoEventResponse typedResponse = new PayinfoEventResponse();
                typedResponse.log = log;
                typedResponse.info = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PayinfoEventResponse> payinfoEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        BcosFilter filter = new BcosFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAYINFO_EVENT));
        return payinfoEventFlowable(filter);
    }

    public List<ExchangeinfoEventResponse> getExchangeinfoEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(EXCHANGEINFO_EVENT, transactionReceipt);
        ArrayList<ExchangeinfoEventResponse> responses = new ArrayList<ExchangeinfoEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ExchangeinfoEventResponse typedResponse = new ExchangeinfoEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.info = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExchangeinfoEventResponse> exchangeinfoEventFlowable(BcosFilter filter) {
        return web3j.logFlowable(filter).map(new io.reactivex.functions.Function<Log, ExchangeinfoEventResponse>() {
            @Override
            public ExchangeinfoEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(EXCHANGEINFO_EVENT, log);
                ExchangeinfoEventResponse typedResponse = new ExchangeinfoEventResponse();
                typedResponse.log = log;
                typedResponse.info = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExchangeinfoEventResponse> exchangeinfoEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        BcosFilter filter = new BcosFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXCHANGEINFO_EVENT));
        return exchangeinfoEventFlowable(filter);
    }

    @Deprecated
    public static SupplyChain load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChain(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SupplyChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChain(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SupplyChain load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SupplyChain(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SupplyChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SupplyChain(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SupplyChain> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<SupplyChain> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SupplyChain> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChain.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SupplyChain> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChain.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CreditUserinfoEventResponse {
        public Log log;

        public String info;
    }

    public static class CreateUserinfoEventResponse {
        public Log log;

        public String info;
    }

    public static class PayinfoEventResponse {
        public Log log;

        public String info;
    }

    public static class ExchangeinfoEventResponse {
        public Log log;

        public String info;
    }
}
