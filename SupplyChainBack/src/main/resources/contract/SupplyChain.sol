pragma solidity ^0.4.4;

contract SupplyChain{
    struct Account{
        string userNo;
        string name;
        string userType;    //c=coreEnterpise,e=enterpise
        uint token;
        bool exist;
    }
    
    struct ContractInfo{
        string partyA;
        string hash;
        string time;
        int    state;   //0=unsigned,1=signed,2=cancel
        string partyB;
        bool exist;
    }
    
    struct formInfo{
        string formNo;
        string hash;
        string time;
    }
    
    formInfo[] formInfos;   //formList
    
    
    address public bank;    //bank is deployer
    mapping(string => Account)accountsMap;
    mapping(string => ContractInfo)contractsMap;
    
    event creditUserinfo(string info);
    event createUserinfo(string info);
    event payinfo(string info);
    event exchangeinfo(string info);
    
    
    
    function SupplyChain(){
        bank = msg.sender;
    }
    
    function getDeployAddr() public returns(address){
        return bank;
    }
    
   function credit(string userNo,string name,uint bal)public returns(bool){
       
        if (accountsMap[userNo].exist) {
            creditUserinfo("already exist!");
            return false;
        }
        if(msg.sender != bank){
            creditUserinfo("have no permisssion!");
            return false;
        }
        else
        {
            accountsMap[userNo] = Account(userNo,name,"e",bal,true);
            creditUserinfo("success");
            return true;
        }
   }
   
   function createUser(string userNo,string name)public returns(bool){
        if (accountsMap[userNo].exist) {
            createUserinfo("already exist!");
            return false;
        }
        accountsMap[userNo].userNo = userNo;
            accountsMap[userNo].name = name;
            accountsMap[userNo].userType = "e";
            accountsMap[userNo].token = 0;
            accountsMap[userNo].exist = true;
            createUserinfo("success");
            return true;
   }
   
   function pay(string payerUserNo,string payeeUserNo,uint amount)public returns(bool){
       if(accountsMap[payerUserNo].token < amount)
            {
                payinfo("token unenough");
                return false;
            }
        else
        {
            accountsMap[payerUserNo].token -= amount;
            accountsMap[payeeUserNo].token += amount;
            payinfo("success");
            return true;
        }
   }
   
   function exchange(string userNo, uint amount) public returns(bool){
       if(msg.sender != bank)
            {
                exchangeinfo("no enough permisssion");
                return false;
            }
       if(accountsMap[userNo].token < amount)
            {
                exchangeinfo("token unenough");
                return false;
            }
        else
        {
            exchangeinfo("success");
            accountsMap[userNo].token -= amount;
            return true;
        }
   }
   
   function getBalance(string userNo) public view returns(uint){
       return accountsMap[userNo].token;
   }
   
   function formInfoOnChain(string formNo,string hash,string time) public returns(bool){
       formInfos.push(formInfo(formNo,hash,time));
       return true;
   }
   
   function createContract(string partyA,string partyB,string hash,string time) public returns(bool){
       ContractInfo storage newcontract = contractsMap[hash];
       
       newcontract.partyA = partyA;
       newcontract.partyB = partyB;
       newcontract.time = time;
       newcontract.hash = hash;
       newcontract.exist = true;
       return true;
   }
   
   function changeContract(string hash,int s)public returns(bool){
       ContractInfo storage c = contractsMap[hash];
       if(!c.exist){
            return false;
       }
        contractsMap[hash].state = s;
        return true;
   }
   
   function getContractState(string hash)public view returns(int){
       return contractsMap[hash].state;
   }
   
   
}