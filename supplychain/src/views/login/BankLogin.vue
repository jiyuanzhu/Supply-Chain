<template>
  <div class="blback" :style="blback">
    <div id="bltop">
      <TopNav></TopNav>
    </div>
    <div id="blbody">
      <div id="blbody1">
        <p>银行管理子系统</p>
      </div>
      <div id="blbody2">
        <div id="login">
          <div id="logintitle">
            <p>登录</p>
          </div>
          <div id="username">
            <p class="usertext">用户名</p>
            <el-input type="text" class="userinput"></el-input>
          </div>
          <div id="password">
            <p class="passtext">密码</p>
            <el-input type="text" class="passinput"></el-input>
          </div>
          <el-button @click="bankl" class="bankl">登录</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TopNav from '@/views/nav/TopNavLogin'
export default {
  name: 'BankLogin',
  components:{
    TopNav
  },
  data(){
    return{
      blback:{
        backgroundImage: "url(" + require("@/assets/bank.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
    }
  },
  methods:{
    bankl(){
      this.$store.state.leftNavState = 'Bank';
      this.$router.push({path:'/bank'})
    }
  }
}
</script>

<style>
.blback{
  height:750px;
  width:100%;
  
}

#bltop{
  height:13%;
  width:100%;
}

#blbody{
  height:87%;
  width:100%;
  text-align: center;
}

#blbody1{
  margin:auto;
  height:12%;
  width:46%;
  font-family:"华文行楷"; 
  font-size:30px;
  text-align: center;
}

#blbody2{
  margin:auto;
  height:73%;
  width:27%;
}

#login{
  height:100%;
  width:100%;
  background-color: rgb(252, 247, 252);
  border-radius:30px;
  box-shadow: 1px #383737;
  text-align: center;
}

#logintitle{
  height:23%;
  width:100%;
  text-align: center;
  font-family:"华文行楷"; 
  font-size:30px;
  padding-top:2px;
}

#username{
  margin:auto;
  height:18%;
  width:62%;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

#password{
  margin:auto;
  height:18%;
  width:62%;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

.bankl{
  background-color: rgb(17, 212, 226);
  width:100px;
  height:45px;
  margin-top: 50px;
  font-family:"华文行楷"; 
  font-size:25px;
  text-align: center;
}
</style>
