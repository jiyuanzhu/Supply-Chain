<template>
  <div class="elback" :style="elback">
    <div id="eltop">
      <TopNav></TopNav>
    </div>
    <div id="elbody">
      <div id="elbody1">
        <p>企业管理子系统</p>
      </div>
      <div id="elbody2">
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
          <el-button @click="enterl" class="enterl">登录</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TopNav from '@/views/nav/TopNavLogin'
export default {
  name: 'EnterpriseLogin',
  components:{
    TopNav
  },
  data(){
    return{
      elback:{
        backgroundImage: "url(" + require("@/assets/enterprise.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
    }
  },
  methods:{
    enterl(){
      this.$store.state.leftNavState = 'Enterpise';
      this.$router.push({path:'/enterpise'})
    }
  }
}
</script>

<style>
.elback{
  height:690px;
  width:1500px;
  
}

#eltop{
  height:80px;
  width:1500px;
}

#elbody{
  height:600px;
  width:1500px;
  text-align: center;
}

#elbody1{
  margin:auto;
  height:70px;
  width:700px;
  font-family:"华文行楷"; 
  font-size:30px;
  text-align: center;
}

#elbody2{
  margin:auto;
  height:440px;
  width:400px;
}

#login{
  height:440px;
  width:400px;
  background-color: rgb(252, 247, 252);
  border-radius:30px;
  box-shadow: 1px #383737;
  text-align: center;
}

#logintitle{
  height:100px;
  width:400px;
  text-align: center;
  font-family:"华文行楷"; 
  font-size:30px;
  padding-top:2px;
}

#username{
  margin:auto;
  height:80px;
  width:250px;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

#password{
  margin:auto;
  height:80px;
  width:250px;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

.enterl{
  background-color: rgb(17, 212, 226);
  width:100px;
  height:45px;
  margin-top: 50px;
  font-family:"华文行楷"; 
  font-size:25px;
  text-align: center;
}
</style>
